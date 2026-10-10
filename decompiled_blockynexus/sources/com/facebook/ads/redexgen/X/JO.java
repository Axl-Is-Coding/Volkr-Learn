package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class JO implements DialogInterface.OnClickListener {
    public final /* synthetic */ ViewOnClickListenerC2211bR A00;

    public JO(ViewOnClickListenerC2211bR viewOnClickListenerC2211bR) {
        this.A00 = viewOnClickListenerC2211bR;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        if (this.A00.A01.A0W == null) {
            return;
        }
        this.A00.A01.A0W.A0c(this.A00.A01());
    }
}
