package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-measurement-base@@18.0.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzkk<K, V> implements Iterator<Map.Entry<K, V>> {
    private int zza;
    private boolean zzb;
    private Iterator<Map.Entry<K, V>> zzc;
    private final /* synthetic */ zzkc zzd;

    private zzkk(zzkc zzkcVar) {
        this.zzd = zzkcVar;
        this.zza = -1;
    }

    private final Iterator<Map.Entry<K, V>> zza() {
        if (this.zzc == null) {
            this.zzc = this.zzd.zzc.entrySet().iterator();
        }
        return this.zzc;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zza + 1 < this.zzd.zzb.size() || (!this.zzd.zzc.isEmpty() && zza().hasNext());
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.zzb = true;
        int i = this.zza + 1;
        this.zza = i;
        return i < this.zzd.zzb.size() ? (Map.Entry) this.zzd.zzb.get(this.zza) : zza().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzb) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzb = false;
        this.zzd.zzf();
        if (this.zza >= this.zzd.zzb.size()) {
            zza().remove();
            return;
        }
        zzkc zzkcVar = this.zzd;
        int i = this.zza;
        this.zza = i - 1;
        zzkcVar.zzc(i);
    }

    /* synthetic */ zzkk(zzkc zzkcVar, zzkf zzkfVar) {
        this(zzkcVar);
    }
}
