package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class MA implements View.OnClickListener {
    public final /* synthetic */ Y5 A00;

    public MA(Y5 y5) {
        this.A00 = y5;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A0V(false);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
