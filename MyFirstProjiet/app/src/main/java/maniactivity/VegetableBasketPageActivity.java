package maniactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myfirstprojiet.R;

import acativity.BaseActivity;

/**
 * Created by Administrator on 2016/10/19.
 */
public class VegetableBasketPageActivity extends BaseActivity{
    ImageView vegetableBackImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vegetable_basket_page);

        vegetableBackImg = (ImageView) findViewById(R.id.vegetable_back_img);
        vegetableBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(VegetableBasketPageActivity.this,HomepageActivity.class);
            }
        });
    }
}
