package maniactivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */
public class SearchLayoutAdapter extends BaseAdapter {
    Context context;
    List<SearchLayoutListInformation> list;

    public SearchLayoutAdapter(Context context, List<SearchLayoutListInformation> list) {
        this.context = context;
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

    class ViewHolder {
        ImageView icon_head;//头像图片
        TextView author;//作者
        TextView time_y_m_d;//日期-年月日
        TextView time_f_a;//日期-AM/PM
        TextView time_m_s;//日期-小时 分钟
        ImageView img;//示例背景图
        TextView numb_f;//喜欢人数
        TextView numb_m;//留言数
        boolean set = false;
    }

    @Override
    public View getView(int position, View view, ViewGroup viewGroup) {
        LayoutInflater layoutInflater = LayoutInflater.from(context);
        ViewHolder viewHolder;
        if (view == null){
            viewHolder = new ViewHolder();
            view = layoutInflater.inflate(R.layout.list_searchgoods,null);
            viewHolder.icon_head = (ImageView)view.findViewById(R.id.icon_head);
            viewHolder.img = (ImageView)view.findViewById(R.id.img);
            viewHolder.author = (TextView)view.findViewById(R.id.author);
            viewHolder.time_y_m_d = (TextView)view.findViewById(R.id.time_y_m_d);
            viewHolder.time_f_a = (TextView)view.findViewById(R.id.time_f_a);
            viewHolder.time_m_s = (TextView)view.findViewById(R.id.time_m_s);
            viewHolder.numb_f = (TextView)view.findViewById(R.id.numb_f);
            viewHolder.numb_m = (TextView)view.findViewById(R.id.numb_m);
            view.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder)view.getTag();
        }
        SearchLayoutListInformation information = list.get(position);
        //如果没有设置作者，则进入设置数据--解决
        if (true){
            viewHolder.icon_head.setImageResource(information.getIcon_head());
            viewHolder.img.setImageResource(information.getImg());
            viewHolder.author.setText(information.getAuthor());
            viewHolder.time_y_m_d.setText(information.getTime_y_m_d());
            viewHolder.time_f_a.setText(information.getTime_f_a());
            viewHolder.time_m_s.setText(information.getTime_m_s());
            viewHolder.numb_f.setText(information.getNumb_f());
            viewHolder.numb_m.setText(information.getNumb_m());
            viewHolder.set= true;
        }
        return view;
    }
}
