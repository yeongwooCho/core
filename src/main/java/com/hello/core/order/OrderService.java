package com.hello.core.order;

import com.hello.core.member.MemberRepository;

public interface OrderService {
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
