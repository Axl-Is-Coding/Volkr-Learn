package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ly, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1766Ly implements View.OnClickListener {
    public final /* synthetic */ DialogC2117Zr A00;
    public final /* synthetic */ C2112Zm A01;
    public final /* synthetic */ MJ A02;

    public ViewOnClickListenerC1766Ly(C2112Zm c2112Zm, MJ mj, DialogC2117Zr dialogC2117Zr) {
        this.A01 = c2112Zm;
        this.A02 = mj;
        this.A00 = dialogC2117Zr;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A02.A95();
            this.A00.hide();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
