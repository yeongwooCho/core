package com.hello.core.singleton;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("상태를 유지하는 싱글톤 방식의 문제점")
    void statefulServiceSingleton() {
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // Thread A: A 사용자 10000원 주문
        statefulService1.order("userA", 10000);
        // Thread B: B 사용자 20000원 주문
        statefulService2.order("userB", 20000);

        // Thread A: 사용자 A 주문 금액 조회
        int price = statefulService1.getPrice();
        System.out.println("price = " + price);

        // Thread B: 사용자 B 주문 금액 조회
        int price2 = statefulService2.getPrice();
        System.out.println("price2 = " + price2);

        // Thread A: 사용자 A 주문 금액 조회
        // 사용자 A가 20000원을 주문했지만, 사용자 B가 주문한 20000원이 조회됨
        // 따라서, 상태를 유지하는 싱글톤 방식은 사용하지 않는 것이 좋음
        assertEquals(20000, price);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }


}
