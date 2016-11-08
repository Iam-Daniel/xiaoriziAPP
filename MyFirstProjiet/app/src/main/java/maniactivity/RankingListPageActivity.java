package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class RankingListPageActivity extends BaseActivity {
    ImageView rankingBackImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking_list);

        rankingBackImg = (ImageView) findViewById(R.id.ranking_back_img);
        rankingBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(RankingListPageActivity.this,HomepageActivity.class);
                finish();
            }
        });
    }
}
