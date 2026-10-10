package com.google.android.gms.iid;

import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
final class zzj implements Runnable {
    private final /* synthetic */ zzg zzbj;
    private final /* synthetic */ zzi zzbk;

    zzj(zzi zziVar, zzg zzgVar) {
        this.zzbk = zziVar;
        this.zzbj = zzgVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "bg processing of the intent starting now");
        }
        this.zzbk.zzbi.handleIntent(this.zzbj.intent);
        this.zzbj.finish();
    }
}
