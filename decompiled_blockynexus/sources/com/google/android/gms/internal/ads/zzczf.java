package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzczf extends zzxf {
    private final ViewGroup zzfpw;
    private final zzdok zzfsk;
    private final zzwt zzfxl;
    private final zzboq zzgsg;
    private final Context zzvr;

    public zzczf(Context context, zzwt zzwtVar, zzdok zzdokVar, zzboq zzboqVar) {
        this.zzvr = context;
        this.zzfxl = zzwtVar;
        this.zzfsk = zzdokVar;
        this.zzgsg = zzboqVar;
        FrameLayout frameLayout = new FrameLayout(this.zzvr);
        frameLayout.removeAllViews();
        frameLayout.addView(this.zzgsg.zzahx(), com.google.android.gms.ads.internal.zzp.zzkt().zzxx());
        frameLayout.setMinimumHeight(zzkg().heightPixels);
        frameLayout.setMinimumWidth(zzkg().widthPixels);
        this.zzfpw = frameLayout;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgsg.destroy();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final Bundle getAdMetadata() throws RemoteException {
        zzbbq.zzfd("getAdMetadata is not supported in Publisher AdView returned by AdLoader.");
        return new Bundle();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final String getAdUnitId() throws RemoteException {
        return this.zzfsk.zzhfb;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final String getMediationAdapterClassName() throws RemoteException {
        if (this.zzgsg.zzaix() != null) {
            return this.zzgsg.zzaix().getMediationAdapterClassName();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzyo getVideoController() throws RemoteException {
        return this.zzgsg.getVideoController();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final boolean isLoading() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final boolean isReady() throws RemoteException {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void pause() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgsg.zzaiw().zzca(null);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void resume() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzgsg.zzaiw().zzcb(null);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void setImmersiveMode(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
        zzbbq.zzfd("setManualImpressionsEnabled is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void setUserId(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void showInterstitial() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void stopLoading() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzari zzariVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzaro zzaroVar, String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzaug zzaugVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzsh zzshVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzvs zzvsVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzyu zzyuVar) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final boolean zza(zzvg zzvgVar) throws RemoteException {
        zzbbq.zzfd("loadAd is not supported for a Publisher AdView returned from AdLoader.");
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zzbp(String str) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final IObjectWrapper zzke() throws RemoteException {
        return ObjectWrapper.wrap(this.zzfpw);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zzkf() throws RemoteException {
        this.zzgsg.zzkf();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzvn zzkg() {
        Preconditions.checkMainThread("getAdSize must be called on the main UI thread.");
        return zzdoq.zzb(this.zzvr, Collections.singletonList(this.zzgsg.zzahw()));
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final String zzkh() throws RemoteException {
        if (this.zzgsg.zzaix() != null) {
            return this.zzgsg.zzaix().getMediationAdapterClassName();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzyn zzki() {
        return this.zzgsg.zzaix();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzxk zzkj() throws RemoteException {
        return this.zzfsk.zzhfg;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzwt zzkk() throws RemoteException {
        return this.zzfxl;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzaak zzaakVar) throws RemoteException {
        zzbbq.zzfd("setVideoOptions is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzvn zzvnVar) throws RemoteException {
        Preconditions.checkMainThread("setAdSize must be called on the main UI thread.");
        zzboq zzboqVar = this.zzgsg;
        if (zzboqVar != null) {
            zzboqVar.zza(this.zzfpw, zzvnVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzaby zzabyVar) throws RemoteException {
        zzbbq.zzfd("setOnCustomRenderedAdLoadedListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzwo zzwoVar) throws RemoteException {
        zzbbq.zzfd("setAdClickListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzxq zzxqVar) throws RemoteException {
        zzbbq.zzfd("setCorrelationIdProvider is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzwt zzwtVar) throws RemoteException {
        zzbbq.zzfd("setAdListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzxk zzxkVar) throws RemoteException {
        zzbbq.zzfd("setAppEventListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzxj zzxjVar) throws RemoteException {
        zzbbq.zzfd("setAdMetadataListener is not supported in Publisher AdView returned by AdLoader.");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzyi zzyiVar) {
        zzbbq.zzfd("setOnPaidEventListener is not supported in Publisher AdView returned by AdLoader.");
    }
}
