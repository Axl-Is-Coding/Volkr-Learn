package com.facebook.ads.redexgen.X;

import android.os.Debug;
import android.os.Handler;
import android.os.Looper;
import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.4g, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13464g extends Thread {
    public static byte[] A07;
    public static String[] A08;
    public static final String A09;
    public final int A00;
    public final Handler A01;
    public final C13484i A02;
    public final C2026Wb A03;
    public final Runnable A04;
    public volatile long A05;
    public volatile boolean A06;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 116);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A07 = new byte[]{97, 101, 10, 102, 105, 117, 10, 99, 66, 83, 66, 68, 83, 72, 85, 103, 101, 110, 101, 114, 105, 99};
    }

    public static void A03() {
        A08 = new String[]{"22scehDHoaCOvZMprlsBZA8XDImDmfKB", "weKghC0VptQmI5ngiGaEXX", "Hf9H6", "FJiPG4ANJnN6", "MZm2fX9OE1lWAQp9g7i9e16yKVjr6LaO", "qv5p39sFFmKE2Upe5HhwzyNbLjT31UC6", "BSHanWyHkNGNXcGKwO9o06mFf", "6OihQTIk4xH7HyNYKpu4LMiaEL1fh7ec"};
    }

    static {
        A03();
        A02();
        A09 = C13464g.class.getName();
    }

    public C13464g(C2026Wb c2026Wb, C13484i c13484i) {
        this(c2026Wb, c13484i, C1693Iy.A06(c2026Wb));
    }

    public C13464g(C2026Wb c2026Wb, C13484i c13484i, int i) {
        this.A01 = new Handler(Looper.getMainLooper());
        this.A04 = new Runnable() { // from class: com.facebook.ads.redexgen.X.4f
            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                if (KL.A02(this)) {
                    return;
                }
                try {
                    this.A00.A05 = 0L;
                    this.A00.A06 = false;
                } catch (Throwable th) {
                    KL.A00(th, this);
                }
            }
        };
        this.A05 = 0L;
        this.A06 = false;
        setName(A01(0, 15, 83));
        this.A00 = i;
        this.A03 = c2026Wb;
        this.A02 = c13484i;
    }

    @Override // java.lang.Thread, java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            long j = this.A00;
            while (!isInterrupted()) {
                long j2 = this.A05;
                String[] strArr = A08;
                if (strArr[1].length() != strArr[2].length()) {
                    String[] strArr2 = A08;
                    strArr2[3] = "QDJRY7exkP3l";
                    strArr2[6] = "zyOVtGNErBmKt3HrtbWcAlOC0";
                    boolean needPost = j2 == 0;
                    this.A05 = j;
                    if (needPost) {
                        this.A01.post(this.A04);
                    }
                    try {
                        Thread.sleep(j);
                        if (this.A05 != 0) {
                            boolean needPost2 = this.A06;
                            if (!needPost2) {
                                boolean needPost3 = Debug.isDebuggerConnected();
                                if (!needPost3) {
                                    boolean needPost4 = this.A02.A05();
                                    if (needPost4) {
                                        this.A03.A04().A8H(A01(15, 7, 116), C8Y.A0y, new C8Z(this.A02.A04()));
                                    }
                                    this.A06 = true;
                                }
                            }
                        }
                    } catch (InterruptedException unused) {
                        BuildConfigApi.isDebug();
                        return;
                    }
                } else {
                    throw new RuntimeException();
                }
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
