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

import adapter.MyCollectionOrderAdapter;
import listclass.MyCollectionOrderData;

/**
 * Created by Administrator on 2016/11/30.
 */
public class MyCollectionPage02 extends Fragment {
    View view;
    ListView listView;
    List<MyCollectionOrderData> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.kitchen_sub_layout, container, false);
        itemFindViewById();
        setData();

        MyCollectionOrderAdapter myCollectionOrderData = new MyCollectionOrderAdapter(getActivity(), list, 2);
        listView.setAdapter(myCollectionOrderData);

        return view;
    }

    private void itemFindViewById() {
        listView = (ListView) view.findViewById(R.id.listView);

    }

    private void itemSetOnClickListener() {

    }

    public void setData() {
        list = new ArrayList<>();
        MyCollectionOrderData myCollectionOrderData;
        for (int i = 0; i < 20; i++) {
            myCollectionOrderData = new MyCollectionOrderData();
            myCollectionOrderData.setImg(R.mipmap.icon_luan);
            myCollectionOrderData.setDate("2016-11-30");
            myCollectionOrderData.setMethod("日本动漫谭王见监制");
            myCollectionOrderData.setPeople("金木研");
            myCollectionOrderData.setTitle("东京食尸鬼" + i);
            myCollectionOrderData.setTotal("100" + i * 10);

            list.add(myCollectionOrderData);
        }
    }
}
