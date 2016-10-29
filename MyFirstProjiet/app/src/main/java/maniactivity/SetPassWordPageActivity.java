package maniactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;

import com.example.administrator.myfirstprojiet.R;

import acativity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class SetPassWordPageActivity extends BaseActivity {
    RelativeLayout setpasswordToNumber;
    RelativeLayout setpasswordToPasswork;
    RelativeLayout setpasswordToAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setpassword_layout);
        setpasswordToNumber = (RelativeLayout)findViewById(R.id.setpassword_to_number);
        setpasswordToPasswork = (RelativeLayout)findViewById(R.id.setpassword_to_passwork);
        setpasswordToAddress = (RelativeLayout)findViewById(R.id.setpassword_to_address);

        setpasswordToNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SetPassWordPageActivity.this,NumberPageActivity.class);
                finish();
            }
        });
        setpasswordToPasswork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SetPassWordPageActivity.this,PassWorkPageActivity.class);
                finish();
            }
        });
        setpasswordToAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SetPassWordPageActivity.this,AddressPageActivity.class);
                finish();
            }
        });
    }
}
