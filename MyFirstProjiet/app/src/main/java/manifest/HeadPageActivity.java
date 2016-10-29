package manifest;

import android.app.Activity;
import android.os.Bundle;

import com.example.administrator.myfirstprojiet.R;

/**
 * Created by Administrator on 2016/10/29.
 */
public class HeadPageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head_layout);
    }
}
