package com.google.android.gms.ads;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class AdValue {
    private final int zzadc;
    private final String zzadd;
    private final long zzade;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface PrecisionType {
        public static final int ESTIMATED = 1;
        public static final int PRECISE = 3;
        public static final int PUBLISHER_PROVIDED = 2;
        public static final int UNKNOWN = 0;
    }

    private AdValue(int i, String str, long j) {
        this.zzadc = i;
        this.zzadd = str;
        this.zzade = j;
    }

    public static AdValue zza(int i, String str, long j) {
        return new AdValue(i, str, j);
    }

    public final String getCurrencyCode() {
        return this.zzadd;
    }

    public final int getPrecisionType() {
        return this.zzadc;
    }

    public final long getValueMicros() {
        return this.zzade;
    }
}
