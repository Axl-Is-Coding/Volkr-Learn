package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1764Lw implements View.OnClickListener {
    public final /* synthetic */ C2112Zm A00;

    public ViewOnClickListenerC1764Lw(C2112Zm c2112Zm) {
        this.A00 = c2112Zm;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (this.A00.A00 == null || !this.A00.A04.A03()) {
                return;
            }
            this.A00.A00.A9S();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
