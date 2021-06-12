package com.rest.webservices.restfulwebservices;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.rest.webservices.model.Employee;


@RestController
public class HelloWorldController {
	
	@Autowired
	MessageSource messageSource;
	
	@RequestMapping(method=RequestMethod.GET,path="/hello")
	public String helloWorld() {
		final String uri = "https://mocki.io/v1/d4867d8b-b5d5-4a48-a4ab-79131b5809b8";

	    RestTemplate restTemplate = new RestTemplate();
	    String result = restTemplate.getForObject(uri, String.class);
	    System.out.println(result);
		return result;
	}
	
	@GetMapping(path="/employeeBean")
	public Employee employeeBean() {
		return new Employee("Hello World");
	}
	
	@RequestMapping(method=RequestMethod.GET,path="/getPathVar/{name}")
	public Employee employeePathVariable(@PathVariable String name) {
		return new Employee("Hello World,"+name);
	}
	
	
	@GetMapping(path="/internationalization-demo")
	public String  saluteMessage(@RequestHeader(name="Accept-Language",required=false) Locale locale) {
		return messageSource.getMessage("good.morning.message",null,locale);
	}
	
	@GetMapping(path="/internationalization-demo2")
	public String  saluteMessage2() {
		return messageSource.getMessage("good.morning.message",null,LocaleContextHolder.getLocale());
	}

}
