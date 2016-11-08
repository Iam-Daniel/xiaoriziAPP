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
public class EditDataPageActivity extends BaseActivity {
    ImageView editDataBackImg;
    RelativeLayout editDataHeadRtl;
    RelativeLayout editDataHeadBackgroundRtl;
    RelativeLayout editDataInformationRtl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editdata_layout);
//        返回到我的主页
        editDataBackImg = (ImageView) findViewById(R.id.editData_back_img);
        editDataBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(EditDataPageActivity.this,MyHomePageLayoutActivity.class);
                finish();
            }
        });
//        点击跳转到头像
        editDataHeadRtl = (RelativeLayout) findViewById(R.id.editData_head_rtl);
        editDataHeadRtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(EditDataPageActivity.this,HeadPageActivity.class);
            }
        });
//        头像背景
        editDataHeadBackgroundRtl = (RelativeLayout) findViewById(R.id.editData_background_rtl);
        editDataHeadBackgroundRtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(EditDataPageActivity.this,HeadBackgroundPageActivity.class);
            }
        });
//        点击跳转到详细资料
        editDataInformationRtl = (RelativeLayout) findViewById(R.id.editData_information_rtl);
        editDataInformationRtl.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(EditDataPageActivity.this,DetailedInfomationPageActivity.class);
            }
        });
    }
}
