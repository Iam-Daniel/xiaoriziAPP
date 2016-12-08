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

import listclass.ShopListData;

/**
 * Created by Administrator on 2016/11/29.
 */
public class ShoppingListAdapter extends BaseAdapter {
    Context context;
    List<ShopListData> list;
    LayoutInflater layoutInflater;
    ViewHolder viewHolder;
    Bitmap bitmap;

    public ShoppingListAdapter(Context context, List<ShopListData> list) {
        this.context = context;
        this.list = list;
        layoutInflater = LayoutInflater.from(context);
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


    class ViewHolder {
        ImageView shopping_cart_show_three;
        TextView shopping_name;
        TextView shopping_info;
        TextView shopping_price;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.shop_listeview_item, null);
            viewHolder.shopping_cart_show_three = (ImageView) convertView.findViewById(R.id.shopping_cart_show_three);
            viewHolder.shopping_name = (TextView) convertView.findViewById(R.id.shopping_name);
            viewHolder.shopping_info = (TextView) convertView.findViewById(R.id.shopping_info);
            viewHolder.shopping_price = (TextView) convertView.findViewById(R.id.shopping_price);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        ShopListData shopListData = list.get(position);
        String path = shopListData.getImg();
        getImage(path);
        viewHolder.shopping_name.setText(shopListData.getShopping_name());
        viewHolder.shopping_info.setText(shopListData.getShopping_info());
        viewHolder.shopping_price.setText(shopListData.getShopping_price() + "元");
        return convertView;
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
            viewHolder.shopping_cart_show_three.setImageBitmap(bitmap);
        }
    };
}
