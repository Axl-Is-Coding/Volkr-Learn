package com.sandboxol.common.widget.rv.sbrv;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes3.dex */
public class SandboxRecyclerView extends RecyclerView {
    public SandboxRecyclerView(Context context) {
        super(context);
        setFocusable(false);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    protected void onMeasure(int i, int i2) {
        try {
            super.onMeasure(i, View.MeasureSpec.makeMeasureSpec(536870911, Integer.MIN_VALUE));
        } catch (Exception unused) {
            super.onMeasure(i, i2);
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        return true;
    }

    public SandboxRecyclerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setFocusable(false);
    }

    public SandboxRecyclerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setFocusable(false);
    }
}
