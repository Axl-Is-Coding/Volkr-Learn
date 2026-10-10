package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzegi extends ThreadLocal<Cipher> {
    zzegi() {
    }

    private static Cipher zzbdm() {
        try {
            return zzehb.zzicx.zzhs("AES/ECB/NOPADDING");
        } catch (GeneralSecurityException e2) {
            throw new IllegalStateException(e2);
        }
    }

    @Override // java.lang.ThreadLocal
    protected final /* synthetic */ Cipher initialValue() {
        return zzbdm();
    }
}
