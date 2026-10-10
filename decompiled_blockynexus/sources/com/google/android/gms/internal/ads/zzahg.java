package com.google.android.gms.internal.ads;

import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzahg implements zzahq<zzbgj> {
    zzahg() {
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final /* synthetic */ void zza(zzbgj zzbgjVar, Map map) {
        zzbgj zzbgjVar2 = zzbgjVar;
        if (zzbgjVar2.zzack() != null) {
            zzbgjVar2.zzack().zzmt();
        }
        com.google.android.gms.ads.internal.overlay.zze zzeVarZzabs = zzbgjVar2.zzabs();
        if (zzeVarZzabs != null) {
            zzeVarZzabs.close();
            return;
        }
        com.google.android.gms.ads.internal.overlay.zze zzeVarZzabt = zzbgjVar2.zzabt();
        if (zzeVarZzabt != null) {
            zzeVarZzabt.close();
        } else {
            zzbbq.zzfe("A GMSG tried to close something that wasn't an overlay.");
        }
    }
}
