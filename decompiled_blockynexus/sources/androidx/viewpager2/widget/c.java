package androidx.viewpager2.widget;

import android.os.SystemClock;
import android.view.MotionEvent;
import android.view.VelocityTracker;
import android.view.ViewConfiguration;
import androidx.recyclerview.widget.RecyclerView;
import cn.qqtheme.framework.widget.WheelView;

/* JADX INFO: compiled from: FakeDrag.java */
/* JADX INFO: loaded from: classes.dex */
final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final ViewPager2 f2436a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final ScrollEventAdapter f2437b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final RecyclerView f2438c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private VelocityTracker f2439d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private int f2440e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f2441f;
    private int g;
    private long h;

    c(ViewPager2 viewPager2, ScrollEventAdapter scrollEventAdapter, RecyclerView recyclerView) {
        this.f2436a = viewPager2;
        this.f2437b = scrollEventAdapter;
        this.f2438c = recyclerView;
    }

    private void d() {
        VelocityTracker velocityTracker = this.f2439d;
        if (velocityTracker != null) {
            velocityTracker.clear();
        } else {
            this.f2439d = VelocityTracker.obtain();
            this.f2440e = ViewConfiguration.get(this.f2436a.getContext()).getScaledMaximumFlingVelocity();
        }
    }

    boolean a() {
        if (this.f2437b.c()) {
            return false;
        }
        this.g = 0;
        this.f2441f = 0;
        this.h = SystemClock.uptimeMillis();
        d();
        this.f2437b.f();
        if (!this.f2437b.e()) {
            this.f2438c.stopScroll();
        }
        a(this.h, 0, WheelView.DividerConfig.FILL, WheelView.DividerConfig.FILL);
        return true;
    }

    boolean b() {
        if (!this.f2437b.d()) {
            return false;
        }
        this.f2437b.h();
        VelocityTracker velocityTracker = this.f2439d;
        velocityTracker.computeCurrentVelocity(1000, this.f2440e);
        if (this.f2438c.fling((int) velocityTracker.getXVelocity(), (int) velocityTracker.getYVelocity())) {
            return true;
        }
        this.f2436a.snapToPage();
        return true;
    }

    boolean c() {
        return this.f2437b.d();
    }

    boolean a(float f2) {
        if (!this.f2437b.d()) {
            return false;
        }
        this.f2441f -= f2;
        int iRound = Math.round(this.f2441f - this.g);
        this.g += iRound;
        long jUptimeMillis = SystemClock.uptimeMillis();
        boolean z = this.f2436a.getOrientation() == 0;
        int i = z ? iRound : 0;
        if (z) {
            iRound = 0;
        }
        float f3 = z ? this.f2441f : WheelView.DividerConfig.FILL;
        float f4 = z ? WheelView.DividerConfig.FILL : this.f2441f;
        this.f2438c.scrollBy(i, iRound);
        a(jUptimeMillis, 2, f3, f4);
        return true;
    }

    private void a(long j, int i, float f2, float f3) {
        MotionEvent motionEventObtain = MotionEvent.obtain(this.h, j, i, f2, f3, 0);
        this.f2439d.addMovement(motionEventObtain);
        motionEventObtain.recycle();
    }
}
