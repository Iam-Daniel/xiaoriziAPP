package maniactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import acativity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class HomepageActivity extends BaseActivity {
    ImageView SearchImg;
    ImageView homepageBasketImg;
    ImageView homepageVideoImg;
    TextView homepageKitchenImg;
    TextView homepageRankingImg;
    TextView homepageClassificationImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_homepage);

        SearchImg = (ImageView) findViewById(R.id.homepage_search_img);
        SearchImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(HomepageActivity.this,SearchPageActivity.class);
            }
        });
        homepageBasketImg = (ImageView) findViewById(R.id.homepage_basket_img);
        homepageBasketImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(HomepageActivity.this,VegetableBasketPageActivity.class);
            }
        });
        homepageVideoImg = (ImageView) findViewById(R.id.homepage_video_img);
        homepageVideoImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(HomepageActivity.this,VegetableBasketPageActivity.class);
            }
        });
        homepageKitchenImg = (TextView) findViewById(R.id.homepage_kitchen_img);
        homepageKitchenImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(HomepageActivity.this,KitchenPageActivity.class);
            }
        });
        homepageRankingImg = (TextView) findViewById(R.id.homepage_ranking_img);
        homepageRankingImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(HomepageActivity.this,RankingListPageActivity.class);
            }
        });
        homepageClassificationImg = (TextView) findViewById(R.id.homepage_classification_img);
        homepageClassificationImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(HomepageActivity.this,RankingListPageActivity.class);
            }
        });
    }
}
