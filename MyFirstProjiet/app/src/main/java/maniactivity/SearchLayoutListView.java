package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.administrator.myfirstprojiet.R;

import java.util.ArrayList;
import java.util.List;

import adapter.ListViewAdapter;

/**
 * Created by Administrator on 2016/11/25.
 */
public class SearchLayoutListView extends Activity {
    ListView listView;
    List<ListInformation> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout_list_view);
        setInfo();
        listView = (ListView)findViewById(R.id.search_layout_listView);
        View view = getLayoutInflater().inflate(R.layout.search_layout,null);
        listView.addHeaderView(view);
        int type = 1;//调用适配器，申明是SearchLayoutListView调用
        listView.setAdapter(new ListViewAdapter(this,list,type));
    }

    private void setInfo(){
        list = new ArrayList<>();
        ListInformation information;
        for (int t =0;t<10;t++){
            information  = new ListInformation();
            information.setAuthor("author"+t);
            information.setImg(R.mipmap.icon_bg_kitchen);
            information.setTime_y_m_d("2016-11-"+t);
            information.setTime_f_a("AM");
            information.setTime_m_s("16:"+t);
            information.setIcon_head(R.mipmap.icon_head);
            information.setNumb_f(t*10);
            information.setNumb_m(t);
            list.add(information);
        }
    }
}
