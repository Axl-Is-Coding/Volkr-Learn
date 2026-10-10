package com.google.zxing.datamatrix.encoder;

import cn.qqtheme.framework.widget.WheelView;
import java.util.Arrays;

/* JADX INFO: compiled from: HighLevelEncoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class j {
    private static char a(char c2, int i) {
        int i2 = c2 + ((i * 149) % 253) + 1;
        if (i2 > 254) {
            i2 -= 254;
        }
        return (char) i2;
    }

    static boolean b(char c2) {
        return c2 >= '0' && c2 <= '9';
    }

    static boolean c(char c2) {
        return c2 >= 128 && c2 <= 255;
    }

    private static boolean d(char c2) {
        if (c2 == ' ') {
            return true;
        }
        if (c2 < '0' || c2 > '9') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    private static boolean e(char c2) {
        return c2 >= ' ' && c2 <= '^';
    }

    private static boolean f(char c2) {
        if (c2 == ' ') {
            return true;
        }
        if (c2 < '0' || c2 > '9') {
            return c2 >= 'a' && c2 <= 'z';
        }
        return true;
    }

    private static boolean g(char c2) {
        if (i(c2) || c2 == ' ') {
            return true;
        }
        if (c2 < '0' || c2 > '9') {
            return c2 >= 'A' && c2 <= 'Z';
        }
        return true;
    }

    private static boolean h(char c2) {
        return false;
    }

    private static boolean i(char c2) {
        return c2 == '\r' || c2 == '*' || c2 == '>';
    }

    public static String a(String str, SymbolShapeHint symbolShapeHint, com.google.zxing.a aVar, com.google.zxing.a aVar2) {
        int iE = 0;
        g[] gVarArr = {new a(), new c(), new l(), new m(), new f(), new b()};
        h hVar = new h(str);
        hVar.a(symbolShapeHint);
        hVar.a(aVar, aVar2);
        if (str.startsWith("[)>\u001e05\u001d") && str.endsWith("\u001e\u0004")) {
            hVar.a((char) 236);
            hVar.a(2);
            hVar.f14458f += 7;
        } else if (str.startsWith("[)>\u001e06\u001d") && str.endsWith("\u001e\u0004")) {
            hVar.a((char) 237);
            hVar.a(2);
            hVar.f14458f += 7;
        }
        while (hVar.h()) {
            gVarArr[iE].a(hVar);
            if (hVar.e() >= 0) {
                iE = hVar.e();
                hVar.i();
            }
        }
        int iA = hVar.a();
        hVar.k();
        int iA2 = hVar.g().a();
        if (iA < iA2 && iE != 0 && iE != 5 && iE != 4) {
            hVar.a((char) 254);
        }
        StringBuilder sbB = hVar.b();
        if (sbB.length() < iA2) {
            sbB.append((char) 129);
        }
        while (sbB.length() < iA2) {
            sbB.append(a((char) 129, sbB.length() + 1));
        }
        return hVar.b().toString();
    }

    static int a(CharSequence charSequence, int i, int i2) {
        float[] fArr;
        char c2;
        if (i >= charSequence.length()) {
            return i2;
        }
        if (i2 == 0) {
            fArr = new float[]{WheelView.DividerConfig.FILL, 1.0f, 1.0f, 1.0f, 1.0f, 1.25f};
        } else {
            fArr = new float[]{1.0f, 2.0f, 2.0f, 2.0f, 2.0f, 2.25f};
            fArr[i2] = 0.0f;
        }
        int i3 = 0;
        while (true) {
            int i4 = i + i3;
            if (i4 == charSequence.length()) {
                byte[] bArr = new byte[6];
                int[] iArr = new int[6];
                int iA = a(fArr, iArr, Integer.MAX_VALUE, bArr);
                int iA2 = a(bArr);
                if (iArr[0] == iA) {
                    return 0;
                }
                if (iA2 == 1 && bArr[5] > 0) {
                    return 5;
                }
                if (iA2 == 1 && bArr[4] > 0) {
                    return 4;
                }
                if (iA2 != 1 || bArr[2] <= 0) {
                    return (iA2 != 1 || bArr[3] <= 0) ? 1 : 3;
                }
                return 2;
            }
            char cCharAt = charSequence.charAt(i4);
            i3++;
            if (b(cCharAt)) {
                fArr[0] = fArr[0] + 0.5f;
            } else if (c(cCharAt)) {
                fArr[0] = (float) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 2.0f;
            } else {
                fArr[0] = (float) Math.ceil(fArr[0]);
                fArr[0] = fArr[0] + 1.0f;
            }
            if (d(cCharAt)) {
                fArr[1] = fArr[1] + 0.6666667f;
            } else if (c(cCharAt)) {
                fArr[1] = fArr[1] + 2.6666667f;
            } else {
                fArr[1] = fArr[1] + 1.3333334f;
            }
            if (f(cCharAt)) {
                fArr[2] = fArr[2] + 0.6666667f;
            } else if (c(cCharAt)) {
                fArr[2] = fArr[2] + 2.6666667f;
            } else {
                fArr[2] = fArr[2] + 1.3333334f;
            }
            if (g(cCharAt)) {
                fArr[3] = fArr[3] + 0.6666667f;
            } else if (c(cCharAt)) {
                fArr[3] = fArr[3] + 4.3333335f;
            } else {
                fArr[3] = fArr[3] + 3.3333333f;
            }
            if (e(cCharAt)) {
                fArr[4] = fArr[4] + 0.75f;
            } else if (c(cCharAt)) {
                fArr[4] = fArr[4] + 4.25f;
            } else {
                fArr[4] = fArr[4] + 3.25f;
            }
            if (h(cCharAt)) {
                c2 = 5;
                fArr[5] = fArr[5] + 4.0f;
            } else {
                c2 = 5;
                fArr[5] = fArr[5] + 1.0f;
            }
            if (i3 >= 4) {
                int[] iArr2 = new int[6];
                byte[] bArr2 = new byte[6];
                a(fArr, iArr2, Integer.MAX_VALUE, bArr2);
                int iA3 = a(bArr2);
                if (iArr2[0] < iArr2[c2] && iArr2[0] < iArr2[1] && iArr2[0] < iArr2[2] && iArr2[0] < iArr2[3] && iArr2[0] < iArr2[4]) {
                    return 0;
                }
                if (iArr2[5] < iArr2[0] || bArr2[1] + bArr2[2] + bArr2[3] + bArr2[4] == 0) {
                    return 5;
                }
                if (iA3 == 1 && bArr2[4] > 0) {
                    return 4;
                }
                if (iA3 == 1 && bArr2[2] > 0) {
                    return 2;
                }
                if (iA3 == 1 && bArr2[3] > 0) {
                    return 3;
                }
                if (iArr2[1] + 1 < iArr2[0] && iArr2[1] + 1 < iArr2[5] && iArr2[1] + 1 < iArr2[4] && iArr2[1] + 1 < iArr2[2]) {
                    if (iArr2[1] < iArr2[3]) {
                        return 1;
                    }
                    if (iArr2[1] == iArr2[3]) {
                        for (int i5 = i + i3 + 1; i5 < charSequence.length(); i5++) {
                            char cCharAt2 = charSequence.charAt(i5);
                            if (i(cCharAt2)) {
                                return 3;
                            }
                            if (!g(cCharAt2)) {
                                break;
                            }
                        }
                        return 1;
                    }
                }
            }
        }
    }

    private static int a(float[] fArr, int[] iArr, int i, byte[] bArr) {
        Arrays.fill(bArr, (byte) 0);
        int i2 = i;
        for (int i3 = 0; i3 < 6; i3++) {
            iArr[i3] = (int) Math.ceil(fArr[i3]);
            int i4 = iArr[i3];
            if (i2 > i4) {
                Arrays.fill(bArr, (byte) 0);
                i2 = i4;
            }
            if (i2 == i4) {
                bArr[i3] = (byte) (bArr[i3] + 1);
            }
        }
        return i2;
    }

    private static int a(byte[] bArr) {
        int i = 0;
        for (int i2 = 0; i2 < 6; i2++) {
            i += bArr[i2];
        }
        return i;
    }

    public static int a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        int i2 = 0;
        if (i < length) {
            char cCharAt = charSequence.charAt(i);
            while (b(cCharAt) && i < length) {
                i2++;
                i++;
                if (i < length) {
                    cCharAt = charSequence.charAt(i);
                }
            }
        }
        return i2;
    }

    static void a(char c2) {
        String hexString = Integer.toHexString(c2);
        throw new IllegalArgumentException("Illegal character: " + c2 + " (0x" + ("0000".substring(0, 4 - hexString.length()) + hexString) + ')');
    }
}
