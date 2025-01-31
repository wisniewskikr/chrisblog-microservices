package pl.kwi.chrisblog.commands.abstr;

import java.util.List;

import pl.kwi.chrisblog.enums.SortingEnum;

public abstract class AbstrPagiantionCommand {
	
	
	private List<Integer> pages;
	private int currentPage = 1;
	private boolean disablePrevious;
	private boolean disableNext;
	private String selectedSorting = SortingEnum.DATE_DECREASING.getValue();
	
	
	public List<Integer> getPages() {
		return pages;
	}
	public void setPages(List<Integer> pages) {
		this.pages = pages;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	
	public boolean isDisablePrevious() {
		return disablePrevious;
	}
	public void setDisablePrevious(boolean disablePrevious) {
		this.disablePrevious = disablePrevious;
	}
	
	public boolean isDisableNext() {
		return disableNext;
	}
	public void setDisableNext(boolean disableNext) {
		this.disableNext = disableNext;
	}
	
	public String getSelectedSorting() {
		return selectedSorting;
	}
	public void setSelectedSorting(String selectedSorting) {
		this.selectedSorting = selectedSorting;
	}	
	
	
}
