package fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;
import java.util.List;

import adapter.MyViewPagerAdapter;

/**
 * Created by Administrator on 2016/10/29.
 */
public class KitchenPageFragment extends FragmentActivity {
    ImageView leftBack;
    List<Fragment> list;
    View gone_one_view;
    View gone_two_view;
    View gone_three_view;
    MyViewPagerAdapter myViewPagerAdapter;
    ViewPager viewPager;
    TextView remen;
    TextView tuijian;
    TextView zuixin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitchen_layout);
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
        leftBack = (ImageView) findViewById(R.id.left_back);
        gone_one_view = findViewById(R.id.gone_one_view);
        gone_two_view = findViewById(R.id.gone_two_view);
        gone_three_view = findViewById(R.id.gone_three_view);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
        remen = (TextView) findViewById(R.id.remen);
        tuijian = (TextView) findViewById(R.id.tuijian);
        zuixin = (TextView) findViewById(R.id.zuixin);
    }

    private void itemSetOnClickListener() {
        leftBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        remen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gone_two_view.setVisibility(View.INVISIBLE);
                gone_three_view.setVisibility(View.INVISIBLE);
                gone_one_view.setVisibility(View.VISIBLE);
                viewPager.setCurrentItem(0, true);
                Log.i("viewPager", "" + viewPager.getCurrentItem());
            }
        });
        tuijian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gone_one_view.setVisibility(View.INVISIBLE);
                gone_three_view.setVisibility(View.INVISIBLE);
                gone_two_view.setVisibility(View.VISIBLE);
                viewPager.setCurrentItem(1, true);
                Log.i("viewPager", "" + viewPager.getCurrentItem());
            }
        });
        zuixin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gone_two_view.setVisibility(View.INVISIBLE);
                gone_one_view.setVisibility(View.INVISIBLE);
                gone_three_view.setVisibility(View.VISIBLE);
                viewPager.setCurrentItem(2, true);
                Log.i("viewPager", "" + viewPager.getCurrentItem());
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
                        gone_two_view.setVisibility(View.INVISIBLE);
                        gone_three_view.setVisibility(View.INVISIBLE);
                        gone_one_view.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        gone_one_view.setVisibility(View.INVISIBLE);
                        gone_three_view.setVisibility(View.INVISIBLE);
                        gone_two_view.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        gone_two_view.setVisibility(View.INVISIBLE);
                        gone_one_view.setVisibility(View.INVISIBLE);
                        gone_three_view.setVisibility(View.VISIBLE);
                        break;

                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setViewPager() {
        list = new ArrayList<>();
        list.add(new KitchenSubLayout01());
        list.add(new KitchenSubLayout02());
        list.add(new KitchenSubLayout03());
    }
}
