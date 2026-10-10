package com.facebook.ads.redexgen.X;

import android.content.DialogInterface;
import android.widget.EditText;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class DialogInterfaceOnClickListenerC1752Lk implements DialogInterface.OnClickListener {
    public final /* synthetic */ EditText A00;
    public final /* synthetic */ C2119Zt A01;

    public DialogInterfaceOnClickListenerC1752Lk(C2119Zt c2119Zt, EditText editText) {
        this.A01 = c2119Zt;
        this.A00 = editText;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        this.A01.A02.execute(new C2120Zu(this, dialogInterface));
    }
}
