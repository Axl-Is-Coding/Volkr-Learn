package io.rong.imkit.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.RelativeLayout;
import io.rong.imkit.utils.FileTypeUtils;

/* JADX INFO: loaded from: classes5.dex */
public class SquareLayout extends RelativeLayout {
    public SquareLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    @Override // android.widget.RelativeLayout, android.view.View
    protected void onMeasure(int i, int i2) {
        setMeasuredDimension(RelativeLayout.getDefaultSize(0, i), RelativeLayout.getDefaultSize(0, i2));
        int iMakeMeasureSpec = View.MeasureSpec.makeMeasureSpec(getMeasuredWidth(), FileTypeUtils.GIGABYTE);
        super.onMeasure(iMakeMeasureSpec, iMakeMeasureSpec);
    }
}
