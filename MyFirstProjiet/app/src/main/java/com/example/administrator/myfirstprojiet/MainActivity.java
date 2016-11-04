package com.example.administrator.myfirstprojiet;

import android.os.Bundle;
import activity.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_layout);
       // startActivity(MainActivity.this,cls);
    }
}
