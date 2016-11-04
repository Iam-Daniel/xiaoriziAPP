package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/18.
 */
public class SearchPageActivity extends BaseActivity {
    ImageView searchBackImg;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_page);

        searchBackImg = (ImageView) findViewById(R.id.search_back_img);
        searchBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(SearchPageActivity.this,HomepageActivity.class);
            }
        });
    }
}
