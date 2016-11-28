package maniactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;
import fragment.WorldPageFragment;

/**
 * Created by Administrator on 2016/10/29.
 */
public class MyHomePageLayoutActivity extends BaseActivity {
    LinearLayout myHomepageConcernLinear;
    LinearLayout myHomepageFansLinear;
    LinearLayout informationTextView;
    LinearLayout myHomepageOrderImg;
    ImageView leftBack;
    LinearLayout myHomepageCollectionImg;
    LinearLayout myHomepageDiscountImg;
    LinearLayout myHomepageStatisticsImg;
    RelativeLayout myHomepageMyWorksRtl;
    RelativeLayout myHomepageMyMenuRtl;
    RelativeLayout myHomepageSetRtl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.myhomepage_layout);
        /*leftBack = (ImageView) findViewById(R.id.left_back);
        leftBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
    }
}
