package com.truegradient.client;

import org.json.JSONObject;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.BodyInserters;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.ResponseSpec;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
@RequiredArgsConstructor
public class GenericDataClient {

	private final WebClient webClient;
	private static final String SEPARATOR = "/";

	public ResponseEntity<String> invokePostAPI(String url, String jsonObject) throws Exception {
		ResponseSpec responseSpec = webClient.post().uri(url).contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON).body(BodyInserters.fromValue(jsonObject)).retrieve();

		try {
			return responseSpec.toEntity(String.class).toFuture().get();
		} catch (Exception e) {
			LOGGER.error("exception while calling {}", url, e);
			throw new RuntimeException("exception while calling " + url, e);
		}

	}

}
