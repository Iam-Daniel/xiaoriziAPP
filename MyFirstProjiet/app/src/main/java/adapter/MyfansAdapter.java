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

import listclass.MyFansData;

/**
 * Created by Administrator on 2016/12/1.
 */
public class MyfansAdapter extends BaseAdapter{
    ArrayList<MyFansData> list = new ArrayList<MyFansData>();
    Context context;
    LayoutInflater layoutInflater;
    public MyfansAdapter(Context context,ArrayList<MyFansData> list){
        this.context=context;
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
            convertView=layoutInflater.inflate(R.layout.myfans_list_item,null);
            MyFansData myFansData=list.get(position);
            TextView user_name = (TextView) convertView.findViewById(R.id.user_name);
            ImageView icon_into=(ImageView)convertView.findViewById(R.id.icon_into);
            ImageView icon_head=(ImageView)convertView.findViewById(R.id.touxiang_imageview_two);
            user_name.setText(myFansData.getUser_name());
            icon_into.setImageResource(myFansData.getIcon_into());
            icon_head.setImageResource(myFansData.getTouxiang_imageview_two());
        }
        return convertView;
    }
}
