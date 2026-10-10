package com.ironsource.environment;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

/* JADX INFO: loaded from: classes2.dex */
public class NetworkStateReceiver extends BroadcastReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private ConnectivityManager f14587a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private a f14588b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f14589c;

    public interface a {
        void a(boolean z);
    }

    public NetworkStateReceiver(Context context, a aVar) {
        this.f14588b = aVar;
        this.f14587a = (ConnectivityManager) context.getSystemService("connectivity");
        a();
    }

    private boolean a() {
        boolean z = this.f14589c;
        NetworkInfo activeNetworkInfo = this.f14587a.getActiveNetworkInfo();
        this.f14589c = activeNetworkInfo != null && activeNetworkInfo.isConnectedOrConnecting();
        return z != this.f14589c;
    }

    private void b() {
        a aVar = this.f14588b;
        if (aVar != null) {
            if (this.f14589c) {
                aVar.a(true);
            } else {
                aVar.a(false);
            }
        }
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) {
        if (intent == null || intent.getExtras() == null || !a()) {
            return;
        }
        b();
    }
}
