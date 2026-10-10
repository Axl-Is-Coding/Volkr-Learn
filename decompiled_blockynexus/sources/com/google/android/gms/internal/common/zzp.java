package com.google.android.gms.internal.common;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzp<T> implements zzo<T> {
    private volatile zzo<T> zza;
    private volatile boolean zzb;
    private T zzc;

    zzp(zzo<T> zzoVar) {
        zzl.zza(zzoVar);
        this.zza = zzoVar;
    }

    public final String toString() {
        Object string = this.zza;
        if (string == null) {
            String strValueOf = String.valueOf(this.zzc);
            StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 25);
            sb.append("<supplier that returned ");
            sb.append(strValueOf);
            sb.append(">");
            string = sb.toString();
        }
        String strValueOf2 = String.valueOf(string);
        StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf2).length() + 19);
        sb2.append("Suppliers.memoize(");
        sb2.append(strValueOf2);
        sb2.append(")");
        return sb2.toString();
    }

    @Override // com.google.android.gms.internal.common.zzo
    public final T zza() {
        if (!this.zzb) {
            synchronized (this) {
                if (!this.zzb) {
                    T tZza = this.zza.zza();
                    this.zzc = tZza;
                    this.zzb = true;
                    this.zza = null;
                    return tZza;
                }
            }
        }
        return this.zzc;
    }
}
