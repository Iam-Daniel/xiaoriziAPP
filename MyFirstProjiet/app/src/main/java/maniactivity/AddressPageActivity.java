package maniactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class AddressPageActivity extends BaseActivity{
    ImageView addressToSetpassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_layout);
        addressToSetpassword = (ImageView)findViewById(R.id.address_to_setpassword);
        addressToSetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(AddressPageActivity.this,SetPassWordPageActivity.class);
                finish();
            }
        });
    }
}
