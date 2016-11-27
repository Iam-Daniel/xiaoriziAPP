package maniactivity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;
import java.util.List;

import adapter.ListViewAdapter;

/**
 * Created by admin on 2016/11/26.
 */
public class KitchenSubLayout01 extends Fragment {
    ListView listView;
    List<ListInformation> list;
    //热门

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.kitchen_sub_layout,null);
        listView = (ListView)view.findViewById(R.id.kitchenLayoutListView) ;
        setData();
        ListViewAdapter listViewAdapter = new ListViewAdapter(getContext(),list,2);
        listView.setAdapter(listViewAdapter);
        {
            View listViewItem = listViewAdapter.getView(0, null, listView);
            listViewItem.measure(0, 0);
            int MeasuredHeight = listViewItem.getMeasuredHeight();
            Log.i("getMeasuredHeight", "" + MeasuredHeight);

            int DividerHeight = listView.getDividerHeight();
            Log.i("getDividerHeight", "" + DividerHeight);
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = (MeasuredHeight + DividerHeight) * list.size();
            Log.i("params.height", "" + params.height);
            listView.setLayoutParams(params);
            //封装的方法，用来刷新ListView
            new ListViewInScrowView().setListViewHeightBasedOnChildren(listView);
            Log.i("listView.height", "" + listView.getHeight());
        }
        return view;
    }

    private void setData(){
        list = new ArrayList<>();
        ListInformation information;
        for (int t =0;t<10;t++){
            information  = new ListInformation();
            information.setAuthor("author"+t);
            information.setImg(R.mipmap.icon_bg_kitchen);
            information.setIcon_head(R.mipmap.icon_head);
            information.setNumb_f(""+t*10);
            information.setNumb_m(""+t);
            information.setDetails("我是做法我是做法我是做法我是做法我是做法我是做法我是做法我是做法我是做法");
            list.add(information);
        }
    }
}
