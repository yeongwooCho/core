package com.hello.core;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.order.Order;
import com.hello.core.order.OrderService;

public class OrderApp {
    public static void main(String[] args) {
        AppConfig appConfig = new AppConfig();

        final MemberService memberService = appConfig.memberService();
        final OrderService orderService = appConfig.orderService();

        final Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }
}
