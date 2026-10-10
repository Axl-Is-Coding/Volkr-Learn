package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.doubleclick.OnCustomRenderedAdLoadedListener;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzyy {
    private final zzvl zzacs;
    private VideoOptions zzbnr;
    private boolean zzbny;
    private AppEventListener zzboa;
    private zzxc zzbut;
    private String zzbuu;
    private final zzanc zzbuw;
    private zzux zzcgv;
    private AdListener zzcha;
    private AdSize[] zzcif;
    private final AtomicBoolean zzcjs;
    private final VideoController zzcjt;

    @VisibleForTesting
    private final zzwp zzcju;
    private OnCustomRenderedAdLoadedListener zzcjv;
    private ViewGroup zzcjw;
    private int zzcjx;
    private OnPaidEventListener zzcjy;

    public zzyy(ViewGroup viewGroup) {
        this(viewGroup, null, false, zzvl.zzchs, 0);
    }

    private static boolean zzcz(int i) {
        return i == 1;
    }

    public final void destroy() {
        try {
            if (this.zzbut != null) {
                this.zzbut.destroy();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final AdListener getAdListener() {
        return this.zzcha;
    }

    public final AdSize getAdSize() {
        zzvn zzvnVarZzkg;
        try {
            if (this.zzbut != null && (zzvnVarZzkg = this.zzbut.zzkg()) != null) {
                return zzvnVarZzkg.zzpo();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
        AdSize[] adSizeArr = this.zzcif;
        if (adSizeArr != null) {
            return adSizeArr[0];
        }
        return null;
    }

    public final AdSize[] getAdSizes() {
        return this.zzcif;
    }

    public final String getAdUnitId() {
        zzxc zzxcVar;
        if (this.zzbuu == null && (zzxcVar = this.zzbut) != null) {
            try {
                this.zzbuu = zzxcVar.getAdUnitId();
            } catch (RemoteException e2) {
                zzbbq.zze("#007 Could not call remote method.", e2);
            }
        }
        return this.zzbuu;
    }

    public final AppEventListener getAppEventListener() {
        return this.zzboa;
    }

    public final String getMediationAdapterClassName() {
        try {
            if (this.zzbut != null) {
                return this.zzbut.zzkh();
            }
            return null;
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public final OnCustomRenderedAdLoadedListener getOnCustomRenderedAdLoadedListener() {
        return this.zzcjv;
    }

    public final ResponseInfo getResponseInfo() {
        zzyn zzynVarZzki = null;
        try {
            if (this.zzbut != null) {
                zzynVarZzki = this.zzbut.zzki();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
        return ResponseInfo.zza(zzynVarZzki);
    }

    public final VideoController getVideoController() {
        return this.zzcjt;
    }

    public final VideoOptions getVideoOptions() {
        return this.zzbnr;
    }

    public final boolean isLoading() {
        try {
            if (this.zzbut != null) {
                return this.zzbut.isLoading();
            }
            return false;
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            return false;
        }
    }

    public final void pause() {
        try {
            if (this.zzbut != null) {
                this.zzbut.pause();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void recordManualImpression() {
        if (this.zzcjs.getAndSet(true)) {
            return;
        }
        try {
            if (this.zzbut != null) {
                this.zzbut.zzkf();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void resume() {
        try {
            if (this.zzbut != null) {
                this.zzbut.resume();
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setAdListener(AdListener adListener) {
        this.zzcha = adListener;
        this.zzcju.zza(adListener);
    }

    public final void setAdSizes(AdSize... adSizeArr) {
        if (this.zzcif != null) {
            throw new IllegalStateException("The ad size can only be set once on AdView.");
        }
        zza(adSizeArr);
    }

    public final void setAdUnitId(String str) {
        if (this.zzbuu != null) {
            throw new IllegalStateException("The ad unit ID can only be set once on AdView.");
        }
        this.zzbuu = str;
    }

    public final void setAppEventListener(AppEventListener appEventListener) {
        try {
            this.zzboa = appEventListener;
            if (this.zzbut != null) {
                this.zzbut.zza(appEventListener != null ? new zzvt(appEventListener) : null);
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbny = z;
        try {
            if (this.zzbut != null) {
                this.zzbut.setManualImpressionsEnabled(this.zzbny);
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setOnCustomRenderedAdLoadedListener(OnCustomRenderedAdLoadedListener onCustomRenderedAdLoadedListener) {
        this.zzcjv = onCustomRenderedAdLoadedListener;
        try {
            if (this.zzbut != null) {
                this.zzbut.zza(onCustomRenderedAdLoadedListener != null ? new zzabz(onCustomRenderedAdLoadedListener) : null);
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        try {
            this.zzcjy = onPaidEventListener;
            if (this.zzbut != null) {
                this.zzbut.zza(new zzaab(onPaidEventListener));
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#008 Must be called on the main UI thread.", e2);
        }
    }

    public final void setVideoOptions(VideoOptions videoOptions) {
        this.zzbnr = videoOptions;
        try {
            if (this.zzbut != null) {
                this.zzbut.zza(videoOptions == null ? null : new zzaak(videoOptions));
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void zza(zzyw zzywVar) {
        try {
            if (this.zzbut == null) {
                if ((this.zzcif == null || this.zzbuu == null) && this.zzbut == null) {
                    throw new IllegalStateException("The ad size and ad unit ID must be set before loadAd is called.");
                }
                Context context = this.zzcjw.getContext();
                zzvn zzvnVarZza = zza(context, this.zzcif, this.zzcjx);
                this.zzbut = "search_v2".equals(zzvnVarZza.zzacy) ? new zzwe(zzwm.zzpu(), context, zzvnVarZza, this.zzbuu).zzd(context, false) : new zzvw(zzwm.zzpu(), context, zzvnVarZza, this.zzbuu, this.zzbuw).zzd(context, false);
                this.zzbut.zza(new zzvc(this.zzcju));
                if (this.zzcgv != null) {
                    this.zzbut.zza(new zzuz(this.zzcgv));
                }
                if (this.zzboa != null) {
                    this.zzbut.zza(new zzvt(this.zzboa));
                }
                if (this.zzcjv != null) {
                    this.zzbut.zza(new zzabz(this.zzcjv));
                }
                if (this.zzbnr != null) {
                    this.zzbut.zza(new zzaak(this.zzbnr));
                }
                this.zzbut.zza(new zzaab(this.zzcjy));
                this.zzbut.setManualImpressionsEnabled(this.zzbny);
                try {
                    IObjectWrapper iObjectWrapperZzke = this.zzbut.zzke();
                    if (iObjectWrapperZzke != null) {
                        this.zzcjw.addView((View) ObjectWrapper.unwrap(iObjectWrapperZzke));
                    }
                } catch (RemoteException e2) {
                    zzbbq.zze("#007 Could not call remote method.", e2);
                }
            }
            if (this.zzbut.zza(zzvl.zza(this.zzcjw.getContext(), zzywVar))) {
                this.zzbuw.zzf(zzywVar.zzqq());
            }
        } catch (RemoteException e3) {
            zzbbq.zze("#007 Could not call remote method.", e3);
        }
    }

    public final zzyo zzdv() {
        zzxc zzxcVar = this.zzbut;
        if (zzxcVar == null) {
            return null;
        }
        try {
            return zzxcVar.getVideoController();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    public zzyy(ViewGroup viewGroup, int i) {
        this(viewGroup, null, false, zzvl.zzchs, i);
    }

    public zzyy(ViewGroup viewGroup, AttributeSet attributeSet, boolean z) {
        this(viewGroup, attributeSet, z, zzvl.zzchs, 0);
    }

    public zzyy(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, int i) {
        this(viewGroup, attributeSet, false, zzvl.zzchs, i);
    }

    @VisibleForTesting
    private zzyy(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzvl zzvlVar, zzxc zzxcVar, int i) {
        zzvn zzvnVarZzpn;
        this.zzbuw = new zzanc();
        this.zzcjt = new VideoController();
        this.zzcju = new zzzb(this);
        this.zzcjw = viewGroup;
        this.zzacs = zzvlVar;
        this.zzbut = null;
        this.zzcjs = new AtomicBoolean(false);
        this.zzcjx = i;
        if (attributeSet != null) {
            Context context = viewGroup.getContext();
            try {
                zzvu zzvuVar = new zzvu(context, attributeSet);
                this.zzcif = zzvuVar.zzy(z);
                this.zzbuu = zzvuVar.getAdUnitId();
                if (viewGroup.isInEditMode()) {
                    zzbbg zzbbgVarZzpt = zzwm.zzpt();
                    AdSize adSize = this.zzcif[0];
                    int i2 = this.zzcjx;
                    if (adSize.equals(AdSize.INVALID)) {
                        zzvnVarZzpn = zzvn.zzpn();
                    } else {
                        zzvn zzvnVar = new zzvn(context, adSize);
                        zzvnVar.zzchw = zzcz(i2);
                        zzvnVarZzpn = zzvnVar;
                    }
                    zzbbgVarZzpt.zza(viewGroup, zzvnVarZzpn, "Ads by Google");
                }
            } catch (IllegalArgumentException e2) {
                zzwm.zzpt().zza(viewGroup, new zzvn(context, AdSize.BANNER), e2.getMessage(), e2.getMessage());
            }
        }
    }

    @VisibleForTesting
    private zzyy(ViewGroup viewGroup, AttributeSet attributeSet, boolean z, zzvl zzvlVar, int i) {
        this(viewGroup, attributeSet, z, zzvlVar, null, i);
    }

    public final void zza(zzux zzuxVar) {
        try {
            this.zzcgv = zzuxVar;
            if (this.zzbut != null) {
                this.zzbut.zza(zzuxVar != null ? new zzuz(zzuxVar) : null);
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void zza(AdSize... adSizeArr) {
        this.zzcif = adSizeArr;
        try {
            if (this.zzbut != null) {
                this.zzbut.zza(zza(this.zzcjw.getContext(), this.zzcif, this.zzcjx));
            }
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
        this.zzcjw.requestLayout();
    }

    public final boolean zza(zzxc zzxcVar) {
        if (zzxcVar == null) {
            return false;
        }
        try {
            IObjectWrapper iObjectWrapperZzke = zzxcVar.zzke();
            if (iObjectWrapperZzke == null || ((View) ObjectWrapper.unwrap(iObjectWrapperZzke)).getParent() != null) {
                return false;
            }
            this.zzcjw.addView((View) ObjectWrapper.unwrap(iObjectWrapperZzke));
            this.zzbut = zzxcVar;
            return true;
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            return false;
        }
    }

    private static zzvn zza(Context context, AdSize[] adSizeArr, int i) {
        for (AdSize adSize : adSizeArr) {
            if (adSize.equals(AdSize.INVALID)) {
                return zzvn.zzpn();
            }
        }
        zzvn zzvnVar = new zzvn(context, adSizeArr);
        zzvnVar.zzchw = zzcz(i);
        return zzvnVar;
    }
}
