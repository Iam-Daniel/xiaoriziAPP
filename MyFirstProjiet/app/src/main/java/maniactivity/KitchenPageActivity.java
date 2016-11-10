package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myfirstprojiet.R;

/**
 * Created by Administrator on 2016/10/29.
 */
public class KitchenPageActivity extends Activity {
    ImageView leftBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kitchen_layout);
        leftBack = (ImageView)findViewById(R.id.left_back);
        leftBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }

        });
    }
}
