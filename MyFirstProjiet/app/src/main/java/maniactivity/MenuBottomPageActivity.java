package maniactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/30.
 */
public class MenuBottomPageActivity extends BaseActivity {
    TextView menuBottomHomepageTv;
    TextView menuBottomShoppingTv;
    TextView menuBottomCircleTv;
    TextView menuBottomMyTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_bottom);

//        跳转到首页
        menuBottomHomepageTv = (TextView) findViewById(R.id.menuBottom_homepage_tv);
        menuBottomHomepageTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MenuBottomPageActivity.this,HomepageActivity.class);
            }
        });
//        跳转到搜索（市集）页面
        menuBottomShoppingTv = (TextView) findViewById(R.id.menuBottom_shopping_tv);
        menuBottomShoppingTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MenuBottomPageActivity.this,SearchLayoutActivity.class);
            }
        });
//        跳转到圈圈（关注我的圈子）页面
        menuBottomCircleTv = (TextView) findViewById(R.id.menuBottom_circle_tv);
        menuBottomCircleTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MenuBottomPageActivity.this,AroundPageActivity.class);
            }
        });
//        跳转到我的主页
        menuBottomMyTv = (TextView) findViewById(R.id.menuBottom_my_tv);
        menuBottomMyTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MenuBottomPageActivity.this,MyHomePageLayoutActivity.class);
            }
        });
    }
}
