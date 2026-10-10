package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdxc extends zzdwp<Object> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zzhqz;

    zzdxc(Object[] objArr, int i, int i2) {
        this.zzhqz = objArr;
        this.offset = i;
        this.size = i2;
    }

    @Override // java.util.List
    public final Object get(int i) {
        zzdwd.zzs(i, this.size);
        return this.zzhqz[(i * 2) + this.offset];
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.size;
    }

    @Override // com.google.android.gms.internal.ads.zzdwk
    final boolean zzaxn() {
        return true;
    }
}
