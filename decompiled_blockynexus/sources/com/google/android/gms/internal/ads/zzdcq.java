package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final /* synthetic */ class zzdcq implements zzdvu {
    static final zzdvu zzdwz = new zzdcq();

    private zzdcq() {
    }

    @Override // com.google.android.gms.internal.ads.zzdvu
    public final Object apply(Object obj) {
        final ArrayList arrayList = (ArrayList) obj;
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzdgu(arrayList) { // from class: com.google.android.gms.internal.ads.zzdct
            private final ArrayList zzgvl;

            {
                this.zzgvl = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzdgu
            public final void zzs(Object obj2) {
                ((Bundle) obj2).putStringArrayList("android_permissions", this.zzgvl);
            }
        };
    }
}
