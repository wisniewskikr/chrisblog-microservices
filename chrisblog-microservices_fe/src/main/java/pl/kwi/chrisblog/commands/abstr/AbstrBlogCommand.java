package pl.kwi.chrisblog.commands.abstr;

import pl.kwi.chrisblog.controllers.list.ListController;

public abstract class AbstrBlogCommand extends AbstrPagiantionCommand {
	
	
	private String selectedCategory = ListController.HOME;
	private Long selectedTag;
	private String searchText;
	
	
	public String getSelectedCategory() {
		return selectedCategory;
	}
	public void setSelectedCategory(String selectedCategory) {
		this.selectedCategory = selectedCategory;
	}
	
	public Long getSelectedTag() {
		return selectedTag;
	}
	public void setSelectedTag(Long selectedTag) {
		this.selectedTag = selectedTag;
	}
	
	public String getSearchText() {
		return searchText;
	}
	public void setSearchText(String searchText) {
		this.searchText = searchText;
	}	

}
