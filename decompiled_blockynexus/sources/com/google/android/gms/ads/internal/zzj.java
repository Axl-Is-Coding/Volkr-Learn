package com.google.android.gms.ads.internal;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaak;
import com.google.android.gms.internal.ads.zzaby;
import com.google.android.gms.internal.ads.zzacm;
import com.google.android.gms.internal.ads.zzari;
import com.google.android.gms.internal.ads.zzaro;
import com.google.android.gms.internal.ads.zzaug;
import com.google.android.gms.internal.ads.zzbbg;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzbbx;
import com.google.android.gms.internal.ads.zzbbz;
import com.google.android.gms.internal.ads.zzef;
import com.google.android.gms.internal.ads.zzeg;
import com.google.android.gms.internal.ads.zzsh;
import com.google.android.gms.internal.ads.zzvg;
import com.google.android.gms.internal.ads.zzvn;
import com.google.android.gms.internal.ads.zzvs;
import com.google.android.gms.internal.ads.zzwm;
import com.google.android.gms.internal.ads.zzwo;
import com.google.android.gms.internal.ads.zzwt;
import com.google.android.gms.internal.ads.zzxf;
import com.google.android.gms.internal.ads.zzxj;
import com.google.android.gms.internal.ads.zzxk;
import com.google.android.gms.internal.ads.zzxq;
import com.google.android.gms.internal.ads.zzyi;
import com.google.android.gms.internal.ads.zzyn;
import com.google.android.gms.internal.ads.zzyo;
import com.google.android.gms.internal.ads.zzyu;
import com.just.agentweb.DefaultWebClient;
import java.util.Map;
import java.util.concurrent.Future;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class zzj extends zzxf {
    private final zzbbx zzbpe;
    private final zzvn zzbpf;
    private final Future<zzeg> zzbpg = zzbbz.zzeep.submit(new zzo(this));
    private final zzq zzbph;
    private WebView zzbpi;
    private zzwt zzbpj;
    private zzeg zzbpk;
    private AsyncTask<Void, Void, String> zzbpl;
    private final Context zzvr;

    public zzj(Context context, zzvn zzvnVar, String str, zzbbx zzbbxVar) {
        this.zzvr = context;
        this.zzbpe = zzbbxVar;
        this.zzbpf = zzvnVar;
        this.zzbpi = new WebView(this.zzvr);
        this.zzbph = new zzq(context, str);
        zzbt(0);
        this.zzbpi.setVerticalScrollBarEnabled(false);
        this.zzbpi.getSettings().setJavaScriptEnabled(true);
        this.zzbpi.setWebViewClient(new zzm(this));
        this.zzbpi.setOnTouchListener(new zzl(this));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final String zzbr(String str) {
        if (this.zzbpk == null) {
            return str;
        }
        Uri uriZza = Uri.parse(str);
        try {
            uriZza = this.zzbpk.zza(uriZza, this.zzvr, null, null);
        } catch (zzef e2) {
            zzbbq.zzd("Unable to process ad data", e2);
        }
        return uriZza.toString();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zzbs(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.zzvr.startActivity(intent);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void destroy() throws RemoteException {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzbpl.cancel(true);
        this.zzbpg.cancel(true);
        this.zzbpi.destroy();
        this.zzbpi = null;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final Bundle getAdMetadata() {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final String getMediationAdapterClassName() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzyo getVideoController() {
        return null;
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
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void resume() throws RemoteException {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void setImmersiveMode(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void setManualImpressionsEnabled(boolean z) throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void setUserId(String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void showInterstitial() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void stopLoading() throws RemoteException {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzyi zzyiVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final boolean zza(zzvg zzvgVar) throws RemoteException {
        Preconditions.checkNotNull(this.zzbpi, "This Search Ad has already been torn down");
        this.zzbph.zza(zzvgVar, this.zzbpe);
        this.zzbpl = new zzn(this, null).execute(new Void[0]);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zzbp(String str) {
        throw new IllegalStateException("Unused method");
    }

    @VisibleForTesting
    final int zzbq(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter(ViewHierarchyConstants.DIMENSION_HEIGHT_KEY);
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzwm.zzpt();
            return zzbbg.zzc(this.zzvr, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    @VisibleForTesting
    final void zzbt(int i) {
        if (this.zzbpi == null) {
            return;
        }
        this.zzbpi.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final IObjectWrapper zzke() throws RemoteException {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzbpi);
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zzkf() throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzvn zzkg() throws RemoteException {
        return this.zzbpf;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final String zzkh() throws RemoteException {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzyn zzki() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzxk zzkj() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final zzwt zzkk() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    @VisibleForTesting
    final String zzkl() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(DefaultWebClient.HTTPS_SCHEME).appendEncodedPath(zzacm.zzdag.get());
        builder.appendQueryParameter(SearchIntents.EXTRA_QUERY, this.zzbph.getQuery());
        builder.appendQueryParameter("pubId", this.zzbph.zzlr());
        Map<String, String> mapZzls = this.zzbph.zzls();
        for (String str : mapZzls.keySet()) {
            builder.appendQueryParameter(str, mapZzls.get(str));
        }
        Uri uriBuild = builder.build();
        zzeg zzegVar = this.zzbpk;
        if (zzegVar != null) {
            try {
                uriBuild = zzegVar.zza(uriBuild, this.zzvr);
            } catch (zzef e2) {
                zzbbq.zzd("Unable to process ad data", e2);
            }
        }
        String strZzkm = zzkm();
        String encodedQuery = uriBuild.getEncodedQuery();
        StringBuilder sb = new StringBuilder(String.valueOf(strZzkm).length() + 1 + String.valueOf(encodedQuery).length());
        sb.append(strZzkm);
        sb.append("#");
        sb.append(encodedQuery);
        return sb.toString();
    }

    @VisibleForTesting
    final String zzkm() {
        String strZzlq = this.zzbph.zzlq();
        if (TextUtils.isEmpty(strZzlq)) {
            strZzlq = "www.google.com";
        }
        String str = zzacm.zzdag.get();
        StringBuilder sb = new StringBuilder(String.valueOf(strZzlq).length() + 8 + String.valueOf(str).length());
        sb.append(DefaultWebClient.HTTPS_SCHEME);
        sb.append(strZzlq);
        sb.append(str);
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzwt zzwtVar) throws RemoteException {
        this.zzbpj = zzwtVar;
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzxk zzxkVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzxj zzxjVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzvn zzvnVar) throws RemoteException {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzari zzariVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzaro zzaroVar, String str) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzaby zzabyVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzwo zzwoVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzxq zzxqVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzaug zzaugVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzaak zzaakVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzyu zzyuVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzvs zzvsVar) {
        throw new IllegalStateException("Unused method");
    }

    @Override // com.google.android.gms.internal.ads.zzxc
    public final void zza(zzsh zzshVar) throws RemoteException {
        throw new IllegalStateException("Unused method");
    }
}
