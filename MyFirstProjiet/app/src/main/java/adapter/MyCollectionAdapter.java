package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.List;

import listclass.MyCollectionData;

/**
 * Created by Administrator on 2016/11/30.
 */
public class MyCollectionAdapter extends BaseAdapter {
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
}
