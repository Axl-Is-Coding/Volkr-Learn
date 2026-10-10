package com.facebook.ads.redexgen.X;

import com.facebook.ads.internal.api.BuildConfigApi;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class X8 implements C0S {
    public static byte[] A02;
    public static String[] A03;
    public final /* synthetic */ AnonymousClass87 A00;
    public final /* synthetic */ XA A01;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A03[1].length() == 17) {
                throw new RuntimeException();
            }
            String[] strArr = A03;
            strArr[0] = "QX0n3XV94OfUIkrY3aQ1mnz4DOZRMjum";
            strArr[3] = "ub6cBxCWynk8j8mrWTDov9XVsshwREvV";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 10);
            i4++;
        }
    }

    public static void A01() {
        A02 = new byte[]{104, -81, -64, -90, -105, -58, -65, -65, -74, -67, 115, -94, -101, -101, -110, -103, 103, 77, -105, -90, -68, -118, -69, -86, -77, -71, -92, -67, -52, -59, -59, -68, -61, -98, -83, -90, -90, -99, -92, -105, -92, -89, -97, -97, -99, -100};
    }

    public static void A02() {
        A03 = new String[]{"FR0EinKvOwZW2VlEpgnoVwKXeBc9ct8J", "K05aYFgFk0t0", "VOug37Y7l3ssOOXSbUnGxFzsx4hRn8wv", "z2uzga85Ski18P7nLebJhENF02V63SxL", "vQZIRiGCHJjFTe4gMXvJZpLaPtvEk1p8", "auy2W0sk", "5Z", "2337kXImyPAg9HB"};
    }

    public X8(XA xa, AnonymousClass87 anonymousClass87) {
        this.A01 = xa;
        this.A00 = anonymousClass87;
    }

    private void A03(int i, String str, JSONObject jSONObject, boolean z) {
        C8Z c8z = new C8Z(A00(4, 6, 71));
        c8z.A05(jSONObject);
        c8z.A03(1);
        c8z.A07(z);
        try {
            jSONObject.put(A00(33, 13, 46), C8S.A0I(this.A00));
        } catch (JSONException unused) {
        }
        this.A00.A04().A8I(A00(27, 6, 77), i + 4000, c8z);
        if (BuildConfigApi.isDebug()) {
            String str2 = A00(10, 8, 35) + str + A00(0, 1, 54) + i + A00(1, 3, 124) + jSONObject.toString();
        }
    }

    @Override // com.facebook.ads.redexgen.X.C0S
    public final void A8J(C0T c0t, JSONObject jSONObject) {
        A03(c0t.A02(), c0t.toString(), jSONObject, Arrays.binarySearch(XA.A08, c0t) != -1);
        if (A03[4].charAt(26) != 'v') {
            throw new RuntimeException();
        }
        String[] strArr = A03;
        strArr[2] = "V18ABcIrH30Drbb4OI30ypEDFjLWp4Lj";
        strArr[2] = "V18ABcIrH30Drbb4OI30ypEDFjLWp4Lj";
    }

    @Override // com.facebook.ads.redexgen.X.C0S
    public final void A8U(int i, JSONObject jSONObject) {
        A03(i, A00(18, 9, 59) + i, jSONObject, false);
    }
}
