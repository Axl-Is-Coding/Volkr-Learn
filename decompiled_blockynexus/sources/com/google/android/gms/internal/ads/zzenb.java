package com.google.android.gms.internal.ads;

import java.util.ListIterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzenb implements ListIterator<String> {
    private final /* synthetic */ int zzhso;
    private ListIterator<String> zzinw;
    private final /* synthetic */ zzenc zzinx;

    zzenb(zzenc zzencVar, int i) {
        this.zzinx = zzencVar;
        this.zzhso = i;
        this.zzinw = this.zzinx.zziny.listIterator(this.zzhso);
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void add(String str) {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final boolean hasNext() {
        return this.zzinw.hasNext();
    }

    @Override // java.util.ListIterator
    public final boolean hasPrevious() {
        return this.zzinw.hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final /* synthetic */ Object next() {
        return this.zzinw.next();
    }

    @Override // java.util.ListIterator
    public final int nextIndex() {
        return this.zzinw.nextIndex();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ String previous() {
        return this.zzinw.previous();
    }

    @Override // java.util.ListIterator
    public final int previousIndex() {
        return this.zzinw.previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    @Override // java.util.ListIterator
    public final /* synthetic */ void set(String str) {
        throw new UnsupportedOperationException();
    }
}
