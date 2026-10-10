package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Np, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1808Np implements View.OnClickListener {
    public final /* synthetic */ C9Q A00;

    public ViewOnClickListenerC1808Np(C9Q c9q) {
        this.A00 = c9q;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A07 = false;
            if (this.A00.A04 != null) {
                LX.A0O(this.A00.A04);
            }
            LX.A0Q(this.A00.A0A, 0);
            LX.A0Q(this.A00.A0B, 0);
            LX.A0Q(this.A00.getAdDetailsView(), 0);
            LX.A0M(this.A00.A08);
            this.A00.A0A.A0Y(EnumC1834Op.A03, 14);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
