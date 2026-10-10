package androidx.appcompat.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewParent;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: ForwardingListener.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class I implements View.OnAttachStateChangeListener, View.OnTouchListener {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final float f533a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final int f534b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final int f535c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    final View f536d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Runnable f537e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Runnable f538f;
    private boolean g;
    private int h;
    private final int[] i = new int[2];

    /* JADX INFO: compiled from: ForwardingListener.java */
    private class a implements Runnable {
        a() {
        }

        @Override // java.lang.Runnable
        public void run() {
            ViewParent parent = I.this.f536d.getParent();
            if (parent != null) {
                parent.requestDisallowInterceptTouchEvent(true);
            }
        }
    }

    /* JADX INFO: compiled from: ForwardingListener.java */
    private class b implements Runnable {
        b() {
        }

        @Override // java.lang.Runnable
        public void run() {
            I.this.d();
        }
    }

    public I(View view) {
        this.f536d = view;
        view.setLongClickable(true);
        view.addOnAttachStateChangeListener(this);
        this.f533a = ViewConfiguration.get(view.getContext()).getScaledTouchSlop();
        this.f534b = ViewConfiguration.getTapTimeout();
        this.f535c = (this.f534b + ViewConfiguration.getLongPressTimeout()) / 2;
    }

    private boolean a(MotionEvent motionEvent) {
        G g;
        View view = this.f536d;
        androidx.appcompat.view.menu.m mVarA = a();
        if (mVarA == null || !mVarA.c() || (g = (G) mVarA.f()) == null || !g.isShown()) {
            return false;
        }
        MotionEvent motionEventObtainNoHistory = MotionEvent.obtainNoHistory(motionEvent);
        a(view, motionEventObtainNoHistory);
        b(g, motionEventObtainNoHistory);
        boolean zOnForwardedEvent = g.onForwardedEvent(motionEventObtainNoHistory, this.h);
        motionEventObtainNoHistory.recycle();
        int actionMasked = motionEvent.getActionMasked();
        return zOnForwardedEvent && (actionMasked != 1 && actionMasked != 3);
    }

    /* JADX WARN: Removed duplicated region for block: B:20:0x003d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private boolean b(android.view.MotionEvent r6) {
        /*
            r5 = this;
            android.view.View r0 = r5.f536d
            boolean r1 = r0.isEnabled()
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            int r1 = r6.getActionMasked()
            if (r1 == 0) goto L41
            r3 = 1
            if (r1 == r3) goto L3d
            r4 = 2
            if (r1 == r4) goto L1a
            r6 = 3
            if (r1 == r6) goto L3d
            goto L6d
        L1a:
            int r1 = r5.h
            int r1 = r6.findPointerIndex(r1)
            if (r1 < 0) goto L6d
            float r4 = r6.getX(r1)
            float r6 = r6.getY(r1)
            float r1 = r5.f533a
            boolean r6 = a(r0, r4, r6, r1)
            if (r6 != 0) goto L6d
            r5.e()
            android.view.ViewParent r6 = r0.getParent()
            r6.requestDisallowInterceptTouchEvent(r3)
            return r3
        L3d:
            r5.e()
            goto L6d
        L41:
            int r6 = r6.getPointerId(r2)
            r5.h = r6
            java.lang.Runnable r6 = r5.f537e
            if (r6 != 0) goto L52
            androidx.appcompat.widget.I$a r6 = new androidx.appcompat.widget.I$a
            r6.<init>()
            r5.f537e = r6
        L52:
            java.lang.Runnable r6 = r5.f537e
            int r1 = r5.f534b
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
            java.lang.Runnable r6 = r5.f538f
            if (r6 != 0) goto L65
            androidx.appcompat.widget.I$b r6 = new androidx.appcompat.widget.I$b
            r6.<init>()
            r5.f538f = r6
        L65:
            java.lang.Runnable r6 = r5.f538f
            int r1 = r5.f535c
            long r3 = (long) r1
            r0.postDelayed(r6, r3)
        L6d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.I.b(android.view.MotionEvent):boolean");
    }

    private void e() {
        Runnable runnable = this.f538f;
        if (runnable != null) {
            this.f536d.removeCallbacks(runnable);
        }
        Runnable runnable2 = this.f537e;
        if (runnable2 != null) {
            this.f536d.removeCallbacks(runnable2);
        }
    }

    public abstract androidx.appcompat.view.menu.m a();

    protected abstract boolean b();

    protected boolean c() {
        androidx.appcompat.view.menu.m mVarA = a();
        if (mVarA == null || !mVarA.c()) {
            return true;
        }
        mVarA.dismiss();
        return true;
    }

    void d() {
        e();
        View view = this.f536d;
        if (view.isEnabled() && !view.isLongClickable() && b()) {
            view.getParent().requestDisallowInterceptTouchEvent(true);
            long jUptimeMillis = SystemClock.uptimeMillis();
            MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0);
            view.onTouchEvent(motionEventObtain);
            motionEventObtain.recycle();
            this.g = true;
        }
    }

    @Override // android.view.View.OnTouchListener
    public boolean onTouch(View view, MotionEvent motionEvent) {
        boolean z;
        boolean z2 = this.g;
        if (z2) {
            z = a(motionEvent) || !c();
        } else {
            z = b(motionEvent) && b();
            if (z) {
                long jUptimeMillis = SystemClock.uptimeMillis();
                MotionEvent motionEventObtain = MotionEvent.obtain(jUptimeMillis, jUptimeMillis, 3, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL, 0);
                this.f536d.onTouchEvent(motionEventObtain);
                motionEventObtain.recycle();
            }
        }
        this.g = z;
        return z || z2;
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewAttachedToWindow(View view) {
    }

    @Override // android.view.View.OnAttachStateChangeListener
    public void onViewDetachedFromWindow(View view) {
        this.g = false;
        this.h = -1;
        Runnable runnable = this.f537e;
        if (runnable != null) {
            this.f536d.removeCallbacks(runnable);
        }
    }

    private static boolean a(View view, float f2, float f3, float f4) {
        float f5 = -f4;
        return f2 >= f5 && f3 >= f5 && f2 < ((float) (view.getRight() - view.getLeft())) + f4 && f3 < ((float) (view.getBottom() - view.getTop())) + f4;
    }

    private boolean a(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.i);
        motionEvent.offsetLocation(r0[0], r0[1]);
        return true;
    }

    private boolean b(View view, MotionEvent motionEvent) {
        view.getLocationOnScreen(this.i);
        motionEvent.offsetLocation(-r0[0], -r0[1]);
        return true;
    }
}
