package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdxa<K, V> extends zzdwp<Map.Entry<K, V>> {
    private final /* synthetic */ zzdxb zzhrc;

    zzdxa(zzdxb zzdxbVar) {
        this.zzhrc = zzdxbVar;
    }

    @Override // java.util.List
    public final /* synthetic */ Object get(int i) {
        zzdwd.zzs(i, this.zzhrc.size);
        Object[] objArr = this.zzhrc.zzhqz;
        int i2 = i * 2;
        zzdxb zzdxbVar = this.zzhrc;
        Object obj = objArr[i2];
        Object[] objArr2 = zzdxbVar.zzhqz;
        zzdxb zzdxbVar2 = this.zzhrc;
        return new AbstractMap.SimpleImmutableEntry(obj, objArr2[i2 + 1]);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzhrc.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    public final boolean zzaxn() {
        return true;
    }
}
