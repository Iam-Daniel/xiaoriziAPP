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
 * Created by Administrator on 2016/11/29.
 */
public class MyOrderPageFragment extends BaseFragment {
    private View view;
    private ViewPager viewPager;
    List<Fragment> list;
    private TextView daifahuo;
    private TextView daishouhuo;
    private TextView daipingjia;
    private View show_left;
    private View show_center;
    private View show_right;

    public MyOrderPageFragment() {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.myorder_layout, container, false);
        setViewPager();
        itemFindViewById();

        {
            MyViewPagerAdapter myViewPagerAdapter = new MyViewPagerAdapter(getChildFragmentManager(), list);
            viewPager.setAdapter(myViewPagerAdapter);
        }
        itemSetOnClickListener();
        return view;
    }

    private void itemFindViewById() {
        daifahuo = (TextView) view.findViewById(R.id.daifahuo);
        daishouhuo = (TextView) view.findViewById(R.id.daishouhuo);
        daipingjia = (TextView) view.findViewById(R.id.daipingjia);
        show_left = view.findViewById(R.id.show_left);
        show_right = view.findViewById(R.id.show_right);
        show_center = view.findViewById(R.id.show_center);
        viewPager = (ViewPager) view.findViewById(R.id.viewPager);
    }

    private void itemSetOnClickListener() {
        daifahuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDefaultColor();
                daifahuo.setTextColor(getResources().getColor(R.color.set_orange));
                show_left.setVisibility(View.VISIBLE);
                viewPager.setCurrentItem(0, true);
            }
        });
        daipingjia.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setDefaultColor();
                daipingjia.setTextColor(getResources().getColor(R.color.set_orange));
                show_right.setVisibility(View.VISIBLE);
                viewPager.setCurrentItem(1, true);
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
                        setDefaultColor();
                        daishouhuo.setTextColor(getResources().getColor(R.color.set_orange));
                        show_left.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        setDefaultColor();
                        daifahuo.setTextColor(getResources().getColor(R.color.set_orange));
                        show_right.setVisibility(View.VISIBLE);
                        break;
                    case 2:
                        setDefaultColor();
                        daipingjia.setTextColor(getResources().getColor(R.color.set_orange));
                        show_right.setVisibility(View.VISIBLE);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private void setDefaultColor() {
        daifahuo.setTextColor(getResources().getColor(R.color.set_black));
        daishouhuo.setTextColor(getResources().getColor(R.color.set_black));
        daipingjia.setTextColor(getResources().getColor(R.color.set_black));
        show_right.setVisibility(View.INVISIBLE);
        show_left.setVisibility(View.INVISIBLE);
        show_center.setVisibility(View.INVISIBLE);
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
