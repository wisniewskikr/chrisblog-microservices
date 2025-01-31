package pl.kwi.chrisblog.services;

import java.util.Optional;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import pl.kwi.chrisblog.clients.ArticleClient;
import pl.kwi.chrisblog.commands.list.ListCommand;
import pl.kwi.chrisblog.dtos.ArticleDto;
import pl.kwi.chrisblog.dtos.ArticleResponse;

@Service
public class ArticleService {

	public static final String HOME = "home";

	private final ArticleClient articleClient;

	public ArticleService(ArticleClient articleClient) {
		this.articleClient = articleClient;
	}

	public void findAll(ListCommand command) {			
		
		Long categoryId = (HOME.equals(command.getSelectedCategory())) ? 0L : Long.valueOf(command.getSelectedCategory());
		Long tagId = command.getSelectedTag();
		int page = command.getCurrentPage();
		String sorting = command.getSelectedSorting();
		String searchText = (StringUtils.isNotBlank(command.getSearchText())) ? command.getSearchText().toLowerCase() : null;

		ArticleResponse articleResponse = articleClient.findArticles(categoryId, tagId, page, sorting , searchText);
		command.setArticles(articleResponse.articles());
		command.setPages(articleResponse.pages());
		command.setDisableNext(articleResponse.disableNext());
		command.setDisablePrevious(articleResponse.disablePrevious());
		
	}

	public Optional<ArticleDto> findById(long articleId) {
		return Optional.ofNullable(articleClient.findArticleById(articleId));
	}
	
}
