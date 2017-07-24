package com.warm.dagger_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.warm.dagger_demo.bean.Info;
import com.warm.dagger_demo.di.components.DaggerMainComponent;
import com.warm.dagger_demo.di.modules.MainModule;
import com.warm.dagger_demo.presenter.MainPresenter;
import com.warm.dagger_demo.view.MainView;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity implements MainView,View.OnClickListener{

    @Inject
    MainPresenter mMainPresenter;

    private Button mBtGet;
    private TextView mTvInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainComponent.builder().mainModule(new MainModule(this)).build().inject(this);


        mBtGet= (Button) this.findViewById(R.id.bt_get);
        mBtGet.setOnClickListener(this);
        mTvInfo= (TextView) this.findViewById(R.id.tv_info);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_get:
                mMainPresenter.getInfo();
                break;
        }
    }

    @Override
    public void getInfoSuccess(Info info) {
        mTvInfo.append(info.toString());

    }
}
