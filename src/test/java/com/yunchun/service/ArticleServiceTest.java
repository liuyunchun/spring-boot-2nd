package com.yunchun.service;

import com.yunchun.domain.Article;
import com.yunchun.domain.Member;
import com.yunchun.domain.SysCode;
import com.yunchun.domain.Type;
import org.assertj.core.api.Assertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class ArticleServiceTest {
    @Resource
    private SysCodeService sysCodeService;

    @Resource
    private MemberService memberService;

    @Resource
    private ArticleService articleService;

    @Test
    public void test(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = LocalDate.parse("2020/05/09", formatter);

        SysCode syscode = new SysCode();
        syscode.setId("001");
        syscode.setCode("A");
        syscode.setDescription("版主");

        sysCodeService.insert(syscode);

        SysCode syscode2 = new SysCode();
        syscode2.setId("002");
        syscode2.setCode("live");
        syscode2.setDescription("音樂版");

        sysCodeService.insert(syscode2);

        SysCode syscode3 = sysCodeService.find("001");
        SysCode syscode4 = sysCodeService.find("002");

        Member member = new Member();
        member.setId("123456");
        member.setPassword("654321");
        member.setName("arashi");
        member.setEmail("123@yahoo.com");
        member.setBanTime(date);
        member.setBoardMaster(syscode3);

        memberService.insert(member);

        Member member2 = memberService.find("123456");

        Article article = new Article();
        article.setId("A0001");
        article.setTitle("BLAZING台版心得");
        article.setSort(1);
        article.setType(Type.ARTICLE);
        article.setCategory(syscode4);
        article.setContent("Mamo的BLAZING演唱會BD居然找到自己了！！");
        article.setCount(0);
        article.setAuthor(member2);
        article.setCreateTime(LocalDateTime.now());

        articleService.insert(article);

        Article result1 = articleService.find("A0001");
        Assertions.assertThat(result1.getTitle()).isEqualTo("BLAZING台版心得");
        System.err.println(result1);

        Article content = new Article();
        content.setId("A0002");
        content.setTitle("補充");
        content.setSort(1);
        content.setType(Type.COMMENT);
        content.setParent(result1);
        content.setCategory(syscode4);
        content.setContent("隔天的見面會本人也有出現在阿官的照片上，人生第一次追星行程無憾QWQ");
        content.setCount(0);
        content.setAuthor(member2);
        content.setCreateTime(LocalDateTime.now());

        articleService.insert(content);
        Article result2 = articleService.find("A0002");
        Assertions.assertThat(result2).isNotNull();
        System.err.println(result2);

        result2.setTitle("見面會也......！");
        articleService.update(result2);
        result2 = articleService.find("A0002");
        Assertions.assertThat(result2.getTitle()).isEqualTo("見面會也......！");
        System.err.println(result2);

        articleService.delete(result2);
        result2 = articleService.find("A0002");
        Assertions.assertThat(result2).isNull();
    }
}
