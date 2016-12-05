package maniactivity;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.AssetManager;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

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
    RelativeLayout aboutUsRelative;

    RelativeLayout cleanCache;
    TextView exitNumbTextView;
    private Context mContext = SetPassWordPageActivity.this;
    private AlertDialog alert = null;
    private AlertDialog.Builder builder = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setpassword_layout);
        setPasswordToNumber = (RelativeLayout) findViewById(R.id.setpassword_to_number);
        setPasswordToPassWork = (RelativeLayout) findViewById(R.id.setpassword_to_passwork);
        setPasswordToAddress = (RelativeLayout) findViewById(R.id.setpassword_to_address);
        aboutUsRelative = (RelativeLayout) findViewById(R.id.aboutUs_Relative);
        cleanCache = (RelativeLayout) findViewById(R.id.clean_cache);

        exitNumbTextView = (TextView) findViewById(R.id.exitNumb_textView);//退出当前账号id
        exitNumbTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                builder = new AlertDialog.Builder(mContext);
                alert = builder.setTitle("友情提示：")
                        .setIcon(R.mipmap.sun)
                        .setMessage("确定退出当前按钮？\n退出后需重新登录，确定退出？")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Toast.makeText(mContext, "你点击了取消按钮~", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Toast.makeText(mContext, "你点击了确定按钮~", Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                alert.show();
            }
        });
//        跳转到关于我们页面
        aboutUsRelative.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(SetPassWordPageActivity.this, AboutUsPageActivity.class));
                //finish();
            }
        });

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
                //finish();
            }
        });
//        跳转到设置密码页面
        setPasswordToPassWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SetPassWordPageActivity.this, PassWorkPageActivity.class);
                //finish();
            }
        });
//        跳转到收货地址页面
        setPasswordToAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SetPassWordPageActivity.this, AddressPageActivity.class);
                //finish();
            }
        });
        //清除缓存点击事件
        cleanCache.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataCleanManager dataCleanManager = new DataCleanManager();
                //dataCleanManager.cleanInternalCache(context);
                builder = new AlertDialog.Builder(mContext);
                alert = builder.setIcon(R.mipmap.sun)
                        .setTitle("友情提示")
                        .setMessage("确定清除缓存？\n清除缓存后......")
                        .setNegativeButton("取消", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(mContext, "缓存还存在哦~", Toast.LENGTH_SHORT).show();
                            }
                        })
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                //Toast.makeText(mContext, "你点击了确定按钮~", Toast.LENGTH_SHORT).show();
                            }
                        }).create();
                alert.show();
            }
        });
    }
    /** 文 件 名:  DataCleanManager.java
     *  描    述: 主要功能有清除内/外缓存，清除数据库，清除sharedPreference，清除files和清除自定义目录
     */
}
