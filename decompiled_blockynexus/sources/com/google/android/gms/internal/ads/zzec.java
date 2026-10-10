package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzec implements Runnable {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Context zzxp;
    private final /* synthetic */ View zzxq;
    private final /* synthetic */ String zzxt;

    zzec(zzdy zzdyVar, Context context, String str, View view, Activity activity) {
        this.zzxp = context;
        this.zzxt = str;
        this.zzxq = view;
        this.val$activity = activity;
    }

    @Override // java.lang.Runnable
    public final void run() {
        try {
            zzdy.zzxe.zza(this.zzxp, this.zzxt, this.zzxq, this.val$activity);
        } catch (Exception e2) {
            zzdy.zzxg.zza(2021, -1L, e2);
        }
    }
}
