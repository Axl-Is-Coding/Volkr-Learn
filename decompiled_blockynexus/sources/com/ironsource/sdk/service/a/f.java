package com.ironsource.sdk.service.a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.util.Log;
import org.json.JSONObject;

/* JADX INFO: compiled from: NetworkCallbackStrategy.java */
/* JADX INFO: loaded from: classes2.dex */
public class f implements c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private String f15405a = f.class.getSimpleName();

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private int f15406b = 23;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final d f15407c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ConnectivityManager.NetworkCallback f15408d;

    public f(d dVar) {
        this.f15407c = dVar;
    }

    @Override // com.ironsource.sdk.service.a.c
    @SuppressLint({"NewApi", "MissingPermission"})
    public void b(Context context) {
        if (Build.VERSION.SDK_INT >= this.f15406b) {
            c(context);
            if (b.f.c.b.b(context).equals("none")) {
                this.f15407c.onDisconnected();
            }
            if (this.f15408d == null) {
                this.f15408d = new e(this, context);
            }
            NetworkRequest networkRequestBuild = new NetworkRequest.Builder().addCapability(12).build();
            try {
                ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
                if (connectivityManager != null) {
                    connectivityManager.registerNetworkCallback(networkRequestBuild, this.f15408d);
                }
            } catch (Exception unused) {
                Log.e(this.f15405a, "NetworkCallback was not able to register");
            }
        }
    }

    @Override // com.ironsource.sdk.service.a.c
    @SuppressLint({"NewApi"})
    public void c(Context context) {
        ConnectivityManager connectivityManager;
        if (Build.VERSION.SDK_INT < this.f15406b || this.f15408d == null || context == null || (connectivityManager = (ConnectivityManager) context.getSystemService("connectivity")) == null) {
            return;
        }
        try {
            connectivityManager.unregisterNetworkCallback(this.f15408d);
        } catch (Exception unused) {
            Log.e(this.f15405a, "NetworkCallback for was not registered or already unregistered");
        }
    }

    @Override // com.ironsource.sdk.service.a.c
    public void release() {
        this.f15408d = null;
    }

    @Override // com.ironsource.sdk.service.a.c
    public JSONObject a(Context context) {
        return b.f.c.b.a(context, b.f.c.b.a(context));
    }
}
