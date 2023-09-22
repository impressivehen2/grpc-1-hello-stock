package com.impressivehen.server.service;

import com.impressivehen.hello.HelloRequest;
import com.impressivehen.hello.HelloResponse;
import com.impressivehen.hello.HelloServiceGrpc;
import io.grpc.stub.StreamObserver;

public class HelloServiceImpl extends HelloServiceGrpc.HelloServiceImplBase {

    /*
    Simple RPC

    StreamObserver: response observer, a call back for the server to call with its response.
    This way the client gets the option to make a blocking call or a non-blocking call.
     */
    @Override
    public void hello(HelloRequest request, StreamObserver<HelloResponse> responseObserver) {
        String greeting = new StringBuilder()
                .append("Hello, ")
                .append(request.getFirstName())
                .append(" ")
                .append(request.getLastName())
                .toString();

        HelloResponse response = HelloResponse.newBuilder()
                .setGreeting(greeting)
                .build();

        /*
        onNext() method to send response object to the client.
         */
        responseObserver.onNext(response);

        /*
        onCompleted() to specify that we’ve finished dealing with the RPC; otherwise, the connection will be hung,
        and the client will just wait for more information to come in.
         */
        responseObserver.onCompleted();
    }
}
