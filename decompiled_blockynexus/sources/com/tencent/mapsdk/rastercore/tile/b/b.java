package com.tencent.mapsdk.rastercore.tile.b;

import com.tencent.mapsdk.raster.model.TileProvider;
import com.tencent.mapsdk.rastercore.tile.MapTile;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: loaded from: classes5.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static Map<MapTile.MapSource, TileProvider> f19655a = new WeakHashMap();

    /* JADX INFO: renamed from: com.tencent.mapsdk.rastercore.tile.b.b$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f19656a = new int[MapTile.MapSource.values().length];

        static {
            try {
                f19656a[MapTile.MapSource.TENCENT.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f19656a[MapTile.MapSource.WORLD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f19656a[MapTile.MapSource.SATELLITE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f19656a[MapTile.MapSource.TRAFFIC.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public static TileProvider a(com.tencent.mapsdk.rastercore.d.f fVar, MapTile.MapSource mapSource) {
        TileProvider dVar;
        int i = fVar.f().a() > 1 ? 2 : 1;
        TileProvider tileProvider = f19655a.get(mapSource);
        if (tileProvider != null) {
            return tileProvider;
        }
        int i2 = AnonymousClass1.f19656a[mapSource.ordinal()];
        if (i2 == 1) {
            dVar = new d(i);
        } else if (i2 == 2) {
            dVar = new f(i);
        } else if (i2 == 3) {
            dVar = new c(i);
        } else {
            if (i2 != 4) {
                return null;
            }
            dVar = new e(i);
        }
        f19655a.put(mapSource, dVar);
        return dVar;
    }
}
