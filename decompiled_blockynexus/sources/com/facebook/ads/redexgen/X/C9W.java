package com.facebook.ads.redexgen.X;

import androidx.annotation.VisibleForTesting;
import com.umeng.analytics.pro.ci;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Locale;
import okio.Utf8;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9W, reason: invalid class name */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C9W implements Closeable {
    public static byte[] A03;
    public static String[] A04;
    public final C9M A01;
    public final Deque<C9V> A02 = new LinkedList();
    public boolean A00 = false;

    static {
        A04();
        A03();
    }

    public static String A02(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A03, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            int i5 = bArrCopyOfRange[i4] ^ i3;
            if (A04[5].length() != 16) {
                throw new RuntimeException();
            }
            String[] strArr = A04;
            strArr[0] = "u097qyCEcqL0dCUFF3RqUSqj";
            strArr[6] = "TBb0mUAcLDsBFXHpNBOq9rzF";
            bArrCopyOfRange[i4] = (byte) (i5 ^ 113);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A03() {
        byte[] bArr = {5, 41, 51, 42, 34, 102, 40, 41, 50, 102, 39, 34, 34, 102, 52, 35, 37, 41, 52, 34, 102, 50, 41, 102, 40, 35, 49, 42, Utf8.REPLACEMENT_BYTE, 102, 39, 34, 34, 35, 34, 102, 32, 47, 42, 35, 42, ci.k, 5, 0, 9, 8, 76, 24, 3, 76, 8, 9, 0, 9, 24, 9, 76, 10, 5, 0, 9, 76, 75, 73, 31, 75, 106, 77, 69, 64, 73, 72, 12, 88, 67, 12, 64, 69, 95, 88, 12, 74, 69, 64, 73, 72, 12, 69, 66, 12, 72, 69, 94, 73, 79, 88, 67, 94, 85, 12, 11, 9, 95, 11, 28, 59, 51, 54, Utf8.REPLACEMENT_BYTE, 62, 122, 46, 53, 122, 54, 53, 59, 62, 122, 60, 51, 54, Utf8.REPLACEMENT_BYTE, 122, 125, 127, 41, 125, 118, 122, 41, 49, 51, 42, 42, 51, 52, 61, 122, 59, 54, 54, 122, 42, 40, Utf8.REPLACEMENT_BYTE, 44, 51, 53, 47, 41, 122, 60, 51, 54, Utf8.REPLACEMENT_BYTE, 41, 122, 47, 52, 46, 51, 54, 122, 127, 62, 61, 28, 29, 94, ci.n, 28, 29, 7, 26, 20, 6, 28, 6, 0, 83, 29, 18, 30, 22, 23, 83, 21, 26, 31, 22, 83, 26, 29, 83, 31, 28, 20, 20, 26, 29, 20, 83, 23, 26, 1, 22, ci.n, 7, 28, 1, 10, 73, 83, 86, 23, 95, 83, 30, 26, 29, 83, 26, 0, 83, 86, 23, 29, 42, 44, 32, 61, 43, 9, 38, 35, 42, 28, 42, 62, 58, 42, 33, 44, 42, 111, 46, 35, 61, 42, 46, 43, 54, 111, 44, 35, 32, 60, 42, 43, 107, 80, 85, 80, 81, 73, 80, 30, 88, 87, 82, 91, 30, 87, 80, 30, 82, 81, 89, 89, 87, 80, 89, 30, 90, 87, 76, 91, 93, 74, 81, 76, 71, 4, 30, 25, 27, 77, 25};
        String[] strArr = A04;
        if (strArr[3].charAt(18) != strArr[2].charAt(18)) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[3] = "rXUNYUFSY3Wwjf0Rt9wI3pKgcM0mrVi5";
        strArr2[2] = "NbfmFkvRWQfztm8Xt0wszzyUhHEjBSFU";
        A03 = bArr;
    }

    public static void A04() {
        A04 = new String[]{"Gii7pzXwK3MpiHC8B9NJqbzL", "8Pqq6WSNf8vKrPOx7XSY9C7", "LI4waC8pDZc7B2Ob9Mw4umyD0YVp7Iep", "HQVOS1q9k5iJuCSZxlwiHtDpSPIo2CAf", "0wBrPWYDPAFL7IDgbo0bQ8s", "e5cW7wYXRGqKaYX8", "aNUR51q123XM3tsFczjtkJvp", "F8bzMC9kGkJ5CLi2olbpsia5Bq7Sq0"};
    }

    public C9W(C9M c9m, C9U c9u) throws IOException {
        this.A01 = c9m;
        A06(c9m, c9u);
        if (this.A02.isEmpty()) {
            A00();
        }
    }

    private C9V A00() throws IOException {
        int iA00 = -1;
        if (!this.A02.isEmpty()) {
            iA00 = this.A02.getLast().A00();
        }
        int i = iA00 + 1;
        this.A02.add(new C9V(i, new C9S(new File(this.A01.A05(), A01(i)))));
        return this.A02.getLast();
    }

    @VisibleForTesting
    public static String A01(int i) {
        return Integer.toString(i);
    }

    private void A05(int i, File file) throws IOException {
        C9S c9s = new C9S(file);
        c9s.A05();
        this.A02.addFirst(new C9V(i, c9s));
    }

    private void A06(C9M c9m, C9U c9u) throws IOException {
        File[] fileArrListFiles = c9m.A05().listFiles();
        if (fileArrListFiles != null) {
            HashMap map = new HashMap();
            HashSet<File> hashSet = new HashSet();
            int i = -1;
            for (File file : fileArrListFiles) {
                try {
                    int i2 = Integer.parseInt(file.getName());
                    map.put(Integer.valueOf(i2), file);
                    if (i2 > i) {
                        i = i2;
                    }
                } catch (NumberFormatException unused) {
                    hashSet.add(file);
                    c9u.ACo(String.format(Locale.US, A02(260, 39, 79), file.getCanonicalPath()));
                }
            }
            if (!map.isEmpty()) {
                int i3 = i;
                while (map.containsKey(Integer.valueOf(i3 - 1))) {
                    i3--;
                }
                Iterator it = new HashSet(map.keySet()).iterator();
                while (it.hasNext()) {
                    int iIntValue = ((Integer) it.next()).intValue();
                    if (iIntValue < i3) {
                        c9u.ACo(String.format(Locale.US, A02(166, 61, 2), Integer.valueOf(iIntValue), Integer.valueOf(i3)));
                        hashSet.add(map.remove(Integer.valueOf(iIntValue)));
                    }
                }
                while (i >= i3) {
                    Integer numValueOf = Integer.valueOf(i);
                    if (A04[7].length() == 23) {
                        throw new RuntimeException();
                    }
                    String[] strArr = A04;
                    strArr[5] = "fmCLvQkSN3nY4ZJN";
                    strArr[5] = "fmCLvQkSN3nY4ZJN";
                    File file2 = (File) map.get(numValueOf);
                    try {
                        A05(i, file2);
                        map.remove(Integer.valueOf(i));
                        i--;
                    } catch (IOException e2) {
                        c9u.ACp(String.format(Locale.US, A02(104, 62, 43), file2.getCanonicalPath(), Integer.valueOf(i)), e2);
                        hashSet.addAll(map.values());
                    }
                }
            }
            for (File file3 : hashSet) {
                if (!file3.delete()) {
                    c9u.ACo(String.format(Locale.US, A02(40, 26, 29), file3.getCanonicalPath()));
                }
            }
            return;
        }
        throw new IOException(String.format(Locale.US, A02(66, 38, 93), c9m.A05().getCanonicalPath()));
    }

    public final synchronized int A07() throws IOException {
        if (!this.A00) {
            if (this.A02.isEmpty()) {
                return -1;
            }
            return this.A02.getFirst().A00();
        }
        throw new IOException(A02(227, 33, 62));
    }

    public final synchronized int A08() throws IOException {
        if (!this.A00) {
            if (this.A02.isEmpty()) {
                return 0;
            }
            return this.A02.getFirst().A01();
        }
        throw new IOException(A02(227, 33, 62));
    }

    public final synchronized int A09() throws IOException {
        if (!this.A00) {
        } else {
            throw new IOException(A02(227, 33, 62));
        }
        return this.A02.size();
    }

    public final synchronized int A0A() throws IOException {
        int iA01;
        if (!this.A00) {
            iA01 = 0;
            Iterator<C9V> it = this.A02.iterator();
            while (it.hasNext()) {
                iA01 += it.next().A01();
            }
        } else {
            throw new IOException(A02(227, 33, 62));
        }
        return iA01;
    }

    public final synchronized C9K A0B(int i, int i2, byte[] bArr, int i3, int[] iArr, int i4) throws IOException {
        if (!this.A00) {
            for (C9V c9v : this.A02) {
                if (c9v.A00() == i) {
                    return new C9K(i, c9v.A02(i2, bArr, i3, iArr, i4));
                }
            }
            return new C9K(-1, new C9J(C9I.A04, -1, -1, 0));
        }
        throw new IOException(A02(227, 33, 62));
    }

    public final synchronized void A0C() throws IOException {
        if (!this.A00) {
            for (C9V file : this.A02) {
                file.A04();
            }
            this.A02.clear();
            A00();
        } else {
            throw new IOException(A02(227, 33, 62));
        }
        String[] strArr = A04;
        if (strArr[0].length() != strArr[6].length()) {
            throw new RuntimeException();
        }
        String[] strArr2 = A04;
        strArr2[0] = "Q8tRgYQjLjZu9wWv5pfP6FNK";
        strArr2[6] = "ZBO8PuR7N2UupXyTknUyfTWg";
    }

    public final synchronized void A0D(byte[] bArr) throws IOException {
        if (!this.A00) {
            if ((this.A02.isEmpty() || !this.A02.getLast().A05(bArr)) && !A00().A05(bArr)) {
                throw new IOException(A02(0, 40, 55));
            }
        } else {
            throw new IOException(A02(227, 33, 62));
        }
    }

    public final synchronized boolean A0E() throws IOException {
        if (!this.A00) {
            if (this.A02.size() > 1) {
                C9V first = this.A02.getFirst();
                this.A02.removeFirst();
                first.A04();
                return true;
            }
            return false;
        }
        throw new IOException(A02(227, 33, 62));
    }

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public final synchronized void close() throws IOException {
        if (this.A00) {
            return;
        }
        this.A00 = true;
        for (C9V file : this.A02) {
            file.A03();
        }
    }
}
