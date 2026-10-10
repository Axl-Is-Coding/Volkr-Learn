package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzecn extends zzeai<zzeam, zzecz> {
    zzecn(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzeai
    public final /* synthetic */ zzeam zzag(zzecz zzeczVar) throws GeneralSecurityException {
        zzecz zzeczVar2 = zzeczVar;
        return new zzege(zzeczVar2.zzazd().toByteArray(), zzeczVar2.zzaze().zzazi());
    }
}
