package com.google.android.gms.internal.ads;

import java.util.UUID;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzha {
    public static final int CHANNEL_OUT_7POINT1_SURROUND;
    public static final UUID UUID_NIL;
    private static final UUID zzaeb;
    private static final UUID zzaec;
    private static final UUID zzaed;

    static {
        CHANNEL_OUT_7POINT1_SURROUND = zzpq.SDK_INT < 23 ? 1020 : 6396;
        UUID_NIL = new UUID(0L, 0L);
        zzaeb = new UUID(1186680826959645954L, -5988876978535335093L);
        zzaec = new UUID(-1301668207276963122L, -6645017420763422227L);
        zzaed = new UUID(-7348484286925749626L, -6083546864340672619L);
    }

    public static long zzdm(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j / 1000;
    }

    public static long zzdn(long j) {
        if (j == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j * 1000;
    }
}
