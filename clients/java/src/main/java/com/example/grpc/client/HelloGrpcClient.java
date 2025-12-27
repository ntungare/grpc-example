package com.example.grpc.client;

import com.example.grpc.gen.HelloRequest;
import com.example.grpc.gen.HelloResponse;
import com.example.grpc.gen.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.StatusException;
import lombok.AllArgsConstructor;
import org.springframework.boot.autoconfigure.AutoConfiguration;
import org.springframework.context.annotation.Bean;

@AutoConfiguration
public class HelloGrpcClient {

    @Bean
    ManagedChannel helloChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 9090).usePlaintext().build();
    }

    @Bean
    HelloServiceGrpc.HelloServiceStub helloServiceStub(final ManagedChannel helloChannel) {
        return HelloServiceGrpc.newStub(helloChannel);
    }

    @Bean
    HelloServiceGrpc.HelloServiceBlockingStub helloServiceBlockingStub(final ManagedChannel helloChannel) {
        return HelloServiceGrpc.newBlockingStub(helloChannel);
    }

    @Bean
    HelloServiceGrpc.HelloServiceBlockingV2Stub helloServiceBlockingV2Stub(final ManagedChannel helloChannel) {
        return HelloServiceGrpc.newBlockingV2Stub(helloChannel);
    }

    @Bean
    HelloServiceGrpc.HelloServiceFutureStub helloServiceFutureStub(final ManagedChannel helloChannel) {
        return HelloServiceGrpc.newFutureStub(helloChannel);
    }

    @Bean
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
