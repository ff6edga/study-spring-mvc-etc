package study.spring.mvc;

import javafx.application.Application;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.WebApplicationContext;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class HelloServlet extends HttpServlet {
	@Override
	public void init() throws ServletException {
		System.out.println("init servlet");
	}


	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		System.out.println("doGet called at servlet");
		//ContextLoaderListner의 구현코드를 보면 ApplicationContext를 생성하고 아래 이름으로 애트리뷰트로 저장하는 코드를 확인가능하다.
		ApplicationContext context = (ApplicationContext) getServletContext()
				.getAttribute(WebApplicationContext.ROOT_WEB_APPLICATION_CONTEXT_ATTRIBUTE);

		HelloService helloService = context.getBean(HelloService.class);

		resp.getWriter().println("<html>");
		resp.getWriter().println("<head>");
		resp.getWriter().println("<body>");
		resp.getWriter().println("<h1>Hello " + helloService.getName() + "</hi>");
		resp.getWriter().println("</body>");
		resp.getWriter().println("</head>");
		resp.getWriter().println("</html>");
	}

//	private Object getName() {
//		return getServletContext().getAttribute("name");
//	}

	@Override
	public void destroy() {
		System.out.println("destroy servlet");
	}

}
