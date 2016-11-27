package fragment;


import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myfirstprojiet.R;

import maniactivity.BaseFragment;

/**
 * Created by Administrator on 2016/11/25.
 */
public class SearchFragment extends BaseFragment {
    public SearchFragment() {

    }

    @Override
    protected int setLayoutResouceId() {
        return 0;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.search_layout, container, false);
        return view;
    }



    private void itemFindViewById(){

    }
    private void itemSetOnClickListener(){

    }
}
