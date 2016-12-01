package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.ArrayRes;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;

import activity.BaseActivity;
import adapter.MyAttentionAdapter;
import listclass.MyAttentionData;

/**
 * Created by Administrator on 2016/10/29.
 */
public class MyConcernPageActivity extends BaseActivity {
    ImageView myConcern_back_img;
    ListView myCollection_listview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myconcern_layout);
        //点击返回到我的主页页面
        myConcern_back_img = (ImageView) findViewById(R.id.myConcern_back_img);
        myConcern_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(MyConcernPageActivity.this,MyHomePageLayoutActivity.class);
                finish();
            }
        });
        myCollection_listview= (ListView) findViewById(R.id.myCollection_listview);
        ArrayList<MyAttentionData> list = new ArrayList<MyAttentionData>();
        getMyAttentionData(list);
        myCollection_listview.setAdapter(new MyAttentionAdapter(this,list));
    }

    public void getMyAttentionData(ArrayList<MyAttentionData> list){
        MyAttentionData myAttentionData = new MyAttentionData();
        for (int i=0;i<20;i++){
            myAttentionData.setuser_name("昵称");
            myAttentionData.settouxiang_imageview_two(R.mipmap.icon_head);
            myAttentionData.setText("关注");
            list.add(myAttentionData);
        }
    }
}
