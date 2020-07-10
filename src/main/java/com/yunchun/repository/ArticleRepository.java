package com.yunchun.repository;

import com.yunchun.domain.Article;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ArticleRepository extends JpaRepository <Article, String>{
    Article findOneById(String id);

    @Query(
            "SELECT t FROM Article t " +
                    "WHERE t.title like '%:#{#article.title}%'" +
                    "ORDER BY t.id ASC"
    )
    List<Article> findAllByTitle(@Param("article") Article article);

    @Query(
            "SELECT t FROM Article t " +
                    "WHERE t.content like :#{#article.content} " +
                    "ORDER BY t.id ASC"
    )
    List<Article> findAllByContent(@Param("article") Article article);

    @Query(
            "SELECT t FROM Article t " +
                    "WHERE t.title= :#{#article.title} " +
                    "AND t.content= :#{#article.content} " +
                    "ORDER BY t.id ASC"
    )
    List<Article> findAllByTitleAndContent(@Param("article") Article article);
}
