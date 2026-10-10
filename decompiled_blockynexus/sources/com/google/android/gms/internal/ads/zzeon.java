package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;

/* JADX INFO: Add missing generic type declarations: [E] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeon<E> implements Iterator<E> {
    private int pos = 0;
    private final /* synthetic */ zzeoo zziub;

    zzeon(zzeoo zzeooVar) {
        this.zziub = zzeooVar;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.pos < this.zziub.zziuc.size() || this.zziub.zziud.hasNext();
    }

    @Override // java.util.Iterator
    public final E next() {
        while (this.pos >= this.zziub.zziuc.size()) {
            zzeoo zzeooVar = this.zziub;
            zzeooVar.zziuc.add(zzeooVar.zziud.next());
        }
        List<E> list = this.zziub.zziuc;
        int i = this.pos;
        this.pos = i + 1;
        return list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
