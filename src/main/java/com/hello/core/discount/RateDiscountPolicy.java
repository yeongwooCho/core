package com.hello.core.discount;

import com.hello.core.member.Member;

public class RateDiscountPolicy implements DiscountPolicy {
    @Override
    public int discount(Member member, int price) {
        return 0;
    }
}
