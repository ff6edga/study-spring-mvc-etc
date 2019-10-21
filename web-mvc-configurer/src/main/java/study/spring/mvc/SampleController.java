package study.spring.mvc;

import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

@RestController
public class SampleController {

	//@GetMapping(value = "/hello")
	@GetHelloMapping
	public String hello() {
		return "hello";
	}

	@PostMapping(value = "/hello")
	public String helloPost() {
		return "hello";
	}

	@GetMapping("/message")
	public String message(@RequestBody String body) {
		return body;
	}

	@GetMapping("/xmlMessage")
	public Person jsonMessage(@RequestBody Person person) {
		return person;
	}
}
