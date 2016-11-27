package fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;
import java.util.List;

import adapter.MyViewPagerAdapter;
import maniactivity.BaseFragment;

/**
 * Created by Administrator on 2016/11/25.
 */


//自定义的BaseAdapter类
public class WorldPageFragment extends BaseFragment {
    View view;
    List<Fragment> list;
    TextView around_title_left;
    TextView around_title_right;
    View show_right;
    View show_left;
    ViewPager viewPager;

    public WorldPageFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.world, container, false);
        setViewPager();
        itemFindViewById();
        {
            MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getChildFragmentManager(),list);
            viewPager.setAdapter(myViewPagerAdapter);
        }
        itemSetOnClickListener();
        return view;

    }

    private void itemFindViewById() {
        around_title_left = (TextView) view.findViewById(R.id.around_title_left);
        around_title_right = (TextView) view.findViewById(R.id.around_title_right);
        show_right = view.findViewById(R.id.show_right);
        show_left = view.findViewById(R.id.show_left);
        viewPager = (ViewPager)view.findViewById(R.id.viewPager);
    }

    private void itemSetOnClickListener() {
        around_title_left.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDefaultColor();
                around_title_left.setTextColor(getResources().getColor(R.color.set_orange));
                show_left.setVisibility(View.VISIBLE);
                viewPager.setCurrentItem(0,true);
            }
        });
        around_title_right.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDefaultColor();
                around_title_right.setTextColor(getResources().getColor(R.color.set_orange));
                show_right.setVisibility(View.VISIBLE);
                viewPager.setCurrentItem(1,true);
            }
        });
        viewPager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        setDefaultColor();
                        around_title_left.setTextColor(getResources().getColor(R.color.set_orange));
                        show_left.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        setDefaultColor();
                        around_title_right.setTextColor(getResources().getColor(R.color.set_orange));
                        show_right.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    //重置字体颜色为黑色，颜色标签为不可见
    private void setDefaultColor(){
        around_title_left.setTextColor(getResources().getColor(R.color.set_black));
        around_title_right.setTextColor(getResources().getColor(R.color.set_black));
        show_right.setVisibility(View.INVISIBLE);
        show_left.setVisibility(View.INVISIBLE);
    }

    private void setViewPager() {
        list = new ArrayList<>();
        list.add(new WorldConcern());
        list.add(new WorldAround());
    }

    @Override
    protected int setLayoutResouceId() {
        return 0;
    }
}
