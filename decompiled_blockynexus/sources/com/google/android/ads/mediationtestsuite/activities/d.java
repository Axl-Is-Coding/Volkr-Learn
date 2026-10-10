package com.google.android.ads.mediationtestsuite.activities;

import android.util.Log;
import com.google.android.ads.mediationtestsuite.BatchAdRequestCallbacks;
import com.google.android.ads.mediationtestsuite.dataobjects.BatchAdRequestManager;
import com.google.android.ads.mediationtestsuite.dataobjects.NetworkConfig;
import com.google.android.ads.mediationtestsuite.utils.logging.RequestEvent;

/* JADX INFO: compiled from: AdUnitDetailActivity.java */
/* JADX INFO: loaded from: classes.dex */
class d implements BatchAdRequestCallbacks {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    final /* synthetic */ androidx.appcompat.app.j f12640a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    final /* synthetic */ AdUnitDetailActivity f12641b;

    d(AdUnitDetailActivity adUnitDetailActivity, androidx.appcompat.app.j jVar) {
        this.f12641b = adUnitDetailActivity;
        this.f12640a = jVar;
    }

    @Override // com.google.android.ads.mediationtestsuite.BatchAdRequestCallbacks
    public void a(BatchAdRequestManager batchAdRequestManager, NetworkConfig networkConfig) {
        Log.i("gma_test", "Tested config ");
        com.google.android.ads.mediationtestsuite.utils.logging.e.a(new RequestEvent(networkConfig, RequestEvent.Origin.BATCH_REQUEST), this.f12641b);
    }

    @Override // com.google.android.ads.mediationtestsuite.BatchAdRequestCallbacks
    public void a(BatchAdRequestManager batchAdRequestManager) {
        Log.i("gma_test", "Finished Testing");
        this.f12641b.runOnUiThread(new c(this));
    }
}
