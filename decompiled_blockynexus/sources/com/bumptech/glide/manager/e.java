package com.bumptech.glide.manager;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

/* JADX INFO: compiled from: DefaultConnectivityMonitor.java */
/* JADX INFO: loaded from: classes.dex */
class e extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ f f4752a;

    e(f fVar) {
        this.f4752a = fVar;
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        f fVar = this.f4752a;
        boolean z = fVar.f4755c;
        fVar.f4755c = fVar.a(context);
        if (z != this.f4752a.f4755c) {
            if (Log.isLoggable("ConnectivityMonitor", 3)) {
                Log.d("ConnectivityMonitor", "connectivity changed, isConnected: " + this.f4752a.f4755c);
            }
            f fVar2 = this.f4752a;
            fVar2.f4754b.a(fVar2.f4755c);
        }
    }
}
