package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mi, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1776Mi implements View.OnClickListener {
    public final /* synthetic */ XR A00;

    public ViewOnClickListenerC1776Mi(XR xr) {
        this.A00 = xr;
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
