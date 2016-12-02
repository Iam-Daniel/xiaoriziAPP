package maniactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import com.example.administrator.myfirstprojiet.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import adapter.ListViewAdapter;
import adapter.ShoppingListAdapter;
import listclass.ShopListData;

/**
 * Created by Administrator on 2016/11/10.
 */
public class ShoppingActivity extends Activity {
    String result;
    List<ShopListData>list;
    ListView listView;
    ImageView search_shoppingCart_img;
    ImageView shoppingBackImg;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_layout);
        //接收传递过来的商品类型
        Intent intent = getIntent();
        String type = intent.getStringExtra("type");
        itemFindViewById();
        itemSetOnClickListener();

        //请求接口返回数据
        AskInternetData("requireGoodsInfo","type="+type);
    }

    private void itemFindViewById(){
        listView = (ListView)findViewById(R.id.shopping_list);
        search_shoppingCart_img = (ImageView)findViewById(R.id.search_shoppingCart_img);
        shoppingBackImg = (ImageView) findViewById(R.id.left_back);
    }
    private void itemSetOnClickListener(){
        //跳转到购物车页面
        search_shoppingCart_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ShoppingActivity.this, ShoppingCartPageActivity.class);
                startActivity(intent);
                finish();
            }
        });
        //返回到SearchLayoutActivity 页面
        shoppingBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }

    //请求接口返回数据 并设置ListView
    public void AskInternetData(final String method, final String keyAndValue) {
        new Thread() {
            @Override
            public void run() {
                try {
                    /**
                     * 模拟器默认把127.0.0.1和localhost当做本身了，在模拟器上可以用10.0.2.2代替127.0.0.1和localhost，
                     * 另外如果是在局域网环境可以用 192.168.0.x或者192.168.1.x(根据具体配置)连接本机,这样应该就不会报错了。
                     */
                    URL url;
                    HttpURLConnection httpURLConnection;
                    String httpUrl = "http://10.0.2.2/project/index.php/home/index/" + method;
                    //有参数传递
                    if (!keyAndValue.equals("")) {
                        url = new URL(httpUrl + "?" + keyAndValue);
                        //没有参数传递
                    } else {
                        url = new URL(httpUrl);
                    }
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    //传回的数据解析成String
                    if (httpURLConnection.getResponseCode() == 200) {
                        InputStream inputStream = httpURLConnection.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "utf-8");
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder = new StringBuilder();
                        String str;
                        while ((str = bufferedReader.readLine()) != null) {
                            stringBuilder.append(str);
                        }
                        result = stringBuilder.toString();
                        list = new ArrayList<>();

                        //JASON解析数据
                        try {
                            JSONArray jsonArray = new JSONArray(result);
                            ShopListData shopListData;
                            for (int t = 0; t < jsonArray.length(); t++) {
                                JSONObject object = jsonArray.getJSONObject(t);
                                shopListData = new ShopListData();
                                shopListData.setShopping_name(object.optString("goods_name","获取失败"));
                                shopListData.setShopping_info(object.optString("goods_information","获取失败"));
                                shopListData.setShopping_price(object.optString("price","获取失败"));
                                list.add(shopListData);
                            }
                            //发送信息设置ListView
                            if (list.size()!=0){
                                handler.sendEmptyMessage(0);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //接口请求失败
                    } else {
                        Toast.makeText(ShoppingActivity.this, " httpURLConnection.connect Field", Toast.LENGTH_LONG).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            {
                //设置适配器
                ShoppingListAdapter listViewAdapter = new ShoppingListAdapter(ShoppingActivity.this, list);
                listView.setAdapter(listViewAdapter);
                //限制ListView的高度
                {
                    View view = listViewAdapter.getView(0, null, listView);
                    view.measure(0, 0);
                    int MeasuredHeight = view.getMeasuredHeight();
                    int DividerHeight = listView.getDividerHeight();
                    ViewGroup.LayoutParams params = listView.getLayoutParams();
                    params.height = (MeasuredHeight + DividerHeight) * list.size();
                    listView.setLayoutParams(params);
                }
            }
        }
    };
}
