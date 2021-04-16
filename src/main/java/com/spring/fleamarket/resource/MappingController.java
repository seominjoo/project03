package com.spring.fleamarket.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MappingController {

	@GetMapping("/websocket")
	public String getMessage() {
		
		return "index";
	}
}
