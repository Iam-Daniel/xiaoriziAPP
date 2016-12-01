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

import listclass.MyAttentionData;

/**
 * Created by Administrator on 2016/12/1.
 */
public class MyAttentionAdapter extends BaseAdapter{
    ArrayList<MyAttentionData> list = new ArrayList<MyAttentionData>();
    Context context;
    LayoutInflater layoutInflater;
    public MyAttentionAdapter(Context context,ArrayList<MyAttentionData> list){
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
        if (convertView==null) {
            convertView = layoutInflater.inflate(R.layout.myattention_listview_item, null);
            MyAttentionData myAttentionData = new MyAttentionData();
            myAttentionData=list.get(position);
            ImageView touxiang_imageview_two= (ImageView) convertView.findViewById(R.id.touxiang_imageview_two);
            TextView user_name= (TextView) convertView.findViewById(R.id.user_name);
            TextView text= (TextView) convertView.findViewById(R.id.text);
            text.setText(myAttentionData.getText());
            user_name.setText(myAttentionData.getuser_name());
            touxiang_imageview_two.setImageResource(myAttentionData.gettouxiang_imageview_two());
        }
        return convertView;
    }
}
