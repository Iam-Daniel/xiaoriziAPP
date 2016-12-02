package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;
import java.util.List;

import listclass.ShopListData;

/**
 * Created by Administrator on 2016/11/29.
 */
public class ShoppingListAdapter extends BaseAdapter {
    Context context;
    List<ShopListData> list;
    LayoutInflater layoutInflater;

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
        ViewHolder viewHolder = new ViewHolder();
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.shop_listeview_item, null);
            viewHolder.shopping_cart_show_three = (ImageView)convertView.findViewById(R.id.shopping_cart_show_three) ;
            viewHolder.shopping_name = (TextView) convertView.findViewById(R.id.shopping_name) ;
            viewHolder.shopping_info = (TextView) convertView.findViewById(R.id.shopping_info) ;
            viewHolder.shopping_price = (TextView) convertView.findViewById(R.id.shopping_price) ;
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)convertView.getTag();
        }
        ShopListData shopListData = list.get(position);
        viewHolder.shopping_name.setText(shopListData.getShopping_name());
        viewHolder.shopping_info.setText(shopListData.getShopping_info());
        viewHolder.shopping_price.setText(shopListData.getShopping_price()+"元");
        return convertView;
    }
}
