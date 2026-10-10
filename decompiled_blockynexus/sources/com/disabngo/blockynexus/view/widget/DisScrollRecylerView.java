package com.disabngo.blockynexus.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.recyclerview.widget.RecyclerView;

/* JADX INFO: loaded from: classes.dex */
public class DisScrollRecylerView extends RecyclerView {
    public DisScrollRecylerView(Context context) {
        super(context);
    }

    @Override // androidx.recyclerview.widget.RecyclerView, android.view.ViewGroup
    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        return false;
    }

    public DisScrollRecylerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public DisScrollRecylerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
