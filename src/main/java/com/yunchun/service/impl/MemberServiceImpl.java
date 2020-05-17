package com.yunchun.service.impl;

import com.yunchun.domain.Member;
import com.yunchun.repository.MemberRepository;
import com.yunchun.service.MemberService;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.Resource;

@Service("com.yunchun.service.impl.MemberServiceImpl")
public class MemberServiceImpl extends GenericServiceImpl<Member, MemberRepository> implements MemberService{

    @Resource
    private MemberRepository memberRepository;

    @PostConstruct
    public void init(){setRepository(memberRepository);}

    @Override
    public Member find(String id) {
        return memberRepository.findOneById(id);
    }
}
