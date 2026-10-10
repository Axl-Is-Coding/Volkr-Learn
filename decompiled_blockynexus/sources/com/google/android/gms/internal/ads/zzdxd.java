package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdxd<K> extends zzdws<K> {
    private final transient zzdwp<K> zzhqo;
    private final transient zzdwt<K, ?> zzhrd;

    zzdxd(zzdwt<K, ?> zzdwtVar, zzdwp<K> zzdwpVar) {
        this.zzhrd = zzdwtVar;
        this.zzhqo = zzdwpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdwk, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        return this.zzhrd.get(obj) != null;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.zzhrd.size();
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    final int zza(Object[] objArr, int i) {
        return zzaxm().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzdws, com.google.android.gms.internal.ads.zzdwk, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzaxi */
    public final zzdxg<K> iterator() {
        return (zzdxg) zzaxm().iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdws, com.google.android.gms.internal.ads.zzdwk
    public final zzdwp<K> zzaxm() {
        return this.zzhqo;
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    final boolean zzaxn() {
        return true;
    }
}
