package kr.ac.hansung.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Handles requests for the application home page.
 */
@Controller // @Component + ��Ʈ�ѷ� ����
public class HomeController {

	// http://localhost:8080/helloSpringMVC
	// �ش� url �� ���ؼ� home �޼ҵ尡 ���� / ����
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHome() {

		return "home"; // view's logical name
	}

}
