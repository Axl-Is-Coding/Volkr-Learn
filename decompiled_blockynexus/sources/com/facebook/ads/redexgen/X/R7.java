package com.facebook.ads.redexgen.X;

import java.util.Arrays;
import java.util.Iterator;
import org.json.JSONException;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class R7 extends KT {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ String A00;

    static {
        A03();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = (bArrCopyOfRange[i4] - i3) - 47;
            if (A02[6].charAt(27) != 'c') {
                throw new RuntimeException();
            }
            String[] strArr = A02;
            strArr[5] = "CuQnTMvQt2iEBPylhK7T15";
            strArr[1] = "FSZFy24WJ9CShZHmahty6u";
            bArrCopyOfRange[i4] = (byte) i5;
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        if (A02[6].charAt(27) != 'c') {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[3] = "LuOw";
        strArr[3] = "LuOw";
        A01 = new byte[]{-99, -87, -100, -88, -84, -100, -91, -102, -80, -106, -102, -104, -89, -89, -96, -91, -98};
    }

    public static void A03() {
        A02 = new String[]{"CdCLIQRd", "Gozok8EGiq89CC7S8QZsNr", "pl5lQHAXyLio1ost", "M44cRouQCRL7K0vypo2P04DU", "Y2GzUIW8g3L", "Bs9wehYqNd3BdGUVOwkaAN", "ajmsB695tQiR2xtfKUGvlSwazulcZzs7", "Sy9bhDNhoUd7kDt0yrvFBLns12VVbk64"};
    }

    public R7(String str) {
        this.A00 = str;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        try {
            C12580t.A04.await();
            synchronized (C12580t.A00) {
                Iterator<String> itKeys = C12580t.A00.A04().keys();
                while (itKeys.hasNext()) {
                    String next = itKeys.next();
                    if (C12580t.A0J(this.A00)) {
                        C12580t.A0C((C1J) C12580t.A00.A04().get(next), next, next.equals(this.A00));
                    }
                }
                C12580t.A00.A05();
                C12580t.A0A();
            }
        } catch (InterruptedException e2) {
            C12580t.A01.A04().A8H(A00(0, 17, 8), C8Y.A0w, new C8Z(e2));
        } catch (JSONException e3) {
            C12580t.A08();
            C12580t.A01.A04().A8H(A00(0, 17, 8), C8Y.A0v, new C8Z(e3));
        }
    }
}
