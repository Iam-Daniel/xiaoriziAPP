package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;

import listclass.MyworksData;

/**
 * Created by Administrator on 2016/11/29.
 */
public class MyworksPageAdapter extends BaseAdapter{
    Context context;
    ArrayList<MyworksData> dataList=new ArrayList<MyworksData>();
    LayoutInflater layoutInflater;
    public MyworksPageAdapter(ArrayList<MyworksData> dataList,Context context){
        this.context = context;
        this.dataList=dataList;
        layoutInflater = LayoutInflater.from(context);
    }
    @Override
    public int getCount() {
        return dataList.size();
    }

    @Override
    public Object getItem(int position) {
        return dataList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            convertView=layoutInflater.inflate(R.layout.myworks_list_item,null);
        }

        return convertView;
    }
}
