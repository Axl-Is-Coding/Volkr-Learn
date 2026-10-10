package com.facebook.ads.redexgen.X;

import android.webkit.ConsoleMessage;
import android.webkit.WebChromeClient;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class O5 extends WebChromeClient {
    public static byte[] A01;
    public final /* synthetic */ C1872Qb A00;

    static {
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 15);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{-23, -26, -21, -30, -53, -14, -22, -33, -30, -17, -6, -14, 0, 0, -18, -12, -14, -96, -100, -94, -97, -112, -110, 118, -111};
    }

    public O5(C1872Qb c1872Qb) {
        this.A00 = c1872Qb;
    }

    public /* synthetic */ O5(C1872Qb c1872Qb, C1877Qg c1877Qg) {
        this(c1872Qb);
    }

    @Override // android.webkit.WebChromeClient
    public final boolean onConsoleMessage(ConsoleMessage consoleMessage) {
        if (consoleMessage.messageLevel() == ConsoleMessage.MessageLevel.ERROR) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put(A00(10, 7, 126), consoleMessage.message());
                jSONObject.put(A00(0, 10, 110), consoleMessage.lineNumber());
                jSONObject.put(A00(17, 8, 30), consoleMessage.sourceId());
            } catch (JSONException unused) {
            }
            String string = jSONObject.toString();
            this.A00.A0A.A03(JB.A0N, null);
            this.A00.A0G.A05(C8Y.A0q, string);
            this.A00.A08.A0A().A4t(string);
        }
        return super.onConsoleMessage(consoleMessage);
    }
}
