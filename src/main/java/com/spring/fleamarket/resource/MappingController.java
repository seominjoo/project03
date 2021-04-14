package com.spring.fleamarket.resource;

import org.springframework.web.bind.annotation.GetMapping;

public class MappingController {

	@GetMapping("/websocket-example")
	public String getMessage() {
		return "/index";
	}
}
