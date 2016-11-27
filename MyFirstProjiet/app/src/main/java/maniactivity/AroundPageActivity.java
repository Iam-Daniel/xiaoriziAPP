package maniactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import fragment.WorldPageFragment;

/**
 * Created by Admin on 2016/10/23.
 */
public class AroundPageActivity extends Activity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.world_around);
        textView = (TextView)findViewById(R.id.around_title_left);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(AroundPageActivity.this, WorldPageFragment.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
