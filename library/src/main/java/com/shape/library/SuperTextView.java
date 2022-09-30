package com.shape.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;

import androidx.annotation.ColorInt;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatTextView;

/**
 * @description: 自定义TextView，支持自定义shape，
 * 避免频繁的创建shape xml资源,注意，如需要按压变色，xml属性设置isTouch为true即可
 * 如需setEnabled变色，设置setEnabled True or flase 即可
 * 支持按压颜色渐变
 * 支持圆角，半角，边线等常规shape的定义
 * 逻辑如果solidColor为0 or 不设置该属性，就是设置渐变色
 * @author: zhy
 */
public class SuperTextView extends AppCompatTextView {
    public SuperTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }
    public SuperTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }
    private int solidColor = 0;
    private int strokeColor = 0;
    private float strokeWith = 0;
    private float radius =0;
    private float topLeftRadius=0;
    private float topRightRadius=0;
    private float bottomLeftRadius=0;
    private float bottomRightRadius=0;
    private final RectF mRect = new RectF();
    private Paint paintStroke ;
    private Paint paint ;
    private Path path;
    private float[] radii;
    //按下填充色
    private int solidTouchColor = 0;
    //按下边框色
    private int strokeTouchColor = 0;
    //按下字体色
    private int textTouchColor=0;
    //字体色
    private int textColor=0;
    private boolean isTouch=false;
    private LinearGradient mLinearGradient;
    private int[] colorGradient;
    private int[] colorTouchGradient;
    private int gradientMode = 0;
    private int startColor = 0;
    private int endColor = 0;
    private int startTouchColor = 0;
    private int endTouchColor = 0;
    private boolean label=true;
    public void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.MySuperTextView, 0, 0);
        solidColor = ta.getInteger(R.styleable.MySuperTextView_solidColor, 0x00000000);
        strokeColor = ta.getInteger(R.styleable.MySuperTextView_strokeColor, 0x00000000);
        solidTouchColor = ta.getInteger(R.styleable.MySuperTextView_solidTouchColor, 0x00000000);
        strokeTouchColor = ta.getInteger(R.styleable.MySuperTextView_strokeTouchColor, 0x00000000);
        textTouchColor= ta.getInteger(R.styleable.MySuperTextView_textTouchColor, 0x00000000);
        textColor=getCurrentTextColor();
        startColor = ta.getColor(R.styleable.MySuperTextView_startColor, Color.TRANSPARENT);
        endColor = ta.getColor(R.styleable.MySuperTextView_endColor, Color.TRANSPARENT);
        startTouchColor = ta.getColor(R.styleable.MySuperTextView_startTouchColor, Color.TRANSPARENT);
        endTouchColor = ta.getColor(R.styleable.MySuperTextView_endTouchColor, Color.TRANSPARENT);
        strokeWith = ta.getDimension(R.styleable.MySuperTextView_strokeWith, 0);
        radius = ta.getDimension(R.styleable.MySuperTextView_radius, 0);
        topLeftRadius = ta.getDimension(R.styleable.MySuperTextView_topLeftRadius, 0);
        topRightRadius = ta.getDimension(R.styleable.MySuperTextView_topRightRadius, 0);
        bottomLeftRadius = ta.getDimension(R.styleable.MySuperTextView_bottomLeftRadius, 0);
        bottomRightRadius = ta.getDimension(R.styleable.MySuperTextView_bottomRightRadius, 0);
        isTouch=ta.getBoolean(R.styleable.MySuperTextView_isTouch,false);
        gradientMode= ta.getInt(R.styleable.MySuperTextView_gradientMode, 2);
        ta.recycle();
        if(strokeColor!=0&&strokeWith>0) {
            paintStroke = new Paint();
            paintStroke.setColor(strokeColor);
            paintStroke.setStyle(Paint.Style.STROKE);
            paintStroke.setStrokeWidth(strokeWith);
            paintStroke.setAntiAlias(true);
        }
        paint=new Paint();
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.FILL);
        colorGradient = new int[]{startColor,
                endColor};
        colorTouchGradient = new int[]{startTouchColor,
                endTouchColor};
        if(radius==0){
            path=new Path();
            radii=new float[]{topLeftRadius,topLeftRadius,topRightRadius,topRightRadius,bottomRightRadius,bottomRightRadius,bottomLeftRadius,bottomLeftRadius};
        }
        if(solidColor!=0){
            paint.setColor(solidColor);
        }
    }
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        mRect.set(strokeWith, strokeWith, getWidth() - strokeWith, getHeight() - strokeWith);
        if(path!=null)
            path.addRoundRect(mRect, radii, Path.Direction.CW);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        if(solidColor==0){
            if(label){
                label=false;
                if(startColor!=0&&endColor!=0){
                    switch (gradientMode){
                        case 0:
                            createLinearGradient(0, 0, 0, getMeasuredHeight(),
                                    colorGradient[0], colorGradient[1]);
                            break;
                        case 1:
                            createLinearGradient(0, getMeasuredHeight(), 0,0,
                                    colorGradient[0], colorGradient[1]);
                            break;
                        case 2:
                            createLinearGradient(0, 0, getMeasuredWidth(), 0,
                                    colorGradient[0], colorGradient[1]);
                            break;
                        case 3:
                            createLinearGradient(getMeasuredWidth(), 0, 0, 0,
                                    colorGradient[0], colorGradient[1]);
                            break;

                    }
                }
            }
        }
            if(radius==0){
                canvas.drawPath(path, paint);
                if(paintStroke!=null)
                    canvas.drawPath(path, paintStroke);
            }else{
                canvas.drawRoundRect(mRect, radius, radius, paint);
                if(paintStroke!=null)
                    canvas.drawRoundRect(mRect, radius, radius, paintStroke);
            }
        super.onDraw(canvas);
    }
    //这里实现按压事件
    @Override
    public boolean onTouchEvent(MotionEvent event) {

            if(isTouch){
                if (event.getAction() == MotionEvent.ACTION_DOWN||event.getAction() == MotionEvent.ACTION_MOVE) {
                    if(event.getAction() == MotionEvent.ACTION_DOWN)
                        drowBackgroud(true);
                } else {
                    drowBackgroud(false);
                }
                return super.onTouchEvent(event);
            }


        else{
            return super.onTouchEvent(event);
        }
    }

    @Override
    public void setEnabled(boolean enabled) {
        super.setEnabled(enabled);
        drowBackgroud(!enabled);
    }

    /**
     * 设置按下颜色值
     */
    private void drowBackgroud(boolean isTouch) {
        if (isTouch) {
            if(solidTouchColor!=0){
                paint.setColor(solidTouchColor);
            }
            else{
                label=true;
            }
            if(paintStroke!=null)
                paintStroke.setColor(strokeTouchColor);
            if(textTouchColor!=0)
                setTextColor(textTouchColor);


        }
        else {
            if(solidColor!=0){
                paint.setColor(solidColor);
            }
            else{
                label=false;
                if(startTouchColor!=0&&endTouchColor!=0){
                    switch (gradientMode){
                        case 0:
                            //从上到下
                            createLinearGradient(0, 0, 0, getMeasuredHeight(),
                                    colorTouchGradient[0], colorTouchGradient[1]);
                            break;
                        case 1:
                            //从下到上
                            createLinearGradient(0, getMeasuredHeight(), 0,0,
                                    colorTouchGradient[0], colorTouchGradient[1]);
                            break;
                        case 2:
                            //从左到右
                            createLinearGradient(0, 0, getMeasuredWidth(), 0,
                                    colorTouchGradient[0], colorTouchGradient[1]);
                            break;
                        case 3:
                            //从右到左
                            createLinearGradient(getMeasuredWidth(), 0, 0, 0,
                                    colorTouchGradient[0], colorTouchGradient[1]);
                            break;
                    }

                }
            }
            if(paintStroke!=null)
                paintStroke.setColor(strokeColor);

            if(textTouchColor!=0)
                setTextColor(textColor);

        }
        postInvalidate();
    }
    private void createLinearGradient(float x0, float y0, float x1, float y1, @ColorInt int color0, @ColorInt int color1){
        mLinearGradient = new LinearGradient(x0, y0, x1, y1,
                color0, color1, Shader.TileMode.CLAMP);
        paint.setShader(mLinearGradient);
    }
}
