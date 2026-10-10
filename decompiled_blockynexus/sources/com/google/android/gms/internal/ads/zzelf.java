package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzelf implements zzelg {
    zzelf() {
    }

    @Override // com.google.android.gms.internal.ads.zzelg
    public final Map<?, ?> zzan(Object obj) {
        return (zzeld) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzelg
    public final zzele<?, ?> zzao(Object obj) {
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.zzelg
    public final Map<?, ?> zzap(Object obj) {
        return (zzeld) obj;
    }

    @Override // com.google.android.gms.internal.ads.zzelg
    public final boolean zzaq(Object obj) {
        return !((zzeld) obj).isMutable();
    }

    @Override // com.google.android.gms.internal.ads.zzelg
    public final Object zzar(Object obj) {
        ((zzeld) obj).zzbec();
        return obj;
    }

    @Override // com.google.android.gms.internal.ads.zzelg
    public final Object zzas(Object obj) {
        return zzeld.zzbhp().zzbhq();
    }

    @Override // com.google.android.gms.internal.ads.zzelg
    public final int zzb(int i, Object obj, Object obj2) {
        zzeld zzeldVar = (zzeld) obj;
        if (zzeldVar.isEmpty()) {
            return 0;
        }
        Iterator it = zzeldVar.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }

    @Override // com.google.android.gms.internal.ads.zzelg
    public final Object zzf(Object obj, Object obj2) {
        zzeld zzeldVarZzbhq = (zzeld) obj;
        zzeld zzeldVar = (zzeld) obj2;
        if (!zzeldVar.isEmpty()) {
            if (!zzeldVarZzbhq.isMutable()) {
                zzeldVarZzbhq = zzeldVarZzbhq.zzbhq();
            }
            zzeldVarZzbhq.zza(zzeldVar);
        }
        return zzeldVarZzbhq;
    }
}
