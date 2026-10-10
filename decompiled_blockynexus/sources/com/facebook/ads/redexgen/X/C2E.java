package com.facebook.ads.redexgen.X;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.umeng.analytics.pro.ci;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.2E, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C2E {
    public static C2E A05;
    public static byte[] A06;
    public static String[] A07;
    public static final Object A08;
    public final Context A00;
    public final Handler A01;
    public final HashMap<BroadcastReceiver, ArrayList<C2D>> A04 = new HashMap<>();
    public final HashMap<String, ArrayList<C2D>> A03 = new HashMap<>();
    public final ArrayList<C2C> A02 = new ArrayList<>();

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A06, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 80);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A06 = new byte[]{-116, -116, -78, -43, -40, -32, -47, -34, -116, -48, -43, -48, -116, -38, -37, -32, -116, -39, -51, -32, -49, -44, -90, -116, -111, -111, -73, -38, -35, -27, -42, -29, -111, -34, -46, -27, -44, -39, -42, -43, -110, -111, -111, -34, -46, -27, -44, -39, -82, -95, -23, -102, -23, -32, -102, -29, -24, -18, -33, -24, -18, -102, 126, -47, -63, -58, -61, -53, -61, 126, -88, -54, -37, -48, -42, -43, -121, -45, -48, -38, -37, -95, -121, 27, 62, 50, 48, 59, 17, 65, 62, 48, 51, 50, 48, 66, 67, 28, 48, 61, 48, 54, 52, 65, -51, -31, -12, -29, -24, -23, -18, -25, -96, -31, -25, -31, -23, -18, -13, -12, -96, -26, -23, -20, -12, -27, -14, -96, -80, -61, -47, -51, -54, -44, -57, -52, -59, 126, -46, -41, -50, -61, 126, -19, -17, 0, -11, -5, -6, -3, -5, ci.l, -1, 1, 9, 12, 19, 9, 6, 25, 6, 29, 34, 25, ci.l, -53, -60, -63, -60, -59, -51, -60, 118, -56, -69, -73, -55, -59, -60};
    }

    public static void A04() {
        A07 = new String[]{"JAgQ2spdQpH8xKgxtQcQLLz6sgGCkpe2", "SMfU9IuS4ycu6Y2ZHRBSqn3aWPXKMTOT", "55l84Ag1V6wgeVOPN73gijnv7nIwTIEx", "eOq258YlCb1TEbA", "VJMc46I8NXWnx7x8GW3WGk3ASQlYYFHT", "LoC5Exa7K60en74lmCNTJxDot4v0o8bM", "KRpLxkqJYlgWqGJZ48eoA1wpDd5KWG89", "Gt8Vn0C4eF81I9TsnyjdaH21jMiVX3Ky"};
    }

    static {
        A04();
        A03();
        A08 = new Object();
    }

    public C2E(Context context) {
        this.A00 = context;
        final Looper mainLooper = context.getMainLooper();
        this.A01 = new Handler(mainLooper) { // from class: com.facebook.ads.redexgen.X.2B
            @Override // android.os.Handler
            public final void handleMessage(Message message) {
                if (message.what != 1) {
                    super.handleMessage(message);
                } else {
                    this.A00.A02();
                }
            }
        };
    }

    public static C2E A00(Context context) {
        C2E c2e;
        synchronized (A08) {
            if (A05 == null) {
                A05 = new C2E(context.getApplicationContext());
            }
            c2e = A05;
        }
        return c2e;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A02() {
        C2C[] c2cArr;
        while (true) {
            synchronized (this.A04) {
                int size = this.A02.size();
                if (size > 0) {
                    c2cArr = new C2C[size];
                    this.A02.toArray(c2cArr);
                    this.A02.clear();
                } else {
                    return;
                }
            }
            for (C2C c2c : c2cArr) {
                int size2 = c2c.A01.size();
                for (int i = 0; i < size2; i++) {
                    C2D c2d = c2c.A01.get(i);
                    if (!c2d.A01) {
                        c2d.A02.onReceive(this.A00, c2c.A00);
                    }
                }
            }
        }
    }

    public final void A06(BroadcastReceiver broadcastReceiver) {
        synchronized (this.A04) {
            ArrayList<C2D> arrayListRemove = this.A04.remove(broadcastReceiver);
            if (arrayListRemove == null) {
                return;
            }
            for (int size = arrayListRemove.size() - 1; size >= 0; size--) {
                C2D c2d = arrayListRemove.get(size);
                c2d.A01 = true;
                for (int i = 0; i < c2d.A03.countActions(); i++) {
                    String action = c2d.A03.getAction(i);
                    ArrayList<C2D> arrayList = this.A03.get(action);
                    if (arrayList != null) {
                        for (int size2 = arrayList.size() - 1; size2 >= 0; size2--) {
                            C2D c2d2 = arrayList.get(size2);
                            if (c2d2.A02 == broadcastReceiver) {
                                c2d2.A01 = true;
                                arrayList.remove(size2);
                            }
                        }
                        if (arrayList.size() <= 0) {
                            this.A03.remove(action);
                        }
                    }
                }
            }
        }
    }

    public final void A07(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        synchronized (this.A04) {
            C2D c2d = new C2D(intentFilter, broadcastReceiver);
            ArrayList<C2D> arrayList = this.A04.get(broadcastReceiver);
            if (arrayList == null) {
                arrayList = new ArrayList<>(1);
                this.A04.put(broadcastReceiver, arrayList);
            }
            arrayList.add(c2d);
            for (int i = 0; i < intentFilter.countActions(); i++) {
                String action = intentFilter.getAction(i);
                ArrayList<C2D> arrayList2 = this.A03.get(action);
                if (arrayList2 == null) {
                    arrayList2 = new ArrayList<>(1);
                    this.A03.put(action, arrayList2);
                }
                arrayList2.add(c2d);
            }
        }
    }

    /* JADX WARN: Incorrect condition in loop: B:64:0x01be */
    /* JADX WARN: Removed duplicated region for block: B:45:0x014d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x016a A[Catch: all -> 0x01ea, TryCatch #0 {, blocks: (B:4:0x0005, B:16:0x0087, B:19:0x0097, B:21:0x00b0, B:23:0x00b6, B:25:0x00be, B:26:0x00d8, B:59:0x01ae, B:29:0x00de, B:32:0x00f8, B:34:0x0116, B:35:0x011b, B:51:0x0160, B:56:0x0192, B:55:0x0189, B:52:0x016a, B:53:0x0174, B:54:0x017e, B:63:0x01ba, B:65:0x01c0, B:66:0x01cc, B:68:0x01df, B:69:0x01e4, B:72:0x01e7, B:15:0x004f), top: B:78:0x0005 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean A08(android.content.Intent r23) {
        /*
            Method dump skipped, instruction units count: 493
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.C2E.A08(android.content.Intent):boolean");
    }
}
