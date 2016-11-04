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
public class HeadBackgroundPageActivity extends BaseActivity {
    ImageView headBackgroundBackImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head_background_layout);

//  点击返回到编辑资料页面
        headBackgroundBackImg = (ImageView) findViewById(R.id.headBackground_back_img);
        headBackgroundBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(HeadBackgroundPageActivity.this,EditDataPageActivity.class);
            }
        });
    }
}
