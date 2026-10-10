package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.protocol.AdPlacementType;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.0r, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C12560r {
    public static InterfaceC12510m A00;

    public final InterfaceC12510m A00(AdPlacementType adPlacementType) {
        InterfaceC12510m interfaceC12510m = A00;
        if (interfaceC12510m != null) {
            return interfaceC12510m;
        }
        int i = C12550q.A00[adPlacementType.ordinal()];
        if (i == 1) {
            return new RA();
        }
        if (i == 2) {
            return new RB();
        }
        if (i == 3) {
            return new RD();
        }
        if (i == 4) {
            return new C1586Ep();
        }
        if (i != 5) {
            return null;
        }
        return new C1584En();
    }
}
