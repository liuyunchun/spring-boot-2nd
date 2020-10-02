package com.yunchun.domain;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "article")
public class Article {

    @Id
    @Column(name = "id_")
    private String id;

    @Column(name = "title_")
    private String title;

    @Column(name = "sort_")
    private Integer sort;

    //枚舉嘗試
    @Column(name = "type_")
    @Enumerated(EnumType.STRING)
    private Type type;

    //自關聯嘗試，此欄擁有外來鍵，應為Many
    @ManyToOne
    @JoinColumn(name = "parent_")
    private Article parent;

    //OneToMany
    @OneToMany(mappedBy = "id")
    private List<Article> childrens;

    //文章分類標籤，擁有外來鍵，應為Many
    @ManyToOne
    @JoinColumn(name = "category_")
    private SysCode category;

    @Column(name = "content_")
    private String content;

    @Column(name = "count_")
    private Integer count;

    @Column(name = "create_time_")
    private LocalDateTime createTime;

    @ManyToOne
    @JoinColumn(name = "author_")
    private Member author;

//    @Column(name = "create_id_")
//    private String createId;

    @Column(name = "update_time_")
    private LocalDateTime updateTime;
}

