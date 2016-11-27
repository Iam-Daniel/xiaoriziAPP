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
public class KitchenSubLayout02 extends Fragment {
    //推荐
    ListView listView;
    List<ListInformation> list;

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
            Log.i("getMeasuredHeight", "" + DividerHeight);
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = (MeasuredHeight + DividerHeight) * list.size();
            listView.setLayoutParams(params);

            //封装的方法，用来刷新ListView
            new ListViewInScrowView().setListViewHeightBasedOnChildren(listView);
            Log.i("getMeasuredHeight", "" + view.getMeasuredHeight());
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
            information.setNumb_f(""+t*20);
            information.setNumb_m(""+t*2);
            information.setDetails("我是做法我是做法我是做法我是做法我是做法我是做法我是做法我是做法我是做法");
            list.add(information);
        }
    }
}
