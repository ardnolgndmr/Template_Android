package com.ardenolgundemir.template.controller;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.view.inputmethod.InputMethodManager;
import android.widget.TextView;
import android.widget.Toast;


import com.ardenolgundemir.template.R;
import com.ardenolgundemir.template.api.WebServices;
import com.ardenolgundemir.template.root.ApiModule;
import com.ardenolgundemir.template.root.App;
import com.ardenolgundemir.template.root.ApplicationComponent;
import com.ardenolgundemir.template.root.DaggerApplicationComponent;
import com.ardenolgundemir.template.utility.Constant;

import javax.inject.Inject;

/**
 * Created by ardenolgundemir on 01/06/2017.
 */

public class BaseActivity extends AppCompatActivity {
    @Inject
    WebServices webServices;
    private App app;
    private ApplicationComponent component;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        app = (App) getApplication();
        component = DaggerApplicationComponent.builder()
                .iMAppComponent(app.component())
                .apiModule(new ApiModule())
                .build();
        component.inject(this);
    }


    public WebServices getService() {
        return this.webServices;
    }


    public void showProgresDialog(Activity activity) {
        try{
            Constant.progressDialog = new ProgressDialog(activity);
            Constant.progressDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
            Constant.progressDialog.setMessage(getResources().getString(R.string.dialog_waiting_message));
            Constant.progressDialog.setCancelable(false);
            Constant.progressDialog.show();
        }catch (Exception e){

        }


    }

    public void dismissProgressDialog() {
        if (Constant.progressDialog != null){
            if (Constant.progressDialog.isShowing()){
                Constant.progressDialog.dismiss();
            }
        }
    }


    @TargetApi(11)
    protected void alert(String title, final String msg, final boolean exit) {
       AlertDialog alt = new AlertDialog.Builder(this).create();
        alt.setTitle(title);
        alt.setMessage(msg);
        alt.setButton(AlertDialog.BUTTON_NEUTRAL, getString(R.string.ok),
                (arg0, arg1) -> {
                    if (exit) {
                        finish();
                    }
                });

        alt.show();
        alt.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(Color.BLACK);

    }
    protected void alertShow(String Message) {
        final AlertDialog alt = new AlertDialog.Builder(this).create();
        alt.requestWindowFeature(Window.FEATURE_NO_TITLE); // before
        alt.setMessage(Message);
        alt.setButton(AlertDialog.BUTTON_NEUTRAL, getString(R.string.ok),
                (arg0, arg1) -> alt.dismiss());

        alt.show();
        alt.getButton(AlertDialog.BUTTON_NEUTRAL).setTextColor(Color.BLACK);

    }


    public boolean isConnectingToInternet() {
        ConnectivityManager connectivity = (ConnectivityManager) this.getApplicationContext()
                .getSystemService(Context.CONNECTIVITY_SERVICE);
        if (connectivity != null) {
            NetworkInfo[] info = connectivity.getAllNetworkInfo();
            if (info != null)
                for (int i = 0; i < info.length; i++)
                    if (info[i].getState() == NetworkInfo.State.CONNECTED) {
                        return true;
                    }

        }
        alert(getString(R.string.dialog_internet_title),
                getString(R.string.dialog_internet_message), false);
        return false;
    }


    public void keyboardClose(Activity activity) {
        View view = activity.getCurrentFocus();
        if (view != null) {
            InputMethodManager imm = (InputMethodManager) activity.getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }
    }

    protected void Toast(String Message) {
        Toast.makeText(getApplicationContext(), Message, Toast.LENGTH_SHORT)
                .show();
    }
}
