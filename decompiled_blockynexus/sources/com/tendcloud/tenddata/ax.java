package com.tendcloud.tenddata;

import android.text.TextUtils;
import com.tendcloud.tenddata.t;
import java.lang.reflect.Array;
import java.security.SecureRandom;
import java.util.ArrayList;

/* JADX INFO: compiled from: td */
/* JADX INFO: loaded from: classes5.dex */
public final class ax {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f19812a = "Archimedes_p";

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static int f19813b = 0;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final int f19814c = 1000000000;

    static int a() {
        int i = f19813b;
        if (i != 0) {
            return i;
        }
        try {
            t.getFileLock(t.b.AES_DATA_LOCK.toString());
            f19813b = au.a(b());
            if (f19813b == 0) {
                f19813b = af.b().nextInt(f19814c);
                a(f19813b);
            }
            int i2 = f19813b;
            t.releaseFileLock(t.b.AES_DATA_LOCK.toString());
            return i2;
        } catch (Throwable th) {
            t.releaseFileLock(t.b.AES_DATA_LOCK.toString());
            throw th;
        }
    }

    private static int[][] b() {
        int i;
        try {
            ArrayList arrayList = new ArrayList();
            StringBuilder sb = new StringBuilder();
            int i2 = 0;
            for (int i3 = 1; i3 < 4; i3++) {
                String strA = aw.a(f19812a + i3);
                if (!TextUtils.isEmpty(strA)) {
                    arrayList.add(strA);
                    i2++;
                }
            }
            int i4 = 4;
            while (true) {
                if (i4 >= 6) {
                    break;
                }
                String strB = aw.b(f19812a + i4);
                if (!TextUtils.isEmpty(strB)) {
                    arrayList.add(strB);
                    i2++;
                }
                i4++;
            }
            if (i2 < 4) {
                for (i = 6; i < 8; i++) {
                    String strC = aw.c(ab.g.getPackageName() + i);
                    if (!TextUtils.isEmpty(strC)) {
                        arrayList.add(strC);
                    }
                }
            }
            if (arrayList.size() < 4) {
                return null;
            }
            for (int i5 = 0; i5 < 4; i5++) {
                sb.append((String) arrayList.get(i5));
            }
            return a(sb.toString(), 4, 2);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void a(int i) throws Throwable {
        int i2;
        int i3;
        int i4;
        ArrayList arrayList = new ArrayList(16);
        int i5 = 0;
        do {
            int[] iArr = new int[3];
            int[] iArr2 = new int[7];
            int[] iArr3 = new int[7];
            SecureRandom secureRandomB = af.b();
            for (int i6 = 0; i6 < iArr.length; i6++) {
                iArr[i6] = secureRandomB.nextInt(1000);
            }
            for (int i7 = 0; i7 < iArr2.length; i7++) {
                iArr2[i7] = secureRandomB.nextInt(100);
            }
            int i8 = 0;
            while (true) {
                i2 = 1;
                if (i8 >= iArr3.length) {
                    break;
                }
                iArr3[i8] = (iArr[0] * iArr2[i8] * iArr2[i8] * iArr2[i8]) + (iArr[1] * iArr2[i8] * iArr2[i8]) + (iArr[2] * iArr2[i8]) + i;
                arrayList.add(iArr2[i8] + "," + iArr3[i8] + ",");
                i8++;
            }
            if (a(arrayList, i)) {
                break;
            }
            arrayList.clear();
            i5++;
        } while (i5 < 7);
        while (true) {
            i3 = 4;
            if (i2 >= 4) {
                break;
            }
            aw.a(f19812a + i2, (String) arrayList.get(i2 - 1));
            i2++;
        }
        while (true) {
            if (i3 >= 6) {
                break;
            }
            aw.b(f19812a + i3, (String) arrayList.get(i3 - 1));
            i3++;
        }
        for (i4 = 6; i4 < 8; i4++) {
            aw.c(ab.g.getPackageName() + i4, (String) arrayList.get(i4 - 1));
        }
    }

    private static boolean a(ArrayList<String> arrayList, int i) {
        String strConcat = "";
        for (int i2 = 0; i2 < 4; i2++) {
            try {
                strConcat = strConcat.concat(arrayList.get(i2));
            } catch (Throwable unused) {
                return false;
            }
        }
        return i == au.a(a(strConcat, 4, 2));
    }

    private static int[][] a(String str, int i, int i2) {
        int[][] iArr = (int[][]) Array.newInstance((Class<?>) int.class, i, i2);
        String[] strArrSplit = str.split(",");
        int i3 = 0;
        int i4 = 0;
        while (i3 < i) {
            int i5 = i4;
            for (int i6 = 0; i6 < i2; i6++) {
                iArr[i3][i6] = Integer.parseInt(strArrSplit[i5]);
                i5++;
            }
            i3++;
            i4 = i5;
        }
        return iArr;
    }
}
