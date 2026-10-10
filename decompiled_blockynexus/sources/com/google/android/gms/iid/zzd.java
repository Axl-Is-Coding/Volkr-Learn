package com.google.android.gms.iid;

import io.rong.common.dlog.DLog;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes.dex */
public final class zzd {
    public static KeyPair zzk() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(DLog.CRS);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }
}
