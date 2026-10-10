package com.tencent.mapsdk.rastercore.tile.b;

import java.net.MalformedURLException;
import java.net.URL;

/* JADX INFO: loaded from: classes5.dex */
public final class e extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String[] f19659a = {"https://rtt2.map.qq.com", "https://rtt2a.map.qq.com", "https://rtt2b.map.qq.com", "https://rtt2c.map.qq.com"};

    public e(int i) {
        super(i);
    }

    @Override // com.tencent.mapsdk.raster.model.UrlTileProvider
    public final URL getTileUrl(int i, int i2, int i3, Object... objArr) {
        if (i3 < 10) {
            return null;
        }
        String[] strArr = f19659a;
        String str = strArr[(i + i2) % strArr.length];
        double dPow = Math.pow(2.0d, i3);
        double d2 = i2;
        Double.isNaN(d2);
        String str2 = str + "/rtt/?z=" + i3 + "&x=" + i + "&y=" + ((int) ((dPow - d2) - 1.0d)) + "&ref=android2DSdk&timeKey=" + System.currentTimeMillis();
        try {
            return new URL(str2);
        } catch (MalformedURLException unused) {
            e.class.getSimpleName();
            StringBuilder sb = new StringBuilder("Can not convert ");
            sb.append(str2);
            sb.append(" to URL.");
            return null;
        }
    }
}
