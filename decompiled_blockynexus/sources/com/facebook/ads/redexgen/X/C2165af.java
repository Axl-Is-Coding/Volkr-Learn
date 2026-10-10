package com.facebook.ads.redexgen.X;

import android.os.Looper;
import android.os.SystemClock;
import androidx.annotation.Nullable;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.af, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2165af implements HU {
    public static String[] A03;
    public HO<? extends HP> A00;
    public IOException A01;
    public final ExecutorService A02;

    static {
        A04();
    }

    public static void A04() {
        A03 = new String[]{"zA1HDLVhPd9PsL9PenCbpcrAKXxlN0d6", "FLS1DqH1RbizqOpj", "1z8O9NEtb5xyjYGA", "8w8GUSv0BTEQmaLhHrYTkFjQIFXWxu0p", "o1jGjvwpoOOHSDmJh0w1BZ4ZQReO8O7V", "", "IXAYHKYtOagUrLCRc2OBPi2ErH2JE5Q2", "ufrZt7t49gDVq6vRzV1VlqPqnp3Kfu3W"};
    }

    public C2165af(String str) {
        this.A02 = IW.A0T(str);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.HN != com.facebook.ads.internal.exoplayer2.upstream.Loader$Callback<T extends com.facebook.ads.redexgen.X.HP> */
    public final <T extends HP> long A05(T loadable, HN<T> hn, int i) {
        Looper looperMyLooper = Looper.myLooper();
        C1662Hr.A04(looperMyLooper != null);
        this.A01 = null;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        new HO(this, looperMyLooper, loadable, hn, i, jElapsedRealtime).A06(0L);
        return jElapsedRealtime;
    }

    public final void A06() {
        this.A00.A07(false);
    }

    public final void A07(int i) throws IOException {
        IOException iOException = this.A01;
        if (iOException == null) {
            HO<? extends HP> ho = this.A00;
            if (ho != null) {
                if (A03[0].charAt(1) != 'f') {
                    String[] strArr = A03;
                    strArr[2] = "ShO16ogjgPVIHMzl";
                    strArr[1] = "8gZONBnlwtDMou1V";
                    if (i == Integer.MIN_VALUE) {
                        i = ho.A03;
                    }
                    ho.A05(i);
                    return;
                }
                throw new RuntimeException();
            }
            return;
        }
        throw iOException;
    }

    public final void A08(@Nullable HQ hq) {
        HO<? extends HP> ho = this.A00;
        if (ho != null) {
            ho.A07(true);
        }
        if (hq != null) {
            this.A02.execute(new HR(hq));
        }
        this.A02.shutdown();
    }

    public final boolean A09() {
        return this.A00 != null;
    }
}
