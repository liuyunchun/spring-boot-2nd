package com.yunchun.service;

import com.yunchun.domain.Article;

import java.util.List;

public interface ArticleService {
    Article insert(Article article);

    Article update(Article article);

    Article find(String id);

    List<Article> findAll ();

    void delete(Article article);
}

