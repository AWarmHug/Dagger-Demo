package com.warm.dagger_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.warm.dagger_demo.adapter.DataAdapter;
import com.warm.dagger_demo.bean.Data;
import com.warm.dagger_demo.di.components.DaggerActivityComponent;
import com.warm.dagger_demo.presenter.MainPresenter;
import com.warm.dagger_demo.view.MainView;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView{

    @Inject
    MainPresenter mMainPresenter;

    private RecyclerView mRv;

    private  DataAdapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerActivityComponent.builder().appComponent(DiApp.getAppComponent()).build().inject(this);
        mMainPresenter.attach(this);


        mRv= (RecyclerView) this.findViewById(R.id.rv);
        List<Data> datas=new ArrayList<>();
        mAdapter =new DataAdapter(datas);
        mRv.setAdapter(mAdapter);
        mRv.setLayoutManager(new LinearLayoutManager(this));
        mMainPresenter.getInfo();

    }




    @Override
    public void getInfoSuccess(List<Data> datas) {
        mAdapter.refreshAll(datas);

    }
}
