package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzvt extends zzxn {
    private final AppEventListener zzboa;

    public zzvt(AppEventListener appEventListener) {
        this.zzboa = appEventListener;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzboa;
    }

    @Override // com.google.android.gms.internal.ads.zzxk
    public final void onAppEvent(String str, String str2) {
        this.zzboa.onAppEvent(str, str2);
    }
}
