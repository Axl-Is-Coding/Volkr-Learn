package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class N1 implements View.OnClickListener {
    public final /* synthetic */ N4 A00;

    public N1(N4 n4) {
        this.A00 = n4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (!this.A00.A08.canGoForward()) {
                return;
            }
            this.A00.A08.goForward();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
