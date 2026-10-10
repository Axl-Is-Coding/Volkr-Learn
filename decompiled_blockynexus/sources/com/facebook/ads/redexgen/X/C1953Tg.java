package com.facebook.ads.redexgen.X;

import android.app.ActivityManager;
import android.content.Context;
import android.content.pm.ConfigurationInfo;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import javax.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Tg, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C1953Tg extends C6P {
    public static byte[] A04;

    @Nullable
    public ConfigurationInfo A00;
    public final ActivityManager.RunningAppProcessInfo A01;
    public final ActivityManager A02;
    public final Context A03;

    static {
        A05();
    }

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 6);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        A04 = new byte[]{ci.k, ci.m, 24, 5, 26, 5, 24, 21};
    }

    public C1953Tg(Context context, C13815p c13815p) {
        super(context, c13815p);
        this.A03 = context;
        this.A02 = (ActivityManager) this.A03.getSystemService(A04(0, 8, 106));
        ActivityManager activityManager = this.A02;
        if (activityManager != null) {
            this.A00 = activityManager.getDeviceConfigurationInfo();
        }
        this.A01 = new ActivityManager.RunningAppProcessInfo();
    }

    public final C6Y A0H() {
        return new C1950Td(this);
    }

    public final C6Y A0I() {
        return new C1951Te(this);
    }

    public final C6Y A0J() {
        return new TZ(this);
    }

    public final C6Y A0K() {
        return new C1947Ta(this);
    }

    public final C6Y A0L() {
        return new C1948Tb(this);
    }

    public final C6Y A0M() {
        return new TY(this);
    }

    public final C6Y A0N() {
        return new C1949Tc(this);
    }

    public final C6Y A0O() {
        return new TX(this);
    }

    public final C6Y A0P() {
        return new C1952Tf(this);
    }

    public final C6Y A0Q() {
        return new TV(this);
    }

    public final C6Y A0R() {
        return new TW(this);
    }
}
