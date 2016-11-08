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
public class MyFansPageActivity extends BaseActivity {
    ImageView myFansBackImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myfans_layout);

//        点击返回到我的主页
        myFansBackImg = (ImageView) findViewById(R.id.myFans_back_img);
        myFansBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(MyFansPageActivity.this,MyHomePageLayoutActivity.class);
                finish();
            }
        });
    }
}
