package pl.kwi.chrisblog.dtos;

import java.util.HashSet;
import java.util.Set;

public class CategoryDto {

	private Long id;
    private String name;
    private Set<ArticleDto> articles = new HashSet<ArticleDto>();
    
	public CategoryDto() {
	}	

	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public Set<ArticleDto> getArticles() {
		return articles;
	}
	public void setArticles(Set<ArticleDto> articles) {
		this.articles = articles;
	}

}
