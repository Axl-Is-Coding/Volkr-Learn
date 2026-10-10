package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.pm.Signature;
import java.io.ByteArrayInputStream;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class U0 implements InterfaceC13966f<Integer> {
    public static byte[] A02;
    public final String A00;
    public final String A01;

    static {
        A03();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A02, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 37);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A02 = new byte[]{-38, -80, -73, -78, -69, -77, 113, 12, -53};
    }

    public U0(Signature signature) throws NoSuchAlgorithmException, CertificateException {
        this.A00 = A01(signature, EnumC14126v.A05);
        this.A01 = A01(signature, EnumC14126v.A06);
    }

    public static String A01(Signature signature, EnumC14126v enumC14126v) throws NoSuchAlgorithmException, CertificateException {
        return C14136w.A08(((X509Certificate) CertificateFactory.getInstance(A00(0, 5, 93)).generateCertificate(new ByteArrayInputStream(signature.toByteArray()))).getEncoded(), enumC14126v);
    }

    /* JADX INFO: Access modifiers changed from: private */
    @Override // com.facebook.ads.redexgen.X.InterfaceC13966f
    /* JADX INFO: renamed from: A02, reason: merged with bridge method [inline-methods] */
    public final JSONObject ADp(Integer num, JSONObject jSONObject) throws JSONException {
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put(A00(5, 2, 27), this.A00);
        jSONObject2.put(A00(7, 2, 116), this.A01);
        jSONObject.put(Integer.toString(num.intValue()), jSONObject2);
        return jSONObject;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13966f
    public final boolean A7o(Object obj) {
        String str;
        U0 u0 = (U0) obj;
        String str2 = this.A00;
        return str2 != null && str2.equals(u0.A00) && (str = this.A01) != null && str.equals(u0.A01);
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13966f
    @SuppressLint({"BadMethodUse-java.lang.String.length"})
    public final int ADV() {
        String str = this.A01;
        int length = str != null ? str.length() : 0;
        String str2 = this.A00;
        return length + (str2 != null ? str2.length() : 0);
    }
}
