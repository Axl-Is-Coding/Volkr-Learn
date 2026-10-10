package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzemx<T, B> {
    zzemx() {
    }

    abstract void zza(B b2, int i, long j);

    abstract void zza(B b2, int i, zzeip zzeipVar);

    abstract void zza(B b2, int i, T t);

    abstract void zza(T t, zzenu zzenuVar) throws IOException;

    abstract boolean zza(zzelz zzelzVar);

    final boolean zza(B b2, zzelz zzelzVar) throws IOException {
        int tag = zzelzVar.getTag();
        int i = tag >>> 3;
        int i2 = tag & 7;
        if (i2 == 0) {
            zza(b2, i, zzelzVar.zzber());
            return true;
        }
        if (i2 == 1) {
            zzb(b2, i, zzelzVar.zzbet());
            return true;
        }
        if (i2 == 2) {
            zza((Object) b2, i, zzelzVar.zzbex());
            return true;
        }
        if (i2 != 3) {
            if (i2 == 4) {
                return false;
            }
            if (i2 != 5) {
                throw zzekj.zzbhc();
            }
            zzc(b2, i, zzelzVar.zzbeu());
            return true;
        }
        B bZzbiu = zzbiu();
        int i3 = 4 | (i << 3);
        while (zzelzVar.zzbfn() != Integer.MAX_VALUE && zza(bZzbiu, zzelzVar)) {
        }
        if (i3 != zzelzVar.getTag()) {
            throw zzekj.zzbhb();
        }
        zza(b2, i, zzar(bZzbiu));
        return true;
    }

    abstract void zzaj(Object obj);

    abstract T zzar(B b2);

    abstract int zzat(T t);

    abstract T zzax(Object obj);

    abstract B zzay(Object obj);

    abstract int zzaz(T t);

    abstract void zzb(B b2, int i, long j);

    abstract B zzbiu();

    abstract void zzc(B b2, int i, int i2);

    abstract void zzc(T t, zzenu zzenuVar) throws IOException;

    abstract void zzi(Object obj, T t);

    abstract void zzj(Object obj, B b2);

    abstract T zzk(T t, T t2);
}
