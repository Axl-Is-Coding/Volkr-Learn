package com.google.android.gms.internal.ads;

import cn.qqtheme.framework.util.ConvertUtils;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzdwt<K, V> implements Serializable, Map<K, V> {
    private static final Map.Entry<?, ?>[] zzhqq = new Map.Entry[0];
    private transient zzdws<Map.Entry<K, V>> zzhqr;
    private transient zzdws<K> zzhqs;
    private transient zzdwk<V> zzhqt;

    zzdwt() {
    }

    public static <K, V> zzdwt<K, V> zza(K k, V v, K k2, V v2, K k3, V v3, K k4, V v4, K k5, V v5) {
        zzdwj.zzb(k, v);
        zzdwj.zzb(k2, v2);
        zzdwj.zzb(k3, v3);
        zzdwj.zzb(k4, v4);
        zzdwj.zzb(k5, v5);
        return zzdwy.zzc(5, new Object[]{k, v, k2, v2, k3, v3, k4, v4, k5, v5});
    }

    public static <K, V> zzdwt<K, V> zzc(K k, V v) {
        zzdwj.zzb(k, v);
        return zzdwy.zzc(1, new Object[]{k, v});
    }

    @Override // java.util.Map
    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    @Override // java.util.Map
    public boolean containsValue(Object obj) {
        return ((zzdwk) values()).contains(obj);
    }

    @Override // java.util.Map
    public /* synthetic */ Set entrySet() {
        zzdws<Map.Entry<K, V>> zzdwsVar = this.zzhqr;
        if (zzdwsVar != null) {
            return zzdwsVar;
        }
        zzdws<Map.Entry<K, V>> zzdwsVarZzaxr = zzaxr();
        this.zzhqr = zzdwsVarZzaxr;
        return zzdwsVarZzaxr;
    }

    @Override // java.util.Map
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Map) {
            return entrySet().equals(((Map) obj).entrySet());
        }
        return false;
    }

    @Override // java.util.Map
    public abstract V get(Object obj);

    @Override // java.util.Map
    public final V getOrDefault(Object obj, V v) {
        V v2 = get(obj);
        return v2 != null ? v2 : v;
    }

    @Override // java.util.Map
    public int hashCode() {
        return zzdxe.zzg((zzdws) entrySet());
    }

    @Override // java.util.Map
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.Map
    public /* synthetic */ Set keySet() {
        zzdws<K> zzdwsVar = this.zzhqs;
        if (zzdwsVar != null) {
            return zzdwsVar;
        }
        zzdws<K> zzdwsVarZzaxs = zzaxs();
        this.zzhqs = zzdwsVarZzaxs;
        return zzdwsVarZzaxs;
    }

    @Override // java.util.Map
    @Deprecated
    public final V put(K k, V v) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.Map
    @Deprecated
    public final V remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public String toString() {
        int size = size();
        zzdwj.zzh(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(((long) size) << 3, ConvertUtils.GB));
        sb.append('{');
        boolean z = true;
        for (Map.Entry<K, V> entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            z = false;
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
        }
        sb.append('}');
        return sb.toString();
    }

    @Override // java.util.Map
    public /* synthetic */ Collection values() {
        zzdwk<V> zzdwkVar = this.zzhqt;
        if (zzdwkVar != null) {
            return zzdwkVar;
        }
        zzdwk<V> zzdwkVarZzaxt = zzaxt();
        this.zzhqt = zzdwkVarZzaxt;
        return zzdwkVarZzaxt;
    }

    abstract zzdws<Map.Entry<K, V>> zzaxr();

    abstract zzdws<K> zzaxs();

    abstract zzdwk<V> zzaxt();
}
