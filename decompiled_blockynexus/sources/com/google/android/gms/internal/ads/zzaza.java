package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzaza extends BroadcastReceiver {
    private final /* synthetic */ zzayu zzebj;

    private zzaza(zzayu zzayuVar) {
        this.zzebj = zzayuVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.USER_PRESENT".equals(intent.getAction())) {
            this.zzebj.zzyq = true;
        } else if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.zzebj.zzyq = false;
        }
    }

    /* synthetic */ zzaza(zzayu zzayuVar, zzayw zzaywVar) {
        this(zzayuVar);
    }
}
