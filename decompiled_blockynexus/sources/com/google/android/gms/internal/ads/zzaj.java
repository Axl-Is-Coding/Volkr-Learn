package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaj<T> {
    public final T result;
    public final zzn zzbs;
    public final zzao zzbt;
    public boolean zzbu;

    private zzaj(T t, zzn zznVar) {
        this.zzbu = false;
        this.result = t;
        this.zzbs = zznVar;
        this.zzbt = null;
    }

    public static <T> zzaj<T> zza(T t, zzn zznVar) {
        return new zzaj<>(t, zznVar);
    }

    public static <T> zzaj<T> zzd(zzao zzaoVar) {
        return new zzaj<>(zzaoVar);
    }

    public final boolean isSuccess() {
        return this.zzbt == null;
    }

    private zzaj(zzao zzaoVar) {
        this.zzbu = false;
        this.result = null;
        this.zzbs = null;
        this.zzbt = zzaoVar;
    }
}
