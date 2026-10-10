package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.File;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public final class zzbib extends zzbik implements zzbhv {
    private volatile boolean zzbrf;
    private zzux zzcgv;
    private zzagt zzdep;
    private zzagv zzdeq;
    private com.google.android.gms.ads.internal.zza zzdfm;
    private zzaqd zzdfn;
    private com.google.android.gms.ads.internal.overlay.zzp zzdpm;
    private com.google.android.gms.ads.internal.overlay.zzv zzdpq;
    private boolean zzdtp;
    protected zzbgj zzemq;
    private zzbhu zzemt;
    private zzbhx zzemu;
    private zzbhw zzemv;
    private boolean zzemx;
    private boolean zzemy;
    private boolean zzemz;
    private zzaqo zzena;
    private zzawl zzenb;
    private boolean zzenc;
    private boolean zzend;
    private int zzene;
    private View.OnAttachStateChangeListener zzenf;
    private final Object lock = new Object();
    private boolean zzemw = false;
    private final zzakd<zzbgj> zzeqp = new zzakd<>();

    private final void zzabh() {
        if (this.zzenf == null) {
            return;
        }
        this.zzemq.getView().removeOnAttachStateChangeListener(this.zzenf);
    }

    private final void zzabm() {
        if (this.zzemt != null && ((this.zzenc && this.zzene <= 0) || this.zzend)) {
            this.zzemt.zzai(!this.zzend);
            this.zzemt = null;
        }
        this.zzemq.zzacg();
    }

    private static WebResourceResponse zzabn() {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcob)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00f2, code lost:
    
        com.google.android.gms.ads.internal.zzp.zzkr();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f9, code lost:
    
        return com.google.android.gms.internal.ads.zzayu.zzd(r3);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.webkit.WebResourceResponse zze(com.google.android.gms.internal.ads.zzbin r8) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 282
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbib.zze(com.google.android.gms.internal.ads.zzbin):android.webkit.WebResourceResponse");
    }

    public final void destroy() {
        zzawl zzawlVar = this.zzenb;
        if (zzawlVar != null) {
            zzawlVar.zzvt();
            this.zzenb = null;
        }
        zzabh();
        this.zzeqp.reset();
        this.zzeqp.zzg((zzbgj) null);
        synchronized (this.lock) {
            this.zzcgv = null;
            this.zzdpm = null;
            this.zzemt = null;
            this.zzemu = null;
            this.zzdep = null;
            this.zzdeq = null;
            this.zzdpq = null;
            this.zzemv = null;
            if (this.zzdfn != null) {
                this.zzdfn.zzac(true);
                this.zzdfn = null;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzsu zzsuVarZzacm = this.zzemq.zzacm();
        if (zzsuVarZzacm != null && webView == zzsuVarZzacm.getWebView()) {
            zzsuVarZzacm.onPageStarted(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzemq.zzc(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    final void zza(zzbgj zzbgjVar, boolean z) {
        zzaqo zzaqoVar = new zzaqo(zzbgjVar, zzbgjVar.zzabr(), new zzaam(zzbgjVar.getContext()));
        this.zzemq = zzbgjVar;
        this.zzbrf = z;
        this.zzena = zzaqoVar;
        this.zzdfn = null;
        this.zzeqp.zzg(zzbgjVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final com.google.android.gms.ads.internal.zza zzabb() {
        return this.zzdfm;
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final boolean zzabc() {
        return this.zzbrf;
    }

    public final boolean zzabd() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzemx;
        }
        return z;
    }

    public final boolean zzabe() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzemy;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzabf() {
        synchronized (this.lock) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzabg() {
        synchronized (this.lock) {
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zzabi() {
        zzawl zzawlVar = this.zzenb;
        if (zzawlVar != null) {
            WebView webView = this.zzemq.getWebView();
            if (ViewCompat.B(webView)) {
                zza(webView, zzawlVar, 10);
                return;
            }
            zzabh();
            this.zzenf = new zzbic(this, zzawlVar);
            this.zzemq.getView().addOnAttachStateChangeListener(this.zzenf);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zzabj() {
        synchronized (this.lock) {
            this.zzemz = true;
        }
        this.zzene++;
        zzabm();
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zzabk() {
        this.zzene--;
        zzabm();
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zzabl() {
        this.zzend = true;
        zzabm();
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final zzawl zzabo() {
        return this.zzenb;
    }

    public final void zzav(boolean z) {
        this.zzemw = z;
    }

    public final void zzax(boolean z) {
        this.zzdtp = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zzay(boolean z) {
        synchronized (this.lock) {
            this.zzemx = true;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zzaz(boolean z) {
        synchronized (this.lock) {
            this.zzemy = z;
        }
    }

    public final void zzb(String str, zzahq<? super zzbgj> zzahqVar) {
        this.zzeqp.zzb(str, zzahqVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final boolean zzc(zzbin zzbinVar) {
        String strValueOf = String.valueOf(zzbinVar.url);
        zzayp.zzei(strValueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(strValueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uriZza = zzbinVar.uri;
        if (this.zzeqp.zzg(uriZza)) {
            return true;
        }
        if (this.zzemw) {
            String scheme = uriZza.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                zzux zzuxVar = this.zzcgv;
                if (zzuxVar != null) {
                    zzuxVar.onAdClicked();
                    zzawl zzawlVar = this.zzenb;
                    if (zzawlVar != null) {
                        zzawlVar.zzea(zzbinVar.url);
                    }
                    this.zzcgv = null;
                }
                return false;
            }
        }
        if (this.zzemq.getWebView().willNotDraw()) {
            String strValueOf2 = String.valueOf(zzbinVar.url);
            zzbbq.zzfe(strValueOf2.length() != 0 ? "AdWebView unable to handle URL: ".concat(strValueOf2) : new String("AdWebView unable to handle URL: "));
        } else {
            try {
                zzeg zzegVarZzabz = this.zzemq.zzabz();
                if (zzegVarZzabz != null && zzegVarZzabz.zzb(uriZza)) {
                    uriZza = zzegVarZzabz.zza(uriZza, this.zzemq.getContext(), this.zzemq.getView(), this.zzemq.zzzu());
                }
            } catch (zzef unused) {
                String strValueOf3 = String.valueOf(zzbinVar.url);
                zzbbq.zzfe(strValueOf3.length() != 0 ? "Unable to append parameter to URL: ".concat(strValueOf3) : new String("Unable to append parameter to URL: "));
            }
            com.google.android.gms.ads.internal.zza zzaVar = this.zzdfm;
            if (zzaVar == null || zzaVar.zzjz()) {
                zza(new com.google.android.gms.ads.internal.overlay.zzb("android.intent.action.VIEW", uriZza.toString(), null, null, null, null, null));
            } else {
                this.zzdfm.zzbo(zzbinVar.url);
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final WebResourceResponse zzd(zzbin zzbinVar) {
        WebResourceResponse webResourceResponseZzd;
        zzsz zzszVarZza;
        zzawl zzawlVar = this.zzenb;
        if (zzawlVar != null) {
            zzawlVar.zza(zzbinVar.url, zzbinVar.zzam, 1);
        }
        if ("mraid.js".equalsIgnoreCase(new File(zzbinVar.url).getName())) {
            zzuu();
            String str = this.zzemq.zzabu().zzadb() ? (String) zzwm.zzpx().zzd(zzabb.zzcmz) : this.zzemq.zzacb() ? (String) zzwm.zzpx().zzd(zzabb.zzcmy) : (String) zzwm.zzpx().zzd(zzabb.zzcmx);
            com.google.android.gms.ads.internal.zzp.zzkr();
            webResourceResponseZzd = zzayu.zzd(this.zzemq.getContext(), this.zzemq.zzzx().zzbre, str);
        } else {
            webResourceResponseZzd = null;
        }
        if (webResourceResponseZzd != null) {
            return webResourceResponseZzd;
        }
        try {
            if (!zzaxh.zzc(zzbinVar.url, this.zzemq.getContext(), this.zzdtp).equals(zzbinVar.url)) {
                return zze(zzbinVar);
            }
            zzte zzteVarZzbw = zzte.zzbw(zzbinVar.url);
            if (zzteVarZzbw != null && (zzszVarZza = com.google.android.gms.ads.internal.zzp.zzkx().zza(zzteVarZzbw)) != null && zzszVarZza.zzmw()) {
                return new WebResourceResponse("", "", zzszVarZza.zzmx());
            }
            if (zzbbk.isEnabled() && zzacr.zzdax.get().booleanValue()) {
                return zze(zzbinVar);
            }
            return null;
        } catch (Exception | NoClassDefFoundError e2) {
            com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "AdWebViewClient.interceptRequest");
            return zzabn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zzh(Uri uri) {
        this.zzeqp.zzh(uri);
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zzi(int i, int i2) {
        zzaqd zzaqdVar = this.zzdfn;
        if (zzaqdVar != null) {
            zzaqdVar.zzi(i, i2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zzuu() {
        synchronized (this.lock) {
            this.zzemw = false;
            this.zzbrf = true;
            zzbbz.zzeet.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbia
                private final zzbib zzeqo;

                {
                    this.zzeqo = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbib zzbibVar = this.zzeqo;
                    zzbibVar.zzemq.zzacf();
                    com.google.android.gms.ads.internal.overlay.zze zzeVarZzabs = zzbibVar.zzemq.zzabs();
                    if (zzeVarZzabs != null) {
                        zzeVarZzabs.zzuu();
                    }
                }
            });
        }
    }

    public final void zzb(boolean z, int i) {
        zzux zzuxVar = (!this.zzemq.zzacb() || this.zzemq.zzabu().zzadb()) ? this.zzcgv : null;
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = this.zzdpm;
        com.google.android.gms.ads.internal.overlay.zzv zzvVar = this.zzdpq;
        zzbgj zzbgjVar = this.zzemq;
        zza(new AdOverlayInfoParcel(zzuxVar, zzpVar, zzvVar, zzbgjVar, z, i, zzbgjVar.zzzx()));
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final void zzb(zzbin zzbinVar) {
        this.zzeqp.zzg(zzbinVar.uri);
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zza(int i, int i2, boolean z) {
        this.zzena.zzj(i, i2);
        zzaqd zzaqdVar = this.zzdfn;
        if (zzaqdVar != null) {
            zzaqdVar.zza(i, i2, false);
        }
    }

    public final void zza(String str, zzahq<? super zzbgj> zzahqVar) {
        this.zzeqp.zza(str, zzahqVar);
    }

    public final void zza(String str, Predicate<zzahq<? super zzbgj>> predicate) {
        this.zzeqp.zza(str, predicate);
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zza(zzux zzuxVar, zzagt zzagtVar, com.google.android.gms.ads.internal.overlay.zzp zzpVar, zzagv zzagvVar, com.google.android.gms.ads.internal.overlay.zzv zzvVar, boolean z, zzahp zzahpVar, com.google.android.gms.ads.internal.zza zzaVar, zzaqq zzaqqVar, zzawl zzawlVar) {
        if (zzaVar == null) {
            zzaVar = new com.google.android.gms.ads.internal.zza(this.zzemq.getContext(), zzawlVar, null);
        }
        this.zzdfn = new zzaqd(this.zzemq, zzaqqVar);
        this.zzenb = zzawlVar;
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcom)).booleanValue()) {
            zza("/adMetadata", new zzagu(zzagtVar));
        }
        zza("/appEvent", new zzagw(zzagvVar));
        zza("/backButton", zzagx.zzdfb);
        zza("/refresh", zzagx.zzdfc);
        zza("/canOpenApp", zzagx.zzdes);
        zza("/canOpenURLs", zzagx.zzder);
        zza("/canOpenIntents", zzagx.zzdet);
        zza("/click", zzagx.zzdeu);
        zza("/close", zzagx.zzdev);
        zza("/customClose", zzagx.zzdew);
        zza("/instrument", zzagx.zzdff);
        zza("/delayPageLoaded", zzagx.zzdfh);
        zza("/delayPageClosed", zzagx.zzdfi);
        zza("/getLocationInfo", zzagx.zzdfj);
        zza("/httpTrack", zzagx.zzdex);
        zza("/log", zzagx.zzdey);
        zza("/mraid", new zzahr(zzaVar, this.zzdfn, zzaqqVar));
        zza("/mraidLoaded", this.zzena);
        zza("/open", new zzahu(zzaVar, this.zzdfn));
        zza("/precache", new zzbfq());
        zza("/touch", zzagx.zzdfa);
        zza("/video", zzagx.zzdfd);
        zza("/videoMeta", zzagx.zzdfe);
        if (com.google.android.gms.ads.internal.zzp.zzlp().zzac(this.zzemq.getContext())) {
            zza("/logScionEvent", new zzahs(this.zzemq.getContext()));
        }
        this.zzcgv = zzuxVar;
        this.zzdpm = zzpVar;
        this.zzdep = zzagtVar;
        this.zzdeq = zzagvVar;
        this.zzdpq = zzvVar;
        this.zzdfm = zzaVar;
        this.zzemw = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbik
    public final void zza(zzbin zzbinVar) {
        this.zzenc = true;
        zzbhx zzbhxVar = this.zzemu;
        if (zzbhxVar != null) {
            zzbhxVar.zztj();
            this.zzemu = null;
        }
        zzabm();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(View view, zzawl zzawlVar, int i) {
        if (!zzawlVar.zzvr() || i <= 0) {
            return;
        }
        zzawlVar.zzl(view);
        if (zzawlVar.zzvr()) {
            zzayu.zzeba.postDelayed(new zzbid(this, view, zzawlVar, i), 100L);
        }
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzb zzbVar) {
        boolean zZzacb = this.zzemq.zzacb();
        zza(new AdOverlayInfoParcel(zzbVar, (!zZzacb || this.zzemq.zzabu().zzadb()) ? this.zzcgv : null, zZzacb ? null : this.zzdpm, this.zzdpq, this.zzemq.zzzx()));
    }

    public final void zza(boolean z, int i, String str) {
        boolean zZzacb = this.zzemq.zzacb();
        zzux zzuxVar = (!zZzacb || this.zzemq.zzabu().zzadb()) ? this.zzcgv : null;
        zzbif zzbifVar = zZzacb ? null : new zzbif(this.zzemq, this.zzdpm);
        zzagt zzagtVar = this.zzdep;
        zzagv zzagvVar = this.zzdeq;
        com.google.android.gms.ads.internal.overlay.zzv zzvVar = this.zzdpq;
        zzbgj zzbgjVar = this.zzemq;
        zza(new AdOverlayInfoParcel(zzuxVar, zzbifVar, zzagtVar, zzagvVar, zzvVar, zzbgjVar, z, i, str, zzbgjVar.zzzx()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zZzacb = this.zzemq.zzacb();
        zzux zzuxVar = (!zZzacb || this.zzemq.zzabu().zzadb()) ? this.zzcgv : null;
        zzbif zzbifVar = zZzacb ? null : new zzbif(this.zzemq, this.zzdpm);
        zzagt zzagtVar = this.zzdep;
        zzagv zzagvVar = this.zzdeq;
        com.google.android.gms.ads.internal.overlay.zzv zzvVar = this.zzdpq;
        zzbgj zzbgjVar = this.zzemq;
        zza(new AdOverlayInfoParcel(zzuxVar, zzbifVar, zzagtVar, zzagvVar, zzvVar, zzbgjVar, z, i, str, str2, zzbgjVar.zzzx()));
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        com.google.android.gms.ads.internal.overlay.zzb zzbVar;
        zzaqd zzaqdVar = this.zzdfn;
        boolean zZzuo = zzaqdVar != null ? zzaqdVar.zzuo() : false;
        com.google.android.gms.ads.internal.zzp.zzkq();
        com.google.android.gms.ads.internal.overlay.zzl.zza(this.zzemq.getContext(), adOverlayInfoParcel, zZzuo ? false : true);
        if (this.zzenb != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && (zzbVar = adOverlayInfoParcel.zzdpl) != null) {
                str = zzbVar.url;
            }
            this.zzenb.zzea(str);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zza(zzbhu zzbhuVar) {
        this.zzemt = zzbhuVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zza(zzbhx zzbhxVar) {
        this.zzemu = zzbhxVar;
    }
}
