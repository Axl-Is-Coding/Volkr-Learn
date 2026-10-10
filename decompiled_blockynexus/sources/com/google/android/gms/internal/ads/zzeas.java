package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzelj;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzeas<KeyProtoT extends zzelj, PublicKeyProtoT extends zzelj> extends zzeag<KeyProtoT> {
    private final Class<PublicKeyProtoT> zzhuy;

    @SafeVarargs
    protected zzeas(Class<KeyProtoT> cls, Class<PublicKeyProtoT> cls2, zzeai<?, KeyProtoT>... zzeaiVarArr) {
        super(cls, zzeaiVarArr);
        this.zzhuy = cls2;
    }
}
