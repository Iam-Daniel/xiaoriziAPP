package maniactivity;

import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

public class LogUpPageActivity extends BaseActivity {
    TextView log_up_text_bottom_agreement;
    ImageView logUp_back_img;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.log_up_page);

        bindView();
    }

    private void bindView() {
        log_up_text_bottom_agreement = (TextView) findViewById(R.id.log_up_text_bottom_agreement);
        log_up_text_bottom_agreement.setOnClickListener(onClickListener);

        logUp_back_img = (ImageView) findViewById(R.id.logUp_back_img);
        logUp_back_img.setOnClickListener(onClickListener);
    }

    //跳转到用户协议页面
    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.log_up_text_bottom_agreement:
                    startActivity(LogUpPageActivity.this, UserAgreementActivity.class);
                    break;
                case R.id.logUp_back_img:
                    finish();
                    break;
            }

        }
    };
}
