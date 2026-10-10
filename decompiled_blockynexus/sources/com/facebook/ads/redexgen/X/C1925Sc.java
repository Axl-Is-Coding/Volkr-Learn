package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sc, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1925Sc implements C4Z {
    public final /* synthetic */ C4E A00;

    public C1925Sc(C4E c4e) {
        this.A00 = c4e;
    }

    @Override // com.facebook.ads.redexgen.X.C4Z
    public final View A5k(int i) {
        return this.A00.A0u(i);
    }

    @Override // com.facebook.ads.redexgen.X.C4Z
    public final int A5m(View view) {
        return this.A00.A0k(view) + ((C4F) view.getLayoutParams()).bottomMargin;
    }

    @Override // com.facebook.ads.redexgen.X.C4Z
    public final int A5n(View view) {
        return this.A00.A0p(view) - ((C4F) view.getLayoutParams()).topMargin;
    }

    @Override // com.facebook.ads.redexgen.X.C4Z
    public final int A6l() {
        return this.A00.A0Y() - this.A00.A0e();
    }

    @Override // com.facebook.ads.redexgen.X.C4Z
    public final int A6m() {
        return this.A00.A0h();
    }
}
