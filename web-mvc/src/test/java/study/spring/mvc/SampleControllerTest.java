package study.spring.mvc;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

import static org.hamcrest.Matchers.notNullValue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@WebMvcTest
class SampleControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Test
	public void hello() throws Exception {
		ResultActions resultActions = mockMvc.perform(get("/events")
				.param("name", "younsoo")
				.param("limit", "-10"))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(model().hasErrors());
		ModelAndView mav = resultActions.andReturn().getModelAndView();
		Map<String, Object> model = mav.getModel();
		System.out.println(model.size());
	}

	@Test
	public void eventForm() throws Exception {
		MockHttpServletRequest request = mockMvc.perform(get("/events/form"))
				.andDo(print())
				.andExpect(view().name("/events/form"))
				.andExpect(model().attributeExists("event"))
				.andExpect(request().sessionAttribute("event", notNullValue()))
				.andReturn().getRequest();
		Event event = (Event) request.getSession().getAttribute("event");
		System.out.println(event);
	}
}