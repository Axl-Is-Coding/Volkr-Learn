package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.doubleclick.PublisherAdView;
import com.google.android.gms.ads.formats.OnPublisherAdViewLoadedListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzagq extends zzafr {
    private final OnPublisherAdViewLoadedListener zzdem;

    public zzagq(OnPublisherAdViewLoadedListener onPublisherAdViewLoadedListener) {
        this.zzdem = onPublisherAdViewLoadedListener;
    }

    @Override // com.google.android.gms.internal.ads.zzafs
    public final void zza(zzxc zzxcVar, IObjectWrapper iObjectWrapper) {
        if (zzxcVar == null || iObjectWrapper == null) {
            return;
        }
        PublisherAdView publisherAdView = new PublisherAdView((Context) ObjectWrapper.unwrap(iObjectWrapper));
        try {
            if (zzxcVar.zzkk() instanceof zzvc) {
                zzvc zzvcVar = (zzvc) zzxcVar.zzkk();
                publisherAdView.setAdListener(zzvcVar != null ? zzvcVar.getAdListener() : null);
            }
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
        try {
            if (zzxcVar.zzkj() instanceof zzvt) {
                zzvt zzvtVar = (zzvt) zzxcVar.zzkj();
                publisherAdView.setAppEventListener(zzvtVar != null ? zzvtVar.getAppEventListener() : null);
            }
        } catch (RemoteException e3) {
            zzbbq.zzc("", e3);
        }
        zzbbg.zzaah.post(new zzagp(this, publisherAdView, zzxcVar));
    }
}
