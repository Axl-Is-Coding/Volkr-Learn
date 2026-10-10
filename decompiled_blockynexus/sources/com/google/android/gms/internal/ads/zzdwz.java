package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdwz<E> extends zzdwp<E> {
    static final zzdwp<Object> zzhra = new zzdwz(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzhrb;

    zzdwz(Object[] objArr, int i) {
        this.zzhrb = objArr;
        this.size = i;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzdwd.zzs(i, this.size);
        return (E) this.zzhrb[i];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdwp, com.google.android.gms.internal.ads.zzdwk
    final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzhrb, 0, objArr, i, this.size);
        return i + this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    final Object[] zzaxj() {
        return this.zzhrb;
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
}
