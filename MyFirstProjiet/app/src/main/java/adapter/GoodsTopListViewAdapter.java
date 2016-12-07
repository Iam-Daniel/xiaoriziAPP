package adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
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
import java.util.List;

import maniactivity.GoodsTopInfo;

/**
 * Created by Administrator on 2016/12/6.
 */
public class GoodsTopListViewAdapter extends BaseAdapter{
    Context context;
    List<GoodsTopInfo>list;
    ViewHolder viewHolder;
    Bitmap bitmap;

    public GoodsTopListViewAdapter(Context context, List<GoodsTopInfo>list){
        this.context = context;
        this.list = list;
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

    class ViewHolder{
        TextView title;
        TextView information;
        TextView price;
        ImageView img;
    }
    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        if (view==null){
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.goods_top_list_item,null);
            viewHolder.title = (TextView)view.findViewById(R.id.title);
            viewHolder.information = (TextView)view.findViewById(R.id.goods_information);
            viewHolder.price = (TextView)view.findViewById(R.id.price);
            viewHolder.img = (ImageView)view.findViewById(R.id.img);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
        if (viewHolder.title.getText().equals("title")){
            GoodsTopInfo goodsTopInfo = list.get(position);
            viewHolder.title.setText(goodsTopInfo.getTitle());
            viewHolder.information.setText(goodsTopInfo.getInformation());
            viewHolder.price.setText(goodsTopInfo.getPrice());
            getImage(goodsTopInfo.getImg());
        }
        return view;
    }

    private void getImage(final String path) {
        bitmap = null;
        new Thread() {
            @Override
            public void run() {
                try {
                    URL url = new URL(path);
                    URLConnection connection = url.openConnection();
                    connection.connect();
                    InputStream inputStream = connection.getInputStream();
                    bitmap = BitmapFactory.decodeStream(inputStream);
                    handler.sendEmptyMessage(0);
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
            viewHolder.img.setImageBitmap(bitmap);
        }
    };
}
