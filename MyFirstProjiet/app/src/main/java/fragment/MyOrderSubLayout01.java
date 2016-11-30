package fragment;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;
import java.util.List;


import adapter.MyOrderAdapter;
import listclass.MyOrderData;

/**
 * Created by Administrator on 2016/11/30.
 */
public class MyOrderSubLayout01 extends Fragment {
    View view;
    ListView listView;
    List<MyOrderData> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.kitchen_sub_layout, container, false);
        itemFindViewById();
        setData();
        MyOrderAdapter myOrderAdapter = new MyOrderAdapter(getActivity(), list, 2);
        listView.setAdapter(myOrderAdapter);
        /*{
            View view = listViewAdapter.getView(0, null, listView);
            view.measure(0, 0);
            int MeasuredHeight = view.getMeasuredHeight();
            int DividerHeight = listView.getDividerHeight();
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = (MeasuredHeight + DividerHeight) * list.size();
            listView.setLayoutParams(params);
        }*/
        return view;
    }

    private void itemFindViewById() {
        listView = (ListView) view.findViewById(R.id.listView);

    }

    private void setData() {
        list = new ArrayList<>();
        MyOrderData myOrderData;
        for (int t = 0; t < 10; t++) {
            myOrderData = new MyOrderData();
            myOrderData.setCooking_img(R.mipmap.icon_luan);
            myOrderData.setCooking_name("谭王见" + t+"号小号");
            myOrderData.setDate("2016-11-30");
            myOrderData.setCooking_method("" + t);
            myOrderData.setDoing_counts("1000" + t * 10);
            myOrderData.setCollect_counts("5");

            list.add(myOrderData);
        }
    }
}
