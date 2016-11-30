package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;
import java.util.List;

import adapter.MyViewPagerAdapter;

/**
 * Created by Administrator on 2016/11/29.
 */
public class MyOrderPageFragment extends FragmentActivity {
    private View view;
    private ViewPager viewPager;
    List<Fragment> list;
    MyViewPagerAdapter myViewPagerAdapter;

    private ImageView myOrder_back_img;
    private TextView daifahuo;
    private TextView daishouhuo;
    private TextView daipingjia;
    private View show_left;
    private View show_center;
    private View show_right;

    public MyOrderPageFragment() {

    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myorder_layout);

        //关联控件
        itemFindViewById();
        //设置点击事件
        itemSetOnClickListener();
        //设置viewPager页面
        setViewPager();
        myViewPagerAdapter = new MyViewPagerAdapter(getSupportFragmentManager(), list);
        viewPager.setAdapter(myViewPagerAdapter);
    }

    private void itemFindViewById() {
        myOrder_back_img = (ImageView) findViewById(R.id.myOrder_back_img);
        daifahuo = (TextView) findViewById(R.id.daifahuo);
        daishouhuo = (TextView) findViewById(R.id.daishouhuo);
        daipingjia = (TextView) findViewById(R.id.daipingjia);
        show_left = findViewById(R.id.show_left);
        show_center = findViewById(R.id.show_center);
        show_right = findViewById(R.id.show_right);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private void itemSetOnClickListener() {
        myOrder_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

        daifahuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setDefaultColor();
                //daifahuo.setTextColor(getResources().getColor(R.color.set_orange));
                show_left.setVisibility(View.VISIBLE);
                show_center.setVisibility(View.INVISIBLE);
                show_right.setVisibility(View.INVISIBLE);
                viewPager.setCurrentItem(0, true);
            }
        });
        daishouhuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setDefaultColor();
                //daipingjia.setTextColor(getResources().getColor(R.color.set_orange));
                show_left.setVisibility(View.INVISIBLE);
                show_center.setVisibility(View.VISIBLE);
                show_right.setVisibility(View.INVISIBLE);
                viewPager.setCurrentItem(1, true);
            }
        });
        daipingjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //setDefaultColor();
                //daipingjia.setTextColor(getResources().getColor(R.color.set_orange));
                show_left.setVisibility(View.INVISIBLE);
                show_center.setVisibility(View.INVISIBLE);
                show_right.setVisibility(View.VISIBLE);
                viewPager.setCurrentItem(2, true);
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position) {
                    case 0:
                        show_left.setVisibility(View.VISIBLE);
                        show_center.setVisibility(View.INVISIBLE);
                        show_right.setVisibility(View.INVISIBLE);
                        break;
                    case 1:
                        show_left.setVisibility(View.INVISIBLE);
                        show_center.setVisibility(View.VISIBLE);
                        show_right.setVisibility(View.INVISIBLE);
                        break;
                    case 2:
                        show_left.setVisibility(View.INVISIBLE);
                        show_center.setVisibility(View.INVISIBLE);
                        show_right.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    /*private void setDefaultColor() {
        daifahuo.setTextColor(getResources().getColor(R.color.set_black));
        daishouhuo.setTextColor(getResources().getColor(R.color.set_black));
        daipingjia.setTextColor(getResources().getColor(R.color.set_black));
        show_right.setVisibility(View.INVISIBLE);
        show_left.setVisibility(View.INVISIBLE);
        show_center.setVisibility(View.INVISIBLE);
    }*/

    private void setViewPager() {
        list = new ArrayList<>();
        list.add(new MyOrderSubLayout01());
        list.add(new MyOrderSubLayout02());
        list.add(new MyOrderSubLayout03());
    }
}
