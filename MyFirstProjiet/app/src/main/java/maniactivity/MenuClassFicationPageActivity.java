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
public class MenuClassFicationPageActivity extends BaseActivity {
    ImageView homePageMenuClassificationBackImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_classification);

        homePageMenuClassificationBackImg = (ImageView) findViewById(R.id.homepage_menuClassification_back_img);
        homePageMenuClassificationBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MenuClassFicationPageActivity.this,RankingListPageActivity.class);
            }
        });
    }
}
