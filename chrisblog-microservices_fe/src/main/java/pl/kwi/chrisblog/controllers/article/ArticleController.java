package pl.kwi.chrisblog.controllers.article;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import pl.kwi.chrisblog.commands.article.ArticleCommand;
import pl.kwi.chrisblog.controllers.abstr.AbstractController;
import pl.kwi.chrisblog.enums.TemplateEnum;
import pl.kwi.chrisblog.services.ArticleService;
import pl.kwi.chrisblog.utils.SessionUtils;

@Slf4j
@Controller
@RequestMapping(value="/article")
public class ArticleController extends AbstractController {
	
	
	@Autowired
	private ArticleService articleService;
	
	
	@RequestMapping(value = "/{articleId}", method = RequestMethod.GET)
	public String display(
			@ModelAttribute("command") ArticleCommand command,
			@PathVariable Long articleId,
			HttpSession session) {
		
		log.info("Article Id: {}", articleId);
		
		command.setArticle(articleService.findById(articleId).get());
		mapSessionToCommand(command, session);
		
		log.debug("Command class: {}", command);
		if (TemplateEnum.NONE.equals(command.getArticle().getTemplate())) {
			return "articles/article-" + String.valueOf(articleId);			
		} else {
			return "articles/templates/" + command.getArticle().getTemplate().getValue();
		}
		
	}
	
	@RequestMapping(value = "/back", method = RequestMethod.POST)
	public String submitBack(
			@ModelAttribute("command") ArticleCommand command,
			HttpSession session) {
		
		mapCommandToSession(command, session);		
		
		log.info("Command class: {}", command);
		return "redirect:/";
		
	}
	
	@RequestMapping(value = "/about", method = RequestMethod.POST)
	public String submitAbout(
			@ModelAttribute("command") ArticleCommand command,
			HttpSession session) {
		
		mapCommandToSession(command, session);		
		
		log.info("Command class: {}", command);
		return "redirect:/about";
		
	}
	
	private void mapSessionToCommand(ArticleCommand command, HttpSession session) {
		
		if (session.getAttribute("currentPage") == null) {
			return;
		}
		
		SessionUtils.mapSessionToCommand(command, session);
		
		
	}
	
	private void mapCommandToSession(ArticleCommand command, HttpSession session) {
		
		if (command.getCurrentPage() == 0) {
			return;
		}
		
		SessionUtils.mapCommandToSession(command, session);		
		
	}
	

}
