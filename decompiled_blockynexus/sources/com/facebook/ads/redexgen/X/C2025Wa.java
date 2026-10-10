package com.facebook.ads.redexgen.X;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Wa, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2025Wa implements PR {
    public final /* synthetic */ AnonymousClass72 A00;

    public C2025Wa(AnonymousClass72 anonymousClass72) {
        this.A00 = anonymousClass72;
    }

    @Override // com.facebook.ads.redexgen.X.PR
    public final void A9f() {
        try {
            this.A00.A00.put(true);
        } catch (InterruptedException unused) {
        }
    }

    @Override // com.facebook.ads.redexgen.X.PR
    public final void A9o() {
        try {
            this.A00.A00.put(false);
        } catch (InterruptedException unused) {
        }
    }
}
