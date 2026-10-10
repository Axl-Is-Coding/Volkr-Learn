package c.t.m.g;

import android.location.Location;
import android.os.Bundle;
import com.umeng.analytics.pro.au;

/* JADX INFO: renamed from: c.t.m.g.lb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: TL */
/* JADX INFO: loaded from: classes.dex */
public final class C0444lb {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Location f3290a;

    static {
        new Bundle();
        f3290a = new Location("EMPTY");
    }

    public static String a(int i, int i2) {
        StringBuilder sb = new StringBuilder();
        boolean zD = Ha.a().d("https");
        StringBuilder sb2 = new StringBuilder("http");
        sb2.append(zD ? au.ax : "");
        sb2.append("://lbs.map.qq.com/loc");
        sb.append(sb2.toString());
        sb.append("?");
        sb.append("c=1");
        sb.append("&mars=");
        sb.append(i);
        sb.append("&obs=");
        sb.append(i2);
        return sb.toString();
    }
}
