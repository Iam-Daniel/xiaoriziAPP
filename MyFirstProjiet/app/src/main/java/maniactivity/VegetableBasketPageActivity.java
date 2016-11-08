package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/19.
 */
public class VegetableBasketPageActivity extends BaseActivity{
    ImageView vegetableBasketBackImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vegetable_basket_page);

        vegetableBasketBackImg = (ImageView) findViewById(R.id.vegetable_basket__back_img);
        vegetableBasketBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(VegetableBasketPageActivity.this,HomepageActivity.class);
                finish();
            }
        });
    }
}
