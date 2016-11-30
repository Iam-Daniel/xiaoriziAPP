package maniactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;

import adapter.ShopingListAdapter;
import fragment.WorldPageFragment;
import listclass.ShopListData;

/**
 * Created by Administrator on 2016/11/10.
 */
public class ShoppingActivity extends Activity {
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_layout);

        //跳转到购物车页面
        ImageView search_shoppingCart_img = (ImageView)findViewById(R.id.search_shoppingCart_img);
        search_shoppingCart_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingActivity.this, ShoppingCartPageActivity.class);
                startActivity(intent);
                finish();
            }
        });

        //返回到SearchLayoutActivity 页面
        ImageView shoppingBackImg = (ImageView) findViewById(R.id.left_back);
        shoppingBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingActivity.this,SearchLayoutActivity.class);
                startActivity(intent);
                finish();
            }
        });

//        //底部菜单-跳转到首页
//        TextView home = (TextView) findViewById(R.id.home);
//        home.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ShoppingActivity.this, HomepageActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//        //底部菜单-跳转到商城
//        TextView buy = (TextView) findViewById(R.id.buy);
//        buy.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ShoppingActivity.this, SearchLayoutActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//        //底部菜单-跳转到关注
//        TextView concern = (TextView) findViewById(R.id.concern);
//        concern.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ShoppingActivity.this, WorldPageFragment.class);
//                startActivity(intent);
//                finish();
//            }
//        });
//        //底部菜单-跳转到我
//        TextView account = (TextView) findViewById(R.id.account);
//        account.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Intent intent = new Intent(ShoppingActivity.this, MyHomePageLayoutActivity.class);
//                startActivity(intent);
//                finish();
//            }
//        });

        ListView shoping_list = (ListView) findViewById(R.id.shoping_list);
        ArrayList<ShopListData> list = new ArrayList<ShopListData>();
        getShoplistDatas(list);
        shoping_list.setAdapter(new ShopingListAdapter(this,list));
    }

    public void getShoplistDatas(ArrayList<ShopListData> list){
        ShopListData shopListData = new ShopListData();
        for (int i=0;i<20;i++){
            list.add(shopListData);
        }
    }
}
