package maniactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;

import activity.BaseActivity;
import adapter.DetailAdapter;

/**
 * Created by Administrator on 2016/10/30.
 */
public class ShoppingCartPageActivity extends BaseActivity {
    ImageView shoppingCartBackImg;
    TextView detailsVisible;
    LinearLayout detailsVisibleRb;

    /*listview 的数据*/
    //boolean checked_img = true;
    private ArrayList<String> list;
    private DetailAdapter detailAdapter;
    ListView lv;
    ImageView shopping_cart_show;
    TextView title_textView;
    TextView numb_textView;
    TextView content_textView;
    TextView price_textView;

    RadioButton bt_cancel;
    RadioButton bt_selectall;

    private int checkNum; // 记录选中的条目数量

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart_page);
        //返回到SearchLayoutActivity 页面
        shoppingCartBackImg = (ImageView) findViewById(R.id.shopping_cart_back_img);
        shoppingCartBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(ShoppingCartPageActivity.this, SearchLayoutActivity.class);
                finish();
            }
        });
        detailsVisibleRb = (LinearLayout) findViewById(R.id.details_visible_rb);
        detailsVisible = (TextView) findViewById(R.id.details_visible);
        detailsVisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (detailsVisibleRb.getVisibility() == View.INVISIBLE) {
                    detailsVisibleRb.setVisibility(View.VISIBLE);
                } else if (detailsVisibleRb.getVisibility() == View.VISIBLE) {
                    detailsVisibleRb.setVisibility(View.INVISIBLE);
                } else {
                    detailsVisibleRb.setVisibility(View.VISIBLE);
                }
            }
        });

        /**
         *listview 逻辑代码
         */
        lv = (ListView) findViewById(R.id.lv);
        bt_cancel = (RadioButton) findViewById(R.id.bt_cancel);
        bt_selectall = (RadioButton) findViewById(R.id.bt_selectall);

        shopping_cart_show = (ImageView) findViewById(R.id.shopping_cart_show);
        title_textView = (TextView) findViewById(R.id.title_textView);
        numb_textView = (TextView) findViewById(R.id.numb_textView);
        content_textView = (TextView) findViewById(R.id.content_textView);
        price_textView = (TextView) findViewById(R.id.price_textView);
        list = new ArrayList<String>();
        list = new ArrayList<String>();
        // 为Adapter准备数据
        initDate();
        // 实例化自定义的MyAdapter
        detailAdapter = new DetailAdapter(list, this);
        // 绑定Adapter
        lv.setAdapter(detailAdapter);
        // 全选按钮的回调接口
        bt_selectall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 遍历list的长度，将MyAdapter中的map值全部设为true
                for (int i = 0; i < list.size(); i++) {
                    DetailAdapter.getIsSelected().put(i, true);
                }
                // 数量设为list的长度
                checkNum = list.size();
                // 刷新listview和TextView的显示
                dataChanged();
            }
        });
        // 反选按钮的回调接口
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 遍历list的长度，将已选的设为未选，未选的设为已选
                for (int i = 0; i < list.size(); i++) {
                    if (DetailAdapter.getIsSelected().get(i)) {
                        DetailAdapter.getIsSelected().put(i, false);
                        checkNum--;
                    } else {
                        DetailAdapter.getIsSelected().put(i, true);
                        checkNum++;
                    }
                }
                // 刷新listview和TextView的显示
                dataChanged();
            }
        });
        // 绑定listView的监听器
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
                                    long arg3) {
                // 取得ViewHolder对象，这样就省去了通过层层的findViewById去实例化我们需要的cb实例的步骤
                DetailAdapter.ViewHolder holder = (DetailAdapter.ViewHolder) arg1.getTag();
                // 改变CheckBox的状态
                holder.cb.toggle();
                // 将CheckBox的选中状况记录下来
                DetailAdapter.getIsSelected().put(arg2, holder.cb.isChecked());
                // 调整选定条目
                if (holder.cb.isChecked() == true) {
                    checkNum++;
                } else {
                    checkNum--;
                }
                // 用TextView显示
                //tv_show.setText("已选中" + checkNum + "项");
            }
        });
    }


    // 初始化数据
    private void initDate() {
        for (int i = 0; i < 15; i++) {
            list.add("data" + " " + i);
        }
    }

    // 刷新listview和TextView的显示
    private void dataChanged() {
        // 通知listView刷新
        detailAdapter.notifyDataSetChanged();
        // TextView显示最新的选中数目
        //tv_show.setText("已选中" + checkNum + "项");
    }
}
