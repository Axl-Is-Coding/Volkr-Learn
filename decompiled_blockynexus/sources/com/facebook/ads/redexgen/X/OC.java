package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class OC {

    @Nullable
    public String A02;

    @Nullable
    public String A03;
    public final C1F A04;
    public final C1P A05;
    public final C2026Wb A06;
    public C1G A01 = C1G.A01(null);
    public int A00 = 1000;

    public OC(C2026Wb c2026Wb, C1F c1f, C1P c1p) {
        this.A06 = c2026Wb;
        this.A04 = c1f;
        this.A05 = c1p;
    }

    public final OC A07(int i) {
        this.A00 = i;
        return this;
    }

    public final OC A08(C1G c1g) {
        this.A01 = c1g;
        return this;
    }

    public final OC A09(String str) {
        this.A02 = str;
        return this;
    }

    public final OC A0A(String str) {
        this.A03 = str;
        return this;
    }

    public final OE A0B() {
        return new OE(this, null);
    }
}
