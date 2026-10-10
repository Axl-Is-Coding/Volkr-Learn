package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import androidx.annotation.Nullable;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicReference;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
@SuppressLint({"CatchGeneralException"})
public abstract class KT implements Runnable {
    public static byte[] A01;
    public static final AtomicBoolean A02;
    public static final AtomicBoolean A03;
    public static final AtomicReference<KJ> A04;

    @Nullable
    public final KH A00;

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 116);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A01 = new byte[]{124, 91, 64, 64, 79, 76, 66, 75, ci.l, 77, 92, 75, 79, 90, 75, 74, 0, ci.l, 122, 70, 92, 75, 79, 74, 20, ci.l};
    }

    public abstract void A07();

    static {
        A03();
        A02 = new AtomicBoolean();
        A03 = new AtomicBoolean(false);
        A04 = new AtomicReference<>();
    }

    public KT() {
        if (A03.get()) {
            this.A00 = KY.A01(new KX(A02(0, 26, 90) + Thread.currentThread().getName()));
            return;
        }
        this.A00 = null;
    }

    public static void A04(boolean z) {
        A03.set(z);
    }

    public static void A05(boolean z, KJ kj) {
        A02.set(z);
        A04.set(kj);
    }

    @Nullable
    public final KH A06() {
        return this.A00;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        if (KL.A02(this)) {
            return;
        }
        try {
            if (A03.get()) {
                KY.A04(this);
            }
            try {
                A07();
            } catch (Throwable th) {
                if (A02.get()) {
                    C1719Ka.A00().A87(3301, th);
                    KJ kj = A04.get();
                    if (kj != null) {
                        kj.ACk(th, this);
                    }
                } else {
                    throw th;
                }
            }
            if (A03.get()) {
                KY.A05(this);
            }
        } catch (Throwable t) {
            KL.A00(t, this);
        }
    }
}
