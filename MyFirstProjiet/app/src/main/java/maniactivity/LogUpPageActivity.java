package maniactivity;

import android.content.Context;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.util.HashMap;

import activity.BaseActivity;
import cn.smssdk.EventHandler;
import cn.smssdk.SMSSDK;
import cn.smssdk.gui.ContactsPage;
import cn.smssdk.gui.RegisterPage;

public class LogUpPageActivity extends BaseActivity {
    Context context;
    TextView log_up_text_bottom_agreement;
    ImageView logUp_back_img;
    EditText passwordEditText;
    TextView send_textView;
    LogUpPageActivity logUpPageActivity;

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
        send_textView = (TextView) findViewById(R.id.send_textView);
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
                case R.id.send_textView:
                    register();
                    break;
            }
        }
    };

    public void register() {
        SMSSDK.initSDK(this, "f2acd9ee1622", "72c569594fa96816dcb1bfe529dc061b");
        SMSSDK.getVerificationCode("86", "18323706243");
        send_textView.setEnabled(false);
        send_textView.setBackgroundResource(R.color.rosybrown);
        //打开注册页面,必须这样写RegisterPage。（这是jar里面的）注意
        RegisterPage registerPage = new RegisterPage();
        registerPage.setRegisterCallback(new EventHandler() {
            public void afterEvent(int event, int result, Object data) {
                // 解析注册结果
                if (result == SMSSDK.RESULT_COMPLETE) {
                    @SuppressWarnings("unchecked")
                    HashMap<String, Object> phoneMap = (HashMap<String, Object>) data;
                    String country = (String) phoneMap.get("country");
                    String phone = (String) phoneMap.get("phone");

                    // 提交用户信息, 提交的资料将当作“通信录好友”功能的建议资料。
                    registerUser(country, phone);

                    //打开通信录好友列表页面
                    ContactsPage contactsPage = new ContactsPage();
                    contactsPage.show(context);

                    //在验证过后可以处理自己想要的操作
                    Log.v("TAG", "success...");
                }
            }
        });
        registerPage.show(this);
    }

    //这个方法要自己写
    protected void registerUser(String country, String phone) {
        //提交的资料将当作“通信录好友”功能的建议资料。
        String uid = "1223";
        String nickName = "yj";
        SMSSDK.submitUserInfo(uid, nickName, null, country, phone);
    }
}
