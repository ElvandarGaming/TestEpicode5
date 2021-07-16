package it.epicode.web.mvc.controller;

public class ForwOrRedir {

	private boolean forward;
	private String url;
		
	public ForwOrRedir(boolean forward, String url) {
		this.forward = forward;
		this.url = url;
	}
	public boolean isForward() {
		return forward;
	}
	public String getUrl() {
		return url;
	}
	
	
	
}
