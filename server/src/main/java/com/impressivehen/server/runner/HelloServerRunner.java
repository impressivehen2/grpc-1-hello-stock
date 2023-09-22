package com.impressivehen.server.runner;

import com.impressivehen.server.service.HelloServiceImpl;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class HelloServerRunner implements CommandLineRunner {

    @Override
    public void run(String... args) throws Exception {
        Server server = ServerBuilder
                .forPort(8080)
                .addService(new HelloServiceImpl()).build();

        server.start();
        server.awaitTermination();
    }
}