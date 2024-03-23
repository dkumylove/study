package com.hello.hellospring;

import com.hello.hellospring.repository.JdbcMemberRepository;
import com.hello.hellospring.repository.MemberRepository;
import com.hello.hellospring.service.MemberService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    private final DataSource dataSource;
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @Bean
    public MemberService memberService() {
        return new MemberService(memberRepository());
    }
    @Bean
    public MemberRepository memberRepository() {
//        return new MemoryMemberRepository();
        return new JdbcMemberRepository(dataSource);
    }

    /**
     * DI(의존주입) 3가지
     * - 필드 주입, setter 주입, 생성자 주입
     * - 의존관계가 실행중에 동적으로 변하는 경우는 거의 없으므로 생성자 주입을 권장한다.
     *
     * 실무에서는 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드는 컴포넌트 스캔을 사용한다.
     * 정형화 되지 않거나, 상황에 따라 구현 클래스를 변경해야 하면 설정을 통해 스프링 빈으로 등록한다.
     *
     * @Autowired 를 통한 DI는
     * - 스프링이 관리하는 객체에서만 동작한다.
     * - 스프링 빈으로 등록하지 않고 내가 직접 생성한 객체에서는 동작하지 않는다.
     */

    /**
     * 개방-폐쇄 원칙(OCP, Open-Closed Principle)
     * 확장에는 열려있고, 수정, 변경에는 닫혀있다.
     *
     * 스프링의 DI (Dependencies Injection)을 사용하면 기존 코드를 전혀 손대지 않고,
     * 설정만으로 구현 클래스를 변경할 수 있다.
     */

    /**
     * DataSource는 데이터베이스 커넥션을 획득할 때 사용하는 객체다.
     * 스프링 부트는 데이터베이스 커넥션 정보를 바탕으로 DataSource를 생성하고
     * 스프링 빈으로 만들어둔다. 그래서 DI를 받을 수 있다.
     */
}