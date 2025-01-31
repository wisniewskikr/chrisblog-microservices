package pl.kwi.chrisblog.utils;

import jakarta.servlet.http.HttpSession;

import pl.kwi.chrisblog.commands.abstr.AbstrBlogCommand;

public class SessionUtils {
	
	public static void mapSessionToCommand(AbstrBlogCommand command, HttpSession session) {
				
		command.setCurrentPage((Integer)session.getAttribute("currentPage"));
		command.setSelectedCategory((String)session.getAttribute("selectedCategory"));
		command.setSelectedSorting((String)session.getAttribute("selectedSorting"));
		command.setSelectedTag((Long)session.getAttribute("selectedTag"));
		command.setSearchText((String)session.getAttribute("searchText"));
		
	}
	
	public static void mapCommandToSession(AbstrBlogCommand command, HttpSession session) {
		
		session.setAttribute("currentPage", command.getCurrentPage());
		session.setAttribute("selectedCategory", command.getSelectedCategory());
		session.setAttribute("selectedSorting", command.getSelectedSorting());
		session.setAttribute("selectedTag", command.getSelectedTag());
		session.setAttribute("searchText", command.getSearchText());
		
	}

}
