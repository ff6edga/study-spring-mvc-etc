package study.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//그냥 Controller를 쓴다면, Handler별로 @ResponseBody를 붙여줘야 한다.
@RestController
public class HelloController {
	@Autowired
	HelloService helloService;

	@GetMapping("/hello")
	public String hello() {
		return "Hello, " + helloService.getName();
	}
}
