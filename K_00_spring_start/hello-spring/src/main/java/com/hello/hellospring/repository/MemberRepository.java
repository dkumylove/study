package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

/**
 * 회원 리포지토리 인터페이스
 */
public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id);
    Optional<Member> findByName(String name);
    List<Member> findAll();

    /**
     * Optional
     * - null을 처리하는 방법
     * - null을 그대로 반환하는 것이 아닌 Optional 감싸서 반환
     */
}
