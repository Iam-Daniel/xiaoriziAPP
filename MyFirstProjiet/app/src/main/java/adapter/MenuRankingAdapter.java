package adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;

import listclass.MyMenuData;

/**
 * Created by Administrator on 2016/12/5.
 */
public class MenuRankingAdapter extends BaseAdapter{
    Bitmap bitmap;
    Context context;
    ArrayList<MyMenuData> list=new ArrayList<MyMenuData>();
    LayoutInflater layoutInflater;
    public MenuRankingAdapter(Context context,ArrayList<MyMenuData> list){
        this.list=list;this.context=context;
        layoutInflater=LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewhold viewhold=null;
        if (convertView==null){
            convertView=layoutInflater.inflate(R.layout.menu_ranking_item,null);
            viewhold=new viewhold();
            viewhold.author= (TextView) convertView.findViewById(R.id.author);
            viewhold.menu_img= (ImageView) convertView.findViewById(R.id.menu_img);
            viewhold.menu_name= (TextView) convertView.findViewById(R.id.menu_name);
            convertView.setTag(viewhold);
        }
        viewhold= (MenuRankingAdapter.viewhold) convertView.getTag();
        MyMenuData myMenuData=list.get(position);
        viewhold.author.setText(myMenuData.getUser_name());
        viewhold.menu_name.setText(myMenuData.getCooking_name());
//        viewhold.menu_img.setImageBitmap(getImage(myMenuData.getCooking_img()));
        return convertView;
    }

    public class viewhold{
        ImageView menu_img;
        TextView menu_name;
        TextView author;
    }

    private Bitmap getImage(final String path) {
        new Thread(){
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    URLConnection connection = url.openConnection();
                    connection.connect();
                    InputStream inputStream = connection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }.start();
        return bitmap;
    }

}
