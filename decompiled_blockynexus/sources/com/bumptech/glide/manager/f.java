package com.bumptech.glide.manager;

import android.annotation.SuppressLint;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.util.Log;
import com.bumptech.glide.manager.c;

/* JADX INFO: compiled from: DefaultConnectivityMonitor.java */
/* JADX INFO: loaded from: classes.dex */
final class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f4753a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final c.a f4754b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    boolean f4755c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private boolean f4756d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final BroadcastReceiver f4757e = new e(this);

    f(Context context, c.a aVar) {
        this.f4753a = context.getApplicationContext();
        this.f4754b = aVar;
    }

    private void a() {
        if (this.f4756d) {
            return;
        }
        this.f4755c = a(this.f4753a);
        try {
            this.f4753a.registerReceiver(this.f4757e, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
            this.f4756d = true;
        } catch (SecurityException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to register", e2);
            }
        }
    }

    private void b() {
        if (this.f4756d) {
            this.f4753a.unregisterReceiver(this.f4757e);
            this.f4756d = false;
        }
    }

    @Override // com.bumptech.glide.manager.j
    public void onDestroy() {
    }

    @Override // com.bumptech.glide.manager.j
    public void onStart() {
        a();
    }

    @Override // com.bumptech.glide.manager.j
    public void onStop() {
        b();
    }

    @SuppressLint({"MissingPermission"})
    boolean a(Context context) {
        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        com.bumptech.glide.e.l.a(connectivityManager);
        try {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            return activeNetworkInfo != null && activeNetworkInfo.isConnected();
        } catch (RuntimeException e2) {
            if (Log.isLoggable("ConnectivityMonitor", 5)) {
                Log.w("ConnectivityMonitor", "Failed to determine connectivity status when connectivity changed", e2);
            }
            return true;
        }
    }
}
