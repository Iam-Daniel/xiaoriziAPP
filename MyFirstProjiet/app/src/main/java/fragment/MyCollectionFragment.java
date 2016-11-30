package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;
import java.util.List;

import adapter.MyViewPagerAdapter;

/**
 * Created by Administrator on 2016/11/30.
 */
public class MyCollectionFragment extends FragmentActivity {
    List<Fragment> list;
    MyViewPagerAdapter myViewPagerAdapter;

    private ImageView myCollection_back_img;
    private LinearLayout caipu;
    private LinearLayout caidan;
    private View show_left;
    private View show_right;
    private ViewPager viewPager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycollection_layout);

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
        myCollection_back_img = (ImageView) findViewById(R.id.myCollection_back_img);
        caipu = (LinearLayout) findViewById(R.id.caipu);
        caidan = (LinearLayout) findViewById(R.id.caidan);
        show_left = findViewById(R.id.show_left);
        show_right = findViewById(R.id.show_right);
        viewPager = (ViewPager) findViewById(R.id.viewPager);
    }

    private void itemSetOnClickListener() {
        myCollection_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        caipu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_left.setVisibility(View.VISIBLE);
                show_right.setVisibility(View.INVISIBLE);
                viewPager.setCurrentItem(0, true);
                Log.i("viewPager", "" + viewPager.getCurrentItem());
            }
        });
        caidan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                show_left.setVisibility(View.INVISIBLE);
                show_right.setVisibility(View.VISIBLE);
                viewPager.setCurrentItem(1, true);
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
                        show_right.setVisibility(View.INVISIBLE);
                        show_left.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        show_left.setVisibility(View.INVISIBLE);
                        show_right.setVisibility(View.VISIBLE);
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
        list.add(new MyCollectionPage01());
        list.add(new MyCollectionPage02());
    }
}
