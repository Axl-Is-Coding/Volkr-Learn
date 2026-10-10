package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdxf<E> extends zzdws<E> {
    static final zzdxf<Object> zzhrf = new zzdxf<>(new Object[0], 0, null, 0, 0);
    private final transient int mask;
    private final transient int size;
    private final transient int zzahv;
    private final transient Object[] zzhrg;
    private final transient Object[] zzhrh;

    zzdxf(Object[] objArr, int i, Object[] objArr2, int i2, int i3) {
        this.zzhrg = objArr;
        this.zzhrh = objArr2;
        this.mask = i2;
        this.zzahv = i;
        this.size = i3;
    }

    @Override // com.google.android.gms.internal.ads.zzdwk, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        Object[] objArr = this.zzhrh;
        if (obj == null || objArr == null) {
            return false;
        }
        int iZzel = zzdwl.zzel(obj == null ? 0 : obj.hashCode());
        while (true) {
            int i = iZzel & this.mask;
            Object obj2 = objArr[i];
            if (obj2 == null) {
                return false;
            }
            if (obj2.equals(obj)) {
                return true;
            }
            iZzel = i + 1;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzdws, java.util.Collection, java.util.Set
    public final int hashCode() {
        return this.zzahv;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzhrg, 0, objArr, i, this.size);
        return i + this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdws, com.google.android.gms.internal.ads.zzdwk, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzaxi */
    public final zzdxg<E> iterator() {
        return (zzdxg) zzaxm().iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    final Object[] zzaxj() {
        return this.zzhrg;
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    final int zzaxk() {
        return 0;
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    final int zzaxl() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    final boolean zzaxn() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdws
    final boolean zzaxp() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdws
    final zzdwp<E> zzaxq() {
        return zzdwp.zzb(this.zzhrg, this.size);
    }
}
