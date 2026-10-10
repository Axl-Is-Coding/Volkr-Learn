package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.telephony.CellInfo;
import android.telephony.CellInfoCdma;
import android.telephony.CellInfoGsm;
import android.telephony.CellInfoLte;
import android.telephony.CellInfoWcdma;
import android.telephony.TelephonyManager;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class W8 extends C6P {
    public static byte[] A01;
    public final TelephonyManager A00;

    static {
        A05();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 60);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A01 = new byte[]{ci.m, 7, ci.l, ci.k, 4};
    }

    public W8(Context context, C13815p c13815p) {
        super(context, c13815p);
        this.A00 = (TelephonyManager) context.getSystemService(A04(0, 5, 99));
    }

    public static int A01(CellInfo cellInfo) {
        if (cellInfo != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                if (cellInfo instanceof CellInfoCdma) {
                    return ((CellInfoCdma) cellInfo).getCellSignalStrength().getLevel();
                }
                if (cellInfo instanceof CellInfoGsm) {
                    return ((CellInfoGsm) cellInfo).getCellSignalStrength().getLevel();
                }
                if (cellInfo instanceof CellInfoLte) {
                    return ((CellInfoLte) cellInfo).getCellSignalStrength().getLevel();
                }
                if (cellInfo instanceof CellInfoWcdma) {
                    return ((CellInfoWcdma) cellInfo).getCellSignalStrength().getLevel();
                }
                throw new UnsupportedOperationException(cellInfo.getClass().getSimpleName());
            }
            throw new UnsupportedOperationException();
        }
        throw new NullPointerException();
    }

    public final C6Y A0H() {
        return new C2023Vy(this);
    }

    @SuppressLint({"MissingPermission", "CatchGeneralException"})
    public final C6Y A0I() {
        return new C2024Vz(this);
    }

    public final C6Y A0J() {
        return new W3(this);
    }

    public final C6Y A0K() {
        return new W4(this);
    }

    public final C6Y A0L() {
        return new W2(this);
    }

    public final C6Y A0M() {
        return new W1(this);
    }

    public final C6Y A0N() {
        return new W7(this);
    }

    public final C6Y A0O() {
        return new C2020Vv(this);
    }

    public final C6Y A0P() {
        return new W5(this);
    }

    public final C6Y A0Q() {
        return new W6(this);
    }

    public final C6Y A0R() {
        return new C2021Vw(this);
    }

    public final C6Y A0S() {
        return new C2022Vx(this);
    }

    @SuppressLint({"MissingPermission", "CatchGeneralException"})
    public final C6Y A0T() {
        return new W0(this);
    }
}
