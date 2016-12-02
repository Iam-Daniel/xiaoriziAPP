package maniactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class UpLoadMenuPageActivity extends BaseActivity {
    ImageView uploadMenuBackImg;
    LinearLayout add_loadMenu_one;
    LinearLayout add_loadMenu_two;
    LinearLayout add_loadMenu_three;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploadmenu_layout);
        bindView();
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

    private void bindView() {
        add_loadMenu_one = (LinearLayout) findViewById(R.id.add_loadMenu_one);
        add_loadMenu_two = (LinearLayout) findViewById(R.id.add_loadMenu_two);
        add_loadMenu_three = (LinearLayout) findViewById(R.id.add_loadMenu_three);

        add_loadMenu_one.setOnClickListener(onClickListener);
        add_loadMenu_two.setOnClickListener(onClickListener);
        add_loadMenu_three.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.add_loadMenu_one:
                    addMenu();
                    break;
                case R.id.add_loadMenu_two:
                    addMenu();
                    break;
                case R.id.add_loadMenu_three:
                    addMenu();
                    break;
            }
        }
    };

    private void addMenu() {
        Intent intent = new Intent();
        intent.setType("image:/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        //取得相片后返回本界面
        startActivityForResult(intent, 1);
    }
}