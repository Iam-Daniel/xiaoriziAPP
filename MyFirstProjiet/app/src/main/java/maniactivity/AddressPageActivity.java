package maniactivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.example.administrator.myfirstprojiet.R;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class AddressPageActivity extends BaseActivity {
    TextView save;
    ImageView addressToSetpassword;
    EditText name_edit;
    EditText phone_edit;
    EditText city_edit;
    EditText adress_info;
    String name;
    String phonenumber;
    String citylocation;
    String adress;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.address_layout);
        addressToSetpassword = (ImageView) findViewById(R.id.address_to_setpassword);
        addressToSetpassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(AddressPageActivity.this,SetPassWordPageActivity.class);
                finish();
            }
        });

        name_edit = (EditText) findViewById(R.id.name_edit);
        phone_edit = (EditText) findViewById(R.id.phone_edit);
        city_edit = (EditText) findViewById(R.id.city_edit);
        adress_info = (EditText) findViewById(R.id.address_info);

        getData();

        setData();
        save = (TextView) findViewById(R.id.save);
        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //isMobile();
                saveData();
                finish();
            }
        });

    }

    //设置输入框文字
    public void setData() {
        sharedPreferences = getSharedPreferences("Shipping_address", MODE_PRIVATE);
        if (!sharedPreferences.getString("name", "111").equals("111")) {
            name_edit.setText(sharedPreferences.getString("name", "111"));
            phone_edit.setText(sharedPreferences.getString("phonenumber", "111"));
            city_edit.setText(sharedPreferences.getString("city", "111"));
            adress_info.setText(sharedPreferences.getString("adress", "111"));
        }
    }

    /**
     * 验证是否是手机号码
     *
     * @param str
     * @return
     */
    public static boolean isMobile(String str) {
        Pattern pattern = Pattern.compile("^((13[0-9])|(14[0-9])|(15[^4,\\D])|(18[0,5-9])|(17[0-9]))\\d{8}$");
        Matcher matcher = pattern.matcher(str);
        if (matcher.matches()) {
            return true;
        } else {
            return false;
            //Toast.makeText(AddressPageActivity.this, "这不是一个手机号！", Toast.LENGTH_SHORT).show();
        }
    }

    //文字输入监听
    public void getData() {
        name_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                name = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        phone_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                phonenumber = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        city_edit.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                citylocation = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        adress_info.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adress = s.toString();
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    //保存数据
    SharedPreferences sharedPreferences;

    public void saveData() {
        sharedPreferences = getSharedPreferences("Shipping_address", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        if (sharedPreferences.getString("name", "空值") != null && sharedPreferences.getString("name", "空值") != name) {
            editor.clear();
            editor.commit();
        }
        editor.putString("name", name);
        editor.putString("phonenumber", phonenumber);
        editor.putString("city", citylocation);
        editor.putString("adress", adress);
        editor.commit();
    }

}
