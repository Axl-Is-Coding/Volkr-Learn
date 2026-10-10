package io.rong.imkit.model;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.GridView;

/* JADX INFO: loaded from: classes5.dex */
public class RongGridView extends GridView {
    public RongGridView(Context context) {
        super(context);
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.widget.GridView, android.widget.AbsListView, android.view.View
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
    }

    public RongGridView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RongGridView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
