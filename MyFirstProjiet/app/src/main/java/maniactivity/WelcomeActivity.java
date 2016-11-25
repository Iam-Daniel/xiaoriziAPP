package maniactivity;

import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.view.animation.Animation.AnimationListener;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/11/25.
 */
public class WelcomeActivity extends BaseActivity {
    private ImageView welcomeImg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);

        bindView();
    }

    public void bindView() {
        welcomeImg = (ImageView) findViewById(R.id.welcome_img);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0.2f, 1.0f);
        alphaAnimation.setDuration(3000);// 设置动画显示时间
        welcomeImg.startAnimation(alphaAnimation);
        alphaAnimation.setAnimationListener(new AnimationImpl());
    }

    public class AnimationImpl implements AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {
            welcomeImg.setBackgroundResource(R.mipmap.start);//设置启动页面的动画图片
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            skip();// 动画结束后跳转到别的页面
        }

        @Override
        public void onAnimationRepeat(Animation animation) {  //Repeat：重复

        }
    }

    private void skip() {
        startActivity(WelcomeActivity.this, MenuBottomPageActivity.class);
        finish();
    }
}
