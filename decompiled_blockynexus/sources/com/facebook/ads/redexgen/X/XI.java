package com.facebook.ads.redexgen.X;

import android.os.AsyncTask;
import android.text.TextUtils;
import android.util.Log;
import androidx.annotation.Nullable;
import com.facebook.ads.internal.api.BuildConfigApi;
import com.facebook.ads.internal.util.common.Preconditions;
import com.umeng.analytics.pro.ci;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class XI implements C9E {
    public static byte[] A03;
    public static final String A04;
    public final C2027Wc A00;
    public final C9P<J2> A01;
    public final C9P<J2> A02;

    public static String A00(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 70);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        A03 = new byte[]{102, 100, 43, 34, 100, 48, 61, 52, 33, 126, 100, 24, 61, 28, 47, 60, 55, 45, 10, 45, 54, 43, 56, 62, 60, 11, 60, 58, 54, 43, 61, 29, 56, 45, 56, 59, 56, 42, 60, 105, 72, 65, 72, 89, 72, 73, ci.k, 72, 91, 72, 67, 89, 23, ci.k, ci.m, 66, 101, 109, 104, 97, 96, 36, 112, 107, 36, 103, 104, 97, 101, 118, 36, 97, 114, 97, 106, 112, 119, 36, 119, 112, 107, 118, 101, 99, 97, 97, 70, 78, 75, 66, 67, 7, 83, 72, 7, 67, 66, 84, 66, 85, 78, 70, 75, 78, 93, 66, 7, 70, 73, 7, 66, 81, 66, 73, 83, 7, 65, 85, 72, 74, 7, 67, 70, 83, 70, 69, 70, 84, 66, 7, 107, 76, 68, 65, 72, 73, ci.k, 89, 66, ci.k, 64, 66, 91, 72, ci.k, 72, 91, 72, 67, 89, 94, ci.k, 75, 95, 66, 64, ci.k, 68, 67, 0, 75, 65, 68, 74, 69, 89, ci.k, 94, 89, 66, 95, 76, 74, 72, ci.k, 79, 76, 78, 70, ci.k, 89, 66, ci.k, 72, 91, 72, 67, 89, 94, ci.k, 73, 76, 89, 76, 79, 76, 94, 72, 118, 81, 89, 92, 85, 84, ci.n, 68, 95, ci.n, 64, 81, 66, 67, 85, ci.n, 81, 94, ci.n, 85, 70, 85, 94, 68, ci.n, 86, 66, 95, 93, ci.n, 89, 94, 29, 86, 92, 89, 87, 88, 68, ci.n, 67, 68, 95, 66, 81, 87, 85, 123, 92, 84, 81, 88, 89, 29, 73, 82, 29, 79, 88, 92, 89, 29, 73, 85, 88, 29, 83, 72, 80, 95, 88, 79, 29, 82, 91, 29, 88, 75, 88, 83, 73, 78, 29, 91, 79, 82, 80, 29, 89, 92, 73, 92, 95, 92, 78, 88, 12, 43, 35, 38, 47, 46, 106, 62, 37, 106, 57, 47, 56, 35, 43, 38, 35, 48, 47, 106, 43, 46, 106, 47, 60, 47, 36, 62, 105, 78, 70, 76, 73, 71, 72, 84, ci.k, 97, 68, 101, 86, 69, 78, 84, 115, 84, 79, 82, 65, 71, 69, 114, 69, 67, 79, 82, 68, 100, 65, 84, 65, 66, 65, 83, 69, 56, ci.m, 9, 5, 24, ci.l, 74, ci.l, 11, 30, 11, 8, 11, 25, ci.m, 74, 12, 11, 3, 6, 31, 24, ci.m, 74, 5, 9, 9, 31, 24, 24, ci.m, ci.l, 74, 29, 2, ci.m, 4, 74, 24, ci.m, 11, ci.l, 3, 4, ci.k, 74, ci.m, 28, ci.m, 4, 30, 25, 68, 61, 40, 40, 57, 49, 44, 40, 28, 25, 12, 25, 47, 34, 95, 72, 78, 66, 95, 73, 114, 73, 76, 89, 76, 79, 76, 94, 72, 65, 87, 65, 65, 91, 93, 92, 109, 91, 86, 46, 56, 46, 46, 52, 50, 51, 2, 41, 52, 48, 56, 100, 121, 125, 117, 49, 42, 46, 32, 43, 88, 85, 92, 73, 12, 23, 18, 23, 22, ci.l, 23};
    }

    static {
        A03();
        A04 = XI.class.getSimpleName();
    }

    public XI(C2027Wc c2027Wc) throws IOException {
        this.A00 = c2027Wc;
        this.A01 = new XQ(C9M.A00(A00(11, 28, 31), c2027Wc), new XG(this));
        this.A02 = new XQ(C9M.A00(A00(322, 37, 102), c2027Wc), new XH(this));
    }

    private List<JSONObject> A01(List<JSONObject> list, byte[] bArr, int[] iArr) {
        int i = 0;
        for (int i2 : iArr) {
            if (i2 == 0) {
                break;
            }
            try {
                list.add(A02(bArr, i, i2));
            } catch (JSONException e2) {
                if (BuildConfigApi.isDebug()) {
                    Log.e(A04, A00(85, 45, 97), e2);
                }
                A05(C8Y.A22, e2);
            }
            i += i2;
        }
        return list;
    }

    public static JSONObject A02(byte[] bArr, int i, int i2) throws JSONException {
        return new JSONObject(new String(Arrays.copyOfRange(bArr, i, i + i2)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void A04(int i, String str) {
        C8Z c8z = new C8Z(str);
        c8z.A03(1);
        this.A00.A04().A8I(A00(425, 15, 107), i, c8z);
    }

    private void A05(int i, Throwable th) {
        this.A00.A04().A8H(A00(425, 15, 107), i, new C8Z(th));
    }

    public static byte[] A07(String str, J2 j2) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put(A00(423, 2, 0), str);
            jSONObject.put(A00(466, 5, 3), j2.A09());
            jSONObject.put(A00(471, 4, 106), j2.A07().toString());
            jSONObject.put(A00(462, 4, 86), LP.A02(j2.A05()));
            jSONObject.put(A00(450, 12, 27), LP.A02(j2.A04()));
            jSONObject.put(A00(440, 10, 116), j2.A08());
            jSONObject.put(A00(419, 4, 62), new JSONObject(j2.A0A()));
            jSONObject.put(A00(412, 7, 26), 0);
        } catch (JSONException e2) {
            if (BuildConfigApi.isDebug()) {
                Log.e(A04, A00(294, 28, 12), e2);
            }
        }
        return jSONObject.toString().getBytes();
    }

    public static byte[] A09(JSONObject jSONObject) {
        return jSONObject.toString().getBytes();
    }

    public final int A0A() {
        try {
            return this.A01.A6w();
        } catch (C9Y e2) {
            if (BuildConfigApi.isDebug()) {
                Log.e(A04, A00(245, 49, 123), e2);
                return 0;
            }
            return 0;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00e0 A[Catch: 9Y -> 0x0126, TryCatch #5 {9Y -> 0x0126, blocks: (B:33:0x00da, B:35:0x00e0, B:36:0x00ef, B:22:0x0088, B:24:0x008e, B:26:0x0094, B:27:0x00d0, B:39:0x00f8, B:40:0x00fc, B:42:0x0102, B:43:0x0112, B:44:0x0116, B:46:0x011c), top: B:61:0x00da }] */
    /* JADX WARN: Removed duplicated region for block: B:54:0x0131  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int A0B(int r13, java.util.Set<java.lang.String> r14, java.util.Set<java.lang.String> r15) {
        /*
            Method dump skipped, instruction units count: 326
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.ads.redexgen.X.XI.A0B(int, java.util.Set, java.util.Set):int");
    }

    public final List<JSONObject> A0C(int i) {
        boolean z = false;
        if (i == -1) {
            z = true;
            i = 30;
        }
        int[] iArr = new int[i];
        byte[] bArr = new byte[i * 1000];
        List<JSONObject> linkedList = new LinkedList<>();
        LinkedList linkedList2 = new LinkedList();
        try {
            C9O lastFetch = this.A01.A5B(bArr, iArr);
            linkedList2.add(lastFetch);
            int iA5C = lastFetch.A5C();
            linkedList = A01(linkedList, bArr, iArr);
            while (lastFetch.A8k() && (iA5C < i || z)) {
                if (!z) {
                    iArr = new int[i - iA5C];
                } else {
                    Arrays.fill(iArr, 0);
                }
                lastFetch = this.A01.A5B(bArr, iArr);
                linkedList2.add(lastFetch);
                linkedList = A01(linkedList, bArr, iArr);
            }
            Iterator<JSONObject> it = linkedList.iterator();
            while (it.hasNext()) {
                this.A02.ADj(A09(it.next()));
            }
            Iterator it2 = linkedList2.iterator();
            while (it2.hasNext()) {
                ((C9O) it2.next()).A4f();
            }
        } catch (C9Y e2) {
            if (BuildConfigApi.isDebug()) {
                Log.e(A04, A00(359, 53, 44), e2);
            }
            A05(C8Y.A1z, e2);
        }
        return linkedList;
    }

    @Override // com.facebook.ads.redexgen.X.C9E
    public final void A40() {
        try {
            this.A01.clear();
            this.A02.clear();
        } catch (C9Y e2) {
            if (BuildConfigApi.isDebug()) {
                Log.e(A04, A00(55, 30, 66), e2);
            }
            A05(C8Y.A1w, e2);
        }
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.9B != com.facebook.ads.internal.eventstorage.AdEventStorageCallback<java.lang.String> */
    @Override // com.facebook.ads.redexgen.X.C9E
    public final void AEE(final J2 j2, final C9B<String> c9b) {
        Executor executor = ExecutorC1744Lc.A07;
        final C9P<J2> c9p = this.A01;
        final C2027Wc c2027Wc = this.A00;
        LZ.A00(executor, new AsyncTask<Void, Void, String>(j2, c9b, c9p, c2027Wc) { // from class: com.facebook.ads.redexgen.X.9F
            public static byte[] A05;
            public static String[] A06;

            @Nullable
            public C9Y A00;
            public final AnonymousClass87 A01;
            public final C9B<String> A02;
            public final C9P<J2> A03;
            public final J2 A04;

            static {
                A03();
                A02();
            }

            public static String A00(int i, int i2, int i3) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A05, i, i + i2);
                for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                    bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 55);
                }
                return new String(bArrCopyOfRange);
            }

            public static void A02() {
                A05 = new byte[]{26, 40, 31, 31, 2, 31, 77, 0, 8, 30, 30, 12, 10, 8, 77, ci.l, 12, 3, 3, 2, 25, 77, ci.m, 8, 77, 3, 24, 1, 1, ci.k, 46, 38, 38, 40, 47, 38, 97, 36, 55, 36, 47, 53, 123, 97, 9, 30, 24, 20, 9, 31, 36, 31, 26, ci.m, 26, 25, 26, 8, 30};
            }

            public static void A03() {
                A06 = new String[]{"eZRg0", "9V6E8W", "xj5QhV", "OA95VIvTvwhgOpg1JzD5APn5ld4Fxl09", "KVXKxw3vFVm2nsonOqXLQ2M9", "1wiEXg5TWKy6aTJl", "hr3sX5JQ1zlqribj", "Vt9t5ut5ZgjhHbMTByjzA5y3IT5Rov5"};
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.9B != com.facebook.ads.internal.eventstorage.AdEventStorageCallback<java.lang.String> */
            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.9P != com.facebook.ads.internal.eventstorage.record.RecordDatabase<com.facebook.ads.internal.logging.AdEvent> */
            {
                this.A04 = j2;
                this.A03 = c9p;
                this.A02 = c9b;
                this.A01 = c2027Wc;
            }

            @Nullable
            private final String A01(Void... voidArr) throws Throwable {
                if (KL.A02(this)) {
                    return null;
                }
                String string = null;
                try {
                    try {
                        string = UUID.randomUUID().toString();
                        C8X c8xA04 = this.A01.A04();
                        String eventId = this.A04.A07().toString();
                        c8xA04.A7b(eventId);
                        String eventId2 = this.A04.A09();
                        if (TextUtils.isEmpty(eventId2)) {
                            return null;
                        }
                        if (BuildConfigApi.isDebug()) {
                            StringBuilder sb = new StringBuilder();
                            String eventId3 = A00(29, 15, 118);
                            sb.append(eventId3);
                            String eventId4 = this.A04.A07().toString();
                            sb.append(eventId4);
                            String eventId5 = A00(0, 1, 13);
                            sb.append(eventId5);
                            String eventId6 = this.A04.A0A().toString();
                            sb.append(eventId6);
                            sb.toString();
                        }
                        this.A03.ADj(XI.A07(string, this.A04));
                    } catch (C9Y e2) {
                        this.A00 = e2;
                        this.A01.A04().A8H(A00(44, 15, 76), C8Y.A20, new C8Z(e2));
                    }
                    return string;
                } catch (Throwable th) {
                    KL.A00(th, this);
                    return null;
                }
            }

            private final void A04(String str) throws Throwable {
                if (KL.A02(this)) {
                    return;
                }
                try {
                    if (this.A00 == null) {
                        this.A02.A03(str);
                    } else {
                        this.A02.A02(0, (String) Preconditions.checkNotNull(this.A00.getMessage(), A00(1, 28, 90)));
                    }
                } catch (Throwable th) {
                    KL.A00(th, this);
                }
            }

            @Override // android.os.AsyncTask
            @Nullable
            public final /* bridge */ /* synthetic */ String doInBackground(Void[] voidArr) throws Throwable {
                if (KL.A02(this)) {
                    return null;
                }
                try {
                    return A01(voidArr);
                } catch (Throwable th) {
                    KL.A00(th, this);
                    if (A06[7].length() != 31) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A06;
                    strArr[1] = "V";
                    strArr[1] = "V";
                    return null;
                }
            }

            @Override // android.os.AsyncTask
            public final /* bridge */ /* synthetic */ void onPostExecute(String str) throws Throwable {
                if (KL.A02(this)) {
                    return;
                }
                try {
                    A04(str);
                } catch (Throwable th) {
                    KL.A00(th, this);
                }
            }
        }, new Void[0]);
    }
}
