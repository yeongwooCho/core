package com.hello.core;

import com.hello.core.member.Grade;
import com.hello.core.member.Member;
import com.hello.core.member.MemberService;
import com.hello.core.order.Order;
import com.hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        final MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        final OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        final Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(1L, "itemA", 10000);
        System.out.println("order = " + order);
        System.out.println("order = " + order.calculatePrice());
    }
}
