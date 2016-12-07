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
import android.widget.LinearLayout;
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
import ListItemInfor.ListInformation;
import maniactivity.TeachCookPageActivity;

/**
 * Created by admin on 2016/11/26.
 */
public class KitchenSubLayout01 extends Fragment {
    View view;
    ListView listView;
    List<ListInformation> list;
    String result;
    LinearLayout layout_error;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.kitchen_sub_layout, null);
        itemFindViewById();
        itemSetOnClickListener();
        AskInternetData("requireCookMethodHot","type=1001");
        return view;
    }


    private void itemFindViewById() {
        listView = (ListView) view.findViewById(R.id.listView);
        layout_error = (LinearLayout)view.findViewById(R.id.layout_error);
    }

    private void itemSetOnClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getActivity(), TeachCookPageActivity.class);
                ListInformation information = list.get(i);
                intent.putExtra("cooking_menu_id",information.getId());
                startActivity(intent);
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
                            ListInformation information;
                            for (int t = 0; t < jsonArray.length(); t++) {
                                JSONObject object = jsonArray.getJSONObject(t);
                                information = new ListInformation();
                                information.setId(object.optString("cooking_menu_id","获取失败"));
                                information.setAuthor(object.optString("user_name","获取失败"));
                                information.setNumb_f(object.optInt("care_counts",1));
                                information.setNumb_m(object.optInt("comment_counts",1));
                                String rootPath = "http://10.0.2.2/project/Uploads/";
                                information.setImg(rootPath+object.getString("cooking_img"));
                                information.setIcon_head(rootPath+object.getString("user_icon_head_small"));
                                list.add(information);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        if (list.size()!= 0) {
                            //发送信息设置ListView
                            handler.sendEmptyMessage(0);
                        } else {
                            layout_error.setVisibility(View.VISIBLE);
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
    Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            {
                //设置适配器
                ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity(),list,2);
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
