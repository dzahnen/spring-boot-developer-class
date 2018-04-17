package io.pivotal.workshop.snippet.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.boot.actuate.metrics.CounterService;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class ApiInterceptor implements HandlerInterceptor {

	private final String SNIPPETS = "snippets";
	private final String CODES = "codes";
	
	private CounterService service;
	
	public ApiInterceptor(CounterService service){
		this.service = service;
	}
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		return true; // <-- Important set to TRUE!!
	}

	@Override
	public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
			ModelAndView modelAndView) throws Exception {
	}

	@Override
	public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
			throws Exception {
		
		if (request.getRequestURI().contains(SNIPPETS))
			this.service.increment(SNIPPETS);
		else if (request.getRequestURI().contains(CODES))
			this.service.increment(CODES);
	}

}
