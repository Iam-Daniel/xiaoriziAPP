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
public class MorePageActivity extends BaseActivity {
    ImageView more_back_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.more_layout);

//        点击返回到SearchLayoutActivity（搜索）页面
        more_back_img = (ImageView) findViewById(R.id.more_back_img);
        more_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
