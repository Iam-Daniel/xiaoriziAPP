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
public class PassWorkPageActivity extends BaseActivity {
    ImageView passworkToSetpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.passwork_layout);
        passworkToSetpassword = (ImageView)findViewById(R.id.passwork_to_setpassword);
        passworkToSetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(PassWorkPageActivity.this,SetPassWordPageActivity.class);
                finish();
            }
        });
    }
}
