package com.google.android.material.appbar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.OverScroller;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.ViewCompat;

/* JADX INFO: loaded from: classes2.dex */
abstract class HeaderBehavior<V extends View> extends ViewOffsetBehavior<V> {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Runnable f13112d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    OverScroller f13113e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f13114f;
    private int g;
    private int h;
    private int i;
    private VelocityTracker j;

    private class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final CoordinatorLayout f13115a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final V f13116b;

        a(CoordinatorLayout coordinatorLayout, V v) {
            this.f13115a = coordinatorLayout;
            this.f13116b = v;
        }

        @Override // java.lang.Runnable
        public void run() {
            OverScroller overScroller;
            if (this.f13116b == null || (overScroller = HeaderBehavior.this.f13113e) == null) {
                return;
            }
            if (!overScroller.computeScrollOffset()) {
                HeaderBehavior.this.e(this.f13115a, this.f13116b);
                return;
            }
            HeaderBehavior headerBehavior = HeaderBehavior.this;
            headerBehavior.c(this.f13115a, this.f13116b, headerBehavior.f13113e.getCurrY());
            ViewCompat.a(this.f13116b, this);
        }
    }

    public HeaderBehavior() {
        this.g = -1;
        this.i = -1;
    }

    private void d() {
        if (this.j == null) {
            this.j = VelocityTracker.obtain();
        }
    }

    boolean a(V v) {
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x0051  */
    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean a(androidx.coordinatorlayout.widget.CoordinatorLayout r5, V r6, android.view.MotionEvent r7) {
        /*
            r4 = this;
            int r0 = r4.i
            if (r0 >= 0) goto L12
            android.content.Context r0 = r5.getContext()
            android.view.ViewConfiguration r0 = android.view.ViewConfiguration.get(r0)
            int r0 = r0.getScaledTouchSlop()
            r4.i = r0
        L12:
            int r0 = r7.getAction()
            r1 = 2
            r2 = 1
            if (r0 != r1) goto L1f
            boolean r0 = r4.f13114f
            if (r0 == 0) goto L1f
            return r2
        L1f:
            int r0 = r7.getActionMasked()
            r3 = 0
            if (r0 == 0) goto L60
            r5 = -1
            if (r0 == r2) goto L51
            if (r0 == r1) goto L2f
            r6 = 3
            if (r0 == r6) goto L51
            goto L83
        L2f:
            int r6 = r4.g
            if (r6 != r5) goto L34
            goto L83
        L34:
            int r6 = r7.findPointerIndex(r6)
            if (r6 != r5) goto L3b
            goto L83
        L3b:
            float r5 = r7.getY(r6)
            int r5 = (int) r5
            int r6 = r4.h
            int r6 = r5 - r6
            int r6 = java.lang.Math.abs(r6)
            int r0 = r4.i
            if (r6 <= r0) goto L83
            r4.f13114f = r2
            r4.h = r5
            goto L83
        L51:
            r4.f13114f = r3
            r4.g = r5
            android.view.VelocityTracker r5 = r4.j
            if (r5 == 0) goto L83
            r5.recycle()
            r5 = 0
            r4.j = r5
            goto L83
        L60:
            r4.f13114f = r3
            float r0 = r7.getX()
            int r0 = (int) r0
            float r1 = r7.getY()
            int r1 = (int) r1
            boolean r2 = r4.a(r6)
            if (r2 == 0) goto L83
            boolean r5 = r5.isPointInChildBounds(r6, r0, r1)
            if (r5 == 0) goto L83
            r4.h = r1
            int r5 = r7.getPointerId(r3)
            r4.g = r5
            r4.d()
        L83:
            android.view.VelocityTracker r5 = r4.j
            if (r5 == 0) goto L8a
            r5.addMovement(r7)
        L8a:
            boolean r5 = r4.f13114f
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.material.appbar.HeaderBehavior.a(androidx.coordinatorlayout.widget.CoordinatorLayout, android.view.View, android.view.MotionEvent):boolean");
    }

    @Override // androidx.coordinatorlayout.widget.CoordinatorLayout.Behavior
    public boolean b(CoordinatorLayout coordinatorLayout, V v, MotionEvent motionEvent) {
        if (this.i < 0) {
            this.i = ViewConfiguration.get(coordinatorLayout.getContext()).getScaledTouchSlop();
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked != 0) {
            if (actionMasked == 1) {
                VelocityTracker velocityTracker = this.j;
                if (velocityTracker != null) {
                    velocityTracker.addMovement(motionEvent);
                    this.j.computeCurrentVelocity(1000);
                    a(coordinatorLayout, v, -c(v), 0, this.j.getYVelocity(this.g));
                }
            } else if (actionMasked == 2) {
                int iFindPointerIndex = motionEvent.findPointerIndex(this.g);
                if (iFindPointerIndex == -1) {
                    return false;
                }
                int y = (int) motionEvent.getY(iFindPointerIndex);
                int i = this.h - y;
                if (!this.f13114f) {
                    int iAbs = Math.abs(i);
                    int i2 = this.i;
                    if (iAbs > i2) {
                        this.f13114f = true;
                        i = i > 0 ? i - i2 : i + i2;
                    }
                }
                int i3 = i;
                if (this.f13114f) {
                    this.h = y;
                    a(coordinatorLayout, (View) v, i3, b(v), 0);
                }
            } else if (actionMasked == 3) {
            }
            this.f13114f = false;
            this.g = -1;
            VelocityTracker velocityTracker2 = this.j;
            if (velocityTracker2 != null) {
                velocityTracker2.recycle();
                this.j = null;
            }
        } else {
            int x = (int) motionEvent.getX();
            int y2 = (int) motionEvent.getY();
            if (!coordinatorLayout.isPointInChildBounds(v, x, y2) || !a(v)) {
                return false;
            }
            this.h = y2;
            this.g = motionEvent.getPointerId(0);
            d();
        }
        VelocityTracker velocityTracker3 = this.j;
        if (velocityTracker3 != null) {
            velocityTracker3.addMovement(motionEvent);
        }
        return true;
    }

    int c(CoordinatorLayout coordinatorLayout, V v, int i) {
        return b(coordinatorLayout, v, i, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    void e(CoordinatorLayout coordinatorLayout, V v) {
    }

    int c() {
        return b();
    }

    int c(V v) {
        return v.getHeight();
    }

    public HeaderBehavior(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.g = -1;
        this.i = -1;
    }

    final int a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        return b(coordinatorLayout, v, c() - i, i2, i3);
    }

    final boolean a(CoordinatorLayout coordinatorLayout, V v, int i, int i2, float f2) {
        Runnable runnable = this.f13112d;
        if (runnable != null) {
            v.removeCallbacks(runnable);
            this.f13112d = null;
        }
        if (this.f13113e == null) {
            this.f13113e = new OverScroller(v.getContext());
        }
        this.f13113e.fling(0, b(), 0, Math.round(f2), 0, 0, i, i2);
        if (this.f13113e.computeScrollOffset()) {
            this.f13112d = new a(coordinatorLayout, v);
            ViewCompat.a(v, this.f13112d);
            return true;
        }
        e(coordinatorLayout, v);
        return false;
    }

    int b(CoordinatorLayout coordinatorLayout, V v, int i, int i2, int i3) {
        int iA;
        int iB = b();
        if (i2 == 0 || iB < i2 || iB > i3 || iB == (iA = androidx.core.c.a.a(i, i2, i3))) {
            return 0;
        }
        a(iA);
        return iB - iA;
    }

    int b(V v) {
        return -v.getHeight();
    }
}
