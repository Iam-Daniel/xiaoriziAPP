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
public class DetailedInfomationPageActivity extends BaseActivity {
    ImageView detailedInformationBackImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.detailed_information);

//        点击返回到编辑资料页面
        detailedInformationBackImg = (ImageView) findViewById(R.id.detailedInformation_back_img);
        detailedInformationBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(DetailedInfomationPageActivity.this,EditDataPageActivity.class);
                finish();
            }
        });
    }
}
