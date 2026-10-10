package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzua;
import com.sandboxol.center.config.StringConstant;
import fi.iki.elonen.NanoHTTPD;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
final class zzbgz extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzbgj {
    private int maxHeight;
    private int maxWidth;
    private String zzacy;
    private final zzbbx zzbpe;
    private final WindowManager zzbrj;
    private int zzdoc;
    private int zzdod;
    private boolean zzdpo;
    private String zzdrb;
    private Boolean zzdzd;
    private zzabq zzeja;
    private final zzts zzemr;
    private final zzbhz zzeol;
    private final zzeg zzeom;
    private final zzacb zzeon;
    private final com.google.android.gms.ads.internal.zzk zzeoo;
    private final com.google.android.gms.ads.internal.zzb zzeop;
    private final float zzeoq;
    private final zzsu zzeor;
    private final boolean zzeos;
    private zzdnv zzeot;
    private zzdnw zzeou;
    private boolean zzeov;
    private boolean zzeow;
    private zzbgi zzeox;
    private com.google.android.gms.ads.internal.overlay.zze zzeoy;
    private IObjectWrapper zzeoz;
    private zzbhy zzepa;
    private boolean zzepb;
    private boolean zzepc;
    private boolean zzepd;
    private int zzepe;
    private boolean zzepf;
    private boolean zzepg;
    private zzbhd zzeph;
    private boolean zzepi;
    private boolean zzepj;
    private zzads zzepk;
    private zzadn zzepl;
    private zzsc zzepm;
    private int zzepn;
    private int zzepo;
    private zzabq zzepp;
    private zzabq zzepq;
    private zzabp zzepr;
    private WeakReference<View.OnClickListener> zzeps;
    private com.google.android.gms.ads.internal.overlay.zze zzept;
    private boolean zzepu;
    private zzbbh zzepv;
    private Map<String, zzbfl> zzepw;
    private final DisplayMetrics zzxd;

    @VisibleForTesting
    private zzbgz(zzbhz zzbhzVar, zzbhy zzbhyVar, String str, boolean z, boolean z2, zzeg zzegVar, zzacb zzacbVar, zzbbx zzbbxVar, zzabs zzabsVar, com.google.android.gms.ads.internal.zzk zzkVar, com.google.android.gms.ads.internal.zzb zzbVar, zzts zztsVar, zzsu zzsuVar, boolean z3, zzdnv zzdnvVar, zzdnw zzdnwVar) {
        super(zzbhzVar);
        this.zzeov = false;
        this.zzeow = false;
        this.zzepf = true;
        this.zzepg = false;
        this.zzdrb = "";
        this.zzdod = -1;
        this.zzdoc = -1;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.zzeol = zzbhzVar;
        this.zzepa = zzbhyVar;
        this.zzacy = str;
        this.zzepc = z;
        this.zzepe = -1;
        this.zzeom = zzegVar;
        this.zzeon = zzacbVar;
        this.zzbpe = zzbbxVar;
        this.zzeoo = zzkVar;
        this.zzeop = zzbVar;
        this.zzbrj = (WindowManager) getContext().getSystemService("window");
        com.google.android.gms.ads.internal.zzp.zzkr();
        this.zzxd = zzayu.zza(this.zzbrj);
        this.zzeoq = this.zzxd.density;
        this.zzemr = zztsVar;
        this.zzeor = zzsuVar;
        this.zzeos = z3;
        this.zzeot = zzdnvVar;
        this.zzeou = zzdnwVar;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e2) {
            zzbbq.zzc("Unable to enable Javascript.", e2);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        com.google.android.gms.ads.internal.zzp.zzkr().zza(zzbhzVar, zzbbxVar.zzbre, settings);
        com.google.android.gms.ads.internal.zzp.zzkt().zza(getContext(), settings);
        setDownloadListener(this);
        zzacr();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(zzbhe.zzc(this), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.zzepv = new zzbbh(this.zzeol.zzzu(), this, this, null);
        zzacv();
        this.zzepr = new zzabp(new zzabs(true, "make_wv", this.zzacy));
        this.zzepr.zzrp().zzc(zzabsVar);
        this.zzeja = zzabj.zzb(this.zzepr.zzrp());
        this.zzepr.zza("native:view_create", this.zzeja);
        this.zzepq = null;
        this.zzepp = null;
        com.google.android.gms.ads.internal.zzp.zzkt().zzbg(zzbhzVar);
        com.google.android.gms.ads.internal.zzp.zzkv().zzwq();
    }

    private final boolean zzaco() {
        int i;
        int iZzb;
        if (!this.zzeox.zzabc() && !this.zzeox.zzabd()) {
            return false;
        }
        zzwm.zzpt();
        DisplayMetrics displayMetrics = this.zzxd;
        int iZzb2 = zzbbg.zzb(displayMetrics, displayMetrics.widthPixels);
        zzwm.zzpt();
        DisplayMetrics displayMetrics2 = this.zzxd;
        int iZzb3 = zzbbg.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity activityZzzu = this.zzeol.zzzu();
        if (activityZzzu == null || activityZzzu.getWindow() == null) {
            i = iZzb2;
            iZzb = iZzb3;
        } else {
            com.google.android.gms.ads.internal.zzp.zzkr();
            int[] iArrZzd = zzayu.zzd(activityZzzu);
            zzwm.zzpt();
            int iZzb4 = zzbbg.zzb(this.zzxd, iArrZzd[0]);
            zzwm.zzpt();
            iZzb = zzbbg.zzb(this.zzxd, iArrZzd[1]);
            i = iZzb4;
        }
        if (this.zzdoc == iZzb2 && this.zzdod == iZzb3 && this.maxWidth == i && this.maxHeight == iZzb) {
            return false;
        }
        boolean z = (this.zzdoc == iZzb2 && this.zzdod == iZzb3) ? false : true;
        this.zzdoc = iZzb2;
        this.zzdod = iZzb3;
        this.maxWidth = i;
        this.maxHeight = iZzb;
        new zzaqn(this).zza(iZzb2, iZzb3, i, iZzb, this.zzxd.density, this.zzbrj.getDefaultDisplay().getRotation());
        return z;
    }

    private final synchronized void zzacp() {
        this.zzdzd = com.google.android.gms.ads.internal.zzp.zzkv().zzwo();
        if (this.zzdzd == null) {
            try {
                evaluateJavascript("(function(){})()", null);
                zza((Boolean) true);
            } catch (IllegalStateException unused) {
                zza((Boolean) false);
            }
        }
    }

    private final void zzacq() {
        zzabj.zza(this.zzepr.zzrp(), this.zzeja, "aeh2");
    }

    private final synchronized void zzacr() {
        if (!this.zzepc && !this.zzepa.zzadb()) {
            if (Build.VERSION.SDK_INT < 18) {
                zzbbq.zzef("Disabling hardware acceleration on an AdView.");
                zzacs();
                return;
            } else {
                zzbbq.zzef("Enabling hardware acceleration on an AdView.");
                zzact();
                return;
            }
        }
        zzbbq.zzef("Enabling hardware acceleration on an overlay.");
        zzact();
    }

    private final synchronized void zzacs() {
        if (!this.zzepd) {
            com.google.android.gms.ads.internal.zzp.zzkt();
            setLayerType(1, null);
        }
        this.zzepd = true;
    }

    private final synchronized void zzact() {
        if (this.zzepd) {
            com.google.android.gms.ads.internal.zzp.zzkt();
            setLayerType(0, null);
        }
        this.zzepd = false;
    }

    private final synchronized void zzacu() {
        if (this.zzepw != null) {
            Iterator<zzbfl> it = this.zzepw.values().iterator();
            while (it.hasNext()) {
                it.next().release();
            }
        }
        this.zzepw = null;
    }

    private final void zzacv() {
        zzabs zzabsVarZzrp;
        zzabp zzabpVar = this.zzepr;
        if (zzabpVar == null || (zzabsVarZzrp = zzabpVar.zzrp()) == null || com.google.android.gms.ads.internal.zzp.zzkv().zzwn() == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzp.zzkv().zzwn().zza(zzabsVarZzrp);
    }

    static zzbgz zzb(Context context, zzbhy zzbhyVar, String str, boolean z, boolean z2, zzeg zzegVar, zzacb zzacbVar, zzbbx zzbbxVar, zzabs zzabsVar, com.google.android.gms.ads.internal.zzk zzkVar, com.google.android.gms.ads.internal.zzb zzbVar, zzts zztsVar, zzsu zzsuVar, boolean z3, zzdnv zzdnvVar, zzdnw zzdnwVar) {
        return new zzbgz(new zzbhz(context), zzbhyVar, str, z, z2, zzegVar, zzacbVar, zzbbxVar, zzabsVar, zzkVar, zzbVar, zztsVar, zzsuVar, z3, zzdnvVar, zzdnwVar);
    }

    private final void zzbd(boolean z) {
        HashMap map = new HashMap();
        map.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", map);
    }

    private final synchronized void zzfr(String str) {
        if (isDestroyed()) {
            zzbbq.zzfe("#004 The webview is destroyed. Ignoring action.");
        } else {
            loadUrl(str);
        }
    }

    private final synchronized void zzfs(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e2) {
            com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "AdWebViewImpl.loadUrlUnsafe");
            zzbbq.zzd("Could not call loadUrl. ", e2);
        }
    }

    private final void zzft(String str) {
        if (!PlatformVersion.isAtLeastKitKat()) {
            String strValueOf = String.valueOf(str);
            zzfr(strValueOf.length() != 0 ? "javascript:".concat(strValueOf) : new String("javascript:"));
            return;
        }
        if (zzwo() == null) {
            zzacp();
        }
        if (zzwo().booleanValue()) {
            zza(str, (ValueCallback<String>) null);
        } else {
            String strValueOf2 = String.valueOf(str);
            zzfr(strValueOf2.length() != 0 ? "javascript:".concat(strValueOf2) : new String("javascript:"));
        }
    }

    @VisibleForTesting
    private final synchronized Boolean zzwo() {
        return this.zzdzd;
    }

    private final synchronized void zzwr() {
        if (!this.zzepu) {
            this.zzepu = true;
            com.google.android.gms.ads.internal.zzp.zzkv().zzwr();
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgj
    public final synchronized void destroy() {
        zzacv();
        this.zzepv.zzyq();
        if (this.zzeoy != null) {
            this.zzeoy.close();
            this.zzeoy.onDestroy();
            this.zzeoy = null;
        }
        this.zzeoz = null;
        this.zzeox.reset();
        if (this.zzepb) {
            return;
        }
        com.google.android.gms.ads.internal.zzp.zzln();
        zzbfi.zzc(this);
        zzacu();
        this.zzepb = true;
        zzayp.zzei("Initiating WebView self destruct sequence in 3...");
        zzayp.zzei("Loading blank page in WebView, 2...");
        zzfs("about:blank");
    }

    @Override // android.webkit.WebView
    @TargetApi(19)
    public final synchronized void evaluateJavascript(String str, ValueCallback<String> valueCallback) {
        if (!isDestroyed()) {
            super.evaluateJavascript(str, valueCallback);
            return;
        }
        zzbbq.zzfg("#004 The webview is destroyed. Ignoring action.");
        if (valueCallback != null) {
            valueCallback.onReceiveValue(null);
        }
    }

    protected final void finalize() throws Throwable {
        try {
            synchronized (this) {
                if (!this.zzepb) {
                    this.zzeox.reset();
                    com.google.android.gms.ads.internal.zzp.zzln();
                    zzbfi.zzc(this);
                    zzacu();
                    zzwr();
                }
            }
        } finally {
            super.finalize();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final synchronized String getRequestId() {
        return this.zzdrb;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbhs
    public final View getView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final WebView getWebView() {
        return this;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized boolean isDestroyed() {
        return this.zzepb;
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgj
    public final synchronized void loadData(String str, String str2, String str3) {
        if (isDestroyed()) {
            zzbbq.zzfe("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadData(str, str2, str3);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgj
    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (isDestroyed()) {
            zzbbq.zzfe("#004 The webview is destroyed. Ignoring action.");
        } else {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgj
    public final synchronized void loadUrl(String str) {
        if (isDestroyed()) {
            zzbbq.zzfe("#004 The webview is destroyed. Ignoring action.");
            return;
        }
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e2) {
            com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "AdWebViewImpl.loadUrl");
            zzbbq.zzd("Could not call loadUrl. ", e2);
        }
    }

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.zzepv.onAttachedToWindow();
        }
        boolean z = this.zzepi;
        if (this.zzeox != null && this.zzeox.zzabd()) {
            if (!this.zzepj) {
                this.zzeox.zzabf();
                this.zzeox.zzabg();
                this.zzepj = true;
            }
            zzaco();
            z = true;
        }
        zzbd(z);
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onDetachedFromWindow() {
        synchronized (this) {
            if (!isDestroyed()) {
                this.zzepv.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzepj && this.zzeox != null && this.zzeox.zzabd() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzeox.zzabf();
                this.zzeox.zzabg();
                this.zzepj = false;
            }
        }
        zzbd(false);
    }

    @Override // android.webkit.DownloadListener
    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            com.google.android.gms.ads.internal.zzp.zzkr();
            zzayu.zza(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzbbq.zzef(sb.toString());
        }
    }

    @Override // android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected final void onDraw(Canvas canvas) {
        if (isDestroyed()) {
            return;
        }
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
        zzbgi zzbgiVar = this.zzeox;
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > WheelView.DividerConfig.FILL && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < WheelView.DividerConfig.FILL && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > WheelView.DividerConfig.FILL && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < WheelView.DividerConfig.FILL && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final void onGlobalLayout() {
        boolean zZzaco = zzaco();
        com.google.android.gms.ads.internal.overlay.zze zzeVarZzabs = zzabs();
        if (zzeVarZzabs == null || !zZzaco) {
            return;
        }
        zzeVarZzabs.zzux();
    }

    /* JADX WARN: Removed duplicated region for block: B:94:0x0167  */
    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    @android.annotation.SuppressLint({"DrawAllocation"})
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    protected final synchronized void onMeasure(int r8, int r9) {
        /*
            Method dump skipped, instruction units count: 514
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbgz.onMeasure(int, int):void");
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgj
    public final void onPause() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.onPause();
        } catch (Exception e2) {
            zzbbq.zzc("Could not pause webview.", e2);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgj
    public final void onResume() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.onResume();
        } catch (Exception e2) {
            zzbbq.zzc("Could not resume webview.", e2);
        }
    }

    @Override // android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzeox.zzabd() || this.zzeox.zzabe()) {
            zzeg zzegVar = this.zzeom;
            if (zzegVar != null) {
                zzegVar.zza(motionEvent);
            }
            zzacb zzacbVar = this.zzeon;
            if (zzacbVar != null) {
                zzacbVar.zza(motionEvent);
            }
        } else {
            synchronized (this) {
                if (this.zzepk != null) {
                    this.zzepk.zzc(motionEvent);
                }
            }
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override // android.view.View, com.google.android.gms.internal.ads.zzbgj
    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzeps = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void setRequestedOrientation(int i) {
        this.zzepe = i;
        if (this.zzeoy != null) {
            this.zzeoy.setRequestedOrientation(this.zzepe);
        }
    }

    @Override // android.webkit.WebView, com.google.android.gms.internal.ads.zzbgj
    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzbgi) {
            this.zzeox = (zzbgi) webViewClient;
        }
    }

    @Override // android.webkit.WebView
    public final void stopLoading() {
        if (isDestroyed()) {
            return;
        }
        try {
            super.stopLoading();
        } catch (Exception e2) {
            zzbbq.zzc("Could not stop loading webview.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajr
    public final void zza(String str, Map<String, ?> map) {
        try {
            zza(str, com.google.android.gms.ads.internal.zzp.zzkr().zzj(map));
        } catch (JSONException unused) {
            zzbbq.zzfe("Could not convert parameters to JSON.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final synchronized void zzaaa() {
        if (this.zzepl != null) {
            this.zzepl.zzsf();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzabp() {
        zzacq();
        HashMap map = new HashMap(1);
        map.put("version", this.zzbpe.zzbre);
        zza("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzabq() {
        HashMap map = new HashMap(3);
        map.put("app_muted", String.valueOf(com.google.android.gms.ads.internal.zzp.zzkw().zzqh()));
        map.put("app_volume", String.valueOf(com.google.android.gms.ads.internal.zzp.zzkw().zzqg()));
        map.put("device_volume", String.valueOf(zzazm.zzbi(getContext())));
        zza("volume", map);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final Context zzabr() {
        return this.zzeol.zzabr();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized com.google.android.gms.ads.internal.overlay.zze zzabs() {
        return this.zzeoy;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized com.google.android.gms.ads.internal.overlay.zze zzabt() {
        return this.zzept;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbhr
    public final synchronized zzbhy zzabu() {
        return this.zzepa;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized String zzabv() {
        return this.zzacy;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final /* synthetic */ zzbhv zzabw() {
        return this.zzeox;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final WebViewClient zzabx() {
        return this.zzeox;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized boolean zzaby() {
        return this.zzdpo;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbhq
    public final zzeg zzabz() {
        return this.zzeom;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized IObjectWrapper zzaca() {
        return this.zzeoz;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbhl
    public final synchronized boolean zzacb() {
        return this.zzepc;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zzacc() {
        zzayp.zzei("Destroying WebView!");
        zzwr();
        zzayu.zzeba.post(new zzbha(this));
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized boolean zzacd() {
        return this.zzepf;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized boolean zzace() {
        return this.zzepn > 0;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzacf() {
        this.zzepv.zzyp();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzacg() {
        if (this.zzepq == null) {
            this.zzepq = zzabj.zzb(this.zzepr.zzrp());
            this.zzepr.zza("native:view_load", this.zzepq);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized zzads zzach() {
        return this.zzepk;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzaci() {
        setBackgroundColor(0);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzacj() {
        zzayp.zzei("Cannot add text view to inner AdWebView");
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized zzsc zzack() {
        return this.zzepm;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final boolean zzacl() {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final zzsu zzacm() {
        return this.zzeor;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final boolean zzacn() {
        return ((Boolean) zzwm.zzpx().zzd(zzabb.zzcwp)).booleanValue() && this.zzeor != null && this.zzeos;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zzal(boolean z) {
        if (this.zzeoy != null) {
            this.zzeoy.zza(this.zzeox.zzabc(), z);
        } else {
            this.zzdpo = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zzap(IObjectWrapper iObjectWrapper) {
        this.zzeoz = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final void zzav(boolean z) {
        this.zzeox.zzav(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzax(boolean z) {
        this.zzeox.zzax(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zzba(boolean z) {
        boolean z2 = z != this.zzepc;
        this.zzepc = z;
        zzacr();
        if (z2) {
            if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcnb)).booleanValue() || !this.zzepa.zzadb()) {
                new zzaqn(this).zzdz(z ? "expanded" : StringConstant.PARTY_GAME_CATEGORY_DEFAULT);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zzbb(boolean z) {
        this.zzepf = z;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zzbc(boolean z) {
        this.zzepn += z ? 1 : -1;
        if (this.zzepn <= 0 && this.zzeoy != null) {
            this.zzeoy.zzva();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzbw(Context context) {
        this.zzeol.setBaseContext(context);
        this.zzepv.zzh(this.zzeol.zzzu());
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final boolean zzc(final boolean z, final int i) {
        destroy();
        this.zzemr.zza(new zztr(z, i) { // from class: com.google.android.gms.internal.ads.zzbgy
            private final int zzebs;
            private final boolean zzeok;

            {
                this.zzeok = z;
                this.zzebs = i;
            }

            @Override // com.google.android.gms.internal.ads.zztr
            public final void zza(zzua.zzi.zza zzaVar) {
                zzbgz.zza(this.zzeok, this.zzebs, zzaVar);
            }
        });
        this.zzemr.zza(zztu.zza.zzb.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zzdc(String str) {
        zzft(str);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzdu(int i) {
        if (i == 0) {
            zzabj.zza(this.zzepr.zzrp(), this.zzeja, "aebb2");
        }
        zzacq();
        if (this.zzepr.zzrp() != null) {
            this.zzepr.zzrp().zzh("close_type", String.valueOf(i));
        }
        HashMap map = new HashMap(2);
        map.put("closetype", String.valueOf(i));
        map.put("version", this.zzbpe.zzbre);
        zza("onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final synchronized zzbfl zzfj(String str) {
        if (this.zzepw == null) {
            return null;
        }
        return this.zzepw.get(str);
    }

    @Override // com.google.android.gms.ads.internal.zzk
    public final synchronized void zzkn() {
        this.zzepg = true;
        if (this.zzeoo != null) {
            this.zzeoo.zzkn();
        }
    }

    @Override // com.google.android.gms.ads.internal.zzk
    public final synchronized void zzko() {
        this.zzepg = false;
        if (this.zzeoo != null) {
            this.zzeoo.zzko();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzuy() {
        if (this.zzepp == null) {
            zzabj.zza(this.zzepr.zzrp(), this.zzeja, "aes2");
            this.zzepp = zzabj.zzb(this.zzepr.zzrp());
            this.zzepr.zza("native:view_show", this.zzepp);
        }
        HashMap map = new HashMap(1);
        map.put("version", this.zzbpe.zzbre);
        zza("onshow", map);
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final void zzuz() {
        com.google.android.gms.ads.internal.overlay.zze zzeVarZzabs = zzabs();
        if (zzeVarZzabs != null) {
            zzeVarZzabs.zzuz();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final zzbdn zzzr() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbdu
    public final synchronized zzbhd zzzs() {
        return this.zzeph;
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final zzabq zzzt() {
        return this.zzeja;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbdu, com.google.android.gms.internal.ads.zzbhi
    public final Activity zzzu() {
        return this.zzeol.zzzu();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbdu
    public final com.google.android.gms.ads.internal.zzb zzzv() {
        return this.zzeop;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbdu
    public final zzabp zzzw() {
        return this.zzepr;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbdu, com.google.android.gms.internal.ads.zzbht
    public final zzbbx zzzx() {
        return this.zzbpe;
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final int zzzy() {
        return getMeasuredHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final int zzzz() {
        return getMeasuredWidth();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zzb(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, zzbho.zzf(str2, zzbho.zzacx()), NanoHTTPD.MIME_HTML, "UTF-8", str3);
        } else {
            zzbbq.zzfe("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @TargetApi(19)
    private final synchronized void zza(String str, ValueCallback<String> valueCallback) {
        if (!isDestroyed()) {
            evaluateJavascript(str, null);
        } else {
            zzbbq.zzfe("#004 The webview is destroyed. Ignoring action.");
        }
    }

    @VisibleForTesting
    private final void zza(Boolean bool) {
        synchronized (this) {
            this.zzdzd = bool;
        }
        com.google.android.gms.ads.internal.zzp.zzkv().zza(bool);
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(string).length());
        sb.append(str);
        sb.append("(");
        sb.append(string);
        sb.append(");");
        zzft(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzajr
    public final void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String string = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(string);
        sb.append(");");
        String strValueOf = String.valueOf(sb.toString());
        zzbbq.zzef(strValueOf.length() != 0 ? "Dispatching AFMA event: ".concat(strValueOf) : new String("Dispatching AFMA event: "));
        zzft(sb.toString());
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zzb(com.google.android.gms.ads.internal.overlay.zze zzeVar) {
        this.zzept = zzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbhp
    public final void zzb(boolean z, int i) {
        this.zzeox.zzb(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzb(String str, zzahq<? super zzbgj> zzahqVar) {
        zzbgi zzbgiVar = this.zzeox;
        if (zzbgiVar != null) {
            zzbgiVar.zzb(str, zzahqVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final void zza(boolean z, long j) {
        HashMap map = new HashMap(2);
        map.put("success", z ? "1" : "0");
        map.put("duration", Long.toString(j));
        zza("onCacheAccessComplete", map);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zza(com.google.android.gms.ads.internal.overlay.zze zzeVar) {
        this.zzeoy = zzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zza(zzbhy zzbhyVar) {
        this.zzepa = zzbhyVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbdu
    public final synchronized void zza(String str, zzbfl zzbflVar) {
        if (this.zzepw == null) {
            this.zzepw = new HashMap();
        }
        this.zzepw.put(str, zzbflVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zza(zzadn zzadnVar) {
        this.zzepl = zzadnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zza(zzsc zzscVar) {
        this.zzepm = zzscVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zza(zzads zzadsVar) {
        this.zzepk = zzadsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbdu
    public final synchronized void zza(zzbhd zzbhdVar) {
        if (this.zzeph != null) {
            zzbbq.zzfc("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzeph = zzbhdVar;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbhp
    public final void zza(com.google.android.gms.ads.internal.overlay.zzb zzbVar) {
        this.zzeox.zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbhp
    public final void zza(boolean z, int i, String str) {
        this.zzeox.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbhp
    public final void zza(boolean z, int i, String str, String str2) {
        this.zzeox.zza(z, i, str, str2);
    }

    @Override // com.google.android.gms.internal.ads.zzqu
    public final void zza(zzqr zzqrVar) {
        synchronized (this) {
            this.zzepi = zzqrVar.zzbro;
        }
        zzbd(zzqrVar.zzbro);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zza(String str, zzahq<? super zzbgj> zzahqVar) {
        zzbgi zzbgiVar = this.zzeox;
        if (zzbgiVar != null) {
            zzbgiVar.zza(str, zzahqVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zza(String str, Predicate<zzahq<? super zzbgj>> predicate) {
        zzbgi zzbgiVar = this.zzeox;
        if (zzbgiVar != null) {
            zzbgiVar.zza(str, predicate);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zza(ViewGroup viewGroup, Activity activity, String str, String str2) {
        if (!zzacn()) {
            zzayp.zzei("AR ad is not enabled or the ad from the server is not an AR ad.");
            return;
        }
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
        zzayp.zzei("Initializing ArWebView object.");
        this.zzeor.zza(activity, this);
        this.zzeor.zzc(str, str2);
        if (viewGroup != null) {
            viewGroup.addView(this.zzeor.getView());
        } else {
            zzbbq.zzfc("The FrameLayout object cannot be null.");
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zza(zzdnv zzdnvVar, zzdnw zzdnwVar) {
        this.zzeot = zzdnvVar;
        this.zzeou = zzdnwVar;
    }

    static final /* synthetic */ void zza(boolean z, int i, zzua.zzi.zza zzaVar) {
        zzua.zzae.zza zzaVarZzpf = zzua.zzae.zzpf();
        if (zzaVarZzpf.zzpe() != z) {
            zzaVarZzpf.zzx(z);
        }
        zzaVar.zza((zzua.zzae) zzaVarZzpf.zzcy(i).zzbgt());
    }
}
