package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Sb, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1924Sb implements C4Z {
    public final /* synthetic */ C4E A00;

    public C1924Sb(C4E c4e) {
        this.A00 = c4e;
    }

    @Override // com.facebook.ads.redexgen.X.C4Z
    public final View A5k(int i) {
        return this.A00.A0u(i);
    }

    @Override // com.facebook.ads.redexgen.X.C4Z
    public final int A5m(View view) {
        return this.A00.A0o(view) + ((C4F) view.getLayoutParams()).rightMargin;
    }

    @Override // com.facebook.ads.redexgen.X.C4Z
    public final int A5n(View view) {
        return this.A00.A0l(view) - ((C4F) view.getLayoutParams()).leftMargin;
    }

    @Override // com.facebook.ads.redexgen.X.C4Z
    public final int A6l() {
        return this.A00.A0i() - this.A00.A0g();
    }

    @Override // com.facebook.ads.redexgen.X.C4Z
    public final int A6m() {
        return this.A00.A0f();
    }
}
