package com.example.demo;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;


@RestController
public class GreetingController {
    
    private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	private DataService dataService = new DataService();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@GetMapping("/test")
	public ArrayList<String> getWaterQualityData() throws IOException{

		return dataService.fetchData();
	}

	@PostMapping ("/add")
	public String writeNewData(){
		dataService.writeData();
		return "Data added";
	}
}
