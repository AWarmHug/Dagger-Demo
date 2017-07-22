package com.warm.dagger_demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.warm.dagger_demo.di.components.DaggerMainComponent;

import javax.inject.Inject;

public class MainActivity extends AppCompatActivity {
    @Inject
    Action mAction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DaggerMainComponent.builder().build().inject(this);

        mAction.sayHello();

    }
}
