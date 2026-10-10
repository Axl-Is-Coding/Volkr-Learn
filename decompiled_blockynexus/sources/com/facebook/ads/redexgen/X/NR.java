package com.facebook.ads.redexgen.X;

import java.util.Arrays;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public enum NR {
    A06(0),
    A05(1),
    A04(2);

    public static byte[] A01;
    public static String[] A02;
    public int A00;

    public static String A01(int i, int i2, int i3) {
        byte[] bArrCopyOfRange = Arrays.copyOfRange(A01, i, i + i2);
        for (int i4 = 0; i4 < bArrCopyOfRange.length; i4++) {
            bArrCopyOfRange[i4] = (byte) ((bArrCopyOfRange[i4] ^ i3) ^ 67);
        }
        return new String(bArrCopyOfRange);
    }

    public static void A02() {
        A01 = new byte[]{46, 35, 44, 38, 49, 33, 35, 50, 39, 77, 82, 79, 73, 79, 92, 84, 73, 102, 125, 96, 99, 118, 112, 122, 117, 122, 118, 119};
    }

    public static void A03() {
        A02 = new String[]{"rZGvvZMI6I", "wpdicw5jfWUP9Cs9nncu65zzvPXSjTXh", "qXEMgnv7Ct425l7In8PWxhOPFYVbEYpB", "dTodKdBY68fO6HNBSU3LN7qZJ4nOCEpk", "Hkjhu", "mY7TKQYFYXm3BBS2pDypGTbdY20sKsEk", "u0FGaDIimXxXG0l3UqPLAtx16Sc8Y059", "GEphX9PDUn8ir5euMIdeMTZrm9gVIFzw"};
    }

    static {
        A03();
        A02();
    }

    NR(int i) {
        this.A00 = i;
    }

    public static NR A00(int i) throws CloneNotSupportedException {
        for (NR nr : valuesCustom()) {
            if (nr.A00 == i) {
                return nr;
            }
        }
        return A05;
    }

    public final int A04() {
        return this.A00;
    }

    /* JADX INFO: renamed from: values, reason: to resolve conflict with enum method */
    public static NR[] valuesCustom() throws CloneNotSupportedException {
        Object objClone = values().clone();
        if (A02[4].length() == 18) {
            throw new RuntimeException();
        }
        String[] strArr = A02;
        strArr[4] = "9YF3oPenjmVnddjujEMQmJq4m";
        strArr[4] = "9YF3oPenjmVnddjujEMQmJq4m";
        return (NR[]) objClone;
    }
}
