package com.warm.dagger_demo.di.components;


import com.warm.dagger_demo.presenter.MainPresenter;

import dagger.Component;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/22
 * 简介:
 */
@Component
public interface MainModelComponent {


    void inject(MainPresenter presenter);


}
