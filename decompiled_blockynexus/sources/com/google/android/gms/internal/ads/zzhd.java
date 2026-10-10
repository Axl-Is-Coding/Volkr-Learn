package com.google.android.gms.internal.ads;

import java.io.IOException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzhd extends Exception {
    private final int type;
    private final int zzaek;

    private zzhd(int i, String str, Throwable th, int i2) {
        super(null, th);
        this.type = i;
        this.zzaek = i2;
    }

    public static zzhd zza(Exception exc, int i) {
        return new zzhd(1, null, exc, i);
    }

    public static zzhd zza(IOException iOException) {
        return new zzhd(0, null, iOException, -1);
    }

    static zzhd zza(RuntimeException runtimeException) {
        return new zzhd(2, null, runtimeException, -1);
    }
}
