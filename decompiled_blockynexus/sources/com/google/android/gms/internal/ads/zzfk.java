package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzfk extends BroadcastReceiver {
    private final /* synthetic */ zzfi zzaag;

    zzfk(zzfi zzfiVar) {
        this.zzaag = zzfiVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzaag.zzcv();
    }
}
