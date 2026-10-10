package com.tencent.mapsdk.rastercore.d;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Rect;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewGroup;
import com.tencent.mapsdk.raster.model.QMapLanguage;
import com.tencent.mapsdk.rastercore.c;
import com.tencent.mapsdk.rastercore.d;
import com.tencent.mapsdk.rastercore.d.a;
import com.tencent.mapsdk.rastercore.tile.a;
import com.tencent.tencentmap.mapsdk.map.MapView;
import com.tencent.tencentmap.mapsdk.map.TencentMap;

/* JADX INFO: loaded from: classes5.dex */
public final class f implements c.a, d.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile Context f19526a = null;
    private static boolean p = true;
    private static volatile String r = QMapLanguage.getLanguageCode(QMapLanguage.QMapLanguage_en);
    private static int w = 160;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private MapView f19527b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f19528c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private b f19529d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private g f19530e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private a.AnonymousClass1 f19531f;
    private com.tencent.mapsdk.rastercore.tile.f g;
    private com.tencent.mapsdk.rastercore.d.a.a h;
    private c i;
    private a.AnonymousClass1 j;
    private volatile com.tencent.mapsdk.rastercore.g.b k;
    private com.tencent.mapsdk.rastercore.g.a l;
    private int m = 1;
    private TencentMap.OnScreenShotListener n = null;
    private boolean o = false;
    private Rect q = null;
    private boolean s = false;
    private boolean t = false;
    private com.tencent.mapsdk.rastercore.b.c u;
    private com.tencent.mapsdk.rastercore.a v;

    public f(MapView mapView) {
        Context applicationContext = mapView.getContext().getApplicationContext();
        f19526a = applicationContext;
        w = applicationContext.getResources().getDisplayMetrics().densityDpi;
        new Thread(this) { // from class: com.tencent.mapsdk.rastercore.d.f.1
            @Override // java.lang.Thread, java.lang.Runnable
            public final void run() {
                super.run();
                com.tencent.mapsdk.rastercore.tile.a.a.a().a(f.f19526a);
            }
        }.start();
        com.tencent.mapsdk.rastercore.f.a.a().a(f19526a);
        e.a().a(f19526a);
        h.l();
        this.f19527b = mapView;
        this.j = new a.AnonymousClass1(this);
        this.k = new com.tencent.mapsdk.rastercore.g.b(this);
        this.h = new com.tencent.mapsdk.rastercore.d.a.a(this);
        this.i = new c(this);
        this.l = new com.tencent.mapsdk.rastercore.g.a(this);
        this.f19528c = new a(this);
        this.f19529d = new b(this);
        this.f19530e = new g(this);
        this.f19531f = new a.AnonymousClass1(this);
        this.g = new com.tencent.mapsdk.rastercore.tile.f(this);
        this.i.a();
        ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -1);
        mapView.addView(this.f19529d, layoutParams);
        mapView.addView(this.l, layoutParams);
        mapView.addView(this.k, layoutParams);
        this.j.b(1);
        this.j.a(true);
        this.j.c(0);
        this.v = new com.tencent.mapsdk.rastercore.a();
        this.v.a();
        new com.tencent.mapsdk.rastercore.c(f19526a, this).a();
        new com.tencent.mapsdk.rastercore.d(f19526a, this).a();
    }

    public static Context a() {
        return f19526a;
    }

    public static void a(String str) {
        r = str;
    }

    public static void e(boolean z) {
        p = false;
    }

    public static void n() {
    }

    public static boolean p() {
        return p;
    }

    public static String q() {
        return r;
    }

    public static int s() {
        return w;
    }

    private com.tencent.mapsdk.rastercore.b.c u() {
        com.tencent.mapsdk.rastercore.b.f[] fVarArrB = this.i.b();
        com.tencent.mapsdk.rastercore.b.f fVarB = this.f19529d.b();
        float zoom = this.i.d().getZoom();
        com.tencent.mapsdk.rastercore.b.c cVar = this.u;
        if (cVar == null) {
            this.u = new com.tencent.mapsdk.rastercore.b.c(fVarB, fVarArrB, zoom);
        } else {
            cVar.a(fVarB, fVarArrB, zoom);
        }
        return this.u;
    }

    public final void a(float f2) {
        if (this.k != null) {
            this.k.a(f2);
            this.k.invalidate();
        }
    }

    public final void a(int i) {
        this.m = i;
        a(false, false);
    }

    public final void a(int i, int[] iArr) {
        if (this.k != null) {
            this.k.a(iArr);
        }
    }

    public final void a(Bitmap bitmap) {
        if (this.k != null) {
            this.k.a(bitmap);
            this.k.invalidate();
        }
    }

    public final void a(Bundle bundle) {
        if (bundle != null) {
            this.j.e(bundle.getBoolean("ANIMATION_ENABLED", true));
            this.j.b(bundle.getBoolean("SCROLL_ENABLED", true));
            this.j.c(bundle.getBoolean("ZOOM_ENABLED", true));
            this.j.b(bundle.getInt("LOGO_POSITION", 0));
            this.j.c(bundle.getInt("SCALEVIEW_POSITION", 0));
            this.j.a(bundle.getBoolean("SCALE_CONTROLL_ENABLED", true));
            b bVar = this.f19529d;
            bVar.b(bundle.getDouble("ZOOM", bVar.c()), false, null);
            Double dValueOf = Double.valueOf(bundle.getDouble("CENTERX", Double.NaN));
            Double dValueOf2 = Double.valueOf(bundle.getDouble("CENTERY", Double.NaN));
            if (dValueOf.isNaN() || dValueOf2.isNaN()) {
                return;
            }
            this.f19529d.a(new com.tencent.mapsdk.rastercore.b.f(dValueOf.doubleValue(), dValueOf2.doubleValue()));
        }
    }

    public final void a(TencentMap.OnScreenShotListener onScreenShotListener) {
        a(onScreenShotListener, (Rect) null);
    }

    public final void a(TencentMap.OnScreenShotListener onScreenShotListener, Rect rect) {
        b bVar;
        this.n = onScreenShotListener;
        this.q = rect;
        if (Build.VERSION.SDK_INT > 11 && (bVar = this.f19529d) != null) {
            bVar.setLayerType(1, null);
        }
        if (this.o) {
            o();
            return;
        }
        b bVar2 = this.f19529d;
        if (bVar2 != null) {
            bVar2.a(true);
        }
        a(false, false);
    }

    @Override // com.tencent.mapsdk.rastercore.c.a
    public final void a(boolean z) {
        if (z) {
            a(false, false);
        }
    }

    public final void a(boolean z, boolean z2) {
        this.o = false;
        com.tencent.mapsdk.rastercore.d.a.a aVar = this.h;
        if (aVar != null) {
            aVar.a(u());
        }
        this.f19531f.a(z, z2);
        this.f19527b.layout();
        this.f19527b.postInvalidate();
    }

    public final c b() {
        return this.i;
    }

    public final void b(int i) {
        if (this.k != null) {
            this.k.a(i);
            this.k.invalidate();
            if (this.l.getVisibility() == 0) {
                this.l.invalidate();
            }
        }
    }

    public final void b(final Bitmap bitmap) {
        this.f19527b.post(new Runnable() { // from class: com.tencent.mapsdk.rastercore.d.f.2
            @Override // java.lang.Runnable
            public final void run() {
                f.this.a(bitmap);
            }
        });
    }

    public final void b(Bundle bundle) {
        bundle.putBoolean("ANIMATION_ENABLED", this.j.k());
        bundle.putBoolean("SCROLL_ENABLED", this.j.h());
        bundle.putBoolean("ZOOM_ENABLED", this.j.i());
        bundle.putInt("LOGO_POSITION", this.j.j());
        bundle.putInt("SCALEVIEW_POSITION", this.j.f());
        bundle.putBoolean("SCALE_CONTROLL_ENABLED", this.j.g());
        bundle.putDouble("ZOOM", this.f19529d.c());
        bundle.putDouble("CENTERX", this.f19529d.b().b());
        bundle.putDouble("CENTERY", this.f19529d.b().a());
    }

    @Override // com.tencent.mapsdk.rastercore.d.a
    public final void b(boolean z) {
        if (z) {
            this.h.a();
        }
        com.tencent.mapsdk.rastercore.d.a.a aVar = this.h;
        com.tencent.mapsdk.rastercore.d.a.a.a(h.j());
        this.h.a(u());
        a(false, false);
    }

    public final b c() {
        return this.f19529d;
    }

    public final void c(int i) {
        com.tencent.mapsdk.rastercore.g.a aVar = this.l;
        if (aVar == null || aVar.getVisibility() != 0) {
            return;
        }
        this.l.a(i);
        this.l.invalidate();
    }

    public final void c(boolean z) {
        if (z) {
            this.l.setVisibility(0);
            this.l.d();
            return;
        }
        com.tencent.mapsdk.rastercore.g.a aVar = this.l;
        com.tencent.mapsdk.rastercore.g.a.b();
        com.tencent.mapsdk.rastercore.g.a aVar2 = this.l;
        com.tencent.mapsdk.rastercore.g.a.c();
        this.l.setVisibility(8);
    }

    public final MapView d() {
        return this.f19527b;
    }

    protected final void d(boolean z) {
        this.o = z;
    }

    public final a e() {
        return this.f19528c;
    }

    public final a.AnonymousClass1 f() {
        return this.j;
    }

    protected final void f(boolean z) {
        this.s = z;
    }

    public final a.AnonymousClass1 g() {
        return this.f19531f;
    }

    public final void g(boolean z) {
        if (z != this.t) {
            this.t = z;
            a(false, false);
        }
    }

    public final g h() {
        return this.f19530e;
    }

    public final com.tencent.mapsdk.rastercore.tile.f i() {
        return this.g;
    }

    public final void j() {
        this.l.e();
    }

    public final void k() {
        this.l.d();
    }

    public final int l() {
        return this.m;
    }

    public final void m() {
        com.tencent.mapsdk.rastercore.tile.b.f.a();
        this.l.a();
        this.k.a();
        this.f19528c.b();
        this.f19527b.stopAnimation();
        this.f19527b.removeAllViews();
        this.f19531f.a();
        this.h.b();
        e.a().b();
        com.tencent.mapsdk.rastercore.tile.a.a.a().c();
        System.gc();
    }

    protected final void o() {
        Bitmap bitmapCreateBitmap;
        b bVar;
        if (this.n != null) {
            this.f19527b.setDrawingCacheEnabled(true);
            this.f19527b.buildDrawingCache();
            if (this.q == null) {
                bitmapCreateBitmap = Bitmap.createBitmap(this.f19527b.getDrawingCache());
            } else {
                Bitmap drawingCache = this.f19527b.getDrawingCache();
                Rect rect = this.q;
                bitmapCreateBitmap = Bitmap.createBitmap(drawingCache, rect.left, rect.top, rect.width(), this.q.height());
            }
            this.f19527b.destroyDrawingCache();
            this.n.onMapScreenShot(bitmapCreateBitmap);
            if (Build.VERSION.SDK_INT <= 11 || !this.s || (bVar = this.f19529d) == null) {
                return;
            }
            bVar.setLayerType(2, null);
        }
    }

    public final boolean r() {
        return this.t;
    }
}
