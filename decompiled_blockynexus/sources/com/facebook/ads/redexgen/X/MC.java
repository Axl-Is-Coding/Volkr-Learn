package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class MC implements View.OnClickListener {
    public final /* synthetic */ M8 A00;
    public final /* synthetic */ C2071Xu A01;

    public MC(C2071Xu c2071Xu, M8 m8) {
        this.A01 = c2071Xu;
        this.A00 = m8;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            View v = this.A00;
            LX.A0M(v);
            View v2 = this.A01.A0N;
            LX.A0O(v2);
            View v3 = this.A01.A04;
            LX.A0O(v3);
            View v4 = this.A01.A09;
            if (v4 == null) {
                return;
            }
            this.A01.A09.A0Y(EnumC1834Op.A03, 15);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
