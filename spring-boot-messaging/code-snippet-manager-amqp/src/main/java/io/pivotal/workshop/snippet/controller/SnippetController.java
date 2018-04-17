package io.pivotal.workshop.snippet.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import io.pivotal.workshop.snippet.repository.LanguageRepository;
import io.pivotal.workshop.snippet.repository.SnippetRepository;

@RestController
public class SnippetController {

	
	private SnippetRepository snippetRepository;
	private LanguageRepository languageRepository;
	private CounterService counter;
	
	public SnippetController(SnippetRepository snippetRepository,LanguageRepository languageRepository, CounterService counter){
		this.snippetRepository = snippetRepository;
		this.languageRepository = languageRepository;
		this.counter = counter;
	}
	
	@RequestMapping("/")
	public ModelAndView home(){
		counter.increment("homepage");
		
		assert snippetRepository != null;
		
		Map<String,Object> model = new HashMap<String,Object>();
		model.put("langs", languageRepository.findAll());
		model.put("snippets", snippetRepository.findAll());
		
		return new ModelAndView("views/home",model);
	}

}