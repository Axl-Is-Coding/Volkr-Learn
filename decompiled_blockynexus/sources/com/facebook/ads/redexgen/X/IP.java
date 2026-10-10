package com.facebook.ads.redexgen.X;

import java.util.Comparator;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class IP implements Comparator<IQ> {
    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.util.Comparator
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compare(IQ iq, IQ iq2) {
        if (iq.A00 < iq2.A00) {
            return -1;
        }
        return iq2.A00 < iq.A00 ? 1 : 0;
    }
}
