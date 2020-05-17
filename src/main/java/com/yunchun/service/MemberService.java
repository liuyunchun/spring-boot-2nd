package com.yunchun.service;

import com.yunchun.domain.Member;
import com.yunchun.repository.MemberRepository;

public interface MemberService extends GenericService<Member, MemberRepository>{
    Member insert(Member member);

    Member update(Member member);

    Member find(String id);

    void delete(Member member);
}
