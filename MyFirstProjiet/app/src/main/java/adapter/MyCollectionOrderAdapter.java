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

import listclass.MyCollectionOrderData;

/**
 * Created by Administrator on 2016/11/30.
 */
public class MyCollectionOrderAdapter extends BaseAdapter {
    ViewHolder viewHolder;
    Context context;
    MyCollectionOrderData myCollectionOrderData;
    List<MyCollectionOrderData> list;
    LayoutInflater layoutInflater;
    int style;

    public MyCollectionOrderAdapter(Context context, List<MyCollectionOrderData> list, int style) {
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
            convertView = layoutInflater.inflate(R.layout.mycollection_order_sub_layout, null);
            viewHolder.img = (ImageView) convertView.findViewById(R.id.img);
            viewHolder.title = (TextView) convertView.findViewById(R.id.title);
            viewHolder.method = (TextView) convertView.findViewById(R.id.method);
            viewHolder.people = (TextView) convertView.findViewById(R.id.people);
            viewHolder.total = (TextView) convertView.findViewById(R.id.total);
            viewHolder.date = (TextView) convertView.findViewById(R.id.date);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        myCollectionOrderData = list.get(position);
        viewHolder.img.setImageResource(myCollectionOrderData.getImg());
        viewHolder.title.setText(myCollectionOrderData.getTitle());
        viewHolder.method.setText(myCollectionOrderData.getMethod());
        viewHolder.people.setText(myCollectionOrderData.getPeople());
        viewHolder.total.setText(myCollectionOrderData.getTotal());
        viewHolder.date.setText(myCollectionOrderData.getDate());
        return convertView;
    }


    class ViewHolder {
        ImageView img;
        TextView title;
        TextView method;
        TextView total;
        TextView people;
        TextView date;
    }
}
