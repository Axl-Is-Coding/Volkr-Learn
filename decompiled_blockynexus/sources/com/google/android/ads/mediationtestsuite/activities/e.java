package com.google.android.ads.mediationtestsuite.activities;

/* JADX INFO: compiled from: AdUnitDetailActivity.java */
/* JADX INFO: loaded from: classes.dex */
class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ AdUnitDetailActivity f12642a;

    e(AdUnitDetailActivity adUnitDetailActivity) {
        this.f12642a = adUnitDetailActivity;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f12642a.g.notifyDataSetChanged();
    }
}
