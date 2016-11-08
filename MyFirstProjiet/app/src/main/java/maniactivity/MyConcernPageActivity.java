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
public class MyConcernPageActivity extends BaseActivity {
    ImageView myConcern_back_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myconcern_layout);
//点击返回到我的主页页面
        myConcern_back_img = (ImageView) findViewById(R.id.myConcern_back_img);
        myConcern_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(MyConcernPageActivity.this,MyHomePageLayoutActivity.class);
                finish();
            }
        });
    }
}
