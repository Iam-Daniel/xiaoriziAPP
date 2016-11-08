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
public class UpLoadMenuPageActivity extends BaseActivity {
    ImageView uploadMenuBackImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploadmenu_layout);

//        返回到我的菜谱
        uploadMenuBackImg = (ImageView) findViewById(R.id.uploadMenu_back_img);
        uploadMenuBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(UpLoadMenuPageActivity.this,MyMenuPageActivity.class);
                finish();
            }
        });
    }
}
