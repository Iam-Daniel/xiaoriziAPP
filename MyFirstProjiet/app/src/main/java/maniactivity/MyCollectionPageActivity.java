package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;

import activity.BaseActivity;
import adapter.MyCollectionAdapter;
import listclass.MyCollectionData;

/**
 * Created by Administrator on 2016/10/29.
 */
public class MyCollectionPageActivity extends BaseActivity {
    ImageView myCollectionBackImg;
    ListView myCollection_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mycollection_layout);

//        返回到我的主页
        myCollectionBackImg = (ImageView) findViewById(R.id.myCollection_back_img);
        myCollectionBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // startActivity(MyCollectionPageActivity.this,MyHomePageLayoutActivity.class);
                finish();
            }
        });
        myCollection_list = (ListView) findViewById(R.id.myCollection_list);
        ArrayList<MyCollectionData> list = new ArrayList<MyCollectionData>();
        getMyCollectionData(list);
        myCollection_list.setAdapter(new MyCollectionAdapter(this,list));

    }

    public void getMyCollectionData(ArrayList<MyCollectionData> list){
        MyCollectionData myCollectionData=new MyCollectionData();
        for (int i=0;i<20;i++){
            list.add(myCollectionData);
        }
    }
}
