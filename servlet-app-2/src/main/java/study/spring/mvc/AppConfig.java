package study.spring.mvc;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Controller;

@Configuration
// Controller 빈을 등록하지 않겠다 - Root WebApplicationContext에 Controller 빈은 등록 안 하겠다.
@ComponentScan(excludeFilters = @ComponentScan.Filter(Controller.class))
public class AppConfig  {
}
