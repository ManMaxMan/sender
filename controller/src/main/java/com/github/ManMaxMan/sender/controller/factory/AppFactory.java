package com.github.ManMaxMan.sender.controller.factory;

import com.fasterxml.jackson.databind.ObjectMapper;

public class AppFactory {

    private final static ObjectMapper mapper = new ObjectMapper();

    public static ObjectMapper getMapper() {
        return mapper;
    }

}
