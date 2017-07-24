package com.warm.dagger_demo.view;

import com.warm.dagger_demo.bean.Data;
import com.warm.dagger_demo.bean.Info;

import java.util.List;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/22
 * 简介:
 */

public interface MainView {


    void clearInfo();
    void getInfoSuccess(List<Data> datas);
}
