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

import listclass.MenuGoodsData;

/**
 * Created by Administrator on 2016/12/7.
 */
public class MenuGoodsAdapter extends BaseAdapter {
    ViewHolder viewHolder;
    Context context;
    MenuGoodsData menuGoodsData;
    List<MenuGoodsData> list;
    LayoutInflater layoutInflater;

    public MenuGoodsAdapter(Context context, List<MenuGoodsData> list) {
        this.context = context;
        layoutInflater = LayoutInflater.from(context);
        this.list = list;
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
    public View getView(int position, View view, ViewGroup viewGroup) {
        layoutInflater = LayoutInflater.from(context);
        if (view == null) {
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.caipu_shicai_listitem_layout, null);
            viewHolder.caipu_img = (ImageView) view.findViewById(R.id.caipu_img);
            viewHolder.title_textView = (TextView) view.findViewById(R.id.title_textView);
            viewHolder.people_textView = (TextView) view.findViewById(R.id.people_textView);
            viewHolder.people_numb = (TextView) view.findViewById(R.id.people_numb);
            view.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) view.getTag();
        }
        menuGoodsData = list.get(position);
        viewHolder.caipu_img.setImageResource(menuGoodsData.getCaipu_img());
        viewHolder.title_textView.setText(menuGoodsData.getTitle_textView());
        viewHolder.people_textView.setText(menuGoodsData.getPeople_textView());
        viewHolder.people_numb.setText(menuGoodsData.getPeople_numb());
        return view;
    }

    class ViewHolder {
        ImageView caipu_img;
        TextView title_textView;
        TextView people_textView;
        TextView people_numb;
    }
}
