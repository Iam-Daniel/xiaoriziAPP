package fragment;


import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import maniactivity.BaseFragment;
import maniactivity.MorePageActivity;
import maniactivity.ShoppingActivity;
import maniactivity.ShoppingCartPageActivity;

/**
 * Created by Administrator on 2016/11/25.
 */
public class SearchFragment extends BaseFragment {
    TextView searchMoreTv;
    ImageView searchShoppingCartImg;
    TextView hongPei;
    TextView shengXian;
    TextView qiJu;
    TextView tiaoWei;
    TextView fangBian;
    TextView ganHuo;
    TextView yinPing;
    View view;


    public SearchFragment() {

    }

    @Override
    protected int setLayoutResouceId() {
        return 0;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_layout, container, false);
        itemFindViewById();
        itemSetOnClickListener();
        return view;
    }


    private void itemFindViewById() {
        hongPei = (TextView) view.findViewById(R.id.hongpei);
        shengXian = (TextView) view.findViewById(R.id.shengxian);
        qiJu = (TextView) view.findViewById(R.id.qiju);
        tiaoWei = (TextView) view.findViewById(R.id.tiaowei);
        fangBian = (TextView) view.findViewById(R.id.fangbian);
        ganHuo = (TextView) view.findViewById(R.id.ganhuo);
        yinPing = (TextView) view.findViewById(R.id.yinping);
        searchMoreTv = (TextView) view.findViewById(R.id.search_more_tv);
        searchShoppingCartImg = (ImageView) view.findViewById(R.id.search_shoppingCart_img);
    }

    private void itemSetOnClickListener() {
        hongPei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingActivity.class);
                startActivity(intent);
            }
        });

        shengXian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingActivity.class);
                startActivity(intent);
            }
        });

        qiJu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingActivity.class);
                startActivity(intent);
            }
        });

        tiaoWei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingActivity.class);
                startActivity(intent);
            }
        });

        fangBian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingActivity.class);
                startActivity(intent);
            }
        });

        ganHuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingActivity.class);
                startActivity(intent);
            }
        });

        yinPing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingActivity.class);
                startActivity(intent);
            }
        });
//        跳转到更多页面
        searchMoreTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MorePageActivity.class);
                startActivity(intent);
            }
        });
//        跳转到购物车页面
        searchShoppingCartImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingCartPageActivity.class);
                startActivity(intent);
            }
        });
    }
}
