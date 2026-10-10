package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzem implements zzer {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ Bundle zzym;

    zzem(zzej zzejVar, Activity activity, Bundle bundle) {
        this.val$activity = activity;
        this.zzym = bundle;
    }

    @Override // com.google.android.gms.internal.ads.zzer
    public final void zza(Application.ActivityLifecycleCallbacks activityLifecycleCallbacks) {
        activityLifecycleCallbacks.onActivityCreated(this.val$activity, this.zzym);
    }
}
