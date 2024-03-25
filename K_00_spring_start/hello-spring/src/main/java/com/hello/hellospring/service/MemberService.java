package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemberRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * 회원 서비스 개발
 * - 서비스는 비지니스에 의존적으로 네임드 설계
 * - 서비스 롤 : 비지니스를 처리하는
 */
@Transactional
public class MemberService {

    /**
     * @Transactional
     * 스프링은 해당 클래스의 메서드를 실행할 때 트랜잭션을 시작하고,
     * 메서드가 정상 종료되면 트랜잭션을 커밋한다.
     * 만약 런타임 예외가 발생하면 롤백한다.
     * JPA를 통한 모든 데이터 변경은 트랜잭션 안에서 실행해야 한다.
     */

//    private final MemberRepository memberRepository = new
//            MemoryMemberRepository();
    private final MemberRepository memberRepository;

    /**
     * 생성자 주입
     * - 직접생성이 아닌 외부에서 넣어 주게 바꾼다.
     * @param memberRepository
     */
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    /**
     * 회원가입
     * @param member
     * @return
     */
    public Long join(Member member) {

        // MemberService 회원 조회 시간 측정 추가
        long start = System.currentTimeMillis();

        try {
            validateDuplicateMember(member); //중복 회원 검증
            memberRepository.save(member);
            return member.getId();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join : " + timeMs + "ms");
        }

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

        // MemberService 회원 조회 시간 측정 추가
        long start = System.currentTimeMillis();
        try {
            return memberRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers " + timeMs + "ms");
        }

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
     * 07: AOP : AOP가 필요한 상황
     * MemberService 회원 조회 시간 측정 추가 문제>>
     *  - 회원가입, 회원 조회에 시간을 측정하는 기능은 핵심 관심 사항이 아니다.
     *  - 시간을 측정하는 로직은 공통 관심 사항이다.
     *  - 시간을 측정하는 로직과 핵심 비즈니스의 로직이 섞여서 유지보수가 어렵다.
     *  - 시간을 측정하는 로직을 별도의 공통 로직으로 만들기 매우 어렵다.
     *  - 시간을 측정하는 로직을 변경할 때 모든 로직을 찾아가면서 변경해야 한다.
     *
     *  AOP가 필요한 상황
     *  - 모든 메소드의 호출 시간을 측정하고 싶다면?
     *  - 공통 관심 사항(cross-cutting concern) vs 핵심 관심 사항(core concern)
     */

    /**
     * 단축키
     * c> a> + V : return 을 바로해줌
     * c> s> + enter : ;후 줄개행
     * 범위지정 -> c> a> s> + T : 메서드로 외부에 뺄수 있다.
     * 클래스에 커서를 놓고 c> s> + T : 테스트클래스 생성
     * c> + R or s> + F10 : 이전 실행 그대로 다시 실행
     */
}
