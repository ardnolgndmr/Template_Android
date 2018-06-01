package com.ardenolgundemir.template;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.ardenolgundemir.template.controller.activity.MainActivity;
import com.ardenolgundemir.template.utility.SharedPref;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        onOpenApp();

    }

    void onOpenApp(){
        Handler handler = new Handler();
        handler.postDelayed(() -> {
             startActivity(new Intent(SplashActivity.this, MainActivity.class));


            finish();
        }, 500);
    }
}
