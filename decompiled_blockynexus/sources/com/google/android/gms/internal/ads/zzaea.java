package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaea implements NativeCustomTemplateAd.DisplayOpenMeasurement {
    private final zzafa zzddp;

    public zzaea(zzafa zzafaVar) {
        this.zzddp = zzafaVar;
        try {
            zzafaVar.zzss();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.DisplayOpenMeasurement
    public final void setView(View view) {
        try {
            this.zzddp.zzq(ObjectWrapper.wrap(view));
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd.DisplayOpenMeasurement
    public final boolean start() {
        try {
            return this.zzddp.zzsr();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return false;
        }
    }
}
