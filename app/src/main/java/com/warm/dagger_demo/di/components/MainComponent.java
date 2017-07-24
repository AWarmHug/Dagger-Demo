package com.warm.dagger_demo.di.components;

import com.warm.dagger_demo.MainActivity;
import com.warm.dagger_demo.di.modules.MainModule;
import com.warm.dagger_demo.view.MainView;

import dagger.Component;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/22
 * 简介:
 */
@Component(modules = MainModule.class)
public interface MainComponent {


    void inject(MainActivity activity);

}
