package com.social.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandProperties;
import com.social.util.HttpUtils;
import feign.Feign;

import java.util.HashMap;
import java.util.Map;

public class GoogleCommand extends HystrixCommand<Integer> {

    public GoogleCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("GoogleCommand"))
                .andCommandPropertiesDefaults(HystrixCommandProperties.Setter()
                        .withExecutionTimeoutInMilliseconds(5000)));
    }

    @Override
    protected Integer run() throws Exception {
        HttpUtils httpUtils = Feign.builder()
                .decoder(new CustomDecoder(CustomDecoder.DecoderType.STATUS))
                .target(HttpUtils.class, "http://google.bg");

        Map<String, Object> query = new HashMap<>();
        query.put("#q", "deadpool");

        return httpUtils.dynamicGet(query);
    }

    @Override
    protected Integer getFallback() {
        return 404;
    }
}