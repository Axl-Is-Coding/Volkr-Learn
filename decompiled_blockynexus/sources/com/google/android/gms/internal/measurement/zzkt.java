package com.google.android.gms.internal.measurement;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzkt<T, B> {
    zzkt() {
    }

    abstract B zza();

    abstract T zza(B b2);

    abstract void zza(B b2, int i, int i2);

    abstract void zza(B b2, int i, long j);

    abstract void zza(B b2, int i, zzgp zzgpVar);

    abstract void zza(B b2, int i, T t);

    abstract void zza(T t, zzlm zzlmVar) throws IOException;

    abstract void zza(Object obj, T t);

    abstract boolean zza(zzjy zzjyVar);

    final boolean zza(B b2, zzjy zzjyVar) throws IOException {
        int iZzb = zzjyVar.zzb();
        int i = iZzb >>> 3;
        int i2 = iZzb & 7;
        if (i2 == 0) {
            zza(b2, i, zzjyVar.zzg());
            return true;
        }
        if (i2 == 1) {
            zzb(b2, i, zzjyVar.zzi());
            return true;
        }
        if (i2 == 2) {
            zza((Object) b2, i, zzjyVar.zzn());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzij.zzf();
            }
            zza((Object) b2, i, zzjyVar.zzj());
            return true;
        }
        B bZza = zza();
        int i3 = 4 | (i << 3);
        while (zzjyVar.zza() != Integer.MAX_VALUE && zza((Object) bZza, zzjyVar)) {
        }
        if (i3 != zzjyVar.zzb()) {
            throw zzij.zze();
        }
        zza(b2, i, zza(bZza));
        return true;
    }

    abstract T zzb(Object obj);

    abstract void zzb(B b2, int i, long j);

    abstract void zzb(T t, zzlm zzlmVar) throws IOException;

    abstract void zzb(Object obj, B b2);

    abstract B zzc(Object obj);

    abstract T zzc(T t, T t2);

    abstract void zzd(Object obj);

    abstract int zze(T t);

    abstract int zzf(T t);
}
