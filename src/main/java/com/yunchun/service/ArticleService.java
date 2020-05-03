package com.yunchun.service;

import com.yunchun.domain.Article;

public interface ArticleService {
    Article insert(Article article);

    Article update(Article article);

    Article find(String id);

    void delete(Article article);
}
