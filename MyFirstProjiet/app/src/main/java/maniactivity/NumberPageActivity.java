package maniactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class NumberPageActivity extends BaseActivity {
    RelativeLayout add_login;
    ImageView numberToSetpassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.number_layout);
        numberToSetpassword = (ImageView) findViewById(R.id.number_to_setpassword);
        numberToSetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(NumberPageActivity.this, SetPassWordPageActivity.class);
                finish();
            }
        });
        add_login = (RelativeLayout) findViewById(R.id.add_login);
        add_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(NumberPageActivity.this, LogInPageActivity.class);
            }
        });
    }
}
