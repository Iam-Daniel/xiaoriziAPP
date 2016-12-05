package maniactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;

import activity.BaseActivity;
import adapter.DetailAdapter;
import listclass.ShoppingCartsData;

/**
 * Created by Administrator on 2016/10/30.
 */
public class ShoppingCartPageActivity extends BaseActivity {
    ImageView shoppingCartBackImg;
    TextView detailsVisible;
    LinearLayout detailsVisibleRb;

    /*listview 的数据*/
    //boolean checked_img = true;
    /*listview 的数据
    * checkbox的显示和隐藏
    * */
    boolean checked_img=true;
    private ArrayList<String> list;
    private DetailAdapter detailAdapter;
    ListView lv;
    ImageView shopping_cart_show;
    TextView title_textView;
    TextView numb_textView;
    TextView content_textView;
    TextView price_textView;


    CheckBox bt_cancel;
    CheckBox bt_selectall;
    ShoppingCartsData shoppingCartsData;
    ArrayList<ShoppingCartsData> shoppingCartsDatas=new ArrayList<ShoppingCartsData>();

    private int checkNum; // 记录选中的条目数量
    //计算总价
    double all_price=0;
    TextView allprice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart_page);
        //返回到SearchLayoutActivity 页面
        shoppingCartBackImg = (ImageView) findViewById(R.id.shopping_cart_back_img);
        shoppingCartBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(ShoppingCartPageActivity.this, SearchLayoutActivity.class);
                finish();
            }
        });
        detailsVisibleRb = (LinearLayout) findViewById(R.id.details_visible_rb);
        detailsVisible = (TextView) findViewById(R.id.details_visible);
        shoppingCartsData=new ShoppingCartsData();
        allprice= (TextView) findViewById(R.id.allprice);
        allprice.setText("("+all_price+")");
        detailsVisible.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (detailsVisibleRb.getVisibility() == View.INVISIBLE) {
                    detailsVisibleRb.setVisibility(View.VISIBLE);
                } else if (detailsVisibleRb.getVisibility() == View.VISIBLE) {
                    detailsVisibleRb.setVisibility(View.INVISIBLE);
                    all_price=0;
                    allprice.setText("("+0+")");
                } else {
                    detailsVisibleRb.setVisibility(View.VISIBLE);
                }
                if(shoppingCartsData.getisCheck_Show_hidden()){
                    shoppingCartsData.setCheck_Show_hidden(false);
                    shoppingCartsDatas.remove(0);
                    shoppingCartsDatas.add(0,shoppingCartsData);
                }else {
                    shoppingCartsData.setCheck_Show_hidden(true);
                    shoppingCartsDatas.remove(0);
                    shoppingCartsDatas.add(0,shoppingCartsData);
                }
                dataChanged();
                lv.setAdapter(detailAdapter);
//                if (detailsVisibleRb.getVisibility() ==View.VISIBLE){
//                    lv.setClickable(true);
//                }else {
//                    lv.setClickable(false);
//                }
                lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        CheckBox checked_state= (CheckBox) view.findViewById(R.id.checked_img);
                        TextView price_textView= (TextView) view.findViewById(R.id.price_textView);
                        checked_state.setClickable(false);
                        if (!checked_state.isChecked()){
                            if (detailsVisibleRb.getVisibility() ==View.VISIBLE){
                                checked_state.setChecked(true);
                                String string=price_textView.getText().toString();
                                double d=Double.parseDouble(string);
                                all_price += d;
                                allprice.setText("("+all_price+")");
                            }
                        }else {
                            if (detailsVisibleRb.getVisibility() == View.VISIBLE){
                                checked_state.setChecked(false);
                                String string=price_textView.getText().toString();
                                double d=Double.parseDouble(string);
                                all_price -= d;
                                allprice.setText("("+all_price+")");
                            }
                        }
                    }
                });
            }
        });


        /**
         *listview 逻辑代码
         */
        lv = (ListView) findViewById(R.id.lv);
        bt_selectall = (CheckBox) findViewById(R.id.bt_selectall);

        shopping_cart_show = (ImageView) findViewById(R.id.shopping_cart_show);
        title_textView = (TextView) findViewById(R.id.title_textView);
        numb_textView = (TextView) findViewById(R.id.numb_textView);
        content_textView = (TextView) findViewById(R.id.content_textView);
        price_textView = (TextView) findViewById(R.id.price_textView);
        getdata(shoppingCartsDatas);
        detailAdapter = new DetailAdapter(shoppingCartsDatas, this,checked_img);
        // 绑定Adapter
        lv.setAdapter(detailAdapter);

        // 全选按钮的回调接口
        bt_selectall= (CheckBox) findViewById(R.id.bt_selectall);
        bt_selectall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            }
        });
        // 反选按钮的回调接口
        bt_cancel= (CheckBox) findViewById(R.id.bt_cancel);
        bt_cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 遍历list的长度，将已选的设为未选，未选的设为已选
                for (int i = 0; i < shoppingCartsDatas.size(); i++) {
                }
            }
        });
    }

    public void getdata(ArrayList<ShoppingCartsData> shoppingCartsDatas){
        ShoppingCartsData shoppingCartsData = new ShoppingCartsData();
        for (int i=0;i<15;i++){
            shoppingCartsDatas.add(shoppingCartsData);
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
