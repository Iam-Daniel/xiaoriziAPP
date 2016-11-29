package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;

import activity.BaseActivity;
import adapter.MyworksPageAdapter;
import listclass.MyworksData;

/**
 * Created by Administrator on 2016/10/29.
 */
public class MyWorksPageActivity extends BaseActivity {
    ImageView myWorksBackImg;
    ImageView myWorksUploadWorkImg;
    ListView myworks_list;

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

        myworks_list = (ListView) findViewById(R.id.myworks_list);
        ArrayList<MyworksData> dataList=new ArrayList<MyworksData>();
        getMyworkDatas(dataList);
        myworks_list.setAdapter(new MyworksPageAdapter(dataList,this));
    }

    public void getMyworkDatas(ArrayList<MyworksData> dataList){
        MyworksData myworksData = new MyworksData();
        for (int i=0;i<20;i++){
            dataList.add(myworksData);
        }
    }
}
