package com.facebook.ads.redexgen.X;

import java.util.Collections;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class DS {
    public final int A00;
    public final String A01;
    public final List<DR> A02;
    public final byte[] A03;

    public DS(int i, String str, List<DR> list, byte[] bArr) {
        List<DR> listUnmodifiableList;
        this.A00 = i;
        this.A01 = str;
        if (list == null) {
            listUnmodifiableList = Collections.emptyList();
        } else {
            listUnmodifiableList = Collections.unmodifiableList(list);
        }
        this.A02 = listUnmodifiableList;
        this.A03 = bArr;
    }
}
