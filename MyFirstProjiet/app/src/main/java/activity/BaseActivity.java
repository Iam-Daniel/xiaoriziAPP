package activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;


/**
 * Created by Administrator on 2016/10/24.
 */
public class BaseActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    public void startActivity(Context context, Class cls) {
        Intent intent = new Intent(context, cls);
        startActivity(intent);
    }
}
