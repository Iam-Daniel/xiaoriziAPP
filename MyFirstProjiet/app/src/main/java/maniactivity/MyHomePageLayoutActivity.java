package maniactivity;

import android.app.Activity;
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
    ImageView myHomepageOrderImg;
    ImageView myHomepageCollectionImg;
    ImageView myHomepageDiscountImg;
    ImageView myHomepageStatisticsImg;
    RelativeLayout myHomepageMyWorksRtl;
    RelativeLayout myHomepageMyMenuRtl;
    RelativeLayout myHomepageSetRtl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myhomepage_layout);
//        点击跳转到我的关注页面
        myHomepageConcernLinear = (LinearLayout) findViewById(R.id.myHomepage_concern_linear);
        myHomepageConcernLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this,MyConcernPageActivity.class);
            }
        });
//        点击跳转到我的粉丝页面
        myHomepageFansLinear = (LinearLayout) findViewById(R.id.myHomepage_fans_linear);
        myHomepageFansLinear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this,MyFansPageActivity.class);
            }
        });
//        点击跳转到编辑资料页面
        informationTextView = (TextView) findViewById(R.id.myHomepage_information_textView);
        informationTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this,EditDataPageActivity.class);
            }
        });
//        点击跳转到我的订单页面
        myHomepageOrderImg = (ImageView) findViewById(R.id.myHomepage_order_img);
        myHomepageOrderImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this,MyOrderPageActivity.class);
            }
        });
//        点击跳转到我的收藏页面
        myHomepageCollectionImg = (ImageView) findViewById(R.id.myHomepage_collection_img);
        myHomepageCollectionImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this,MyCollectionPageActivity.class);
            }
        });
//        点击跳转到优惠页面
        myHomepageDiscountImg = (ImageView) findViewById(R.id.myHomepage_discount_img);
        myHomepageDiscountImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this,DiscountPageActivity.class);
            }
        });
//        点击跳转到统计页面
        myHomepageStatisticsImg = (ImageView) findViewById(R.id.myHomepage_statistics_img);
        myHomepageStatisticsImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this,StatisticsPageActivity.class);
            }
        });
//        点击跳转到我的作品
        myHomepageMyWorksRtl = (RelativeLayout) findViewById(R.id.myHomepage_myWorks_rtl);
        myHomepageMyWorksRtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this,MyWorksPageActivity.class);
            }
        });
//        点击跳转到我的菜谱
        myHomepageMyMenuRtl = (RelativeLayout) findViewById(R.id.myHomepage_myMenu_rtl);
        myHomepageMyMenuRtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this,MyMenuPageActivity.class);
            }
        });
//        点击跳转到设置页面
        myHomepageSetRtl = (RelativeLayout) findViewById(R.id.myHomepage_set_rtl);
        myHomepageSetRtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyHomePageLayoutActivity.this,SetPassWordPageActivity.class);
            }
        });
    }
}
