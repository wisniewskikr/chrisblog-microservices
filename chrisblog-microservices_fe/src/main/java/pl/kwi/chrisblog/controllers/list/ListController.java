package pl.kwi.chrisblog.controllers.list;

import java.util.Arrays;

import jakarta.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import lombok.extern.slf4j.Slf4j;
import pl.kwi.chrisblog.commands.list.ListCommand;
import pl.kwi.chrisblog.controllers.abstr.AbstrPaginationController;
import pl.kwi.chrisblog.enums.SortingEnum;
import pl.kwi.chrisblog.services.ArticleService;
import pl.kwi.chrisblog.services.CategoryService;
import pl.kwi.chrisblog.services.TagService;
import pl.kwi.chrisblog.utils.SessionUtils;


@Slf4j
@Controller
@RequestMapping(value="/")
public class ListController extends AbstrPaginationController {
	
	
	public static final String HOME = "home";

	@Autowired
	private CategoryService categoryService;
	
	@Autowired
	private ArticleService articleService;
	
	@Autowired
	private TagService tagService;
	
	@ModelAttribute
	public void addAttributes(Model model) {
	    model.addAttribute("categories", categoryService.findAll());
	    model.addAttribute("sorting", Arrays.asList(SortingEnum.values()));	    
	}
	
	@Value(value = "${articles.on.page}")
    private int articlesOnPage;
	@Value(value = "${pagination.items.on.page}")
    private int paginationItemsOnPage;

	
	@RequestMapping(method = RequestMethod.GET)
	public String init(
			@ModelAttribute("command") ListCommand command,
			HttpSession session) {
		
		mapSessionToCommand(command, session);
		handleList(command);
		
		log.info("Command class: {}", command );
		return "list/list";
		
	}	
	
	@RequestMapping(method = RequestMethod.POST)
	public String display(
			@ModelAttribute("command") ListCommand command) {
		
		handleList(command);
		
		log.info("Command class: {}", command );
		return "list/list";
		
	}	
	
	@RequestMapping(value="/article", method = RequestMethod.POST)
	public String submitArticle(
			@ModelAttribute("command") ListCommand command,
			HttpSession session) {
						
		SessionUtils.mapCommandToSession(command, session);		
		log.info("Command class: {}", command );
		return "redirect:/article/" + command.getSelectedArticle();
		
	}
	
	private void mapSessionToCommand(ListCommand command, HttpSession session) {
		
		if (session.getAttribute("currentPage") == null) {
			return;
		}
		
		SessionUtils.mapSessionToCommand(command, session);
		
	}
	
	private void handleList(ListCommand command) {
		
		if(isTag(command)) {
			log.debug("Type of List: TAG");
			handleTag(command);
		} else if(isSearch(command)) {
			log.debug("Type of List: SEARCH");
			handleSearch(command);
		} else if(isHomeCategory(command)) {
			log.debug("Type of List: HOME CATEGORY");
			handleHomeCategory(command);
		} else {
			log.debug("Type of List: OTHER CATEGORIES");
			handleOtherCategories(command);
		}	
		
	}
	
	private boolean isTag(ListCommand command) {		
		return (command.getSelectedTag() != null) ? true : false;		
	}
	
	private boolean isSearch(ListCommand command) {		
		return (StringUtils.isNotBlank(command.getSearchText())) ? true : false;		
	}
	
	private boolean isHomeCategory(ListCommand command) {		
		return (HOME.equals(command.getSelectedCategory())) ? true : false;		
	}

	private void handleTag(ListCommand command) {
		articleService.findAll(command);
		tagService.findAll(command);
	}
	
	private void handleSearch(ListCommand command) {
		
		if (HOME.equals(command.getSelectedCategory())) {
			articleService.findAll(command);
		} else {
			articleService.findAll(command);
			tagService.findAll(command);
		}		
		
	}
	
	private void handleHomeCategory(ListCommand command) {
		articleService.findAll(command);
	}

	private void handleOtherCategories(ListCommand command) {
		articleService.findAll(command);
		tagService.findAll(command);
	}
		
}