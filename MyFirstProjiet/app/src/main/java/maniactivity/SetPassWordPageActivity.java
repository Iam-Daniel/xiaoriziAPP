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
public class SetPassWordPageActivity extends BaseActivity {

    ImageView setPasswordBackImg;
    RelativeLayout setPasswordToNumber;
    RelativeLayout setPasswordToPassWork;
    RelativeLayout setPasswordToAddress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setpassword_layout);
        setPasswordToNumber = (RelativeLayout)findViewById(R.id.setpassword_to_number);
        setPasswordToPassWork = (RelativeLayout)findViewById(R.id.setpassword_to_passwork);
        setPasswordToAddress = (RelativeLayout)findViewById(R.id.setpassword_to_address);

//        返回到我的主页
        setPasswordBackImg = (ImageView)findViewById(R.id.setPassword_back_img);
        setPasswordBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SetPassWordPageActivity.this,MyHomePageLayoutActivity.class);
                finish();
            }
        });
//        跳转到账号管理页面
        setPasswordToNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SetPassWordPageActivity.this,NumberPageActivity.class);
                finish();
            }
        });
//        跳转到设置密码页面
        setPasswordToPassWork.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SetPassWordPageActivity.this,PassWorkPageActivity.class);
                finish();
            }
        });
//        跳转到收货地址页面
        setPasswordToAddress.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SetPassWordPageActivity.this,AddressPageActivity.class);
                finish();
            }
        });
    }
}
