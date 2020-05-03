package com.yunchun.service;

import com.yunchun.domain.Member;

public interface MemberService {
    Member insert(Member member);

    Member update(Member member);

    Member find(String id);

    void delete(Member member);
}
