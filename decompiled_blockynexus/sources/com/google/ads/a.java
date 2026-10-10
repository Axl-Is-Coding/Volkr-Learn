package com.google.ads;

import com.google.android.gms.ads.AdSize;
import com.just.agentweb.WebIndicator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f12536a = new a(-1, -2, "mb");

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a f12537b = new a(320, 50, "mb");

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a f12538c = new a(300, 250, "as");

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a f12539d = new a(468, 60, "as");

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a f12540e = new a(728, 90, "as");

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a f12541f = new a(160, WebIndicator.DO_END_ANIMATION_DURATION, "as");
    private final AdSize g;

    public a(AdSize adSize) {
        this.g = adSize;
    }

    public final int a() {
        return this.g.getHeight();
    }

    public final int b() {
        return this.g.getWidth();
    }

    public final boolean equals(Object obj) {
        if (obj instanceof a) {
            return this.g.equals(((a) obj).g);
        }
        return false;
    }

    public final int hashCode() {
        return this.g.hashCode();
    }

    public final String toString() {
        return this.g.toString();
    }

    private a(int i, int i2, String str) {
        this(new AdSize(i, i2));
    }
}
