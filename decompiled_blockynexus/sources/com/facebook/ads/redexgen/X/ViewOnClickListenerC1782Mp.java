package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mp, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1782Mp implements View.OnClickListener {
    public final /* synthetic */ C1784Mr A00;

    public ViewOnClickListenerC1782Mp(C1784Mr c1784Mr) {
        this.A00 = c1784Mr;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A00.A02.A7K();
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
