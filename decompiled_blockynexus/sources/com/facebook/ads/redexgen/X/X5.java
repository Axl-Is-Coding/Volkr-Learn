package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class X5 implements C8A {
    public final /* synthetic */ AnonymousClass87 A00;
    public final /* synthetic */ XA A01;

    public X5(XA xa, AnonymousClass87 anonymousClass87) {
        this.A01 = xa;
        this.A00 = anonymousClass87;
    }

    @Override // com.facebook.ads.redexgen.X.C8A
    public final Map<String, String> A4S() {
        return C14568y.A01(this.A00);
    }

    @Override // com.facebook.ads.redexgen.X.C8A
    public final Map<String, String> A5U() {
        return C14408h.A02();
    }

    @Override // com.facebook.ads.redexgen.X.C8A
    @Nullable
    public final String A6Y() {
        return C14408h.A00();
    }

    @Override // com.facebook.ads.redexgen.X.C8A
    public final String A6Z() {
        return C5V.A00().A03();
    }
}
