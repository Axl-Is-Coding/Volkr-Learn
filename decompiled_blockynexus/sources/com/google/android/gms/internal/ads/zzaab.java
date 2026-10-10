package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaab extends zzyl {
    private final OnPaidEventListener zzclc;

    public zzaab(OnPaidEventListener onPaidEventListener) {
        this.zzclc = onPaidEventListener;
    }

    @Override // com.google.android.gms.internal.ads.zzyi
    public final void zza(zzvp zzvpVar) {
        if (this.zzclc != null) {
            this.zzclc.onPaidEvent(AdValue.zza(zzvpVar.zzadc, zzvpVar.zzadd, zzvpVar.zzade));
        }
    }
}
