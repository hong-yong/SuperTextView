package com.shape.library;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.widget.RelativeLayout;

import com.shape.library.util.GradientDrawableUtil;

public class SuperRelativeLayout extends RelativeLayout {
    private GradientDrawable gradientDrawable;
    private int solidColor = 0;
    private int strokeColor = 0;
    private int strokeWidth = 0;
    private int radius;
    private int topLeftRadius;
    private int topRightRadius;
    private int bottomLeftRadius;
    private int bottomRightRadius;

    public SuperRelativeLayout(Context context) {
        this(context, null);
    }

    public SuperRelativeLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }
    public SuperRelativeLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
        setCustomBackground();
    }
    private void init(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.SuperRelativeLayout);
        solidColor = ta.getColor(R.styleable.SuperRelativeLayout_solidColor, Color.TRANSPARENT);
        strokeColor = ta.getColor(R.styleable.SuperRelativeLayout_strokeColor, Color.TRANSPARENT);
        strokeWidth = ta.getDimensionPixelSize(R.styleable.SuperRelativeLayout_strokeWith, 0);
        radius = ta.getDimensionPixelSize(R.styleable.SuperRelativeLayout_radius, 0);
        topLeftRadius = ta.getDimensionPixelSize(R.styleable.SuperRelativeLayout_topLeftRadius, radius);
        topRightRadius = ta.getDimensionPixelSize(R.styleable.SuperRelativeLayout_topRightRadius, radius);
        bottomLeftRadius = ta.getDimensionPixelSize(R.styleable.SuperRelativeLayout_bottomLeftRadius, radius);
        bottomRightRadius = ta.getDimensionPixelSize(R.styleable.SuperRelativeLayout_bottomRightRadius, radius);
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
        gradientDrawable = GradientDrawableUtil.init().getNeedDrawable(new float[]{topLeftRadius, topLeftRadius, topRightRadius, topRightRadius,
                        bottomRightRadius, bottomRightRadius, bottomLeftRadius, bottomLeftRadius},
                solidColor, strokeWidth, strokeColor);
        this.setBackground(gradientDrawable);
        this.setFocusable(false);
        this.setFocusableInTouchMode(false);
    }
}
