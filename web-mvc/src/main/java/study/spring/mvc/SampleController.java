package study.spring.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("event")
public class SampleController {

	@GetMapping("/events/form")
	public String eventsForm(Model model, SessionStatus sessionStatus) {
		Event newEvent = new Event();
		newEvent.setLimit(10);
		model.addAttribute("event", new Event());
		sessionStatus.setComplete();
		return "/events/form";
	}

	@PostMapping("/events")
	public String createEvent(@Validated @ModelAttribute Event event,
			BindingResult bindingResult,
			Model model) {
		if (bindingResult.hasErrors()) {
			return "/events/form";
		}

		List<Event> eventList = new ArrayList<>();
		eventList.add(event);
		model.addAttribute(eventList);

		return "redirect:/events/list";
	}

	@GetMapping("/events/list")
	public String getEvents(Model model) {
		Event event = new Event();
		event.setName("spring");
		event.setLimit(10);

		List<Event> eventList = new ArrayList<>();
		eventList.add(event);

		model.addAttribute(eventList);

		return "/events/list";
	}


}
