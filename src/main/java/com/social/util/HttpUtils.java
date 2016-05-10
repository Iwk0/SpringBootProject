package com.social.util;

import feign.QueryMap;
import feign.RequestLine;

import java.util.Map;

public interface HttpUtils {

    @RequestLine(value = "GET /")
    int dynamicGet(@QueryMap Map<String, Object> queryMap);
}