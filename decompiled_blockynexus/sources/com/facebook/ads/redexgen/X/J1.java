package com.facebook.ads.redexgen.X;

import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class J1 {
    public double A00;
    public J6 A01;
    public J7 A02;
    public String A03;
    public String A04;
    public Map<String, String> A05;
    public boolean A06;

    public final J1 A00(double d2) {
        this.A00 = d2;
        return this;
    }

    public final J1 A01(J6 j6) {
        this.A01 = j6;
        return this;
    }

    public final J1 A02(J7 j7) {
        this.A02 = j7;
        return this;
    }

    public final J1 A03(String str) {
        this.A03 = str;
        return this;
    }

    public final J1 A04(String str) {
        this.A04 = str;
        return this;
    }

    public final J1 A05(Map<String, String> mData) {
        this.A05 = mData;
        return this;
    }

    public final J1 A06(boolean z) {
        this.A06 = z;
        return this;
    }

    public final J2 A07(AnonymousClass87 anonymousClass87) {
        return new J2(anonymousClass87, this.A04, this.A00, this.A03, this.A05, this.A01, this.A02, this.A06);
    }
}
