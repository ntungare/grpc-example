package com.example.grpc.client;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import static com.example.grpc.client.HelloGrpcConfig.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class TestHelloGrpcConfig {

    @Configuration
    @EnableAutoConfiguration // This triggers the discovery of transitive libraries
    static class TestConfig { }

    @Autowired
    private ApplicationContext context;

    @Test
    void allBeansExist() {
        assertTrue(context.containsBean(CHANNEL));
        assertTrue(context.containsBean(STUB_BASIC));
        assertTrue(context.containsBean(STUB_BLOCKING));
        assertTrue(context.containsBean(STUB_BLOCKING_V2));
        assertTrue(context.containsBean(STUB_FUTURE));
        assertTrue(context.containsBean(DEFAULT_CLIENT));
    }
}
