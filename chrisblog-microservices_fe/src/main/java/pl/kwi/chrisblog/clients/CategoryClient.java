package pl.kwi.chrisblog.clients;

import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import pl.kwi.chrisblog.dtos.CategoryResponse;

@HttpExchange
public interface CategoryClient {

    @GetExchange("/api/v1/category")
    public CategoryResponse findCategories();

}