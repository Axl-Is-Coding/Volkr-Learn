package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.1Z, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1Z {
    public int A00;
    public int A01;
    public String A02;

    public C1Z(String str, int i, int i2) {
        this.A02 = str;
        this.A01 = Math.min(LX.A02.widthPixels, (int) (i * LX.A01));
        this.A00 = Math.min(LX.A02.heightPixels, (int) (i2 * LX.A01));
    }

    public final int A00() {
        return this.A00;
    }

    public final int A01() {
        return this.A01;
    }

    public final String A02() {
        return this.A02;
    }
}
