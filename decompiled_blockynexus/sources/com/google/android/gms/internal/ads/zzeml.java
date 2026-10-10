package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzeml extends zzemr {
    private final /* synthetic */ zzemk zzinm;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    private zzeml(zzemk zzemkVar) {
        super(zzemkVar, null);
        this.zzinm = zzemkVar;
    }

    @Override // com.google.android.gms.internal.ads.zzemr, java.util.AbstractCollection, java.util.Collection, java.lang.Iterable, java.util.Set
    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzemm(this.zzinm, null);
    }

    /* synthetic */ zzeml(zzemk zzemkVar, zzemj zzemjVar) {
        this(zzemkVar);
    }
}
