package com.google.android.gms.internal.ads;

import android.content.DialogInterface;
import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaqb implements DialogInterface.OnClickListener {
    private final /* synthetic */ zzaqc zzdmw;

    zzaqb(zzaqc zzaqcVar) {
        this.zzdmw = zzaqcVar;
    }

    @Override // android.content.DialogInterface.OnClickListener
    public final void onClick(DialogInterface dialogInterface, int i) {
        Intent intentCreateIntent = this.zzdmw.createIntent();
        com.google.android.gms.ads.internal.zzp.zzkr();
        zzayu.zza(this.zzdmw.zzvr, intentCreateIntent);
    }
}
