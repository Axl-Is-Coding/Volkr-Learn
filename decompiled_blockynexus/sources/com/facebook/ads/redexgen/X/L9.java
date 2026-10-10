package com.facebook.ads.redexgen.X;

import androidx.annotation.Nullable;
import java.io.Closeable;
import java.io.IOException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class L9 implements Closeable {

    @Nullable
    public L8 A00;
    public boolean A01;
    public final L7 A02;
    public final Runnable A03;

    public L9(long j, Runnable runnable) {
        this.A02 = new L7(j);
        this.A02.A02();
        this.A03 = runnable;
        this.A01 = false;
    }

    private final synchronized void A03() {
        if (this.A00 == null && !this.A01) {
            this.A00 = new L8(this);
        }
    }

    public final L7 A04() {
        return this.A02;
    }

    public final synchronized void A05() {
        if (this.A01) {
            return;
        }
        if (this.A00 == null) {
            this.A00 = new L8(this);
        }
        this.A00.A01();
    }

    public final synchronized void A06() {
        if (this.A02.A05() && !this.A01) {
            A03();
        }
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final void close() throws IOException {
        L8 l8;
        synchronized (this) {
            this.A01 = true;
            l8 = this.A00;
        }
        if (l8 != null) {
            l8.close();
        }
    }
}
