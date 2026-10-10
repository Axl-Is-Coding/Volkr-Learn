package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: Add missing generic type declarations: [T] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-gass@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdwu<T> extends zzdxg<T> {
    private boolean zzhqu;
    private final /* synthetic */ Object zzhqv;

    zzdwu(Object obj) {
        this.zzhqv = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.zzhqu;
    }

    @Override // java.util.Iterator
    public final T next() {
        if (this.zzhqu) {
            throw new NoSuchElementException();
        }
        this.zzhqu = true;
        return (T) this.zzhqv;
    }
}
