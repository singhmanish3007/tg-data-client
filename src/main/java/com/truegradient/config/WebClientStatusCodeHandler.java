package com.truegradient.config;

import org.springframework.http.HttpStatusCode;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.ClientResponse;

import reactor.core.publisher.Mono;

@Component
public class WebClientStatusCodeHandler {

	public static Mono<ClientResponse> exchangeFilterResponseProcessor(ClientResponse response) {

		HttpStatusCode statusCode = response.statusCode();
		if (HttpStatus.valueOf(statusCode.toString()).is4xxClientError()
				|| HttpStatus.valueOf(statusCode.toString()).is5xxServerError()) {
			return response.bodyToMono(String.class).flatMap(body -> Mono.error(new Exception(body)));
		}

		return Mono.just(response);

	}

}
