package maniactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class ForgetPassWordPageActivity extends BaseActivity {
    ImageView forgetPassword_back_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.forgetpassword_layout);

        bindView();
    }

    private void bindView() {
        forgetPassword_back_img = (ImageView) findViewById(R.id.forgetPassword_back_img);
        forgetPassword_back_img.setOnClickListener(onClickListener);
    }

    //结束当前页面
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            finish();
        }
    };
}
