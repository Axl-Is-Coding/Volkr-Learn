package com.google.android.gms.internal.measurement;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
abstract class zzel<K, V> implements zzfk<K, V> {
    private transient Map<K, Collection<V>> zza;

    zzel() {
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof zzfk) {
            return zza().equals(((zzfk) obj).zza());
        }
        return false;
    }

    public int hashCode() {
        return zza().hashCode();
    }

    public String toString() {
        return zza().toString();
    }

    public boolean zza(Object obj) {
        Iterator<Collection<V>> it = zza().values().iterator();
        while (it.hasNext()) {
            if (it.next().contains(obj)) {
                return true;
            }
        }
        return false;
    }

    abstract Map<K, Collection<V>> zzb();

    @Override // com.google.android.gms.internal.measurement.zzfk
    public Map<K, Collection<V>> zza() {
        Map<K, Collection<V>> map = this.zza;
        if (map != null) {
            return map;
        }
        Map<K, Collection<V>> mapZzb = zzb();
        this.zza = mapZzb;
        return mapZzb;
    }
}
