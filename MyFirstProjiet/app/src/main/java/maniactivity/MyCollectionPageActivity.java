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
public class MyCollectionPageActivity extends BaseActivity {
    ImageView myCollectionBackImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycollection_layout);

//        返回到我的主页
        myCollectionBackImg = (ImageView) findViewById(R.id.myCollection_back_img);
        myCollectionBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyCollectionPageActivity.this,MyHomePageLayoutActivity.class);
            }
        });
    }
}
