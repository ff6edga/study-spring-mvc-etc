package study.spring.mvc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class EventController {

	@Autowired
	EventService eventService;
	//@RequestMapping(value = "/events", method = RequestMethod.GET)
	//Spring 4.3부터는 아래와 같이 줄여 쓸 수 있다. (Security 이슈때문에라도 이 버전을 쓰자.)
	//check URL : localhost:8080/events
	@GetMapping("/events")
	public String events(Model model) {
		model.addAttribute("events", eventService.getEvents());
		return "events/list"; // 뷰 네임 (default path : /resources/templates)
	}
}
