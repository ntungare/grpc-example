package com.example.grpc.client;

import com.example.grpc.gen.HelloRequest;
import com.example.grpc.gen.HelloResponse;
import com.example.grpc.gen.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.StatusException;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.grpc.client.CompositeGrpcChannelFactory;

@AutoConfiguration
public class HelloGrpcConfig {

    protected static final String PREFIX = "hello.";

    protected static final String CHANNEL = PREFIX + "channel";

    @Bean(CHANNEL)
    ManagedChannel helloChannel(final CompositeGrpcChannelFactory grpcChannelFactory) {
        return grpcChannelFactory.createChannel("localhost:9090");
    }

    protected static final String STUB_BASIC = PREFIX + "stub_basic";

    @Bean(STUB_BASIC)
    HelloServiceGrpc.HelloServiceStub helloServiceStub(@Qualifier(CHANNEL) final ManagedChannel helloChannel) {
        return HelloServiceGrpc.newStub(helloChannel);
    }

    protected static final String STUB_BLOCKING = PREFIX + "stub_blocking";

    @Bean(STUB_BLOCKING)
    HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub(final ManagedChannel helloChannel) {
        return HelloServiceGrpc.newBlockingStub(helloChannel);
    }

    protected static final String STUB_BLOCKING_V2 = PREFIX + "stub_blocking_v2";

    @Bean(STUB_BLOCKING_V2)
    HelloServiceGrpc.HelloServiceBlockingV2Stub helloServiceBlockingV2Stub(final ManagedChannel helloChannel) {
        return HelloServiceGrpc.newBlockingV2Stub(helloChannel);
    }

    protected static final String STUB_FUTURE = PREFIX + "stub_future";

    @Bean(STUB_FUTURE)
    HelloServiceGrpc.HelloServiceFutureStub helloServiceFutureStub(final ManagedChannel helloChannel) {
        return HelloServiceGrpc.newFutureStub(helloChannel);
    }

    protected static final String DEFAULT_CLIENT = PREFIX + "default_client";

    @Bean(DEFAULT_CLIENT)
    public HelloServiceGrpcClient helloServiceGrpcClient(
            final HelloServiceGrpc.HelloServiceBlockingV2Stub helloServiceBlockingV2Stub) {
        return new HelloServiceGrpcClient(helloServiceBlockingV2Stub);
    }

    @AllArgsConstructor
    public static final class HelloServiceGrpcClient {
        private final HelloServiceGrpc.HelloServiceBlockingV2Stub helloServiceBlockingV2Stub;

        public HelloResponse callSayHello(final HelloRequest helloRequest) throws StatusException {
            return helloServiceBlockingV2Stub.sayHello(helloRequest);
        }
    }
}
