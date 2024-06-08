package com.hello.core;


import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
@ToString
@RequiredArgsConstructor
public class HelloLombok {

    private final String name;
    private final int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok("asdf", 20);
//        helloLombok.setName("test");
        String name = helloLombok.getName();
        System.out.println("name = " + name);
        System.out.println("helloLombok = " + helloLombok);
    }
}
