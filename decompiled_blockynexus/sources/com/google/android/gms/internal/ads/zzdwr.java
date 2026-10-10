package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdwr<E> extends zzdwg<E> {
    private final zzdwp<E> zzhqo;

    zzdwr(zzdwp<E> zzdwpVar, int i) {
        super(zzdwpVar.size(), i);
        this.zzhqo = zzdwpVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdwg
    protected final E get(int i) {
        return this.zzhqo.get(i);
    }
}
