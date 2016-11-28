package internetservice;

import android.util.Log;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Administrator on 2016/11/28.
 */
public class AskInternetService {


    public static void getInternet(final String method, final String keyAndValue){
        new Thread(){
            @Override
            public void run() {
                try {
                    /**
                     * 模拟器默认把127.0.0.1和localhost当做本身了，在模拟器上可以用10.0.2.2代替127.0.0.1和localhost，
                     * 另外如果是在局域网环境可以用 192.168.0.x或者192.168.1.x(根据具体配置)连接本机,这样应该就不会报错了。
                     */
                    HttpURLConnection httpURLConnection;
                    String httpUrl = "http://10.0.2.2/index.php/home/index/"+method;
                    URL url = new URL(httpUrl+"?"+keyAndValue);
                    httpURLConnection = (HttpURLConnection)url.openConnection();
                    httpURLConnection.setConnectTimeout(5000);
                    httpURLConnection.connect();
                    if (httpURLConnection.getResponseCode()==200){
                        InputStream inputStream= httpURLConnection.getInputStream();
                        InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"utf-8");
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        StringBuilder stringBuilder= new StringBuilder();
                        String str;
                        while ((str = bufferedReader.readLine())!=null){
                            stringBuilder.append(str);
                        }
                        Log.i("inputStreamReader",stringBuilder.toString());
                    }
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
    }
}
