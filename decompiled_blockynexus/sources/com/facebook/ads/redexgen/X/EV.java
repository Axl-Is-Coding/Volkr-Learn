package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.exoplayer2.offline.DownloadAction;
import java.io.IOException;
import java.util.Arrays;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class EV implements Runnable {
    public static byte[] A08;
    public static String[] A09;
    public Thread A00;
    public Throwable A01;
    public final int A02;
    public final int A03;
    public final DownloadAction A04;
    public final EY A05;
    public volatile int A06;
    public volatile InterfaceC1575Ec A07;

    static {
        A0C();
        A0B();
    }

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A08, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A09[2].charAt(18) == 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A09;
            strArr[4] = "noItpERo7CNNkHWI";
            strArr[4] = "noItpERo7CNNkHWI";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 26);
            i4++;
        }
    }

    public static void A0B() {
        A08 = new byte[]{74, 97, 121, 96, 98, 97, 111, 106, 46, 107, 124, 124, 97, 124, 32, 46, 92, 107, 122, 124, 119, 46, 20, 35, 53, 35, 50, 102, 35, 52, 52, 41, 52, 102, 37, 41, 51, 40, 50, 104, 102, 34, 41, 49, 40, 42, 41, 39, 34, 35, 34, 4, Utf8.REPLACEMENT_BYTE, 50, 35, 53, 102, 123, 102, 120, 77, 95, 71, 12, 69, 95, 12, 95, 88, 77, 94, 88, 73, 72};
    }

    public static void A0C() {
        A09 = new String[]{"KOAWbsFFbfk0jNgDY62WpIsFaQMswz1L", "pC7XDjTrGSoCHMQrO1sG15bqJEuDqJQJ", "uN2VaEj4rnuk1e19MnznGB1XwQ8yCVfE", "6JBJvnr9DSzDH8E8QP73ZcoxgSr1ahx0", "ultRdxrvkIUuntIMLaCfX8e7z", "lHTnNhXeBOI0IY3AJtGeZO2cjDNAOeyF", "OUHreehzciBJFgJNDowFbwPiXi5p615H", "Ps2SQ7luP6kIA6gbjSFjdYKTtXuPzT18"};
    }

    public EV(int i, EY ey, DownloadAction downloadAction, int i2) {
        this.A02 = i;
        this.A05 = ey;
        this.A04 = downloadAction;
        this.A06 = 0;
        this.A03 = i2;
    }

    public /* synthetic */ EV(int i, EY ey, DownloadAction downloadAction, int i2, EN en) {
        this(i, ey, downloadAction, i2);
    }

    private final float A00() {
        if (this.A07 != null) {
            return this.A07.A69();
        }
        return -1.0f;
    }

    private int A01() {
        int i = this.A06;
        if (i == 5) {
            if (A09[2].charAt(18) == 'Y') {
                throw new RuntimeException();
            }
            String[] strArr = A09;
            strArr[7] = "PDzOFNAaWMsAK9ucradbIEZZH9uUUiPx";
            strArr[1] = "5zRQ9og93WQ9CsswYkuffD8bWtu0S7Rl";
            return 0;
        }
        String[] strArr2 = A09;
        if (strArr2[7].charAt(26) != strArr2[1].charAt(26)) {
            throw new RuntimeException();
        }
        String[] strArr3 = A09;
        strArr3[6] = "vqOmrLNCQqkZmFNmkdUDZ8pThcmdYove";
        strArr3[3] = "yFowKLjp7WUTebccThRrdi4MGh2wopLF";
        if (i != 6 && i != 7) {
            return this.A06;
        }
        return 1;
    }

    private int A02(int i) {
        return Math.min((i - 1) * 1000, 5000);
    }

    private final long A05() {
        if (this.A07 != null) {
            return this.A07.A6A();
        }
        return 0L;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08() {
        if (!A0G(0, 5)) {
            if (!A0G(1, 6)) {
                return;
            }
            A09();
            return;
        }
        this.A05.A07.post(new ES(this));
    }

    private void A09() {
        if (this.A07 != null) {
            this.A07.cancel();
        }
        this.A00.interrupt();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        if (A0G(0, 1)) {
            this.A00 = new Thread(this);
            this.A00.start();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0F() {
        return this.A06 == 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0G(int i, int i2) {
        return A0H(i, i2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean A0H(int i, int i2, Throwable th) {
        if (this.A06 != i) {
            return false;
        }
        this.A06 = i2;
        this.A01 = th;
        if (!(this.A06 != A01())) {
            this.A05.A0F(this);
        }
        return true;
    }

    public final EX A0L() {
        return new EX(this.A02, this.A04, A01(), A00(), A05(), this.A01, null);
    }

    public final boolean A0M() {
        return this.A06 == 5 || this.A06 == 1 || this.A06 == 7 || this.A06 == 6;
    }

    public final boolean A0N() {
        return this.A06 == 4 || this.A06 == 2 || this.A06 == 3;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            EY.A0K(A07(59, 15, 54), this);
            Throwable th = null;
            try {
                this.A07 = this.A04.A08(this.A05.A0A);
                if (this.A04.A03) {
                    this.A07.remove();
                } else {
                    int i = 0;
                    long j = -1;
                    while (!Thread.interrupted()) {
                        try {
                            this.A07.A4q();
                            break;
                        } catch (IOException e2) {
                            long jA6A = this.A07.A6A();
                            if (jA6A != j) {
                                EY.A0K(A07(22, 37, 92) + jA6A, this);
                                j = jA6A;
                                i = 0;
                            }
                            if (this.A06 == 1 && (i = i + 1) <= this.A03) {
                                EY.A0K(A07(0, 22, 20) + i, this);
                                long downloadedBytes = (long) A02(i);
                                Thread.sleep(downloadedBytes);
                            } else {
                                throw e2;
                            }
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
            this.A05.A07.post(new ET(this, th));
        } catch (Throwable th3) {
            KL.A00(th3, this);
        }
    }

    public final String toString() {
        return super.toString();
    }
}
