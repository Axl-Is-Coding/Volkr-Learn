package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzchf implements zzdvu {
    static final zzdvu zzdwz = new zzchf();

    private zzchf() {
    }

    @Override // com.google.android.gms.internal.ads.zzdvu
    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzchh zzchhVar : (List) obj) {
            if (zzchhVar != null) {
                arrayList.add(zzchhVar);
            }
        }
        return arrayList;
    }
}
