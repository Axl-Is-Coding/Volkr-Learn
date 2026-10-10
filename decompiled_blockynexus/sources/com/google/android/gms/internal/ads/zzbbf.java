package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzbbf extends BroadcastReceiver {
    private final /* synthetic */ zzbbc zzeds;

    zzbbf(zzbbc zzbbcVar) {
        this.zzeds = zzbbcVar;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.zzeds.zzc(context, intent);
    }
}
