package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;

import activity.BaseActivity;
import adapter.MyDiscountAdapter;
import listclass.MyDiscountData;

/**
 * Created by Administrator on 2016/10/29.
 */
public class DiscountPageActivity extends BaseActivity {
    ImageView discountBackImg;
    ListView my_discount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.discount_layout);

        discountBackImg = (ImageView) findViewById(R.id.discount_back_img);
        discountBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(DiscountPageActivity.this,MyHomePageLayoutActivity.class);
                finish();
            }
        });

        my_discount= (ListView) findViewById(R.id.my_discount);
        ArrayList<MyDiscountData> list = new ArrayList<MyDiscountData>();
        getMyDiscountData(list);
        my_discount.setAdapter(new MyDiscountAdapter(this,list));
    }

    public void getMyDiscountData(ArrayList<MyDiscountData> list){
        MyDiscountData myDiscountData = new MyDiscountData();
        for (int i=0;i<10;i++){
            list.add(myDiscountData);
        }
    }
}
