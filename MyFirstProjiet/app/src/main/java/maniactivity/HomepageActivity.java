package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class HomepageActivity extends BaseActivity {
    ImageView homepageSearchImg;
    ImageView homepageBasketImg;
    TextView homepageKitchenTv;
    TextView homepageRankingTv;
    TextView homepageMenuClassificationTv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_homepage);
//        搜索商品
        homepageSearchImg = (ImageView) findViewById(R.id.homepage_search_img);
        homepageSearchImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(HomepageActivity.this,SearchPageActivity.class);
            }
        });
        // 买烘培
        TextView homepage_buy = (TextView) findViewById(R.id.homepage_buy);
        homepage_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(HomepageActivity.this,SearchLayoutActivity.class);
            }
        });

//        菜篮子
        homepageBasketImg = (ImageView) findViewById(R.id.homepage_basket_img);
        homepageBasketImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(HomepageActivity.this,VegetableBasketPageActivity.class);
            }
        });
//        厨房问答
        homepageKitchenTv = (TextView) findViewById(R.id.homepage_kitchen_tv);
        homepageKitchenTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(HomepageActivity.this,KitchenPageActivity.class);
            }
        });
//        排行榜
        homepageRankingTv = (TextView) findViewById(R.id.homepage_ranking_tv);
        homepageRankingTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(HomepageActivity.this,RankingListPageActivity.class);
            }
        });
//        菜谱分类
        homepageMenuClassificationTv = (TextView) findViewById(R.id.homepage_menuclassification_tv);
        homepageMenuClassificationTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(HomepageActivity.this,MenuClassFicationPageActivity.class);
            }
        });
    }
}
