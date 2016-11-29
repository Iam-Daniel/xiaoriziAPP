package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;

import listclass.MyMenuData;

/**
 * Created by Administrator on 2016/11/29.
 */
public class MyMenuAdapter extends BaseAdapter{
    Context context;
    ArrayList<MyMenuData> list = new ArrayList<MyMenuData>();
    LayoutInflater layoutInflater;
    public MyMenuAdapter(Context context,ArrayList<MyMenuData> list){
        this.list=list;
        this.context = context;
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
        if (convertView ==null){
            convertView = layoutInflater.inflate(R.layout.mymenu_listview_item,null);
        }
        return convertView;
    }
}
