package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdyc<V> extends zzdyd<V, List<V>> {
    zzdyc(zzdwk<? extends zzdzc<? extends V>> zzdwkVar, boolean z) {
        super(zzdwkVar, true);
        zzaxy();
    }

    @Override // com.google.android.gms.internal.ads.zzdyd
    public final /* synthetic */ Object zzk(List list) {
        ArrayList arrayListZzep = zzdwx.zzep(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzdyf zzdyfVar = (zzdyf) it.next();
            arrayListZzep.add(zzdyfVar != null ? zzdyfVar.value : null);
        }
        return Collections.unmodifiableList(arrayListZzep);
    }
}
