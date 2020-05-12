package com.yunchun.ServiceImpl;

import com.yunchun.domain.Article;
import com.yunchun.domain.Member;
import com.yunchun.domain.SysCode;
import com.yunchun.domain.Type;
import com.yunchun.service.impl.ArticleServiceImpl;
import com.yunchun.service.impl.MemberServiceImpl;
import com.yunchun.service.impl.SysCodeServiceImpl;
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
public class ArticleServiceImplTest {
    @Resource
    private SysCodeServiceImpl sysCodeServiceImpl;

    @Resource
    private MemberServiceImpl memberServiceImpl;

    @Resource
    private ArticleServiceImpl articleServiceImpl;

    @Test
    public void test(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = LocalDate.parse("2020/05/09", formatter);

        SysCode syscode = new SysCode();
        syscode.setId("001");
        syscode.setCode("A");
        syscode.setDescription("版主");

        sysCodeServiceImpl.insert(syscode);

        SysCode syscode2 = new SysCode();
        syscode2.setId("002");
        syscode2.setCode("live");
        syscode2.setDescription("音樂版");

        sysCodeServiceImpl.insert(syscode2);

        SysCode syscode3 = sysCodeServiceImpl.find("001");
        SysCode syscode4 = sysCodeServiceImpl.find("002");

        Member member = new Member();
        member.setId("123456");
        member.setPassword("654321");
        member.setName("arashi");
        member.setEmail("123@yahoo.com");
        member.setBanTime(date);
        member.setBoardMaster(syscode3);

        memberServiceImpl.insert(member);

        Member member2 = memberServiceImpl.find("123456");
        //System.out.println(member2.getBoardMaster().getDescription());

        Article article = new Article();
        article.setId("A0001");
        article.setTitle("BLAZING台版心得");
        article.setSort(1);
        article.setType(Type.ARTICLE);
        article.setCategory(syscode4);
        article.setContent("Mamo的BLAZING演唱會BD居然找到自己了！！");
        article.setCount(0);
        article.setCreater(member2);
        article.setCreateTime(LocalDateTime.now());

        articleServiceImpl.insert(article);

        Article article2 = articleServiceImpl.find("A0001");
        //System.out.println(article2.getType());

        Article content = new Article();
        content.setId("A0002");
        content.setTitle("補充");
        content.setSort(1);
        content.setType(Type.COMMENT);
        content.setParent(article2);
        content.setCategory(syscode4);
        content.setContent("隔天的見面會本人也有出現在阿官的照片上，人生第一次追星行程無憾QWQ");
        content.setCount(0);
        content.setCreater(member2);
        content.setCreateTime(LocalDateTime.now());

        articleServiceImpl.insert(content);

        Article content2 = articleServiceImpl.find("A0002");
        System.out.println(content2.getCategory().getDescription());
    }
}
