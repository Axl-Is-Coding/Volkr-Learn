package com.google.android.ads.mediationtestsuite.activities;

import com.google.android.ads.mediationtestsuite.dataobjects.AdUnit;
import java.util.List;

/* JADX INFO: compiled from: AdUnitsFragment.java */
/* JADX INFO: loaded from: classes.dex */
class g implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdUnitsFragment f12644a;

    g(AdUnitsFragment adUnitsFragment) {
        this.f12644a = adUnitsFragment;
    }

    @Override // java.lang.Runnable
    public void run() {
        List listI = this.f12644a.i();
        if (listI != null) {
            this.f12644a.f12625c.clear();
            this.f12644a.f12625c.addAll(com.google.android.ads.mediationtestsuite.viewmodels.k.a((List<AdUnit>) listI));
            this.f12644a.f12626d.b();
        }
    }
}
