package com.warm.dagger_demo.presenter;

import com.warm.dagger_demo.di.components.DaggerMainModelComponent;
import com.warm.dagger_demo.model.MainModel;
import com.warm.dagger_demo.view.MainView;

import javax.inject.Inject;

import dagger.Provides;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/22
 * 简介:
 */

public class MainPresenter {

    private MainView mMainView;
    @Inject
    MainModel mainModel;

    @Inject
    MainPresenter(MainView mMainView) {
        this.mMainView = mMainView;
        DaggerMainModelComponent.builder().build().inject(this);
    }


    public void getInfo(){
        mMainView.getInfoSuccess( mainModel.getInfo());
    }


}
