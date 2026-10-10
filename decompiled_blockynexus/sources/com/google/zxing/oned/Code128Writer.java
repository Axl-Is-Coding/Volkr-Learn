package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: loaded from: classes2.dex */
public final class Code128Writer extends m {

    private enum CType {
        UNCODABLE,
        ONE_DIGIT,
        TWO_DIGITS,
        FNC_1
    }

    @Override // com.google.zxing.oned.m, com.google.zxing.f
    public com.google.zxing.common.b a(String str, BarcodeFormat barcodeFormat, int i, int i2, Map<EncodeHintType, ?> map) throws WriterException {
        if (barcodeFormat == BarcodeFormat.CODE_128) {
            return super.a(str, barcodeFormat, i, i2, map);
        }
        throw new IllegalArgumentException("Can only encode CODE_128, but got ".concat(String.valueOf(barcodeFormat)));
    }

    @Override // com.google.zxing.oned.m
    public boolean[] a(String str) {
        int length = str.length();
        if (length > 0 && length <= 80) {
            int iA = 0;
            for (int i = 0; i < length; i++) {
                char cCharAt = str.charAt(i);
                switch (cCharAt) {
                    case 241:
                    case 242:
                    case 243:
                    case 244:
                        break;
                    default:
                        if (cCharAt > 127) {
                            throw new IllegalArgumentException("Bad character in input: ".concat(String.valueOf(cCharAt)));
                        }
                        break;
                        break;
                }
            }
            ArrayList<int[]> arrayList = new ArrayList();
            int i2 = 0;
            int i3 = 0;
            int i4 = 0;
            int i5 = 1;
            while (i2 < length) {
                int iA2 = a(str, i2, i4);
                int iCharAt = 100;
                if (iA2 == i4) {
                    switch (str.charAt(i2)) {
                        case 241:
                            iCharAt = 102;
                            break;
                        case 242:
                            iCharAt = 97;
                            break;
                        case 243:
                            iCharAt = 96;
                            break;
                        case 244:
                            if (i4 == 101) {
                                iCharAt = 101;
                            }
                            break;
                        default:
                            if (i4 == 100) {
                                iCharAt = str.charAt(i2) - ' ';
                            } else if (i4 == 101) {
                                iCharAt = str.charAt(i2) - ' ';
                                if (iCharAt < 0) {
                                    iCharAt += 96;
                                }
                            } else {
                                iCharAt = Integer.parseInt(str.substring(i2, i2 + 2));
                                i2++;
                            }
                            break;
                    }
                    i2++;
                } else {
                    iCharAt = i4 == 0 ? iA2 != 100 ? iA2 != 101 ? 105 : 103 : 104 : iA2;
                    i4 = iA2;
                }
                arrayList.add(c.f14476a[iCharAt]);
                i3 += iCharAt * i5;
                if (i2 != 0) {
                    i5++;
                }
            }
            arrayList.add(c.f14476a[i3 % 103]);
            arrayList.add(c.f14476a[106]);
            int i6 = 0;
            for (int[] iArr : arrayList) {
                int i7 = i6;
                for (int i8 : iArr) {
                    i7 += i8;
                }
                i6 = i7;
            }
            boolean[] zArr = new boolean[i6];
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                iA += m.a(zArr, iA, (int[]) it.next(), true);
            }
            return zArr;
        }
        throw new IllegalArgumentException("Contents length should be between 1 and 80 characters, but got ".concat(String.valueOf(length)));
    }

    private static CType a(CharSequence charSequence, int i) {
        int length = charSequence.length();
        if (i >= length) {
            return CType.UNCODABLE;
        }
        char cCharAt = charSequence.charAt(i);
        if (cCharAt == 241) {
            return CType.FNC_1;
        }
        if (cCharAt < '0' || cCharAt > '9') {
            return CType.UNCODABLE;
        }
        int i2 = i + 1;
        if (i2 >= length) {
            return CType.ONE_DIGIT;
        }
        char cCharAt2 = charSequence.charAt(i2);
        if (cCharAt2 >= '0' && cCharAt2 <= '9') {
            return CType.TWO_DIGITS;
        }
        return CType.ONE_DIGIT;
    }

    private static int a(CharSequence charSequence, int i, int i2) {
        CType cTypeA;
        CType cTypeA2;
        char cCharAt;
        CType cTypeA3 = a(charSequence, i);
        if (cTypeA3 == CType.ONE_DIGIT) {
            return 100;
        }
        if (cTypeA3 == CType.UNCODABLE) {
            return (i >= charSequence.length() || ((cCharAt = charSequence.charAt(i)) >= ' ' && (i2 != 101 || cCharAt >= '`'))) ? 100 : 101;
        }
        if (i2 == 99) {
            return 99;
        }
        if (i2 == 100) {
            if (cTypeA3 == CType.FNC_1 || (cTypeA = a(charSequence, i + 2)) == CType.UNCODABLE || cTypeA == CType.ONE_DIGIT) {
                return 100;
            }
            if (cTypeA == CType.FNC_1) {
                return a(charSequence, i + 3) == CType.TWO_DIGITS ? 99 : 100;
            }
            int i3 = i + 4;
            while (true) {
                cTypeA2 = a(charSequence, i3);
                if (cTypeA2 != CType.TWO_DIGITS) {
                    break;
                }
                i3 += 2;
            }
            return cTypeA2 == CType.ONE_DIGIT ? 100 : 99;
        }
        if (cTypeA3 == CType.FNC_1) {
            cTypeA3 = a(charSequence, i + 1);
        }
        return cTypeA3 == CType.TWO_DIGITS ? 99 : 100;
    }
}
