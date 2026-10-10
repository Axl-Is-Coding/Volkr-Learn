package com.tencent.mapsdk.rastercore.a;

import android.os.Handler;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.Scroller;
import cn.qqtheme.framework.widget.WheelView;
import com.tencent.mapsdk.rastercore.d.f;
import com.tencent.mapsdk.rastercore.d.g;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;

/* JADX INFO: loaded from: classes5.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected f f19414a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected com.tencent.mapsdk.rastercore.d.b f19415b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected CancelableCallback f19416c;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private Scroller f19419f;
    private long g;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private EnumC0171a f19417d = EnumC0171a.ACCELERATE_DECELERATE;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private Handler f19418e = new Handler();
    private float h = WheelView.DividerConfig.FILL;
    private boolean i = false;
    private double j = 0.0d;
    private Runnable k = new Runnable() { // from class: com.tencent.mapsdk.rastercore.a.a.1
        @Override // java.lang.Runnable
        public final void run() {
            g gVarH;
            boolean z = false;
            if (a.this.f19419f.computeScrollOffset()) {
                float currX = (a.this.f19419f.getCurrX() * 1.0f) / 10000.0f;
                float f2 = currX - a.this.h;
                a aVar = a.this;
                double d2 = aVar.j;
                double d3 = f2;
                Double.isNaN(d3);
                aVar.j = d2 + d3;
                if (a.this.j < 1.0d) {
                    a.this.a(f2);
                }
                a.this.h = currX;
                if (a.this.i) {
                    a.this.f19418e.postDelayed(a.this.k, 5L);
                }
                gVarH = a.this.f19414a.h();
            } else {
                a.this.d();
                CancelableCallback cancelableCallback = a.this.f19416c;
                if (cancelableCallback != null) {
                    cancelableCallback.onFinish();
                }
                a.a(a.this, false);
                gVarH = a.this.f19414a.h();
                z = true;
            }
            gVarH.a(z);
        }
    };

    /* JADX INFO: renamed from: com.tencent.mapsdk.rastercore.a.a$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f19421a = new int[EnumC0171a.values().length];

        static {
            try {
                f19421a[EnumC0171a.ACCELERATE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19421a[EnumC0171a.DECELERATE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19421a[EnumC0171a.ACCELERATE_DECELERATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    /* JADX INFO: renamed from: com.tencent.mapsdk.rastercore.a.a$a, reason: collision with other inner class name */
    public enum EnumC0171a {
        ACCELERATE,
        DECELERATE,
        ACCELERATE_DECELERATE
    }

    public a(f fVar, long j, CancelableCallback cancelableCallback) {
        this.f19414a = fVar;
        this.f19415b = fVar.c();
        this.g = j;
        this.f19416c = cancelableCallback;
    }

    static /* synthetic */ boolean a(a aVar, boolean z) {
        aVar.i = false;
        return false;
    }

    public final void a() {
        int i = AnonymousClass2.f19421a[this.f19417d.ordinal()];
        this.f19419f = i != 1 ? i != 2 ? i != 3 ? new Scroller(f.a()) : new Scroller(f.a(), new AccelerateDecelerateInterpolator()) : new Scroller(f.a(), new DecelerateInterpolator()) : new Scroller(f.a(), new AccelerateInterpolator());
        c();
        this.i = true;
        this.f19419f.startScroll(0, 0, 10000, 0, (int) this.g);
        this.f19418e.postDelayed(this.k, 5L);
        this.f19414a.a(false, false);
    }

    protected abstract void a(float f2);

    public final void a(EnumC0171a enumC0171a) {
        this.f19417d = enumC0171a;
    }

    public final void b() {
        if (this.i) {
            this.i = false;
            CancelableCallback cancelableCallback = this.f19416c;
            if (cancelableCallback != null) {
                cancelableCallback.onCancel();
            }
            this.f19414a.h().a(true);
        }
    }

    protected abstract void c();

    protected abstract void d();
}
