package maniactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/30.
 */
public class ShoppingCartPageActivity extends BaseActivity {
    ImageView shoppingCartBackImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart_page);
//返回到SearchLayoutActivity 页面
        shoppingCartBackImg = (ImageView) findViewById(R.id.shopping_cart_back_img);
        shoppingCartBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // startActivity(ShoppingCartPageActivity.this,SearchLayoutActivity.class);//
                finish();
            }
        });
    }
}
