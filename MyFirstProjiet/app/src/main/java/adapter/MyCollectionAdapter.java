package adapter;

import android.content.Context;
<<<<<<< HEAD
import android.support.v4.app.FragmentActivity;
=======
>>>>>>> acd1e8d5e9f096bda78c280c0fe8ade8536a69d1
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
<<<<<<< HEAD
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.List;
=======

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;
>>>>>>> acd1e8d5e9f096bda78c280c0fe8ade8536a69d1

import listclass.MyCollectionData;

/**
 * Created by Administrator on 2016/11/30.
 */
public class MyCollectionAdapter extends BaseAdapter {
<<<<<<< HEAD
    ViewHolder viewHolder;
    Context context;
    MyCollectionData myCollectionData;
    List<MyCollectionData> list;
    LayoutInflater layoutInflater;
    int style;

    public MyCollectionAdapter(Context context, List<MyCollectionData> list, int style) {
        this.list = list;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.style = style;
    }

    @Override
    public int getCount() {
        return 0;
=======
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
>>>>>>> acd1e8d5e9f096bda78c280c0fe8ade8536a69d1
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
<<<<<<< HEAD
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        if (convertView == null) {
            viewHolder = new ViewHolder();
            convertView = layoutInflater.inflate(R.layout.mycollection_sub_layout, null);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.img);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.method = (TextView) convertView.findViewById(R.id.method);
            viewHolder.people = (TextView) convertView.findViewById(R.id.people);
            viewHolder.who = (TextView) convertView.findViewById(R.id.who);
            viewHolder.date = (TextView) convertView.findViewById(R.id.date);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        myCollectionData = list.get(position);
        viewHolder.img.setImageResource(myCollectionData.getImg());
        viewHolder.title.setText(myCollectionData.getTitle());
        viewHolder.method.setText(myCollectionData.getMethod());
        viewHolder.people.setText(myCollectionData.getPeople());
        viewHolder.who.setText(myCollectionData.getWho());
        viewHolder.date.setText(myCollectionData.getDate());

        return convertView;
    }

    class ViewHolder {
        ImageView img;
        TextView title;
        TextView method;
        TextView people;
        TextView who;
        TextView date;
    }
=======
        if (convertView==null){
            convertView=layoutInflater.inflate(R.layout.mycollection_list_item,null);
        }
        return convertView;
    }
>>>>>>> acd1e8d5e9f096bda78c280c0fe8ade8536a69d1
}
