package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
final class zzrr {

    @VisibleForTesting
    private ByteArrayOutputStream zzbue = new ByteArrayOutputStream(4096);

    @VisibleForTesting
    private Base64OutputStream zzbuf = new Base64OutputStream(this.zzbue, 10);

    /* JADX WARN: Multi-variable type inference failed */
    public final String toString() {
        try {
            this.zzbuf.close();
        } catch (IOException e2) {
            zzbbq.zzc("HashManager: Unable to convert to Base64.", e2);
        }
        try {
            this.zzbue.close();
            return this.zzbue.toString();
        } catch (IOException e3) {
            zzbbq.zzc("HashManager: Unable to convert to Base64.", e3);
            return "";
        } finally {
            this.zzbue = null;
            this.zzbuf = null;
        }
    }

    public final void write(byte[] bArr) throws IOException {
        this.zzbuf.write(bArr);
    }
}
