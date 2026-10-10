package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.exoplayer2.offline.DownloadAction;
import com.umeng.analytics.pro.ci;
import java.io.File;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class PS {
    public static PS A09;
    public static byte[] A0A;
    public static final DownloadAction.Deserializer[] A0B;
    public EY A00;

    @Nullable
    public InterfaceC1646Hb A01;
    public File A02;
    public boolean A03;
    public final Context A04;
    public final Handler A05 = new Handler(Looper.getMainLooper());
    public final SparseArray<PQ> A06 = new SparseArray<>();
    public final Runnable A08 = new PP(this);
    public final ER A07 = new G3(this);

    public static String A07(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0A, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 103);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A0B() {
        A0A = new byte[]{-103, -69, -14, -19, -34, -20, -77, -103, -69, -3, 20, ci.m, 0, ci.l, -69, -24, 19, 27, 18, ci.n, 19, 5, 8, 9, 8, -46, -60, -9, 24, 5, 24, 9, -34, -60, 27, 72, 72, 69, 72, 4, -10, 41, 74, 55, 74, 59, ci.n, -10, -44, -31, -13, -21, 33, 36, 46, 55, -19, 33, 35, 52, 41, 47, 46, 51, -40, -37, -27, -18, -92, -37, -26, -18, -27, -29, -26, -40, -37, -22, 33, 36, 51};
    }

    static {
        A0B();
        A0B = new DownloadAction.Deserializer[]{ZR.A03};
    }

    @VisibleForTesting
    public PS(Context context, @Nullable EY ey) {
        this.A04 = context;
        if (ey != null) {
            this.A00 = ey;
            ey.A0R(this.A07);
        }
        A01().A0Q();
    }

    private EY A01() {
        if (this.A00 == null) {
            C1576Ed downloaderConstructorHelper = new C1576Ed(A03(), A02());
            this.A00 = new EY(downloaderConstructorHelper, 10, 5, new File(A06(), A07(52, 12, 89)), A0B);
            this.A00.A0R(this.A07);
        }
        return this.A00;
    }

    private InterfaceC2161ab A02() {
        return new C2Y(A07(78, 3, 89), null);
    }

    private final synchronized InterfaceC1646Hb A03() {
        if (this.A01 == null) {
            this.A01 = new C2181av(new File(A06(), A07(64, 14, 16)), new C14769s(134217728L));
        }
        return this.A01;
    }

    public static C2177ar A04(C2155aV c2155aV, InterfaceC1646Hb interfaceC1646Hb) {
        return new C2177ar(interfaceC1646Hb, c2155aV, new C2159aZ(), null, 2, null);
    }

    public static PS A05(Context context) {
        if (A09 == null) {
            A09 = new PS(context.getApplicationContext(), null);
        }
        return A09;
    }

    private File A06() {
        if (this.A02 == null) {
            this.A02 = this.A04.getCacheDir();
        }
        return this.A02;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A08() {
        for (EX ex : A01().A0T()) {
            int state = ex.A02;
            PQ pq = this.A06.get(state);
            if (pq != null) {
                int i = ex.A01;
                if (i == 2 || ex.A03 > pq.A00) {
                    String str = A07(15, 19, 61) + i + A07(0, 8, 18) + ex.A03;
                    pq.A01.A9f();
                    this.A06.remove(state);
                } else if (i == 4 || i == 3) {
                    String str2 = A07(34, 14, 111) + i;
                    pq.A01.A9o();
                    this.A06.remove(state);
                }
            }
            String str3 = A07(48, 4, 25) + state + A07(8, 7, 52) + ex.A03;
        }
    }

    private void A09() {
        if (!this.A03) {
            this.A03 = true;
            this.A05.post(this.A08);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A0A() {
        this.A05.removeCallbacks(this.A08);
        this.A03 = false;
    }

    public final HB A0E(Context context) {
        return A04(new C2155aV(context, (HX<? super HC>) null, A02()), A03());
    }

    public final void A0F(Uri uri, PR pr, long j) {
        this.A06.put(A01().A0P(new ZR(uri, false, null, null)), new PQ(pr, j, null));
        A09();
    }
}
