package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcib extends zzaer {
    private final String zzcib;
    private final zzcei zzfxu;
    private final zzcdx zzgaw;

    public zzcib(String str, zzcdx zzcdxVar, zzcei zzceiVar) {
        this.zzcib = str;
        this.zzgaw = zzcdxVar;
        this.zzfxu = zzceiVar;
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final void destroy() throws RemoteException {
        this.zzgaw.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final String getBody() throws RemoteException {
        return this.zzfxu.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final String getCallToAction() throws RemoteException {
        return this.zzfxu.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final Bundle getExtras() throws RemoteException {
        return this.zzfxu.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final String getHeadline() throws RemoteException {
        return this.zzfxu.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final List<?> getImages() throws RemoteException {
        return this.zzfxu.getImages();
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final String getMediationAdapterClassName() throws RemoteException {
        return this.zzcib;
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final String getPrice() throws RemoteException {
        return this.zzfxu.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final double getStarRating() throws RemoteException {
        return this.zzfxu.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final String getStore() throws RemoteException {
        return this.zzfxu.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final zzyo getVideoController() throws RemoteException {
        return this.zzfxu.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final void performClick(Bundle bundle) throws RemoteException {
        this.zzgaw.zzg(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final boolean recordImpression(Bundle bundle) throws RemoteException {
        return this.zzgaw.zzi(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final void reportTouchEvent(Bundle bundle) throws RemoteException {
        this.zzgaw.zzh(bundle);
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final IObjectWrapper zzsk() throws RemoteException {
        return ObjectWrapper.wrap(this.zzgaw);
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final zzaee zzsl() throws RemoteException {
        return this.zzfxu.zzsl();
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final zzadw zzsm() throws RemoteException {
        return this.zzfxu.zzsm();
    }

    @Override // com.google.android.gms.internal.ads.zzaes
    public final IObjectWrapper zzsn() throws RemoteException {
        return this.zzfxu.zzsn();
    }
}
