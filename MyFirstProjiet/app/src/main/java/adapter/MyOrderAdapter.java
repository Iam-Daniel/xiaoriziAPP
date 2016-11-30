package adapter;

import android.content.Context;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;
import java.util.List;

import listclass.MyOrderData;
import maniactivity.MyOrderPageActivity;

/**
 * Created by Administrator on 2016/11/29.
 */
public class MyOrderAdapter extends BaseAdapter {
    ViewHolder viewHolder;
    Context context;
    MyOrderData myOrderData;
    List<MyOrderData> list;
    LayoutInflater layoutInflater;
    int style;

    public MyOrderAdapter(Context context, List<MyOrderData> list, int style) {
        this.list = list;
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.style = style;
    }

    public MyOrderAdapter(MyOrderPageActivity myOrderPageActivity, ArrayList<MyOrderData> list) {
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
            convertView = layoutInflater.inflate(R.layout.myorder_listview_item, null);
            viewHolder.cooking_img = (ImageView) convertView.findViewById(R.id.cooking_img);
            viewHolder.cooking_name = (TextView) convertView.findViewById(R.id.cooking_name);
            viewHolder.date = (TextView) convertView.findViewById(R.id.date);
            viewHolder.cooking_method = (TextView) convertView.findViewById(R.id.cooking_method);
            viewHolder.doing_counts = (TextView) convertView.findViewById(R.id.doing_counts);
            viewHolder.collect_counts = (TextView) convertView.findViewById(R.id.collect_counts);
            viewHolder.pingjia = (TextView) convertView.findViewById(R.id.pingjia);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }
        myOrderData = list.get(position);
        if (style == 1) {
            viewHolder.cooking_img.setImageResource(myOrderData.getCooking_img());
            viewHolder.cooking_name.setText(myOrderData.getCooking_name());
            viewHolder.date.setText(myOrderData.getDate());
            viewHolder.cooking_method.setText(myOrderData.getCooking_method());
            viewHolder.doing_counts.setText(myOrderData.getDoing_counts());
            viewHolder.collect_counts.setText(myOrderData.getCollect_counts());
            //viewHolder.pingjia.setVisibility(View.INVISIBLE);
        } else if (style == 2) {
            viewHolder.cooking_img.setImageResource(myOrderData.getCooking_img());
            viewHolder.cooking_name.setText(myOrderData.getCooking_name());
            viewHolder.date.setText(myOrderData.getDate());
            viewHolder.cooking_method.setText(myOrderData.getCooking_method());
            viewHolder.doing_counts.setText(myOrderData.getDoing_counts());
            viewHolder.collect_counts.setText(myOrderData.getCollect_counts());
//            viewHolder.pingjia.setVisibility(View.INVISIBLE);
        } else if (style == 3) {
            viewHolder.cooking_img.setImageResource(myOrderData.getCooking_img());
            viewHolder.cooking_name.setText(myOrderData.getCooking_name());
            viewHolder.date.setText(myOrderData.getDate());
            viewHolder.cooking_method.setText(myOrderData.getCooking_method());
            viewHolder.doing_counts.setText(myOrderData.getDoing_counts());
            viewHolder.collect_counts.setText(myOrderData.getCollect_counts());
//            viewHolder.pingjia.setVisibility(View.INVISIBLE);
        }
        return convertView;
    }


    class ViewHolder {
        ImageView cooking_img;
        TextView cooking_name;
        TextView date;
        TextView cooking_method;
        TextView doing_counts;
        TextView collect_counts;
        TextView pingjia;
    }
}
