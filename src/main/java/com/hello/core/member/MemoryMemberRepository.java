package com.hello.core.member;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

@Component
@Primary
public class MemoryMemberRepository implements MemberRepository {
    // HashMap 은 동시성 이슈가 있을 수 있으므로 ConcurrentHashMap 을 사용하는 것이 좋다.
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
