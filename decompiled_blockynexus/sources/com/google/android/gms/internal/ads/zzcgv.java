package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzcgv implements zzdvu {
    static final zzdvu zzdwz = new zzcgv();

    private zzcgv() {
    }

    @Override // com.google.android.gms.internal.ads.zzdvu
    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzadq zzadqVar : (List) obj) {
            if (zzadqVar != null) {
                arrayList.add(zzadqVar);
            }
        }
        return arrayList;
    }
}
