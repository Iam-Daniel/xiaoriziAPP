package maniactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;

import activity.BaseActivity;
import adapter.MyOrderAdapter;
import listclass.MyOrderData;

/**
 * Created by Administrator on 2016/10/29.
 */
public class MyOrderPageActivity extends BaseActivity {
    ImageView myOrder_back_img;
    ImageView myMenuBackImg;
    ImageView myMenuUploadMenuImg;
    ListView viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myorder_layout);

//        返回到我的主页
        myOrder_back_img = (ImageView) findViewById(R.id.myOrder_back_img);
        myOrder_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(MyOrderPageActivity.this,MyHomePageLayoutActivity.class);
                finish();
            }
        });

        viewPager = (ListView) findViewById(R.id.viewPager);
        ArrayList<MyOrderData> list = new ArrayList<MyOrderData>();
        getMyOrderData(list);
        viewPager.setAdapter(new MyOrderAdapter(this, list));
    }

    public void getMyOrderData(ArrayList<MyOrderData> list) {
        MyOrderData myOrderData = new MyOrderData();
        for (int i = 0; i < 20; i++) {
            list.add(myOrderData);
        }
    }
}
