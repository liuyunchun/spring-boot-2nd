package com.yunchun.service;

import com.yunchun.domain.Member;

import java.util.List;

public interface MemberService {
    Member insert(Member member);

    Member update(Member member);

    Member find(String id);

    List<Member> findAll ();

    void delete(Member member);
}
