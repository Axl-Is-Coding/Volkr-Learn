package com.facebook.ads.redexgen.X;

import java.util.UUID;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.9o, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public final class C14729o {
    public static final int A00;
    public static final UUID A01;
    public static final UUID A02;
    public static final UUID A03;
    public static final UUID A04;
    public static final UUID A05;

    static {
        int i;
        if (IW.A02 < 23) {
            i = 1020;
        } else {
            i = 6396;
        }
        A00 = i;
        A04 = new UUID(0L, 0L);
        A02 = new UUID(1186680826959645954L, -5988876978535335093L);
        A01 = new UUID(-2129748144642739255L, 8654423357094679310L);
        A05 = new UUID(-1301668207276963122L, -6645017420763422227L);
        A03 = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long A00(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j * 1000;
    }

    public static long A01(long j) {
        return (j == -9223372036854775807L || j == Long.MIN_VALUE) ? j : j / 1000;
    }
}
