package com.google.zxing.d.a;

import com.google.zxing.EncodeHintType;
import com.google.zxing.WriterException;
import com.google.zxing.common.CharacterSetECI;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;
import com.google.zxing.qrcode.decoder.Mode;
import com.google.zxing.qrcode.decoder.a;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: Encoder.java */
/* JADX INFO: loaded from: classes2.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final int[] f14439a = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 36, -1, -1, -1, 37, 38, -1, -1, -1, -1, 39, 40, -1, 41, 42, 43, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 44, -1, -1, -1, -1, -1, -1, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, -1, -1, -1, -1, -1};

    private static int a(b bVar) {
        return e.a(bVar) + e.b(bVar) + e.c(bVar) + e.d(bVar);
    }

    static void b(CharSequence charSequence, com.google.zxing.common.a aVar) {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iCharAt = charSequence.charAt(i) - '0';
            int i2 = i + 2;
            if (i2 < length) {
                aVar.a((iCharAt * 100) + ((charSequence.charAt(i + 1) - '0') * 10) + (charSequence.charAt(i2) - '0'), 10);
                i += 3;
            } else {
                i++;
                if (i < length) {
                    aVar.a((iCharAt * 10) + (charSequence.charAt(i) - '0'), 7);
                    i = i2;
                } else {
                    aVar.a(iCharAt, 4);
                }
            }
        }
    }

    public static g a(String str, ErrorCorrectionLevel errorCorrectionLevel, Map<EncodeHintType, ?> map) throws WriterException {
        com.google.zxing.qrcode.decoder.a aVarA;
        CharacterSetECI characterSetECIByName;
        boolean z = map != null && map.containsKey(EncodeHintType.CHARACTER_SET);
        String string = z ? map.get(EncodeHintType.CHARACTER_SET).toString() : "ISO-8859-1";
        Mode modeA = a(str, string);
        com.google.zxing.common.a aVar = new com.google.zxing.common.a();
        if (modeA == Mode.BYTE && z && (characterSetECIByName = CharacterSetECI.getCharacterSetECIByName(string)) != null) {
            a(characterSetECIByName, aVar);
        }
        if ((map != null && map.containsKey(EncodeHintType.GS1_FORMAT)) && Boolean.valueOf(map.get(EncodeHintType.GS1_FORMAT).toString()).booleanValue()) {
            a(Mode.FNC1_FIRST_POSITION, aVar);
        }
        a(modeA, aVar);
        com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
        a(str, modeA, aVar2, string);
        if (map != null && map.containsKey(EncodeHintType.QR_VERSION)) {
            aVarA = com.google.zxing.qrcode.decoder.a.a(Integer.parseInt(map.get(EncodeHintType.QR_VERSION).toString()));
            if (!a(a(modeA, aVar, aVar2, aVarA), aVarA, errorCorrectionLevel)) {
                throw new WriterException("Data too big for requested version");
            }
        } else {
            aVarA = a(errorCorrectionLevel, modeA, aVar, aVar2);
        }
        com.google.zxing.common.a aVar3 = new com.google.zxing.common.a();
        aVar3.a(aVar);
        a(modeA == Mode.BYTE ? aVar2.c() : str.length(), aVarA, modeA, aVar3);
        aVar3.a(aVar2);
        a.b bVarA = aVarA.a(errorCorrectionLevel);
        int iB = aVarA.b() - bVarA.d();
        a(iB, aVar3);
        com.google.zxing.common.a aVarA2 = a(aVar3, aVarA.b(), iB, bVarA.c());
        g gVar = new g();
        gVar.a(errorCorrectionLevel);
        gVar.a(modeA);
        gVar.a(aVarA);
        int iA = aVarA.a();
        b bVar = new b(iA, iA);
        int iA2 = a(aVarA2, errorCorrectionLevel, aVarA, bVar);
        gVar.b(iA2);
        f.a(aVarA2, errorCorrectionLevel, aVarA, iA2, bVar);
        gVar.a(bVar);
        return gVar;
    }

    private static com.google.zxing.qrcode.decoder.a a(ErrorCorrectionLevel errorCorrectionLevel, Mode mode, com.google.zxing.common.a aVar, com.google.zxing.common.a aVar2) throws WriterException {
        return a(a(mode, aVar, aVar2, a(a(mode, aVar, aVar2, com.google.zxing.qrcode.decoder.a.a(1)), errorCorrectionLevel)), errorCorrectionLevel);
    }

    private static int a(Mode mode, com.google.zxing.common.a aVar, com.google.zxing.common.a aVar2, com.google.zxing.qrcode.decoder.a aVar3) {
        return aVar.b() + mode.getCharacterCountBits(aVar3) + aVar2.b();
    }

    static int a(int i) {
        int[] iArr = f14439a;
        if (i < iArr.length) {
            return iArr[i];
        }
        return -1;
    }

    private static Mode a(String str, String str2) {
        if ("Shift_JIS".equals(str2) && a(str)) {
            return Mode.KANJI;
        }
        boolean z = false;
        boolean z2 = false;
        for (int i = 0; i < str.length(); i++) {
            char cCharAt = str.charAt(i);
            if (cCharAt >= '0' && cCharAt <= '9') {
                z2 = true;
            } else {
                if (a(cCharAt) == -1) {
                    return Mode.BYTE;
                }
                z = true;
            }
        }
        if (z) {
            return Mode.ALPHANUMERIC;
        }
        if (z2) {
            return Mode.NUMERIC;
        }
        return Mode.BYTE;
    }

    private static boolean a(String str) {
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            if (length % 2 != 0) {
                return false;
            }
            for (int i = 0; i < length; i += 2) {
                int i2 = bytes[i] & 255;
                if ((i2 < 129 || i2 > 159) && (i2 < 224 || i2 > 235)) {
                    return false;
                }
            }
            return true;
        } catch (UnsupportedEncodingException unused) {
            return false;
        }
    }

    private static int a(com.google.zxing.common.a aVar, ErrorCorrectionLevel errorCorrectionLevel, com.google.zxing.qrcode.decoder.a aVar2, b bVar) throws WriterException {
        int i = Integer.MAX_VALUE;
        int i2 = -1;
        for (int i3 = 0; i3 < 8; i3++) {
            f.a(aVar, errorCorrectionLevel, aVar2, i3, bVar);
            int iA = a(bVar);
            if (iA < i) {
                i2 = i3;
                i = iA;
            }
        }
        return i2;
    }

    private static com.google.zxing.qrcode.decoder.a a(int i, ErrorCorrectionLevel errorCorrectionLevel) throws WriterException {
        for (int i2 = 1; i2 <= 40; i2++) {
            com.google.zxing.qrcode.decoder.a aVarA = com.google.zxing.qrcode.decoder.a.a(i2);
            if (a(i, aVarA, errorCorrectionLevel)) {
                return aVarA;
            }
        }
        throw new WriterException("Data too big");
    }

    private static boolean a(int i, com.google.zxing.qrcode.decoder.a aVar, ErrorCorrectionLevel errorCorrectionLevel) {
        return aVar.b() - aVar.a(errorCorrectionLevel).d() >= (i + 7) / 8;
    }

    static void a(int i, com.google.zxing.common.a aVar) throws WriterException {
        int i2 = i << 3;
        if (aVar.b() <= i2) {
            for (int i3 = 0; i3 < 4 && aVar.b() < i2; i3++) {
                aVar.a(false);
            }
            int iB = aVar.b() & 7;
            if (iB > 0) {
                while (iB < 8) {
                    aVar.a(false);
                    iB++;
                }
            }
            int iC = i - aVar.c();
            for (int i4 = 0; i4 < iC; i4++) {
                aVar.a((i4 & 1) == 0 ? 236 : 17, 8);
            }
            if (aVar.b() != i2) {
                throw new WriterException("Bits size does not equal capacity");
            }
            return;
        }
        throw new WriterException("data bits cannot fit in the QR Code" + aVar.b() + " > " + i2);
    }

    static void a(int i, int i2, int i3, int i4, int[] iArr, int[] iArr2) throws WriterException {
        if (i4 < i3) {
            int i5 = i % i3;
            int i6 = i3 - i5;
            int i7 = i / i3;
            int i8 = i7 + 1;
            int i9 = i2 / i3;
            int i10 = i9 + 1;
            int i11 = i7 - i9;
            int i12 = i8 - i10;
            if (i11 != i12) {
                throw new WriterException("EC bytes mismatch");
            }
            if (i3 != i6 + i5) {
                throw new WriterException("RS blocks mismatch");
            }
            if (i != ((i9 + i11) * i6) + ((i10 + i12) * i5)) {
                throw new WriterException("Total bytes mismatch");
            }
            if (i4 < i6) {
                iArr[0] = i9;
                iArr2[0] = i11;
                return;
            } else {
                iArr[0] = i10;
                iArr2[0] = i12;
                return;
            }
        }
        throw new WriterException("Block ID too large");
    }

    static com.google.zxing.common.a a(com.google.zxing.common.a aVar, int i, int i2, int i3) throws WriterException {
        if (aVar.c() == i2) {
            ArrayList arrayList = new ArrayList(i3);
            int i4 = 0;
            int iMax = 0;
            int iMax2 = 0;
            for (int i5 = 0; i5 < i3; i5++) {
                int[] iArr = new int[1];
                int[] iArr2 = new int[1];
                a(i, i2, i3, i5, iArr, iArr2);
                int i6 = iArr[0];
                byte[] bArr = new byte[i6];
                aVar.a(i4 << 3, bArr, 0, i6);
                byte[] bArrA = a(bArr, iArr2[0]);
                arrayList.add(new a(bArr, bArrA));
                iMax = Math.max(iMax, i6);
                iMax2 = Math.max(iMax2, bArrA.length);
                i4 += iArr[0];
            }
            if (i2 == i4) {
                com.google.zxing.common.a aVar2 = new com.google.zxing.common.a();
                for (int i7 = 0; i7 < iMax; i7++) {
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        byte[] bArrA2 = ((a) it.next()).a();
                        if (i7 < bArrA2.length) {
                            aVar2.a(bArrA2[i7], 8);
                        }
                    }
                }
                for (int i8 = 0; i8 < iMax2; i8++) {
                    Iterator it2 = arrayList.iterator();
                    while (it2.hasNext()) {
                        byte[] bArrB = ((a) it2.next()).b();
                        if (i8 < bArrB.length) {
                            aVar2.a(bArrB[i8], 8);
                        }
                    }
                }
                if (i == aVar2.c()) {
                    return aVar2;
                }
                throw new WriterException("Interleaving error: " + i + " and " + aVar2.c() + " differ.");
            }
            throw new WriterException("Data bytes does not match offset");
        }
        throw new WriterException("Number of bits and data bytes does not match");
    }

    static byte[] a(byte[] bArr, int i) {
        int length = bArr.length;
        int[] iArr = new int[length + i];
        for (int i2 = 0; i2 < length; i2++) {
            iArr[i2] = bArr[i2] & 255;
        }
        new com.google.zxing.common.reedsolomon.c(com.google.zxing.common.reedsolomon.a.f14427e).a(iArr, i);
        byte[] bArr2 = new byte[i];
        for (int i3 = 0; i3 < i; i3++) {
            bArr2[i3] = (byte) iArr[length + i3];
        }
        return bArr2;
    }

    static void a(Mode mode, com.google.zxing.common.a aVar) {
        aVar.a(mode.getBits(), 4);
    }

    static void a(int i, com.google.zxing.qrcode.decoder.a aVar, Mode mode, com.google.zxing.common.a aVar2) throws WriterException {
        int characterCountBits = mode.getCharacterCountBits(aVar);
        int i2 = 1 << characterCountBits;
        if (i < i2) {
            aVar2.a(i, characterCountBits);
            return;
        }
        throw new WriterException(i + " is bigger than " + (i2 - 1));
    }

    static void a(String str, Mode mode, com.google.zxing.common.a aVar, String str2) throws WriterException {
        int i = c.f14438a[mode.ordinal()];
        if (i == 1) {
            b(str, aVar);
            return;
        }
        if (i == 2) {
            a((CharSequence) str, aVar);
        } else if (i == 3) {
            a(str, aVar, str2);
        } else {
            if (i == 4) {
                a(str, aVar);
                return;
            }
            throw new WriterException("Invalid mode: ".concat(String.valueOf(mode)));
        }
    }

    static void a(CharSequence charSequence, com.google.zxing.common.a aVar) throws WriterException {
        int length = charSequence.length();
        int i = 0;
        while (i < length) {
            int iA = a(charSequence.charAt(i));
            if (iA == -1) {
                throw new WriterException();
            }
            int i2 = i + 1;
            if (i2 < length) {
                int iA2 = a(charSequence.charAt(i2));
                if (iA2 != -1) {
                    aVar.a((iA * 45) + iA2, 11);
                    i += 2;
                } else {
                    throw new WriterException();
                }
            } else {
                aVar.a(iA, 6);
                i = i2;
            }
        }
    }

    static void a(String str, com.google.zxing.common.a aVar, String str2) throws WriterException {
        try {
            for (byte b2 : str.getBytes(str2)) {
                aVar.a(b2, 8);
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    static void a(String str, com.google.zxing.common.a aVar) throws WriterException {
        int i;
        try {
            byte[] bytes = str.getBytes("Shift_JIS");
            int length = bytes.length;
            for (int i2 = 0; i2 < length; i2 += 2) {
                int i3 = ((bytes[i2] & 255) << 8) | (bytes[i2 + 1] & 255);
                int i4 = 33088;
                if (i3 >= 33088 && i3 <= 40956) {
                    i = i3 - i4;
                } else if (i3 < 57408 || i3 > 60351) {
                    i = -1;
                } else {
                    i4 = 49472;
                    i = i3 - i4;
                }
                if (i != -1) {
                    aVar.a(((i >> 8) * 192) + (i & 255), 13);
                } else {
                    throw new WriterException("Invalid byte sequence");
                }
            }
        } catch (UnsupportedEncodingException e2) {
            throw new WriterException(e2);
        }
    }

    private static void a(CharacterSetECI characterSetECI, com.google.zxing.common.a aVar) {
        aVar.a(Mode.ECI.getBits(), 4);
        aVar.a(characterSetECI.getValue(), 8);
    }
}
