package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;

import listclass.MyCollectionData;

/**
 * Created by Administrator on 2016/11/30.
 */
public class MyCollectionAdapter extends BaseAdapter {
    Context context;
    LayoutInflater layoutInflater;
    ArrayList<MyCollectionData> list = new ArrayList<MyCollectionData>();
    public MyCollectionAdapter(Context context,ArrayList<MyCollectionData> list){
        this.context = context;
        this.list=list;
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
        if (convertView==null){
            convertView=layoutInflater.inflate(R.layout.mycollection_list_item,null);
        }
        return convertView;
    }
}
