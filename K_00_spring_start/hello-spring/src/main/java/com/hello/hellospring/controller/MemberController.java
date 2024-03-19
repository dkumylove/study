package com.hello.hellospring.controller;

import com.hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * 회원 컨트롤러에 의존관계 추가
 */
@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    /**
     * 객체 의존관계를 외부에서 넣어주는 것을 DI (Dependency Injection), 의존성 주입이라 한다.
     *
     * 스프링 빈을 등록하는 2가지 방법
     * - 컴포넌트 스캔과 자동 의존관계 설정
     * - 자바 코드로 직접 스프링 빈 등록하기
     *
     * 컴포넌트 스캔 원리
     * - @Component : 애노테이션이 있으면 스프링 빈으로 자동 등록
     *      - @Controller 컨트롤러가 스프링 빈으로 자동 등록된 이유도 컴포넌트 스캔 때문
     * - @Component 를 포함하는 다음 애노테이션도 스프링 빈으로 자동 등록
     *      - @Controller
     *      - @Service
     *      - @Repository
     *
     * @Controller
     * - 스프링 빈으로 자동 등록
     *
     * @Autowired
     * - 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 주입한다.
     * - 생성자가 1개만 있으면 @Autowired 는 생략할 수 있다.
     *
     *
     * 참고: 스프링은 스프링 컨테이너에 스프링 빈을 등록할 때, 기본으로 싱글톤으로 등록한다.
     * (유일하게 하나만 등록해서 공유한다) 따라서 같은 스프링 빈이면 모두 같은 인스턴스다.
     * 설정으로 싱글톤이 아니게 설정할 수 있지만, 특별한 경우를 제외하면 대부분 싱글톤을 사용한다.
     */
}

