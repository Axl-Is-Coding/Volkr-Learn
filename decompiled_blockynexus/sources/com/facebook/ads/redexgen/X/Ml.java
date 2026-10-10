package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class Ml implements View.OnClickListener {
    public final /* synthetic */ C1771Md A00;
    public final /* synthetic */ XR A01;

    public Ml(XR xr, C1771Md c1771Md) {
        this.A01 = xr;
        this.A00 = c1771Md;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A01();
            this.A01.A0A.A83();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
