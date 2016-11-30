package maniactivity;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;
import listclass.DataCleanManager;

/**
 * Created by Administrator on 2016/10/29.
 */
public class SetPassWordPageActivity extends BaseActivity {
    Context context;

    ImageView setPasswordBackImg;
    RelativeLayout setPasswordToNumber;
    RelativeLayout setPasswordToPassWork;
    RelativeLayout setPasswordToAddress;
    RelativeLayout cleanCache;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setpassword_layout);
        setPasswordToNumber = (RelativeLayout) findViewById(R.id.setpassword_to_number);
        setPasswordToPassWork = (RelativeLayout) findViewById(R.id.setpassword_to_passwork);
        setPasswordToAddress = (RelativeLayout) findViewById(R.id.setpassword_to_address);
        cleanCache = (RelativeLayout) findViewById(R.id.clean_cache);

//        返回到我的主页
        setPasswordBackImg = (ImageView) findViewById(R.id.setPassword_back_img);
        setPasswordBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//                startActivity(SetPassWordPageActivity.this, MyHomePageLayoutActivity.class);
                finish();
            }
        });
//        跳转到账号管理页面
        setPasswordToNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SetPassWordPageActivity.this, NumberPageActivity.class);
                finish();
            }
        });
//        跳转到设置密码页面
        setPasswordToPassWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SetPassWordPageActivity.this, PassWorkPageActivity.class);
                finish();
            }
        });
//        跳转到收货地址页面
        setPasswordToAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SetPassWordPageActivity.this, AddressPageActivity.class);
                finish();
            }
        });
        //清除缓存点击事件
        cleanCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataCleanManager dataCleanManager = new DataCleanManager();
                //dataCleanManager.cleanInternalCache(context);
            }
        });
    }
    /** 文 件 名:  DataCleanManager.java
     *  描    述: 主要功能有清除内/外缓存，清除数据库，清除sharedPreference，清除files和清除自定义目录
     */
}
