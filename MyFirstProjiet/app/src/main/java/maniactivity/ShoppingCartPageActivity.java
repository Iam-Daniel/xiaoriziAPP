package maniactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

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
                startActivity(ShoppingCartPageActivity.this, SearchLayoutActivity.class);
                finish();
            }
        });
        //底部菜单-跳转到首页
        TextView home = (TextView) findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingCartPageActivity.this, HomepageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //底部菜单-跳转到商城
        TextView buy = (TextView) findViewById(R.id.buy);
        buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingCartPageActivity.this, SearchLayoutActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //底部菜单-跳转到关注
        TextView concern = (TextView) findViewById(R.id.concern);
        concern.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingCartPageActivity.this, ConcernPageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //底部菜单-跳转到我
        TextView account = (TextView) findViewById(R.id.account);
        account.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingCartPageActivity.this, MyHomePageLayoutActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
