package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbnj {
    private final View view;
    private final zzbgj zzdgy;
    private final zzdnu zzfpe;
    private final int zzfpf;
    private final boolean zzfpg;
    private final boolean zzfph;

    public zzbnj(View view, zzbgj zzbgjVar, zzdnu zzdnuVar, int i, boolean z, boolean z2) {
        this.view = view;
        this.zzdgy = zzbgjVar;
        this.zzfpe = zzdnuVar;
        this.zzfpf = i;
        this.zzfpg = z;
        this.zzfph = z2;
    }

    public final zzbgj zzahl() {
        return this.zzdgy;
    }

    public final View zzahm() {
        return this.view;
    }

    public final zzdnu zzahn() {
        return this.zzfpe;
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
}
