package com.facebook.ads.redexgen.X;

import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2o, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13052o extends C1490Ag implements Comparable<C13052o> {
    public long A00;

    public C13052o() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.Comparable
    /* JADX INFO: renamed from: A00, reason: merged with bridge method [inline-methods] */
    public final int compareTo(@NonNull C13052o c13052o) {
        if (A04() != c13052o.A04()) {
            return A04() ? 1 : -1;
        }
        long j = ((C2067Xq) this).A00 - ((C2067Xq) c13052o).A00;
        if (j == 0) {
            j = this.A00 - c13052o.A00;
            if (j == 0) {
                return 0;
            }
        }
        return j > 0 ? 1 : -1;
    }
}
