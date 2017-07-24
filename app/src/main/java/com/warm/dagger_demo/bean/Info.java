package com.warm.dagger_demo.bean;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/22
 * 简介:
 */

public class Info {
    private String name;
    private int age;

    public Info(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Info{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
