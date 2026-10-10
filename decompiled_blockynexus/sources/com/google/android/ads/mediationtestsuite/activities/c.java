package com.google.android.ads.mediationtestsuite.activities;

import com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig;
import java.util.Iterator;

/* JADX INFO: compiled from: AdUnitDetailActivity.java */
/* JADX INFO: loaded from: classes.dex */
class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ d f12639a;

    c(d dVar) {
        this.f12639a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f12639a.f12640a.dismiss();
        AdUnitDetailActivity.b(this.f12639a.f12641b.f12618d, this.f12639a.f12641b.f12619e);
        Iterator it = this.f12639a.f12641b.f12620f.iterator();
        while (it.hasNext()) {
            ((NetworkConfig) it.next()).setChecked(false);
        }
        this.f12639a.f12641b.f12620f.clear();
        this.f12639a.f12641b.g.notifyDataSetChanged();
    }
}
