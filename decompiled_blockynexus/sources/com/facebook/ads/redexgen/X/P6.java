package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class P6 implements View.OnClickListener {
    public final /* synthetic */ AnonymousClass71 A00;

    public P6(AnonymousClass71 anonymousClass71) {
        this.A00 = anonymousClass71;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            View v = this.A00.getVideoView();
            if (v != null) {
                if (this.A00.A02 != null) {
                    this.A00.A02.A03(JB.A0l, null);
                }
                this.A00.A01.A0A().A2x();
                int i = P7.A00[this.A00.getVideoView().getState().ordinal()];
                if (i == 1 || i == 2 || i == 3 || i == 4) {
                    this.A00.getVideoView().A0Y(EnumC1834Op.A05, 12);
                } else if (i == 5) {
                    this.A00.getVideoView().A0b(true, 8);
                }
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
