package com.keyholesoftware.devops.simpleservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import io.jaegertracing.Configuration;
import io.opentracing.Tracer;

@SpringBootApplication
@EnableFeignClients
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public Tracer jaegerTracer() {
		// The following environment variables need to set
		// JAEGER_ENDPOINT="http://jaeger-collector.istio-system:14268/api/traces"
		// JAEGER_PROPAGATION="b3"
		// JAEGER_TRACEID_128BIT="true" Use 128bit tracer id to be compatible with the trace id generated by istio/envoy
		return Configuration.fromEnv("simple-springboot-tracing").getTracer();
	}
}
