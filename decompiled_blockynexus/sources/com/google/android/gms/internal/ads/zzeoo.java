package com.google.android.gms.internal.ads;

import java.util.AbstractList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzeoo<E> extends AbstractList<E> {
    private static final zzeoq zzdc = zzeoq.zzn(zzeoo.class);
    List<E> zziuc;
    Iterator<E> zziud;

    public zzeoo(List<E> list, Iterator<E> it) {
        this.zziuc = list;
        this.zziud = it;
    }

    @Override // java.util.AbstractList, java.util.List
    public E get(int i) {
        if (this.zziuc.size() > i) {
            return this.zziuc.get(i);
        }
        if (!this.zziud.hasNext()) {
            throw new NoSuchElementException();
        }
        this.zziuc.add(this.zziud.next());
        return get(i);
    }

    @Override // java.util.AbstractList, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.List
    public Iterator<E> iterator() {
        return new zzeon(this);
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.util.List
    public int size() {
        zzdc.zzik("potentially expensive size() call");
        zzdc.zzik("blowup running");
        while (this.zziud.hasNext()) {
            this.zziuc.add(this.zziud.next());
        }
        return this.zziuc.size();
    }
}
