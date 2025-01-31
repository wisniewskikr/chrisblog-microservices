package pl.kwi.chrisblog.controllers.common;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController {

	private static final String EXCEPTION_ATTRIBUTE = "jakarta.servlet.error.exception";
	private static final String FORWARD_URI_ATTRIBUTE = "jakarta.servlet.forward.request_uri";
	private static final String STATUS_CODE_ATTRIBUTE = "jakarta.servlet.error.status_code";

	@RequestMapping(value="/error")
	public String handleErrors(HttpServletRequest request, Model model) {	
		
		Integer statusCode = (Integer) request.getAttribute(STATUS_CODE_ATTRIBUTE);	
			
		if(statusCode == HttpStatus.NOT_FOUND.value()) {
			
			log.error("404 Error. There is no such path: {}", request.getAttribute(FORWARD_URI_ATTRIBUTE));
			model.addAttribute("errorTitle", "404 - Page Not Found");
			model.addAttribute("errorText", "Page you are looking for might have been removed, had its name changed or is temporary unavailable.");
			
        } else {
        	
        	Exception exception = (Exception) request.getAttribute(EXCEPTION_ATTRIBUTE);
        	log.error("System Error.", exception);
    		model.addAttribute("errorTitle", "System Error");
    		model.addAttribute("errorText", "It seems that there is some problem with system. We will try to resolve it as soon as possible. Sorry for the inconvenience.");
    		
        }	    
		
		return "error/error";
		
	}
	
}