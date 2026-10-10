package com.sandboxol.gamedetail.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import cn.qqtheme.framework.widget.WheelView;
import com.sandboxol.gamedetail.R;
import io.rong.imkit.utils.FileTypeUtils;

/* JADX INFO: loaded from: classes3.dex */
public class MaxLayout extends FrameLayout {
    public static final float DEF_VALUE = -1.0f;
    public static final int H_W = 2;
    public static final int STANDRAD = 0;
    private static final String TAG = "MaxLayout";
    public static final int W_H = 1;
    private Context mContext;
    private float mMaxHeight;
    private float mMaxWidth;
    private float mRatio;
    private int mRatioStandrad;

    public MaxLayout(Context context) {
        this(context, null, 0);
    }

    private int getHeight(int i) {
        float f2 = this.mMaxHeight;
        return (f2 > -1.0f && ((float) i) > f2) ? (int) f2 : i;
    }

    private int getWidth(int i) {
        float f2 = this.mMaxWidth;
        return (f2 > -1.0f && ((float) i) > f2) ? (int) f2 : i;
    }

    private void initAttrs(AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = this.mContext.obtainStyledAttributes(attributeSet, R.styleable.MaxLayout);
        this.mMaxHeight = typedArrayObtainStyledAttributes.getDimension(R.styleable.MaxLayout_ml_maxheight, -1.0f);
        this.mMaxWidth = typedArrayObtainStyledAttributes.getDimension(R.styleable.MaxLayout_ml_maxWidth, -1.0f);
        this.mRatioStandrad = typedArrayObtainStyledAttributes.getInt(R.styleable.MaxLayout_ml_ratio_standard, 0);
        this.mRatio = typedArrayObtainStyledAttributes.getFloat(R.styleable.MaxLayout_ml_ratio, WheelView.DividerConfig.FILL);
        typedArrayObtainStyledAttributes.recycle();
    }

    private boolean isSetRatio() {
        int i;
        return this.mRatio > WheelView.DividerConfig.FILL && ((i = this.mRatioStandrad) == 1 || i == 2);
    }

    public void clearMaxHeightFlag() {
        this.mMaxHeight = -1.0f;
    }

    public void clearMaxWidthFlag() {
        this.mMaxWidth = -1.0f;
    }

    public float getMaxHeight() {
        return this.mMaxHeight;
    }

    public float getMaxWidth() {
        return this.mMaxWidth;
    }

    public float getRatio() {
        return this.mRatio;
    }

    public int getRatioStandrad() {
        return this.mRatioStandrad;
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        int width;
        int height;
        boolean zIsSetRatio = isSetRatio();
        if (this.mMaxWidth <= -1.0f && this.mMaxHeight <= -1.0f && !zIsSetRatio) {
            super.onMeasure(i, i2);
            return;
        }
        int mode = View.MeasureSpec.getMode(i2);
        int size = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i);
        Log.d(TAG, "origin onMeasure: widthSize =" + size2 + "heightSize = " + size);
        int i3 = this.mRatioStandrad;
        if (i3 == 1) {
            width = getWidth(size2);
            float f2 = this.mRatio;
            if (f2 >= WheelView.DividerConfig.FILL) {
                size = (int) (width * f2);
            }
            height = getHeight(size);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(width, mode2), View.MeasureSpec.makeMeasureSpec(height, FileTypeUtils.GIGABYTE));
        } else if (i3 == 2) {
            height = getHeight(size);
            float f3 = this.mRatio;
            if (f3 >= WheelView.DividerConfig.FILL) {
                size2 = (int) (height * f3);
            }
            width = getWidth(size2);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(width, FileTypeUtils.GIGABYTE), View.MeasureSpec.makeMeasureSpec(height, mode));
        } else {
            width = getWidth(size2);
            height = getHeight(size);
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(width, mode2), View.MeasureSpec.makeMeasureSpec(height, mode));
        }
        Log.d(TAG, "adjust onMeasure: widthSize =" + width + "heightSize = " + height);
    }

    public void setMaxHeight(float f2) {
        this.mMaxHeight = f2;
    }

    public void setMaxWidth(float f2) {
        this.mMaxWidth = f2;
    }

    public void setRatio(float f2) {
        this.mRatio = f2;
    }

    public void setRatioStandrad(int i) {
        this.mRatioStandrad = i;
    }

    public MaxLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public MaxLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.mMaxHeight = -1.0f;
        this.mMaxWidth = -1.0f;
        this.mContext = context;
        initAttrs(attributeSet);
    }
}
