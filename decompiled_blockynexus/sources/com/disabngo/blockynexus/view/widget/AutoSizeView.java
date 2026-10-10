package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.disabngo.blockynexus.R;

/* JADX INFO: loaded from: classes.dex */
public class AutoSizeView extends FrameLayout {
    private int heightProportion;
    private boolean isWidth;
    private int widthProportion;

    public AutoSizeView(Context context) {
        this(context, null);
    }

    @Override // android.widget.FrameLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        if (this.isWidth) {
            super.onMeasure(this.widthProportion * i, this.heightProportion * i);
            setMeasuredDimension(this.widthProportion * i, i * this.heightProportion);
        } else {
            super.onMeasure(this.widthProportion * i2, this.heightProportion * i2);
            setMeasuredDimension(this.widthProportion * i2, i2 * this.heightProportion);
        }
    }

    public AutoSizeView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public AutoSizeView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, R.styleable.AutoSizeView);
        this.isWidth = typedArrayObtainStyledAttributes.getBoolean(1, false);
        this.widthProportion = typedArrayObtainStyledAttributes.getInteger(2, 1);
        this.heightProportion = typedArrayObtainStyledAttributes.getInteger(0, 1);
        typedArrayObtainStyledAttributes.recycle();
    }
}
