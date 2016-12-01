package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;

import activity.BaseActivity;
import adapter.MyfansAdapter;
import listclass.MyFansData;

/**
 * Created by Administrator on 2016/10/29.
 */
public class MyFansPageActivity extends BaseActivity {
    ImageView myFansBackImg;
    ListView Myfan_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myfans_layout);

//        点击返回到我的主页
        myFansBackImg = (ImageView) findViewById(R.id.myFans_back_img);
        myFansBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(MyFansPageActivity.this,MyHomePageLayoutActivity.class);
                finish();
            }
        });
        Myfan_list=(ListView) findViewById(R.id.Myfan_list);
        ArrayList<MyFansData> list = new ArrayList<MyFansData>();
        getMyfansdata(list);
        Myfan_list.setAdapter(new MyfansAdapter(this,list));

    }

    public void getMyfansdata(ArrayList<MyFansData> list){
        MyFansData myFansData= new MyFansData();
        for (int i=0;i<20;i++){
            myFansData.setIcon_into(R.mipmap.icon_into);
            myFansData.setTouxiang_imageview_two(R.mipmap.icon_head);
            myFansData.setUser_name("昵称");
            list.add(myFansData);
        }
    }
}
