package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzekv extends zzekt {
    private static final Class<?> zzilb = Collections.unmodifiableList(Collections.emptyList()).getClass();

    private zzekv() {
        super();
    }

    private static <E> List<E> zzc(Object obj, long j) {
        return (List) zzend.zzp(obj, j);
    }

    @Override // com.google.android.gms.internal.ads.zzekt
    final <L> List<L> zza(Object obj, long j) {
        return zza(obj, j, 10);
    }

    @Override // com.google.android.gms.internal.ads.zzekt
    final void zzb(Object obj, long j) {
        Object objUnmodifiableList;
        List list = (List) zzend.zzp(obj, j);
        if (list instanceof zzeku) {
            objUnmodifiableList = ((zzeku) list).zzbhk();
        } else {
            if (zzilb.isAssignableFrom(list.getClass())) {
                return;
            }
            if ((list instanceof zzelv) && (list instanceof zzekk)) {
                zzekk zzekkVar = (zzekk) list;
                if (zzekkVar.zzbeb()) {
                    zzekkVar.zzbec();
                    return;
                }
                return;
            }
            objUnmodifiableList = Collections.unmodifiableList(list);
        }
        zzend.zza(obj, j, objUnmodifiableList);
    }

    private static <L> List<L> zza(Object obj, long j, int i) {
        Object obj2;
        List<L> listZzc = zzc(obj, j);
        if (listZzc.isEmpty()) {
            List<L> zzekrVar = listZzc instanceof zzeku ? new zzekr(i) : ((listZzc instanceof zzelv) && (listZzc instanceof zzekk)) ? ((zzekk) listZzc).zzft(i) : new ArrayList<>(i);
            zzend.zza(obj, j, zzekrVar);
            return zzekrVar;
        }
        if (zzilb.isAssignableFrom(listZzc.getClass())) {
            ArrayList arrayList = new ArrayList(listZzc.size() + i);
            arrayList.addAll(listZzc);
            zzend.zza(obj, j, arrayList);
            obj2 = arrayList;
        } else {
            if (!(listZzc instanceof zzenc)) {
                if (!(listZzc instanceof zzelv) || !(listZzc instanceof zzekk)) {
                    return listZzc;
                }
                zzekk zzekkVar = (zzekk) listZzc;
                if (zzekkVar.zzbeb()) {
                    return listZzc;
                }
                zzekk zzekkVarZzft = zzekkVar.zzft(listZzc.size() + i);
                zzend.zza(obj, j, zzekkVarZzft);
                return zzekkVarZzft;
            }
            zzekr zzekrVar2 = new zzekr(listZzc.size() + i);
            zzekrVar2.addAll((zzenc) listZzc);
            zzend.zza(obj, j, zzekrVar2);
            obj2 = zzekrVar2;
        }
        return (List<L>) obj2;
    }

    @Override // com.google.android.gms.internal.ads.zzekt
    final <E> void zza(Object obj, Object obj2, long j) {
        List listZzc = zzc(obj2, j);
        List listZza = zza(obj, j, listZzc.size());
        int size = listZza.size();
        int size2 = listZzc.size();
        if (size > 0 && size2 > 0) {
            listZza.addAll(listZzc);
        }
        if (size > 0) {
            listZzc = listZza;
        }
        zzend.zza(obj, j, listZzc);
    }
}
