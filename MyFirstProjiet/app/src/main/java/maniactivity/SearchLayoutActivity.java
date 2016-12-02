package maniactivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;
import java.util.List;

import activity.BaseActivity;
import adapter.ListViewAdapter;

/**
 * Created by Administrator on 2016/10/29.
 */
public class SearchLayoutActivity extends BaseActivity {
    TextView searchMoreTv;
    ImageView searchShoppingCartImg;
    TextView hongPei;
    TextView shengXian;
    TextView qiJu;
    TextView tiaoWei;
    TextView fangBian;
    TextView ganHuo;
    TextView yinPing;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
        itemFindViewById();
        itemSetOnClickListener();

    }

    private void itemFindViewById() {
        hongPei = (TextView) findViewById(R.id.hongpei);
        shengXian = (TextView) findViewById(R.id.shengxian);
        qiJu = (TextView) findViewById(R.id.qiju);
        tiaoWei = (TextView) findViewById(R.id.tiaowei);
        fangBian = (TextView) findViewById(R.id.fangbian);
        ganHuo = (TextView) findViewById(R.id.ganhuo);
        yinPing = (TextView) findViewById(R.id.yinping);
        searchMoreTv = (TextView) findViewById(R.id.search_more_tv);
        searchShoppingCartImg = (ImageView) findViewById(R.id.search_shoppingCart_img);
    }


    private void itemSetOnClickListener() {
        hongPei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this, ShoppingActivity.class);
                startActivity(intent);
            }
        });

        shengXian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this, ShoppingActivity.class);
                startActivity(intent);
            }
        });

        qiJu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this, ShoppingActivity.class);
                startActivity(intent);
            }
        });

        tiaoWei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this, ShoppingActivity.class);
                startActivity(intent);
            }
        });

        fangBian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this, ShoppingActivity.class);
                startActivity(intent);
            }
        });

        ganHuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this, ShoppingActivity.class);
                startActivity(intent);
            }
        });

        yinPing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this, ShoppingActivity.class);
                startActivity(intent);
            }
        });

//        跳转到更多页面

        searchMoreTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SearchLayoutActivity.this, MorePageActivity.class);
            }
        });
//        跳转到购物车页面

        searchShoppingCartImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SearchLayoutActivity.this, ShoppingCartPageActivity.class);
            }
        });
    }
}
