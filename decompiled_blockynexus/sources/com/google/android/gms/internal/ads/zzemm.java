package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzemm<K, V> implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzemk zzinm;
    private Iterator<Map.Entry<K, V>> zzinn;

    private zzemm(zzemk zzemkVar) {
        this.zzinm = zzemkVar;
        this.pos = this.zzinm.zzinh.size();
    }

    private final Iterator<Map.Entry<K, V>> zzbir() {
        if (this.zzinn == null) {
            this.zzinn = this.zzinm.zzink.entrySet().iterator();
        }
        return this.zzinn;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        int i = this.pos;
        return (i > 0 && i <= this.zzinm.zzinh.size()) || zzbir().hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        if (zzbir().hasNext()) {
            return zzbir().next();
        }
        List list = this.zzinm.zzinh;
        int i = this.pos - 1;
        this.pos = i;
        return (Map.Entry) list.get(i);
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }

    /* synthetic */ zzemm(zzemk zzemkVar, zzemj zzemjVar) {
        this(zzemkVar);
    }
}
