package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzdz implements Runnable {
    private final /* synthetic */ Context zzxp;
    private final /* synthetic */ View zzxq;
    private final /* synthetic */ Activity zzxr;

    zzdz(zzdy zzdyVar, Context context, View view, Activity activity) {
        this.zzxp = context;
        this.zzxq = view;
        this.zzxr = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzdy.zzxe.zza(this.zzxp, this.zzxq, this.zzxr);
        } catch (Exception e2) {
            zzdy.zzxg.zza(2020, -1L, e2);
        }
    }
}
