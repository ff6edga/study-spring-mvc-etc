package study.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@Autowired
	HelloService helloService;

	// Request를 아래 핸들러로 Dispatch 해주고
	// 아래 Annotation을 이해하며
	// 아래 Return 값을 Http Response로 만들어주는 주체
	// 그것은 바로 DispatcherServlet
	@GetMapping("/hello")
	public String hello() {
		return "HELLO, " + helloService.getName();
	}
}
