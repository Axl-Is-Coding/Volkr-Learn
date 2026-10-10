package com.google.android.gms.internal.ads;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdqx {
    private final zzdra zzhjj = new zzdra();
    private int zzhjl = 0;
    private int zzhjm = 0;
    private int zzhjn = 0;
    private final long zzhji = com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis();
    private long zzhjk = this.zzhji;

    public final long getCreationTimeMillis() {
        return this.zzhji;
    }

    public final long zzaua() {
        return this.zzhjk;
    }

    public final int zzaub() {
        return this.zzhjl;
    }

    public final String zzaum() {
        return "Created: " + this.zzhji + " Last accessed: " + this.zzhjk + " Accesses: " + this.zzhjl + "\nEntries retrieved: Valid: " + this.zzhjm + " Stale: " + this.zzhjn;
    }

    public final void zzauu() {
        this.zzhjk = com.google.android.gms.ads.internal.zzp.zzky().currentTimeMillis();
        this.zzhjl++;
    }

    public final void zzauv() {
        this.zzhjm++;
        this.zzhjj.zzhjo = true;
    }

    public final void zzauw() {
        this.zzhjn++;
        this.zzhjj.zzhjn++;
    }

    public final zzdra zzaux() {
        zzdra zzdraVar = (zzdra) this.zzhjj.clone();
        zzdra zzdraVar2 = this.zzhjj;
        zzdraVar2.zzhjo = false;
        zzdraVar2.zzhjn = 0;
        return zzdraVar;
    }
}
