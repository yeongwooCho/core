package com.hello.core.order;

import com.hello.core.member.*;

public class OrderApp {
    public static void main(String[] args) {
        final MemberService memberService = new MemberServiceImpl();
        final OrderService orderService = new OrderServiceImpl();

        final Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }
}
