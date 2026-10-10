package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class OP implements View.OnClickListener {
    public final /* synthetic */ OQ A00;

    public OP(OQ oq) {
        this.A00 = oq;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A04.performClick();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
