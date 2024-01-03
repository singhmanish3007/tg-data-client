package com.truegradient.controller;

import org.json.JSONObject;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.truegradient.client.GenericDataClient;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@RestController
@RequestMapping("/data")
@RequiredArgsConstructor
@Slf4j
public class GenericRestController {

	private final GenericDataClient genericDataClient;

	@ResponseStatus(value = HttpStatus.OK)

	@PostMapping(value = "/invoke", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<JSONObject> invokeGenericDataClient(
			@RequestParam(value = "url", required = true) String targetUrl, @RequestBody JSONObject inputData)
			throws Exception {

		return genericDataClient.invokePostAPI(targetUrl, inputData);

	}

}