package com.example.administrator.myfirstprojiet;

import android.os.Bundle;
import acativity.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myhomepage_layout);

       // startActivity(MainActivity.this,cls);
    }
}
