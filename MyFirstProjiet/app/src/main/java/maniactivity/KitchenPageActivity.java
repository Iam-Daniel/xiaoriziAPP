package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myfirstprojiet.R;

import acativity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class KitchenPageActivity extends BaseActivity {
    ImageView kitchenBackImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitchen_layout);

        kitchenBackImg = (ImageView) findViewById(R.id.kitchen_back_img);
        kitchenBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(KitchenPageActivity.this,HomepageActivity.class);
            }
        });
    }
}
