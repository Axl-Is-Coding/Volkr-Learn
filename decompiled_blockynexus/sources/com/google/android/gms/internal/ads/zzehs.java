package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzehs {
    private static final ThreadLocal<SecureRandom> zzidr = new zzehr();

    /* JADX INFO: Access modifiers changed from: private */
    public static SecureRandom zzbdr() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] zzfo(int i) {
        byte[] bArr = new byte[i];
        zzidr.get().nextBytes(bArr);
        return bArr;
    }
}
