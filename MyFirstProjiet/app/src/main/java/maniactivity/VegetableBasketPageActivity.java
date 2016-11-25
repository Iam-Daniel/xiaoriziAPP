package maniactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/19.
 */
public class VegetableBasketPageActivity extends BaseActivity {
    ImageView vegetableBasketBackImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.vegetable_basket_page);

        //底部菜单-跳转到首页
        TextView home = (TextView) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VegetableBasketPageActivity.this, HomepageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //底部菜单-跳转到商城
        TextView buy = (TextView) findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VegetableBasketPageActivity.this, SearchLayoutActivity.class);
                startActivity(intent);
                finish();

            }
        });
        //底部菜单-跳转到关注
        TextView concern = (TextView) findViewById(R.id.concern);
        concern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VegetableBasketPageActivity.this, ConcernPageActivity.class);
                startActivity(intent);
                finish();

            }
        });
        //底部菜单-跳转到我
        TextView account = (TextView) findViewById(R.id.account);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(VegetableBasketPageActivity.this, MyHomePageLayoutActivity.class);
                startActivity(intent);
                finish();

            }
        });
        //返回
        vegetableBasketBackImg = (ImageView) findViewById(R.id.vegetable_basket_back_img);
        vegetableBasketBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(VegetableBasketPageActivity.this, HomepageActivity.class);
                finish();
            }
        });
    }
}
