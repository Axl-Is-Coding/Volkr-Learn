package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdcf implements zzdgx<zzdgu<Bundle>> {
    private final Set<String> zzgvm;

    zzdcf(Set<String> set) {
        this.zzgvm = set;
    }

    @Override // com.google.android.gms.internal.ads.zzdgx
    public final zzdzc<zzdgu<Bundle>> zzarj() {
        final ArrayList arrayList = new ArrayList();
        Iterator<String> it = this.zzgvm.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next());
        }
        return zzdyq.zzaf(new zzdgu(arrayList) { // from class: com.google.android.gms.internal.ads.zzdce
            private final ArrayList zzgvl;

            {
                this.zzgvl = arrayList;
            }

            @Override // com.google.android.gms.internal.ads.zzdgu
            public final void zzs(Object obj) {
                ((Bundle) obj).putStringArrayList("ad_types", this.zzgvl);
            }
        });
    }
}
