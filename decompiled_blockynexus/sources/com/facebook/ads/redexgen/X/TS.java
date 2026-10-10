package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import java.util.HashMap;
import java.util.Map;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class TS extends C6L implements C6G {
    public AnonymousClass65 A00;
    public final C13815p A01;
    public final Map<Integer, C6V> A02;

    @SuppressLint({"UseSparseArrays"})
    public TS(Context context, C13815p c13815p) {
        super(context, c13815p);
        this.A02 = new HashMap();
        this.A01 = c13815p;
    }

    public final void A03(C6V c6v) {
        this.A02.put(Integer.valueOf(c6v.A00()), c6v);
    }

    public final void A04(C6Z c6z, Context context) {
        this.A00 = AnonymousClass65.A00(context, this.A01);
        this.A00.A05(this.A02, c6z);
    }

    @Override // com.facebook.ads.redexgen.X.C6G
    public final void ABr() {
        AnonymousClass65 anonymousClass65 = this.A00;
        if (anonymousClass65 != null) {
            anonymousClass65.A04();
        }
    }
}
