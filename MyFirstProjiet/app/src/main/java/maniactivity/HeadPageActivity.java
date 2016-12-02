package maniactivity;

import android.content.ContentResolver;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.io.FileNotFoundException;

import activity.BaseActivity;
import classinit.CircularImage;

/**
 * Created by Administrator on 2016/10/29.
 */
public class HeadPageActivity extends BaseActivity {
    ImageView headBackImg;
    TextView headUploadTextView;
    ImageView myHeadImg;
    LinearLayout myHeadBackgroundImg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head_layout);
        /**
         * 控件的实例化和点击事件
         */
        CircularImage cover_user_photo = (CircularImage) findViewById(R.id.cover_user_photo);
        cover_user_photo.setImageResource(R.mipmap.icon_mybg);

//返回的id，结束当前页面
        headBackImg = (ImageView) findViewById(R.id.head_back_img);
        headBackImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //startActivity(HeadPageActivity.this,MyHomePageLayoutActivity.class);
                finish();
            }
        });
//上传头像的控件
        headUploadTextView = (TextView) findViewById(R.id.head_upload_textView);
        headUploadTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.setType("image:/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                //取得相片后返回本界面
                startActivityForResult(intent, 1);
            }
        });
        // 我的头像布局控件
        /*myHeadImg = (ImageView) findViewById(R.id.cover_user_photo);
        myHeadImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });*/
        //头像背景图布局控件
        myHeadBackgroundImg = (LinearLayout) findViewById(R.id.myHead_background_img);
    }

    //上传头像的代码
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            Uri uri = data.getData();
            ContentResolver contentResolver = this.getContentResolver();
            try {
                Bitmap bitmap = BitmapFactory.decodeStream(contentResolver.openInputStream(uri));
                //设置到imageView上
                myHeadImg.setImageBitmap(bitmap);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
        super.onActivityResult(requestCode, resultCode, data);
    }
}
