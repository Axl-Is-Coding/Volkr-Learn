package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: Add missing generic type declarations: [V, K] */
/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzems<K, V> implements Iterator<Map.Entry<K, V>> {
    private int pos;
    private final /* synthetic */ zzemk zzinm;
    private Iterator<Map.Entry<K, V>> zzinn;
    private boolean zzinr;

    private zzems(zzemk zzemkVar) {
        this.zzinm = zzemkVar;
        this.pos = -1;
    }

    private final Iterator<Map.Entry<K, V>> zzbir() {
        if (this.zzinn == null) {
            this.zzinn = this.zzinm.zzini.entrySet().iterator();
        }
        return this.zzinn;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.pos + 1 < this.zzinm.zzinh.size() || (!this.zzinm.zzini.isEmpty() && zzbir().hasNext());
    }

    @Override // java.util.Iterator
    public final /* synthetic */ Object next() {
        this.zzinr = true;
        int i = this.pos + 1;
        this.pos = i;
        return i < this.zzinm.zzinh.size() ? (Map.Entry) this.zzinm.zzinh.get(this.pos) : zzbir().next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        if (!this.zzinr) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzinr = false;
        this.zzinm.zzbip();
        if (this.pos >= this.zzinm.zzinh.size()) {
            zzbir().remove();
            return;
        }
        zzemk zzemkVar = this.zzinm;
        int i = this.pos;
        this.pos = i - 1;
        zzemkVar.zzhq(i);
    }

    /* synthetic */ zzems(zzemk zzemkVar, zzemj zzemjVar) {
        this(zzemkVar);
    }
}
