package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;

import listclass.ShopListData;

/**
 * Created by Administrator on 2016/11/29.
 */
public class ShopingListAdapter extends BaseAdapter{
    Context context;
    ArrayList<ShopListData> list = new ArrayList<ShopListData>();
    LayoutInflater layoutInflater;
    public ShopingListAdapter(Context context,ArrayList<ShopListData> list){
        this.context = context;
        this.list=list;
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView=layoutInflater.inflate(R.layout.shop_listeview_item,null);
        }
        return convertView;
    }
}
