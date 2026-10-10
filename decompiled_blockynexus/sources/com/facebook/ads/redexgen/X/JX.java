package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.mirror.NativeViewabilityLogger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class JX implements Runnable {
    public static byte[] A03;
    public final /* synthetic */ AnonymousClass87 A00;
    public final /* synthetic */ C1695Ja A01;
    public final /* synthetic */ String A02;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 121);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{3, 27, 5, 60, 61, 39, 32, 59, 38, 45, 89, 78, 91, 68, 89, 95, 66, 69, 76, 54, 33, 53, 49, 33, 55, 48, 27, 45, 32};
    }

    public JX(C1695Ja c1695Ja, String str, AnonymousClass87 anonymousClass87) {
        this.A01 = c1695Ja;
        this.A02 = str;
        this.A00 = anonymousClass87;
    }

    @Override // java.lang.Runnable
    public final void run() throws Throwable {
        ArrayList<NativeViewabilityLogger.ViewabilityRecord> clone;
        if (KL.A02(this)) {
            return;
        }
        try {
            C8Z c8z = new C8Z(A00(0, 3, 52));
            JSONObject jSONObject = new JSONObject();
            JSONArray jSONArray = new JSONArray();
            jSONObject.put(A00(3, 7, 45), jSONArray);
            jSONObject.put(A00(19, 10, 61), this.A02);
            synchronized (this.A01.A0D) {
                clone = new ArrayList<>(this.A01.A0D);
                this.A01.A0D.clear();
            }
            Iterator<NativeViewabilityLogger.ViewabilityRecord> it = clone.iterator();
            while (it.hasNext()) {
                JZ jz = (JZ) it.next();
                jSONArray.put(A00(0, 0, 60) + jz.A00 + ';' + jz.A02 + ';' + jz.A01);
            }
            c8z.A05(jSONObject);
            c8z.A03(1);
            this.A00.A04().A8I(A00(10, 9, 82), C8Y.A24, c8z);
        } catch (JSONException unused) {
        } catch (Throwable th) {
            KL.A00(th, this);
        }
    }
}
