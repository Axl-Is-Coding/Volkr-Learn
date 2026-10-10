package com.facebook.ads.redexgen.X;

import android.media.AudioTrack;
import android.os.SystemClock;
import com.sandboxol.center.config.VipSubscribeStatus;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class BC {
    public static byte[] A0P;
    public static String[] A0Q;
    public int A00;
    public int A01;
    public int A02;
    public int A03;
    public int A04;
    public long A05;
    public long A06;
    public long A07;
    public long A08;
    public long A09;
    public long A0A;
    public long A0B;
    public long A0C;
    public long A0D;
    public long A0E;
    public long A0F;
    public long A0G;
    public AudioTrack A0H;
    public B9 A0I;
    public Method A0J;
    public boolean A0K;
    public boolean A0L;
    public boolean A0M;
    public final BA A0N;
    public final long[] A0O;

    static {
        A07();
        A06();
    }

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0P, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 82);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A06() {
        A0P = new byte[]{119, 117, 100, 92, 113, 100, 117, 126, 115, 105};
    }

    public static void A07() {
        A0Q = new String[]{"2OZtSKqBdCORReWjwkUHUNaFdmP57qD6", "wxnNTeBLYydyQqASc88t", "NZCt4jZqJZROeAh1myX6H7SaBhvHRhTJ", "W", "cvmaUkh2yailCvlRg0", "9zfhSGNjdoCRl8j9ORTvg70vvPJm", "N6Pae7kbdU7K2JDJ7pHsGdlVXSdZHDtL", "MG3JHDBNbYnrrwGYpH7tUB1vkoKXKxdT"};
    }

    public BC(BA ba) {
        this.A0N = (BA) C1662Hr.A01(ba);
        if (IW.A02 >= 18) {
            try {
                this.A0J = AudioTrack.class.getMethod(A03(0, 10, 66), (Class[]) null);
            } catch (NoSuchMethodException unused) {
            }
        }
        this.A0O = new long[10];
    }

    private long A00() {
        if (this.A0G != -9223372036854775807L) {
            long jElapsedRealtime = SystemClock.elapsedRealtime() * 1000;
            if (A0Q[6].charAt(23) == 'U') {
                throw new RuntimeException();
            }
            String[] strArr = A0Q;
            strArr[3] = VipSubscribeStatus.SUBSCRIPTION_PURCHASED;
            strArr[3] = VipSubscribeStatus.SUBSCRIPTION_PURCHASED;
            long j = (((long) this.A03) * (jElapsedRealtime - this.A0G)) / 1000000;
            long framesSinceStop = this.A06;
            return Math.min(framesSinceStop, this.A0F + j);
        }
        int playState = this.A0H.getPlayState();
        if (playState == 1) {
            return 0L;
        }
        long playbackHeadPosition = 4294967295L & ((long) this.A0H.getPlaybackHeadPosition());
        if (this.A0M) {
            if (playState == 2 && playbackHeadPosition == 0) {
                this.A0C = this.A0A;
            }
            playbackHeadPosition += this.A0C;
        }
        if (IW.A02 <= 28) {
            if (playbackHeadPosition == 0) {
                long j2 = this.A0A;
                if (A0Q[2].charAt(13) == 'g') {
                    throw new RuntimeException();
                }
                String[] strArr2 = A0Q;
                strArr2[7] = "Jf7te8MTt0xB0AnyTHSRJJahUuQs4RIN";
                strArr2[7] = "Jf7te8MTt0xB0AnyTHSRJJahUuQs4RIN";
                if (j2 > 0 && playState == 3) {
                    if (this.A07 == -9223372036854775807L) {
                        this.A07 = SystemClock.elapsedRealtime();
                    }
                    return this.A0A;
                }
            }
            this.A07 = -9223372036854775807L;
        }
        if (this.A0A > playbackHeadPosition) {
            this.A0D++;
        }
        this.A0A = playbackHeadPosition;
        return (this.A0D << 32) + playbackHeadPosition;
    }

    private long A01() {
        return A02(A00());
    }

    private long A02(long j) {
        return (1000000 * j) / ((long) this.A03);
    }

    private void A04() {
        long systemTimeUs = A01();
        if (systemTimeUs == 0) {
            return;
        }
        long jNanoTime = System.nanoTime() / 1000;
        if (jNanoTime - this.A09 >= com.tendcloud.tenddata.ab.R) {
            long[] jArr = this.A0O;
            int i = this.A01;
            jArr[i] = systemTimeUs - jNanoTime;
            this.A01 = (i + 1) % 10;
            int i2 = this.A04;
            if (i2 < 10) {
                int i3 = i2 + 1;
                if (A0Q[7].charAt(25) == 'h') {
                    throw new RuntimeException();
                }
                String[] strArr = A0Q;
                strArr[7] = "0ZtCyKtQlXFIE9UJw5KWgAyqZz9KpR2W";
                strArr[7] = "0ZtCyKtQlXFIE9UJw5KWgAyqZz9KpR2W";
                this.A04 = i3;
            }
            this.A09 = jNanoTime;
            this.A0E = 0L;
            int i4 = 0;
            while (true) {
                int i5 = this.A04;
                if (i4 >= i5) {
                    break;
                }
                this.A0E += this.A0O[i4] / ((long) i5);
                i4++;
            }
        }
        boolean z = this.A0M;
        if (A0Q[3].length() == 1) {
            String[] strArr2 = A0Q;
            strArr2[7] = "QKSLI2et0ddSkJpCy6yOqBE4Y3BrEDug";
            strArr2[7] = "QKSLI2et0ddSkJpCy6yOqBE4Y3BrEDug";
            if (z) {
                return;
            }
        } else if (z) {
            return;
        }
        A09(jNanoTime, systemTimeUs);
        A08(jNanoTime);
    }

    private void A05() {
        this.A0E = 0L;
        this.A04 = 0;
        this.A01 = 0;
        this.A09 = 0L;
    }

    private void A08(long j) {
        Method method;
        if (this.A0L && (method = this.A0J) != null && j - this.A08 >= 500000) {
            try {
                this.A0B = (((long) ((Integer) method.invoke(this.A0H, (Object[]) null)).intValue()) * 1000) - this.A05;
                this.A0B = Math.max(this.A0B, 0L);
                if (this.A0B > 5000000) {
                    this.A0N.AAD(this.A0B);
                    this.A0B = 0L;
                }
            } catch (Exception unused) {
                this.A0J = null;
            }
            this.A08 = j;
        }
    }

    private void A09(long j, long audioTimestampSystemTimeUs) {
        if (!this.A0I.A09(j)) {
            return;
        }
        long jA03 = this.A0I.A03();
        long audioTimestampPositionFrames = this.A0I.A02();
        if (Math.abs(jA03 - j) > 5000000) {
            this.A0N.ABN(audioTimestampPositionFrames, jA03, j, audioTimestampSystemTimeUs);
            this.A0I.A05();
        } else if (Math.abs(A02(audioTimestampPositionFrames) - audioTimestampSystemTimeUs) > 5000000) {
            this.A0N.AAt(audioTimestampPositionFrames, jA03, j, audioTimestampSystemTimeUs);
            this.A0I.A05();
        } else {
            this.A0I.A04();
        }
    }

    private boolean A0A() {
        return this.A0M && this.A0H.getPlayState() == 2 && A00() == 0;
    }

    public static boolean A0B(int i) {
        return IW.A02 < 23 && (i == 5 || i == 6);
    }

    public final int A0C(long j) {
        return this.A00 - ((int) (j - (A00() * ((long) this.A02))));
    }

    public final long A0D(boolean z) {
        long positionUs;
        if (this.A0H.getPlayState() == 3) {
            A04();
        }
        long jNanoTime = System.nanoTime();
        if (A0Q[7].charAt(25) == 'h') {
            throw new RuntimeException();
        }
        String[] strArr = A0Q;
        strArr[5] = "wFaGh6b5RiCG631f3S8Lg8JJUGkJ";
        strArr[1] = "CitVBV12pOqWvHiAj7sv";
        long j = jNanoTime / 1000;
        if (this.A0I.A07()) {
            long timestampPositionFrames = this.A0I.A02();
            long jA02 = A02(timestampPositionFrames);
            if (!this.A0I.A08()) {
                return jA02;
            }
            long timestampPositionUs = this.A0I.A03();
            return jA02 + (j - timestampPositionUs);
        }
        if (this.A04 == 0) {
            positionUs = A01();
        } else {
            long positionUs2 = this.A0E;
            positionUs = positionUs2 + j;
        }
        if (!z) {
            return positionUs - this.A0B;
        }
        return positionUs;
    }

    public final void A0E() {
        A05();
        this.A0H = null;
        this.A0I = null;
    }

    public final void A0F() {
        this.A0I.A06();
    }

    public final void A0G(long j) {
        this.A0F = A00();
        this.A0G = SystemClock.elapsedRealtime() * 1000;
        this.A06 = j;
    }

    public final void A0H(AudioTrack audioTrack, int i, int i2, int i3) {
        this.A0H = audioTrack;
        this.A02 = i2;
        this.A00 = i3;
        this.A0I = new B9(audioTrack);
        this.A03 = audioTrack.getSampleRate();
        this.A0M = A0B(i);
        this.A0L = IW.A0d(i);
        this.A05 = this.A0L ? A02(i3 / i2) : -9223372036854775807L;
        this.A0A = 0L;
        this.A0D = 0L;
        this.A0C = 0L;
        this.A0K = false;
        this.A0G = -9223372036854775807L;
        this.A07 = -9223372036854775807L;
        this.A0B = 0L;
    }

    public final boolean A0I() {
        return this.A0H.getPlayState() == 3;
    }

    public final boolean A0J() {
        A05();
        if (this.A0G == -9223372036854775807L) {
            this.A0I.A06();
            String[] strArr = A0Q;
            if (strArr[5].length() == strArr[1].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0Q;
            strArr2[5] = "GAvEeTbbpJy4dkpTDH1oMJCt3ihg";
            strArr2[1] = "Fc6P1TrRc3WwbWBQIjag";
            return true;
        }
        return false;
    }

    public final boolean A0K(long j) {
        return j > A00() || A0A();
    }

    public final boolean A0L(long j) {
        if (this.A07 != -9223372036854775807L) {
            if (A0Q[3].length() != 1) {
                throw new RuntimeException();
            }
            String[] strArr = A0Q;
            strArr[2] = "WkbNChvAjAmG4HStnLH3XRlXL7LoLVfn";
            strArr[2] = "WkbNChvAjAmG4HStnLH3XRlXL7LoLVfn";
            if (j > 0 && SystemClock.elapsedRealtime() - this.A07 >= 200) {
                return true;
            }
        }
        return false;
    }

    public final boolean A0M(long j) {
        BA ba;
        int playState = this.A0H.getPlayState();
        if (this.A0M) {
            if (playState == 2) {
                this.A0K = false;
                return false;
            }
            if (playState == 1 && A00() == 0) {
                return false;
            }
        }
        boolean z = this.A0K;
        this.A0K = A0K(j);
        if (z && !this.A0K && playState != 1 && (ba = this.A0N) != null) {
            ba.ABU(this.A00, C14729o.A01(this.A05));
        }
        return true;
    }
}
