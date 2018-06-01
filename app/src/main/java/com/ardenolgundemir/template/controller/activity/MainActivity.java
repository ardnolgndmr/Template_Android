package com.ardenolgundemir.template.controller.activity;

import android.os.Bundle;

import com.ardenolgundemir.template.R;
import com.ardenolgundemir.template.api.model.UserModel;
import com.ardenolgundemir.template.controller.BaseActivity;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by ardenolgundemir on 1.06.2018.
 */

public class MainActivity extends BaseActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        getService().getUser("ardnolgndmr")
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<UserModel>() {
            @Override
            public void call(UserModel userModel) {
                    if (userModel != null){

                    }
            }
        }, throwable -> {});
    }
}
