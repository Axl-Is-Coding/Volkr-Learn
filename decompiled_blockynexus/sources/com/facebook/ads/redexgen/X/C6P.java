package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import javax.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.6P, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C6P {
    public static byte[] A03;
    public static String[] A04;
    public final Context A00;
    public final Intent A01;
    public final C13815p A02;

    static {
        A02();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 8);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A03 = new byte[]{-114, -101, -111, -97, -100, -106, -111, 91, -106, -101, -95, -110, -101, -95, 91, -114, -112, -95, -106, -100, -101, 91, 111, 110, -127, -127, 114, 127, -122, -116, 112, 117, 110, 123, 116, 114, 113};
    }

    public static void A02() {
        A04 = new String[]{"o84FpHzEZxPfIbBPVc3PyJBEasuCfO6c", "JrI1dU8TTdtObirIwzr9PDFTf", "Oz2bxznKOZIoYiu00r0tMjRqahT5L8eX", "WyAMbI9dOM56rsavBzGbIzP4LEeOBa2a", "QAd1wzNDoH5I97BQWX3GR9O2v", "PJ66RTAVo3tttPzwttyvOY4w2twOeZmh", "FZtFZJQ3MyLobIqHR00oY", "wJgkVVpmtRvVSLM2dL7kjEoPPerdmE0p"};
    }

    public C6P(Context context, C13815p c13815p) {
        this.A00 = context;
        this.A02 = c13815p;
        this.A01 = this.A00.registerReceiver(null, new IntentFilter(A00(0, 37, 37)));
    }

    @Nullable
    public final C14026l A03() {
        if (this.A02.A0a() == EnumC13936c.A0G) {
            return null;
        }
        Context context = this.A00;
        String[] strArr = A04;
        if (strArr[6].length() == strArr[1].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[2] = "BdLEpYuR7vP7Yavjfaa4glVMZlrsrS6q";
        strArr2[2] = "BdLEpYuR7vP7Yavjfaa4glVMZlrsrS6q";
        C14026l signalValueContext = new C14026l(context == null ? A00(0, 0, 34) : context.getPackageName());
        return signalValueContext;
    }

    public final AbstractC14046n A04(float f2) {
        return new WN(SystemClock.elapsedRealtime(), A03(), f2);
    }

    public final AbstractC14046n A05(int i) {
        return new WP(SystemClock.elapsedRealtime(), A03(), i);
    }

    public final AbstractC14046n A06(int i, HashMap<String, String> map) {
        if (this.A01 != null) {
            HashMap<String, Integer> map2 = new HashMap<>();
            for (String str : map.keySet()) {
                String[] strArr = A04;
                if (strArr[7].length() != strArr[0].length()) {
                    throw new RuntimeException();
                }
                String[] strArr2 = A04;
                strArr2[2] = "InQCvX9bMvCeYEwlTxFUxsBs8sRyWh3b";
                strArr2[2] = "InQCvX9bMvCeYEwlTxFUxsBs8sRyWh3b";
                Intent intent = this.A01;
                String key = map.get(str);
                map2.put(str, Integer.valueOf(intent.getIntExtra(key, i)));
            }
            return A0D(map2);
        }
        return A08(EnumC14006j.A07);
    }

    public final AbstractC14046n A07(long j) {
        return new WR(SystemClock.elapsedRealtime(), A03(), j);
    }

    public final AbstractC14046n A08(EnumC14006j enumC14006j) {
        return new WM(SystemClock.elapsedRealtime(), A03(), new C14016k(enumC14006j));
    }

    public final AbstractC14046n A09(String str) {
        return new WU(SystemClock.elapsedRealtime(), A03(), str);
    }

    public final AbstractC14046n A0A(String str) {
        Intent intent = this.A01;
        if (intent != null) {
            return A09(intent.getStringExtra(str));
        }
        return A08(EnumC14006j.A07);
    }

    public final AbstractC14046n A0B(String str, int i) {
        Intent intent = this.A01;
        if (intent != null) {
            int intExtra = intent.getIntExtra(str, i);
            if (A04[4].length() == 16) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[2] = "oU3Fbet9HTJlYuGSJV9pu56iNwFexhrg";
            strArr[2] = "oU3Fbet9HTJlYuGSJV9pu56iNwFexhrg";
            return A05(intExtra);
        }
        return A08(EnumC14006j.A07);
    }

    public final AbstractC14046n A0C(String str, boolean z) {
        Intent intent = this.A01;
        if (intent != null) {
            return A0G(intent.getBooleanExtra(str, z));
        }
        return A08(EnumC14006j.A07);
    }

    public final AbstractC14046n A0D(HashMap<String, Integer> map) {
        return new WO(SystemClock.elapsedRealtime(), A03(), map);
    }

    public final AbstractC14046n A0E(List<InterfaceC13956e> list) {
        return new WQ(SystemClock.elapsedRealtime(), A03(), list, EnumC14036m.A03);
    }

    public final AbstractC14046n A0F(List<String> resultList) {
        return new WQ(SystemClock.elapsedRealtime(), A03(), resultList, EnumC14036m.A0C);
    }

    public final AbstractC14046n A0G(boolean z) {
        return new WK(SystemClock.elapsedRealtime(), A03(), z);
    }
}
