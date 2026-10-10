package com.facebook.ads.redexgen.X;

import com.facebook.ads.NativeAd;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class T5 implements InterfaceC14166z {
    public final List<RD> A00;
    public final /* synthetic */ T6 A01;

    public T5(T6 t6, List<RD> list) {
        this.A01 = t6;
        this.A00 = list;
    }

    private void A00() {
        this.A01.A00.A07(true);
        this.A01.A00.A04();
        this.A01.A00.A05(0);
        Iterator<RD> it = this.A00.iterator();
        while (it.hasNext()) {
            this.A01.A00.A06(new NativeAd(this.A01.A01, new C2213bT(this.A01.A01, it.next(), null, C2213bT.A0I(), this.A01.A00.A03())));
        }
        KK.A00(new T4(this));
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC14166z
    public final void A9P() {
        A00();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC14166z
    public final void A9W() {
        A00();
    }
}
