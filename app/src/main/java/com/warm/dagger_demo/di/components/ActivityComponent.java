package com.warm.dagger_demo.di.components;

import com.warm.dagger_demo.MainActivity;
import com.warm.dagger_demo.di.modules.ActivityModule;
import com.warm.dagger_demo.di.scopes.ActivityScope;

import dagger.Component;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/22
 * 简介:
 */
@ActivityScope
@Component(dependencies = AppComponent.class,modules = ActivityModule.class)
public interface ActivityComponent {


    void inject(MainActivity activity);

}
