package com.tencent.mapsdk.rastercore.d;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import android.graphics.Rect;
import android.os.Build;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import com.tencent.mapsdk.raster.model.LatLng;
import com.tencent.mapsdk.rastercore.a.a;
import com.tencent.tencentmap.mapsdk.map.CancelableCallback;
import com.tencent.tencentmap.mapsdk.map.TencentMap;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

/* JADX INFO: loaded from: classes5.dex */
public final class b extends View {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private f f19504a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private c f19505b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19506c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile boolean f19507d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private List<Runnable> f19508e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private com.tencent.mapsdk.rastercore.b.d f19509f;
    private com.tencent.mapsdk.rastercore.b.f g;
    private PointF h;
    private TencentMap.OnMapLoadedListener i;
    private final Handler j;
    private com.tencent.mapsdk.rastercore.a.c k;
    private com.tencent.mapsdk.rastercore.a.b l;

    public b(f fVar) {
        super(f.a());
        this.f19506c = false;
        this.f19507d = false;
        this.f19508e = new Vector();
        this.g = null;
        this.h = null;
        this.j = new Handler() { // from class: com.tencent.mapsdk.rastercore.d.b.1
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                int i = message.what;
                if (i != 11) {
                    if (i != 16) {
                        return;
                    }
                    b.this.f19504a.o();
                    return;
                }
                Iterator it = b.this.f19508e.iterator();
                while (it.hasNext()) {
                    ((Runnable) it.next()).run();
                }
                b.this.f19508e.clear();
                if (b.this.i != null) {
                    b.this.i.onMapLoaded();
                }
            }
        };
        this.f19504a = fVar;
        this.f19505b = fVar.b();
        this.f19509f = new com.tencent.mapsdk.rastercore.b.d(10.0d);
        if (fVar.f().a() >= 3 && fVar.f().b() > 1.0f) {
            this.f19509f.a(1.3d);
        }
        this.g = com.tencent.mapsdk.rastercore.c.a(new LatLng(39.91669d, 116.39716d));
        this.h = new PointF(getWidth() / 2, getHeight() / 2);
        if (Build.VERSION.SDK_INT <= 11 || fVar.c() == null) {
            return;
        }
        fVar.c().setLayerType(2, null);
    }

    private com.tencent.mapsdk.rastercore.b.f a(int i, int i2) {
        double dB = this.g.b();
        double d2 = i;
        double d3 = this.f19509f.d();
        Double.isNaN(d2);
        double d4 = dB + (d2 * d3);
        double dA = this.g.a();
        double d5 = i2;
        double d6 = this.f19509f.d();
        Double.isNaN(d5);
        return new com.tencent.mapsdk.rastercore.b.f(d4, dA - (d5 * d6));
    }

    private void a(com.tencent.mapsdk.rastercore.b.d dVar, PointF pointF) {
        double width = getWidth();
        Double.isNaN(width);
        double d2 = width / 2.0d;
        double height = getHeight();
        Double.isNaN(height);
        double d3 = height / 2.0d;
        double dB = this.g.b();
        double d4 = pointF.x;
        Double.isNaN(d4);
        double d5 = (d4 - d2) * this.f19509f.d();
        double d6 = pointF.x;
        Double.isNaN(d6);
        double d7 = dB + d5 + ((d2 - d6) * dVar.d());
        double dA = this.g.a();
        double d8 = pointF.y;
        Double.isNaN(d8);
        double d9 = (d8 - d3) * this.f19509f.d();
        double d10 = pointF.y;
        Double.isNaN(d10);
        double d11 = dA - (d9 + ((d3 - d10) * dVar.d()));
        this.g.b(d7);
        this.g.a(d11);
        PointF pointF2 = this.h;
        pointF2.x = (int) d2;
        pointF2.y = (int) d3;
        this.f19509f.b(dVar.c());
        this.f19505b.a(this.g);
        this.f19504a.a(false, false);
    }

    private void b(double d2, PointF pointF, boolean z, long j, CancelableCallback cancelableCallback) {
        a(d2, pointF, z, j, a.EnumC0171a.ACCELERATE_DECELERATE, cancelableCallback);
    }

    private PointF e() {
        return new PointF(getWidth() / 2, getHeight() / 2);
    }

    public final PointF a() {
        return this.h;
    }

    public final void a(double d2, PointF pointF) {
        a(this.f19505b.a(new com.tencent.mapsdk.rastercore.b.d(this.f19509f.a(), this.f19509f.b() * d2)), pointF);
    }

    public final void a(double d2, PointF pointF, boolean z, long j, a.EnumC0171a enumC0171a, CancelableCallback cancelableCallback) {
        if (!z) {
            a(this.f19505b.a(new com.tencent.mapsdk.rastercore.b.d(d2)), pointF);
            if (cancelableCallback != null) {
                cancelableCallback.onFinish();
                return;
            }
            return;
        }
        com.tencent.mapsdk.rastercore.a.c cVar = this.k;
        if (cVar != null) {
            cVar.b();
        }
        this.k = new com.tencent.mapsdk.rastercore.a.c(this.f19504a, d2, pointF, j, cancelableCallback);
        this.k.a(enumC0171a);
        this.k.a();
    }

    public final void a(double d2, PointF pointF, boolean z, long j, CancelableCallback cancelableCallback) {
        b(d2, pointF, false, 0L, null);
    }

    public final void a(double d2, PointF pointF, boolean z, CancelableCallback cancelableCallback) {
        b(this.f19509f.c() + d2, pointF, z, 500L, cancelableCallback);
    }

    public final void a(double d2, boolean z, CancelableCallback cancelableCallback) {
        b(this.f19509f.c() + d2, e(), z, 500L, cancelableCallback);
    }

    public final void a(int i, int i2, long j, CancelableCallback cancelableCallback) {
        a(a(i, i2), j, cancelableCallback);
    }

    public final void a(PointF pointF, boolean z, CancelableCallback cancelableCallback) {
        b(this.f19509f.c() + 1.0d, pointF, true, 500L, null);
    }

    public final void a(com.tencent.mapsdk.rastercore.b.f fVar) {
        this.g = fVar;
        this.f19505b.a(this.g);
        this.f19504a.a(false, false);
    }

    public final void a(com.tencent.mapsdk.rastercore.b.f fVar, long j, CancelableCallback cancelableCallback) {
        com.tencent.mapsdk.rastercore.a.b bVar = this.l;
        if (bVar != null) {
            bVar.b();
        }
        this.l = new com.tencent.mapsdk.rastercore.a.b(this.f19504a, fVar, j, cancelableCallback);
        this.l.a();
    }

    public final void a(final com.tencent.mapsdk.rastercore.c.a aVar) {
        if (this.f19507d || !aVar.a()) {
            aVar.a(this.f19504a);
        } else {
            this.f19508e.add(new Runnable() { // from class: com.tencent.mapsdk.rastercore.d.b.2
                @Override // java.lang.Runnable
                public final void run() {
                    aVar.a(b.this.f19504a);
                }
            });
        }
    }

    public final void a(TencentMap.OnMapLoadedListener onMapLoadedListener) {
        this.i = onMapLoadedListener;
    }

    public final void a(boolean z) {
        this.f19506c = true;
    }

    public final void a(boolean z, CancelableCallback cancelableCallback) {
        b(this.f19509f.c() + 1.0d, e(), z, 500L, cancelableCallback);
    }

    public final com.tencent.mapsdk.rastercore.b.f b() {
        return this.g;
    }

    public final void b(double d2, boolean z, CancelableCallback cancelableCallback) {
        b(d2, e(), z, 500L, cancelableCallback);
    }

    public final void b(com.tencent.mapsdk.rastercore.b.f fVar) {
        a(fVar);
    }

    public final void b(boolean z, CancelableCallback cancelableCallback) {
        b(this.f19509f.c() - 1.0d, e(), z, 500L, cancelableCallback);
    }

    public final double c() {
        return this.f19509f.c();
    }

    @Override // android.view.View
    public final void clearAnimation() {
        super.clearAnimation();
        com.tencent.mapsdk.rastercore.a.b bVar = this.l;
        if (bVar != null) {
            bVar.b();
        }
        com.tencent.mapsdk.rastercore.a.c cVar = this.k;
        if (cVar != null) {
            cVar.b();
        }
    }

    public final com.tencent.mapsdk.rastercore.b.d d() {
        return this.f19509f;
    }

    @Override // android.view.View
    public final void draw(Canvas canvas) {
        if (!this.f19507d) {
            this.j.sendEmptyMessage(11);
            this.f19507d = true;
        }
        boolean zA = this.f19504a.g().a(canvas);
        this.f19504a.e().a(canvas);
        if (!f.p()) {
            Paint paint = new Paint();
            paint.setColor(-65536);
            paint.setTextSize(50.0f);
            Rect rect = new Rect();
            int width = getWidth();
            int height = getHeight();
            paint.getTextBounds("鉴权失败，请到腾讯", 0, 9, rect);
            int i = width / 2;
            int i2 = height / 2;
            canvas.drawText("鉴权失败，请到腾讯", i - (rect.width() / 2), i2 - rect.height(), paint);
            paint.getTextBounds("地图官网申请密钥", 0, 8, rect);
            canvas.drawText("地图官网申请密钥", i - (rect.width() / 2), i2 + 2, paint);
        }
        this.f19504a.d(zA);
        if (this.f19506c && zA) {
            this.f19506c = false;
            this.j.sendEmptyMessage(16);
        }
    }

    @Override // android.view.View
    protected final void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (this.f19505b.g() != 0.0d && this.f19505b.h() != 0.0d) {
            c cVar = this.f19505b;
            cVar.b(cVar.g(), this.f19505b.h());
            this.f19505b.a(0);
            this.f19505b.b(0);
        }
        this.h = new PointF(getWidth() / 2, getHeight() / 2);
        int i5 = com.tencent.mapsdk.rastercore.b.d.f19448a;
        while (Math.pow(2.0d, i5) * 256.0d < Math.max(getWidth(), getHeight())) {
            i5++;
        }
        com.tencent.mapsdk.rastercore.b.d.f19448a = i5;
        int iA = this.f19505b.j().a();
        int i6 = com.tencent.mapsdk.rastercore.b.d.f19448a;
        if (iA < i6) {
            this.f19505b.d(i6);
        }
        this.f19504a.a(false, false);
    }

    @Override // android.view.View
    public final void scrollBy(int i, int i2) {
        a(a(i, i2));
    }
}
