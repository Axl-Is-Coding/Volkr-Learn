package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class SL implements C3P {
    public final /* synthetic */ EM A00;
    public final /* synthetic */ C3K A01;

    public SL(EM em, C3K c3k) {
        this.A00 = em;
        this.A01 = c3k;
    }

    @Override // com.facebook.ads.redexgen.X.C3P
    public final Object A4C(int i) {
        C3I c3iA00 = this.A01.A00(i);
        if (c3iA00 == null) {
            return null;
        }
        return c3iA00.A0N();
    }

    @Override // com.facebook.ads.redexgen.X.C3P
    public final List<Object> A5D(String str, int i) {
        List<C3I> listA03 = this.A01.A03(str, i);
        if (listA03 == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = listA03.size();
        for (int i2 = 0; i2 < size; i2++) {
            arrayList.add(listA03.get(i2).A0N());
        }
        return arrayList;
    }

    @Override // com.facebook.ads.redexgen.X.C3P
    public final Object A5E(int i) {
        C3I c3iA01 = this.A01.A01(i);
        if (c3iA01 == null) {
            return null;
        }
        return c3iA01.A0N();
    }

    @Override // com.facebook.ads.redexgen.X.C3P
    public final boolean ABu(int i, int i2, Bundle bundle) {
        return this.A01.A04(i, i2, bundle);
    }
}
