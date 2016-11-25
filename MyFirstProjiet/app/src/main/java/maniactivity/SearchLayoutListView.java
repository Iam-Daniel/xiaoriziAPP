package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.administrator.myfirstprojiet.R;

import java.lang.reflect.AccessibleObject;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/11/25.
 */
public class SearchLayoutListView extends Activity {
    ListView listView;
    List<SearchLayoutListInformation> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_layout_list_view);
        setInfo();
        listView = (ListView)findViewById(R.id.search_layout_listView);
        View view = getLayoutInflater().inflate(R.layout.search_layout,null);
        listView.addHeaderView(view);
        listView.setAdapter(new SearchLayoutAdapter(this,list));
    }

    private void setInfo(){
        list = new ArrayList<>();
        SearchLayoutListInformation information;
        for (int t =0;t<10;t++){
            information  = new SearchLayoutListInformation();
            information.setAuthor("author"+t);
            information.setImg(R.mipmap.icon_bg_kitchen);
            information.setTime_y_m_d("2016-11-"+t);
            information.setNumb_f("AM");
            information.setTime_m_s("16:"+t);
            information.setIcon_head(R.mipmap.icon_head);
            information.setNumb_f(""+t*10);
            information.setNumb_m(""+t);
            list.add(information);
        }
    }
}
