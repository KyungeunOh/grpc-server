package com.example.grpcspringbootexample.service;

import com.example.grpc.*;
import io.grpc.stub.StreamObserver;
import net.devh.boot.grpc.server.service.GrpcService;

@GrpcService
public class GreetingService extends GreetingServiceGrpc.GreetingServiceImplBase {
    @Override
    public void greeting(GreetingRequest request, StreamObserver<GreetingResponse> responseObserver) {
        String message = request.getMessage();
        System.out.println("Received Message: " + message);


        GreetingResponse greetingResponse = GreetingResponse.newBuilder()
                .setMessage("Received your " + message + ". Hello From Server. ")
                .build();

        responseObserver.onNext(greetingResponse);
        responseObserver.onCompleted();
    }
}