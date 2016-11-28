package maniactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/19.
 */
public class LogInPageActivity extends BaseActivity {
    TextView login_to_logup;
    TextView login_forgetPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.log_in_page);

        bindView();
    }

    private void bindView() {
        login_to_logup = (TextView) findViewById(R.id.login_to_logup);
        login_to_logup.setOnClickListener(onClickListener);

        login_forgetPassword = (TextView) findViewById(R.id.login_forgetPassword);
        login_forgetPassword.setOnClickListener(onClickListener);
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.login_forgetPassword:
                    startActivity(LogInPageActivity.this, ForgetPassWordPageActivity.class);
                    break;
                case R.id.login_to_logup:
                    startActivity(LogInPageActivity.this, LogUpPageActivity.class);
                    break;
            }
        }
    };
}
