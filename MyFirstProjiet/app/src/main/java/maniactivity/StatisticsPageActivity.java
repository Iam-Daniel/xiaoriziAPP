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
public class StatisticsPageActivity extends BaseActivity {
    ImageView statisticsBackImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics_layout);

//        点击返回到我的主页
        statisticsBackImg = (ImageView) findViewById(R.id.statistics_back_img);
        statisticsBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(StatisticsPageActivity.this,MyHomePageLayoutActivity.class);
                finish();
            }
        });
    }
}
