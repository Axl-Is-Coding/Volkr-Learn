package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzea<T> extends zzdy<T> {
    private final T zza;

    zzea(T t) {
        this.zza = t;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof zzea) {
            return this.zza.equals(((zzea) obj).zza);
        }
        return false;
    }

    public final int hashCode() {
        return this.zza.hashCode() + 1502476572;
    }

    public final String toString() {
        String strValueOf = String.valueOf(this.zza);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 13);
        sb.append("Optional.of(");
        sb.append(strValueOf);
        sb.append(")");
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzdy
    public final boolean zza() {
        return true;
    }

    @Override // com.google.android.gms.internal.measurement.zzdy
    public final T zzb() {
        return this.zza;
    }
}
