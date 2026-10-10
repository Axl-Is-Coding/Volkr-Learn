package com.sandboxol.common.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.HorizontalScrollView;
import android.widget.ScrollView;
import androidx.core.view.u;
import androidx.core.widget.NestedScrollView;
import cn.qqtheme.framework.widget.WheelView;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class AutoSlideScrollView extends NestedScrollView {
    private ViewGroup[] childs;
    private boolean isMoving;
    private float lastX;
    private float lastY;
    private int moveTimes;

    public AutoSlideScrollView(Context context) {
        super(context);
        this.lastX = WheelView.DividerConfig.FILL;
        this.lastY = WheelView.DividerConfig.FILL;
        this.moveTimes = 0;
        this.isMoving = false;
    }

    private void findSlidableView(ViewGroup viewGroup, boolean z, List<ViewGroup> list) {
        for (int i = 0; i < viewGroup.getChildCount(); i++) {
            View childAt = viewGroup.getChildAt(i);
            if (childAt instanceof ViewGroup) {
                if ((childAt instanceof ScrollView) || (childAt instanceof u) || (childAt instanceof HorizontalScrollView) || (childAt instanceof AbsListView)) {
                    list.add((ViewGroup) childAt);
                    if (!z) {
                        return;
                    }
                } else {
                    findSlidableView((ViewGroup) childAt, false, list);
                }
            }
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (!this.isMoving) {
            ViewGroup[] viewGroupArr = this.childs;
            int length = viewGroupArr.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (viewGroupArr[i].onInterceptTouchEvent(motionEvent)) {
                    this.isMoving = true;
                    break;
                }
                i++;
            }
        }
        int action = motionEvent.getAction();
        if (action == 1 || action == 3) {
            this.isMoving = false;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    protected void onFinishInflate() {
        super.onFinishInflate();
        View childAt = getChildAt(0);
        if (childAt == null || !(childAt instanceof ViewGroup)) {
            throw new NullPointerException("child is empty!");
        }
        ArrayList arrayList = new ArrayList();
        findSlidableView((ViewGroup) childAt, true, arrayList);
        this.childs = new ViewGroup[arrayList.size()];
        for (int i = 0; i < arrayList.size(); i++) {
            this.childs[i] = arrayList.get(i);
        }
    }

    @Override // androidx.core.widget.NestedScrollView, android.view.ViewGroup
    public boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            onTouchEvent(motionEvent);
        }
        return this.isMoving || super.onInterceptTouchEvent(motionEvent);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x0064  */
    @Override // androidx.core.widget.NestedScrollView, android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(android.view.MotionEvent r8) {
        /*
            r7 = this;
            int r0 = r8.getAction()
            r1 = 0
            if (r0 == 0) goto L67
            r2 = 1
            if (r0 == r2) goto L64
            r2 = 2
            if (r0 == r2) goto L11
            r2 = 3
            if (r0 == r2) goto L64
            goto L74
        L11:
            float r0 = r8.getY()
            float r2 = r7.lastY
            float r0 = r0 - r2
            float r0 = java.lang.Math.abs(r0)
            float r2 = r8.getX()
            float r3 = r7.lastX
            float r2 = r2 - r3
            float r2 = java.lang.Math.abs(r2)
            int r0 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r0 <= 0) goto L2c
            goto L74
        L2c:
            android.view.ViewGroup[] r0 = r7.childs
            int r2 = r0.length
        L2f:
            if (r1 >= r2) goto L74
            r3 = r0[r1]
            float r4 = r8.getY()
            int r5 = r7.getScrollY()
            float r5 = (float) r5
            float r4 = r4 + r5
            float r5 = r3.getY()
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 <= 0) goto L61
            float r4 = r8.getY()
            int r5 = r7.getScrollY()
            float r5 = (float) r5
            float r4 = r4 + r5
            float r5 = r3.getY()
            int r6 = r3.getHeight()
            float r6 = (float) r6
            float r5 = r5 + r6
            int r4 = (r4 > r5 ? 1 : (r4 == r5 ? 0 : -1))
            if (r4 >= 0) goto L61
            r3.dispatchTouchEvent(r8)
            goto L74
        L61:
            int r1 = r1 + 1
            goto L2f
        L64:
            r7.isMoving = r1
            goto L74
        L67:
            android.view.ViewGroup[] r0 = r7.childs
            int r2 = r0.length
        L6a:
            if (r1 >= r2) goto L74
            r3 = r0[r1]
            r3.dispatchTouchEvent(r8)
            int r1 = r1 + 1
            goto L6a
        L74:
            float r0 = r8.getX()
            r7.lastX = r0
            float r0 = r8.getY()
            r7.lastY = r0
            boolean r8 = super.onTouchEvent(r8)
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.sandboxol.common.widget.AutoSlideScrollView.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public AutoSlideScrollView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.lastX = WheelView.DividerConfig.FILL;
        this.lastY = WheelView.DividerConfig.FILL;
        this.moveTimes = 0;
        this.isMoving = false;
    }

    public AutoSlideScrollView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.lastX = WheelView.DividerConfig.FILL;
        this.lastY = WheelView.DividerConfig.FILL;
        this.moveTimes = 0;
        this.isMoving = false;
    }
}
