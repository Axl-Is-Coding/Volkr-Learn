package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class MV implements View.OnClickListener {
    public final /* synthetic */ MY A00;

    public MV(MY my) {
        this.A00 = my;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (this.A00.A04) {
                this.A00.A03.A42();
            } else {
                this.A00.A03.A43();
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
