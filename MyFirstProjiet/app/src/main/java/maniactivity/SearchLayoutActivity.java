package maniactivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
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

import activity.BaseActivity;
import adapter.GoodsTopListViewAdapter;
import adapter.ListViewAdapter;

/**
 * Created by Administrator on 2016/10/29.
 */
public class SearchLayoutActivity extends BaseActivity {
    TextView searchMoreTv;
    ImageView searchShoppingCartImg;
    TextView hongPei;
    TextView shengXian;
    TextView qiJu;
    TextView tiaoWei;
    TextView fangBian;
    TextView ganHuo;
    TextView yinPing;
    ImageView exit;
    ListView listView;
    List<GoodsTopInfo> list;
    String result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout);
        itemFindViewById();
        itemSetOnClickListener();
        AskInternetData("requireGoodsInfo","");
    }

    private void itemFindViewById() {
        listView = (ListView)findViewById(R.id.listView);
        exit = (ImageView)findViewById(R.id.exit);
        hongPei = (TextView) findViewById(R.id.hongpei);
        shengXian = (TextView) findViewById(R.id.shengxian);
        qiJu = (TextView) findViewById(R.id.qiju);
        tiaoWei = (TextView) findViewById(R.id.tiaowei);
        fangBian = (TextView) findViewById(R.id.fangbian);
        ganHuo = (TextView) findViewById(R.id.ganhuo);
        yinPing = (TextView) findViewById(R.id.yinping);
        searchMoreTv = (TextView) findViewById(R.id.search_more_tv);
        searchShoppingCartImg = (ImageView) findViewById(R.id.search_shoppingCart_img);
    }


    private void itemSetOnClickListener() {
        hongPei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this, ShoppingActivity.class);
                intent.putExtra("type","烘培");
                startActivity(intent);
            }
        });

        shengXian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this, ShoppingActivity.class);
                intent.putExtra("type","生鲜果蔬");
                startActivity(intent);
            }
        });

        qiJu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this, ShoppingActivity.class);
                intent.putExtra("type","器具");
                startActivity(intent);
            }
        });

        tiaoWei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this, ShoppingActivity.class);
                intent.putExtra("type","调味");
                startActivity(intent);
            }
        });

        fangBian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this, ShoppingActivity.class);
                intent.putExtra("type","方便食品");
                startActivity(intent);
            }
        });

        ganHuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this, ShoppingActivity.class);
                intent.putExtra("type","干货");
                startActivity(intent);
            }
        });

        yinPing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(SearchLayoutActivity.this, ShoppingActivity.class);
                intent.putExtra("type","饮品茶酒");
                startActivity(intent);
            }
        });

//        跳转到更多页面

        searchMoreTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SearchLayoutActivity.this, MorePageActivity.class);
            }
        });
//        跳转到购物车页面

        searchShoppingCartImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SearchLayoutActivity.this, ShoppingCartPageActivity.class);
            }
        });
//       返回上一级
        exit.setOnClickListener(new View.OnClickListener() {
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
                            GoodsTopInfo information;
                            for (int t = 0; t < jsonArray.length(); t++) {
                                JSONObject object = jsonArray.getJSONObject(t);
                                information = new GoodsTopInfo();
                                information.setTitle(object.optString("goods_name","获取失败"));
                                information.setInformation(object.optString("goods_information","获取失败"));
                                information.setPrice(object.optString("price","获取失败"));
                                String rootPath = "http://10.0.2.2/project/Uploads/";
                                information.setImg(rootPath+object.getString("goods_img"));
                                list.add(information);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (list.size()!= 0) {
                            //发送信息设置ListView
                            handler.sendEmptyMessage(0);
                        }
                        //接口请求失败
                    } else {
                        Toast.makeText(SearchLayoutActivity.this," httpURLConnection.connect Field", Toast.LENGTH_LONG).show();
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
                GoodsTopListViewAdapter listViewAdapter = new GoodsTopListViewAdapter(SearchLayoutActivity.this,list);
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
