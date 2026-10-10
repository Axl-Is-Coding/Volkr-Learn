package com.ironsource.sdk.service.a;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.LinkProperties;
import android.net.Network;
import android.net.NetworkCapabilities;

/* JADX INFO: compiled from: NetworkCallbackStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
class e extends ConnectivityManager.NetworkCallback {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f15403a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ f f15404b;

    e(f fVar, Context context) {
        this.f15404b = fVar;
        this.f15403a = context;
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onAvailable(Network network) {
        if (network != null) {
            this.f15404b.f15407c.b(b.f.c.b.a(network, this.f15403a), b.f.c.b.a(this.f15403a, network));
            return;
        }
        d dVar = this.f15404b.f15407c;
        String strB = b.f.c.b.b(this.f15403a);
        Context context = this.f15403a;
        dVar.b(strB, b.f.c.b.a(context, b.f.c.b.a(context)));
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onCapabilitiesChanged(Network network, NetworkCapabilities networkCapabilities) {
        if (network != null) {
            this.f15404b.f15407c.a(b.f.c.b.a(network, this.f15403a), b.f.c.b.a(this.f15403a, network));
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLinkPropertiesChanged(Network network, LinkProperties linkProperties) {
        if (network != null) {
            this.f15404b.f15407c.a(b.f.c.b.a(network, this.f15403a), b.f.c.b.a(this.f15403a, network));
        }
    }

    @Override // android.net.ConnectivityManager.NetworkCallback
    public void onLost(Network network) {
        if (b.f.c.b.b(this.f15403a).equals("none")) {
            this.f15404b.f15407c.onDisconnected();
        }
    }
}
