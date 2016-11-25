package fragment;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.myfirstprojiet.R;

/**
 * Created by Administrator on 2016/11/25.
 */
public class ConcernPageFragment extends Fragment {
    public ConcernPageFragment() {
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.concern_page, container, false);
        return view;
    }
}
