package com.google.android.gms.internal.ads;

import java.util.Comparator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeir implements Comparator<zzeip> {
    zzeir() {
    }

    @Override // java.util.Comparator
    public final /* synthetic */ int compare(zzeip zzeipVar, zzeip zzeipVar2) {
        zzeip zzeipVar3 = zzeipVar;
        zzeip zzeipVar4 = zzeipVar2;
        zzeiu zzeiuVar = (zzeiu) zzeipVar3.iterator();
        zzeiu zzeiuVar2 = (zzeiu) zzeipVar4.iterator();
        while (zzeiuVar.hasNext() && zzeiuVar2.hasNext()) {
            int iCompare = Integer.compare(zzeip.zzb(zzeiuVar.nextByte()), zzeip.zzb(zzeiuVar2.nextByte()));
            if (iCompare != 0) {
                return iCompare;
            }
        }
        return Integer.compare(zzeipVar3.size(), zzeipVar4.size());
    }
}
