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
public class DiscountPageActivity extends BaseActivity {
    ImageView discountBackImg;

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
    }
}
