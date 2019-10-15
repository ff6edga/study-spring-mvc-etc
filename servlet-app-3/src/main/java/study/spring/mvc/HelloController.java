package study.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

//@Controller를 쓴다면, Handler별로 @ResponseBody를 붙여줘야 한다.
//@RestController
@Controller
public class HelloController {
	@Autowired
	HelloService helloService;

	@GetMapping("/hello")
	@ResponseBody // 뷰 생성하지 않는다. (내부적으로 ModelAndView = null)
	public String hello() {
		return "Hello, " + helloService.getName();
	}

	@GetMapping("/sample")
	public String sample() {
		// 아래 이름의 뷰를 찾고 생성한다.
		return "/WEB-INF/sample.jsp";
	}
}
