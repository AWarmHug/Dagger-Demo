package com.warm.dagger_demo;

import javax.inject.Inject;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/22
 * 简介:
 */
public class Action {
    @Inject
    public Action() {
    }

    public void sayHello(){
        System.out.println("Hello");
    }

}
