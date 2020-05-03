package com.yunchun.repository;

import com.sun.org.apache.bcel.internal.generic.NEW;
import com.yunchun.domain.Article;
import com.yunchun.domain.Member;
import com.yunchun.domain.SysCode;
import com.yunchun.domain.Type;
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
public class ArticleRepositoryTest {
    @Resource
    private MemberRepository memberRepository;

    @Resource
    private SysCodeRepository sysCodeRepository;

    @Resource
    private ArticleRepository articleRepository;

    @Test
    public void test(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = LocalDate.parse("2020/05/01", formatter);

        SysCode syscode = new SysCode();
        syscode.setId("001");
        syscode.setCode("A");
        syscode.setDescription("版主");

        sysCodeRepository.save(syscode);

        SysCode syscode2 = new SysCode();
        syscode2.setId("002");
        syscode2.setCode("music");
        syscode2.setDescription("音樂版");


        SysCode syscode3 = sysCodeRepository.findOneById("001");
        SysCode syscode4 = sysCodeRepository.findOneById("002");

        Member member_a = new Member();
        member_a.setId("123456");
        member_a.setPassword("654321");
        member_a.setName("arashi");
        member_a.setEmail("123@yahoo.com");
        member_a.setBanTime(date);
        member_a.setBoardMaster(syscode3);

        memberRepository.save(member_a);
        Member member_b = memberRepository.findOneById("123456");

        Article article = new Article();

        article.setId("A0001");
        article.setTitle("測試文章功能");
        article.setSort(1);
        article.setType(Type.ARTICLE);
        article.setCategory(syscode4);
        article.setContent("Mamo的19th新專光射す方へ根本神仙專輯！！");
        article.setCount(0);
        article.setCreater(member_b);
        article.setCreateTime(LocalDateTime.now());

        articleRepository.save(article);

        Article article2 = articleRepository.findOneById("A0001");
        System.out.println(article2.getCreater().getName());

    }
}
