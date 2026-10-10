package com.google.android.gms.internal.ads;

import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcaj implements zzcak {
    private final List<String> zzdsp;
    private final zzdst zzfnf;
    private boolean zzfwn;

    public zzcaj(zzdnv zzdnvVar, zzdst zzdstVar) {
        this.zzdsp = zzdnvVar.zzdsp;
        this.zzfnf = zzdstVar;
    }

    @Override // com.google.android.gms.internal.ads.zzcak
    public final void zzakv() {
        if (this.zzfwn) {
            return;
        }
        this.zzfnf.zzj(this.zzdsp);
        this.zzfwn = true;
    }
}
