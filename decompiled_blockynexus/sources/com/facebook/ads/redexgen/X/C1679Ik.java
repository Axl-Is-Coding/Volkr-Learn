package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.content.Context;
import android.hardware.display.DisplayManager;
import android.view.Display;
import android.view.WindowManager;
import androidx.annotation.Nullable;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ik, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(16)
public final class C1679Ik {
    public static byte[] A0C;
    public static String[] A0D;
    public long A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;
    public long A05;
    public long A06;
    public long A07;
    public boolean A08;
    public final WindowManager A09;
    public final C1677Ii A0A;
    public final ChoreographerFrameCallbackC1678Ij A0B;

    static {
        A05();
        A04();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0C, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 124);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0C = new byte[]{109, 96, 122, 121, 101, 104, 112, 120, 102, 97, 107, 96, 120};
    }

    public static void A05() {
        A0D = new String[]{"i0Plrx2Nq5R", "0KClt8Z9EM", "nQMuIj2OsVJHQqYmqvawjMpASRVzc92c", "WLkeStMKuRlseW4hkxDKryqccASBMssv", "75mbZl2wj9Oc7L4cfBN0ornHxJ7x4bV4", "cDdFi4obBr6Dm4LziWqhdJNE9f6gL2cC", "Y", "1LOEfBfCv2OZoty488nnb7WvOOH1XlhR"};
    }

    public C1679Ik() {
        this(null);
    }

    public C1679Ik(@Nullable Context context) {
        if (context != null) {
            context = context.getApplicationContext();
            this.A09 = (WindowManager) context.getSystemService(A02(7, 6, 115));
        } else {
            this.A09 = null;
        }
        if (this.A09 != null) {
            this.A0A = IW.A02 >= 17 ? A01(context) : null;
            this.A0B = ChoreographerFrameCallbackC1678Ij.A00();
        } else {
            this.A0A = null;
            this.A0B = null;
        }
        this.A06 = -9223372036854775807L;
        this.A07 = -9223372036854775807L;
    }

    public static long A00(long vsyncCount, long j, long snappedBeforeNs) {
        long snappedTimeNs;
        long snappedTimeNs2 = j + (snappedBeforeNs * ((vsyncCount - j) / snappedBeforeNs));
        if (vsyncCount <= snappedTimeNs2) {
            snappedTimeNs = snappedTimeNs2 - snappedBeforeNs;
        } else {
            snappedTimeNs = snappedTimeNs2;
            snappedTimeNs2 += snappedBeforeNs;
        }
        return snappedTimeNs2 - vsyncCount < vsyncCount - snappedTimeNs ? snappedTimeNs2 : snappedTimeNs;
    }

    @TargetApi(17)
    private C1677Ii A01(Context context) {
        DisplayManager displayManager = (DisplayManager) context.getSystemService(A02(0, 7, 117));
        if (displayManager == null) {
            return null;
        }
        return new C1677Ii(this, displayManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A03() {
        Display defaultDisplay = this.A09.getDefaultDisplay();
        if (defaultDisplay != null) {
            double defaultDisplayRefreshRate = defaultDisplay.getRefreshRate();
            double d2 = 1.0E9d / defaultDisplayRefreshRate;
            String[] strArr = A0D;
            if (strArr[1].length() == strArr[6].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0D;
            strArr2[0] = "cQjBVfAMAaWJXkNWf";
            strArr2[0] = "cQjBVfAMAaWJXkNWf";
            this.A06 = (long) d2;
            this.A07 = (this.A06 * 80) / 100;
        }
    }

    private boolean A07(long j, long j2) {
        return Math.abs((j2 - this.A05) - (j - this.A04)) > 20000000;
    }

    public final long A08(long j, long j2) {
        long j3 = 1000 * j;
        long j4 = j3;
        long adjustedReleaseTimeNs = j2;
        if (this.A08) {
            if (j != this.A02) {
                this.A01++;
                this.A00 = this.A03;
            }
            long j5 = this.A01;
            if (j5 >= 6) {
                long j6 = this.A00 + ((j3 - this.A04) / j5);
                if (A07(j6, j2)) {
                    this.A08 = false;
                } else {
                    long adjustedReleaseTimeNs2 = this.A05 + j6;
                    long adjustedFrameTimeNs = this.A04;
                    adjustedReleaseTimeNs = adjustedReleaseTimeNs2 - adjustedFrameTimeNs;
                    j4 = j6;
                }
            } else if (A07(j3, j2)) {
                this.A08 = false;
            }
        }
        if (!this.A08) {
            this.A04 = j3;
            this.A05 = j2;
            this.A01 = 0L;
            this.A08 = true;
        }
        this.A02 = j;
        this.A03 = j4;
        ChoreographerFrameCallbackC1678Ij choreographerFrameCallbackC1678Ij = this.A0B;
        if (choreographerFrameCallbackC1678Ij == null || this.A06 == -9223372036854775807L) {
            return adjustedReleaseTimeNs;
        }
        long j7 = choreographerFrameCallbackC1678Ij.A04;
        if (j7 == -9223372036854775807L) {
            return adjustedReleaseTimeNs;
        }
        long adjustedFrameTimeNs2 = this.A06;
        long adjustedReleaseTimeNs3 = A00(adjustedReleaseTimeNs, j7, adjustedFrameTimeNs2);
        long adjustedFrameTimeNs3 = this.A07;
        return adjustedReleaseTimeNs3 - adjustedFrameTimeNs3;
    }

    public final void A09() {
        if (this.A09 != null) {
            C1677Ii c1677Ii = this.A0A;
            if (c1677Ii != null) {
                c1677Ii.A01();
            }
            this.A0B.A08();
        }
    }

    public final void A0A() {
        this.A08 = false;
        if (this.A09 != null) {
            this.A0B.A07();
            C1677Ii c1677Ii = this.A0A;
            if (c1677Ii != null) {
                c1677Ii.A00();
            }
            A03();
        }
    }
}
