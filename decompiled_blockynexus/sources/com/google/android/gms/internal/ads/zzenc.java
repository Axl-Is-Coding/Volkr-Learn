package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzenc extends AbstractList<String> implements zzeku, RandomAccess {
    private final zzeku zziny;

    public zzenc(zzeku zzekuVar) {
        this.zziny = zzekuVar;
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        return (String) this.zziny.get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public final Iterator<String> iterator() {
        return new zzene(this);
    }

    @Override // java.util.AbstractList, java.util.List
    public final ListIterator<String> listIterator(int i) {
        return new zzenb(this, i);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zziny.size();
    }

    @Override // com.google.android.gms.internal.ads.zzeku
    public final void zzaj(zzeip zzeipVar) {
        throw new UnsupportedOperationException();
    }

    @Override // com.google.android.gms.internal.ads.zzeku
    public final List<?> zzbhj() {
        return this.zziny.zzbhj();
    }

    @Override // com.google.android.gms.internal.ads.zzeku
    public final zzeku zzbhk() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzeku
    public final Object zzhe(int i) {
        return this.zziny.zzhe(i);
    }
}
