package fragment;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
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

import adapter.ListViewAdapter;
import maniactivity.BaseFragment;
import ListItemInfor.ListInformation;
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
        AskInternetData("requireGoodsInfo_limit","");
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
                                listInformation.setTitle(object.getString("goods_name"));
                                listInformation.setId(object.getString("goods_id"));
                                //隐藏喜欢人数，留言数和关注图标
                                listInformation.setLike(0);
                                listInformation.setMessage(0);
                                listInformation.setConcern(0);
                                //获得商品预览图
                                String rootPath = "http://10.0.2.2/project/Uploads/";
                                listInformation.setImg(rootPath+object.getString("goods_img"));
                                list.add(listInformation);
                            }
                            if (list.size() != 0) {
                                //发送信息设置ListView
                                Message message = new Message();
                                message.arg1 =1;
                                handler.sendMessage(message);
                            }
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //接口请求失败
                    } else {
                        Toast.makeText(getActivity(), "httpURLConnection.connect Field", Toast.LENGTH_LONG).show();
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
            if (msg.arg1==1){
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
        }
    };

}
