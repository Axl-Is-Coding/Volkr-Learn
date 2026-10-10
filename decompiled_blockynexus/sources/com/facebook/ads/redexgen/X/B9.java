package com.facebook.ads.redexgen.X;

import android.media.AudioTrack;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class B9 {
    public static String[] A06;
    public int A00;
    public long A01;
    public long A02;
    public long A03;
    public long A04;

    @Nullable
    public final B7 A05;

    static {
        A00();
    }

    public static void A00() {
        A06 = new String[]{"W1h", "J3B5KCEbjjwmRuC3OBjGZe6Vqq", "m9qFzMc74R8svEUC9gqMjQn", "jgNIoR8qAkaEc7us150M5yTFbz", "3ys", "w1u", "bbeJnzocKvEAyVfPIveapdYFC3HTaXea", "5a1"};
    }

    public B9(AudioTrack audioTrack) {
        if (IW.A02 >= 19) {
            this.A05 = new B7(audioTrack);
            A06();
        } else {
            this.A05 = null;
            A01(3);
        }
    }

    private void A01(int i) {
        this.A00 = i;
        if (i == 0) {
            this.A03 = 0L;
            this.A01 = -1L;
            this.A02 = System.nanoTime() / 1000;
            this.A04 = 5000L;
            return;
        }
        if (i == 1) {
            this.A04 = 5000L;
            return;
        }
        if (i == 2 || i == 3) {
            this.A04 = 10000000L;
        } else {
            if (i == 4) {
                this.A04 = 500000L;
                return;
            }
            throw new IllegalStateException();
        }
    }

    public final long A02() {
        B7 b7 = this.A05;
        if (b7 != null) {
            return b7.A01();
        }
        return -1L;
    }

    public final long A03() {
        B7 b7 = this.A05;
        if (b7 != null) {
            return b7.A02();
        }
        return -9223372036854775807L;
    }

    public final void A04() {
        if (this.A00 == 4) {
            A06();
        }
    }

    public final void A05() {
        A01(4);
    }

    public final void A06() {
        if (this.A05 != null) {
            A01(0);
        }
    }

    public final boolean A07() {
        int i = this.A00;
        return i == 1 || i == 2;
    }

    public final boolean A08() {
        return this.A00 == 2;
    }

    public final boolean A09(long timestampPositionFrames) {
        B7 b7 = this.A05;
        if (b7 == null || timestampPositionFrames - this.A03 < this.A04) {
            return false;
        }
        this.A03 = timestampPositionFrames;
        boolean zA03 = b7.A03();
        int i = this.A00;
        if (i == 0) {
            if (!zA03) {
                if (timestampPositionFrames - this.A02 > 500000) {
                    A01(3);
                    return zA03;
                }
                return zA03;
            }
            if (this.A05.A02() >= this.A02) {
                this.A01 = this.A05.A01();
                String[] strArr = A06;
                if (strArr[1].length() != strArr[3].length()) {
                    A01(1);
                    return zA03;
                }
                String[] strArr2 = A06;
                strArr2[5] = "X7O";
                strArr2[4] = "dhv";
                A01(1);
                return zA03;
            }
            return false;
        }
        if (i == 1) {
            if (!zA03) {
                A06();
                return zA03;
            }
            if (this.A05.A01() > this.A01) {
                A01(2);
                return zA03;
            }
            return zA03;
        }
        if (i == 2) {
            if (!zA03) {
                A06();
                return zA03;
            }
            return zA03;
        }
        if (i == 3) {
            if (zA03) {
                A06();
                return zA03;
            }
            return zA03;
        }
        String[] strArr3 = A06;
        if (strArr3[0].length() != strArr3[7].length()) {
            throw new RuntimeException();
        }
        String[] strArr4 = A06;
        strArr4[5] = "KBr";
        strArr4[4] = "FWj";
        if (i != 4) {
            throw new IllegalStateException();
        }
        return zA03;
    }
}
