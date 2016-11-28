package maniactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class HeadBackgroundPageActivity extends BaseActivity {
    ImageView headBackgroundBackImg;
    TextView head_upload_textView;
    LinearLayout myHeadImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head_background_layout);

//  点击返回到编辑资料页面
        headBackgroundBackImg = (ImageView) findViewById(R.id.headBackground_back_img);
        headBackgroundBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(HeadBackgroundPageActivity.this,EditDataPageActivity.class);
                finish();
            }
        });
        //上传头像的控件
        head_upload_textView = (TextView) findViewById(R.id.head_upload_textView);
        head_upload_textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image:/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                //取得相片后返回本界面
                startActivityForResult(intent, 1);
            }
        });
        // 我的头像布局控件
        myHeadImg = (LinearLayout) findViewById(R.id.myHead_img);
        myHeadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
    }
}
