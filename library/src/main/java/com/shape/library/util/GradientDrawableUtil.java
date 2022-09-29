package com.shape.library.util;

import android.graphics.drawable.GradientDrawable;

public class GradientDrawableUtil {
    private static GradientDrawableUtil gradientDrawableUtil;

    public static GradientDrawableUtil init() {
        if (gradientDrawableUtil == null) {
            gradientDrawableUtil = new GradientDrawableUtil();
        }
        return gradientDrawableUtil;
    }

    /**
     * @param radius      四个角的半径
     * @param colors      渐变的颜色
     * @param strokeWidth 边框宽度
     * @param strokeColor 边框颜色
     * @return
     */
    public GradientDrawable getNeedDrawable(float[] radius, int[] colors, int strokeWidth, int strokeColor,int gradientMode) {
        GradientDrawable drawable = new GradientDrawable();
        switch (gradientMode){
            case 0:
                drawable.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                break;
            case 1:
                drawable.setOrientation(GradientDrawable.Orientation.BOTTOM_TOP);
                break;
            case 2:
                drawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
                break;
            case 3:
                drawable.setOrientation(GradientDrawable.Orientation.RIGHT_LEFT);
                break;
        }
        drawable.setCornerRadii(radius);
        drawable.setColors(colors);
        drawable.setStroke(strokeWidth, strokeColor);
        drawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        return drawable;
    }

    /**
     * @param radius      四个角的半径
     * @param bgColor     背景颜色
     * @param strokeWidth 边框宽度
     * @param strokeColor 边框颜色
     * @return
     */
    public GradientDrawable getNeedDrawable(float[] radius, int bgColor, int strokeWidth, int strokeColor) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setCornerRadii(radius);
        drawable.setStroke(strokeWidth, strokeColor);
        drawable.setColor(bgColor);
        return drawable;
    }

    /**
     * @param radius      四个角的半径
     * @param bgColor     背景颜色
     * @param strokeWidth 边框宽度
     * @param strokeColor 边框颜色
     * @param dashWidth   虚线边框宽度
     * @param dashGap     虚线边框间隙
     * @return
     */
    public GradientDrawable getNeedDrawable(float[] radius, int bgColor, int strokeWidth, int strokeColor, float dashWidth, float dashGap) {
        GradientDrawable drawable = new GradientDrawable();
        drawable.setShape(GradientDrawable.RECTANGLE);
        drawable.setCornerRadii(radius);
        drawable.setStroke(strokeWidth, strokeColor, dashWidth, dashGap);
        drawable.setColor(bgColor);
        return drawable;
    }
}
