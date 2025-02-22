package com.hello.core.member;

import com.hello.core.AppConfig;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {
    MemberService memberService;

    @BeforeEach
    void beforeEach() {
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
    }

    @Test
    void join() {
        // given: 이게 주어졌을때
        Member member = new Member(1L, "memberA", Grade.VIP);

        // when: 이런 상황일떄
        memberService.join(member);

        // then: 이렇게 된다.
        Member findMember = memberService.findMember(1L);
//        org.assertj.core.api.Assertions.assertThat(member).isEqualTo(findMember);
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
