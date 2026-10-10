package com.sandboxol.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.ViewParent;
import android.widget.HorizontalScrollView;
import androidx.core.widget.NestedScrollView;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes3.dex */
public class AutoHorizontalScrollView extends HorizontalScrollView {
    private float lastY;
    private NestedScrollView svRoot;

    public AutoHorizontalScrollView(Context context) {
        super(context);
    }

    private void findRootSV() {
        ViewParent parent = this;
        while (this.svRoot == null && parent != null) {
            parent = parent.getParent();
            if (parent != null && (parent instanceof NestedScrollView)) {
                this.svRoot = (NestedScrollView) parent;
            }
        }
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    @Override // android.widget.HorizontalScrollView, android.widget.FrameLayout, android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        findRootSV();
    }

    @Override // android.widget.HorizontalScrollView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.lastY = WheelView.DividerConfig.FILL;
        }
        float f2 = this.lastY;
        if (f2 != WheelView.DividerConfig.FILL) {
            int rawY = (int) (f2 - motionEvent.getRawY());
            int iAbs = Math.abs(rawY);
            NestedScrollView nestedScrollView = this.svRoot;
            if (nestedScrollView != null && iAbs != 0 && iAbs < 65) {
                nestedScrollView.scrollBy(0, rawY);
            }
        }
        this.lastY = motionEvent.getRawY();
        return super.onTouchEvent(motionEvent);
    }

    public AutoHorizontalScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AutoHorizontalScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
