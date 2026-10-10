package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzagt;
import com.google.android.gms.internal.ads.zzagv;
import com.google.android.gms.internal.ads.zzaqn;
import com.google.android.gms.internal.ads.zzarb;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzazd;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzbgj;
import com.google.android.gms.internal.ads.zzbgr;
import com.google.android.gms.internal.ads.zzbhu;
import com.google.android.gms.internal.ads.zzbhv;
import com.google.android.gms.internal.ads.zzts;
import com.google.android.gms.internal.ads.zzwm;
import com.umeng.analytics.pro.m;
import fi.iki.elonen.NanoHTTPD;
import io.rong.common.dlog.DLog;
import java.util.Collections;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public class zze extends zzarb implements zzw {

    @VisibleForTesting
    private static final int zzdon = Color.argb(0, 0, 0, 0);
    protected final Activity zzaas;

    @VisibleForTesting
    zzbgj zzdgy;

    @VisibleForTesting
    AdOverlayInfoParcel zzdoo;

    @VisibleForTesting
    private zzk zzdop;

    @VisibleForTesting
    private zzo zzdoq;

    @VisibleForTesting
    private FrameLayout zzdos;

    @VisibleForTesting
    private WebChromeClient.CustomViewCallback zzdot;

    @VisibleForTesting
    private zzh zzdov;
    private Runnable zzdoz;
    private boolean zzdpa;
    private boolean zzdpb;

    @VisibleForTesting
    private boolean zzdor = false;

    @VisibleForTesting
    private boolean zzdou = false;

    @VisibleForTesting
    private boolean zzbov = false;

    @VisibleForTesting
    private boolean zzdow = false;

    @VisibleForTesting
    int zzdox = 0;
    private final Object zzdoy = new Object();
    private boolean zzdpc = false;
    private boolean zzdpd = false;
    private boolean zzdpe = true;

    public zze(Activity activity) {
        this.zzaas = activity;
    }

    private final void zzaj(boolean z) {
        int iIntValue = ((Integer) zzwm.zzpx().zzd(zzabb.zzctv)).intValue();
        zzr zzrVar = new zzr();
        zzrVar.size = 50;
        zzrVar.paddingLeft = z ? iIntValue : 0;
        zzrVar.paddingRight = z ? 0 : iIntValue;
        zzrVar.paddingTop = 0;
        zzrVar.paddingBottom = iIntValue;
        this.zzdoq = new zzo(this.zzaas, zzrVar, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.zzdoo.zzdpo);
        this.zzdov.addView(this.zzdoq, layoutParams);
    }

    private final void zzak(boolean z) throws zzi {
        if (!this.zzdpb) {
            this.zzaas.requestWindowFeature(1);
        }
        Window window = this.zzaas.getWindow();
        if (window == null) {
            throw new zzi("Invalid activity, no window available.");
        }
        zzbgj zzbgjVar = this.zzdoo.zzdgy;
        zzbhv zzbhvVarZzabw = zzbgjVar != null ? zzbgjVar.zzabw() : null;
        boolean z2 = zzbhvVarZzabw != null && zzbhvVarZzabw.zzabc();
        this.zzdow = false;
        if (z2) {
            int i = this.zzdoo.orientation;
            com.google.android.gms.ads.internal.zzp.zzkt();
            if (i == 6) {
                this.zzdow = this.zzaas.getResources().getConfiguration().orientation == 1;
            } else {
                int i2 = this.zzdoo.orientation;
                com.google.android.gms.ads.internal.zzp.zzkt();
                if (i2 == 7) {
                    this.zzdow = this.zzaas.getResources().getConfiguration().orientation == 2;
                }
            }
        }
        boolean z3 = this.zzdow;
        StringBuilder sb = new StringBuilder(46);
        sb.append("Delay onShow to next orientation change: ");
        sb.append(z3);
        zzbbq.zzef(sb.toString());
        setRequestedOrientation(this.zzdoo.orientation);
        com.google.android.gms.ads.internal.zzp.zzkt();
        window.setFlags(16777216, 16777216);
        zzbbq.zzef("Hardware acceleration on the AdActivity window enabled.");
        if (this.zzbov) {
            this.zzdov.setBackgroundColor(zzdon);
        } else {
            this.zzdov.setBackgroundColor(-16777216);
        }
        this.zzaas.setContentView(this.zzdov);
        this.zzdpb = true;
        if (z) {
            try {
                com.google.android.gms.ads.internal.zzp.zzks();
                this.zzdgy = zzbgr.zza(this.zzaas, this.zzdoo.zzdgy != null ? this.zzdoo.zzdgy.zzabu() : null, this.zzdoo.zzdgy != null ? this.zzdoo.zzdgy.zzabv() : null, true, z2, null, null, this.zzdoo.zzbpe, null, null, this.zzdoo.zzdgy != null ? this.zzdoo.zzdgy.zzzv() : null, zzts.zzna(), null, false, null, null);
                zzbhv zzbhvVarZzabw2 = this.zzdgy.zzabw();
                AdOverlayInfoParcel adOverlayInfoParcel = this.zzdoo;
                zzagt zzagtVar = adOverlayInfoParcel.zzdep;
                zzagv zzagvVar = adOverlayInfoParcel.zzdeq;
                zzv zzvVar = adOverlayInfoParcel.zzdpq;
                zzbgj zzbgjVar2 = adOverlayInfoParcel.zzdgy;
                zzbhvVarZzabw2.zza(null, zzagtVar, null, zzagvVar, zzvVar, true, null, zzbgjVar2 != null ? zzbgjVar2.zzabw().zzabb() : null, null, null);
                this.zzdgy.zzabw().zza(new zzbhu(this) { // from class: com.google.android.gms.ads.internal.overlay.zzd
                    private final zze zzdom;

                    {
                        this.zzdom = this;
                    }

                    @Override // com.google.android.gms.internal.ads.zzbhu
                    public final void zzai(boolean z4) {
                        zzbgj zzbgjVar3 = this.zzdom.zzdgy;
                        if (zzbgjVar3 != null) {
                            zzbgjVar3.zzuy();
                        }
                    }
                });
                AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdoo;
                String str = adOverlayInfoParcel2.url;
                if (str != null) {
                    this.zzdgy.loadUrl(str);
                } else {
                    String str2 = adOverlayInfoParcel2.zzdpp;
                    if (str2 == null) {
                        throw new zzi("No URL or HTML to display in ad overlay.");
                    }
                    this.zzdgy.loadDataWithBaseURL(adOverlayInfoParcel2.zzdpn, str2, NanoHTTPD.MIME_HTML, "UTF-8", null);
                }
                zzbgj zzbgjVar3 = this.zzdoo.zzdgy;
                if (zzbgjVar3 != null) {
                    zzbgjVar3.zzb(this);
                }
            } catch (Exception e2) {
                zzbbq.zzc("Error obtaining webview.", e2);
                throw new zzi("Could not obtain webview for the overlay.");
            }
        } else {
            this.zzdgy = this.zzdoo.zzdgy;
            this.zzdgy.zzbw(this.zzaas);
        }
        this.zzdgy.zza(this);
        zzbgj zzbgjVar4 = this.zzdoo.zzdgy;
        if (zzbgjVar4 != null) {
            zzc(zzbgjVar4.zzaca(), this.zzdov);
        }
        ViewParent parent = this.zzdgy.getParent();
        if (parent != null && (parent instanceof ViewGroup)) {
            ((ViewGroup) parent).removeView(this.zzdgy.getView());
        }
        if (this.zzbov) {
            this.zzdgy.zzaci();
        }
        zzbgj zzbgjVar5 = this.zzdgy;
        Activity activity = this.zzaas;
        AdOverlayInfoParcel adOverlayInfoParcel3 = this.zzdoo;
        zzbgjVar5.zza((ViewGroup) null, activity, adOverlayInfoParcel3.zzdpn, adOverlayInfoParcel3.zzdpp);
        this.zzdov.addView(this.zzdgy.getView(), -1, -1);
        if (!z && !this.zzdow) {
            zzuy();
        }
        zzaj(z2);
        if (this.zzdgy.zzaby()) {
            zza(z2, true);
        }
    }

    private static void zzc(IObjectWrapper iObjectWrapper, View view) {
        if (iObjectWrapper == null || view == null) {
            return;
        }
        com.google.android.gms.ads.internal.zzp.zzlg().zza(iObjectWrapper, view);
    }

    private final void zzuv() {
        if (!this.zzaas.isFinishing() || this.zzdpc) {
            return;
        }
        this.zzdpc = true;
        zzbgj zzbgjVar = this.zzdgy;
        if (zzbgjVar != null) {
            zzbgjVar.zzdu(this.zzdox);
            synchronized (this.zzdoy) {
                if (!this.zzdpa && this.zzdgy.zzace()) {
                    this.zzdoz = new Runnable(this) { // from class: com.google.android.gms.ads.internal.overlay.zzg
                        private final zze zzdom;

                        {
                            this.zzdom = this;
                        }

                        @Override // java.lang.Runnable
                        public final void run() {
                            this.zzdom.zzuw();
                        }
                    };
                    zzayu.zzeba.postDelayed(this.zzdoz, ((Long) zzwm.zzpx().zzd(zzabb.zzcot)).longValue());
                    return;
                }
            }
        }
        zzuw();
    }

    private final void zzuy() {
        this.zzdgy.zzuy();
    }

    public final void close() {
        this.zzdox = 2;
        this.zzaas.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onBackPressed() {
        this.zzdox = 0;
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public void onCreate(Bundle bundle) {
        this.zzaas.requestWindowFeature(1);
        this.zzdou = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            this.zzdoo = AdOverlayInfoParcel.zzd(this.zzaas.getIntent());
            if (this.zzdoo == null) {
                throw new zzi("Could not get info for ad overlay.");
            }
            if (this.zzdoo.zzbpe.zzeem > 7500000) {
                this.zzdox = 3;
            }
            if (this.zzaas.getIntent() != null) {
                this.zzdpe = this.zzaas.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
            }
            if (this.zzdoo.zzdpt != null) {
                this.zzbov = this.zzdoo.zzdpt.zzbov;
            } else {
                this.zzbov = false;
            }
            if (this.zzbov && this.zzdoo.zzdpt.zzbpa != -1) {
                new zzj(this).zzwz();
            }
            if (bundle == null) {
                if (this.zzdoo.zzdpm != null && this.zzdpe) {
                    this.zzdoo.zzdpm.zzun();
                }
                if (this.zzdoo.zzdpr != 1 && this.zzdoo.zzcgv != null) {
                    this.zzdoo.zzcgv.onAdClicked();
                }
            }
            this.zzdov = new zzh(this.zzaas, this.zzdoo.zzdps, this.zzdoo.zzbpe.zzbre);
            this.zzdov.setId(1000);
            com.google.android.gms.ads.internal.zzp.zzkt().zzg(this.zzaas);
            int i = this.zzdoo.zzdpr;
            if (i == 1) {
                zzak(false);
                return;
            }
            if (i == 2) {
                this.zzdop = new zzk(this.zzdoo.zzdgy);
                zzak(false);
            } else {
                if (i != 3) {
                    throw new zzi("Could not determine ad overlay type.");
                }
                zzak(true);
            }
        } catch (zzi e2) {
            zzbbq.zzfe(e2.getMessage());
            this.zzdox = 3;
            this.zzaas.finish();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onDestroy() {
        zzbgj zzbgjVar = this.zzdgy;
        if (zzbgjVar != null) {
            try {
                this.zzdov.removeView(zzbgjVar.getView());
            } catch (NullPointerException unused) {
            }
        }
        zzuv();
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onPause() {
        zzur();
        zzp zzpVar = this.zzdoo.zzdpm;
        if (zzpVar != null) {
            zzpVar.onPause();
        }
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzctt)).booleanValue() && this.zzdgy != null && (!this.zzaas.isFinishing() || this.zzdop == null)) {
            com.google.android.gms.ads.internal.zzp.zzkt();
            zzazd.zza(this.zzdgy);
        }
        zzuv();
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onRestart() {
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onResume() {
        zzp zzpVar = this.zzdoo.zzdpm;
        if (zzpVar != null) {
            zzpVar.onResume();
        }
        zza(this.zzaas.getResources().getConfiguration());
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzctt)).booleanValue()) {
            return;
        }
        zzbgj zzbgjVar = this.zzdgy;
        if (zzbgjVar == null || zzbgjVar.isDestroyed()) {
            zzbbq.zzfe("The webview does not exist. Ignoring action.");
        } else {
            com.google.android.gms.ads.internal.zzp.zzkt();
            zzazd.zzb(this.zzdgy);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdou);
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onStart() {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzctt)).booleanValue()) {
            zzbgj zzbgjVar = this.zzdgy;
            if (zzbgjVar == null || zzbgjVar.isDestroyed()) {
                zzbbq.zzfe("The webview does not exist. Ignoring action.");
            } else {
                com.google.android.gms.ads.internal.zzp.zzkt();
                zzazd.zzb(this.zzdgy);
            }
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void onStop() {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzctt)).booleanValue() && this.zzdgy != null && (!this.zzaas.isFinishing() || this.zzdop == null)) {
            com.google.android.gms.ads.internal.zzp.zzkt();
            zzazd.zza(this.zzdgy);
        }
        zzuv();
    }

    public final void setRequestedOrientation(int i) {
        if (this.zzaas.getApplicationInfo().targetSdkVersion >= ((Integer) zzwm.zzpx().zzd(zzabb.zzcvy)).intValue()) {
            if (this.zzaas.getApplicationInfo().targetSdkVersion <= ((Integer) zzwm.zzpx().zzd(zzabb.zzcvz)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzwm.zzpx().zzd(zzabb.zzcwa)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzwm.zzpx().zzd(zzabb.zzcwb)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzaas.setRequestedOrientation(i);
        } catch (Throwable th) {
            com.google.android.gms.ads.internal.zzp.zzkv().zzb(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zza(boolean z, boolean z2) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        com.google.android.gms.ads.internal.zzi zziVar;
        AdOverlayInfoParcel adOverlayInfoParcel2;
        com.google.android.gms.ads.internal.zzi zziVar2;
        boolean z3 = true;
        boolean z4 = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcou)).booleanValue() && (adOverlayInfoParcel2 = this.zzdoo) != null && (zziVar2 = adOverlayInfoParcel2.zzdpt) != null && zziVar2.zzbpc;
        boolean z5 = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcov)).booleanValue() && (adOverlayInfoParcel = this.zzdoo) != null && (zziVar = adOverlayInfoParcel.zzdpt) != null && zziVar.zzbpd;
        if (z && z2 && z4 && !z5) {
            new zzaqn(this.zzdgy, "useCustomClose").zzdx("Custom close has been disabled for interstitial ads in this ad slot.");
        }
        zzo zzoVar = this.zzdoq;
        if (zzoVar != null) {
            if (!z5 && (!z2 || z4)) {
                z3 = false;
            }
            zzoVar.zzal(z3);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void zzad(IObjectWrapper iObjectWrapper) {
        zza((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final void zzdq() {
        this.zzdpb = true;
    }

    public final void zzur() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdoo;
        if (adOverlayInfoParcel != null && this.zzdor) {
            setRequestedOrientation(adOverlayInfoParcel.orientation);
        }
        if (this.zzdos != null) {
            this.zzaas.setContentView(this.zzdov);
            this.zzdpb = true;
            this.zzdos.removeAllViews();
            this.zzdos = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzdot;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzdot = null;
        }
        this.zzdor = false;
    }

    @Override // com.google.android.gms.ads.internal.overlay.zzw
    public final void zzus() {
        this.zzdox = 1;
        this.zzaas.finish();
    }

    @Override // com.google.android.gms.internal.ads.zzaqy
    public final boolean zzut() {
        this.zzdox = 0;
        zzbgj zzbgjVar = this.zzdgy;
        if (zzbgjVar == null) {
            return true;
        }
        boolean zZzacd = zzbgjVar.zzacd();
        if (!zZzacd) {
            this.zzdgy.zza("onbackblocked", Collections.emptyMap());
        }
        return zZzacd;
    }

    public final void zzuu() {
        this.zzdov.removeView(this.zzdoq);
        zzaj(true);
    }

    @VisibleForTesting
    final void zzuw() {
        zzbgj zzbgjVar;
        zzp zzpVar;
        if (this.zzdpd) {
            return;
        }
        this.zzdpd = true;
        zzbgj zzbgjVar2 = this.zzdgy;
        if (zzbgjVar2 != null) {
            this.zzdov.removeView(zzbgjVar2.getView());
            zzk zzkVar = this.zzdop;
            if (zzkVar != null) {
                this.zzdgy.zzbw(zzkVar.zzvr);
                this.zzdgy.zzba(false);
                ViewGroup viewGroup = this.zzdop.parent;
                View view = this.zzdgy.getView();
                zzk zzkVar2 = this.zzdop;
                viewGroup.addView(view, zzkVar2.index, zzkVar2.zzdpi);
                this.zzdop = null;
            } else if (this.zzaas.getApplicationContext() != null) {
                this.zzdgy.zzbw(this.zzaas.getApplicationContext());
            }
            this.zzdgy = null;
        }
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdoo;
        if (adOverlayInfoParcel != null && (zzpVar = adOverlayInfoParcel.zzdpm) != null) {
            zzpVar.zzum();
        }
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdoo;
        if (adOverlayInfoParcel2 == null || (zzbgjVar = adOverlayInfoParcel2.zzdgy) == null) {
            return;
        }
        zzc(zzbgjVar.zzaca(), this.zzdoo.zzdgy.getView());
    }

    public final void zzux() {
        if (this.zzdow) {
            this.zzdow = false;
            zzuy();
        }
    }

    public final void zzuz() {
        this.zzdov.zzdpg = true;
    }

    public final void zzva() {
        synchronized (this.zzdoy) {
            this.zzdpa = true;
            if (this.zzdoz != null) {
                zzayu.zzeba.removeCallbacks(this.zzdoz);
                zzayu.zzeba.post(this.zzdoz);
            }
        }
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.zzdos = new FrameLayout(this.zzaas);
        this.zzdos.setBackgroundColor(-16777216);
        this.zzdos.addView(view, -1, -1);
        this.zzaas.setContentView(this.zzdos);
        this.zzdpb = true;
        this.zzdot = customViewCallback;
        this.zzdor = true;
    }

    private final void zza(Configuration configuration) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        com.google.android.gms.ads.internal.zzi zziVar;
        com.google.android.gms.ads.internal.zzi zziVar2;
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdoo;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = (adOverlayInfoParcel2 == null || (zziVar2 = adOverlayInfoParcel2.zzdpt) == null || !zziVar2.zzbow) ? false : true;
        boolean zZza = com.google.android.gms.ads.internal.zzp.zzkt().zza(this.zzaas, configuration);
        if ((this.zzbov && !z3) || zZza) {
            z = false;
        } else if (Build.VERSION.SDK_INT >= 19 && (adOverlayInfoParcel = this.zzdoo) != null && (zziVar = adOverlayInfoParcel.zzdpt) != null && zziVar.zzbpb) {
            z2 = true;
        }
        Window window = this.zzaas.getWindow();
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcow)).booleanValue() && Build.VERSION.SDK_INT >= 19) {
            View decorView = window.getDecorView();
            int i = 256;
            if (z) {
                i = 5380;
                if (z2) {
                    i = 5894;
                }
            }
            decorView.setSystemUiVisibility(i);
            return;
        }
        if (z) {
            window.addFlags(1024);
            window.clearFlags(DLog.CRS);
            if (Build.VERSION.SDK_INT < 19 || !z2) {
                return;
            }
            window.getDecorView().setSystemUiVisibility(m.a.f20900b);
            return;
        }
        window.addFlags(DLog.CRS);
        window.clearFlags(1024);
    }
}
