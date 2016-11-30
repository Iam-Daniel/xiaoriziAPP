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
import listclass.MyCollectionData;
import maniactivity.ListInformation;

/**
 * Created by Administrator on 2016/11/30.
 */
public class MyCollectionPage01 extends Fragment {
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

        //限制ListView的高度
        /*{
            View view = listViewAdapter.getView(0, null, listView);
            view.measure(0, 0);
            int MeasuredHeight = view.getMeasuredHeight();
            int DividerHeight = listView.getDividerHeight();
            ViewGroup.LayoutParams params = listView.g
            etLayoutParams();
            params.height = (MeasuredHeight + DividerHeight) * list.size();
            listView.setLayoutParams(params);
        }*/
        return view;
    }

    private void itemFindViewById() {
        listView = (ListView) view.findViewById(R.id.listView);

    }

    private void itemSetOnClickListener() {

    }

    public void setData() {
        list = new ArrayList<>();
        MyCollectionData myCollectionData;
        for (int i = 0; i < 20; i++) {
            myCollectionData = new MyCollectionData();
            myCollectionData.setImg(R.mipmap.icon_add_img);
            myCollectionData.setDate("2016-11-30");
            myCollectionData.setMethod("日本动漫");
            myCollectionData.setPeople("金木研");
            myCollectionData.setTitle("东京食尸鬼");
            myCollectionData.setWho("我是神仙");
        }
    }
}
