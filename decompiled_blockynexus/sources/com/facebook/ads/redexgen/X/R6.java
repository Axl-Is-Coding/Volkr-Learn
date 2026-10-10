package com.facebook.ads.redexgen.X;

import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class R6 extends KT {
    public static byte[] A01;
    public final /* synthetic */ JSONObject A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 21);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{7, 19, 4, ci.n, 20, 4, ci.m, 2, 24, 62, 2, 0, 17, 17, 8, ci.m, 6};
    }

    public R6(JSONObject jSONObject) {
        this.A00 = jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        try {
            C12580t.A03.await();
            synchronized (C12580t.A00) {
                C12580t.A00.A0A(this.A00);
                C12580t.A04.countDown();
            }
        } catch (InterruptedException e2) {
            C12580t.A01.A04().A8H(A00(0, 17, 116), C8Y.A0w, new C8Z(e2));
        } catch (JSONException e3) {
            C12580t.A08();
            C12580t.A01.A04().A8H(A00(0, 17, 116), C8Y.A0v, new C8Z(e3));
        }
    }
}
