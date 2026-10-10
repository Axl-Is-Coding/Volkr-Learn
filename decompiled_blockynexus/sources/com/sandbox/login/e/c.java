package com.sandbox.login.e;

import com.umeng.analytics.pro.ci;
import java.io.UnsupportedEncodingException;
import okio.Utf8;

/* JADX INFO: compiled from: Base64Utils.java */
/* JADX INFO: loaded from: classes2.dex */
public class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static char[] f15745a = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', '+', '/'};

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static byte[] f15746b = {-1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 62, -1, -1, -1, Utf8.REPLACEMENT_BYTE, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, -1, -1, -1, -1, -1, -1, -1, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, ci.k, ci.l, ci.m, ci.n, 17, 18, 19, 20, 21, 22, 23, 24, 25, -1, -1, -1, -1, -1, -1, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 42, 43, 44, 45, 46, 47, 48, 49, 50, 51, -1, -1, -1, -1, -1};

    public static String a(byte[] bArr) {
        StringBuilder sb = new StringBuilder();
        int length = bArr.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                break;
            }
            int i2 = i + 1;
            int i3 = bArr[i] & 255;
            if (i2 == length) {
                sb.append(f15745a[i3 >>> 2]);
                sb.append(f15745a[(i3 & 3) << 4]);
                sb.append("==");
                break;
            }
            int i4 = i2 + 1;
            int i5 = bArr[i2] & 255;
            if (i4 == length) {
                sb.append(f15745a[i3 >>> 2]);
                sb.append(f15745a[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
                sb.append(f15745a[(i5 & 15) << 2]);
                sb.append("=");
                break;
            }
            int i6 = i4 + 1;
            int i7 = bArr[i4] & 255;
            sb.append(f15745a[i3 >>> 2]);
            sb.append(f15745a[((i3 & 3) << 4) | ((i5 & 240) >>> 4)]);
            sb.append(f15745a[((i5 & 15) << 2) | ((i7 & 192) >>> 6)]);
            sb.append(f15745a[i7 & 63]);
            i = i6;
        }
        return sb.toString();
    }

    private static byte[] b(String str) throws UnsupportedEncodingException {
        int i;
        byte b2;
        int i2;
        byte b3;
        int i3;
        byte b4;
        int i4;
        byte b5;
        StringBuilder sb = new StringBuilder();
        byte[] bytes = str.getBytes("US-ASCII");
        int length = bytes.length;
        int i5 = 0;
        while (i5 < length) {
            while (true) {
                i = i5 + 1;
                b2 = f15746b[bytes[i5]];
                if (i >= length || b2 != -1) {
                    break;
                }
                i5 = i;
            }
            if (b2 == -1) {
                break;
            }
            while (true) {
                i2 = i + 1;
                b3 = f15746b[bytes[i]];
                if (i2 >= length || b3 != -1) {
                    break;
                }
                i = i2;
            }
            if (b3 == -1) {
                break;
            }
            sb.append((char) ((b2 << 2) | ((b3 & 48) >>> 4)));
            while (true) {
                i3 = i2 + 1;
                byte b6 = bytes[i2];
                if (b6 == 61) {
                    return sb.toString().getBytes("iso8859-1");
                }
                b4 = f15746b[b6];
                if (i3 >= length || b4 != -1) {
                    break;
                }
                i2 = i3;
            }
            if (b4 == -1) {
                break;
            }
            sb.append((char) (((b3 & ci.m) << 4) | ((b4 & 60) >>> 2)));
            while (true) {
                i4 = i3 + 1;
                byte b7 = bytes[i3];
                if (b7 == 61) {
                    return sb.toString().getBytes("iso8859-1");
                }
                b5 = f15746b[b7];
                if (i4 >= length || b5 != -1) {
                    break;
                }
                i3 = i4;
            }
            if (b5 == -1) {
                break;
            }
            sb.append((char) (b5 | ((b4 & 3) << 6)));
            i5 = i4;
        }
        return sb.toString().getBytes("iso8859-1");
    }

    public static byte[] a(String str) {
        try {
            return b(str);
        } catch (Exception e2) {
            e2.printStackTrace();
            return new byte[0];
        }
    }
}
