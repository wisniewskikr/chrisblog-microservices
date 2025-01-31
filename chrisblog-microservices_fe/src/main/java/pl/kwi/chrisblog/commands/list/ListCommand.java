package pl.kwi.chrisblog.commands.list;

import lombok.ToString;
import pl.kwi.chrisblog.commands.abstr.AbstrBlogCommand;
import pl.kwi.chrisblog.dtos.ArticleDto;
import pl.kwi.chrisblog.dtos.TagDto;

@ToString
public class ListCommand extends AbstrBlogCommand {
		
	private Iterable<ArticleDto> articles;
	private Long selectedArticle;
	private Iterable<TagDto> tags;

	
	public Iterable<ArticleDto> getArticles() {
		return articles;
	}
	public void setArticles(Iterable<ArticleDto> articles) {
		this.articles = articles;
	}
	
	public Long getSelectedArticle() {
		return selectedArticle;
	}
	public void setSelectedArticle(Long selectedArticle) {
		this.selectedArticle = selectedArticle;
	}
	
	public Iterable<TagDto> getTags() {
		return tags;
	}
	public void setTags(Iterable<TagDto> tags) {
		this.tags = tags;
	}
	
	
}