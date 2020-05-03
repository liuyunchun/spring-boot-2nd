package com.yunchun.repository;

import com.yunchun.domain.Member;
import com.yunchun.domain.SysCode;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@SpringBootTest
@RunWith(SpringRunner.class)
@Transactional
public class MemberRepositoryTest {

    @Resource
    private MemberRepository memberRepository;

    @Resource
    private SysCodeRepository sysCodeRepository;

    @Test
    public void test(){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy/MM/dd");
        LocalDate date = LocalDate.parse("2020/05/01", formatter);

        SysCode syscode = new SysCode();
        syscode.setId("001");
        syscode.setCode("A");
        syscode.setDescription("版主");

        sysCodeRepository.save(syscode);
        SysCode syscode2 = sysCodeRepository.findOneById("001");

        Member memberA = new Member();
        memberA.setId("123456");
        memberA.setPassword("654321");
        memberA.setName("arashi");
        memberA.setEmail("123@yahoo.com");
        memberA.setBanTime(date);
        memberA.setBoardMaster(syscode2);

        memberRepository.save(memberA);

        Member memberB = memberRepository.findOneById("123456");
        System.out.println(memberB.getBoardMaster().getDescription());

    }
}
