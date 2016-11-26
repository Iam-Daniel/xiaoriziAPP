package maniactivity;

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

/**
 * Created by admin on 2016/11/26.
 */
public class KitchenSubLayout03 extends Fragment {
    //最新
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
            information.setNumb_f(""+t*30);
            information.setNumb_m(""+t*3);
            information.setDetails("我是做法我是做法我是做法我是做法我是做法我是做法我是做法我是做法我是做法");
            list.add(information);
        }
    }
}
