package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzekp<K> implements Iterator<Map.Entry<K, Object>> {
    private Iterator<Map.Entry<K, Object>> zzikr;

    public zzekp(Iterator<Map.Entry<K, Object>> it) {
        this.zzikr = it;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zzikr.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        Map.Entry<K, Object> next = this.zzikr.next();
        return next.getValue() instanceof zzeko ? new zzekq(next) : next;
    }

    @Override // java.util.Iterator
    public final void remove() {
        this.zzikr.remove();
    }
}
