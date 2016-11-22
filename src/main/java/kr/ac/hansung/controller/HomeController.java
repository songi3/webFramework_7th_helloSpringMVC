package kr.ac.hansung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller // @Component + 컨트롤러 역할
public class HomeController {

	// http://localhost:8080/helloSpringMVC
	// 해당 url 에 대해서 home 메소드가 맵핑 / 수행
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome() {

		return "home"; // view's logical name
	}

}
