package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class MN implements View.OnClickListener {
    public final /* synthetic */ C2055Xe A00;

    public MN(C2055Xe c2055Xe) {
        this.A00 = c2055Xe;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A05.A9u();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
