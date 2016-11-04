package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class SearchLayoutActivity extends BaseActivity {
    TextView searchMoreTv;
    ImageView searchShoppingCartImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);

//        跳转到更多页面
        searchMoreTv = (TextView) findViewById(R.id.search_more_tv);
        searchMoreTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SearchLayoutActivity.this,MorePageActivity.class);
                finish();
            }
        });
//        跳转到购物车页面
        searchShoppingCartImg = (ImageView) findViewById(R.id.search_shoppingCart_img);
        searchShoppingCartImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SearchLayoutActivity.this,ShoppingCartPageActivity.class);
                finish();
            }
        });
    }
}
