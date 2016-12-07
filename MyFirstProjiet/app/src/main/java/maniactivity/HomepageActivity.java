package maniactivity;

import android.Manifest;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.view.View;
import android.widget.RadioButton;
import android.widget.Toast;

import com.example.administrator.myfirstprojiet.R;

import fragment.HomepageFragment;
import fragment.MyHomepageFragment;
import fragment.SearchFragment;
import fragment.WorldPageFragment;

/**
 * Created by Administrator on 2016/10/29.
 */
public class HomepageActivity extends FragmentActivity {
    RadioButton menuBottom_homepage_tv;
    RadioButton menuBottom_shopping_tv;
    RadioButton menuBottom_circle_tv;
    RadioButton menuBottom_my_tv;
    HomepageFragment homepageFragment;
    WorldPageFragment worldPageFragment;
    MyHomepageFragment myHomepageFragment;
    SearchFragment searchFragment;
    FragmentManager fragmentManager;
    FragmentTransaction fragmentTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_page);
        //关联控件
        itemFindViewById();
        //设置监听事件
        itemSetOnClickListener();
        setDefaultFragment();
        if (Build.VERSION.SDK_INT > 23) {
            this.requestPermissions(new String[]{Manifest.permission.INTERNET}, 1);
        }
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    private void setDefaultFragment() {
        fragmentManager = getSupportFragmentManager();
        homepageFragment = new HomepageFragment();
        worldPageFragment = new WorldPageFragment();
        myHomepageFragment = new MyHomepageFragment();
        searchFragment = new SearchFragment();
        fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(R.id.fragment, homepageFragment);
        fragmentTransaction.commit();
        menuBottom_homepage_tv.setChecked(true);
    }

    private void itemFindViewById() {
        menuBottom_homepage_tv = (RadioButton) findViewById(R.id.menuBottom_homepage_tv);
        menuBottom_shopping_tv = (RadioButton) findViewById(R.id.menuBottom_shopping_tv);
        menuBottom_circle_tv = (RadioButton) findViewById(R.id.menuBottom_circle_tv);
        menuBottom_my_tv = (RadioButton) findViewById(R.id.menuBottom_my_tv);
    }

    private void itemSetOnClickListener() {
        //首页
        menuBottom_homepage_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, homepageFragment);
                fragmentTransaction.commit();
            }
        });
        //商城
        menuBottom_shopping_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, searchFragment);
                fragmentTransaction.commit();
            }
        });
        //圈子
        menuBottom_circle_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, worldPageFragment);
                fragmentTransaction.commit();
            }
        });
        //我的
        menuBottom_my_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentTransaction = fragmentManager.beginTransaction();
                fragmentTransaction.replace(R.id.fragment, myHomepageFragment);
                fragmentTransaction.commit();
            }
        });
    }


    private long exitTime = 0;

    /**
     * 捕捉返回事件按钮
     * <p>
     * 因为此 Activity 继承 TabActivity 用 onKeyDown 无响应，所以改用 dispatchKeyEvent
     * 一般的 Activity 用 onKeyDown 就可以了
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
            if (event.getAction() == KeyEvent.ACTION_DOWN && event.getRepeatCount() == 0) {
                this.exitApp();
            }
            return true;
        }
        return super.dispatchKeyEvent(event);
    }

    /**
     * 退出程序
     */
    private void exitApp() {
        // 判断2次点击事件时间
        if ((System.currentTimeMillis() - exitTime) > 2000) {
            //-------------Activity.this的context 返回当前activity的上下文，属于activity，activity 摧毁他就摧毁
            //-------------getApplicationContext() 返回应用的上下文，生命周期是整个应用，应用摧毁它才摧毁
            Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
            exitTime = System.currentTimeMillis();
        } else {
            finish();
        }
    }

    /**
     * 点击2次退出程序的另一种写法
     */
   /* @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if(keyCode == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN){
            if((System.currentTimeMillis()-exitTime) > 2000){
                Toast.makeText(getApplicationContext(), "再按一次退出程序", Toast.LENGTH_SHORT).show();
                exitTime = System.currentTimeMillis();
            } else {
                finish();
                System.exit(0);
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }*/
}
