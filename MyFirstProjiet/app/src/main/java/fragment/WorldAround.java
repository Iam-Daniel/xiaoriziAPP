package fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.administrator.myfirstprojiet.R;

/**
 * Created by Administrator on 2016/11/27.
 */
public class WorldAround extends Fragment {
    View view;
    ListView listView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.world_around,null);
        return view;
    }


    private void itemFindViewById(){
        
    }

    private void itemSetOnClickListener(){

    }
}
