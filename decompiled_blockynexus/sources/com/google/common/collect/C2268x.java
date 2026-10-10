package com.google.common.collect;

/* JADX INFO: renamed from: com.google.common.collect.x, reason: case insensitive filesystem */
/* JADX INFO: compiled from: Hashing.java */
/* JADX INFO: loaded from: classes2.dex */
final class C2268x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static int f13967a = 1073741824;

    static int a(int i) {
        return Integer.rotateLeft(i * (-862048943), 15) * 461845907;
    }

    static int a(Object obj) {
        return a(obj == null ? 0 : obj.hashCode());
    }

    static int a(int i, double d2) {
        int iMax = Math.max(i, 2);
        int iHighestOneBit = Integer.highestOneBit(iMax);
        double d3 = iHighestOneBit;
        Double.isNaN(d3);
        if (iMax <= ((int) (d2 * d3))) {
            return iHighestOneBit;
        }
        int i2 = iHighestOneBit << 1;
        return i2 > 0 ? i2 : f13967a;
    }
}
