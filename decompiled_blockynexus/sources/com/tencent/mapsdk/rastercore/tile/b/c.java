package com.tencent.mapsdk.rastercore.tile.b;

import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes5.dex */
public final class c extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String[] f19657a;

    public c(int i) {
        super(i);
        this.f19657a = new String[]{"https://p0.map.gtimg.com/sateTiles", "https://p1.map.gtimg.com/sateTiles", "https://p2.map.gtimg.com/sateTiles", "https://p3.map.gtimg.com/sateTiles"};
    }

    @Override // com.tencent.mapsdk.raster.model.UrlTileProvider
    public final URL getTileUrl(int i, int i2, int i3, Object... objArr) {
        double dPow = Math.pow(2.0d, i3);
        double d2 = i2;
        Double.isNaN(d2);
        int i4 = (int) ((dPow - d2) - 1.0d);
        String str = this.f19657a[a.a(i + i4, 4)] + '/' + i3 + '/' + (i >> 4) + '/' + (i4 >> 4) + '/' + i + '_' + i4 + ".jpg";
        try {
            return new URL(str);
        } catch (MalformedURLException unused) {
            new StringBuilder("Unable to new URL with ").append(str);
            return null;
        }
    }
}
