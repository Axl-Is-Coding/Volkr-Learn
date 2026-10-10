package com.facebook.ads.redexgen.X;

import java.util.Set;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Pn, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1858Pn {
    public C1862Pr A00;
    public Set<String> A01;
    public Set<String> A02;
    public boolean A03;
    public boolean A04 = true;

    public final C1858Pn A00(C1862Pr c1862Pr) {
        this.A00 = c1862Pr;
        return this;
    }

    public final C1858Pn A01(Set<String> pinnedCertificates) {
        this.A01 = pinnedCertificates;
        return this;
    }

    public final C1858Pn A02(Set<String> pinnedPublicKeys) {
        this.A02 = pinnedPublicKeys;
        return this;
    }

    public final C1858Pn A03(boolean z) {
        this.A04 = z;
        return this;
    }

    public final C1858Pn A04(boolean z) {
        this.A03 = z;
        return this;
    }

    public final C1859Po A05() {
        return new C1859Po(this.A00, this.A04, this.A02, this.A01, this.A03);
    }
}
