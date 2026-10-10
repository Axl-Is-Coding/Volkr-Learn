package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ou, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C1839Ou implements O0 {
    public final /* synthetic */ C1838Ot A00;

    public C1839Ou(C1838Ot c1838Ot) {
        this.A00 = c1838Ot;
    }

    @Override // com.facebook.ads.redexgen.X.O0
    public final void ABd(View view) {
        if (this.A00.A07) {
            this.A00.A05 = false;
        }
    }

    @Override // com.facebook.ads.redexgen.X.O0
    public final void ABe(View view) {
        AbstractC1878Qh abstractC1878Qh = (AbstractC1878Qh) view;
        abstractC1878Qh.A0f();
        if (this.A00.A07) {
            this.A00.A05 = true;
        }
        if (this.A00.A0E.A0b() && ((Integer) abstractC1878Qh.getTag(-1593835536)).intValue() == 0) {
            this.A00.A0E.A0W();
        }
    }
}
