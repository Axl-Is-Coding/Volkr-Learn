package com.alibaba.mtl.log.d;

/* JADX INFO: compiled from: RC4.java */
/* JADX INFO: loaded from: classes.dex */
public class n {

    /* JADX INFO: compiled from: RC4.java */
    private static class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int[] f3643d;
        public int x;
        public int y;

        private a() {
            this.f3643d = new int[256];
        }
    }

    public static byte[] a(byte[] bArr, String str) {
        a aVarA;
        if (bArr == null || str == null || (aVarA = a(str)) == null) {
            return null;
        }
        return a(bArr, aVarA);
    }

    private static a a(String str) {
        if (str == null) {
            return null;
        }
        a aVar = new a();
        for (int i = 0; i < 256; i++) {
            aVar.f3643d[i] = i;
        }
        aVar.x = 0;
        aVar.y = 0;
        int length = 0;
        int iCharAt = 0;
        for (int i2 = 0; i2 < 256; i2++) {
            try {
                iCharAt = ((str.charAt(length) + aVar.f3643d[i2]) + iCharAt) % 256;
                int i3 = aVar.f3643d[i2];
                aVar.f3643d[i2] = aVar.f3643d[iCharAt];
                aVar.f3643d[iCharAt] = i3;
                length = (length + 1) % str.length();
            } catch (Exception unused) {
                return null;
            }
        }
        return aVar;
    }

    private static byte[] a(byte[] bArr, a aVar) {
        if (bArr == null || aVar == null) {
            return null;
        }
        int i = aVar.x;
        int i2 = aVar.y;
        for (int i3 = 0; i3 < bArr.length; i3++) {
            i = (i + 1) % 256;
            int[] iArr = aVar.f3643d;
            i2 = (iArr[i] + i2) % 256;
            int i4 = iArr[i];
            iArr[i] = iArr[i2];
            iArr[i2] = i4;
            int i5 = (iArr[i] + iArr[i2]) % 256;
            bArr[i3] = (byte) (iArr[i5] ^ bArr[i3]);
        }
        aVar.x = i;
        aVar.y = i2;
        return bArr;
    }
}
