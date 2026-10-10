package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzebu extends zzeai<zzdzv, zzefr> {
    zzebu(Class cls) {
        super(cls);
    }

    @Override // com.google.android.gms.internal.ads.zzeai
    public final /* synthetic */ zzdzv zzag(zzefr zzefrVar) throws GeneralSecurityException {
        zzefr zzefrVar2 = zzefrVar;
        String strZzbdb = zzefrVar2.zzbcy().zzbdb();
        return new zzebs(zzefrVar2.zzbcy().zzbdc(), zzeaj.zzhj(strZzbdb).zzhl(strZzbdb));
    }
}
