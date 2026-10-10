package com.facebook.ads.redexgen.X;

import androidx.annotation.VisibleForTesting;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class QD {

    @VisibleForTesting
    public static boolean A02;
    public static String[] A03;
    public long A00 = 0;
    public final FY A01;

    public static void A01() {
        A03 = new String[]{"qsn7C6zn3PdSVfgubJel9atpLV8UzMkS", "d5sl1UvhAH", "h3HSO", "RPMH8", "hkIXVCWcwK478YEFfwbo8RGIomhe8bPZ", "XzI0qoLX56", "bH89tdse0KsHc3c1ijve", "fX7ikpx60ZPhJLse4FRwcVwuHJXGRP"};
    }

    static {
        A01();
        A02 = false;
    }

    public QD(FY fy) {
        this.A01 = fy;
        new Thread(new QC(this)).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A00() {
        while (true) {
            synchronized (this) {
                if (this.A00 == 0) {
                    try {
                        wait();
                    } catch (InterruptedException unused) {
                    }
                } else {
                    long jNanoTime = System.nanoTime();
                    if (jNanoTime < this.A00) {
                        int i = (int) ((this.A00 - jNanoTime) / 1000000);
                        if (i >= 1) {
                            try {
                                wait(i);
                            } catch (InterruptedException unused2) {
                            }
                        }
                    }
                    this.A00 = 0L;
                    this.A01.A0A();
                    long jNanoTime2 = System.nanoTime();
                    synchronized (this) {
                        if (this.A00 < jNanoTime2) {
                            this.A00 = 0L;
                        }
                    }
                }
            }
        }
    }

    public final synchronized void A03() {
        this.A00 = System.nanoTime();
        notifyAll();
    }

    public final synchronized void A04(int i) {
        long jNanoTime = System.nanoTime() + (((long) i) * 1000000 * ((long) (A02 ? 1 : 1000)));
        long requestedNextSync = this.A00;
        if (requestedNextSync == 0 || this.A00 > jNanoTime) {
            this.A00 = jNanoTime;
            notifyAll();
        }
        String[] strArr = A03;
        if (strArr[7].length() == strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A03;
        strArr2[3] = "scQbN";
        strArr2[2] = "fyfTH";
    }
}
