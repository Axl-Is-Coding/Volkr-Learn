package com.google.android.gms.common.stats;

import android.annotation.SuppressLint;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.util.Log;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.zzj;
import com.google.android.gms.common.util.ClientLibraryUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.common.zzn;
import com.google.android.gms.internal.common.zzo;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-basement@@17.3.0 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public class ConnectionTracker {
    private static volatile ConnectionTracker zzb;

    @VisibleForTesting
    private ConcurrentHashMap<ServiceConnection, ServiceConnection> zze = new ConcurrentHashMap<>();
    private static final Object zza = new Object();

    @VisibleForTesting
    private static boolean zzc = false;
    private static zzo<Boolean> zzd = zzn.zza(zza.zza);

    private ConnectionTracker() {
    }

    @KeepForSdk
    public static ConnectionTracker getInstance() {
        if (zzb == null) {
            synchronized (zza) {
                if (zzb == null) {
                    zzb = new ConnectionTracker();
                }
            }
        }
        return zzb;
    }

    static final /* synthetic */ boolean zza() {
        return false;
    }

    @KeepForSdk
    public boolean bindService(Context context, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, context.getClass().getName(), intent, serviceConnection, i);
    }

    @KeepForSdk
    @SuppressLint({"UntrackedBindService"})
    public void unbindService(Context context, ServiceConnection serviceConnection) {
        if (!zza(serviceConnection) || !this.zze.containsKey(serviceConnection)) {
            zza(context, serviceConnection);
            return;
        }
        try {
            zza(context, this.zze.get(serviceConnection));
        } finally {
            this.zze.remove(serviceConnection);
        }
    }

    @KeepForSdk
    @SuppressLint({"UntrackedBindService"})
    public void unbindServiceSafe(Context context, ServiceConnection serviceConnection) {
        try {
            unbindService(context, serviceConnection);
        } catch (IllegalArgumentException e2) {
            Log.w("ConnectionTracker", "Exception thrown while unbinding", e2);
        }
    }

    public final boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i) {
        return zza(context, str, intent, serviceConnection, i, true);
    }

    @SuppressLint({"UntrackedBindService"})
    private final boolean zza(Context context, String str, Intent intent, ServiceConnection serviceConnection, int i, boolean z) {
        ComponentName component = intent.getComponent();
        if (component == null ? false : ClientLibraryUtils.zza(context, component.getPackageName())) {
            Log.w("ConnectionTracker", "Attempted to bind to a service in a STOPPED package.");
            return false;
        }
        if (!zza(serviceConnection)) {
            return context.bindService(intent, serviceConnection, i);
        }
        ServiceConnection serviceConnectionPutIfAbsent = this.zze.putIfAbsent(serviceConnection, serviceConnection);
        if (serviceConnectionPutIfAbsent != null && serviceConnection != serviceConnectionPutIfAbsent) {
            Log.w("ConnectionTracker", String.format("Duplicate binding with the same ServiceConnection: %s, %s, %s.", serviceConnection, str, intent.getAction()));
        }
        try {
            boolean zBindService = context.bindService(intent, serviceConnection, i);
            return !zBindService ? zBindService : zBindService;
        } finally {
            this.zze.remove(serviceConnection, serviceConnection);
        }
    }

    private static boolean zza(ServiceConnection serviceConnection) {
        return zzd.zza().booleanValue() && !(serviceConnection instanceof zzj);
    }

    @SuppressLint({"UntrackedBindService"})
    private static void zza(Context context, ServiceConnection serviceConnection) {
        try {
            context.unbindService(serviceConnection);
        } catch (IllegalArgumentException | IllegalStateException e2) {
            Log.w("ConnectionTracker", "Exception thrown while unbinding", e2);
        }
    }
}
