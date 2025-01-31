package pl.kwi.chrisblog.commands.article;

import lombok.ToString;
import pl.kwi.chrisblog.commands.abstr.AbstrBlogCommand;
import pl.kwi.chrisblog.dtos.ArticleDto;

@ToString
public class ArticleCommand extends AbstrBlogCommand {
	
	
	private ArticleDto article;
	private Long articleId;

	
	public ArticleDto getArticle() {
		return article;
	}
	public void setArticle(ArticleDto article) {
		this.article = article;
	}
	
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}
	
	
}
