package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class WX extends KT {
    public final /* synthetic */ InterfaceC14166z A00;
    public final /* synthetic */ AnonymousClass70 A01;
    public final /* synthetic */ AnonymousClass77 A02;
    public final /* synthetic */ ArrayList A03;
    public final /* synthetic */ ArrayList A04;

    public WX(AnonymousClass77 anonymousClass77, ArrayList arrayList, InterfaceC14166z interfaceC14166z, AnonymousClass70 anonymousClass70, ArrayList arrayList2) {
        this.A02 = anonymousClass77;
        this.A03 = arrayList;
        this.A00 = interfaceC14166z;
        this.A01 = anonymousClass70;
        this.A04 = arrayList2;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        AtomicBoolean atomicBooleanA0B = AnonymousClass77.A0B(this.A03);
        if (this.A02.A04 instanceof C2026Wb) {
            C2026Wb c2026Wb = (C2026Wb) this.A02.A04;
            if (atomicBooleanA0B.get()) {
                c2026Wb.A0A().A3w(LP.A01(this.A02.A00));
            } else {
                c2026Wb.A0A().A3v(LP.A01(this.A02.A00));
            }
        }
        this.A02.A02.post(new WW(this, atomicBooleanA0B));
        AnonymousClass77.A0B(this.A04);
    }
}
