package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcz implements Runnable {
    private zzcz() {
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            MessageDigest unused = zzcx.zzns = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused2) {
        } finally {
            zzcx.zznv.countDown();
        }
    }
}
