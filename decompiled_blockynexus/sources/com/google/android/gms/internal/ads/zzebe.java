package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzebe extends zzeai<zzehl, zzedi> {
    zzebe(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzeai
    public final /* synthetic */ zzehl zzag(zzedi zzediVar) throws GeneralSecurityException {
        zzedi zzediVar2 = zzediVar;
        return new zzegd(zzediVar2.zzazd().toByteArray(), zzediVar2.zzazs().zzazy());
    }
}
