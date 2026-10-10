package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeky extends zzekt {
    private zzeky() {
        super();
    }

    private static <E> zzekk<E> zzd(Object obj, long j) {
        return (zzekk) zzend.zzp(obj, j);
    }

    @Override // com.google.android.gms.internal.ads.zzekt
    final <L> List<L> zza(Object obj, long j) {
        zzekk zzekkVarZzd = zzd(obj, j);
        if (zzekkVarZzd.zzbeb()) {
            return zzekkVarZzd;
        }
        int size = zzekkVarZzd.size();
        zzekk zzekkVarZzft = zzekkVarZzd.zzft(size == 0 ? 10 : size << 1);
        zzend.zza(obj, j, zzekkVarZzft);
        return zzekkVarZzft;
    }

    @Override // com.google.android.gms.internal.ads.zzekt
    final void zzb(Object obj, long j) {
        zzd(obj, j).zzbec();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.google.android.gms.internal.ads.zzekk, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    @Override // com.google.android.gms.internal.ads.zzekt
    final <E> void zza(Object obj, Object obj2, long j) {
        zzekk zzekkVarZzd = zzd(obj, j);
        ?? Zzd = zzd(obj2, j);
        int size = zzekkVarZzd.size();
        int size2 = Zzd.size();
        ?? r0 = zzekkVarZzd;
        r0 = zzekkVarZzd;
        if (size > 0 && size2 > 0) {
            boolean zZzbeb = zzekkVarZzd.zzbeb();
            ?? Zzft = zzekkVarZzd;
            if (!zZzbeb) {
                Zzft = zzekkVarZzd.zzft(size2 + size);
            }
            Zzft.addAll(Zzd);
            r0 = Zzft;
        }
        if (size > 0) {
            Zzd = r0;
        }
        zzend.zza(obj, j, (Object) Zzd);
    }
}
