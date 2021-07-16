package it.epicode.web.mvc.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class BaseController {

	 public ForwOrRedir getMissingPage(HttpServletRequest request, HttpServletResponse response) {
   	  return new ForwOrRedir(false,"missingPage.jsp");
     }

	public ForwOrRedir getHomePage() {
	  return new ForwOrRedir(false,"http://localhost:8080/TestEpicode5/");
	}
	
}
