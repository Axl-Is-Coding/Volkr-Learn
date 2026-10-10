package com.warkiz.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

/* JADX INFO: loaded from: classes5.dex */
public class IndicatorStayLayout extends LinearLayout {
    public IndicatorStayLayout(Context context) {
        this(context, null);
    }

    private void layoutIndicator(View view, int i) {
        if (view instanceof IndicatorSeekBar) {
            IndicatorSeekBar indicatorSeekBar = (IndicatorSeekBar) view;
            indicatorSeekBar.setIndicatorStayAlways(true);
            View indicatorContentView = indicatorSeekBar.getIndicatorContentView();
            if (indicatorContentView == null) {
                throw new IllegalStateException("Can not find any indicator in the IndicatorSeekBar, please make sure you have called the attr: SHOW_INDICATOR_TYPE for IndicatorSeekBar and the value is not IndicatorType.NONE.");
            }
            if (indicatorContentView instanceof IndicatorSeekBar) {
                throw new IllegalStateException("IndicatorSeekBar can not be a contentView for Indicator in case this inflating loop.");
            }
            ViewGroup.MarginLayoutParams marginLayoutParams = new ViewGroup.MarginLayoutParams(new ViewGroup.LayoutParams(-2, -2));
            marginLayoutParams.setMargins(marginLayoutParams.leftMargin, marginLayoutParams.topMargin, marginLayoutParams.rightMargin, j.a(indicatorSeekBar.getContext(), 2.0f) - indicatorSeekBar.getPaddingTop());
            addView(indicatorContentView, i, marginLayoutParams);
            indicatorSeekBar.showStayIndicator();
        }
    }

    public void attachTo(IndicatorSeekBar indicatorSeekBar) {
        attachTo(indicatorSeekBar, -2);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        for (int childCount = getChildCount() - 1; childCount >= 0; childCount--) {
            layoutIndicator(getChildAt(childCount), childCount);
        }
        super.onFinishInflate();
    }

    @Override // android.widget.LinearLayout
    public void setOrientation(int i) {
        if (i != 1) {
            throw new IllegalArgumentException("IndicatorStayLayout is always vertical and does not support horizontal orientation");
        }
        super.setOrientation(i);
    }

    public IndicatorStayLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public void attachTo(IndicatorSeekBar indicatorSeekBar, int i) {
        if (indicatorSeekBar == null) {
            throw new NullPointerException("the seek bar wanna attach to IndicatorStayLayout can not be null value.");
        }
        layoutIndicator(indicatorSeekBar, i);
        addView(indicatorSeekBar, i + 1);
    }

    public IndicatorStayLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(1);
    }
}
