package com.facebook.ads.redexgen.X;

import android.os.Handler;
import android.os.Looper;
import androidx.annotation.CheckResult;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.exoplayer2.Format;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class FJ {
    public static String[] A04;
    public final int A00;

    @Nullable
    public final F6 A01;
    public final long A02;
    public final CopyOnWriteArrayList<FI> A03;

    static {
        A01();
    }

    public static void A01() {
        A04 = new String[]{"HGHzNcawqnVFgJx8ceQNwcxcn1SDkpDb", "AD2ta0a", "biSUTEi4nYJndXTTLsT", "38FOXeSW4cnwnxdXp60to", "WtyRCcfaPM", "iLolo35", "fvJAwdggv90DLF", "FbA7S8K"};
    }

    public FJ() {
        this(new CopyOnWriteArrayList(), 0, null, 0L);
    }

    public FJ(CopyOnWriteArrayList<FI> copyOnWriteArrayList, int i, @Nullable F6 f6, long j) {
        this.A03 = copyOnWriteArrayList;
        this.A00 = i;
        this.A01 = f6;
        this.A02 = j;
    }

    private long A00(long j) {
        long jA01 = C14729o.A01(j);
        if (jA01 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        long j2 = this.A02;
        if (A04[2].length() != 19) {
            throw new RuntimeException();
        }
        String[] strArr = A04;
        strArr[7] = "vQJR5ZN";
        strArr[7] = "vQJR5ZN";
        return j2 + jA01;
    }

    private void A02(Handler handler, Runnable runnable) {
        if (handler.getLooper() == Looper.myLooper()) {
            runnable.run();
        } else {
            handler.post(runnable);
        }
    }

    @CheckResult
    public final FJ A03(int i, @Nullable F6 f6, long j) {
        return new FJ(this.A03, i, f6, j);
    }

    public final void A04() {
        C1662Hr.A04(this.A01 != null);
        for (FI listenerAndHandler : this.A03) {
            A02(listenerAndHandler.A00, new F9(this, listenerAndHandler.A01));
        }
    }

    public final void A05() {
        C1662Hr.A04(this.A01 != null);
        for (FI listenerAndHandler : this.A03) {
            A02(listenerAndHandler.A00, new FA(this, listenerAndHandler.A01));
        }
    }

    public final void A06() {
        C1662Hr.A04(this.A01 != null);
        Iterator<FI> it = this.A03.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            if (A04[7].length() != 7) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[2] = "JAadAeVCHcunsRCfoQL";
            strArr[2] = "JAadAeVCHcunsRCfoQL";
            if (zHasNext) {
                FI listenerAndHandler = it.next();
                A02(listenerAndHandler.A00, new FF(this, listenerAndHandler.A01));
            } else {
                return;
            }
        }
    }

    public final void A07(int i, @Nullable Format format, int i2, @Nullable Object obj, long j) {
        A0D(new FL(1, i, format, i2, obj, A00(j), -9223372036854775807L));
    }

    public final void A08(Handler handler, FM fm) {
        C1662Hr.A03((handler == null || fm == null) ? false : true);
        this.A03.add(new FI(handler, fm));
    }

    public final void A09(FK fk, FL fl) {
        for (FI fi2 : this.A03) {
            A02(fi2.A00, new FD(this, fi2.A01, fk, fl));
        }
    }

    public final void A0A(FK fk, FL fl) {
        for (FI fi2 : this.A03) {
            A02(fi2.A00, new FC(this, fi2.A01, fk, fl));
        }
    }

    public final void A0B(FK fk, FL fl) {
        for (FI fi2 : this.A03) {
            A02(fi2.A00, new FB(this, fi2.A01, fk, fl));
        }
    }

    public final void A0C(FK fk, FL fl, IOException iOException, boolean z) {
        for (FI listenerAndHandler : this.A03) {
            A02(listenerAndHandler.A00, new FE(this, listenerAndHandler.A01, fk, fl, iOException, z));
        }
    }

    public final void A0D(FL fl) {
        for (FI fi2 : this.A03) {
            A02(fi2.A00, new FH(this, fi2.A01, fl));
        }
    }

    public final void A0E(FM fm) {
        for (FI fi2 : this.A03) {
            if (fi2.A01 == fm) {
                this.A03.remove(fi2);
            }
        }
    }

    public final void A0F(HG hg, int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2, long j3) {
        A0B(new FK(hg, j3, 0L, 0L), new FL(i, i2, format, i3, obj, A00(j), A00(j2)));
    }

    public final void A0G(HG hg, int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2, long j3, long j4, long j5) {
        A09(new FK(hg, j3, j4, j5), new FL(i, i2, format, i3, obj, A00(j), A00(j2)));
    }

    public final void A0H(HG hg, int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2, long j3, long j4, long j5) {
        A0A(new FK(hg, j3, j4, j5), new FL(i, i2, format, i3, obj, A00(j), A00(j2)));
    }

    public final void A0I(HG hg, int i, int i2, @Nullable Format format, int i3, @Nullable Object obj, long j, long j2, long j3, long j4, long j5, IOException iOException, boolean z) {
        A0C(new FK(hg, j3, j4, j5), new FL(i, i2, format, i3, obj, A00(j), A00(j2)), iOException, z);
    }
}
