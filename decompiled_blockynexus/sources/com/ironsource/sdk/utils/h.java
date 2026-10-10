package com.ironsource.sdk.utils;

/* JADX INFO: compiled from: MD5Hashing.java */
/* JADX INFO: loaded from: classes2.dex */
public final class h {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final byte[] f15428a = {-128, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f15429b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private a f15430c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private int[] f15431d = new int[16];

    /* JADX INFO: compiled from: MD5Hashing.java */
    private class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private boolean f15432a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private int[] f15433b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private long f15434c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private byte[] f15435d;

        /* JADX INFO: Access modifiers changed from: private */
        public void f(a aVar) {
            byte[] bArr = aVar.f15435d;
            byte[] bArr2 = this.f15435d;
            System.arraycopy(bArr, 0, bArr2, 0, bArr2.length);
            int[] iArr = aVar.f15433b;
            int[] iArr2 = this.f15433b;
            System.arraycopy(iArr, 0, iArr2, 0, iArr2.length);
            this.f15432a = aVar.f15432a;
            this.f15434c = aVar.f15434c;
        }

        private a() {
            this.f15432a = true;
            this.f15433b = new int[4];
            this.f15435d = new byte[64];
            a();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void a() {
            int[] iArr = this.f15433b;
            iArr[0] = 1732584193;
            iArr[1] = -271733879;
            iArr[2] = -1732584194;
            iArr[3] = 271733878;
            this.f15434c = 0L;
        }
    }

    h() {
        this.f15429b = new a();
        this.f15430c = new a();
        c();
    }

    private static int a(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + ((i3 & i2) | (i4 & (i2 ^ (-1)))) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    private static int b(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + ((i3 & (i4 ^ (-1))) | (i2 & i4)) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    private static int c(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + ((i3 ^ i2) ^ i4) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    private static int d(int i, int i2, int i3, int i4, int i5, int i6, int i7) {
        int i8 = i + (i3 ^ ((i4 ^ (-1)) | i2)) + i5 + i7;
        return ((i8 >>> (32 - i6)) | (i8 << i6)) + i2;
    }

    public byte[] a() {
        if (!this.f15430c.f15432a) {
            this.f15430c.f(this.f15429b);
            long j = this.f15430c.f15434c;
            int i = (int) ((j >>> 3) & 63);
            a(this.f15430c, f15428a, 0, i < 56 ? 56 - i : 120 - i);
            a(this.f15430c, a(j), 0, 8);
            this.f15430c.f15432a = true;
        }
        return a(this.f15430c.f15433b, 16);
    }

    public String b() {
        return b(a());
    }

    public void c() {
        this.f15429b.a();
        this.f15430c.f15432a = false;
    }

    public String toString() {
        return b();
    }

    public void b(String str) {
        a(str.getBytes());
    }

    private static String b(byte[] bArr) {
        StringBuffer stringBuffer = new StringBuffer(bArr.length * 2);
        for (byte b2 : bArr) {
            int i = b2 & 255;
            if (i < 16) {
                stringBuffer.append("0");
            }
            stringBuffer.append(Integer.toHexString(i));
        }
        return stringBuffer.toString();
    }

    public static String a(String str) {
        h hVar = new h();
        hVar.b(str);
        return hVar.b();
    }

    private int[] b(byte[] bArr, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i; i4 += 4) {
            this.f15431d[i3] = (bArr[i4 + i2] & 255) | ((bArr[(i4 + 1) + i2] & 255) << 8) | ((bArr[(i4 + 2) + i2] & 255) << 16) | ((bArr[(i4 + 3) + i2] & 255) << 24);
            i3++;
        }
        return this.f15431d;
    }

    private void a(a aVar, byte[] bArr, int i, int i2) {
        int i3 = 0;
        this.f15430c.f15432a = false;
        if (i2 + i > bArr.length) {
            i2 = bArr.length - i;
        }
        int i4 = ((int) (aVar.f15434c >>> 3)) & 63;
        aVar.f15434c += (long) (i2 << 3);
        int i5 = 64 - i4;
        if (i2 >= i5) {
            System.arraycopy(bArr, i, aVar.f15435d, i4, i5);
            a(aVar, b(aVar.f15435d, 64, 0));
            while (i5 + 63 < i2) {
                a(aVar, b(bArr, 64, i5));
                i5 += 64;
            }
            i3 = i5;
            i4 = 0;
        }
        if (i3 < i2) {
            for (int i6 = i3; i6 < i2; i6++) {
                aVar.f15435d[(i4 + i6) - i3] = bArr[i6 + i];
            }
        }
    }

    public void a(byte[] bArr, int i, int i2) {
        a(this.f15429b, bArr, i, i2);
    }

    public void a(byte[] bArr) {
        a(bArr, 0, bArr.length);
    }

    private static byte[] a(long j) {
        return new byte[]{(byte) (j & 255), (byte) ((j >>> 8) & 255), (byte) ((j >>> 16) & 255), (byte) ((j >>> 24) & 255), (byte) ((j >>> 32) & 255), (byte) ((j >>> 40) & 255), (byte) ((j >>> 48) & 255), (byte) ((j >>> 56) & 255)};
    }

    private static byte[] a(int[] iArr, int i) {
        byte[] bArr = new byte[i];
        int i2 = 0;
        for (int i3 = 0; i3 < i; i3 += 4) {
            bArr[i3] = (byte) (iArr[i2] & 255);
            bArr[i3 + 1] = (byte) ((iArr[i2] >>> 8) & 255);
            bArr[i3 + 2] = (byte) ((iArr[i2] >>> 16) & 255);
            bArr[i3 + 3] = (byte) ((iArr[i2] >>> 24) & 255);
            i2++;
        }
        return bArr;
    }

    private static void a(a aVar, int[] iArr) {
        int i = aVar.f15433b[0];
        int i2 = aVar.f15433b[1];
        int i3 = aVar.f15433b[2];
        int i4 = aVar.f15433b[3];
        int iA = a(i, i2, i3, i4, iArr[0], 7, -680876936);
        int iA2 = a(i4, iA, i2, i3, iArr[1], 12, -389564586);
        int iA3 = a(i3, iA2, iA, i2, iArr[2], 17, 606105819);
        int iA4 = a(i2, iA3, iA2, iA, iArr[3], 22, -1044525330);
        int iA5 = a(iA, iA4, iA3, iA2, iArr[4], 7, -176418897);
        int iA6 = a(iA2, iA5, iA4, iA3, iArr[5], 12, 1200080426);
        int iA7 = a(iA3, iA6, iA5, iA4, iArr[6], 17, -1473231341);
        int iA8 = a(iA4, iA7, iA6, iA5, iArr[7], 22, -45705983);
        int iA9 = a(iA5, iA8, iA7, iA6, iArr[8], 7, 1770035416);
        int iA10 = a(iA6, iA9, iA8, iA7, iArr[9], 12, -1958414417);
        int iA11 = a(iA7, iA10, iA9, iA8, iArr[10], 17, -42063);
        int iA12 = a(iA8, iA11, iA10, iA9, iArr[11], 22, -1990404162);
        int iA13 = a(iA9, iA12, iA11, iA10, iArr[12], 7, 1804603682);
        int iA14 = a(iA10, iA13, iA12, iA11, iArr[13], 12, -40341101);
        int iA15 = a(iA11, iA14, iA13, iA12, iArr[14], 17, -1502002290);
        int iA16 = a(iA12, iA15, iA14, iA13, iArr[15], 22, 1236535329);
        int iB = b(iA13, iA16, iA15, iA14, iArr[1], 5, -165796510);
        int iB2 = b(iA14, iB, iA16, iA15, iArr[6], 9, -1069501632);
        int iB3 = b(iA15, iB2, iB, iA16, iArr[11], 14, 643717713);
        int iB4 = b(iA16, iB3, iB2, iB, iArr[0], 20, -373897302);
        int iB5 = b(iB, iB4, iB3, iB2, iArr[5], 5, -701558691);
        int iB6 = b(iB2, iB5, iB4, iB3, iArr[10], 9, 38016083);
        int iB7 = b(iB3, iB6, iB5, iB4, iArr[15], 14, -660478335);
        int iB8 = b(iB4, iB7, iB6, iB5, iArr[4], 20, -405537848);
        int iB9 = b(iB5, iB8, iB7, iB6, iArr[9], 5, 568446438);
        int iB10 = b(iB6, iB9, iB8, iB7, iArr[14], 9, -1019803690);
        int iB11 = b(iB7, iB10, iB9, iB8, iArr[3], 14, -187363961);
        int iB12 = b(iB8, iB11, iB10, iB9, iArr[8], 20, 1163531501);
        int iB13 = b(iB9, iB12, iB11, iB10, iArr[13], 5, -1444681467);
        int iB14 = b(iB10, iB13, iB12, iB11, iArr[2], 9, -51403784);
        int iB15 = b(iB11, iB14, iB13, iB12, iArr[7], 14, 1735328473);
        int iB16 = b(iB12, iB15, iB14, iB13, iArr[12], 20, -1926607734);
        int iC = c(iB13, iB16, iB15, iB14, iArr[5], 4, -378558);
        int iC2 = c(iB14, iC, iB16, iB15, iArr[8], 11, -2022574463);
        int iC3 = c(iB15, iC2, iC, iB16, iArr[11], 16, 1839030562);
        int iC4 = c(iB16, iC3, iC2, iC, iArr[14], 23, -35309556);
        int iC5 = c(iC, iC4, iC3, iC2, iArr[1], 4, -1530992060);
        int iC6 = c(iC2, iC5, iC4, iC3, iArr[4], 11, 1272893353);
        int iC7 = c(iC3, iC6, iC5, iC4, iArr[7], 16, -155497632);
        int iC8 = c(iC4, iC7, iC6, iC5, iArr[10], 23, -1094730640);
        int iC9 = c(iC5, iC8, iC7, iC6, iArr[13], 4, 681279174);
        int iC10 = c(iC6, iC9, iC8, iC7, iArr[0], 11, -358537222);
        int iC11 = c(iC7, iC10, iC9, iC8, iArr[3], 16, -722521979);
        int iC12 = c(iC8, iC11, iC10, iC9, iArr[6], 23, 76029189);
        int iC13 = c(iC9, iC12, iC11, iC10, iArr[9], 4, -640364487);
        int iC14 = c(iC10, iC13, iC12, iC11, iArr[12], 11, -421815835);
        int iC15 = c(iC11, iC14, iC13, iC12, iArr[15], 16, 530742520);
        int iC16 = c(iC12, iC15, iC14, iC13, iArr[2], 23, -995338651);
        int iD = d(iC13, iC16, iC15, iC14, iArr[0], 6, -198630844);
        int iD2 = d(iC14, iD, iC16, iC15, iArr[7], 10, 1126891415);
        int iD3 = d(iC15, iD2, iD, iC16, iArr[14], 15, -1416354905);
        int iD4 = d(iC16, iD3, iD2, iD, iArr[5], 21, -57434055);
        int iD5 = d(iD, iD4, iD3, iD2, iArr[12], 6, 1700485571);
        int iD6 = d(iD2, iD5, iD4, iD3, iArr[3], 10, -1894986606);
        int iD7 = d(iD3, iD6, iD5, iD4, iArr[10], 15, -1051523);
        int iD8 = d(iD4, iD7, iD6, iD5, iArr[1], 21, -2054922799);
        int iD9 = d(iD5, iD8, iD7, iD6, iArr[8], 6, 1873313359);
        int iD10 = d(iD6, iD9, iD8, iD7, iArr[15], 10, -30611744);
        int iD11 = d(iD7, iD10, iD9, iD8, iArr[6], 15, -1560198380);
        int iD12 = d(iD8, iD11, iD10, iD9, iArr[13], 21, 1309151649);
        int iD13 = d(iD9, iD12, iD11, iD10, iArr[4], 6, -145523070);
        int iD14 = d(iD10, iD13, iD12, iD11, iArr[11], 10, -1120210379);
        int iD15 = d(iD11, iD14, iD13, iD12, iArr[2], 15, 718787259);
        int iD16 = d(iD12, iD15, iD14, iD13, iArr[9], 21, -343485551);
        int[] iArr2 = aVar.f15433b;
        iArr2[0] = iArr2[0] + iD13;
        int[] iArr3 = aVar.f15433b;
        iArr3[1] = iArr3[1] + iD16;
        int[] iArr4 = aVar.f15433b;
        iArr4[2] = iArr4[2] + iD15;
        int[] iArr5 = aVar.f15433b;
        iArr5[3] = iArr5[3] + iD14;
    }
}
