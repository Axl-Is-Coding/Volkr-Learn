package com.google.android.gms.internal.ads;

import android.view.View;
import java.util.Set;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public class zzbot {
    private final View view;
    private final zzbgj zzdgy;
    private final zzdnu zzfpe;
    private final zzbql zzfqb;

    public zzbot(View view, zzbgj zzbgjVar, zzbql zzbqlVar, zzdnu zzdnuVar) {
        this.view = view;
        this.zzdgy = zzbgjVar;
        this.zzfqb = zzbqlVar;
        this.zzfpe = zzdnuVar;
    }

    public zzbvr zza(Set<zzcab<zzbvs>> set) {
        return new zzbvr(set);
    }

    public final zzbgj zzahl() {
        return this.zzdgy;
    }

    public final View zzahx() {
        return this.view;
    }

    public final zzbql zzaij() {
        return this.zzfqb;
    }

    public final zzdnu zzaik() {
        return this.zzfpe;
    }
}
