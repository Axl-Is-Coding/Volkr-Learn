package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzrq {
    private static MessageDigest zzbud;
    protected Object mLock = new Object();

    abstract byte[] zzbu(String str);

    protected final MessageDigest zzms() {
        synchronized (this.mLock) {
            if (zzbud != null) {
                return zzbud;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    zzbud = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            return zzbud;
        }
    }
}
