package com.facebook.ads.redexgen.X;

import android.hardware.Sensor;
import android.hardware.SensorManager;
import android.os.Build;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Vj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2008Vj implements C6Y {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ C2010Vl A00;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 123);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{49, 39, 44, 49, 45, 48};
    }

    public static void A02() {
        A02 = new String[]{"DYzZ33D", "FX", "1OACtFyT458udh1Nq8LtT5hKAntFdlV0", "NREy1eS", "YXbhfnB1JeAOpwzc7R5F4UgUcnERyrlo", "CB", "UiK58QgaQ3DZSY0y2Dj7Y4rAezwTtVBd", "ZsDGmeWwG8AfDaZfTpPswbVEo9CgGFmV"};
    }

    public C2008Vj(C2010Vl c2010Vl) {
        this.A00 = c2010Vl;
    }

    @Override // com.facebook.ads.redexgen.X.C6Y
    public final AbstractC14046n A58() throws Exception {
        C2010Vl c2010Vl = this.A00;
        c2010Vl.A00 = (SensorManager) c2010Vl.A01.getSystemService(A00(0, 6, 57));
        if (Build.VERSION.SDK_INT < 20) {
            return this.A00.A08(EnumC14006j.A05);
        }
        C2010Vl c2010Vl2 = this.A00;
        String[] strArr = A02;
        if (strArr[5].length() != strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A02;
        strArr2[5] = "Uf";
        strArr2[1] = "fm";
        if (c2010Vl2.A00 == null) {
            return this.A00.A08(EnumC14006j.A07);
        }
        List<Sensor> sensorList = this.A00.A00.getSensorList(-1);
        ArrayList arrayList = new ArrayList();
        Iterator<Sensor> it = sensorList.iterator();
        while (it.hasNext()) {
            arrayList.add(new C2009Vk(it.next()));
        }
        return this.A00.A0E(arrayList);
    }
}
