package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5T, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C5T {
    public final long A00;
    public final C5S A01;
    public final String A02;
    public final boolean A03;

    public C5T(String str, boolean z, C5S c5s) {
        this(str, z, c5s, System.currentTimeMillis());
    }

    public C5T(String str, boolean z, C5S c5s, long j) {
        this.A02 = str;
        this.A03 = z;
        this.A01 = c5s;
        this.A00 = j;
    }

    public static C5T A00() {
        return new C5T("", true, C5S.A06, -1L);
    }

    public final long A01() {
        return this.A00;
    }

    public final C5S A02() {
        return this.A01;
    }

    public final String A03() {
        return this.A02;
    }

    public final boolean A04() {
        return this.A03;
    }
}
