package com.google.zxing.oned;

/* JADX INFO: compiled from: CodaBarWriter.java */
/* JADX INFO: loaded from: classes2.dex */
public final class b extends m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final char[] f14472a = {'A', 'B', 'C', 'D'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final char[] f14473b = {'T', 'N', '*', 'E'};

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final char[] f14474c = {'/', ':', '+', '.'};

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final char f14475d = f14472a[0];

    @Override // com.google.zxing.oned.m
    public boolean[] a(String str) {
        int i;
        if (str.length() < 2) {
            str = f14475d + str + f14475d;
        } else {
            char upperCase = Character.toUpperCase(str.charAt(0));
            char upperCase2 = Character.toUpperCase(str.charAt(str.length() - 1));
            boolean zA = a.a(f14472a, upperCase);
            boolean zA2 = a.a(f14472a, upperCase2);
            boolean zA3 = a.a(f14473b, upperCase);
            boolean zA4 = a.a(f14473b, upperCase2);
            if (zA) {
                if (!zA2) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
                }
            } else if (!zA3) {
                if (zA2 || zA4) {
                    throw new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
                }
                str = f14475d + str + f14475d;
            } else if (!zA4) {
                throw new IllegalArgumentException("Invalid start/end guards: ".concat(String.valueOf(str)));
            }
        }
        int i2 = 20;
        for (int i3 = 1; i3 < str.length() - 1; i3++) {
            if (Character.isDigit(str.charAt(i3)) || str.charAt(i3) == '-' || str.charAt(i3) == '$') {
                i2 += 9;
            } else {
                if (!a.a(f14474c, str.charAt(i3))) {
                    throw new IllegalArgumentException("Cannot encode : '" + str.charAt(i3) + '\'');
                }
                i2 += 10;
            }
        }
        boolean[] zArr = new boolean[i2 + (str.length() - 1)];
        int i4 = 0;
        for (int i5 = 0; i5 < str.length(); i5++) {
            char upperCase3 = Character.toUpperCase(str.charAt(i5));
            if (i5 == 0 || i5 == str.length() - 1) {
                if (upperCase3 == '*') {
                    upperCase3 = 'C';
                } else if (upperCase3 == 'E') {
                    upperCase3 = 'D';
                } else if (upperCase3 == 'N') {
                    upperCase3 = 'B';
                } else if (upperCase3 == 'T') {
                    upperCase3 = 'A';
                }
            }
            int i6 = 0;
            while (true) {
                char[] cArr = a.f14469a;
                if (i6 >= cArr.length) {
                    i = 0;
                    break;
                }
                if (upperCase3 == cArr[i6]) {
                    i = a.f14470b[i6];
                    break;
                }
                i6++;
            }
            int i7 = i4;
            int i8 = 0;
            boolean z = true;
            while (true) {
                int i9 = 0;
                while (i8 < 7) {
                    zArr[i7] = z;
                    i7++;
                    if (((i >> (6 - i8)) & 1) == 0 || i9 == 1) {
                        break;
                    }
                    i9++;
                }
                z = !z;
                i8++;
            }
            if (i5 < str.length() - 1) {
                zArr[i7] = false;
                i7++;
            }
            i4 = i7;
        }
        return zArr;
    }
}
