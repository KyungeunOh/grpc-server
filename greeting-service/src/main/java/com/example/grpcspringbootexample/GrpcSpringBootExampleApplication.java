package com.example.grpcspringbootexample;

import com.example.grpcspringbootexample.service.GreetingService;
import io.grpc.Server;
import io.grpc.ServerBuilder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;

@Slf4j
@SpringBootApplication
public class GrpcSpringBootExampleApplication /* implements ApplicationRunner */ {

	public static void main(String[] args) throws IOException, InterruptedException {
		SpringApplication.run(GrpcSpringBootExampleApplication.class, args);

		Server server = ServerBuilder
				.forPort(8888)
				.addService(new GreetingService())
				.build();

		server.start();
		server.awaitTermination();
	}

	/*
	Server grpcServer = ServerBuilder.forPort(9091)
			.addService(new GreetingService())
			.build();

	public void run(ApplicationArguments args) throws Exception {
		log.info("grpcServer is RESstarting");
		grpcServer.start();
	}

	 */

}
