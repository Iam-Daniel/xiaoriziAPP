package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class UpLoadWorkPageActivity extends BaseActivity {
    ImageView uploadWorkBackImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploadwork_layout);

//        返回到我的作品页面
        uploadWorkBackImg = (ImageView) findViewById(R.id.uploadWork_back_img);
        uploadWorkBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(UpLoadWorkPageActivity.this,MyWorksPageActivity.class);
                finish();
            }
        });
    }
}
