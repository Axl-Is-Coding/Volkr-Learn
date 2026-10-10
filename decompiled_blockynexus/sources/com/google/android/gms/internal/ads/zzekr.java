package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.RandomAccess;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzekr extends zzeij<String> implements zzeku, RandomAccess {
    private static final zzekr zzikt;
    private static final zzeku zziku;
    private final List<Object> zzikv;

    static {
        zzekr zzekrVar = new zzekr();
        zzikt = zzekrVar;
        zzekrVar.zzbec();
        zziku = zzikt;
    }

    public zzekr() {
        this(10);
    }

    private static String zzal(Object obj) {
        return obj instanceof String ? (String) obj : obj instanceof zzeip ? ((zzeip) obj).zzbef() : zzekb.zzz((byte[]) obj);
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.List
    public final /* synthetic */ void add(int i, Object obj) {
        zzbed();
        this.zzikv.add(i, (String) obj);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final boolean addAll(Collection<? extends String> collection) {
        return addAll(size(), collection);
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final void clear() {
        zzbed();
        this.zzikv.clear();
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean equals(Object obj) {
        return super.equals(obj);
    }

    @Override // java.util.AbstractList, java.util.List
    public final /* synthetic */ Object get(int i) {
        Object obj = this.zzikv.get(i);
        if (obj instanceof String) {
            return (String) obj;
        }
        if (obj instanceof zzeip) {
            zzeip zzeipVar = (zzeip) obj;
            String strZzbef = zzeipVar.zzbef();
            if (zzeipVar.zzbeg()) {
                this.zzikv.set(i, strZzbef);
            }
            return strZzbef;
        }
        byte[] bArr = (byte[]) obj;
        String strZzz = zzekb.zzz(bArr);
        if (zzekb.zzy(bArr)) {
            this.zzikv.set(i, strZzz);
        }
        return strZzz;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ int hashCode() {
        return super.hashCode();
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean remove(Object obj) {
        return super.remove(obj);
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean removeAll(Collection collection) {
        return super.removeAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean retainAll(Collection collection) {
        return super.retainAll(collection);
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object set(int i, Object obj) {
        zzbed();
        return zzal(this.zzikv.set(i, (String) obj));
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public final int size() {
        return this.zzikv.size();
    }

    @Override // com.google.android.gms.internal.ads.zzeku
    public final void zzaj(zzeip zzeipVar) {
        zzbed();
        this.zzikv.add(zzeipVar);
        ((AbstractList) this).modCount++;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, com.google.android.gms.internal.ads.zzekk
    public final /* bridge */ /* synthetic */ boolean zzbeb() {
        return super.zzbeb();
    }

    @Override // com.google.android.gms.internal.ads.zzeku
    public final List<?> zzbhj() {
        return Collections.unmodifiableList(this.zzikv);
    }

    @Override // com.google.android.gms.internal.ads.zzeku
    public final zzeku zzbhk() {
        return zzbeb() ? new zzenc(this) : this;
    }

    @Override // com.google.android.gms.internal.ads.zzekk
    public final /* synthetic */ zzekk zzft(int i) {
        if (i < size()) {
            throw new IllegalArgumentException();
        }
        ArrayList arrayList = new ArrayList(i);
        arrayList.addAll(this.zzikv);
        return new zzekr((ArrayList<Object>) arrayList);
    }

    @Override // com.google.android.gms.internal.ads.zzeku
    public final Object zzhe(int i) {
        return this.zzikv.get(i);
    }

    public zzekr(int i) {
        this((ArrayList<Object>) new ArrayList(i));
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.List
    public final boolean addAll(int i, Collection<? extends String> collection) {
        zzbed();
        if (collection instanceof zzeku) {
            collection = ((zzeku) collection).zzbhj();
        }
        boolean zAddAll = this.zzikv.addAll(i, collection);
        ((AbstractList) this).modCount++;
        return zAddAll;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.List
    public final /* synthetic */ Object remove(int i) {
        zzbed();
        Object objRemove = this.zzikv.remove(i);
        ((AbstractList) this).modCount++;
        return zzal(objRemove);
    }

    private zzekr(ArrayList<Object> arrayList) {
        this.zzikv = arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzeij, java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.util.List
    public final /* bridge */ /* synthetic */ boolean add(Object obj) {
        return super.add(obj);
    }
}
