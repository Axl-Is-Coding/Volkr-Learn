package com.google.android.ads.mediationtestsuite.utils;

import android.content.Context;
import com.google.android.ads.mediationtestsuite.AdLoadCallback;
import com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;

/* JADX INFO: loaded from: classes.dex */
public abstract class AdManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    protected NetworkConfig f12663a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    protected AdLoadCallback f12664b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    protected AdRequest f12665c;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    protected Boolean f12667e = false;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    protected AdListener f12666d = new a(this);

    public AdManager(NetworkConfig networkConfig, AdLoadCallback adLoadCallback) {
        this.f12663a = networkConfig;
        this.f12664b = adLoadCallback;
        this.f12665c = c.a(this.f12663a.getServerParameters(), this.f12663a);
    }

    public void a() {
        this.f12667e = true;
    }

    public abstract void a(Context context);

    public NetworkConfig b() {
        return this.f12663a;
    }

    public abstract void c();
}
