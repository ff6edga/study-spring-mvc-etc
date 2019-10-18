package study.spring.mvc;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class SampleController {

	@GetMapping(value = "/hello",
			consumes = "!" + MediaType.APPLICATION_JSON_VALUE
	)
	@ResponseBody
	public String hello() {
		return "hello";
	}
}
