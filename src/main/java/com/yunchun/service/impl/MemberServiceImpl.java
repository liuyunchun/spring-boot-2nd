package com.yunchun.service.impl;

import com.yunchun.domain.Member;
import com.yunchun.repository.MemberRepository;
import com.yunchun.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service("com.yunchun.service.impl.MemberServiceImpl")
public class MemberServiceImpl implements MemberService{

    @Resource
    private MemberRepository memberRepository;

    @Override
    public Member insert(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member update(Member member) {
        return memberRepository.save(member);
    }

    @Override
    public Member find(String id) {
        return memberRepository.findOneById(id);
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

    public void delete(Member member) {
        memberRepository.delete(member);
    }
}
