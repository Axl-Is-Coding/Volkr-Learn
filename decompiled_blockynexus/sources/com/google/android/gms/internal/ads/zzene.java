package com.google.android.gms.internal.ads;

import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzene implements Iterator<String> {
    private final /* synthetic */ zzenc zzinx;
    private Iterator<String> zziot;

    zzene(zzenc zzencVar) {
        this.zzinx = zzencVar;
        this.zziot = this.zzinx.zziny.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.zziot.hasNext();
    }

    @Override // java.util.Iterator
    public final /* synthetic */ String next() {
        return this.zziot.next();
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
