package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbnv extends zzbqo {
    private final View view;
    private final zzbgj zzdgy;
    private final zzdnu zzfpe;
    private final int zzfpf;
    private final boolean zzfpg;
    private final boolean zzfph;
    private zzsm zzfpn;
    private final zzbnn zzfpo;

    zzbnv(zzbqn zzbqnVar, View view, zzbgj zzbgjVar, zzdnu zzdnuVar, int i, boolean z, boolean z2, zzbnn zzbnnVar) {
        super(zzbqnVar);
        this.view = view;
        this.zzdgy = zzbgjVar;
        this.zzfpe = zzdnuVar;
        this.zzfpf = i;
        this.zzfpg = z;
        this.zzfph = z2;
        this.zzfpo = zzbnnVar;
    }

    public final void zza(zzsc zzscVar) {
        zzbgj zzbgjVar = this.zzdgy;
        if (zzbgjVar != null) {
            zzbgjVar.zza(zzscVar);
        }
    }

    public final boolean zzabc() {
        zzbgj zzbgjVar = this.zzdgy;
        return (zzbgjVar == null || zzbgjVar.zzabw() == null || !this.zzdgy.zzabw().zzabc()) ? false : true;
    }

    public final int zzaho() {
        return this.zzfpf;
    }

    public final boolean zzahp() {
        return this.zzfpg;
    }

    public final boolean zzahq() {
        return this.zzfph;
    }

    public final zzdnu zzahw() {
        return zzdoq.zza(this.zzeot.zzhdq, this.zzfpe);
    }

    public final View zzahx() {
        return this.view;
    }

    public final boolean zzahy() {
        zzbgj zzbgjVar = this.zzdgy;
        return zzbgjVar != null && zzbgjVar.zzaby();
    }

    public final zzsm zzahz() {
        return this.zzfpn;
    }

    public final void zzfd(long j) {
        this.zzfpo.zzfd(j);
    }

    public final void zza(zzsm zzsmVar) {
        this.zzfpn = zzsmVar;
    }
}
