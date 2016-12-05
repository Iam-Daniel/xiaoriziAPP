package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import adapter.ListViewAdapter;
import maniactivity.BaseFragment;
import maniactivity.ListInformation;
import maniactivity.MorePageActivity;
import maniactivity.ShoppingActivity;
import maniactivity.ShoppingCartPageActivity;

/**
 * Created by Administrator on 2016/11/25.
 */
public class SearchFragment extends BaseFragment {
    TextView searchMoreTv;
    ImageView searchShoppingCartImg;
    TextView hongPei;
    TextView shengXian;
    TextView qiJu;
    TextView tiaoWei;
    TextView fangBian;
    TextView ganHuo;
    TextView yinPing;
    /*下面是listView的一些参数*/
    View view;
    ListView listView;
    ListViewAdapter listViewAdapter;
    List<ListInformation> list;
    //访问接口返回的数组
    String result;

    public SearchFragment() {

    }

    @Override
    protected int setLayoutResouceId() {
        return 0;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_layout, container, false);
        itemFindViewById();
        itemSetOnClickListener();
        setData();
        listViewAdapter = new ListViewAdapter(getActivity(), list, 2);
        listView.setAdapter(listViewAdapter);
        return view;
    }

    private void itemFindViewById() {
        hongPei = (TextView) view.findViewById(R.id.hongpei);
        shengXian = (TextView) view.findViewById(R.id.shengxian);
        qiJu = (TextView) view.findViewById(R.id.qiju);
        tiaoWei = (TextView) view.findViewById(R.id.tiaowei);
        fangBian = (TextView) view.findViewById(R.id.fangbian);
        ganHuo = (TextView) view.findViewById(R.id.ganhuo);
        yinPing = (TextView) view.findViewById(R.id.yinping);
        searchMoreTv = (TextView) view.findViewById(R.id.search_more_tv);
        searchShoppingCartImg = (ImageView) view.findViewById(R.id.search_shoppingCart_img);
        listView = (ListView) view.findViewById(R.id.listView);
    }

    private void setData() {
        list = new ArrayList<ListInformation>();
        ListInformation information;
        for (int t = 0; t < 10; t++) {
            information = new ListInformation();
            information.setAuthor("author" + t);
            information.setMedia(1);
            information.setTime_y_m_d("2016-11-11");
            information.setTime_f_a("PM");
            information.setTime_m_s("" + t + ":" + t * 20);
            information.setNumb_f(t * 10);
            information.setNumb_m(t);
            information.setTitle_bottom("-扬州什锦-");
            list.add(information);
        }
    }

    private void itemSetOnClickListener() {
        hongPei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingActivity.class);
                startActivity(intent);
            }
        });

        shengXian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingActivity.class);
                startActivity(intent);
            }
        });

        qiJu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingActivity.class);
                startActivity(intent);
            }
        });

        tiaoWei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingActivity.class);
                startActivity(intent);
            }
        });

        fangBian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingActivity.class);
                startActivity(intent);
            }
        });

        ganHuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingActivity.class);
                startActivity(intent);
            }
        });

        yinPing.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingActivity.class);
                startActivity(intent);
            }
        });
//        跳转到更多页面
        searchMoreTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MorePageActivity.class);
                startActivity(intent);
            }
        });
//        跳转到购物车页面
        searchShoppingCartImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), ShoppingCartPageActivity.class);
                startActivity(intent);
            }
        });
    }

//    public void getdata(final String method,final String KeyAndValue){
//        new Thread(){
//            @Override
//            public void run() {
//                try {
//                    URL url;
//                    HttpURLConnection httpURLConnection;
//                    String httpUrl = "http://10.0.2.2/project/index.php/home/index/" + method;
//                    StringBuilder stringBuilder = new StringBuilder();
//                    //有参数传递
//                    if (!KeyAndValue.equals("")) {
//                        url = new URL(httpUrl + "?" + KeyAndValue);
//                        //没有参数传递
//                    } else {
//                        url = new URL(httpUrl);
//                    }
//                    httpURLConnection = (HttpURLConnection) url.openConnection();
//                    httpURLConnection.setConnectTimeout(5000);
//                    httpURLConnection.connect();
//                    if (httpURLConnection.getResponseCode() == HttpURLConnection.HTTP_OK){
//                        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(),"utf-8"));
//                        String str;
//                        while ((str = bufferedReader.readLine()) != null) {
//                            stringBuilder.append(str);
//                        }
//                        result = stringBuilder.toString();
//                        JSONArray jsonArray = new JSONArray(result);
//                        ListInformation listInformation;
//                        for(int i=0;i<jsonArray.length();i++){
//                            JSONObject object = jsonArray.getJSONObject(i);
//                            listInformation = new ListInformation();
//
//                            list.add(listInformation);
//                        }
//                    }
//                } catch (MalformedURLException e) {
//                e.printStackTrace();
//            } catch (IOException e) {
//                e.printStackTrace();
//            } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//        }.start();
//    }

}
