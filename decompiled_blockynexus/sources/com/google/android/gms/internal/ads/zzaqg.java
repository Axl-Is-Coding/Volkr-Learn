package com.google.android.gms.internal.ads;

import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaqg implements View.OnClickListener {
    private final /* synthetic */ zzaqd zzdnr;

    zzaqg(zzaqd zzaqdVar) {
        this.zzdnr = zzaqdVar;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View view) {
        this.zzdnr.zzac(true);
    }
}
