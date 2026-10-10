package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class MD implements View.OnClickListener {
    public final /* synthetic */ M8 A00;
    public final /* synthetic */ C2071Xu A01;

    public MD(C2071Xu c2071Xu, M8 m8) {
        this.A01 = c2071Xu;
        this.A00 = m8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            LX.A0M(this.A00);
            LX.A0O(this.A01.A0N);
            LX.A0O(this.A01.A04);
            this.A01.A0L();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
