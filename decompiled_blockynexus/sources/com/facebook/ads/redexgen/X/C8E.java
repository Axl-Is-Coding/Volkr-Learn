package com.facebook.ads.redexgen.X;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.AsyncTask;
import android.os.Looper;
import android.text.TextUtils;
import com.facebook.ads.internal.util.process.ProcessUtils;
import com.sandboxol.center.config.VipSubscribeStatus;
import com.umeng.analytics.pro.ci;
import java.util.Arrays;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.8E, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C8E {
    public static byte[] A04;
    public static String[] A05;
    public static final String A06;
    public static final Lock A07;
    public static final Lock A08;
    public static final ReentrantReadWriteLock A09;
    public SQLiteOpenHelper A00;
    public final C2027Wc A01;
    public final C2034Wj A03 = new C2034Wj(this);
    public final C2032Wh A02 = new C2032Wh(this);

    public static String A05(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
        int i4 = 0;
        while (true) {
            int length = bArrCopyOfRange.length;
            if (A05[3].charAt(0) != '1') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[0] = "6YOEgEHO6bjbd5au9bSAefu6W5tI3Dak";
            strArr[6] = "kgOgsYcmlOEy6T8oxoaixHiO6WRSp1D2";
            if (i4 >= length) {
                return new String(bArrCopyOfRange);
            }
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] - i3) - 115);
            i4++;
        }
    }

    public static void A07() {
        A04 = new byte[]{-31, -2, -31, -81, -51, -81, -50, -11, 22, 40, 24, -67, -29, -17, -20, -22, -67, -44, -2, 3, -3, 2, -44, -108, -64, -67, -63, -67, -56, -108, -106, -59, -60, -106, -35, 12, ci.m, 1, 2, ci.m, -35, -1, 22, -35, -42, 9, -5, 10, -42, -98, -43, -58, -61, -48, -61, -98, -49, -43, -46, -58, 11, 3, -54, -52, 22, 52, 65, 65, 66, 71, -13, 54, 52, Utf8.REPLACEMENT_BYTE, Utf8.REPLACEMENT_BYTE, -13, 58, 56, 71, 23, 52, 71, 52, 53, 52, 70, 56, -13, 57, 69, 66, 64, -13, 71, 59, 56, -13, 40, 28, -13, 71, 59, 69, 56, 52, 55, -12, 33, 19, 26, 19, 17, 34, -18, 66, 61, 57, 51, 60, 65, -4, 39, 34, 22, 19, 38, 23, -14, 43, 40, 59, 40, 41, 40, 58, 44, 71, 88, 71, 80, 86, 85, -9, -14, -18, -24, -15, -10};
    }

    public static void A08() {
        A05 = new String[]{"qJOvsPrm5BQkhL6wLJahauzjA45r7dQz", "hfx8x2hkXgxq19RSFkkqiaOe1zMy03Qo", "bV5o7GaQth4ZZOPd4LFtWwXjKNVB8lua", "1EyYFmGpmEhL9EWyl0I1ptwRPtnJxpez", "F", com.umeng.analytics.pro.au.ay, "plO80lk7YnGQvaXazMopbLIwOg8MB0TR", "EzLFA06L6a2SQhX4934tm7serJXXg4XA"};
    }

    static {
        A08();
        A07();
        StringBuilder sb = new StringBuilder();
        sb.append(A05(107, 14, 91));
        sb.append(C2034Wj.A02.A01);
        String strA05 = A05(58, 2, 51);
        sb.append(strA05);
        String strA052 = A05(142, 6, 16);
        sb.append(strA052);
        String strA053 = A05(60, 1, 106);
        sb.append(strA053);
        sb.append(C2034Wj.A01.A01);
        sb.append(strA05);
        String strA054 = A05(136, 6, 111);
        sb.append(strA054);
        sb.append(strA053);
        sb.append(C2032Wh.A04.A01);
        sb.append(strA05);
        sb.append(strA054);
        sb.append(strA053);
        sb.append(C2032Wh.A05.A01);
        sb.append(strA05);
        sb.append(strA054);
        sb.append(strA053);
        sb.append(C2032Wh.A0A.A01);
        sb.append(strA05);
        sb.append(strA054);
        sb.append(strA053);
        sb.append(C2032Wh.A08.A01);
        sb.append(strA05);
        sb.append(strA054);
        sb.append(strA053);
        sb.append(C2032Wh.A07.A01);
        sb.append(strA05);
        sb.append(strA054);
        sb.append(strA053);
        sb.append(C2032Wh.A06.A01);
        sb.append(strA05);
        sb.append(strA054);
        sb.append(strA053);
        sb.append(C2032Wh.A03.A01);
        sb.append(strA05);
        sb.append(strA054);
        sb.append(strA053);
        sb.append(C2032Wh.A02.A01);
        sb.append(A05(11, 6, 42));
        sb.append(strA054);
        sb.append(A05(17, 6, 65));
        sb.append(strA052);
        sb.append(A05(30, 4, 3));
        sb.append(strA054);
        sb.append(strA053);
        sb.append(C2032Wh.A09.A01);
        sb.append(A05(0, 3, 78));
        sb.append(strA052);
        sb.append(strA053);
        sb.append(C2034Wj.A02.A01);
        sb.append(A05(34, 10, 74));
        sb.append(strA054);
        sb.append(strA053);
        sb.append(C2032Wh.A08.A01);
        sb.append(A05(7, 4, 98));
        A06 = sb.toString();
        A09 = new ReentrantReadWriteLock();
        A07 = A09.readLock();
        A08 = A09.writeLock();
    }

    public C8E(C2027Wc c2027Wc) {
        this.A01 = c2027Wc;
    }

    private synchronized SQLiteDatabase A00() {
        if (this.A00 == null) {
            final C2027Wc c2027Wc = this.A01;
            this.A00 = new SQLiteOpenHelper(c2027Wc, this) { // from class: com.facebook.ads.redexgen.X.8F
                public static byte[] A01;
                public static String[] A02;
                public static final String A03;
                public final C8E A00;

                public static String A00(int i, int i2, int i3) {
                    byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
                    for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                        bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 76);
                    }
                    return new String(bArrCopyOfRange);
                }

                public static void A02() {
                    A01 = new byte[]{17, 1, 101, 100, 103, 96, 116, 109, 117, 1, 17, 48, 61, 37, 52, 35, 81, 37, 48, 51, 61, 52, 81, 20, 7, 20, 31, 5, 2, 81, 48, 53, 53, 81, 50, 62, 61, 36, 60, Utf8.REPLACEMENT_BYTE, 81, 90, 127, 95, 122, 111, 122, 121, 122, 104, 126, 83, 126, 119, 107, 126, 105, 59, 120, 122, 117, 59, 117, 116, 111, 59, 121, 126, 59, 117, 110, 119, 119, 33, 55, 42, 53, 69, 49, 36, 39, 41, 32, 69, 44, 35, 69, 32, 61, 44, 54, 49, 54, 69, 6, 23, 4, 22, ci.k, 0, 22, 88, 90, 73, 79, 69, 73, 40, 110, 103, 122, 109, 97, 111, 102, 87, 99, 109, 113, 123, 40, 53, 40, 71, 70, 51, 124, 121, 110, 56, 110, 51, 121, 127};
                }

                public static void A03() {
                    A02 = new String[]{"JShIJu3JRfHt43ypO9GqFaXtQU", "Uet3LTw8rLJmru1DFWkYPrIPq9yjzQ4", "LBYTyoU1fD8w8O4ue", "ZxNu1nQjo2XkCjw5ERk40jWGoeLjYM9V", "VhJY3C97J7J84q76u4hEYHgB0g", "Ro8Wdk2EPx5GRn22XYsr1QjtSyjSX", "SdOPztDY16h0BPmxgfN82QFEWJhjV", "9YM807W9r6X84VXv6l9L7RtBJQk8UQ"};
                }

                static {
                    A03();
                    A02();
                    A03 = C8F.class.getSimpleName();
                }

                {
                    super(c2027Wc, A01(c2027Wc), (SQLiteDatabase.CursorFactory) null, 4);
                    if (this != null) {
                        this.A00 = this;
                        return;
                    }
                    throw new IllegalArgumentException(A00(41, 32, 87));
                }

                public static String A01(C2027Wc c2027Wc2) {
                    Locale locale = Locale.US;
                    Object[] objArr = {A00(0, 0, 95)};
                    String strA00 = A00(126, 8, 81);
                    String str = String.format(locale, strA00, objArr);
                    if (!C1693Iy.A1Y(c2027Wc2)) {
                        return str;
                    }
                    String packageName = c2027Wc2.getPackageName();
                    String processName = ProcessUtils.getProcessName(c2027Wc2);
                    if (!packageName.equals(processName) && !TextUtils.isEmpty(processName)) {
                        return String.format(Locale.US, strA00, '_' + processName);
                    }
                    return str;
                }

                @Override // android.database.sqlite.SQLiteOpenHelper
                public final void onCreate(SQLiteDatabase sQLiteDatabase) {
                    for (C8I c8i : this.A00.A0N()) {
                        c8i.A08(sQLiteDatabase);
                    }
                }

                @Override // android.database.sqlite.SQLiteOpenHelper
                public final void onDowngrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                    for (C8I c8i : this.A00.A0N()) {
                        c8i.A09(sQLiteDatabase);
                        c8i.A08(sQLiteDatabase);
                    }
                }

                @Override // android.database.sqlite.SQLiteOpenHelper
                public final void onOpen(SQLiteDatabase sQLiteDatabase) {
                    super.onOpen(sQLiteDatabase);
                    if (!sQLiteDatabase.isReadOnly()) {
                        sQLiteDatabase.execSQL(A00(101, 25, 68));
                    }
                }

                @Override // android.database.sqlite.SQLiteOpenHelper
                public final void onUpgrade(SQLiteDatabase sQLiteDatabase, int i, int i2) {
                    if (i == 2 && i2 >= 3) {
                        String strA00 = A00(73, 28, 41);
                        if (A02[7].length() != 30) {
                            throw new RuntimeException();
                        }
                        String[] strArr = A02;
                        strArr[3] = "Uy0CZyDaBZXeJSQ63Y80hAJR5wsAelR7";
                        strArr[3] = "Uy0CZyDaBZXeJSQ63Y80hAJR5wsAelR7";
                        sQLiteDatabase.execSQL(strA00);
                    }
                    if (i <= 3 && i2 >= 4) {
                        C8C c8c = C2032Wh.A02;
                        sQLiteDatabase.execSQL(A00(11, 30, 61) + c8c.A01 + A00(0, 1, 125) + c8c.A02 + A00(1, 10, 109));
                    }
                }
            };
        }
        return this.A00.getWritableDatabase();
    }

    private synchronized SQLiteDatabase A01() {
        SQLiteException e2 = null;
        for (int i = 0; i < 10; i++) {
            try {
            } catch (SQLiteException e3) {
                e2 = e3;
                try {
                    Thread.sleep(100L);
                } catch (InterruptedException unused) {
                }
            }
        }
        this.A01.A04().A8H(A05(128, 8, 84), C8Y.A0j, new C8Z(e2));
        throw e2;
        return A00();
    }

    public final int A09(int i) {
        A08.lock();
        try {
            return A0F().delete(A05(136, 6, 111), C2032Wh.A02.A01 + A05(3, 4, 28), new String[]{String.valueOf(i - 1)});
        } finally {
            A08.unlock();
        }
    }

    public final Cursor A0A() {
        A07.lock();
        try {
            return this.A02.A0C();
        } finally {
            A07.unlock();
        }
    }

    public final Cursor A0B() {
        A07.lock();
        try {
            return this.A02.A0D();
        } finally {
            A07.unlock();
        }
    }

    public final Cursor A0C() {
        A07.lock();
        try {
            return this.A03.A0C();
        } finally {
            A07.unlock();
        }
    }

    public final Cursor A0D(int i) {
        A07.lock();
        try {
            return A0F().rawQuery(A06 + A05(23, 7, 1) + String.valueOf(i), null);
        } finally {
            A07.unlock();
        }
    }

    public final Cursor A0E(String str) {
        A07.lock();
        try {
            return this.A02.A0E(str);
        } finally {
            A07.unlock();
        }
    }

    public final SQLiteDatabase A0F() {
        if (Looper.myLooper() != Looper.getMainLooper()) {
            return A01();
        }
        throw new IllegalStateException(A05(64, 43, 96));
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.8H != com.facebook.ads.internal.database.AdDatabaseQuery<T> */
    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.9B != com.facebook.ads.internal.eventstorage.AdEventStorageCallback<T> */
    public final <T> AsyncTask A0G(final C8H<T> c8h, final C9B<T> c9b) {
        Executor executor = ExecutorC1744Lc.A07;
        final C2027Wc c2027Wc = this.A01;
        return LZ.A00(executor, new AsyncTask<Void, Void, T>(c2027Wc, c8h, c9b) { // from class: com.facebook.ads.redexgen.X.8D
            public static byte[] A04;
            public static String[] A05;
            public C8G A00;
            public final C2027Wc A01;
            public final C8H<T> A02;
            public final C9B<T> A03;

            static {
                A03();
                A02();
            }

            public static String A01(int i, int i2, int i3) {
                byte[] bArrCopyOfRange = Arrays.copyOfRange(A04, i, i + i2);
                for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
                    int i5 = (bArrCopyOfRange[i4] - i3) - 116;
                    if (A05[7].charAt(12) != 'P') {
                        throw new RuntimeException();
                    }
                    String[] strArr = A05;
                    strArr[6] = "VTML";
                    strArr[6] = "VTML";
                    bArrCopyOfRange[i4] = (byte) i5;
                }
                return new String(bArrCopyOfRange);
            }

            public static void A02() {
                A04 = new byte[]{31, 28, 47, 28, 29, 28, 46, 32};
            }

            public static void A03() {
                A05 = new String[]{"65r9CRdv0GoLRVNVjbjXzJK5P2ycj7FG", "0CWnyuhck9HOQgwCfxzQ09GVkx", "IEC2mc7xTTQi8lqWDODmms9jEFByhoZx", "6exEWFSZK9oTcnxcvUurXohDGqhdlb0H", "22QzghXqrFZ4DBGtDF", "dbvBYMdgslkBJuEWD9uCPJqFmtTt8cU5", "jZC4Ivj", "4jv2LQemXeCXPfpssPDUuPD2TleIiZzb"};
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.8D != com.facebook.ads.internal.database.AdDatabaseHelper$DatabaseQueryAsyncTask<T> */
            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.8H != com.facebook.ads.internal.database.AdDatabaseQuery<T> */
            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.9B != com.facebook.ads.internal.eventstorage.AdEventStorageCallback<T> */
            {
                this.A02 = c8h;
                this.A03 = c9b;
                this.A01 = c2027Wc;
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.8D != com.facebook.ads.internal.database.AdDatabaseHelper$DatabaseQueryAsyncTask<T> */
            private final T A00(Void... voidArr) throws Throwable {
                if (KL.A02(this)) {
                    return null;
                }
                if (A05[6].length() == 11) {
                    throw new RuntimeException();
                }
                String[] strArr = A05;
                strArr[2] = "4eGiZ19xQ4OxGjIavdFldPBRBlbWR0DL";
                strArr[2] = "4eGiZ19xQ4OxGjIavdFldPBRBlbWR0DL";
                T tA04 = null;
                try {
                    try {
                        tA04 = this.A02.A04();
                        this.A00 = this.A02.A00();
                    } catch (Exception e2) {
                        this.A01.A04().A8H(A01(0, 8, 71), C8Y.A0k, new C8Z(e2));
                        this.A00 = C8G.A09;
                    }
                    return tA04;
                } catch (Throwable th) {
                    KL.A00(th, this);
                    return null;
                }
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.8D != com.facebook.ads.internal.database.AdDatabaseHelper$DatabaseQueryAsyncTask<T> */
            @Override // android.os.AsyncTask
            public final /* bridge */ /* synthetic */ Object doInBackground(Void[] voidArr) throws Throwable {
                if (KL.A02(this)) {
                    return null;
                }
                try {
                    return A00(voidArr);
                } catch (Throwable th) {
                    KL.A00(th, this);
                    return null;
                }
            }

            /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.8D != com.facebook.ads.internal.database.AdDatabaseHelper$DatabaseQueryAsyncTask<T> */
            @Override // android.os.AsyncTask
            public final void onPostExecute(T t) throws Throwable {
                if (KL.A02(this)) {
                    return;
                }
                try {
                    if (this.A00 == null) {
                        this.A03.A03(t);
                    } else {
                        this.A03.A02(this.A00.A03(), this.A00.A04());
                    }
                } catch (Throwable th) {
                    KL.A00(th, this);
                }
            }
        }, new Void[0]);
    }

    /* JADX WARN: Generic types in debug info not equals: com.facebook.ads.redexgen.X.9B != com.facebook.ads.internal.eventstorage.AdEventStorageCallback<java.lang.String> */
    public final AsyncTask A0H(String str, int i, String str2, double d2, double d3, String str3, Map<String, String> map, C9B<String> c9b) {
        return A0G(new C1523Ca(this, str2, str, i, d2, d3, str3, map), c9b);
    }

    public final void A0I() {
        A08.lock();
        try {
            this.A02.A0A();
            this.A03.A0A();
        } finally {
            A08.unlock();
        }
    }

    public final void A0J() {
        A08.lock();
        try {
            this.A03.A0E();
            A08.unlock();
            if (A05[2].charAt(20) == 'D') {
                throw new RuntimeException();
            }
            String[] strArr = A05;
            strArr[3] = "1xdZaIBKHwxaXlFBCUT9GXbMegb8IQts";
            strArr[3] = "1xdZaIBKHwxaXlFBCUT9GXbMegb8IQts";
        } catch (Throwable th) {
            A08.unlock();
            throw th;
        }
    }

    public final synchronized void A0K() {
        for (int i = 0; i < A0N().length; i++) {
        }
        if (this.A00 != null) {
            this.A00.close();
            this.A00 = null;
        }
        String[] strArr = A05;
        if (strArr[7].charAt(23) != strArr[1].charAt(23)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[3] = "1MkhueXc3ojVbbuWv64h1Z2UaaL8Cuya";
        strArr2[3] = "1MkhueXc3ojVbbuWv64h1Z2UaaL8Cuya";
    }

    public final boolean A0L(String str) {
        A08.lock();
        try {
            boolean zA0G = this.A02.A0G(str);
            Lock lock = A08;
            String[] strArr = A05;
            if (strArr[7].charAt(23) != strArr[1].charAt(23)) {
                throw new RuntimeException();
            }
            String[] strArr2 = A05;
            strArr2[4] = VipSubscribeStatus.SUBSCRIPTION_PRICE_CHANGE_CONFIRMED;
            strArr2[5] = "N";
            lock.unlock();
            return zA0G;
        } catch (Throwable th) {
            A08.unlock();
            throw th;
        }
    }

    public final boolean A0M(String str) {
        boolean z;
        A08.lock();
        try {
            A0F().execSQL(A05(121, 7, 95) + A05(136, 6, 111) + A05(44, 5, 67) + C2032Wh.A02.A01 + A05(61, 1, 83) + C2032Wh.A02.A01 + A05(56, 2, 49) + A05(49, 7, 11) + C2032Wh.A04.A01 + A05(62, 2, 26), new String[]{str});
            z = true;
        } catch (SQLiteException unused) {
            z = false;
        }
        A08.unlock();
        String[] strArr = A05;
        if (strArr[0].charAt(2) != strArr[6].charAt(2)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A05;
        strArr2[2] = "LEhHmvsdsEQXOsQ0B1AVwqczGhJrofDk";
        strArr2[2] = "LEhHmvsdsEQXOsQ0B1AVwqczGhJrofDk";
        return z;
    }

    public final C8I[] A0N() {
        return new C8I[]{this.A03, this.A02};
    }
}
