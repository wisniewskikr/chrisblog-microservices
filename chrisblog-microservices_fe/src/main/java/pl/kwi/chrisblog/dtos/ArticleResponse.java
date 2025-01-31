package pl.kwi.chrisblog.dtos;

import java.util.List;

public record ArticleResponse(List<Integer> pages, boolean disablePrevious, boolean disableNext, Iterable<ArticleDto> articles) {}