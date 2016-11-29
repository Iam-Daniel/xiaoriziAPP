package maniactivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.widget.ImageView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/11/28.
 */
public class WelcomeActivity extends BaseActivity {
    ImageView welcomeImg = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_layout);

        bindView();
    }

    private void bindView() {
        welcomeImg = (ImageView) this.findViewById(R.id.welcome_img);
        AlphaAnimation animation = new AlphaAnimation(0.3f, 1.0f);
        animation.setDuration(5000);// 设置动画显示时间
        welcomeImg.startAnimation(animation);
        animation.setAnimationListener(new AnimationImpl());
    }

    private class AnimationImpl implements Animation.AnimationListener {

        @Override
        public void onAnimationStart(Animation animation) {
            welcomeImg.setBackgroundResource(R.mipmap.start);
        }

        @Override
        public void onAnimationEnd(Animation animation) {
            skip(); // 动画结束后跳转到别的页面
        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }

    }

    private void skip() {
        //startActivity(WelcomeActivity.this, HomepageActivity.class);
        startActivity(new Intent(this, HomepageActivity.class));
        finish();
    }
}
