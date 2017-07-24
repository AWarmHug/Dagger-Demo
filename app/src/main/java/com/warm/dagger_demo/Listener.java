package com.warm.dagger_demo;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/24
 * 简介:
 */

public interface Listener<T> {
    void success(T t);
    void fail();


}
