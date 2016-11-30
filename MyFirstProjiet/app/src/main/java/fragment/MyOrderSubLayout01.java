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

import adapter.ListViewAdapter;

import listclass.MyOrderData;
import maniactivity.ListInformation;

/**
 * Created by Administrator on 2016/11/30.
 */
public class MyOrderSubLayout01 extends Fragment {
    View view;
    ListView listView;
    List<ListInformation> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.kitchen_sub_layout, container, false);
        itemFindViewById();
        setData();
        ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity(), list, 2);
        listView.setAdapter(listViewAdapter);
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
            myOrderData.setCooking_img(R.mipmap.icon_bg_kitchen);
            myOrderData.setCooking_name("000");
            myOrderData.setDate("0000000");
            myOrderData.setCooking_method("" + t);
            myOrderData.setText("0.0");
            myOrderData.setDoing_counts("0.0");

            //list.add(myOrderData);
        }
    }
}
