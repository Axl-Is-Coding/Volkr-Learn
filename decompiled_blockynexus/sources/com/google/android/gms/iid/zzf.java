package com.google.android.gms.iid;

import android.content.Intent;

/* JADX INFO: loaded from: classes.dex */
final class zzf implements Runnable {
    private final /* synthetic */ Intent zzbb;
    private final /* synthetic */ Intent zzbc;
    private final /* synthetic */ zze zzbd;

    zzf(zze zzeVar, Intent intent, Intent intent2) {
        this.zzbd = zzeVar;
        this.zzbb = intent;
        this.zzbc = intent2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.zzbd.handleIntent(this.zzbb);
        this.zzbd.zzf(this.zzbc);
    }
}
