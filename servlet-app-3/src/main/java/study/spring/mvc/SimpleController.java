package study.spring.mvc;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// DispatcherServlet에서 Handler를 찾을 HandlerMapping이
// RequestMappingHandlerMapping이 아니라, BeanNameHandlerMapping이다.
// 실행할 HandlerMapping 또한 다르다.
@org.springframework.stereotype.Controller("/simple")
public class SimpleController implements Controller {
	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) throws Exception {
		//WebConfig에 새로 등록한 InternalResourceViewResolver에서
		//prefix / suffix 를 새로 추가하였다
		//return new ModelAndView("/WEB-INF/simple.jsp");
		return new ModelAndView("/simple");

	}
}
