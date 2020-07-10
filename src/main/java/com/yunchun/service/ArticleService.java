package com.yunchun.service;

import com.yunchun.domain.Article;
import com.yunchun.repository.ArticleRepository;

import java.util.List;

public interface ArticleService extends GenericService<Article, ArticleRepository>{
    Article insert(Article article);

    Article update(Article article);

    Article find(String id);

    void delete(Article article);

    List<Article> findAllByTitle(Article article);

    List<Article> findAllByContent(Article article);

    List<Article> findAllByTitleAndContent(Article article);
}

