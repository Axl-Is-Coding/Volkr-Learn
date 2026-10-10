package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.hardware.Sensor;
import android.os.Build;
import java.util.Arrays;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vk, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2009Vk implements InterfaceC13956e {
    public static byte[] A0K;
    public static String[] A0L;
    public final float A00;
    public final float A01;
    public final float A02;
    public final int A03;
    public final int A04;
    public final int A05;
    public final int A06;
    public final int A07;
    public final String A0I;
    public final String A0J;
    public final String A08 = A00(0, 2, 111);
    public final String A0A = A00(8, 2, 66);
    public final String A0B = A00(5, 3, 111);
    public final String A09 = A00(2, 3, 21);
    public final String A0C = A00(10, 1, 23);
    public final String A0D = A00(11, 1, 108);
    public final String A0E = A00(12, 1, 75);
    public final String A0F = A00(13, 1, 46);
    public final String A0G = A00(14, 3, 81);
    public final String A0H = A00(17, 3, 106);

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A0K, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 122);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A0K = new byte[]{82, 77, -4, -16, -13, 86, 82, 77, 41, 46, -1, 86, 55, 28, 65, 48, 57, 90, 73, 86};
    }

    public static void A02() {
        A0L = new String[]{"iPG1t32u874St7saALvPvxyWeud", "UrmxquXQt8SfDHHjv0dMI1nlqdR4ATyp", "1qXrL8O5q0BtdOAQ3yRptFreZlLrEwpP", "MK9C1gjsPA1p5Mh8DRiOt3aRaZeKw74T", "74UXn4Y4KHUBem1ECJoYPrjerGw", "gVPzEamFaNsCYwnWJNQa", "5P5tuwqKsm7DtqkVVW9zJW12Xln", "iYOHX"};
    }

    public C2009Vk(Sensor sensor) {
        this.A03 = Build.VERSION.SDK_INT < 24 ? 0 : sensor.getId();
        this.A04 = Build.VERSION.SDK_INT >= 21 ? sensor.getMaxDelay() : 0;
        this.A00 = sensor.getMaximumRange();
        this.A05 = sensor.getMinDelay();
        this.A0I = sensor.getName();
        this.A01 = sensor.getPower();
        this.A02 = sensor.getResolution();
        this.A06 = sensor.getType();
        this.A0J = sensor.getVendor();
        this.A07 = sensor.getVersion();
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13956e
    public final boolean A7o(Object obj) {
        C2009Vk c2009Vk = (C2009Vk) obj;
        if (this.A03 == c2009Vk.A03 && this.A04 == c2009Vk.A04 && Math.abs(this.A00 - c2009Vk.A00) < C13815p.A01() && this.A05 == c2009Vk.A05 && C14136w.A0G(this.A0I, c2009Vk.A0I) && Math.abs(this.A01 - c2009Vk.A01) < C13815p.A01() && Math.abs(this.A02 - c2009Vk.A02) < C13815p.A01() && this.A06 == c2009Vk.A06 && C14136w.A0G(this.A0J, c2009Vk.A0J)) {
            int i = this.A07;
            int i2 = c2009Vk.A07;
            String[] strArr = A0L;
            if (strArr[5].length() == strArr[0].length()) {
                throw new RuntimeException();
            }
            String[] strArr2 = A0L;
            strArr2[4] = "On2LWhQKLGEDne7oiFngrXws7ig";
            strArr2[6] = "R1w6gEdPq16FSKrzDdwcQQ9VOsn";
            if (i == i2) {
                return true;
            }
        }
        return false;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13956e
    public final int ADV() {
        return A00(0, 2, 111).length() + 4 + A00(2, 3, 21).length() + 4 + A00(8, 2, 66).length() + 4 + A00(5, 3, 111).length() + 4 + A00(10, 1, 23).length() + this.A0I.length() + A00(11, 1, 108).length() + 4 + A00(12, 1, 75).length() + 4 + A00(13, 1, 46).length() + 4 + A00(14, 3, 81).length() + this.A0J.length() + A00(17, 3, 106).length() + 4;
    }

    @Override // com.facebook.ads.redexgen.X.InterfaceC13956e
    @SuppressLint({"CatchGeneralException"})
    public final JSONObject ADo() throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A00(0, 2, 111), this.A03);
            jSONObject.put(A00(2, 3, 21), this.A04);
            jSONObject.put(A00(8, 2, 66), this.A00);
            jSONObject.put(A00(5, 3, 111), this.A05);
            jSONObject.put(A00(10, 1, 23), this.A0I);
            jSONObject.put(A00(11, 1, 108), this.A01);
            jSONObject.put(A00(12, 1, 75), this.A02);
            jSONObject.put(A00(13, 1, 46), this.A06);
            jSONObject.put(A00(14, 3, 81), this.A0J);
            jSONObject.put(A00(17, 3, 106), this.A07);
        } catch (Throwable th) {
            AnonymousClass61.A04(th);
        }
        return jSONObject;
    }
}
