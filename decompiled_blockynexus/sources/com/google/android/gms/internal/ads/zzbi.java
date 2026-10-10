package com.google.android.gms.internal.ads;

import java.io.ByteArrayOutputStream;
import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbi extends ByteArrayOutputStream {
    private final zzat zzch;

    public zzbi(zzat zzatVar, int i) {
        this.zzch = zzatVar;
        ((ByteArrayOutputStream) this).buf = this.zzch.zzf(Math.max(i, 256));
    }

    private final void zzg(int i) {
        int i2 = ((ByteArrayOutputStream) this).count;
        if (i2 + i <= ((ByteArrayOutputStream) this).buf.length) {
            return;
        }
        byte[] bArrZzf = this.zzch.zzf((i2 + i) << 1);
        System.arraycopy(((ByteArrayOutputStream) this).buf, 0, bArrZzf, 0, ((ByteArrayOutputStream) this).count);
        this.zzch.zza(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = bArrZzf;
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        this.zzch.zza(((ByteArrayOutputStream) this).buf);
        ((ByteArrayOutputStream) this).buf = null;
        super.close();
    }

    public final void finalize() {
        this.zzch.zza(((ByteArrayOutputStream) this).buf);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(byte[] bArr, int i, int i2) {
        zzg(i2);
        super.write(bArr, i, i2);
    }

    @Override // java.io.ByteArrayOutputStream, java.io.OutputStream
    public final synchronized void write(int i) {
        zzg(1);
        super.write(i);
    }
}
