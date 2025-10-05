package com.example.mcp.cep.server.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;

@Component
public class ConvertObjectToStringUtil {

    private static final ObjectMapper objectMapper = new ObjectMapper();

    public static String convert(Object obj) {
        try {
            return objectMapper.writeValueAsString(obj);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
