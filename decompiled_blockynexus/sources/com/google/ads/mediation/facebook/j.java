package com.google.ads.mediation.facebook;

import android.content.Context;
import android.util.Log;
import com.google.ads.mediation.facebook.h;

/* JADX INFO: compiled from: FacebookMediationAdapter.java */
/* JADX INFO: loaded from: classes.dex */
class j implements h.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ Context f12612a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ String f12613b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    final /* synthetic */ FacebookMediationAdapter f12614c;

    j(FacebookMediationAdapter facebookMediationAdapter, Context context, String str) {
        this.f12614c = facebookMediationAdapter;
        this.f12612a = context;
        this.f12613b = str;
    }

    @Override // com.google.ads.mediation.facebook.h.a
    public void a() {
        this.f12614c.createAndLoadRewardedVideo(this.f12612a, this.f12613b);
    }

    @Override // com.google.ads.mediation.facebook.h.a
    public void a(String str) {
        String str2 = "Failed to load ad from Facebook: " + str;
        Log.w(FacebookMediationAdapter.TAG, str2);
        if (this.f12614c.mAdLoadCallback != null) {
            this.f12614c.mAdLoadCallback.onFailure(str2);
        }
    }
}
