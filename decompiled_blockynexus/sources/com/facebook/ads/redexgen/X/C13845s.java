package com.facebook.ads.redexgen.X;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5s, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13845s {
    public final List<InterfaceC13835r> A00 = new ArrayList();

    public final void A00(InterfaceC13835r interfaceC13835r) {
        this.A00.add(interfaceC13835r);
    }

    public final void A01(C6Z c6z) {
        Iterator<InterfaceC13835r> it = this.A00.iterator();
        while (it.hasNext()) {
            it.next().ADx(c6z);
        }
    }
}
