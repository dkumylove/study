package com.hello.hellospring.repository;

import com.hello.hellospring.domain.Member;

import java.util.*;

/**
 * 동시성 문제가 고려되어 있지 않음, 실무에서는 ConcurrentHashMap, AtomicLong 사용 고려
 *
 * 회원 리포지토리 메모리 구현체
 */
public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>();
    private static long sequence = 0L;
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }
    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id));  // null발생할수 있기때문에 Optional.ofNullable()로 감싼다.
    }
    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }
    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))  //member.getName이 여기 파라미트로 넘어온 name이랑 같은지 확인
                .findAny();  // 하나라도 찾으면 반환, 끝까지 없으면 null반환
    }
    public void clearStore() {
        store.clear();  // 스토어를 비움
    }

}
