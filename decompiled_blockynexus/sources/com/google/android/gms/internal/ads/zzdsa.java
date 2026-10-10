package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdsa<O> {
    private final E zzhjx;
    private final String zzhjy;
    private final List<zzdzc<?>> zzhkc;
    final /* synthetic */ zzdru zzhkd;
    private final zzdzc<?> zzhkg;
    private final zzdzc<O> zzhkh;

    private zzdsa(zzdru zzdruVar, E e2, String str, zzdzc<?> zzdzcVar, List<zzdzc<?>> list, zzdzc<O> zzdzcVar2) {
        this.zzhkd = zzdruVar;
        this.zzhjx = e2;
        this.zzhjy = str;
        this.zzhkg = zzdzcVar;
        this.zzhkc = list;
        this.zzhkh = zzdzcVar2;
    }

    public final <O2> zzdsa<O2> zza(zzdya<O, O2> zzdyaVar) {
        return zza(zzdyaVar, this.zzhkd.zzgcz);
    }

    public final zzdrr<E, O> zzavs() {
        E e2 = this.zzhjx;
        String strZzv = this.zzhjy;
        if (strZzv == null) {
            strZzv = this.zzhkd.zzv(e2);
        }
        final zzdrr<E, O> zzdrrVar = new zzdrr<>(e2, strZzv, this.zzhkh);
        this.zzhkd.zzhkb.zza(zzdrrVar);
        this.zzhkg.addListener(new Runnable(this, zzdrrVar) { // from class: com.google.android.gms.internal.ads.zzdse
            private final zzdsa zzhkk;
            private final zzdrr zzhkl;

            {
                this.zzhkk = this;
                this.zzhkl = zzdrrVar;
            }

            @Override // java.lang.Runnable
            public final void run() {
                zzdsa zzdsaVar = this.zzhkk;
                zzdsaVar.zzhkd.zzhkb.zzb(this.zzhkl);
            }
        }, zzbbz.zzeeu);
        zzdyq.zza(zzdrrVar, new zzdsd(this, zzdrrVar), zzbbz.zzeeu);
        return zzdrrVar;
    }

    public final <O2> zzdsa<O2> zzb(final zzdrp<O, O2> zzdrpVar) {
        return zza(new zzdya(zzdrpVar) { // from class: com.google.android.gms.internal.ads.zzdrz
            private final zzdrp zzhkf;

            {
                this.zzhkf = zzdrpVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return zzdyq.zzaf(this.zzhkf.apply(obj));
            }
        });
    }

    public final <O2> zzdsa<O2> zze(final zzdzc<O2> zzdzcVar) {
        return zza(new zzdya(zzdzcVar) { // from class: com.google.android.gms.internal.ads.zzdsc
            private final zzdzc zzgdq;

            {
                this.zzgdq = zzdzcVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return this.zzgdq;
            }
        }, zzbbz.zzeeu);
    }

    public final zzdsa<O> zzgx(String str) {
        return new zzdsa<>(this.zzhkd, this.zzhjx, str, this.zzhkg, this.zzhkc, this.zzhkh);
    }

    public final zzdsa<O> zzw(E e2) {
        return this.zzhkd.zza((Object) e2, (zzdzc) zzavs());
    }

    private final <O2> zzdsa<O2> zza(zzdya<O, O2> zzdyaVar, Executor executor) {
        return new zzdsa<>(this.zzhkd, this.zzhjx, this.zzhjy, this.zzhkg, this.zzhkc, zzdyq.zzb(this.zzhkh, zzdyaVar, executor));
    }

    public final <T extends Throwable> zzdsa<O> zza(Class<T> cls, final zzdrp<T, O> zzdrpVar) {
        return zza(cls, new zzdya(zzdrpVar) { // from class: com.google.android.gms.internal.ads.zzdsb
            private final zzdrp zzhkf;

            {
                this.zzhkf = zzdrpVar;
            }

            @Override // com.google.android.gms.internal.ads.zzdya
            public final zzdzc zzf(Object obj) {
                return zzdyq.zzaf(this.zzhkf.apply((Throwable) obj));
            }
        });
    }

    public final <T extends Throwable> zzdsa<O> zza(Class<T> cls, zzdya<T, O> zzdyaVar) {
        zzdru zzdruVar = this.zzhkd;
        return new zzdsa<>(zzdruVar, this.zzhjx, this.zzhjy, this.zzhkg, this.zzhkc, zzdyq.zzb(this.zzhkh, cls, zzdyaVar, zzdruVar.zzgcz));
    }

    public final zzdsa<O> zza(long j, TimeUnit timeUnit) {
        zzdru zzdruVar = this.zzhkd;
        return new zzdsa<>(zzdruVar, this.zzhjx, this.zzhjy, this.zzhkg, this.zzhkc, zzdyq.zza(this.zzhkh, j, timeUnit, zzdruVar.zzfoz));
    }
}
