package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myfirstprojiet.R;

/**
 * Created by Administrator on 2016/12/1.
 */
public class AboutUsPageActivity extends Activity implements View.OnClickListener {
    private ImageView aboutUsBackImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.aboutus_layout);

        bindView();
    }

    private void bindView() {
        aboutUsBackImg = (ImageView) findViewById(R.id.aboutUs_back_img);
        aboutUsBackImg.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        finish();
    }
}
