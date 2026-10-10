package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public class MediationAdConfiguration {
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    private final String zzado;
    private final int zzdlk;
    private final String zzdmk;
    private final String zzera;
    private final Bundle zzerb;
    private final Bundle zzerc;
    private final int zzerd;
    private final boolean zzna;
    private final Location zznb;
    private final Context zzvr;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForChildDirectedTreatment {
    }

    public MediationAdConfiguration(Context context, String str, Bundle bundle, Bundle bundle2, boolean z, Location location, int i, int i2, String str2, String str3) {
        this.zzera = str;
        this.zzerb = bundle;
        this.zzerc = bundle2;
        this.zzvr = context;
        this.zzna = z;
        this.zznb = location;
        this.zzdlk = i;
        this.zzerd = i2;
        this.zzado = str2;
        this.zzdmk = str3;
    }

    public String getBidResponse() {
        return this.zzera;
    }

    public Context getContext() {
        return this.zzvr;
    }

    public Location getLocation() {
        return this.zznb;
    }

    public String getMaxAdContentRating() {
        return this.zzado;
    }

    public Bundle getMediationExtras() {
        return this.zzerc;
    }

    public Bundle getServerParameters() {
        return this.zzerb;
    }

    public String getWatermark() {
        return this.zzdmk;
    }

    public boolean isTestRequest() {
        return this.zzna;
    }

    public int taggedForChildDirectedTreatment() {
        return this.zzdlk;
    }

    public int taggedForUnderAgeTreatment() {
        return this.zzerd;
    }
}
