package maniactivity;

import android.os.Bundle;
import android.text.InputFilter;
import android.text.InputType;
import android.text.method.NumberKeyListener;
import android.text.method.PasswordTransformationMethod;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

public class LogUpPageActivity extends BaseActivity {
    TextView log_up_text_bottom_agreement;
    ImageView logUp_back_img;
    EditText passwordEditText;

    /*---------   $pattern = '/^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{6,10}$/';  正则表达式，
    分开来注释一下：
            ^ 匹配一行的开头位置
            (?![0-9]+$) 预测该位置后面不全是数字
    (?![a-zA-Z]+$) 预测该位置后面不全是字母
    [0-9A-Za-z] {6,10} 由6-10位数字或这字母组成
    $ 匹配行结尾位置   --------*/

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
        passwordEditText = (EditText) findViewById(R.id.password_editText);
        logUp_back_img = (ImageView) findViewById(R.id.logUp_back_img);

        logUp_back_img.setOnClickListener(onClickListener);
//        密码输入框的设置属性
        passwordEditText.setOnClickListener(onClickListener);
//        passwordEditText.setInputType(InputType.TYPE_CLASS_PHONE); //输入类型
        passwordEditText.setFilters(new InputFilter[]{new InputFilter.LengthFilter(24)}); //最大输入长度
        passwordEditText.setTransformationMethod(PasswordTransformationMethod.getInstance()); //设置为密码输入框
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
                case R.id.password_editText:

                    break;
            }
        }
    };
}
