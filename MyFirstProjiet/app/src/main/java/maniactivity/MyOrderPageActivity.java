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
public class MyOrderPageActivity extends BaseActivity {
    ImageView myOrder_back_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myorder_layout);

//        返回到我的主页
        myOrder_back_img = (ImageView) findViewById(R.id.myOrder_back_img);
        myOrder_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(MyOrderPageActivity.this,MyHomePageLayoutActivity.class);
                finish();
            }
        });
    }
}
