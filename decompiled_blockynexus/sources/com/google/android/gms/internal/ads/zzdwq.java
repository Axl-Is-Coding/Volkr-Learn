package com.google.android.gms.internal.ads;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdwq<E> extends zzdwp<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzdwp zzhqn;

    zzdwq(zzdwp zzdwpVar, int i, int i2) {
        this.zzhqn = zzdwpVar;
        this.offset = i;
        this.length = i2;
    }

    @Override // java.util.List
    public final E get(int i) {
        zzdwd.zzs(i, this.length);
        return this.zzhqn.get(i + this.offset);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.length;
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    final Object[] zzaxj() {
        return this.zzhqn.zzaxj();
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    final int zzaxk() {
        return this.zzhqn.zzaxk() + this.offset;
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    final int zzaxl() {
        return this.zzhqn.zzaxk() + this.offset + this.length;
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    final boolean zzaxn() {
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzdwp, java.util.List
    /* JADX INFO: renamed from: zzu */
    public final zzdwp<E> subList(int i, int i2) {
        zzdwd.zzf(i, i2, this.length);
        zzdwp zzdwpVar = this.zzhqn;
        int i3 = this.offset;
        return (zzdwp) zzdwpVar.subList(i + i3, i2 + i3);
    }
}
