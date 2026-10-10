package com.facebook.ads.redexgen.X;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import com.facebook.ads.internal.settings.AdSharedPreferences;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.aM, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class C2146aM extends KT {
    public static byte[] A01;
    public static String[] A02;
    public final /* synthetic */ Context A00;

    static {
        A03();
        A01();
    }

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 11);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A01() {
        A01 = new byte[]{86, -123, -123, 98, 126, -125, 104, 121, -128, 107, 122, -121, -120, 126, -124, -125};
    }

    public static void A03() {
        A02 = new String[]{"562InPUOhACtlwCEtN", "R5lwX4z8RDFVh5E8umVQyGbxSoVGO", "CYUCoKvLVtAS439EMb", "ChKnavF9Nqo0oetaNymcfBGaHAWTYXo2", "g5ZzVDftJQYE4wszTnHA7JY3RdMW3", "1hyLjyvULyVtl4OO", "Eld6CqAd7cnvJnvbiWS", "Re88eRXq7VTIVsZrXxwUq3yVYBRsOkYZ"};
    }

    public C2146aM(Context context) {
        this.A00 = context;
    }

    @Override // com.facebook.ads.redexgen.X.KT
    public final void A07() {
        int iA02;
        if (C1735Kt.A02 == EnumC1734Ks.A02) {
            return;
        }
        SharedPreferences sharedPreferences = AdSharedPreferences.getSharedPreferences(this.A00);
        String strA00 = A00(0, 16, 10);
        int returnMinSdkVersion = sharedPreferences.getInt(strA00, -1);
        if (returnMinSdkVersion != -1) {
            int unused = C1735Kt.A00 = returnMinSdkVersion;
            C1735Kt.A02 = EnumC1734Ks.A02;
            return;
        }
        if (Build.VERSION.SDK_INT >= 24) {
            iA02 = C1735Kt.A03(this.A00);
        } else {
            iA02 = C1735Kt.A02(this.A00);
        }
        int unused2 = C1735Kt.A00 = iA02;
        if (A02[7].charAt(31) == 71) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[3] = "Y4NBnL2AiN9ppE2ANDhRNdYoO8WQhPKC";
        strArr[3] = "Y4NBnL2AiN9ppE2ANDhRNdYoO8WQhPKC";
        sharedPreferences.edit().putInt(strA00, iA02).commit();
        C1735Kt.A02 = EnumC1734Ks.A02;
    }
}
