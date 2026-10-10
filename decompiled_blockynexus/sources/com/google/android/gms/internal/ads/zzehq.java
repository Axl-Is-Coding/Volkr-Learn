package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Mac;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzehq extends ThreadLocal<Mac> {
    private final /* synthetic */ zzehn zzidq;

    zzehq(zzehn zzehnVar) {
        this.zzidq = zzehnVar;
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // java.lang.ThreadLocal
    /* JADX INFO: renamed from: zzbdq, reason: merged with bridge method [inline-methods] */
    public final Mac initialValue() {
        try {
            Mac macZzhs = zzehb.zzicy.zzhs(this.zzidq.zzidl);
            macZzhs.init(this.zzidq.zzidm);
            return macZzhs;
        } catch (GeneralSecurityException e2) {
            throw new IllegalStateException(e2);
        }
    }
}
