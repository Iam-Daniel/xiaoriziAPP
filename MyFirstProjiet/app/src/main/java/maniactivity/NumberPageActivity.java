package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myfirstprojiet.R;

import acativity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class NumberPageActivity extends BaseActivity {
    ImageView numberToSetpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_layout);
        numberToSetpassword = (ImageView)findViewById(R.id.number_to_setpassword);
        numberToSetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(NumberPageActivity.this,SetPassWordPageActivity.class);
                finish();
            }
        });
    }
}
