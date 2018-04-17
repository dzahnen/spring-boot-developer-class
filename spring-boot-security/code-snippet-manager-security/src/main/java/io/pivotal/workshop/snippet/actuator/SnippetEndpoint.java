package io.pivotal.workshop.snippet.actuator;

import org.springframework.boot.actuate.endpoint.Endpoint;
import org.springframework.boot.actuate.endpoint.MetricsEndpoint;
import org.springframework.stereotype.Component;

@Component
public class SnippetEndpoint implements Endpoint<SnippetMetric> {

	private MetricsEndpoint metrics;
	
	public SnippetEndpoint(MetricsEndpoint metrics){
		this.metrics = metrics;
	}
	
	@Override
	public String getId() {
		return "snippet-metric";
	}
	
	@Override
	public SnippetMetric invoke() {	
		Object obj = this.metrics.invoke().get("counter.snippets");
		
		Integer get = 0;
		try {
			get = Integer.parseInt(obj.toString());
		}catch(Exception ex){
			get = 0;
		}
		return new SnippetMetric(get,0,0,0);
	}
	

	/*
	
	private Random random = new Random();
	
	@Override
	public SnippetMetric invoke() {		
		return new SnippetMetric(random.nextInt(100),random.nextInt(100),random.nextInt(100),random.nextInt(100));
	}
	*/

	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public boolean isSensitive() {
		return false;
	}

}
