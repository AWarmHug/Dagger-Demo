package com.warm.dagger_demo.presenter;

import com.warm.dagger_demo.bean.BaseEntity;
import com.warm.dagger_demo.bean.Data;
import com.warm.dagger_demo.data.DataCentre;
import com.warm.dagger_demo.view.MainView;

import java.util.List;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Consumer;
import io.reactivex.functions.Function;
import io.reactivex.functions.Predicate;
import io.reactivex.schedulers.Schedulers;

/**
 * 作者: 51hs_android
 * 时间: 2017/7/22
 * 简介:
 */

public class MainPresenter extends BasePresenter {

    private MainView mMainView;
    private DataCentre mDataCentre;

    @Inject
    public MainPresenter(DataCentre dataCentre) {
        this.mDataCentre = dataCentre;
    }

    @Override
    public void attach(MainView view) {
        this.mMainView=view;
    }




    public void getInfo() {
        mDataCentre.getDate("Android")
                .filter(new Predicate<BaseEntity<List<Data>>>() {
                    @Override
                    public boolean test(@NonNull BaseEntity<List<Data>> listBaseEntity) throws Exception {
                        return !listBaseEntity.isError();
                    }
                })
                .map(new Function<BaseEntity<List<Data>>, List<Data>>() {
                    @Override
                    public List<Data> apply(@NonNull BaseEntity<List<Data>> listBaseEntity) throws Exception {
                        return listBaseEntity.getResults();
                    }
                })
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<List<Data>>() {
                    @Override
                    public void accept(@NonNull List<Data> datas) throws Exception {
                        mMainView.getInfoSuccess(datas);
                    }
                });
    }


}
