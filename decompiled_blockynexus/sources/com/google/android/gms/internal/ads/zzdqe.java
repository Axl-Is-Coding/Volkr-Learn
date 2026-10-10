package com.google.android.gms.internal.ads;

import com.umeng.umcrash.UMCustomLogInfoBuilder;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdqe {
    private final zzdqd zzhhj = new zzdqd();
    private int zzhhk;
    private int zzhhl;
    private int zzhhm;
    private int zzhhn;
    private int zzhho;

    zzdqe() {
    }

    public final void zzaug() {
        this.zzhhm++;
    }

    public final void zzauh() {
        this.zzhhn++;
    }

    public final void zzaui() {
        this.zzhhk++;
        this.zzhhj.zzhhh = true;
    }

    public final void zzauj() {
        this.zzhhl++;
        this.zzhhj.zzhhi = true;
    }

    public final void zzauk() {
        this.zzhho++;
    }

    public final zzdqd zzaul() {
        zzdqd zzdqdVar = (zzdqd) this.zzhhj.clone();
        zzdqd zzdqdVar2 = this.zzhhj;
        zzdqdVar2.zzhhh = false;
        zzdqdVar2.zzhhi = false;
        return zzdqdVar;
    }

    public final String zzaum() {
        return "\n\tPool does not exist: " + this.zzhhm + "\n\tNew pools created: " + this.zzhhk + "\n\tPools removed: " + this.zzhhl + "\n\tEntries added: " + this.zzhho + "\n\tNo entries retrieved: " + this.zzhhn + UMCustomLogInfoBuilder.LINE_SEP;
    }
}
