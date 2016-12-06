package maniactivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
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
import java.net.URLConnection;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by admin on 2016/10/23.
 */
public class TeachCookPageActivity extends Activity {
    TextView title ;
    TextView author;
    TextView method;
    TextView concern;
    ImageView img;
    ImageView teach_cook_img;
    String cooking_menu_id="";
    Map<String, String> info = null;
    String result;
    Bitmap bitmap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.teach_cook_page);
        itemFindViewById();
        Intent intent = getIntent();
        if (intent!=null){
            cooking_menu_id = intent.getStringExtra("cooking_menu_id");
            Log.i("TAG===>","cooking_menu_id=>"+cooking_menu_id);
            AskInternetData("requireCookInfo_id","cooking_menu_id="+cooking_menu_id);
        }
        itemSetOnClickListener();
    }

    private void itemFindViewById(){
        title  = (TextView)findViewById(R.id.title);
        author  = (TextView)findViewById(R.id.author);
        method  = (TextView)findViewById(R.id.cooking_method);
        concern  = (TextView)findViewById(R.id.concern);
        img = (ImageView)findViewById(R.id.img);
        teach_cook_img = (ImageView)findViewById(R.id.teach_cook_img);
    }

    private void itemSetOnClickListener(){
        teach_cook_img.setOnClickListener(new View.OnClickListener() {
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
                        Log.i("TAG===>","url=>"+url);
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
                        //JASON解析数据
                        try {
                            JSONArray jsonArray = new JSONArray(result);
                            info = new HashMap<>();
                            JSONObject object = jsonArray.getJSONObject(0);
                            info.put("title", object.optString("cooking_name", "获取失败"));//菜谱名
                            info.put("author", object.optString("user_name", "获取失败"));//作者
                            info.put("method", object.optString("cooking_method", "获取失败"));//做法
                            info.put("concern", object.optString("care_counts", "0"));//喜欢人数
                            String rootPath = "http://10.0.2.2/project/Uploads/";
                            info.put("img", rootPath + object.getString("cooking_img_small"));
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        //发送信息设置ListView
                        Message message = new Message();
                        message.what=1;
                        handler.sendMessage(message);
                        //接口请求失败
                    } else {
                        Toast.makeText(TeachCookPageActivity.this, " httpURLConnection.connect Field", Toast.LENGTH_LONG).show();
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
            if (msg.what==1){
                if (info != null) {
                    title.setText(info.get("title"));
                    author.setText(info.get("author"));
                    method.setText(info.get("method"));
                    concern.setText(info.get("concern"));
                    getImage(info.get("img"));
                }
            }else{
                if (bitmap != null) {
                    img.setImageBitmap(bitmap);
                }
            }
        }
    };

    private void getImage(final String path) {
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    URLConnection connection = url.openConnection();
                    connection.connect();
                    InputStream inputStream = connection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    Message message = new Message();
                    message.what=2;
                    handler.sendMessage(message);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (bitmap!=null){
            bitmap.recycle();
        }
    }
}
