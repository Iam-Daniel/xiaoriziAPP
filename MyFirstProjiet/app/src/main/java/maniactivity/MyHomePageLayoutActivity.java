package maniactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class MyHomePageLayoutActivity extends BaseActivity {
    LinearLayout myHomepageConcernLinear;
    LinearLayout myHomepageFansLinear;
    TextView informationTextView;
    LinearLayout myHomepageOrderImg;
    ImageView leftBack;
    LinearLayout myHomepageCollectionImg;
    LinearLayout myHomepageDiscountImg;
    LinearLayout myHomepageStatisticsImg;
    RelativeLayout myHomepageMyWorksRtl;
    RelativeLayout myHomepageMyMenuRtl;
    RelativeLayout myHomepageSetRtl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myhomepage_layout);
        leftBack = (ImageView) findViewById(R.id.left_back);
        leftBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

//        点击跳转到我的关注页面
        myHomepageConcernLinear = (LinearLayout) findViewById(R.id.myHomepage_concern_linear);
        myHomepageConcernLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this, MyConcernPageActivity.class);
            }
        });
//        点击跳转到我的粉丝页面
        myHomepageFansLinear = (LinearLayout) findViewById(R.id.myHomepage_fans_linear);
        myHomepageFansLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this, MyFansPageActivity.class);
            }
        });
//        点击跳转到编辑资料页面
        informationTextView = (TextView) findViewById(R.id.myHomepage_information_textView);
        informationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this, EditDataPageActivity.class);
            }
        });
//        点击跳转到我的订单页面
        myHomepageOrderImg = (LinearLayout) findViewById(R.id.myHomepage_order_img);
        myHomepageOrderImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this, MyOrderPageActivity.class);
            }
        });
//        点击跳转到我的收藏页面
        myHomepageCollectionImg = (LinearLayout) findViewById(R.id.myHomepage_collection_img);
        myHomepageCollectionImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this, MyCollectionPageActivity.class);
            }
        });
//        点击跳转到优惠页面
        myHomepageDiscountImg = (LinearLayout) findViewById(R.id.myHomepage_discount_img);
        myHomepageDiscountImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this, DiscountPageActivity.class);
            }
        });
//        点击跳转到统计页面
        myHomepageStatisticsImg = (LinearLayout) findViewById(R.id.myHomepage_statistics_img);
        myHomepageStatisticsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this, StatisticsPageActivity.class);
            }
        });
//        点击跳转到我的作品
        myHomepageMyWorksRtl = (RelativeLayout) findViewById(R.id.myHomepage_myWorks_rtl);
        myHomepageMyWorksRtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this, MyWorksPageActivity.class);
            }
        });
//        点击跳转到我的菜谱
        myHomepageMyMenuRtl = (RelativeLayout) findViewById(R.id.myHomepage_myMenu_rtl);
        myHomepageMyMenuRtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this, MyMenuPageActivity.class);
            }
        });
//        点击跳转到设置页面
        myHomepageSetRtl = (RelativeLayout) findViewById(R.id.myHomepage_set_rtl);
        myHomepageSetRtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this, SetPassWordPageActivity.class);
            }
        });
        //底部菜单-跳转到首页
        TextView home = (TextView) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyHomePageLayoutActivity.this, HomepageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //底部菜单-跳转到商城
        TextView buy = (TextView) findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyHomePageLayoutActivity.this, SearchLayoutActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //底部菜单-跳转到关注
        TextView concern = (TextView) findViewById(R.id.concern);
        concern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MyHomePageLayoutActivity.this, ConcernPageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //底部菜单-跳转到我
        TextView account = (TextView) findViewById(R.id.account);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            }
        });
    }
}
