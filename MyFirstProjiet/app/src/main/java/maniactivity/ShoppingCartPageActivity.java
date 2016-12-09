package maniactivity;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myfirstprojiet.R;
import com.tencent.mm.sdk.modelmsg.SendMessageToWX;
import com.tencent.mm.sdk.modelmsg.WXImageObject;
import com.tencent.mm.sdk.modelmsg.WXMediaMessage;
import com.tencent.mm.sdk.openapi.IWXAPI;
import com.tencent.mm.sdk.openapi.WXAPIFactory;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import listclass.DataBean;

public class ShoppingCartPageActivity extends Activity implements View.OnClickListener {
//    IWXAPI api;
//    String APP_ID = "wx92055528e224f610";
    private static final int INITIALIZE = 0;

    private ListView mListView;// �

    private ListAdapter mListAdapter;// adapter

    private List<DataBean> mListData = new ArrayList<DataBean>();// ����

    private boolean isBatchModel;// �Ƿ��ɾ��ģʽ

    private RelativeLayout mBottonLayout;
    private CheckBox mCheckAll;
    private TextView mEdit;
    private TextView mPriceAll;
    private TextView contentTextView;
    // private TextView mSelectNum; ����
    private TextView mFavorite;
    private TextView mDelete;

    private double totalPrice = 0;
    /**
     * ����
     */
    private SparseArray<Boolean> mSelectState = new SparseArray<Boolean>();
    private ImageView back;
    private boolean flag = true; // �

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.shopping_cart_page);

        initView();
        initListener();
        loadData();
        //微信回调
//        regToWx();
    }

    private void initView() {
        back = (ImageView) findViewById(R.id.back);

        mBottonLayout = (RelativeLayout) findViewById(R.id.cart_rl_allprie_total);
        mCheckAll = (CheckBox) findViewById(R.id.check_box_all);
        mEdit = (TextView) findViewById(R.id.subtitle);
        mPriceAll = (TextView) findViewById(R.id.tv_cart_total);
        // mSelectNum = (TextView) findViewById(R.id.tv_cart_select_num);
        mFavorite = (TextView) findViewById(R.id.tv_cart_move_favorite);
        mDelete = (TextView) findViewById(R.id.tv_cart_buy_or_del);
        contentTextView = (TextView) findViewById(R.id.content_textView);
        mListView = (ListView) findViewById(R.id.listview);
        mListView.setSelector(R.drawable.list_selector);

    }

    private void initListener() {
        mEdit.setOnClickListener(this);
        mDelete.setOnClickListener(this);
        mCheckAll.setOnClickListener(this);
        back.setOnClickListener(this);
    }

    private void loadData() {
        new LoadDataTask().execute(new Params(INITIALIZE));
    }

    private void refreshListView() {
        if (mListAdapter == null) {
            mListAdapter = new ListAdapter();
            mListView.setAdapter(mListAdapter);
            mListView.setOnItemClickListener(mListAdapter);
        } else {
            mListAdapter.notifyDataSetChanged();
        }
    }

    private List<DataBean> getData() {
        int maxId = 0;
        if (mListData != null && mListData.size() > 0)
            maxId = mListData.get(mListData.size() - 1).getId();
        List<DataBean> result = new ArrayList<DataBean>();
        DataBean data = null;
        for (int i = 0; i < 20; i++) {
            data = new DataBean();
            data.setId(maxId + i + 1);//
            data.setShopName("不知道写什么" + (maxId + 1 + i) + "啦啦啦啦啦啦啦啦啦");
            data.setContent("我是商品标题" + (maxId + 1 + i) + "号商品");
            data.setContent_textView("(10片装，500g 品质生鲜，)");
            data.setCarNum(1);
            data.setPrice(200);
            result.add(data);
        }
        return result;
    }

    class Params {
        int op;

        public Params(int op) {
            this.op = op;
        }
    }

    class Result {
        int op;
        List<DataBean> list;
    }

    private class LoadDataTask extends AsyncTask<Params, Void, Result> {
        @Override
        protected Result doInBackground(Params... params) {
            Params p = params[0];
            Result result = new Result();
            result.op = p.op;
            try {//
                Thread.sleep(500L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            result.list = getData();
            return result;
        }

        @Override
        protected void onPostExecute(Result result) {
            super.onPostExecute(result);
            if (result.op == INITIALIZE) {
                mListData = result.list;
            } else {
                mListData.addAll(result.list);
                Toast.makeText(getApplicationContext(), "",
                        Toast.LENGTH_SHORT).show();
            }
            refreshListView();
        }
    }

    boolean isSelect = false;

    private class ListAdapter extends BaseAdapter implements AdapterView.OnItemClickListener {

        @Override
        public int getCount() {
            return mListData.size();
        }

        @Override
        public Object getItem(int position) {
            return mListData.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        ViewHolder holder = null;

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            View view = convertView;
            if (view == null) {
                holder = new ViewHolder();
                view = LayoutInflater.from(ShoppingCartPageActivity.this).inflate(
                        R.layout.listshoppingitem_layout, null);
                holder.checkBox = (CheckBox) view.findViewById(R.id.check_box);
                // shopName = (TextView) view.findViewById(R.id.tv_source_name);
                holder.image = (ImageView) view
                        .findViewById(R.id.iv_adapter_list_pic);
                holder.content = (TextView) view.findViewById(R.id.tv_intro);
                holder.carNum = (TextView) view.findViewById(R.id.tv_num);
                holder.price = (TextView) view.findViewById(R.id.tv_price);
                holder.add = (TextView) view.findViewById(R.id.tv_add);
                holder.red = (TextView) view.findViewById(R.id.tv_reduce);
                holder.contentTextView = (TextView) view.findViewById(R.id.content_textView);
//                 holder.button = (Button) view.findViewById(R.id.btn_delete);
                holder.frontView = view.findViewById(R.id.item_left);

                view.setTag(holder);
            } else {
                holder = (ViewHolder) view.getTag();
            }

            final DataBean data = mListData.get(position);
            bindListItem(holder, data);

            if (data != null) {
                if (data.isChoose()) {
                    holder.checkBox.setChecked(true);
                } else {
                    holder.checkBox.setChecked(false);
                }
                holder.checkBox.setOnClickListener(new CheckBoxOnClick(data));
                holder.red.setOnClickListener(new ReduceOnClick(data,
                        holder.carNum));
                holder.add.setOnClickListener(new AddOnclick(data,
                        holder.carNum));
            }
            return view;
        }

        class CheckBoxOnClick implements View.OnClickListener {
            DataBean shopcartEntity;

            public CheckBoxOnClick(DataBean shopcartEntity) {
                this.shopcartEntity = shopcartEntity;
            }

            @Override
            public void onClick(View view) {
                CheckBox cb = (CheckBox) view;
                if (cb.isChecked()) {
                    shopcartEntity.setChoose(true);
                } else {
                    shopcartEntity.setChoose(false);
                }
                count();
                select();
            }
        }

        private class AddOnclick implements View.OnClickListener {
            DataBean shopcartEntity;
            TextView shopcart_number_btn;

            private AddOnclick(DataBean shopcartEntity,
                               TextView shopcart_number_btn) {
                this.shopcartEntity = shopcartEntity;
                this.shopcart_number_btn = shopcart_number_btn;
            }

            @Override
            public void onClick(View arg0) {
                shopcartEntity.setChoose(true);
                String numberStr = shopcart_number_btn.getText().toString();
                if (!TextUtils.isEmpty(numberStr)) {
                    int number = Integer.parseInt(numberStr);
                    int currentNum = number + 1;
                    // �
                    shopcartEntity.setCarNum(currentNum);
                    holder.carNum.setText("" + currentNum);
                    notifyDataSetChanged();
                }
                count();
            }
        }

        private class ReduceOnClick implements View.OnClickListener {
            DataBean shopcartEntity;
            TextView shopcart_number_btn;

            private ReduceOnClick(DataBean shopcartEntity,
                                  TextView shopcart_number_btn) {
                this.shopcartEntity = shopcartEntity;
                this.shopcart_number_btn = shopcart_number_btn;
            }

            @Override
            public void onClick(View arg0) {
                shopcartEntity.setChoose(true);
                String numberStr = shopcart_number_btn.getText().toString();
                if (!TextUtils.isEmpty(numberStr)) {
                    int number = Integer.parseInt(numberStr);
                    if (number == 1) {
                        // Toast.makeText(CartListActivity.this, "�������¼�����",
                        // Toast.LENGTH_SHORT).show();
                    } else {
                        int currentNum = number - 1;
                        //
                        shopcartEntity.setCarNum(currentNum);

                        holder.carNum.setText("" + currentNum);
                        notifyDataSetChanged();
                    }
                }
                count();
            }
        }

        private void bindListItem(ViewHolder holder, DataBean data) {

            // holder.shopName.setText(data.getShopName());
            holder.content.setText(data.getContent());
            holder.price.setText("价格" + data.getPrice());
/**
 *这是设置的起始数量为1，不能乱改
 */
            holder.carNum.setText(data.getCarNum() + "");
            int _id = data.getId();

            boolean selected = mSelectState.get(_id, false);
            holder.checkBox.setChecked(selected);
        }

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position,
                                long id) {
            DataBean bean = mListData.get(position);

            ViewHolder holder = (ViewHolder) view.getTag();
            int _id = (int) bean.getId();
            String contentTextView = bean.getContent_textView();
            boolean selected = !mSelectState.get(_id, false);
            holder.checkBox.toggle();
            // ��CheckBox���
            mListData.get(position).setChoose(holder.checkBox.isChecked());
            //
            if (holder.checkBox.isChecked() == true) {
                totalPrice += bean.getCarNum() * bean.getPrice();
            } else {
                mSelectState.delete(position);
                totalPrice -= bean.getCarNum() * bean.getPrice();
            }
            mPriceAll.setText("" + totalPrice + "");
            if (mSelectState.size() == mListData.size()) {
                mCheckAll.setChecked(true);
            } else {
                mCheckAll.setChecked(false);
            }
        }
    }

    class ViewHolder {
        CheckBox checkBox;

        ImageView image;
        TextView shopName;
        TextView content;
        TextView carNum;
        TextView price;
        TextView add;
        TextView red;
        TextView contentTextView;
        Button button; //��button
        View frontView;
        LinearLayout item_right, item_left;

    }

    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {

            case R.id.subtitle:
                isBatchModel = !isBatchModel;
                if (isBatchModel) {
                    mEdit.setText(getResources().getString(R.string.menu_enter));
                    mDelete.setText(getResources().getString(R.string.menu_del));
                    mBottonLayout.setVisibility(View.GONE);
                    mFavorite.setVisibility(View.VISIBLE);

                } else {
                    mEdit.setText(getResources().getString(R.string.menu_edit));

                    mFavorite.setVisibility(View.GONE);
                    mBottonLayout.setVisibility(View.VISIBLE);
                    mDelete.setText(getResources().getString(R.string.menu_sett));
                    totalPrice = 0;
                    mPriceAll.setText("总价" + totalPrice);
                }
                break;

            case R.id.check_box_all:
                totalPrice = 0;
                if (mCheckAll.isChecked()) {
                    for (int i = 0; i < mListData.size(); i++) {
                        mListData.get(i).setChoose(true);

                        if (mListData.get(i).isChoose()) {
                            totalPrice = totalPrice + mListData.get(i).getCarNum()
                                    * mListData.get(i).getPrice();
                        }
                    }
                    mListAdapter.notifyDataSetChanged();
                    mPriceAll.setText(totalPrice + "元");
                } else {
                    for (int i = 0; i < mListData.size(); i++) {
                        mListData.get(i).setChoose(false);
                        mListAdapter.notifyDataSetChanged();
                    }
                    mPriceAll.setText(totalPrice + "元");
                }
                break;

            case R.id.tv_cart_buy_or_del:
                if (isBatchModel) {
                    Iterator it = mListData.iterator();
                    while (it.hasNext()) {
                        DataBean g = (DataBean) it.next();
                        if (g.isChoose()) {
                            it.remove();
                        }
                    }
                    mListAdapter.notifyDataSetChanged();
                } else {
                    if (totalPrice != 0) {
                         /*Intent intent = new Intent();
                         intent.setClass(MainActivity.this,
                         OrderFillActivity.class);
                         startActivity(intent);*/
                    } else {
                        Toast.makeText(ShoppingCartPageActivity.this, "没有选择商品",
                                Toast.LENGTH_SHORT).show();
                        mListAdapter.notifyDataSetChanged();
                        return;
                    }
                }
                break;
            case R.id.back:
                onBackPressed();
                break;
//            case R.id.tv_cart_move_favorite:
//                wxShare();
//                break;
            default:
                break;
        }
    }

    /**
     * �����
     */
    public void count() {
        totalPrice = 0;// �����
        if (mListData != null && mListData.size() > 0) {
            for (int i = 0; i < mListData.size(); i++) {
                if (mListData.get(i).isChoose()) {
                    totalPrice = totalPrice + mListData.get(i).getCarNum() * mListData.get(i).getPrice();
                }
            }
            mPriceAll.setText("一共" + totalPrice + "元");
        }
    }

    public void select() {
        int count = 0;
        for (int i = 0; i < mListData.size(); i++) {
            if (mListData.get(i).isChoose()) {
                count++;
            }
        }
        if (count == mListData.size()) {
            mCheckAll.setChecked(true);
        } else {
            isSelect = true;
            mCheckAll.setChecked(false);
        }
    }

    //微信分享图片
//    public void wxShare(){
//        Bitmap bitmap= BitmapFactory.decodeResource(getResources(),R.mipmap.shopping_cart_show);
//
//        //初始化WXImageObject和WXMediamessage对象
//        WXImageObject imageObject=new WXImageObject(bitmap);
//        WXMediaMessage msg=new WXMediaMessage();
//        msg.mediaObject=imageObject;
//        // 设置缩略图
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.PNG, 100, baos);
//        msg.thumbData = baos.toByteArray();

//        Bitmap ibitmap=Bitmap.createScaledBitmap(bitmap,120,120,true);
//        bitmap.recycle();
//        msg.thumbData = Util.bmpToByteArray(ibitmap, true);

//        SendMessageToWX.Req req = new SendMessageToWX.Req();
//        req.transaction = buildTransaction("img");
//        req.message = msg;
//        req.scene = SendMessageToWX.Req.WXSceneTimeline;//判断是否发送到朋友圈
//        api.sendReq(req);
//    }
//
//    public void regToWx(){
//        api= WXAPIFactory.createWXAPI(this,APP_ID,true);
//        api.registerApp("wx92055528e224f610");
//    }

}
