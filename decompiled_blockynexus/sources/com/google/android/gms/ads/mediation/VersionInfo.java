package com.google.android.gms.ads.mediation;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class VersionInfo {
    private final int zzerx;
    private final int zzery;
    private final int zzerz;

    public VersionInfo(int i, int i2, int i3) {
        this.zzerx = i;
        this.zzery = i2;
        this.zzerz = i3;
    }

    public final int getMajorVersion() {
        return this.zzerx;
    }

    public final int getMicroVersion() {
        return this.zzerz;
    }

    public final int getMinorVersion() {
        return this.zzery;
    }
}
