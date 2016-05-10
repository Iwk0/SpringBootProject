package com.social.command;

import feign.FeignException;
import feign.Response;
import feign.codec.Decoder;
import lombok.extern.log4j.Log4j;
import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.lang.reflect.Type;

@Log4j
public class CustomDecoder implements Decoder {

    private DecoderType decoderType;

    public CustomDecoder(DecoderType decoderType) {
        this.decoderType = decoderType;
    }

    @Override
    public Object decode(Response response, Type type) throws IOException, FeignException {
        switch (decoderType) {
            case STATUS:
                log.info("return type: status");
                return response.status();
            case JSON:
                log.info("return type: json");
                return IOUtils.toString(response.body().asInputStream());
            default:
                log.info("no selected type");
                return "";
        }
    }

    public enum DecoderType {
        STATUS, JSON
    }
}