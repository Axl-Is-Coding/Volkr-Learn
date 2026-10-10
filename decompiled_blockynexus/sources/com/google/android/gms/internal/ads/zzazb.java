package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzazb extends BroadcastReceiver {
    private zzazb(zzayu zzayuVar) {
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        zzbbk.zzyt();
        zzayn.zzao(context);
    }

    /* synthetic */ zzazb(zzayu zzayuVar, zzayw zzaywVar) {
        this(zzayuVar);
    }
}
