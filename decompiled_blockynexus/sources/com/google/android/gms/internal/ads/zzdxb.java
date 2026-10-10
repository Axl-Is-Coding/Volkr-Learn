package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdxb<K, V> extends zzdws<Map.Entry<K, V>> {
    private final transient int size;
    private final transient Object[] zzhqz;
    private final transient zzdwt<K, V> zzhrd;
    private final transient int zzhre = 0;

    zzdxb(zzdwt<K, V> zzdwtVar, Object[] objArr, int i, int i2) {
        this.zzhrd = zzdwtVar;
        this.zzhqz = objArr;
        this.size = i2;
    }

    @Override // com.google.android.gms.internal.ads.zzdwk, java.util.AbstractCollection, java.util.Collection
    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zzhrd.get(key))) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.Set
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    final int zza(Object[] objArr, int i) {
        return zzaxm().zza(objArr, i);
    }

    @Override // com.google.android.gms.internal.ads.zzdws, com.google.android.gms.internal.ads.zzdwk, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    /* JADX INFO: renamed from: zzaxi */
    public final zzdxg<Map.Entry<K, V>> iterator() {
        return (zzdxg) zzaxm().iterator();
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    final boolean zzaxn() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdws
    final zzdwp<Map.Entry<K, V>> zzaxq() {
        return new zzdxa(this);
    }
}
