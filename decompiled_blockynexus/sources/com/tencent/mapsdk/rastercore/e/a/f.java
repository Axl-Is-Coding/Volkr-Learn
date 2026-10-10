package com.tencent.mapsdk.rastercore.e.a;

import com.tencent.mapsdk.raster.model.TileOverlayOptions;
import com.tencent.mapsdk.raster.model.TileProvider;
import java.io.File;

/* JADX INFO: loaded from: classes5.dex */
public final class f {
    private static int h;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private com.tencent.mapsdk.rastercore.d.f f19580a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final String f19581b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f19582c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private float f19583d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private boolean f19584e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private TileProvider f19585f;
    private String g;

    public f(com.tencent.mapsdk.rastercore.d.f fVar, TileOverlayOptions tileOverlayOptions) {
        this.f19582c = true;
        this.f19583d = Float.NEGATIVE_INFINITY;
        this.f19584e = true;
        StringBuilder sb = new StringBuilder("TileOverlay_");
        int i = h;
        h = i + 1;
        sb.append(i);
        this.f19581b = sb.toString();
        this.f19580a = fVar;
        this.g = com.tencent.mapsdk.rastercore.d.f.a().getPackageName() + File.separator + this.f19581b;
        this.f19584e = tileOverlayOptions.getDiskCacheEnabled();
        if (!this.f19584e) {
            this.g = null;
        }
        this.f19585f = tileOverlayOptions.getTileProvider();
        this.f19583d = tileOverlayOptions.getZIndex();
        this.f19582c = tileOverlayOptions.isVisible();
    }

    public static void c() {
    }

    public final float a() {
        return this.f19583d;
    }

    public final void a(boolean z) {
        this.f19582c = z;
        this.f19580a.a(false, false);
    }

    public final void b() {
        this.f19580a.g().a(this);
    }

    public final String d() {
        return this.f19581b;
    }

    public final boolean e() {
        return this.f19582c;
    }

    public final boolean equals(Object obj) {
        return obj != null && (obj instanceof f) && this.f19581b.equals(((f) obj).f19581b);
    }

    public final TileProvider f() {
        return this.f19585f;
    }

    public final String g() {
        return this.g;
    }

    public final boolean h() {
        return this.f19584e;
    }
}
