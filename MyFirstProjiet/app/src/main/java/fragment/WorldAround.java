package fragment;

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
import listclass.ListInformation;
import maniactivity.ListViewInScrowView;

/**
 * Created by Administrator on 2016/11/27.
 */
public class WorldAround extends Fragment {
    View view;
    ListView listView;
    List<ListInformation> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.world_around, null);
        itemFindViewById();
        setData();
        ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity(), list, 3);
        listView.setAdapter(listViewAdapter);
        //限制ListView的高度，调用封装的方法刷新ListView
        {
            View view = listViewAdapter.getView(0, null, listView);
            view.measure(0, 0);
            int MeasuredHeight = view.getMeasuredHeight();
            Log.i("getMeasuredHeight", "" + MeasuredHeight);

            int DividerHeight = listView.getDividerHeight();
            Log.i("getMeasuredHeight", "" + DividerHeight);
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = (MeasuredHeight + DividerHeight) * list.size();
            listView.setLayoutParams(params);

            //封装的方法，用来刷新ListView
            new ListViewInScrowView().setListViewHeightBasedOnChildren(listView);
            Log.i("listView.height", "" + listView.getHeight());
        }
        return view;
    }


    private void itemFindViewById() {
        listView = (ListView) view.findViewById(R.id.listView);

    }

    private void itemSetOnClickListener() {

    }

    private void setData() {
        list = new ArrayList<>();
        ListInformation information;
        for (int t = 0; t < 10; t++) {
            information = new ListInformation();
            information.setAuthor("author" + t);
            information.setImg(R.mipmap.icon_bg_kitchen);
            information.setMedia(1);
            information.setIcon_head(R.mipmap.icon_head);
            information.setTime_y_m_d("2016-11-11");
            information.setTime_f_a("PM");
            information.setTime_m_s("" + t + ":" + t * 20);
            information.setNumb_f("" + t * 10);
            information.setNumb_m("" + t);
            information.setTitle_bottom("-扬州什锦-");
            list.add(information);
        }
    }
}
