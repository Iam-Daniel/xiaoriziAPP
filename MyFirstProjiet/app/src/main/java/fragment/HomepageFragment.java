package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
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

import adapter.ListViewAdapter;
import maniactivity.BaseFragment;
import maniactivity.ListInformation;
import maniactivity.MenuClassFicationPageActivity;
import maniactivity.RankingListPageActivity;
import maniactivity.SearchLayoutActivity;
import maniactivity.SearchPageActivity;
import maniactivity.VegetableBasketPageActivity;

/**
 * Created by Administrator on 2016/11/25.
 */
public class HomepageFragment extends BaseFragment {
    ImageView homepage_search_img;
    TextView homepage_buy;
    ImageView homepage_basket_img;
    TextView homepage_kitchen_tv;
    TextView homepage_ranking_tv;
    TextView homepage_menuclassification_tv;
    View view;
    ListView listView;
    ListViewAdapter listViewAdapter;
    List<ListInformation> list;
    String result;

    public HomepageFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.layout_homepage, container, false);
        itemFindViewById();
        itemSetOnClickListener();
        //请求接口返回数据并设置listView
        AskInternetData("requireReferenceCookBooks", "");
        return view;
    }

    private void itemFindViewById() {
        homepage_search_img = (ImageView) view.findViewById(R.id.homepage_search_img);
        homepage_buy = (TextView) view.findViewById(R.id.homepage_buy);
        homepage_basket_img = (ImageView) view.findViewById(R.id.homepage_basket_img);
        homepage_kitchen_tv = (TextView) view.findViewById(R.id.homepage_kitchen_tv);
        homepage_ranking_tv = (TextView) view.findViewById(R.id.homepage_ranking_tv);
        homepage_menuclassification_tv = (TextView) view.findViewById(R.id.homepage_menuclassification_tv);
        listView = (ListView) view.findViewById(R.id.listView);
    }

    private void itemSetOnClickListener() {
        // 搜索界面
        homepage_search_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchPageActivity.class);
                startActivity(intent);
            }
        });
        //买烘培
        homepage_buy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), SearchLayoutActivity.class);
                startActivity(intent);
            }
        });
        //菜篮子
        homepage_basket_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), VegetableBasketPageActivity.class);
                startActivity(intent);
            }
        });
        //厨房问答
        homepage_kitchen_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), KitchenPageFragment.class);
                startActivity(intent);
            }
        });
        //排行榜
        homepage_ranking_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), RankingListPageActivity.class);
                startActivity(intent);
            }
        });
        //菜谱分类
        homepage_menuclassification_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MenuClassFicationPageActivity.class);
                startActivity(intent);
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override                                                   //Position
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

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
                        try {
                            JSONArray jsonArray = new JSONArray(result);
                            ListInformation listInformation;
                            for (int t = 0; t < jsonArray.length(); t++) {
                                JSONObject object = jsonArray.getJSONObject(t);
                                listInformation = new ListInformation();
                                listInformation.setTitle(object.getString("cooking_name"));
                                listInformation.setLike(0);
                                listInformation.setMessage(0);
                                listInformation.setConcern(0);
                                listInformation.setImg(R.mipmap.icon_bg_kitchen);
                                list.add(listInformation);
                            }
                            //设置listView
                            if (list.size() != 0) {
                                listViewAdapter = new ListViewAdapter(getActivity(), list, 4);
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
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //接口请求失败
                    } else {
                        Toast.makeText(getActivity(), " httpURLConnection.connect Field", Toast.LENGTH_LONG).show();
                    }
                }catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }

    @Override
    protected int setLayoutResouceId() {
        return 0;
    }
}
