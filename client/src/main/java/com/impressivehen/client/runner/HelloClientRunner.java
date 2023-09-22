package com.impressivehen.client.runner;


import com.impressivehen.hello.HelloRequest;
import com.impressivehen.hello.HelloResponse;
import com.impressivehen.hello.HelloServiceGrpc;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class HelloClientRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        //  ManagedChannel: channel abstracts the underlying details, like connection, connection pooling, load balancing, etc.
        ManagedChannel channel = ManagedChannelBuilder.forAddress("localhost", 8080)
                .usePlaintext()
                .build();

        /*
        The stub is the primary way for clients to interact with the server.
        using a blocking/synchronous stub the RPC call waits for the server to respond
         */
        HelloServiceGrpc.HelloServiceBlockingStub stub = HelloServiceGrpc.newBlockingStub(channel);

        HelloResponse helloResponse = stub.hello(HelloRequest.newBuilder()
                .setFirstName("Shawn")
                .setLastName("Hu")
                .build());

        log.info("helloResponse: {}", helloResponse);

        channel.shutdown();
    }
}
