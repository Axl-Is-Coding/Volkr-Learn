package com.sandboxol.videosubmit.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.viewpager.widget.ViewPager;

/* JADX INFO: loaded from: classes4.dex */
public class VideoSubmitViewPager extends ViewPager {
    public VideoSubmitViewPager(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    private int measureHeight(int i, View view) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size;
        }
        int measuredHeight = view != null ? view.getMeasuredHeight() : 0;
        return mode == Integer.MIN_VALUE ? Math.min(measuredHeight, size) : measuredHeight;
    }

    public void measeureView(View view) {
        view.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        view.getMeasuredWidth();
        view.getMeasuredHeight();
    }

    @Override // androidx.viewpager.widget.ViewPager, android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        View childAt = getChildAt(getCurrentItem());
        if (childAt != null) {
            childAt.measure(i, i2);
        }
        setMeasuredDimension(getMeasuredWidth(), measureHeight(i2, childAt));
    }
}
