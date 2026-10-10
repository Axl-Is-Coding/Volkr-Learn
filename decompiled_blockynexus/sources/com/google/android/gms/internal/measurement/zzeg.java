package com.google.android.gms.internal.measurement;

import java.io.Serializable;
import java.util.Arrays;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeg<T> implements zzec<T>, Serializable {
    private final T zza;

    zzeg(T t) {
        this.zza = t;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzeg) {
            return zzdz.zza(this.zza, ((zzeg) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return Arrays.hashCode(new Object[]{this.zza});
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 22);
        sb.append("Suppliers.ofInstance(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzec
    public final T zza() {
        return this.zza;
    }
}
