package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.view.Choreographer;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ij, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class ChoreographerFrameCallbackC1678Ij implements Choreographer.FrameCallback, Handler.Callback {
    public static byte[] A05;
    public static String[] A06;
    public static final ChoreographerFrameCallbackC1678Ij A07;
    public int A00;
    public Choreographer A01;
    public final Handler A02;
    public volatile long A04 = -9223372036854775807L;
    public final HandlerThread A03 = new HandlerThread(A01(0, 26, 7));

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 127);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A05 = new byte[]{-55, -18, -11, -8, -21, -11, -19, -8, -25, -10, -18, -21, -8, -43, -3, -12, -21, -8, -64, -50, -25, -12, -22, -14, -21, -8};
    }

    public static void A06() {
        A06 = new String[]{"7pBVLZrqhDDbZ0tYj5xh6PpAno2m", "xkcxMmw20FKB7FJbtkqD12cEqTB7ze2w", "TM2oCNBKKDXNLmDj8LdFTV0zf2KY6EDx", "0Qcgaz5qfDTLbpJoV0yTITWXMh6lxrN5", "RYkflwVTmTjUKlFHuRroVnAWoEc89IJi", "1MiZZB75", "Nr3lQs", "1me56lfIABHV4"};
    }

    static {
        A06();
        A05();
        A07 = new ChoreographerFrameCallbackC1678Ij();
    }

    public ChoreographerFrameCallbackC1678Ij() {
        this.A03.start();
        this.A02 = new Handler(this.A03.getLooper(), this);
        this.A02.sendEmptyMessage(0);
    }

    public static ChoreographerFrameCallbackC1678Ij A00() {
        return A07;
    }

    private void A02() {
        this.A00++;
        if (this.A00 == 1) {
            this.A01.postFrameCallback(this);
        }
    }

    private void A03() {
        this.A01 = Choreographer.getInstance();
    }

    private void A04() {
        this.A00--;
        if (this.A00 == 0) {
            this.A01.removeFrameCallback(this);
            this.A04 = -9223372036854775807L;
        }
    }

    public final void A07() {
        this.A02.sendEmptyMessage(1);
    }

    public final void A08() {
        this.A02.sendEmptyMessage(2);
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long j) {
        this.A04 = j;
        this.A01.postFrameCallbackDelayed(this, 500L);
    }

    @Override // android.os.Handler.Callback
    public final boolean handleMessage(Message message) {
        int i = message.what;
        if (i == 0) {
            A03();
            return true;
        }
        if (i == 1) {
            A02();
            return true;
        }
        if (i == 2) {
            A04();
            return true;
        }
        if (A06[4].charAt(23) != 'W') {
            throw new RuntimeException();
        }
        String[] strArr = A06;
        strArr[7] = "NYQIx0THDyroo";
        strArr[5] = "Pe1eikc3";
        return false;
    }
}
