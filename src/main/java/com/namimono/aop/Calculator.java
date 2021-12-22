package com.namimono.aop;

public class Calculator {
//test
    @LogAopAnnotation
    public Integer add(int a,int b){
        System.out.println("adding..........");
        return a+b;
    }
}
