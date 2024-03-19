package com.hello.hellospring.service;

import com.hello.hellospring.domain.Member;
import com.hello.hellospring.repository.MemoryMemberRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;
    MemoryMemberRepository memberRepository;

    /**
     * 테스트는 각각 독립적으로 실행되어야 한다.
     * 테스트 순서에 의존관계가 있는 것은 좋은 테스트가 아니다.
     * - Given : 뭔가가 주어지고
     * - When : 이렇게 실행할때
     * - Then : 결과가 이렇게 나와야함
     * "상황에 따라 다르게 GWT구조에서 벗어날수 있음"
     *
     * @AfterEach
     * - 메소드 실행이 끝날떄마다 실행
     * - 한번에 여러 테스트를 실행하면 메모리 DB에 직전 테스트의 결과가 남을 수 있다.
     * - 이렇게 되면 다음 이전 테스트 때문에 다음 테스트가 실패할 가능성이 있다.
     * - @AfterEach 를 사용하면 각 테스트가 종료 될 때 마다 이 기능을 실행한다.
     * - 여기서는 메모리 DB에 저장된 데이터를 삭제한다.
     *
     * @BeforeEach
     * - 각 테스트 실행 전에 호출된다.
     * - 테스트가 서로 영향이 없도록 항상 새로운 객체를 생성하고, 의존관계도 새로 맺어준다.
     */
    @BeforeEach
    public void beforeEach() {
        memberRepository = new MemoryMemberRepository();
        memberService = new MemberService(memberRepository);
    }
    @AfterEach
    public void afterEach() {
        memberRepository.clearStore();
    }
    @Test
    public void 회원가입() throws Exception {
        //Given
        Member member = new Member();
        member.setName("hello");
        //When
        Long saveId = memberService.join(member);
        //Then
        Member findMember = memberRepository.findById(saveId).get();
        assertThat(member.getName()).isEqualTo(findMember.getName());
        assertEquals(member.getName(), findMember.getName());
    }
    @Test
    public void 중복_회원_예외() throws Exception {
        //Given
        Member member1 = new Member();
        member1.setName("spring");
        Member member2 = new Member();
        member2.setName("spring");
        //When
        memberService.join(member1);
        IllegalStateException e = assertThrows(IllegalStateException.class,
                () -> memberService.join(member2));//예외가 발생해야 한다.
        assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");

//        try {
//            memberService.join(member2);
//            fail();
//        } catch (IllegalStateException e) {
//            assertThat(e.getMessage()).isEqualTo("이미 존재하는 회원입니다.");
//        }
    }


}