package com.yunchun.repository;

import com.yunchun.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ArticleRepository extends JpaRepository <Article, String>{
    Article findOneById(String id);
}
