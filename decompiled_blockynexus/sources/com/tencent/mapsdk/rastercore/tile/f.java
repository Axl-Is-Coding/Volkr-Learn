package com.tencent.mapsdk.rastercore.tile;

import android.os.Handler;
import cn.qqtheme.framework.widget.WheelView;
import com.tencent.mapsdk.raster.model.TileOverlayOptions;
import com.tencent.mapsdk.rastercore.tile.MapTile;

/* JADX INFO: loaded from: classes5.dex */
public final class f {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private com.tencent.mapsdk.rastercore.e.a.f f19671b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private com.tencent.mapsdk.rastercore.d.f f19672c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private a f19674e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private boolean f19670a = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private Handler f19673d = new Handler();

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private float f19675f = WheelView.DividerConfig.FILL;

    class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f19676a = true;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int f19677b = 60000;

        public a(int i) {
        }

        public final void a(boolean z) {
            this.f19676a = false;
        }

        @Override // java.lang.Runnable
        public final void run() {
            f.this.f19672c.a(false, false);
            if (this.f19676a) {
                f.this.f19673d.postDelayed(this, this.f19677b);
            }
        }
    }

    public f(com.tencent.mapsdk.rastercore.d.f fVar) {
        this.f19672c = fVar;
    }

    public final void a(boolean z) {
        if (z && this.f19670a && this.f19671b != null) {
            return;
        }
        if (z) {
            TileOverlayOptions tileOverlayOptions = new TileOverlayOptions();
            tileOverlayOptions.tileProvider(com.tencent.mapsdk.rastercore.tile.b.b.a(this.f19672c, MapTile.MapSource.TRAFFIC)).diskCacheEnabled(false).visible(true).zIndex(WheelView.DividerConfig.FILL);
            this.f19671b = this.f19672c.g().a(tileOverlayOptions);
            this.f19674e = new a(60000);
            this.f19673d.post(this.f19674e);
        } else {
            com.tencent.mapsdk.rastercore.e.a.f fVar = this.f19671b;
            if (fVar == null) {
                return;
            }
            fVar.b();
            this.f19671b = null;
            this.f19674e.a(false);
            this.f19673d.removeCallbacks(this.f19674e);
            this.f19674e = null;
        }
        this.f19670a = z;
    }

    public final boolean a() {
        return this.f19670a;
    }
}
