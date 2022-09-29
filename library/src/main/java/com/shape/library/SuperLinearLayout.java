package com.shape.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import com.shape.library.util.GradientDrawableUtil;

/**
 * @description: 自定义LinearLayout，支持自定义shape，避免频繁的创建shape xml资源
 * @author: zhy
 */
public class SuperLinearLayout extends LinearLayout {
    private GradientDrawable gradientDrawable;
    private int solidColor = 0;
    private int strokeColor = 0;
    private int startColor = 0;
    private int endColor = 0;
    private int strokeWidth = 0;
    private int gradientMode = 0;
    private int radius;
    private int topLeftRadius;
    private int topRightRadius;
    private int bottomLeftRadius;
    private int bottomRightRadius;

    public SuperLinearLayout(Context context) {
        this(context, null);
    }

    public SuperLinearLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public SuperLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
        setCustomBackground();
    }


    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SuperLinearLayout);
        solidColor = ta.getColor(R.styleable.SuperLinearLayout_solidColor, Color.TRANSPARENT);
        strokeColor = ta.getColor(R.styleable.SuperLinearLayout_strokeColor, Color.TRANSPARENT);
        startColor = ta.getColor(R.styleable.SuperLinearLayout_startColor, Color.TRANSPARENT);
        endColor = ta.getColor(R.styleable.SuperLinearLayout_endColor, Color.TRANSPARENT);
        strokeWidth = ta.getDimensionPixelSize(R.styleable.SuperLinearLayout_strokeWith, 0);
        radius = ta.getDimensionPixelSize(R.styleable.SuperLinearLayout_radius, 0);
        topLeftRadius = ta.getDimensionPixelSize(R.styleable.SuperLinearLayout_topLeftRadius, radius);
        topRightRadius = ta.getDimensionPixelSize(R.styleable.SuperLinearLayout_topRightRadius, radius);
        bottomLeftRadius = ta.getDimensionPixelSize(R.styleable.SuperLinearLayout_bottomLeftRadius, radius);
        bottomRightRadius = ta.getDimensionPixelSize(R.styleable.SuperLinearLayout_bottomRightRadius, radius);
        gradientMode= ta.getInt(R.styleable.SuperConstraintLayout_gradientMode, 0);
        ta.recycle();
    }

    public void setSolidColor(int solidColor) {
        this.solidColor = solidColor;
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
    }

    public void setStrokeWidth(int strokeWidth) {
        this.strokeWidth = strokeWidth;
    }

    public void setRadius(int radius) {
        this.radius = radius;
    }

    public void setTopLeftRadius(int topLeftRadius) {
        this.topLeftRadius = topLeftRadius;
    }

    public void setTopRightRadius(int topRightRadius) {
        this.topRightRadius = topRightRadius;
    }

    public void setBottomLeftRadius(int bottomLeftRadius) {
        this.bottomLeftRadius = bottomLeftRadius;
    }

    public void setBottomRightRadius(int bottomRightRadius) {
        this.bottomRightRadius = bottomRightRadius;
    }

    public void setCustomBackground() {
        if(startColor!=0&&endColor!=0){
            gradientDrawable = GradientDrawableUtil.init().getNeedDrawable(new float[]{topLeftRadius, topLeftRadius, topRightRadius, topRightRadius,
                            bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius},new int[]{startColor,endColor},
                    strokeWidth, strokeColor,gradientMode);
        }
        else{
            gradientDrawable = GradientDrawableUtil.init().getNeedDrawable(new float[]{topLeftRadius, topLeftRadius, topRightRadius, topRightRadius,
                            bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius},
                    solidColor, strokeWidth, strokeColor);
        }

        this.setBackground(gradientDrawable);
        this.setFocusable(false);
        this.setFocusableInTouchMode(false);
    }
}
