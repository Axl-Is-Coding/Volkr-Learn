package com.facebook.ads.redexgen.X;

import android.view.View;
import com.facebook.ads.internal.view.FullScreenAdToolbar;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class M3 implements View.OnClickListener {
    public final /* synthetic */ FullScreenAdToolbar A00;

    public M3(FullScreenAdToolbar fullScreenAdToolbar) {
        this.A00 = fullScreenAdToolbar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (this.A00.A00 != null && this.A00.A05.A03()) {
                this.A00.A00.A9S();
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
