package adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.List;

import listclass.ListDiscount;

/**
 * Created by Administrator on 2016/11/28.
 */
public class DiscountAdapter extends BaseAdapter {
    Context context;
    List<ListDiscount> list;

    public DiscountAdapter(Context context, List<ListDiscount> list) {
        this.context = context;
        this.list = list;
    }


    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int i) {
        return list.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ListDiscount discountAdapter = list.get(i);
        ViewHolder viewHolder = null;
        view = layoutInflater.inflate(R.layout.discount_listview, null);
        viewHolder.count_textView = (TextView) view.findViewById(R.id.count_textView);
        viewHolder.all_textView = (TextView) view.findViewById(R.id.all_textView);
        viewHolder.date_textView = (TextView) view.findViewById(R.id.date_textView);
        view.setTag(viewHolder);

        viewHolder.count_textView.setText(discountAdapter.getCount_textView());
        viewHolder.all_textView.setText(discountAdapter.getAll_textView());
        viewHolder.date_textView.setText(discountAdapter.getDate_textView());
        viewHolder.state = true;
        return view;
    }

    public class ViewHolder {
        private TextView count_textView;  //满50减10
        private TextView all_textView;   //使用范围  全场
        private TextView date_textView; //使用范围 日期
        public boolean state;
    }
}
