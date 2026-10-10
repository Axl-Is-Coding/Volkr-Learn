package me.iwf.photopicker.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import io.rong.imkit.utils.FileTypeUtils;

/* JADX INFO: loaded from: classes5.dex */
public class SquareItemLayout extends RelativeLayout {
    public SquareItemLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(RelativeLayout.getDefaultSize(0, i), RelativeLayout.getDefaultSize(0, i2));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), FileTypeUtils.GIGABYTE);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }

    public SquareItemLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public SquareItemLayout(Context context) {
        super(context);
    }
}
