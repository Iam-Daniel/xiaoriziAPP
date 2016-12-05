package maniactivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.administrator.myfirstprojiet.R;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

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
    LinearLayout goneLinear;
    LinearLayout goneOr;
    LinearLayout dismiss_linear;
    LinearLayout phoneTextView;
    LinearLayout cameraTextView;

    private static int CAMERA_REQUEST_CODE = 1;
    private static int GALLERY_REQUEST_CODE = 2;
    private static int CROP_REQUEST_CODE = 3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.head_layout);
        /**
         * 控件的实例化和点击事件
         */
        CircularImage cover_user_photo = (CircularImage) findViewById(R.id.cover_user_photo);
        cover_user_photo.setImageResource(R.mipmap.icon_mybg);
        cover_user_photo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

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
        goneLinear = (LinearLayout) findViewById(R.id.gone_linear);
        goneLinear.setAnimation(AnimationUtils.makeOutAnimation(this, true)); // 向右边移出动画效果
        goneLinear.setAnimation(AnimationUtils.makeInAnimation(this, false));// 向左边移入动画效果
        goneOr = (LinearLayout) findViewById(R.id.gone_or);
        headUploadTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (goneLinear.getVisibility() == View.GONE) {
                    goneLinear.setVisibility(View.VISIBLE);
                    goneLinear.setAnimation(AnimationUtil.moveToViewLocation());//设置的动画效果，调用最下面的内部类的方法
                }
            }
        });
        dismiss_linear = (LinearLayout) findViewById(R.id.dismiss_linear);
        dismiss_linear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goneLinear.setVisibility(View.GONE);
                goneLinear.setAnimation(AnimationUtil.moveToViewBottom());//设置的动画效果，调用最下面的内部类的方法
            }
        });
        goneOr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goneLinear.setVisibility(View.GONE);
                goneLinear.setAnimation(AnimationUtil.moveToViewBottom());//设置的动画效果，调用最下面的内部类的方法
            }
        });
        //相册选择
        phoneTextView = (LinearLayout) findViewById(R.id.phone_textView);
        phoneTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image:/*");
                startActivityForResult(intent, GALLERY_REQUEST_CODE);
            }
        });
        //相机选择
        cameraTextView = (LinearLayout) findViewById(R.id.camera_textView);
        cameraTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent, CAMERA_REQUEST_CODE);
            }
        });
        //头像背景图布局控件
        myHeadBackgroundImg = (LinearLayout) findViewById(R.id.myHead_background_img);
    }

    private Uri saveBitmap(Bitmap bitmap) {
        File tmpDir = new File(Environment.getExternalStorageDirectory() + "com.jikexueyuan.avater");
        if (!tmpDir.exists()) {
            tmpDir.mkdir();
        }
        File img = new File(tmpDir.getAbsolutePath() + "five.jpg");
        try {
            FileOutputStream fo = new FileOutputStream(img);
            bitmap.compress(Bitmap.CompressFormat.PNG, 85, fo);
            fo.flush();
            fo.close();
            return Uri.fromFile(img);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private Uri converUri(Uri uri) {
        InputStream inputStream = null;
        try {
            inputStream = getContentResolver().openInputStream(uri);
            Bitmap bitmap = BitmapFactory.decodeStream(inputStream);
            inputStream.close();
            return saveBitmap(bitmap);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return null;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private void startImageZoom(Uri uri) {
        Intent intent = new Intent("com.android.camera.action.CROP");
        intent.setDataAndType(uri, "image/*");
        intent.putExtra("crop", "true");
        intent.putExtra("aspectX", "1");
        intent.putExtra("aspectY", "1");
        intent.putExtra("outputX", "150");
        intent.putExtra("outputY", "150");
        intent.putExtra("return-data", true);
        startActivityForResult(intent, CROP_REQUEST_CODE);
    }

    //上传头像的代码
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST_CODE) {
            if (data == null) {
                return;
            } else {
                Bundle bundle = data.getExtras();
                if (bundle != null) {
                    Bitmap bitmap = bundle.getParcelable("data");
                    /*ImageView cover_user_photo = (ImageView) findViewById(R.id.cover_user_photo);
                    cover_user_photo.setImageBitmap(bitmap);*/
                    Uri uri = saveBitmap(bitmap);
                    startImageZoom(uri);
                }
            }
        } else if (requestCode == GALLERY_REQUEST_CODE) {
            if (data == null) {
                return;
            }
            Uri uri;
            uri = data.getData();
            Uri fileUri = converUri(uri);
            startImageZoom(fileUri);
            //Toast.makeText(HeadPageActivity.this, uri.toString(), Toast.LENGTH_SHORT).show();
        } else if (requestCode == CROP_REQUEST_CODE) {
            if (data == null) {
                return;
            }
            Bundle bundle = data.getExtras();
            Bitmap bitmap = bundle.getParcelable("data");
            ImageView cover_user_photo = (ImageView) findViewById(R.id.cover_user_photo);
            cover_user_photo.setImageBitmap(bitmap);
        }
    }

    /**
     * 设置从下到上的动画效果，上面的调用了方法,记住别调用错了，不然又上又下的........
     */
    public static class AnimationUtil {
        private static final String TAG = AnimationUtil.class.getSimpleName();

        /**
         * 从控件所在位置移动到控件的底部
         */
        public static TranslateAnimation moveToViewBottom() {
            TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                    0.0f, Animation.RELATIVE_TO_SELF, 1.0f);
            mHiddenAction.setDuration(500);
            return mHiddenAction;
        }

        /**
         * 从控件的底部移动到控件所在位置
         */
        public static TranslateAnimation moveToViewLocation() {
            TranslateAnimation mHiddenAction = new TranslateAnimation(Animation.RELATIVE_TO_SELF, 0.0f,
                    Animation.RELATIVE_TO_SELF, 0.0f, Animation.RELATIVE_TO_SELF,
                    1.0f, Animation.RELATIVE_TO_SELF, 0.0f);
            mHiddenAction.setDuration(500);
            return mHiddenAction;
        }
    }
}
