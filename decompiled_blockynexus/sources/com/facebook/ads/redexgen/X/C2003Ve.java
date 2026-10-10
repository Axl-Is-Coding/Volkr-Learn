package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ServiceInfo;
import android.util.Log;
import java.util.Arrays;
import javax.annotation.Nullable;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ve, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2003Ve extends C6P {
    public static byte[] A07;
    public static final String A08;
    public final Context A00;

    @Nullable
    public final PackageInfo A01;

    @Nullable
    public final PackageManager A02;
    public final C13815p A03;

    @Nullable
    public final ActivityInfo[] A04;

    @Nullable
    public final ServiceInfo[] A05;

    @Nullable
    public final String[] A06;

    public static String A06(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A07, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 119);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A07() {
        A07 = new byte[]{29, 57, 35, 35, 57, 62, 55, 112, 0, 49, 51, 59, 49, 55, 53, 112, 0, 53, 34, 61, 57, 35, 35, 57, Utf8.REPLACEMENT_BYTE, 62, 35};
    }

    static {
        A07();
        A08 = C2003Ve.class.getSimpleName();
    }

    public C2003Ve(Context context, C13815p c13815p) {
        super(context, c13815p);
        this.A00 = context;
        this.A03 = c13815p;
        this.A01 = A02(context);
        this.A02 = context.getPackageManager();
        this.A04 = A08(context);
        this.A05 = A0A(context);
        this.A06 = A0C(context);
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    private PackageInfo A02(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 4096);
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(A08, A06(0, 27, 39), e2);
            return null;
        }
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    private ActivityInfo[] A08(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 1).activities;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(A08, A06(0, 27, 39), e2);
            return null;
        }
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    private ServiceInfo[] A0A(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 4).services;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(A08, A06(0, 27, 39), e2);
            return null;
        }
    }

    @Nullable
    @SuppressLint({"BadMethodUse-android.util.Log.e"})
    private String[] A0C(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 4096).requestedPermissions;
        } catch (PackageManager.NameNotFoundException e2) {
            Log.e(A08, A06(0, 27, 39), e2);
            return null;
        }
    }

    public final C6Y A0H() {
        return new C2001Vc(this);
    }

    public final C6Y A0I() {
        return new C2000Vb(this);
    }

    public final C6Y A0J() {
        return new C2002Vd(this);
    }

    public final C6Y A0K() {
        return new C1999Va(this);
    }

    public final C6Y A0L() {
        return new VV(this);
    }

    public final C6Y A0M() {
        return new VR(this);
    }

    public final C6Y A0N() {
        return new VW(this);
    }

    public final C6Y A0O() {
        return new VZ(this);
    }

    public final C6Y A0P() {
        return new VX(this);
    }

    public final C6Y A0Q() {
        return new VY(this);
    }

    public final C6Y A0R() {
        return new VU(this);
    }

    public final C6Y A0S() {
        return new VT(this);
    }

    public final C6Y A0T() {
        return new VS(this);
    }

    public final C6Y A0U() {
        return new VP(this);
    }

    public final C6Y A0V() {
        return new VO(this);
    }

    public final C6Y A0W() {
        return new VQ(this);
    }

    public final C6Y A0X() {
        return new VM(this);
    }

    public final C6Y A0Y() {
        return new VL(this);
    }

    public final C6Y A0Z() {
        return new VN(this);
    }
}
