package com.codeconnect.controller;

import java.util.Locale;

import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	private MessageSource messageSource;

	public HelloWorld(MessageSource messageSource) {
		super();
		this.messageSource = messageSource;
	}
	@GetMapping("/greetings")
	public String greetingsfortheday() {
		Locale locale=LocaleContextHolder.getLocale();
		return messageSource.getMessage("good.moring.message",null,"DefaultMessage",locale);
	}
}
