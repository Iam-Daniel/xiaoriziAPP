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
public class MyWorksPageActivity extends BaseActivity {
    ImageView myWorksBackImg;
    ImageView myWorksUploadWorkImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myworks_layout);

//        返回到我的主页
        myWorksBackImg = (ImageView) findViewById(R.id.myWorks_back_img);
        myWorksBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(MyWorksPageActivity.this,MyHomePageLayoutActivity.class);
                finish();
            }
        });
//        上传作品
        myWorksUploadWorkImg = (ImageView) findViewById(R.id.myWorks_uploadWork_img);
        myWorksUploadWorkImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyWorksPageActivity.this,UpLoadWorkPageActivity.class);
            }
        });
    }
}
