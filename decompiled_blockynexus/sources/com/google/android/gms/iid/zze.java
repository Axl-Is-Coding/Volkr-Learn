package com.google.android.gms.iid;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import androidx.legacy.content.WakefulBroadcastReceiver;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/* JADX INFO: loaded from: classes.dex */
public abstract class zze extends Service {
    private Binder zzay;
    private int zzaz;
    final ExecutorService zzax = Executors.newSingleThreadExecutor();
    private final Object lock = new Object();
    private int zzba = 0;

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzf(Intent intent) {
        if (intent != null) {
            WakefulBroadcastReceiver.completeWakefulIntent(intent);
        }
        synchronized (this.lock) {
            this.zzba--;
            if (this.zzba == 0) {
                stopSelfResult(this.zzaz);
            }
        }
    }

    public abstract void handleIntent(Intent intent);

    @Override // android.app.Service
    public final synchronized IBinder onBind(Intent intent) {
        if (Log.isLoggable("EnhancedIntentService", 3)) {
            Log.d("EnhancedIntentService", "Service received bind request");
        }
        if (this.zzay == null) {
            this.zzay = new zzi(this);
        }
        return this.zzay;
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent intent, int i, int i2) {
        synchronized (this.lock) {
            this.zzaz = i2;
            this.zzba++;
        }
        if (intent == null) {
            zzf(intent);
            return 2;
        }
        this.zzax.execute(new zzf(this, intent, intent));
        return 3;
    }
}
