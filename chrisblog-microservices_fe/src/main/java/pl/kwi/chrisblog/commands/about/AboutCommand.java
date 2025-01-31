package pl.kwi.chrisblog.commands.about;

import lombok.ToString;
import pl.kwi.chrisblog.commands.abstr.AbstrBlogCommand;

@ToString
public class AboutCommand extends AbstrBlogCommand {
	
	
	private Long articleId;

	
	public Long getArticleId() {
		return articleId;
	}
	public void setArticleId(Long articleId) {
		this.articleId = articleId;
	}	
			

}
