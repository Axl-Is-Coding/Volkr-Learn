package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.redexgen.X.HP;
import java.io.IOException;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@SuppressLint({"HandlerLeak"})
public final class HO<T extends HP> extends Handler implements Runnable {
    public static byte[] A0A;
    public int A00;

    @Nullable
    public HN<T> A01;
    public IOException A02;
    public final int A03;
    public final long A04;
    public final T A05;
    public volatile Thread A06;
    public volatile boolean A07;
    public volatile boolean A08;
    public final /* synthetic */ C2165af A09;

    static {
        A04();
    }

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 16);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A04() {
        A0A = new byte[]{-96, -61, -75, -72, -88, -75, -57, -65, -113, -75, -76, -113, -90, -115, -91, -83, -81, -78, -71, 96, -91, -78, -78, -81, -78, 96, -84, -81, -95, -92, -87, -82, -89, 96, -77, -76, -78, -91, -95, -83, -70, -45, -54, -35, -43, -54, -56, -39, -54, -55, -123, -54, -41, -41, -44, -41, -123, -47, -44, -58, -55, -50, -45, -52, -123, -40, -39, -41, -54, -58, -46, -87, -62, -71, -52, -60, -71, -73, -56, -71, -72, 116, -71, -52, -73, -71, -60, -56, -67, -61, -62, 116, -68, -75, -62, -72, -64, -67, -62, -69, 116, -64, -61, -75, -72, 116, -73, -61, -63, -60, -64, -71, -56, -71, -72, -38, -13, -22, -3, -11, -22, -24, -7, -22, -23, -91, -22, -3, -24, -22, -11, -7, -18, -12, -13, -91, -15, -12, -26, -23, -18, -13, -20, -91, -8, -7, -9, -22, -26, -14, -94, -91, -105, -102, 112};
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HN != com.facebook.ads.internal.exoplayer2.upstream.Loader$Callback<T extends com.facebook.ads.redexgen.X.HP> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HO != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.HP> */
    public HO(C2165af c2165af, Looper looper, T loadable, HN<T> hn, int i, long j) {
        super(looper);
        this.A09 = c2165af;
        this.A05 = loadable;
        this.A01 = hn;
        this.A03 = i;
        this.A04 = j;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HO != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.HP> */
    private long A00() {
        return Math.min((this.A00 - 1) * 1000, 5000);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HO != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.HP> */
    private void A02() {
        this.A02 = null;
        this.A09.A02.execute(this.A09.A00);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HO != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.HP> */
    private void A03() {
        this.A09.A00 = null;
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HO != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.HP> */
    public final void A05(int i) throws IOException {
        IOException iOException = this.A02;
        if (iOException == null || this.A00 <= i) {
        } else {
            throw iOException;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HO != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.HP> */
    public final void A06(long j) {
        C1662Hr.A04(this.A09.A00 == null);
        this.A09.A00 = this;
        if (j > 0) {
            sendEmptyMessageDelayed(0, j);
        } else {
            A02();
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HO != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.HP> */
    public final void A07(boolean z) {
        this.A08 = z;
        this.A02 = null;
        if (hasMessages(0)) {
            removeMessages(0);
            if (!z) {
                sendEmptyMessage(1);
            }
        } else {
            this.A07 = true;
            this.A05.A3y();
            if (this.A06 != null) {
                this.A06.interrupt();
            }
        }
        if (z) {
            A03();
            long jElapsedRealtime = SystemClock.elapsedRealtime();
            this.A01.AAG(this.A05, jElapsedRealtime, jElapsedRealtime - this.A04, true);
            this.A01 = null;
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HO != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.HP> */
    @Override // android.os.Handler
    public final void handleMessage(Message message) throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (this.A08) {
                return;
            }
            if (message.what == 0) {
                A02();
                return;
            }
            if (message.what != 4) {
                A03();
                long jElapsedRealtime = SystemClock.elapsedRealtime();
                long j = jElapsedRealtime - this.A04;
                if (this.A07) {
                    this.A01.AAG(this.A05, jElapsedRealtime, j, false);
                    return;
                }
                int i = message.what;
                if (i == 1) {
                    this.A01.AAG(this.A05, jElapsedRealtime, j, false);
                    return;
                }
                if (i == 2) {
                    try {
                        this.A01.AAI(this.A05, jElapsedRealtime, j);
                        return;
                    } catch (RuntimeException e2) {
                        Log.e(A01(0, 8, 68), A01(71, 44, 68), e2);
                        this.A09.A01 = new HT(e2);
                        return;
                    }
                }
                if (i != 3) {
                    return;
                }
                this.A02 = (IOException) message.obj;
                int iAAJ = this.A01.AAJ(this.A05, jElapsedRealtime, j, this.A02);
                if (iAAJ != 3) {
                    if (iAAJ == 2) {
                        return;
                    }
                    this.A00 = iAAJ == 1 ? 1 : this.A00 + 1;
                    A06(A00());
                    return;
                }
                this.A09.A01 = this.A02;
                return;
            }
            throw ((Error) message.obj);
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HO != com.facebook.ads.internal.exoplayer2.upstream.Loader$LoadTask<T extends com.facebook.ads.redexgen.X.HP> */
    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        String strA01 = A01(0, 8, 68);
        if (KL.A02(this)) {
            return;
        }
        try {
            try {
                try {
                    try {
                        try {
                            this.A06 = Thread.currentThread();
                            if (!this.A07) {
                                IT.A02(A01(150, 5, 38) + this.A05.getClass().getSimpleName());
                                try {
                                    this.A05.A84();
                                } finally {
                                    IT.A00();
                                }
                            }
                            if (!this.A08) {
                                sendEmptyMessage(2);
                            }
                        } catch (IOException e2) {
                            if (!this.A08) {
                                obtainMessage(3, e2).sendToTarget();
                            }
                        }
                    } catch (Exception e3) {
                        Log.e(strA01, A01(115, 35, 117), e3);
                        if (!this.A08) {
                            obtainMessage(3, new HT(e3)).sendToTarget();
                        }
                    }
                } catch (OutOfMemoryError e4) {
                    Log.e(strA01, A01(8, 32, 48), e4);
                    if (!this.A08) {
                        obtainMessage(3, new HT(e4)).sendToTarget();
                    }
                }
            } catch (Error e5) {
                Log.e(strA01, A01(40, 31, 85), e5);
                if (!this.A08) {
                    obtainMessage(4, e5).sendToTarget();
                }
                throw e5;
            } catch (InterruptedException unused) {
                C1662Hr.A04(this.A07);
                if (!this.A08) {
                    sendEmptyMessage(2);
                }
            }
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
