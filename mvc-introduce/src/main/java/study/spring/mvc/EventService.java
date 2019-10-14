package study.spring.mvc;

import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;
import org.thymeleaf.expression.Lists;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class EventService {

	public List<Event> getEvents() {
		List<Event> list = new ArrayList<>();
		Event event1 = Event.builder()
				.name("스프링 웹 MVC 스터디 1차")
				.limitOfEnrollment(5)
				.startDateTime(LocalDateTime.of(2019,1,11,1,1))
				.endDateTime(LocalDateTime.of(2019, 1, 12, 1, 1))
				.build();
		list.add(event1);
		Event event2 = Event.builder()
				.name("스프링 웹 MVC 스터디 2차")
				.limitOfEnrollment(5)
				.startDateTime(LocalDateTime.of(2019,2,11,1,1))
				.endDateTime(LocalDateTime.of(2019, 3, 12, 1, 1))
				.build();
		list.add(event2);
		return list;
	}
}
