package pl.kwi.chrisblog.clients;

import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.HttpExchange;
import pl.kwi.chrisblog.dtos.TagResponse;

@HttpExchange
public interface TagClient {

    @GetExchange("/api/v1/tag")
    public TagResponse findTags(
        @RequestParam("categoryId") Long categoryId,
        @RequestParam(value = "tagId", required = false) Long tagId,
        @RequestParam("page") int page,
        @RequestParam("sorting") String sorting,
        @RequestParam(value = "searchText", required = false) String searchText
        );

}