package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
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
import java.util.concurrent.atomic.AtomicReference;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@VisibleForTesting
final class zzbig extends zzbim implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzajz, zzbgj {
    private int maxHeight;
    private int maxWidth;
    private String zzacy;
    private final zzbbx zzbpe;
    private final WindowManager zzbrj;
    private int zzdoc;
    private int zzdod;
    private boolean zzdpo;
    private String zzdrb;
    private zzabq zzeja;
    private final zzts zzemr;
    private final zzbhz zzeol;
    private final zzeg zzeom;
    private final zzacb zzeon;
    private final com.google.android.gms.ads.internal.zzk zzeoo;
    private final com.google.android.gms.ads.internal.zzb zzeop;
    private final zzsu zzeor;
    private final boolean zzeos;
    private zzdnv zzeot;
    private zzdnw zzeou;
    private com.google.android.gms.ads.internal.overlay.zze zzeoy;
    private zzbhy zzepa;
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
    private zzbbh zzepv;
    private Map<String, zzbfl> zzepw;
    private final zzbib zzeqr;
    private final AtomicReference<IObjectWrapper> zzeqs;
    private final DisplayMetrics zzxd;

    @VisibleForTesting
    protected zzbig(zzbhz zzbhzVar, zzbib zzbibVar, zzbhy zzbhyVar, String str, boolean z, boolean z2, zzeg zzegVar, zzacb zzacbVar, zzbbx zzbbxVar, zzabs zzabsVar, com.google.android.gms.ads.internal.zzk zzkVar, com.google.android.gms.ads.internal.zzb zzbVar, zzts zztsVar, zzsu zzsuVar, boolean z3, zzdnv zzdnvVar, zzdnw zzdnwVar) {
        super(zzbhzVar, zzbibVar);
        this.zzepf = true;
        this.zzepg = false;
        this.zzdrb = "";
        this.zzeqs = new AtomicReference<>();
        this.zzdod = -1;
        this.zzdoc = -1;
        this.maxWidth = -1;
        this.maxHeight = -1;
        this.zzeol = zzbhzVar;
        this.zzeqr = zzbibVar;
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
        this.zzemr = zztsVar;
        this.zzeor = zzsuVar;
        this.zzeos = z3;
        this.zzeot = zzdnvVar;
        this.zzeou = zzdnwVar;
        this.zzepv = new zzbbh(this.zzeol.zzzu(), this, this, null);
        com.google.android.gms.ads.internal.zzp.zzkr().zza(zzbhzVar, zzbbxVar.zzbre, getSettings());
        setDownloadListener(this);
        zzacr();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(zzbhe.zzc(this), "googleAdsJsInterface");
        }
        zzacv();
        this.zzepr = new zzabp(new zzabs(true, "make_wv", this.zzacy));
        this.zzepr.zzrp().zzc(zzabsVar);
        this.zzeja = zzabj.zzb(this.zzepr.zzrp());
        this.zzepr.zza("native:view_create", this.zzeja);
        this.zzepq = null;
        this.zzepp = null;
        com.google.android.gms.ads.internal.zzp.zzkt().zzbg(zzbhzVar);
    }

    private final boolean zzaco() {
        int i;
        int iZzb;
        if (!this.zzeqr.zzabc() && !this.zzeqr.zzabd()) {
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

    private final void zzbd(boolean z) {
        HashMap map = new HashMap();
        map.put("isVisible", z ? "1" : "0");
        zzakc.zza(this, "onAdVisibilityChanged", map);
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

    @Override // android.webkit.WebView, android.view.ViewGroup, android.view.View
    protected final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.zzepv.onAttachedToWindow();
        }
        boolean z = this.zzepi;
        if (this.zzeqr != null && this.zzeqr.zzabd()) {
            if (!this.zzepj) {
                this.zzeqr.zzabf();
                this.zzeqr.zzabg();
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
            if (this.zzepj && this.zzeqr != null && this.zzeqr.zzabd() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzeqr.zzabf();
                this.zzeqr.zzabg();
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

    @Override // com.google.android.gms.internal.ads.zzbim, android.webkit.WebView, android.view.View
    @TargetApi(21)
    protected final void onDraw(Canvas canvas) {
        if (Build.VERSION.SDK_INT == 21 && canvas.isHardwareAccelerated() && !isAttachedToWindow()) {
            return;
        }
        super.onDraw(canvas);
        zzbib zzbibVar = this.zzeqr;
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

    @Override // android.webkit.WebView, android.widget.AbsoluteLayout, android.view.View
    @SuppressLint({"DrawAllocation"})
    protected final synchronized void onMeasure(int i, int i2) {
        if (isDestroyed()) {
            setMeasuredDimension(0, 0);
            return;
        }
        if (!isInEditMode() && !this.zzepc && !this.zzepa.zzadc()) {
            if (this.zzepa.zzade()) {
                super.onMeasure(i, i2);
                return;
            }
            if (this.zzepa.zzadd()) {
                if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcsg)).booleanValue()) {
                    super.onMeasure(i, i2);
                    return;
                }
                zzbhd zzbhdVarZzzs = zzzs();
                float aspectRatio = zzbhdVarZzzs != null ? zzbhdVarZzzs.getAspectRatio() : WheelView.DividerConfig.FILL;
                if (aspectRatio == WheelView.DividerConfig.FILL) {
                    super.onMeasure(i, i2);
                    return;
                }
                int size = View.MeasureSpec.getSize(i);
                int size2 = View.MeasureSpec.getSize(i2);
                int i3 = (int) (size2 * aspectRatio);
                int i4 = (int) (size / aspectRatio);
                if (size2 == 0 && i4 != 0) {
                    i3 = (int) (i4 * aspectRatio);
                    size2 = i4;
                } else if (size == 0 && i3 != 0) {
                    i4 = (int) (i3 / aspectRatio);
                    size = i3;
                }
                setMeasuredDimension(Math.min(i3, size), Math.min(i4, size2));
                return;
            }
            if (this.zzepa.isFluid()) {
                if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcsj)).booleanValue() && PlatformVersion.isAtLeastJellyBeanMR1()) {
                    zza("/contentHeight", new zzbii(this));
                    zzdc("(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();");
                    setMeasuredDimension(View.MeasureSpec.getSize(i), this.zzepo != -1 ? (int) (this.zzepo * this.zzxd.density) : View.MeasureSpec.getSize(i2));
                    return;
                }
                super.onMeasure(i, i2);
                return;
            }
            if (this.zzepa.zzadb()) {
                setMeasuredDimension(this.zzxd.widthPixels, this.zzxd.heightPixels);
                return;
            }
            int mode = View.MeasureSpec.getMode(i);
            int size3 = View.MeasureSpec.getSize(i);
            int mode2 = View.MeasureSpec.getMode(i2);
            int size4 = View.MeasureSpec.getSize(i2);
            int i5 = (mode == Integer.MIN_VALUE || mode == 1073741824) ? size3 : Integer.MAX_VALUE;
            int i6 = (mode2 == Integer.MIN_VALUE || mode2 == 1073741824) ? size4 : Integer.MAX_VALUE;
            boolean z = true;
            boolean z2 = this.zzepa.widthPixels > i5 || this.zzepa.heightPixels > i6;
            if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcuu)).booleanValue()) {
                if (this.zzepa.widthPixels / this.zzxd.density > i5 / this.zzxd.density || this.zzepa.heightPixels / this.zzxd.density > i6 / this.zzxd.density) {
                    z = false;
                }
                if (z2) {
                    z2 = z;
                }
            }
            if (!z2) {
                if (getVisibility() != 8) {
                    setVisibility(0);
                }
                setMeasuredDimension(this.zzepa.widthPixels, this.zzepa.heightPixels);
                return;
            }
            int i7 = (int) (this.zzepa.widthPixels / this.zzxd.density);
            int i8 = (int) (this.zzepa.heightPixels / this.zzxd.density);
            int i9 = (int) (size3 / this.zzxd.density);
            int i10 = (int) (size4 / this.zzxd.density);
            StringBuilder sb = new StringBuilder(103);
            sb.append("Not enough space to show ad. Needs ");
            sb.append(i7);
            sb.append("x");
            sb.append(i8);
            sb.append(" dp, but only has ");
            sb.append(i9);
            sb.append("x");
            sb.append(i10);
            sb.append(" dp.");
            zzbbq.zzfe(sb.toString());
            if (getVisibility() != 8) {
                setVisibility(4);
            }
            setMeasuredDimension(0, 0);
            return;
        }
        super.onMeasure(i, i2);
    }

    @Override // com.google.android.gms.internal.ads.zzbim, android.webkit.WebView, com.google.android.gms.internal.ads.zzbgj
    public final void onPause() {
        try {
            super.onPause();
        } catch (Exception e2) {
            zzbbq.zzc("Could not pause webview.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbim, android.webkit.WebView, com.google.android.gms.internal.ads.zzbgj
    public final void onResume() {
        try {
            super.onResume();
        } catch (Exception e2) {
            zzbbq.zzc("Could not resume webview.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbim, android.webkit.WebView, android.view.View
    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzeqr.zzabd() || this.zzeqr.zzabe()) {
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

    @Override // com.google.android.gms.internal.ads.zzbim, android.webkit.WebView
    public final void stopLoading() {
        try {
            super.stopLoading();
        } catch (Exception e2) {
            zzbbq.zzc("Could not stop loading webview.", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzajr
    public final void zza(String str, Map map) {
        zzakc.zza(this, str, map);
    }

    @Override // com.google.android.gms.internal.ads.zzajz, com.google.android.gms.internal.ads.zzajr
    public final void zza(String str, JSONObject jSONObject) {
        zzakc.zzb(this, str, jSONObject);
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final void zza(boolean z, long j) {
        HashMap map = new HashMap(2);
        map.put("success", z ? "1" : "0");
        map.put("duration", Long.toString(j));
        zzakc.zza(this, "onCacheAccessComplete", map);
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
        zzakc.zza(this, "onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzabq() {
        HashMap map = new HashMap(3);
        map.put("app_muted", String.valueOf(com.google.android.gms.ads.internal.zzp.zzkw().zzqh()));
        map.put("app_volume", String.valueOf(com.google.android.gms.ads.internal.zzp.zzkw().zzqg()));
        map.put("device_volume", String.valueOf(zzazm.zzbi(getContext())));
        zzakc.zza(this, "volume", map);
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
        return this.zzeqr;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final WebViewClient zzabx() {
        return this.zzeqr;
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
    public final IObjectWrapper zzaca() {
        return this.zzeqs.get();
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbhl
    public final synchronized boolean zzacb() {
        return this.zzepc;
    }

    @Override // com.google.android.gms.internal.ads.zzbim, com.google.android.gms.internal.ads.zzbgj
    public final void zzacc() {
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
            this.zzeoy.zza(this.zzeqr.zzabc(), z);
        } else {
            this.zzdpo = z;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzap(IObjectWrapper iObjectWrapper) {
        this.zzeqs.set(iObjectWrapper);
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final void zzav(boolean z) {
        this.zzeqr.zzav(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzax(boolean z) {
        this.zzeqr.zzax(z);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zzb(String str, String str2, String str3) {
        super.loadDataWithBaseURL(str, zzbho.zzf(str2, zzbho.zzacx()), NanoHTTPD.MIME_HTML, "UTF-8", str3);
    }

    @Override // com.google.android.gms.internal.ads.zzaks
    public final void zzb(String str, JSONObject jSONObject) {
        zzakc.zza(this, str, jSONObject);
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

    @Override // com.google.android.gms.internal.ads.zzbim
    protected final synchronized void zzbe(boolean z) {
        if (z) {
            this.zzeqs.set(null);
            this.zzeqr.destroy();
            com.google.android.gms.ads.internal.zzp.zzln();
            zzbfi.zzc(this);
            zzacu();
        } else {
            zzacv();
            this.zzepv.zzyq();
            if (this.zzeoy != null) {
                this.zzeoy.close();
                this.zzeoy.onDestroy();
                this.zzeoy = null;
            }
            this.zzeqs.set(null);
            this.zzeqr.destroy();
            com.google.android.gms.ads.internal.zzp.zzln();
            zzbfi.zzc(this);
            zzacu();
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
        this.zzemr.zza(new zztr(z, i) { // from class: com.google.android.gms.internal.ads.zzbij
            private final int zzebs;
            private final boolean zzeok;

            {
                this.zzeok = z;
                this.zzebs = i;
            }

            @Override // com.google.android.gms.internal.ads.zztr
            public final void zza(zzua.zzi.zza zzaVar) {
                zzbig.zza(this.zzeok, this.zzebs, zzaVar);
            }
        });
        this.zzemr.zza(zztu.zza.zzb.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    @Override // com.google.android.gms.internal.ads.zzbim, com.google.android.gms.internal.ads.zzbil, com.google.android.gms.internal.ads.zzajz, com.google.android.gms.internal.ads.zzaks
    public final synchronized void zzdc(String str) {
        if (isDestroyed()) {
            zzbbq.zzfe("The webview is destroyed. Ignoring action.");
        } else {
            super.zzdc(str);
        }
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
        zzakc.zza(this, "onhide", map);
    }

    @Override // com.google.android.gms.internal.ads.zzbdu
    public final synchronized zzbfl zzfj(String str) {
        if (this.zzepw == null) {
            return null;
        }
        return this.zzepw.get(str);
    }

    @Override // com.google.android.gms.internal.ads.zzajz
    public final void zzj(String str, String str2) {
        zzakc.zza(this, str, str2);
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
        zzakc.zza(this, "onshow", map);
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
    public final synchronized void zza(com.google.android.gms.ads.internal.overlay.zze zzeVar) {
        this.zzeoy = zzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zzb(com.google.android.gms.ads.internal.overlay.zze zzeVar) {
        this.zzept = zzeVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zza(zzbhy zzbhyVar) {
        this.zzepa = zzbhyVar;
        requestLayout();
    }

    @Override // com.google.android.gms.internal.ads.zzbhp
    public final void zzb(boolean z, int i) {
        this.zzeqr.zzb(z, i);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zzb(String str, zzahq<? super zzbgj> zzahqVar) {
        zzbib zzbibVar = this.zzeqr;
        if (zzbibVar != null) {
            zzbibVar.zzb(str, zzahqVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgj, com.google.android.gms.internal.ads.zzbdu
    public final synchronized void zza(String str, zzbfl zzbflVar) {
        if (this.zzepw == null) {
            this.zzepw = new HashMap();
        }
        this.zzepw.put(str, zzbflVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zza(zzads zzadsVar) {
        this.zzepk = zzadsVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zza(zzadn zzadnVar) {
        this.zzepl = zzadnVar;
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final synchronized void zza(zzsc zzscVar) {
        this.zzepm = zzscVar;
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
        this.zzeqr.zza(zzbVar);
    }

    @Override // com.google.android.gms.internal.ads.zzbhp
    public final void zza(boolean z, int i, String str) {
        this.zzeqr.zza(z, i, str);
    }

    @Override // com.google.android.gms.internal.ads.zzbhp
    public final void zza(boolean z, int i, String str, String str2) {
        this.zzeqr.zza(z, i, str, str2);
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
        zzbib zzbibVar = this.zzeqr;
        if (zzbibVar != null) {
            zzbibVar.zza(str, zzahqVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzbgj
    public final void zza(String str, Predicate<zzahq<? super zzbgj>> predicate) {
        zzbib zzbibVar = this.zzeqr;
        if (zzbibVar != null) {
            zzbibVar.zza(str, predicate);
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
