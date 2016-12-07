package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;

import listclass.MyDiscountData;

/**
 * Created by Administrator on 2016/11/30.
 */
public class MyDiscountAdapter extends BaseAdapter {
    Context context;
    ArrayList<MyDiscountData> list = new ArrayList<MyDiscountData>();
    LayoutInflater layoutInflater;

    public MyDiscountAdapter(Context context, ArrayList<MyDiscountData> list) {
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

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = layoutInflater.inflate(R.layout.discount_list_item, null);
        }
        return convertView;
    }

    public class ViewHolder {
        private TextView count_textView;  //满50减10
        private TextView all_textView;   //使用范围  全场
        private TextView date_textView; //使用范围 日期
        public boolean state;
    }
}
