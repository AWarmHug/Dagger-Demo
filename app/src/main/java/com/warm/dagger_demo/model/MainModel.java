package com.warm.dagger_demo.model;

import android.content.Context;

import com.warm.dagger_demo.bean.Info;

import javax.inject.Inject;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/22
 * 简介:
 */

public class MainModel {

    @Inject
    public MainModel() {
    }

    public Info getInfo(){
        return new Info("",19);
    }

}
