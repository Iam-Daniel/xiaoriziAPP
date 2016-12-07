package maniactivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import activity.BaseActivity;

/**
 * Created by Administrator on 2016/10/29.
 */
public class UpLoadWorkPageActivity extends BaseActivity {
    private static final int ALBUM_REQUEST_CODE = 1;
    private static final String IMAGE_UNSPECIFIED = "image/*";


    ImageView uploadWorkBackImg;
    ImageView gouOneImg;
    ImageView gouTwoImg;
    ImageView gouThreeImg;
    RelativeLayout gouOne;
    RelativeLayout gouTwo;
    RelativeLayout gouThree;
    ImageView addWorkImg;//上传作品的ImageView
    TextView submit;//确定上传控件

    String TAG = "PhotoActivity";
    // @AbIocView(id = R.id.photo_full)
    LinearLayout photo_full;

    private static String srcPath;
    private static final int TIME_OUT = 10 * 1000;   //超时时间
    private static final String CHARSET = "utf-8"; //设置编码
    private String loginKey;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.uploadwork_layout);

        bindView();

        View.OnClickListener keyboard_hide = new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                /*InputMethodManager imm = (InputMethodManager) TAG.this
                        .getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.hideSoftInputFromWindow(v.getWindowToken(), 0);*/
            }

        };
        photo_full.setClickable(true);
        photo_full.setOnClickListener(keyboard_hide);
    }

    private void bindView() {
        photo_full = (LinearLayout) findViewById(R.id.photo_full);//uploadwork_layout页面的最外层布局id

        uploadWorkBackImg = (ImageView) findViewById(R.id.uploadWork_back_img);
        //        返回到我的作品页面
        uploadWorkBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(UpLoadWorkPageActivity.this,MyWorksPageActivity.class);
                finish();
            }
        });
        //上传头像的控件
        /*addWorkImg = (ImageView) findViewById(R.id.add_work_img);
        addWorkImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image:*//*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                //取得相片后返回本界面
                startActivityForResult(intent, 1);
            }
        });*/
        //上传头像的控件  另一种写法(不一样的上传方式)
        addWorkImg = (ImageView) findViewById(R.id.add_work_img);
        addWorkImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.i(TAG, "相册");
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                //Intent intent = new Intent(Intent.ACTION_PICK, null);
                intent.setType("image:/*");
                //intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, IMAGE_UNSPECIFIED);//  IMAGE_UNSPECIFIED = "image/*";
                startActivityForResult(intent, ALBUM_REQUEST_CODE);
            }
        });

        gouOneImg = (ImageView) findViewById(R.id.gou_one_img);
        gouTwoImg = (ImageView) findViewById(R.id.gou_two_img);
        gouThreeImg = (ImageView) findViewById(R.id.gou_three_img);

        gouOne = (RelativeLayout) findViewById(R.id.gou_one);
        gouTwo = (RelativeLayout) findViewById(R.id.gou_two);
        gouThree = (RelativeLayout) findViewById(R.id.gou_three);

        submit = (TextView) findViewById(R.id.submit);

        gouOne.setOnClickListener(onClickListener);
        gouTwo.setOnClickListener(onClickListener);
        gouThree.setOnClickListener(onClickListener);
        submit.setOnClickListener(onClickListener);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == ALBUM_REQUEST_CODE) {
            if (data == null) {
                return;
            }
            Bundle bundle = data.getExtras();
            Bitmap bitmap = bundle.getParcelable("data");
            ImageView addWorkIma = (ImageView) findViewById(R.id.add_work_img);
            addWorkIma.setImageBitmap(bitmap);
        }
    }

    View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            switch (view.getId()) {
                case R.id.gou_one:
                    if (gouOneImg.getVisibility() == View.INVISIBLE) {
                        gouOneImg.setVisibility(View.VISIBLE);
                        gouTwoImg.setVisibility(View.INVISIBLE);
                        gouThreeImg.setVisibility(View.INVISIBLE);
                    } else if (gouOneImg.getVisibility() == View.VISIBLE) {
                        gouOneImg.setVisibility(View.VISIBLE);
                        gouTwoImg.setVisibility(View.INVISIBLE);
                        gouThreeImg.setVisibility(View.INVISIBLE);
                    } else {
                        gouOneImg.setVisibility(View.VISIBLE);
                    }
                    break;
                case R.id.gou_two:
                    if (gouTwoImg.getVisibility() == View.INVISIBLE) {
                        gouOneImg.setVisibility(View.INVISIBLE);
                        gouTwoImg.setVisibility(View.VISIBLE);
                        gouThreeImg.setVisibility(View.INVISIBLE);
                    } else if (gouTwoImg.getVisibility() == View.VISIBLE) {
                        gouOneImg.setVisibility(View.INVISIBLE);
                        gouTwoImg.setVisibility(View.VISIBLE);
                        gouThreeImg.setVisibility(View.INVISIBLE);
                    } else {
                        gouTwoImg.setVisibility(View.VISIBLE);
                    }
                    break;
                case R.id.gou_three:
                    if (gouThreeImg.getVisibility() == View.INVISIBLE) {
                        gouOneImg.setVisibility(View.INVISIBLE);
                        gouTwoImg.setVisibility(View.INVISIBLE);
                        gouThreeImg.setVisibility(View.VISIBLE);
                    } else {
                        gouOneImg.setVisibility(View.INVISIBLE);
                        gouTwoImg.setVisibility(View.INVISIBLE);
                        gouThreeImg.setVisibility(View.VISIBLE);
                    }
                    break;
            }
        }
    };
}
