package com.facebook.ads.redexgen.X;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class SK implements C3M {
    public final /* synthetic */ EU A00;
    public final /* synthetic */ C3K A01;

    public SK(EU eu, C3K c3k) {
        this.A00 = eu;
        this.A01 = c3k;
    }

    @Override // com.facebook.ads.redexgen.X.C3M
    public final Object A4C(int i) {
        C3I c3iA00 = this.A01.A00(i);
        if (c3iA00 == null) {
            return null;
        }
        return c3iA00.A0N();
    }

    @Override // com.facebook.ads.redexgen.X.C3M
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

    @Override // com.facebook.ads.redexgen.X.C3M
    public final boolean ABu(int i, int i2, Bundle bundle) {
        return this.A01.A04(i, i2, bundle);
    }
}
