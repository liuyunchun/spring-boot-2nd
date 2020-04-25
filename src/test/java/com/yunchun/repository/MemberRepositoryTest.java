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

        Member member_a = new Member();
        member_a.setId("123456");
        member_a.setPassword("654321");
        member_a.setName("arashi");
        member_a.setEmail("123@yahoo.com");
        member_a.setBanTime(date);
        member_a.setBoardMaster(syscode2);

        memberRepository.save(member_a);

        Member member_b = memberRepository.findOneById("123456");
        System.out.println(member_b.getBoardMaster().getDescription());

    }
}
