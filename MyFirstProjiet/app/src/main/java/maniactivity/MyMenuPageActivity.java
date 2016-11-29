package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;

import activity.BaseActivity;
import adapter.MyMenuAdapter;
import listclass.MyMenuData;

/**
 * Created by Administrator on 2016/10/29.
 */
public class MyMenuPageActivity extends BaseActivity {
    ImageView myMenuBackImg;
    ImageView myMenuUploadMenuImg;
    ListView myMenu_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mymenu_layout);

//        返回到我的主页
        myMenuBackImg = (ImageView) findViewById(R.id.myMenu_back_img);
        myMenuBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(MyMenuPageActivity.this,MyHomePageLayoutActivity.class);
                finish();
            }
        });
//        跳转到上传菜谱页面
        myMenuUploadMenuImg = (ImageView) findViewById(R.id.myMenu_uploadMenu_img);
        myMenuUploadMenuImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(MyMenuPageActivity.this, UpLoadMenuPageActivity.class);
            }
        });

        myMenu_listview = (ListView) findViewById(R.id.myMenu_listview);
        ArrayList<MyMenuData> list = new ArrayList<MyMenuData>();
        getMymenuData(list);
        myMenu_listview.setAdapter(new MyMenuAdapter(this, list));

    }

    public void getMymenuData(ArrayList<MyMenuData> list) {
        MyMenuData myMenuData = new MyMenuData();
        for (int i = 0; i < 20; i++) {
            list.add(myMenuData);
        }
    }
}
