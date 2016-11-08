package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class HeadPageActivity extends BaseActivity {
    ImageView head_back_img;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head_layout);

        head_back_img = (ImageView) findViewById(R.id.head_back_img);
        head_back_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(HeadPageActivity.this,MyHomePageLayoutActivity.class);
                finish();
            }
        });
    }
}
