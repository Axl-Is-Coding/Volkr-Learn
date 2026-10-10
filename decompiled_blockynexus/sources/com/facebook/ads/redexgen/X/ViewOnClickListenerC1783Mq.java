package com.facebook.ads.redexgen.X;

import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Mq, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1783Mq implements View.OnClickListener {
    public final /* synthetic */ AnonymousClass25 A00;
    public final /* synthetic */ C1771Md A01;
    public final /* synthetic */ C1784Mr A02;

    public ViewOnClickListenerC1783Mq(C1784Mr c1784Mr, C1771Md c1771Md, AnonymousClass25 anonymousClass25) {
        this.A02 = c1784Mr;
        this.A01 = c1771Md;
        this.A00 = anonymousClass25;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.A01();
            this.A02.A02.AAd(this.A00);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
