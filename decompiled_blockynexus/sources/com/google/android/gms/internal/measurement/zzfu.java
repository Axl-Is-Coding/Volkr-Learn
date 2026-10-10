package com.google.android.gms.internal.measurement;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfu<E> extends zzfg<E> {
    private final transient E zza;
    private transient int zzb;

    zzfu(E e2) {
        zzeb.zza(e2);
        this.zza = e2;
    }

    @Override // com.google.android.gms.internal.measurement.zzey, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zza.equals(obj);
    }

    @Override // com.google.android.gms.internal.measurement.zzfg, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.zzb;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.zza.hashCode();
        this.zzb = iHashCode;
        return iHashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String string = this.zza.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 2);
        sb.append('[');
        sb.append(string);
        sb.append(']');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.measurement.zzfg, com.google.android.gms.internal.measurement.zzey, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zza */
    public final zzfx<E> iterator() {
        return new zzfl(this.zza);
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    final boolean zzf() {
        return false;
    }

    @Override // com.google.android.gms.internal.measurement.zzfg
    final boolean zzg() {
        return this.zzb != 0;
    }

    @Override // com.google.android.gms.internal.measurement.zzfg
    final zzfb<E> zzh() {
        return zzfb.zza(this.zza);
    }

    zzfu(E e2, int i) {
        this.zza = e2;
        this.zzb = i;
    }

    @Override // com.google.android.gms.internal.measurement.zzey
    final int zza(Object[] objArr, int i) {
        objArr[i] = this.zza;
        return i + 1;
    }
}
