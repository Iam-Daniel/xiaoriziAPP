package adapter;

import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;
import java.util.HashMap;

import listclass.ShoppingCartsData;

/**
 * Created by Administrator on 2016/11/29.
 */
public class DetailAdapter extends BaseAdapter {
    // 填充数据的list
    private ArrayList<String> list;
    ArrayList<ShoppingCartsData> shoppingCartsDatas;
    // 用来控制CheckBox的选中状况
    private static HashMap<Integer, Boolean> isSelected;
    // 上下文
    private Context context;
    // 用来导入布局
    private LayoutInflater inflater = null;

//    public DetailAdapter(ArrayList<String> list, Context context) {
//        this.list = list;
//    LayoutInflater inflater = null;
//    boolean checked;
    public DetailAdapter(ArrayList<ShoppingCartsData> shoppingCartsDatas, Context context,boolean checked_img) {
        this.shoppingCartsDatas = shoppingCartsDatas;
        this.context = context;
        inflater = LayoutInflater.from(context);
        isSelected = new HashMap<Integer, Boolean>();
        // 初始化数据
//        initDate();
    }

//    private void initDate() {
//        for (int i = 0; i < list.size(); i++) {
//            getIsSelected().put(i, false);
//        }
//        this.checked=checked_img;
//    }


    @Override
    public int getCount() {

        return shoppingCartsDatas.size();
    }

    @Override
    public Object getItem(int i) {
        return shoppingCartsDatas.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if (convertView == null) {
// 获得ViewHolder对象
            // 获得ViewHolder对象
            viewHolder = new ViewHolder();
            // 导入布局并赋值给convertview
            convertView = inflater.inflate(R.layout.listshoppingitem_layout, null);
            viewHolder.tv = (TextView) convertView.findViewById(R.id.item_tv);
            viewHolder.cb = (CheckBox) convertView.findViewById(R.id.item_cb);
            // 为view设置标签
            convertView.setTag(viewHolder);

            CheckBox checked_img= (CheckBox) convertView.findViewById(R.id.checked_img);
            checked_img.setChecked(false);
            ShoppingCartsData shoppingCartsData = shoppingCartsDatas.get(0);
            if (shoppingCartsData.getisCheck_Show_hidden()){
                checked_img.setVisibility(View.VISIBLE);
            }else {
                checked_img.setVisibility(View.GONE);
            }
        } else {
            // 取出holder
            viewHolder = (ViewHolder) convertView.getTag();
        }
        return convertView;
    }


    public static class ViewHolder {
        TextView tv;
        public CheckBox cb;

        boolean checked_img = true;
        String shopping_cart_show;
        String title_textView;
        int numb_textView;
        String content_textView;
        Float price_textView;
    }


}
