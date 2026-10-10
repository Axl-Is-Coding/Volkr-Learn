package com.twitter.sdk.android.tweetui.internal;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.twitter.sdk.android.tweetui.R;
import io.rong.imkit.utils.FileTypeUtils;

/* JADX INFO: loaded from: classes5.dex */
public class AspectRatioFrameLayout extends FrameLayout {
    static final int ADJUST_DIMENSION_HEIGHT = 0;
    static final int ADJUST_DIMENSION_WIDTH = 1;
    private static final int DEFAULT_ADJUST_DIMENSION = 0;
    private static final float DEFAULT_ASPECT_RATIO = 1.0f;
    protected double aspectRatio;
    private int dimensionToAdjust;

    public AspectRatioFrameLayout(Context context) {
        this(context, null);
    }

    private void initAttributes(int i) {
        TypedArray typedArrayObtainStyledAttributes = getContext().getTheme().obtainStyledAttributes(i, R.styleable.AspectRatioFrameLayout);
        try {
            this.aspectRatio = typedArrayObtainStyledAttributes.getFloat(R.styleable.AspectRatioFrameLayout_tw__frame_layout_aspect_ratio, 1.0f);
            this.dimensionToAdjust = typedArrayObtainStyledAttributes.getInt(R.styleable.AspectRatioFrameLayout_tw__frame_layout_dimension_to_adjust, 0);
        } finally {
            typedArrayObtainStyledAttributes.recycle();
        }
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int measuredHeight;
        int i3;
        int i4;
        int measuredWidth;
        int paddingLeft = getPaddingLeft() + getPaddingRight();
        int paddingBottom = getPaddingBottom() + getPaddingTop();
        if (this.dimensionToAdjust == 0) {
            if (View.MeasureSpec.getMode(i) == 1073741824) {
                measuredWidth = View.MeasureSpec.getSize(i);
            } else {
                super.onMeasure(i, i2);
                measuredWidth = getMeasuredWidth();
            }
            i4 = measuredWidth - paddingLeft;
            double d2 = i4;
            double d3 = this.aspectRatio;
            Double.isNaN(d2);
            i3 = (int) (d2 / d3);
        } else {
            if (View.MeasureSpec.getMode(i2) == 1073741824) {
                measuredHeight = View.MeasureSpec.getSize(i2);
            } else {
                super.onMeasure(i, i2);
                measuredHeight = getMeasuredHeight();
            }
            i3 = measuredHeight - paddingBottom;
            double d4 = i3;
            double d5 = this.aspectRatio;
            Double.isNaN(d4);
            i4 = (int) (d4 * d5);
        }
        super.onMeasure(View.MeasureSpec.makeMeasureSpec(i4 + paddingLeft, FileTypeUtils.GIGABYTE), View.MeasureSpec.makeMeasureSpec(i3 + paddingBottom, FileTypeUtils.GIGABYTE));
    }

    public void setAspectRatio(double d2) {
        this.aspectRatio = d2;
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AspectRatioFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        initAttributes(i);
    }
}
