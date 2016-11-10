package maniactivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import org.w3c.dom.Text;

/**
 * Created by admin on 2016/10/23.
 */
public class ConcernPageActivity extends Activity {
    TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.concern_page);
        textView = (TextView)findViewById(R.id.around_title_right);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(ConcernPageActivity.this,AroundPageActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
