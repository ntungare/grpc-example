package com.example.grpc.handlers;

import com.example.grpc.gen.HelloRequest;
import com.example.grpc.gen.HelloResponse;
import com.example.grpc.gen.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;
import org.springframework.grpc.server.service.GrpcService;

@GrpcService
public class HelloService extends HelloServiceGrpc.HelloServiceImplBase {

    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {

        // Build response
        final HelloResponse response = HelloResponse.newBuilder()
                .setMessage("Hello, " + request.getName() + "!")
                .build();

        // Send response
        responseObserver.onNext(response);
        responseObserver.onCompleted();
    }
}
