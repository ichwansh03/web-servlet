package com.ichwan.servlet.util;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Getter;

public class JsonUtil {

    @Getter
    private static final ObjectMapper mapper = new ObjectMapper();

}
