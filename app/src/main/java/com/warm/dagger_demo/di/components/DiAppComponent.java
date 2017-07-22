package com.warm.dagger_demo.di.components;

import android.content.Context;

import com.warm.dagger_demo.di.modules.DiAppModule;

import javax.inject.Singleton;

import dagger.Component;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/22
 * 简介:
 */
@Component(modules = DiAppModule.class)
public interface DiAppComponent {

    Context getContext();

}
