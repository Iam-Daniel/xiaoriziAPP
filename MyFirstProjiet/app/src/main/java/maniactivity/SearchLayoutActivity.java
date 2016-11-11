package maniactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class SearchLayoutActivity extends BaseActivity {
    TextView searchMoreTv;
    ImageView searchShoppingCartImg;
    TextView hongpei;
    TextView shengxian;
    TextView qiju;
    TextView tiaowei;
    TextView fangbian;
    TextView ganhuo;
    TextView yinping;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
        hongpei = (TextView)findViewById(R.id.hongpei);
        hongpei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this,ShoppingActivity.class);
                startActivity(intent);
            }
        });
        shengxian = (TextView)findViewById(R.id.shengxian);
        shengxian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this,ShoppingActivity.class);
                startActivity(intent);
            }
        });
        qiju = (TextView)findViewById(R.id.qiju);
        qiju.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this,ShoppingActivity.class);
                startActivity(intent);
            }
        });
        tiaowei = (TextView)findViewById(R.id.tiaowei);
        tiaowei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this,ShoppingActivity.class);
                startActivity(intent);
            }
        });
        fangbian = (TextView)findViewById(R.id.fangbian);
        fangbian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this,ShoppingActivity.class);
                startActivity(intent);
            }
        });
        ganhuo = (TextView)findViewById(R.id.ganhuo);
        ganhuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this,ShoppingActivity.class);
                startActivity(intent);
            }
        });
        yinping = (TextView)findViewById(R.id.yinping);
        yinping.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this,ShoppingActivity.class);
                startActivity(intent);
            }
        });


//        跳转到更多页面
        searchMoreTv = (TextView) findViewById(R.id.search_more_tv);
        searchMoreTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SearchLayoutActivity.this,MorePageActivity.class);
            }
        });
//        跳转到购物车页面
        searchShoppingCartImg = (ImageView) findViewById(R.id.search_shoppingCart_img);
        searchShoppingCartImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SearchLayoutActivity.this,ShoppingCartPageActivity.class);
            }
        });
    }
}
