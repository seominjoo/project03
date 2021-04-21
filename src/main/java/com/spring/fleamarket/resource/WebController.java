package com.spring.fleamarket.resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {

	@GetMapping("/chat")
	public String getPage() {
		return "index";
	}
	
}
