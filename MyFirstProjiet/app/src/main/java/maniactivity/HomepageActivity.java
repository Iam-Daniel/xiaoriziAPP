package maniactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;
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
                fragmentTransaction.replace(R.id.fragment,worldPageFragment);
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
}
