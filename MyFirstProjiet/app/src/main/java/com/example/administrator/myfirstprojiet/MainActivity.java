package com.example.administrator.myfirstprojiet;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import adapter.MyFragmentPageAdapter;


public class MainActivity extends AppCompatActivity implements RadioGroup.OnCheckedChangeListener, ViewPager.OnPageChangeListener {
    private RadioGroup radioGroupTotal;
    private RadioButton menuBottomHomepageTv;
    private RadioButton menuBottomShoppingTv;
    private RadioButton menuBottomCircleTv;
    private RadioButton menuBottomMyTv;
    private ViewPager viewPager;

    private MyFragmentPageAdapter fragmentPageAdapter;

    //几个代表页面的常量
    public static final int PAGE_ONE = 0;
    public static final int PAGE_TWO = 1;
    public static final int PAGE_THREE = 2;
    public static final int PAGE_FOUR = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_bottom);
        fragmentPageAdapter = new MyFragmentPageAdapter(getSupportFragmentManager());

        bindView();
        menuBottomHomepageTv.setChecked(true);
    }

    private void bindView() {
        radioGroupTotal = (RadioGroup) findViewById(R.id.radioGroup_total);
        menuBottomHomepageTv = (RadioButton) findViewById(R.id.menuBottom_homepage_tv);
        menuBottomShoppingTv = (RadioButton) findViewById(R.id.menuBottom_shopping_tv);
        menuBottomCircleTv = (RadioButton) findViewById(R.id.menuBottom_circle_tv);
        menuBottomMyTv = (RadioButton) findViewById(R.id.menuBottom_my_tv);

        radioGroupTotal.setOnCheckedChangeListener(this);       //radiogroup的点击改变事件

        viewPager = (ViewPager) findViewById(R.id.viewpager);
        viewPager.setAdapter(fragmentPageAdapter);
        viewPager.setCurrentItem(0);
        viewPager.addOnPageChangeListener(this);
    }

    //重写ViewPager页面切换的处理方法
    @Override
    public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
        switch (checkedId) {
            case R.id.menuBottom_homepage_tv:
                viewPager.setCurrentItem(PAGE_ONE);
                break;
            case R.id.menuBottom_shopping_tv:
                viewPager.setCurrentItem(PAGE_TWO);
                break;
            case R.id.menuBottom_circle_tv:
                viewPager.setCurrentItem(PAGE_THREE);
                break;
            case R.id.menuBottom_my_tv:
                viewPager.setCurrentItem(PAGE_FOUR);
                break;
        }
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {

    }

    @Override
    public void onPageScrollStateChanged(int state) {
        //state的状态有三个，0表示什么都没做，1正在滑动，2滑动完毕
        if (state == 2) {
            switch (viewPager.getCurrentItem()) {
                case PAGE_ONE:
                    menuBottomHomepageTv.setChecked(true);
                    break;
                case PAGE_TWO:
                    menuBottomShoppingTv.setChecked(true);
                    break;
                case PAGE_THREE:
                    menuBottomCircleTv.setChecked(true);
                    break;
                case PAGE_FOUR:
                    menuBottomMyTv.setChecked(true);
                    break;
            }
        }
    }
}
