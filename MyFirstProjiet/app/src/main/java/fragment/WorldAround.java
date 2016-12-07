package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
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

import ListItemInfor.CookingInfo;
import adapter.ListViewAdapter;
import ListItemInfor.ListInformation;
import maniactivity.TeachCookPageActivity;

/**
 * Created by Administrator on 2016/11/27.
 */
public class WorldAround extends Fragment {
    View view;
    ListView listView;
    List<ListInformation> list;
    List<CookingInfo> list2;
    String result;
    ScrollView scrollView;
    ImageView img1,img2,img3;
    TextView name1,name2,name3;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.world_around, null);
        itemFindViewById();
        //设置顶部推荐的菜单
        AskInternetData1("requireCookingInfo", "");
        //设置推荐菜谱
        AskInternetData2("requireCookMethodNew", "");
        itemSetOnClickListener();
        listView.setFocusable(false);
        scrollView.smoothScrollTo(0, 20);
        return view;
    }


    private void itemFindViewById() {
        img1 = (ImageView)view.findViewById(R.id.img1);
        img2 = (ImageView)view.findViewById(R.id.img2);
        img3 = (ImageView)view.findViewById(R.id.img3);
        name1 = (TextView)view.findViewById(R.id.name1);
        name2 = (TextView)view.findViewById(R.id.name2);
        name3 = (TextView)view.findViewById(R.id.name3);
        listView = (ListView) view.findViewById(R.id.listView);
        scrollView = (ScrollView) view.findViewById(R.id.scrollView);
    }

    private void itemSetOnClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                ListInformation information = list.get(i);
                Intent intent = new Intent(getActivity(), TeachCookPageActivity.class);
                intent.putExtra("cooking_menu_id", information.getId());
                startActivity(intent);
            }
        });
    }

    //请求接口返回数据 并设置顶部推荐用户
    public void AskInternetData1(final String method, final String keyAndValue) {
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
                        list2 = new ArrayList<>();
                        try {
                            JSONArray jsonArray = new JSONArray(result);
                            CookingInfo info;
                            for (int t = 0; t < jsonArray.length(); t++) {
                                JSONObject object = jsonArray.getJSONObject(t);
                                info = new CookingInfo();
                                info.setCooking_name(object.getString("cooking_name"));
                                info.setId(object.getString("cooking_menu_id"));
                                //获得菜品完成图
                                String rootPath = "http://10.0.2.2/project/Uploads/";
                                info.setImg(rootPath + object.getString("cooking_img"));
                                list2.add(info);
                            }
                            if (list2.size()!= 0) {
                                handler.sendEmptyMessage(1);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //接口请求失败
                    } else {
                        Toast.makeText(getActivity(), " httpURLConnection.connect Field", Toast.LENGTH_LONG).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    //请求接口返回数据 并设置ListView
    public void AskInternetData2(final String method, final String keyAndValue) {
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
                        try {
                            JSONArray jsonArray = new JSONArray(result);
                            ListInformation info;
                            for (int t = 0; t < jsonArray.length(); t++) {
                                JSONObject object = jsonArray.getJSONObject(t);
                                info = new ListInformation();
                                info.setAuthor(object.getString("user_name"));
                                info.setTime_y_m_d(object.getString("publish_date"));
                                info.setLike(object.getInt("care_counts"));
                                info.setMessage(object.getInt("comment_counts"));
                                info.setId(object.getString("cooking_menu_id"));
                                //获得菜品完成图
                                String rootPath = "http://10.0.2.2/project/Uploads/";
                                info.setIcon_head(rootPath + object.getString("user_icon_head_small"));
                                info.setImg(rootPath + object.getString("cooking_img"));
                                list.add(info);
                            }
                            if (list.size() != 0) {
                                handler.sendEmptyMessage(2);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //接口请求失败
                    } else {
                        Toast.makeText(getActivity(), " httpURLConnection.connect Field", Toast.LENGTH_LONG).show();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 1 && list2.size() != 0) {
                CookingInfo cookingInfo;
                cookingInfo = list2.get(0);
                name1.setText(cookingInfo.getCooking_name());

                cookingInfo = list2.get(1);
                name2.setText(cookingInfo.getCooking_name());

                cookingInfo = list2.get(2);
                name3.setText(cookingInfo.getCooking_name());

            } else if (msg.what == 2 && list.size() != 0) {
                ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity(), list, 3);
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
