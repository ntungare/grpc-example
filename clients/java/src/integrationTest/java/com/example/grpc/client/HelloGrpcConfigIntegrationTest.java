package com.example.grpc.client;

import com.example.grpc.gen.HelloRequest;
import com.example.grpc.gen.HelloResponse;
import com.example.grpc.gen.HelloServiceGrpc;
import com.google.common.util.concurrent.ListenableFuture;
import io.grpc.StatusException;
import io.grpc.stub.StreamObserver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import static com.example.grpc.client.HelloGrpcConfig.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
public class HelloGrpcConfigIntegrationTest {

    @Configuration
    @EnableAutoConfiguration // This triggers the discovery of transitive libraries
    static class TestConfig { }

    @Autowired
    private ApplicationContext context;

    @Test
    void testStubBasic() throws ExecutionException, InterruptedException {
        assertTrue(context.containsBean(STUB_BASIC));
        final HelloServiceGrpc.HelloServiceStub helloServiceStub = context.getBean(STUB_BASIC, HelloServiceGrpc.HelloServiceStub.class);
        final HelloRequest helloRequest = HelloRequest.newBuilder()
                .setName("random")
                .build();
        final CompletableFuture<HelloResponse> helloResponseFuture = new CompletableFuture<>();
        final StreamObserver<HelloResponse> helloResponseStreamObserver = new StreamObserver<>() {
            @Override
            public void onNext(final HelloResponse value) {
                helloResponseFuture.complete(value);
            }

            @Override
            public void onError(final Throwable throwable) {
                helloResponseFuture.completeExceptionally(throwable);
            }

            @Override
            public void onCompleted() {
            }
        };
        helloServiceStub.sayHello(helloRequest, helloResponseStreamObserver);
        final HelloResponse helloResponse = helloResponseFuture.get();
        assertTrue(helloResponse.getMessage().contains("random"));
    }

    @Test
    void testStubBlocking() {
        assertTrue(context.containsBean(STUB_BLOCKING));
        final HelloServiceGrpc.HelloServiceBlockingStub helloServiceStub = context.getBean(STUB_BLOCKING, HelloServiceGrpc.HelloServiceBlockingStub.class);
        final HelloRequest helloRequest = HelloRequest.newBuilder()
                .setName("random")
                .build();
        final HelloResponse helloResponse = helloServiceStub.sayHello(helloRequest);
        assertTrue(helloResponse.getMessage().contains("random"));
    }

    @Test
    void testStubBlockingV2() throws StatusException {
        assertTrue(context.containsBean(STUB_BLOCKING_V2));
        final HelloServiceGrpc.HelloServiceBlockingV2Stub helloServiceStub = context.getBean(STUB_BLOCKING_V2, HelloServiceGrpc.HelloServiceBlockingV2Stub.class);
        final HelloRequest helloRequest = HelloRequest.newBuilder()
                .setName("random")
                .build();
        final HelloResponse helloResponse = helloServiceStub.sayHello(helloRequest);
        assertTrue(helloResponse.getMessage().contains("random"));
    }

    @Test
    void testStubFuture() throws ExecutionException, InterruptedException {
        assertTrue(context.containsBean(STUB_FUTURE));
        final HelloServiceGrpc.HelloServiceFutureStub helloServiceStub = context.getBean(STUB_FUTURE, HelloServiceGrpc.HelloServiceFutureStub.class);
        final HelloRequest helloRequest = HelloRequest.newBuilder()
                .setName("random")
                .build();
        final ListenableFuture<HelloResponse> helloResponseListenableFuture = helloServiceStub.sayHello(helloRequest);
        final HelloResponse helloResponse = helloResponseListenableFuture.get();
        assertTrue(helloResponse.getMessage().contains("random"));
    }

    @Test
    void testDefaultClient() throws StatusException {
        assertTrue(context.containsBean(DEFAULT_CLIENT));
        final HelloGrpcConfig.HelloServiceGrpcClient helloServiceGrpcClient = context.getBean(DEFAULT_CLIENT, HelloGrpcConfig.HelloServiceGrpcClient.class);
        final HelloRequest helloRequest = HelloRequest.newBuilder()
                .setName("random")
                .build();
        final HelloResponse helloResponse = helloServiceGrpcClient.callSayHello(helloRequest);
        assertTrue(helloResponse.getMessage().contains("random"));
    }


}
