package study.spring.mvc;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.oxm.Marshaller;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.result.HeaderResultMatchers;

import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;
import java.io.StringWriter;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItems;
import static org.hamcrest.collection.IsIterableContainingInOrder.contains;
import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.head;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.options;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
//@WebMvcTest
class SampleControllerTest {

	@Autowired
	MockMvc mockMvc;

	@Autowired
	PersonRepository personRepository;

	@Autowired
	ObjectMapper objectMapper;

	@Autowired
	Marshaller marshaller;

	@Test
	public void helloTest() throws Exception {
		mockMvc.perform(get("/hello"))
				.andDo(print())
				.andExpect(status().isOk());
	}

	@Test
	void jsonMessage() throws Exception {
		Person person = new Person();
		person.setId(2019L);
		person.setName("younsoo");

		String jsonString = objectMapper.writeValueAsString(person);

		this.mockMvc.perform(get("/jsonMessage")
				.contentType(MediaType.APPLICATION_JSON)
				.accept(MediaType.APPLICATION_JSON)
				.content(jsonString))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(jsonPath("$.id").value(2019))
				.andExpect(jsonPath("$.name").value("younsoo"));

	}

	@Test
	void xmlMessage() throws Exception {
		Person person = new Person();
		person.setId(2019L);
		person.setName("younsoo");

		StringWriter stringWriter = new StringWriter();
		Result result = new StreamResult(stringWriter);
		marshaller.marshal(person, result);
		String xmlString = stringWriter.toString();

		this.mockMvc.perform(get("/xmlMessage")
				.contentType(MediaType.APPLICATION_XML)
				.accept(MediaType.APPLICATION_XML)
				.content(xmlString))
				.andDo(print())
				.andExpect(status().isOk())
				.andExpect(xpath("person/name").string("younsoo"))
				.andExpect(xpath("person/id").string("2019"));
	}

	@Test
	void hello() throws Exception {
		Person person = new Person();
		person.setName("younsoo");
		Person savedPerson = personRepository.save(person);
		this.mockMvc.perform(get("/hello").param("id",savedPerson.getId().toString()))
				.andExpect(content().string("hello younsoo"))
				.andDo(print());
	}

	@Test
	void helloStatic() throws Exception {
		this.mockMvc.perform(get("/mobile/index.html"))
				//.andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string(Matchers.containsString("Hello mobile")))
				.andExpect(header().exists(HttpHeaders.CACHE_CONTROL));
	}

	@Test
	void stringMessage() throws Exception {
		this.mockMvc.perform(get("/message")
				.content("hello"))
				 .andDo(print())
				.andExpect(status().isOk())
				.andExpect(content().string("hello"));
	}
}