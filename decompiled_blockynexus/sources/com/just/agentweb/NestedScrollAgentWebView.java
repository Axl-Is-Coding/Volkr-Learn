package com.just.agentweb;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import androidx.core.view.C0321i;
import androidx.core.view.l;
import androidx.core.view.m;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: loaded from: classes2.dex */
public class NestedScrollAgentWebView extends AgentWebView implements l {
    private m mChildHelper;
    private int mLastMotionY;
    private int mNestedYOffset;
    private final int[] mScrollConsumed;
    private final int[] mScrollOffset;

    public NestedScrollAgentWebView(Context context) {
        super(context);
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        init();
    }

    private void init() {
        this.mChildHelper = new m(this);
        setNestedScrollingEnabled(true);
    }

    @Override // android.view.View
    public boolean dispatchNestedFling(float f2, float f3, boolean z) {
        return this.mChildHelper.a(f2, f3, z);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreFling(float f2, float f3) {
        return this.mChildHelper.a(f2, f3);
    }

    @Override // android.view.View
    public boolean dispatchNestedPreScroll(int i, int i2, int[] iArr, int[] iArr2) {
        return this.mChildHelper.a(i, i2, iArr, iArr2);
    }

    @Override // android.view.View
    public boolean dispatchNestedScroll(int i, int i2, int i3, int i4, int[] iArr) {
        return this.mChildHelper.a(i, i2, i3, i4, iArr);
    }

    @Override // android.view.View
    public boolean hasNestedScrollingParent() {
        return this.mChildHelper.a();
    }

    @Override // android.view.View, androidx.core.view.l
    public boolean isNestedScrollingEnabled() {
        return this.mChildHelper.b();
    }

    @Override // android.webkit.WebView, android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        MotionEvent motionEventObtain = MotionEvent.obtain(motionEvent);
        int iA = C0321i.a(motionEvent);
        if (iA == 0) {
            this.mNestedYOffset = 0;
        }
        int y = (int) motionEvent.getY();
        motionEvent.offsetLocation(WheelView.DividerConfig.FILL, this.mNestedYOffset);
        if (iA == 0) {
            this.mLastMotionY = y;
            startNestedScroll(2);
            return super.onTouchEvent(motionEvent);
        }
        if (iA != 1) {
            if (iA == 2) {
                int i = this.mLastMotionY - y;
                if (dispatchNestedPreScroll(0, i, this.mScrollConsumed, this.mScrollOffset)) {
                    i -= this.mScrollConsumed[1];
                    motionEventObtain.offsetLocation(WheelView.DividerConfig.FILL, this.mScrollOffset[1]);
                    this.mNestedYOffset += this.mScrollOffset[1];
                }
                this.mLastMotionY = y - this.mScrollOffset[1];
                int scrollY = getScrollY();
                int iMax = Math.max(0, scrollY + i) - scrollY;
                if (dispatchNestedScroll(0, iMax, 0, i - iMax, this.mScrollOffset)) {
                    this.mLastMotionY = this.mLastMotionY - this.mScrollOffset[1];
                    motionEventObtain.offsetLocation(WheelView.DividerConfig.FILL, r1[1]);
                    this.mNestedYOffset += this.mScrollOffset[1];
                }
                boolean zOnTouchEvent = super.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
                return zOnTouchEvent;
            }
            if (iA != 3 && iA != 5) {
                return false;
            }
        }
        stopNestedScroll();
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public void setNestedScrollingEnabled(boolean z) {
        this.mChildHelper.a(z);
    }

    @Override // android.view.View
    public boolean startNestedScroll(int i) {
        return this.mChildHelper.b(i);
    }

    @Override // android.view.View, androidx.core.view.l
    public void stopNestedScroll() {
        this.mChildHelper.c();
    }

    public NestedScrollAgentWebView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mScrollOffset = new int[2];
        this.mScrollConsumed = new int[2];
        init();
    }
}
