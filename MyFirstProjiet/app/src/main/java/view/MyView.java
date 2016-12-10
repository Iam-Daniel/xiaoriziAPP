package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.administrator.myfirstprojiet.R;

/**
 * Created by Administrator on 2016/12/9.
 */
public class MyView extends View{
//    public MyView(Context context) {
//        super(context);
//    }
//
//    public MyView(Context context, AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }
//
//    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
//        super(context, attrs, defStyleRes);
//    }

    public MyView(Context context) {
        super(context);
    }
    public MyView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    public MyView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    public MyView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr);
    }

    //计算视图的大小的方法
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    //内容布局的方法
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    Paint paint;
    @Override
    protected void onDraw(Canvas canvas) {

        paint=new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(getResources().getColor(R.color.black_text_normal));
        paint.setStrokeWidth(3);
        drawlines(canvas,paint);
        super.onDraw(canvas);
    }
    int[] X;
    int[] Y;
    public void setXandY(int[] X,int[] Y){
        this.X=X;
        this.Y=Y;
        invalidate();
    }
    public void drawlines(Canvas canvas,Paint paint){
        for (int i=1;i<X.length;i++){
            int x0=X[i-1];
            int x1=X[i];
            int y0=Y[i-1];
            int y1=Y[i];
            canvas.drawLine(x0,y0,x1,y1,paint);
        }
    }

    @Override
    public void invalidate() {
        super.invalidate();
    }
}
