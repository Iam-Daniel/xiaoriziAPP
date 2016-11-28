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
import maniactivity.ListInformation;

/**
 * Created by admin on 2016/11/26.
 */
public class KitchenSubLayout01 extends Fragment {
    View view;
    ListView listView;
    List<ListInformation> list;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.kitchen_sub_layout, null);
        itemFindViewById();
        setData();
        ListViewAdapter listViewAdapter = new ListViewAdapter(getActivity(), list, 2);
        listView.setAdapter(listViewAdapter);
        //限制ListView的高度
        {
            View view = listViewAdapter.getView(0, null, listView);
            view.measure(0, 0);
            int MeasuredHeight = view.getMeasuredHeight();
            int DividerHeight = listView.getDividerHeight();
            ViewGroup.LayoutParams params = listView.getLayoutParams();
            params.height = (MeasuredHeight + DividerHeight) * list.size();
            listView.setLayoutParams(params);
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
            information.setIcon_head(R.mipmap.icon_head);
            information.setDetails("我是做法我是做法我是做法我是做法我是做法我是做法");
            information.setNumb_f("" + t * 10);
            information.setNumb_m("" + t);
            {
/*                icon_head.setImageResource(information.getIcon_head());
                img.setImageResource(information.getImg());
                author.setText(information.getAuthor());
                numb_f.setText(information.getNumb_f());
                numb_m.setText(information.getNumb_m());
                changeLayout.setVisibility(View.GONE);
                details.setText(information.getDetails());*/
            }
            list.add(information);
        }
    }
}