package com.truegradient;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.ExchangeFilterFunction;
import org.springframework.web.reactive.function.client.WebClient;

import com.truegradient.config.WebClientStatusCodeHandler;

@SpringBootApplication
public class TgDataClientApplication {

	public static void main(String[] args) {
		SpringApplication.run(TgDataClientApplication.class, args);
	}

	@Bean
	public WebClient webClient() {
		ExchangeFilterFunction errorResponseFilter = ExchangeFilterFunction
				.ofResponseProcessor(WebClientStatusCodeHandler::exchangeFilterResponseProcessor);
		return WebClient.builder().filter(errorResponseFilter).build();
	}

}
