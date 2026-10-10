package com.google.android.gms.internal.measurement;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zziu extends zzit {
    private zziu() {
        super();
    }

    private static <E> zzig<E> zzc(Object obj, long j) {
        return (zzig) zzkz.zzf(obj, j);
    }

    @Override // com.google.android.gms.internal.measurement.zzit
    final <L> List<L> zza(Object obj, long j) {
        zzig zzigVarZzc = zzc(obj, j);
        if (zzigVarZzc.zza()) {
            return zzigVarZzc;
        }
        int size = zzigVarZzc.size();
        zzig zzigVarZza = zzigVarZzc.zza(size == 0 ? 10 : size << 1);
        zzkz.zza(obj, j, zzigVarZza);
        return zzigVarZza;
    }

    @Override // com.google.android.gms.internal.measurement.zzit
    final void zzb(Object obj, long j) {
        zzc(obj, j).i_();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v1 */
    /* JADX WARN: Type inference failed for: r0v2, types: [java.util.List] */
    /* JADX WARN: Type inference failed for: r0v4 */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6 */
    /* JADX WARN: Type inference failed for: r0v7 */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r6v1, types: [com.google.android.gms.internal.measurement.zzig, java.util.Collection, java.util.List] */
    /* JADX WARN: Type inference failed for: r6v2, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r6v3 */
    @Override // com.google.android.gms.internal.measurement.zzit
    final <E> void zza(Object obj, Object obj2, long j) {
        zzig zzigVarZzc = zzc(obj, j);
        ?? Zzc = zzc(obj2, j);
        int size = zzigVarZzc.size();
        int size2 = Zzc.size();
        ?? r0 = zzigVarZzc;
        r0 = zzigVarZzc;
        if (size > 0 && size2 > 0) {
            boolean zZza = zzigVarZzc.zza();
            ?? Zza = zzigVarZzc;
            if (!zZza) {
                Zza = zzigVarZzc.zza(size2 + size);
            }
            Zza.addAll(Zzc);
            r0 = Zza;
        }
        if (size > 0) {
            Zzc = r0;
        }
        zzkz.zza(obj, j, (Object) Zzc);
    }
}
