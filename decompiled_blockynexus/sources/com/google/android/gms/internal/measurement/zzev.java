package com.google.android.gms.internal.measurement;

import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-impl@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzev<K, V> extends zzei<K, V> {
    private final K zza;
    private int zzb;
    private final /* synthetic */ zzem zzc;

    zzev(zzem zzemVar, int i) {
        this.zzc = zzemVar;
        this.zza = (K) zzemVar.zzb[i];
        this.zzb = i;
    }

    private final void zza() {
        int i = this.zzb;
        if (i == -1 || i >= this.zzc.size() || !zzdz.zza(this.zza, this.zzc.zzb[this.zzb])) {
            this.zzb = this.zzc.zza(this.zza);
        }
    }

    @Override // com.google.android.gms.internal.measurement.zzei, java.util.Map.Entry
    public final K getKey() {
        return this.zza;
    }

    @Override // com.google.android.gms.internal.measurement.zzei, java.util.Map.Entry
    public final V getValue() {
        Map<K, V> mapZzb = this.zzc.zzb();
        if (mapZzb != null) {
            return mapZzb.get(this.zza);
        }
        zza();
        int i = this.zzb;
        if (i == -1) {
            return null;
        }
        return (V) this.zzc.zzc[i];
    }

    @Override // com.google.android.gms.internal.measurement.zzei, java.util.Map.Entry
    public final V setValue(V v) {
        Map<K, V> mapZzb = this.zzc.zzb();
        if (mapZzb != null) {
            return mapZzb.put(this.zza, v);
        }
        zza();
        int i = this.zzb;
        if (i == -1) {
            this.zzc.put(this.zza, v);
            return null;
        }
        Object[] objArr = this.zzc.zzc;
        V v2 = (V) objArr[i];
        objArr[i] = v;
        return v2;
    }
}
