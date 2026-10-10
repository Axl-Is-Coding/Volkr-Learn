package com.facebook.ads.redexgen.X;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.facebook.ads.internal.bridge.gms.AdvertisingId;
import com.umeng.analytics.pro.ci;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.5b, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C13675b {
    public static byte[] A00;
    public static String[] A01;
    public static final String A02;

    public static String A04(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A00, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 58);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A05() {
        byte[] bArr = {112, 82, 93, 93, 92, 71, 19, 84, 86, 71, 19, 82, 87, 69, 86, 65, 71, 90, 64, 90, 93, 84, 19, 90, 93, 85, 92, 19, 92, 93, 19, 94, 82, 90, 93, 19, 71, 91, 65, 86, 82, 87, 29, 91, 87, 85, 22, 95, 87, 87, 95, 84, 93, 22, 89, 86, 92, 74, 87, 81, 92, 22, 95, 85, 75, 82, 94, 92, 31, 86, 94, 94, 86, 93, 84, 31, 80, 95, 85, 67, 94, 88, 85, 31, 86, 92, 66, 31, 80, 85, 66, 31, 88, 85, 84, 95, 69, 88, 87, 88, 84, 67, 31, 112, 85, 71, 84, 67, 69, 88, 66, 88, 95, 86, 120, 85, 114, 93, 88, 84, 95, 69, 109, 97, 99, 32, 105, 97, 97, 105, 98, 107, 32, 111, 96, 106, 124, 97, 103, 106, 32, 105, 99, 125, 32, 111, 106, 125, 32, 103, 106, 107, 96, 122, 103, 104, 103, 107, 124, 32, 125, 107, 124, 120, 103, 109, 107, 32, 93, 90, 79, 92, 90, 18, 30, 28, 95, 22, 30, 30, 22, 29, 20, 95, ci.n, 31, 21, 3, 30, 24, 21, 95, 22, 28, 2, 95, 18, 30, 28, 28, 30, 31, 95, 54, 30, 30, 22, 29, 20, 33, 29, ci.n, 8, 34, 20, 3, 7, 24, 18, 20, 2, 36, 5, 24, 29, 67, 65, 74, 65, 86, 77, 71, 106, 104, 121, 76, 105, 123, 104, 127, 121, 100, 126, 100, 99, 106, 68, 105, 68, 99, 107, 98, 123, 121, 104, 85, 120, 33, 59, ci.m, 39, 39, 47, 36, 45, 24, 36, 41, 49, 27, 45, 58, 62, 33, 43, 45, 59, 9, 62, 41, 33, 36, 41, 42, 36, 45, 43, 49, ci.l, 43, 47, 43, 54, 3, 38, 22, 48, 35, 33, 41, 43, 44, 37, 7, 44, 35, 32, 46, 39, 38};
        if (A01[0].charAt(25) != 'L') {
            throw new RuntimeException();
        }
        String[] strArr = A01;
        strArr[7] = "5c2qL4dH8BvO0Uzn9h0t1hzuT";
        strArr[3] = "iopOujFX2mYmGwDZvEry";
        A00 = bArr;
    }

    public static void A06() {
        A01 = new String[]{"o8zuart55Bmx3Pw0EGryupigSLJoPiZx", "bq35BXrVyo2MmN2pvK0AAoIbsBJXmHFn", "Ag4UQwTEuL9TJhKNxG6", "PmxOul6ExA7xevKGmIJ7", "bJjslG0QPgIDYXjJzGe0RXJuWF5PAt6I", "GLZoSVJacutm5kJ9CSmVpuybEaBnhneX", "dIwLXajRtHFv7I4e8IdUhcaSFtkhp8vw", "TtnuuoV6cihzxwpt43jVepBLS"};
    }

    static {
        A06();
        A05();
        A02 = C5T.class.getSimpleName();
    }

    /* JADX WARN: Removed duplicated region for block: B:12:0x003b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.facebook.ads.redexgen.X.C5T A00(com.facebook.ads.redexgen.X.AnonymousClass87 r5) {
        /*
            android.os.Looper r1 = android.os.Looper.myLooper()
            android.os.Looper r0 = android.os.Looper.getMainLooper()
            if (r1 == r0) goto L50
            com.facebook.ads.redexgen.X.5T r4 = A01(r5)
            if (r4 == 0) goto L3b
            java.lang.String r0 = r4.A03()
            boolean r3 = android.text.TextUtils.isEmpty(r0)
            java.lang.String[] r1 = com.facebook.ads.redexgen.X.C13675b.A01
            r0 = 0
            r1 = r1[r0]
            r0 = 25
            char r1 = r1.charAt(r0)
            r0 = 76
            if (r1 == r0) goto L2d
            java.lang.RuntimeException r0 = new java.lang.RuntimeException
            r0.<init>()
            throw r0
        L2d:
            java.lang.String[] r2 = com.facebook.ads.redexgen.X.C13675b.A01
            java.lang.String r1 = "uy9l7RLQ2P1HyKRuXc5qKTdvpqbxTZwF"
            r0 = 4
            r2[r0] = r1
            java.lang.String r1 = "uy9l7RLQ2P1HyKRuXc5qKTdvpqbxTZwF"
            r0 = 4
            r2[r0] = r1
            if (r3 == 0) goto L3f
        L3b:
            com.facebook.ads.redexgen.X.5T r4 = A02(r5)
        L3f:
            if (r4 == 0) goto L4b
            java.lang.String r0 = r4.A03()
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 == 0) goto L4f
        L4b:
            com.facebook.ads.redexgen.X.5T r4 = A03(r5)
        L4f:
            return r4
        L50:
            java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
            r2 = 0
            r1 = 43
            r0 = 9
            java.lang.String r0 = A04(r2, r1, r0)
            r3.<init>(r0)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C13675b.A00(com.facebook.ads.redexgen.X.87):com.facebook.ads.redexgen.X.5T");
    }

    @Nullable
    @VisibleForTesting
    public static C5T A01(AnonymousClass87 anonymousClass87) {
        AdvertisingId advertisingIdInfoDirectly = AdvertisingId.getAdvertisingIdInfoDirectly(anonymousClass87);
        if (advertisingIdInfoDirectly != null) {
            return new C5T(advertisingIdInfoDirectly.getId(), advertisingIdInfoDirectly.isLimitAdTracking(), C5S.A03);
        }
        return null;
    }

    @Nullable
    @VisibleForTesting
    public static C5T A02(AnonymousClass87 anonymousClass87) {
        Object objA00;
        Method methodA02;
        Object objA002;
        boolean z = true;
        Method methodA022 = C13685c.A02(A04(173, 52, 75), A04(257, 29, 114), Context.class);
        if (methodA022 == null || (objA00 = C13685c.A00(null, methodA022, anonymousClass87)) == null || ((Integer) objA00).intValue() != 0 || (methodA02 = C13685c.A02(A04(65, 57, 11), A04(232, 20, 55), Context.class)) == null || (objA002 = C13685c.A00(null, methodA02, anonymousClass87)) == null) {
            return null;
        }
        Method methodA01 = C13685c.A01(objA002.getClass(), A04(252, 5, 38), new Class[0]);
        Method methodA012 = C13685c.A01(objA002.getClass(), A04(286, 24, 120), new Class[0]);
        if (methodA01 == null || methodA012 == null) {
            return null;
        }
        String id = (String) C13685c.A00(objA002, methodA01, new Object[0]);
        Boolean bool = (Boolean) C13685c.A00(objA002, methodA012, new Object[0]);
        if (id == null) {
            return null;
        }
        if (bool == null || !bool.booleanValue()) {
            z = false;
        }
        return new C5T(id, z, C5S.A07);
    }

    /* JADX WARN: Type inference failed for: r1v4, types: [com.facebook.ads.internal.attribution.GmsAttributionProvider$GoogleAdInfo] */
    @SuppressLint({"CatchGeneralException"})
    @VisibleForTesting
    public static C5T A03(AnonymousClass87 anonymousClass87) {
        ServiceConnectionC13665a serviceConnectionC13665a = new ServiceConnectionC13665a();
        Intent intent = new Intent(A04(122, 51, 52));
        intent.setPackage(A04(43, 22, 2));
        if (anonymousClass87.bindService(intent, serviceConnectionC13665a, 1)) {
            try {
                final IBinder iBinderA02 = serviceConnectionC13665a.A02();
                ?? r1 = new IInterface(iBinderA02) { // from class: com.facebook.ads.internal.attribution.GmsAttributionProvider$GoogleAdInfo
                    public static byte[] A01;
                    public static String[] A02;
                    public IBinder A00;

                    static {
                        A02();
                        A01();
                    }

                    public static String A00(int i, int i2, int i3) {
                        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
                        int i4 = 0;
                        while (true) {
                            int length = bArrCopyOfRange.length;
                            String[] strArr = A02;
                            if (strArr[5].length() != strArr[0].length()) {
                                throw new RuntimeException();
                            }
                            String[] strArr2 = A02;
                            strArr2[3] = "";
                            strArr2[3] = "";
                            if (i4 >= length) {
                                return new String(bArrCopyOfRange);
                            }
                            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 80);
                            i4++;
                        }
                    }

                    public static void A01() {
                        A01 = new byte[]{11, 23, 21, -42, ci.m, 23, 23, ci.m, 20, ci.k, -42, 9, 22, 12, 26, 23, 17, 12, -42, ci.m, 21, 27, -42, 9, 12, 27, -42, 17, 12, ci.k, 22, 28, 17, ci.l, 17, ci.k, 26, -42, 17, 22, 28, ci.k, 26, 22, 9, 20, -42, -15, -23, 12, 30, ci.k, 26, 28, 17, 27, 17, 22, ci.m, -15, 12, -5, ci.k, 26, 30, 17, 11, ci.k};
                    }

                    public static void A02() {
                        A02 = new String[]{"", "dlCQJjSx2v0yIAE7uR5", "YVJONne7N3U8xm", "", "eKTK4BSI8P33PVYq98zfXeBzSnXDY", "", "Oc9p6kWmaRe51UGQv0AehnzsYEIJ", "vamZVSY5oxMc9Fm9XA4FwhL"};
                    }

                    {
                        this.A00 = iBinderA02;
                    }

                    public final String A03() throws RemoteException {
                        Parcel reply = Parcel.obtain();
                        Parcel parcelObtain = Parcel.obtain();
                        try {
                            reply.writeInterfaceToken(A00(0, 68, 88));
                            this.A00.transact(1, reply, parcelObtain, 0);
                            parcelObtain.readException();
                            return parcelObtain.readString();
                        } finally {
                            parcelObtain.recycle();
                            reply.recycle();
                        }
                    }

                    public final boolean A04() throws RemoteException {
                        Parcel reply = Parcel.obtain();
                        Parcel parcelObtain = Parcel.obtain();
                        try {
                            reply.writeInterfaceToken(A00(0, 68, 88));
                            boolean z = true;
                            reply.writeInt(1);
                            this.A00.transact(2, reply, parcelObtain, 0);
                            parcelObtain.readException();
                            if (parcelObtain.readInt() == 0) {
                                z = false;
                            }
                            return z;
                        } finally {
                            parcelObtain.recycle();
                            reply.recycle();
                        }
                    }

                    @Override // android.os.IInterface
                    public final IBinder asBinder() {
                        return this.A00;
                    }
                };
                return new C5T(r1.A03(), r1.A04(), C5S.A08);
            } catch (Throwable th) {
                try {
                    anonymousClass87.A04().A8H(A04(225, 7, 30), C8Y.A18, new C8Z(th));
                } finally {
                    anonymousClass87.unbindService(serviceConnectionC13665a);
                }
            }
        }
        return null;
    }
}
