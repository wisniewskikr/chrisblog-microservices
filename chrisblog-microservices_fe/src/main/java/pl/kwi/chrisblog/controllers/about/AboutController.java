package pl.kwi.chrisblog.controllers.about;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import pl.kwi.chrisblog.commands.about.AboutCommand;
import pl.kwi.chrisblog.utils.SessionUtils;

@Slf4j
@Controller
@RequestMapping(value="/about")
public class AboutController {

	@RequestMapping
	public String display(@ModelAttribute("command") AboutCommand command,
			HttpSession session) {
		
		mapSessionToCommand(command, session);
		
		log.info("Command class: {}", command);
		return "about/about";
		
	}
	
	@RequestMapping(value = "/back", method = RequestMethod.POST)
	public String submitBack(
			@ModelAttribute("command") AboutCommand command,
			HttpSession session) {
				
		if (command.getArticleId() == null) {
			log.info("Command class: {}", command);
			return "redirect:/";
		} else {
			SessionUtils.mapCommandToSession(command, session);			
			log.info("Command class: {}", command);
			return "redirect:/article/" + command.getArticleId();
		}		
		
	}
	
	private void mapSessionToCommand(AboutCommand command, HttpSession session) {
		
		if (session.getAttribute("currentPage") == null) {
			return;
		}
		
		SessionUtils.mapSessionToCommand(command, session);		
		
	}
	
}