package com.facebook.ads.redexgen.X;

import android.net.Uri;
import java.io.IOException;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ZT implements InterfaceC1575Ec {
    public static String[] A06;
    public final HG A00;
    public final InterfaceC1646Hb A01;
    public final C2176aq A02;
    public final IK A04;
    public final C1651Hg A03 = new C1651Hg();
    public final AtomicBoolean A05 = new AtomicBoolean();

    static {
        A00();
    }

    public static void A00() {
        A06 = new String[]{"0vmpU1QtAhI6qjIdcVId", "klBv", "qKjW3ego541fEYihs", "NuBFx4EY8fIgWeMvZ", "vAKBh2R", "FoB4J1nu", "9b5WU1uKCw6g3SYcMdOb", "twQXN8Z"};
    }

    public ZT(Uri uri, String str, C1576Ed c1576Ed) {
        this.A00 = new HG(uri, 0L, -1L, str, 0);
        this.A01 = c1576Ed.A00();
        this.A02 = c1576Ed.A01(false);
        this.A04 = c1576Ed.A02();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1575Ec
    public final void A4q() throws InterruptedException, IOException {
        this.A04.A00(-1000);
        try {
            C1652Hh.A04(this.A00, this.A01, this.A02, new byte[131072], this.A04, -1000, this.A03, this.A05, true);
            IK ik = this.A04;
            String[] strArr = A06;
            if (strArr[3].length() != strArr[2].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A06;
            strArr2[0] = "qX3fQQGAY3dTsBjdyBPn";
            strArr2[6] = "Z0TFAaYyqvVnxMY9deNw";
            ik.A03(-1000);
        } catch (Throwable th) {
            this.A04.A03(-1000);
            throw th;
        }
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1575Ec
    public final float A69() {
        long j = this.A03.A01;
        if (j == -1) {
            return -1.0f;
        }
        return (this.A03.A00() * 100.0f) / j;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1575Ec
    public final long A6A() {
        return this.A03.A00();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1575Ec
    public final void cancel() {
        this.A05.set(true);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC1575Ec
    public final void remove() {
        C1652Hh.A06(this.A01, C1652Hh.A02(this.A00));
    }
}
