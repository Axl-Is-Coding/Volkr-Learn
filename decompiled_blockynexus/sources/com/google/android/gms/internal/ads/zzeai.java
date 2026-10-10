package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzeai<PrimitiveT, KeyT> {
    private final Class<PrimitiveT> zzhuf;

    public zzeai(Class<PrimitiveT> cls) {
        this.zzhuf = cls;
    }

    public abstract PrimitiveT zzag(KeyT keyt) throws GeneralSecurityException;

    final Class<PrimitiveT> zzayk() {
        return this.zzhuf;
    }
}
