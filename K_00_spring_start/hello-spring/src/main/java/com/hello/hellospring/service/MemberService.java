package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

/**
 * 회원 서비스 개발
 * - 서비스는 비지니스에 의존적으로 네임드 설계
 * - 서비스 롤 : 비지니스를 처리하는
 */
public class MemberService {

    private final MemberRepository memberRepository = new
            MemoryMemberRepository();

    /**
     * 회원가입
     * @param member
     * @return
     */
    public Long join(Member member) {
        validateDuplicateMember(member); //중복 회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    /**
     * 중복 회원 검증
     * - 같은 이름이 있는 중복 회원 x
     * @param member
     *
     * ifPresent : 값이 있으면
     */
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    /**
     * 전체 회원 조회
     * @return
     */
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    /**
     * 회원 조회
     * @param memberId
     * @return
     */
    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }


    /**
     * 단축키
     * c> a> + V : return 을 바로해줌
     * c> s> + enter : ;후 줄개행
     * 범위지정 -> c> a> s> + T : 메서드로 외부에 뺄수 있다.
     */
}
