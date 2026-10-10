package com.google.firebase.iid;

import io.rong.common.dlog.DLog;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: loaded from: classes2.dex */
public final class zza {
    public static KeyPair zzc() {
        try {
            KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
            keyPairGenerator.initialize(DLog.CRS);
            return keyPairGenerator.generateKeyPair();
        } catch (NoSuchAlgorithmException e2) {
            throw new AssertionError(e2);
        }
    }
}
