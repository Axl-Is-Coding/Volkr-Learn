package com.facebook.ads.redexgen.X;

import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Looper;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.Utf8;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.b5, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2191b5 implements J4 {
    public static byte[] A0D;
    public static final String A0E;
    public int A00;
    public long A01;
    public final long A02;
    public final long A03;
    public final ConnectivityManager A04;
    public final C2027Wc A06;
    public final J3 A07;
    public final InterfaceC1854Pj A08;
    public volatile boolean A0C;
    public final Runnable A0A = new C2189b3(this);
    public final Runnable A09 = new C2190b4(this);
    public final ThreadPoolExecutor A0B = new ThreadPoolExecutor(1, 1, 0, TimeUnit.MILLISECONDS, new LinkedBlockingQueue());
    public final Handler A05 = new Handler(Looper.getMainLooper());

    public static String A03(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0D, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 88);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A0D = new byte[]{-39, -22, -48, -44, -73, -36, -26, -29, -44, -25, -42, -37, -36, -31, -38, -109, -40, -23, -40, -31, -25, -109, -101, -45, 6, -15, -13, -2, 2, -9, -3, -4, -82, 5, -10, -9, -6, -13, -82, -14, -9, 1, -2, -17, 2, -15, -10, -9, -4, -11, -82, -13, 4, -13, -4, 2, 1, -68, -28, -10, 3, 7, -10, 3, -79, 1, 3, 0, -12, -10, 4, 4, -10, -11, -79, 1, -14, 3, 5, -6, -14, -3, -79, -13, -14, 5, -12, -7, -67, -79, -12, 0, -1, 5, -6, -1, 6, -6, -1, -8, -79, 5, 0, -79, -1, -10, 9, 5, -79, 0, -1, -10, -65, 27, 45, 58, 62, 45, 58, -24, 58, 45, 59, 56, 55, 54, 59, 45, -24, 49, 59, -24, 45, 53, 56, 60, 65, -10, -17, 1, ci.l, 18, 1, ci.l, -68, ci.l, 1, ci.n, 17, ci.l, 10, 1, 0, -68, -3, -68, 10, 11, 10, -55, ci.m, 17, -1, -1, 1, ci.m, ci.m, 2, 17, 8, -68, ci.m, ci.n, -3, ci.n, 17, ci.m, -68, -1, 11, 0, 1, -68, 11, 2, -68, -61, -43, -30, -26, -43, -30, -112, -25, -47, -29, -112, -27, -34, -47, -46, -36, -43, -112, -28, -33, -112, -32, -30, -33, -45, -43, -29, -29, -112, -47, -36, -36, -112, -43, -26, -43, -34, -28, -29, -100, -112, -28, -30, -23, -39, -34, -41, -112, -47, -41, -47, -39, -34, -98, -17, 7, 5, 12, 12, 5, 10, 3, -68, 0, 5, ci.m, 12, -3, ci.n, -1, 4, -68, 0, 17, 1, -68, ci.n, 11, -68, 8, -3, -1, 7, -68, 11, 2, -68, -1, 11, 10, 10, 1, -1, ci.n, 5, 18, 5, ci.n, 21, -54, -31, -12, -12, -27, -19, -16, -12, -59, -47, -48, -48, -57, -59, -42, -53, -40, -53, -42, -37, 47, 44, Utf8.REPLACEMENT_BYTE, 44, -22, -5, -22, -13, -7, -8, 36, 21, 45, 32, 35, 21, 24};
    }

    static {
        A07();
        A0E = J4.class.getSimpleName();
    }

    public C2191b5(C2027Wc c2027Wc, J3 j3) {
        this.A07 = j3;
        this.A06 = c2027Wc;
        this.A04 = (ConnectivityManager) c2027Wc.getSystemService(A03(293, 12, 10));
        this.A08 = Q1.A01(c2027Wc);
        this.A03 = J0.A0K(c2027Wc);
        this.A02 = J0.A0J(c2027Wc);
    }

    public static /* synthetic */ int A00(C2191b5 c2191b5) {
        int i = c2191b5.A00 + 1;
        c2191b5.A00 = i;
        return i;
    }

    private void A05() {
        BuildConfigApi.isDebug();
        this.A00 = 0;
        this.A01 = 0L;
        if (this.A0B.getQueue().size() == 0) {
            this.A07.A97();
        }
    }

    private void A06() {
        if (this.A00 >= J0.A09(this.A06)) {
            A05();
            A4n();
        } else {
            if (this.A00 == 1) {
                this.A01 = J0.A0I(this.A06);
            } else {
                this.A01 *= 2;
            }
            A4o();
        }
    }

    private void A08(long j) {
        this.A05.postDelayed(this.A09, j);
    }

    private void A09(JSONObject jSONObject) throws JSONException {
        for (Map.Entry<String, String> entry : this.A06.A02().A4S().entrySet()) {
            jSONObject.put(entry.getKey(), entry.getValue());
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:22:0x005b */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void A0B() {
        /*
            Method dump skipped, instruction units count: 489
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2191b5.A0B():void");
    }

    @Override // com.facebook.ads.redexgen.X.J4
    public final void A4n() {
        if (this.A0C) {
            return;
        }
        this.A0C = true;
        this.A05.removeCallbacks(this.A09);
        A08(this.A02);
    }

    @Override // com.facebook.ads.redexgen.X.J4
    public final void A4o() {
        this.A0C = true;
        this.A05.removeCallbacks(this.A09);
        A08(this.A03);
    }
}
