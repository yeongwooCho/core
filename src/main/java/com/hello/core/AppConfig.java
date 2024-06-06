package com.hello.core;

import com.hello.core.discount.DiscountPolicy;
import com.hello.core.discount.FixDiscountPolicy;
import com.hello.core.discount.RateDiscountPolicy;
import com.hello.core.member.MemberRepository;
import com.hello.core.member.MemberService;
import com.hello.core.member.MemberServiceImpl;
import com.hello.core.member.MemoryMemberRepository;
import com.hello.core.order.OrderService;
import com.hello.core.order.OrderServiceImpl;

public class AppConfig {
    private MemberRepository getMemberRepository() {
        return new MemoryMemberRepository();
    }

    private DiscountPolicy getDiscountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }

    public MemberService memberService() {
        return new MemberServiceImpl(getMemberRepository());
    }

    public OrderService orderService() {
        return new OrderServiceImpl(getMemberRepository(), getDiscountPolicy());
    }
}
