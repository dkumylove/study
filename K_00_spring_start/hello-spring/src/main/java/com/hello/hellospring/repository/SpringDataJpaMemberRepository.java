package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

/**
 * 스프링 데이터 JPA 회원 리포지토리
 *
 * 스프링 데이터 JPA가
 * SpringDataJpaMemberRepository를 스프링 빈으로 자동 등록해준다.
 */
public interface SpringDataJpaMemberRepository extends JpaRepository<Member,
        Long>, MemberRepository {
    Optional<Member> findByName(String name);
}

/**
 * 스프링 데이터 JPA 제공 기능
 *  - 인터페이스를 통한 기본적인 CRUD
 *  - findByName() , findByEmail() 처럼 메서드 이름 만으로 조회 기능 제공
 *  - 페이징 기능 자동 제공
 *
 *
 */