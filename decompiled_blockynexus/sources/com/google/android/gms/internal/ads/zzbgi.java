package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import androidx.core.view.ViewCompat;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.ads.zztu;
import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
public class zzbgi extends WebViewClient implements zzbhv {
    private final Object lock;
    private boolean zzbrf;
    private zzux zzcgv;
    private zzagt zzdep;
    private zzagv zzdeq;
    private com.google.android.gms.ads.internal.zza zzdfm;
    private zzaqd zzdfn;
    private com.google.android.gms.ads.internal.overlay.zzp zzdpm;
    private com.google.android.gms.ads.internal.overlay.zzv zzdpq;
    private boolean zzdtp;
    protected zzbgj zzemq;
    private final zzts zzemr;
    private final HashMap<String, List<zzahq<? super zzbgj>>> zzems;
    private zzbhu zzemt;
    private zzbhx zzemu;
    private zzbhw zzemv;
    private boolean zzemw;
    private boolean zzemx;
    private boolean zzemy;
    private boolean zzemz;
    private final zzaqo zzena;
    protected zzawl zzenb;
    private boolean zzenc;
    private boolean zzend;
    private int zzene;
    private View.OnAttachStateChangeListener zzenf;

    public zzbgi(zzbgj zzbgjVar, zzts zztsVar, boolean z) {
        this(zzbgjVar, zztsVar, z, new zzaqo(zzbgjVar, zzbgjVar.zzabr(), new zzaam(zzbgjVar.getContext())), null);
    }

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

    /* JADX WARN: Code restructure failed: missing block: B:41:0x00ee, code lost:
    
        com.google.android.gms.ads.internal.zzp.zzkr();
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00f5, code lost:
    
        return com.google.android.gms.internal.ads.zzayu.zzd(r2);
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final android.webkit.WebResourceResponse zze(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8) throws java.io.IOException {
        /*
            Method dump skipped, instruction units count: 278
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgi.zze(java.lang.String, java.util.Map):android.webkit.WebResourceResponse");
    }

    @Override // android.webkit.WebViewClient
    public final void onLoadResource(WebView webView, String str) {
        String strValueOf = String.valueOf(str);
        zzayp.zzei(strValueOf.length() != 0 ? "Loading resource: ".concat(strValueOf) : new String("Loading resource: "));
        Uri uri = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uri.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uri.getHost())) {
            zzh(uri);
        }
    }

    @Override // android.webkit.WebViewClient
    public final void onPageFinished(WebView webView, String str) {
        synchronized (this.lock) {
            if (this.zzemq.isDestroyed()) {
                zzayp.zzei("Blank page loaded, 1...");
                this.zzemq.zzacc();
                return;
            }
            this.zzenc = true;
            zzbhx zzbhxVar = this.zzemu;
            if (zzbhxVar != null) {
                zzbhxVar.zztj();
                this.zzemu = null;
            }
            zzabm();
        }
    }

    @Override // android.webkit.WebViewClient
    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzsu zzsuVarZzacm = this.zzemq.zzacm();
        if (zzsuVarZzacm != null && webView == zzsuVarZzacm.getWebView()) {
            zzsuVarZzacm.onPageStarted(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzemq.zzc(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    public final void reset() {
        zzawl zzawlVar = this.zzenb;
        if (zzawlVar != null) {
            zzawlVar.zzvt();
            this.zzenb = null;
        }
        zzabh();
        synchronized (this.lock) {
            this.zzems.clear();
            this.zzcgv = null;
            this.zzdpm = null;
            this.zzemt = null;
            this.zzemu = null;
            this.zzdep = null;
            this.zzdeq = null;
            this.zzemw = false;
            this.zzbrf = false;
            this.zzemx = false;
            this.zzemz = false;
            this.zzdpq = null;
            this.zzemv = null;
            if (this.zzdfn != null) {
                this.zzdfn.zzac(true);
                this.zzdfn = null;
            }
        }
    }

    @Override // android.webkit.WebViewClient
    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzd(str, Collections.emptyMap());
    }

    @Override // android.webkit.WebViewClient
    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case 127:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    @Override // android.webkit.WebViewClient
    public final boolean shouldOverrideUrlLoading(WebView webView, String str) throws zzef {
        String strValueOf = String.valueOf(str);
        zzayp.zzei(strValueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(strValueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uriZza = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(uriZza.getScheme()) && "mobileads.google.com".equalsIgnoreCase(uriZza.getHost())) {
            zzh(uriZza);
        } else {
            if (this.zzemw && webView == this.zzemq.getWebView()) {
                String scheme = uriZza.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    zzux zzuxVar = this.zzcgv;
                    if (zzuxVar != null) {
                        zzuxVar.onAdClicked();
                        zzawl zzawlVar = this.zzenb;
                        if (zzawlVar != null) {
                            zzawlVar.zzea(str);
                        }
                        this.zzcgv = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (this.zzemq.getWebView().willNotDraw()) {
                String strValueOf2 = String.valueOf(str);
                zzbbq.zzfe(strValueOf2.length() != 0 ? "AdWebView unable to handle URL: ".concat(strValueOf2) : new String("AdWebView unable to handle URL: "));
            } else {
                try {
                    zzeg zzegVarZzabz = this.zzemq.zzabz();
                    if (zzegVarZzabz != null && zzegVarZzabz.zzb(uriZza)) {
                        uriZza = zzegVarZzabz.zza(uriZza, this.zzemq.getContext(), this.zzemq.getView(), this.zzemq.zzzu());
                    }
                } catch (zzef unused) {
                    String strValueOf3 = String.valueOf(str);
                    zzbbq.zzfe(strValueOf3.length() != 0 ? "Unable to append parameter to URL: ".concat(strValueOf3) : new String("Unable to append parameter to URL: "));
                }
                com.google.android.gms.ads.internal.zza zzaVar = this.zzdfm;
                if (zzaVar == null || zzaVar.zzjz()) {
                    zza(new com.google.android.gms.ads.internal.overlay.zzb("android.intent.action.VIEW", uriZza.toString(), null, null, null, null, null));
                } else {
                    this.zzdfm.zzbo(str);
                }
            }
        }
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zza(int i, int i2, boolean z) {
        this.zzena.zzj(i, i2);
        zzaqd zzaqdVar = this.zzdfn;
        if (zzaqdVar != null) {
            zzaqdVar.zza(i, i2, false);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final com.google.android.gms.ads.internal.zza zzabb() {
        return this.zzdfm;
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final boolean zzabc() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzbrf;
        }
        return z;
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
            this.zzenf = new zzbgm(this, zzawlVar);
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
        zzts zztsVar = this.zzemr;
        if (zztsVar != null) {
            zztsVar.zza(zztu.zza.zzb.DELAY_PAGE_LOAD_CANCELLED_AD);
        }
        this.zzend = true;
        zzabm();
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcvj)).booleanValue()) {
            this.zzemq.destroy();
        }
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

    public final void zzb(boolean z, int i) {
        zzux zzuxVar = (!this.zzemq.zzacb() || this.zzemq.zzabu().zzadb()) ? this.zzcgv : null;
        com.google.android.gms.ads.internal.overlay.zzp zzpVar = this.zzdpm;
        com.google.android.gms.ads.internal.overlay.zzv zzvVar = this.zzdpq;
        zzbgj zzbgjVar = this.zzemq;
        zza(new AdOverlayInfoParcel(zzuxVar, zzpVar, zzvVar, zzbgjVar, z, i, zzbgjVar.zzzx()));
    }

    protected final WebResourceResponse zzd(String str, Map<String, String> map) {
        zzsz zzszVarZza;
        try {
            String strZzc = zzaxh.zzc(str, this.zzemq.getContext(), this.zzdtp);
            if (!strZzc.equals(str)) {
                return zze(strZzc, map);
            }
            zzte zzteVarZzbw = zzte.zzbw(str);
            if (zzteVarZzbw != null && (zzszVarZza = com.google.android.gms.ads.internal.zzp.zzkx().zza(zzteVarZzbw)) != null && zzszVarZza.zzmw()) {
                return new WebResourceResponse("", "", zzszVarZza.zzmx());
            }
            if (zzbbk.isEnabled() && zzacr.zzdax.get().booleanValue()) {
                return zze(str, map);
            }
            return null;
        } catch (Exception | NoClassDefFoundError e2) {
            com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "AdWebViewClient.interceptRequest");
            return zzabn();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhv
    public final void zzh(Uri uri) {
        final String path = uri.getPath();
        List<zzahq<? super zzbgj>> list = this.zzems.get(path);
        if (list != null) {
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcvf)).booleanValue()) {
                zzdyq.zza(com.google.android.gms.ads.internal.zzp.zzkr().zzi(uri), new zzbgp(this, list, path), zzbbz.zzeeu);
                return;
            } else {
                com.google.android.gms.ads.internal.zzp.zzkr();
                zza(zzayu.zzj(uri), list, path);
                return;
            }
        }
        String strValueOf = String.valueOf(uri);
        StringBuilder sb = new StringBuilder(String.valueOf(strValueOf).length() + 32);
        sb.append("No GMSG handler found for GMSG: ");
        sb.append(strValueOf);
        zzayp.zzei(sb.toString());
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcxk)).booleanValue() || com.google.android.gms.ads.internal.zzp.zzkv().zzwn() == null) {
            return;
        }
        zzbbz.zzeep.execute(new Runnable(path) { // from class: com.google.android.gms.internal.ads.zzbgk
            private final String zzdgt;

            {
                this.zzdgt = path;
            }

            @Override // java.lang.Runnable
            public final void run() throws Throwable {
                com.google.android.gms.ads.internal.zzp.zzkv().zzwn().zzcv(this.zzdgt.substring(1));
            }
        });
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
            zzbbz.zzeet.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzbgl
                private final zzbgi zzeng;

                {
                    this.zzeng = this;
                }

                @Override // java.lang.Runnable
                public final void run() {
                    zzbgi zzbgiVar = this.zzeng;
                    zzbgiVar.zzemq.zzacf();
                    com.google.android.gms.ads.internal.overlay.zze zzeVarZzabs = zzbgiVar.zzemq.zzabs();
                    if (zzeVarZzabs != null) {
                        zzeVarZzabs.zzuu();
                    }
                }
            });
        }
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

    @VisibleForTesting
    private zzbgi(zzbgj zzbgjVar, zzts zztsVar, boolean z, zzaqo zzaqoVar, zzaqd zzaqdVar) {
        this.zzems = new HashMap<>();
        this.lock = new Object();
        this.zzemw = false;
        this.zzemr = zztsVar;
        this.zzemq = zzbgjVar;
        this.zzbrf = z;
        this.zzena = zzaqoVar;
        this.zzdfn = null;
    }

    public final void zzb(String str, zzahq<? super zzbgj> zzahqVar) {
        synchronized (this.lock) {
            List<zzahq<? super zzbgj>> list = this.zzems.get(str);
            if (list == null) {
                return;
            }
            list.remove(zzahqVar);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(View view, zzawl zzawlVar, int i) {
        if (!zzawlVar.zzvr() || i <= 0) {
            return;
        }
        zzawlVar.zzl(view);
        if (zzawlVar.zzvr()) {
            zzayu.zzeba.postDelayed(new zzbgn(this, view, zzawlVar, i), 100L);
        }
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzb zzbVar) {
        boolean zZzacb = this.zzemq.zzacb();
        zza(new AdOverlayInfoParcel(zzbVar, (!zZzacb || this.zzemq.zzabu().zzadb()) ? this.zzcgv : null, zZzacb ? null : this.zzdpm, this.zzdpq, this.zzemq.zzzx()));
    }

    public final void zza(boolean z, int i, String str) {
        boolean zZzacb = this.zzemq.zzacb();
        zzux zzuxVar = (!zZzacb || this.zzemq.zzabu().zzadb()) ? this.zzcgv : null;
        zzbgo zzbgoVar = zZzacb ? null : new zzbgo(this.zzemq, this.zzdpm);
        zzagt zzagtVar = this.zzdep;
        zzagv zzagvVar = this.zzdeq;
        com.google.android.gms.ads.internal.overlay.zzv zzvVar = this.zzdpq;
        zzbgj zzbgjVar = this.zzemq;
        zza(new AdOverlayInfoParcel(zzuxVar, zzbgoVar, zzagtVar, zzagvVar, zzvVar, zzbgjVar, z, i, str, zzbgjVar.zzzx()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zZzacb = this.zzemq.zzacb();
        zzux zzuxVar = (!zZzacb || this.zzemq.zzabu().zzadb()) ? this.zzcgv : null;
        zzbgo zzbgoVar = zZzacb ? null : new zzbgo(this.zzemq, this.zzdpm);
        zzagt zzagtVar = this.zzdep;
        zzagv zzagvVar = this.zzdeq;
        com.google.android.gms.ads.internal.overlay.zzv zzvVar = this.zzdpq;
        zzbgj zzbgjVar = this.zzemq;
        zza(new AdOverlayInfoParcel(zzuxVar, zzbgoVar, zzagtVar, zzagvVar, zzvVar, zzbgjVar, z, i, str, str2, zzbgjVar.zzzx()));
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

    public final void zza(String str, zzahq<? super zzbgj> zzahqVar) {
        synchronized (this.lock) {
            List<zzahq<? super zzbgj>> copyOnWriteArrayList = this.zzems.get(str);
            if (copyOnWriteArrayList == null) {
                copyOnWriteArrayList = new CopyOnWriteArrayList<>();
                this.zzems.put(str, copyOnWriteArrayList);
            }
            copyOnWriteArrayList.add(zzahqVar);
        }
    }

    public final void zza(String str, Predicate<zzahq<? super zzbgj>> predicate) {
        synchronized (this.lock) {
            List<zzahq<? super zzbgj>> list = this.zzems.get(str);
            if (list == null) {
                return;
            }
            ArrayList arrayList = new ArrayList();
            for (zzahq<? super zzbgj> zzahqVar : list) {
                if (predicate.apply(zzahqVar)) {
                    arrayList.add(zzahqVar);
                }
            }
            list.removeAll(arrayList);
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

    /* JADX INFO: Access modifiers changed from: private */
    public final void zza(Map<String, String> map, List<zzahq<? super zzbgj>> list, String str) {
        if (zzbbq.isLoggable(2)) {
            String strValueOf = String.valueOf(str);
            zzayp.zzei(strValueOf.length() != 0 ? "Received GMSG: ".concat(strValueOf) : new String("Received GMSG: "));
            for (String str2 : map.keySet()) {
                String str3 = map.get(str2);
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 4 + String.valueOf(str3).length());
                sb.append("  ");
                sb.append(str2);
                sb.append(": ");
                sb.append(str3);
                zzayp.zzei(sb.toString());
            }
        }
        Iterator<zzahq<? super zzbgj>> it = list.iterator();
        while (it.hasNext()) {
            it.next().zza(this.zzemq, map);
        }
    }
}
