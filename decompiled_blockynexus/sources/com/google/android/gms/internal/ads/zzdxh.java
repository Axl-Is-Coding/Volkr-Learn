package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdxh<E> extends zzdws<E> {
    private final transient E zzhri;
    private transient int zzhrj;

    zzdxh(E e2) {
        zzdwd.checkNotNull(e2);
        this.zzhri = e2;
    }

    @Override // com.google.android.gms.internal.ads.zzdwk, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zzhri.equals(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzdws, java.util.Collection, java.util.Set
    public final int hashCode() {
        int i = this.zzhrj;
        if (i != 0) {
            return i;
        }
        int iHashCode = this.zzhri.hashCode();
        this.zzhrj = iHashCode;
        return iHashCode;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return 1;
    }

    @Override // java.util.AbstractCollection
    public final String toString() {
        String string = this.zzhri.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 2);
        sb.append('[');
        sb.append(string);
        sb.append(']');
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    final int zza(Object[] objArr, int i) {
        objArr[i] = this.zzhri;
        return i + 1;
    }

    @Override // com.google.android.gms.internal.ads.zzdws, com.google.android.gms.internal.ads.zzdwk, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzaxi */
    public final zzdxg<E> iterator() {
        return new zzdwu(this.zzhri);
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    final boolean zzaxn() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdws
    final boolean zzaxp() {
        return this.zzhrj != 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdws
    final zzdwp<E> zzaxq() {
        return zzdwp.zzac(this.zzhri);
    }

    zzdxh(E e2, int i) {
        this.zzhri = e2;
        this.zzhrj = i;
    }
}
