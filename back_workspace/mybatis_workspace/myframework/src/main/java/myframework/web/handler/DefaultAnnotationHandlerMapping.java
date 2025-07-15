package myframework.web.handler;

import com.google.gson.JsonObject;

import myframework.web.servlet.Controller;

public class DefaultAnnotationHandlerMapping implements HandlerMapping {
	@Override
	public void setRoot(JsonObject root) {
		
	}
	
	@Override
	public void initialize() {
		
	}
	
	@Override
	public Controller getController(String uri) {
		return null;
	}
}
