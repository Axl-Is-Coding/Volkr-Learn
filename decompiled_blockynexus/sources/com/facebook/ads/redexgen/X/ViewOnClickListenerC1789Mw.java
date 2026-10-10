package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mw, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1789Mw implements View.OnClickListener {
    public final /* synthetic */ XO A00;

    public ViewOnClickListenerC1789Mw(XO xo) {
        this.A00 = xo;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A0A.A7K();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
