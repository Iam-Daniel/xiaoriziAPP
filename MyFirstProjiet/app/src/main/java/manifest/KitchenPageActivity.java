package manifest;

import android.app.Activity;
import android.os.Bundle;

import com.example.administrator.myfirstprojiet.R;

/**
 * Created by Administrator on 2016/10/29.
 */
public class KitchenPageActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitchen_layout);
    }
}
