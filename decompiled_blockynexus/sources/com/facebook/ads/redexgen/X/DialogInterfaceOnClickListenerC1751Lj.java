package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class DialogInterfaceOnClickListenerC1751Lj implements DialogInterface.OnClickListener {
    public final /* synthetic */ C2119Zt A00;

    public DialogInterfaceOnClickListenerC1751Lj(C2119Zt c2119Zt) {
        this.A00 = c2119Zt;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        dialogInterface.cancel();
    }
}
