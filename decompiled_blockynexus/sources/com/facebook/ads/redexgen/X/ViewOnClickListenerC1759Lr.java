package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.text.TextUtils;
import android.view.View;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Lr, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class ViewOnClickListenerC1759Lr implements View.OnClickListener {
    public final /* synthetic */ C1P A00;
    public final /* synthetic */ JC A01;
    public final /* synthetic */ C1760Ls A02;
    public final /* synthetic */ InterfaceC1767Lz A03;
    public final /* synthetic */ String A04;

    public ViewOnClickListenerC1759Lr(C1760Ls c1760Ls, JC jc, InterfaceC1767Lz interfaceC1767Lz, String str, C1P c1p) {
        this.A02 = c1760Ls;
        this.A01 = jc;
        this.A03 = interfaceC1767Lz;
        this.A04 = str;
        this.A00 = c1p;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            this.A01.A03(JB.A0A, null);
            if (AnonymousClass22.A0Q(this.A02.A02.A00(), true)) {
                this.A03.A81(this.A04, this.A00);
            } else if (!TextUtils.isEmpty(this.A00.A00())) {
                C1730Ko.A09(new C1730Ko(), this.A02.A02, Uri.parse(this.A00.A00()), this.A04);
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
