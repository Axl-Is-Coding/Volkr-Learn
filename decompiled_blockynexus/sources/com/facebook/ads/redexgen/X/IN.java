package com.facebook.ads.redexgen.X;

import java.io.BufferedOutputStream;
import java.io.OutputStream;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class IN extends BufferedOutputStream {
    public boolean A00;

    public IN(OutputStream outputStream) {
        super(outputStream);
    }

    public IN(OutputStream outputStream, int i) {
        super(outputStream, i);
    }

    public final void A00(OutputStream outputStream) {
        C1662Hr.A04(this.A00);
        this.out = outputStream;
        this.count = 0;
        this.A00 = false;
    }

    @Override // java.io.FilterOutputStream, java.io.OutputStream, java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws Throwable {
        this.A00 = true;
        Throwable th = null;
        try {
            flush();
        } catch (Throwable th2) {
            th = th2;
        }
        try {
            this.out.close();
        } catch (Throwable e2) {
            if (th == null) {
                th = e2;
            }
        }
        if (th != null) {
            IW.A0Z(th);
        }
    }
}
