package maniactivity;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;
import view.MyView;

/**
 * Created by Administrator on 2016/10/29.
 */
public class StatisticsPageActivity extends BaseActivity {
    ImageView statisticsBackImg;
    LinearLayout root_linear;
    View view0;
    View view1;
    View view2;
    View view3;
    LinearLayout linaerlayout_line;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.statistics_layout);

        root_linear= (LinearLayout) findViewById(R.id.root_linear);

//        点击返回到我的主页
        statisticsBackImg = (ImageView) findViewById(R.id.statistics_back_img);
        statisticsBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(StatisticsPageActivity.this,MyHomePageLayoutActivity.class);
                finish();
            }
        });
        view0=findViewById(R.id.view0);
        view1=findViewById(R.id.view1);
        view2=findViewById(R.id.view2);
        view3=findViewById(R.id.view3);
        linaerlayout_line= (LinearLayout) findViewById(R.id.linaerlayout_line);

        int[] location=new int[2];
        view0.getLocationOnScreen(location);
        Log.i("location","X"+location[0]+"Y"+location[1]);
//
//        Button chaxun= (Button) findViewById(R.id.chaxun);
//        chaxun.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                int[] location=new int[2];
//                view0.getLocationOnScreen(location);
//                int X_all = view0.getRight();
//                Log.i("location","X"+location[0]+"Y"+location[1]);
//                Log.i("X_all","X_all"+X_all);
//            }
//        });

        getviewPosion();
        myView= (MyView) findViewById(R.id.myview);
        new Thread(){
            @Override
            public void run() {
                Message message=new Message();
                handler.sendMessage(message);
            }
        }.start();

    }

    Handler handler=new Handler(){
        @Override
        public void handleMessage(Message msg) {
            myView.setXandY(X,Y);
            super.handleMessage(msg);
        }
    };

    public void getviewPosion(){
        ViewTreeObserver observer = root_linear.getViewTreeObserver();
        observer .addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            @Override
            public void onGlobalLayout() {
                root_linear.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                final int w = root_linear.getMeasuredWidth();
                final int h = root_linear.getMeasuredHeight();
                Log.i("root_linear","w"+w+"h"+h);
                int[] location=new int[2];
                view0.getLocationOnScreen(location);
                int X_all = view0.getRight();
                Log.i("location","X"+location[0]+"Y"+location[1]);
                Log.i("getRight","getRight"+X_all);
                int X_qi = view0.getLeft();
                Log.i("getLeft","getLeft"+X_qi);

                setpoint(location,X_qi,X_all);
            }
        });
    }

    MyView myView;
    int[] X=new int[5];
    int[] Y=new int[5];
    public void setpoint(int[] location,int X_getStart,int X_end){
        int X_all = X_end-X_getStart;//X轴的宽度
//        int X_qi = location[0]+X_getStart;
        int X_qi = location[0];//X轴起始位置
        int y_all = location[1];
        Log.i("X_all","X_all"+X_all);
        Log.i("X_qi","X_qi"+X_qi);
        Log.i("y_all","y_all"+y_all);
        int a=X_all/4;
        int b=X_qi;
        for (int i=0;i<5;i++ ){
            X[i]=b+(a*i);
        }

        //获取通知栏的高度大小
        int[] notify_high=new int[2];
        linaerlayout_line.getLocationOnScreen(notify_high);

        for (int y=0;y<5;y++){
            int ym=Math.round((float)Math.random()*3);
            int[] ints=new int[2];
            switch (ym){
                //获取每个点的Y轴位置
                case 0:
                    Y[y]= location[1]-notify_high[1];
                    break;
                case 1:
                    view1.getLocationOnScreen(ints);
                    Y[y]= ints[1]-notify_high[1];
                    break;
                case 2:
                    view2.getLocationOnScreen(ints);
                    Y[y]= ints[1]-notify_high[1];
                    break;
                case 3:
                    view3.getLocationOnScreen(ints);
                    Y[y]= ints[1]-notify_high[1];
                    break;
            }
        }
    }
}
