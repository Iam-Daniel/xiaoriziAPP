package maniactivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/12/1.
 */
public class CouponsPageActivity extends BaseActivity {
    TextView exitBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.coupons_layout);

        bindView();
    }

    private void bindView() {
        exitBack = (TextView) findViewById(R.id.exit_back);
        exitBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }
}
