package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeio extends zzeiq {
    private final int limit;
    private int position = 0;
    private final /* synthetic */ zzeip zzieq;

    zzeio(zzeip zzeipVar) {
        this.zzieq = zzeipVar;
        this.limit = this.zzieq.size();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.position < this.limit;
    }

    @Override // com.google.android.gms.internal.ads.zzeiu
    public final byte nextByte() {
        int i = this.position;
        if (i >= this.limit) {
            throw new NoSuchElementException();
        }
        this.position = i + 1;
        return this.zzieq.zzfv(i);
    }
}
