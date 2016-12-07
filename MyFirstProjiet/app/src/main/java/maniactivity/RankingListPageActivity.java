package maniactivity;


import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListAdapter;

import com.example.administrator.myfirstprojiet.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import activity.BaseActivity;
import adapter.MenuRankingAdapter;
import listclass.MyMenuData;

/**
 * Created by Administrator on 2016/10/29.
 */
public class RankingListPageActivity extends BaseActivity {
    ImageView rankingBackImg;
    GridView menu_hot_GridView;
    GridView menuvedio_hot_GridView;
    MenuRankingAdapter menuRankingAdapter;
    String result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ranking_list);

        rankingBackImg = (ImageView) findViewById(R.id.ranking_back_img);
        rankingBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(RankingListPageActivity.this,HomepageActivity.class);
                finish();
            }
        });

        getUrlData("requireCookMethodHot","");
        menu_hot_GridView= (GridView) findViewById(R.id.menu_hot_GridView);
        menuvedio_hot_GridView= (GridView) findViewById(R.id.menuvedio_hot_GridView);
        handler.sendMessage(new Message());

        menu_hot_GridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(RankingListPageActivity.this, TeachCookPageActivity.class);
                MyMenuData MyMenuData = list.get(position);
                intent.putExtra("cooking_menu_id",MyMenuData.getCooking_menu_id());
                startActivity(intent);
            }
        });
        menuvedio_hot_GridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(RankingListPageActivity.this, TeachCookPageActivity.class);
                MyMenuData MyMenuData = list.get(position);
                intent.putExtra("cooking_menu_id",MyMenuData.getCooking_menu_id());
                startActivity(intent);
            }
        });
    }

    //计算GridView的高度
    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            menuRankingAdapter=new MenuRankingAdapter(RankingListPageActivity.this,list);
            menu_hot_GridView.setAdapter(menuRankingAdapter);
            menuvedio_hot_GridView.setAdapter(menuRankingAdapter);
            int totalHeight = 0;
            if (menuRankingAdapter.getCount() == 0){
                Log.i("menuRankingAdapter","menuRankingAdapter=null");
                return;
            }
            for (int i = 0, len = menuRankingAdapter.getCount(); i < len; i+=4) { //listAdapter.getCount()返回数据项的数目
                View listItem = menuRankingAdapter.getView(i, null, menu_hot_GridView);
                listItem.measure(0, 0); //计算子项View 的宽高
                totalHeight += listItem.getMeasuredHeight(); //统计所有子项的总高度
                ViewGroup.LayoutParams params = menu_hot_GridView.getLayoutParams();
                params.height = totalHeight + (menu_hot_GridView.getVerticalSpacing() * (menuRankingAdapter.getCount() - 1));
                menu_hot_GridView.setLayoutParams(params);
                menuvedio_hot_GridView.setLayoutParams(params);
                Log.i("totalHeight","totalHeight="+totalHeight);
            }
        }
    };

    ArrayList<MyMenuData> list=new ArrayList<MyMenuData>();
    public void getdata(JSONArray jsonArray){
        MyMenuData myMenuData;
        for (int i=0;i<jsonArray.length();i++){
            try {
                JSONObject jsonObject=jsonArray.getJSONObject(i);
                myMenuData=new MyMenuData();
                myMenuData.setCooking_img(jsonObject.getString("cooking_img"));
                myMenuData.setCooking_name(jsonObject.getString("cooking_name"));
                myMenuData.setUser_name(jsonObject.getString("user_name"));
                myMenuData.setCooking_menu_id(jsonObject.getInt("cooking_menu_id"));
                list.add(myMenuData);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
    }

    public void getUrlData(final String method, final String KeyAndValue) {
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url;
                    HttpURLConnection httpURLConnection;
                    String httpUrl = "http://10.0.2.2/project/index.php/home/index/" + method;
                    StringBuilder stringBuilder = new StringBuilder();
                    //有参数传递
                    if (!KeyAndValue.equals("")) {
                        url = new URL(httpUrl + "?" + KeyAndValue);
                        //没有参数传递
                    } else {
                        url = new URL(httpUrl);
                    }
                    httpURLConnection = (HttpURLConnection) url.openConnection();
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK) {
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
                        String str;
                        while ((str = bufferedReader.readLine()) != null) {
                            stringBuilder.append(str);
                        }
                        result = stringBuilder.toString();
                        JSONArray jsonArray = new JSONArray(result);
                        getdata(jsonArray);
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }


}
