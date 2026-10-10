package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcfc extends zzaeh implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcgc {
    public static final String[] zzgba = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO, UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO};
    private FrameLayout zzbnw;
    private zzadz zzckt;
    private final int zzeem;
    private zzcdx zzgaw;
    private zzqq zzgax;
    private final String zzgaz;
    private FrameLayout zzgbb;
    private zzdzb zzgbc;
    private View zzgbd;
    private boolean zzgbf;
    private Map<String, WeakReference<View>> zzdqc = new HashMap();
    private IObjectWrapper zzgbe = null;
    private boolean zzepb = false;

    public zzcfc(FrameLayout frameLayout, FrameLayout frameLayout2, int i) {
        String str;
        this.zzgbb = frameLayout;
        this.zzbnw = frameLayout2;
        this.zzeem = i;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = NativeAppInstallAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.zzgaz = str;
        com.google.android.gms.ads.internal.zzp.zzlo();
        zzbco.zza((View) frameLayout, (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.zzp.zzlo();
        zzbco.zza((View) frameLayout, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzgbc = zzbbz.zzeet;
        this.zzgax = new zzqq(this.zzgbb.getContext(), this.zzgbb);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    private final synchronized void zzanh() {
        this.zzgbc.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcfb
            private final zzcfc zzgay;

            {
                this.zzgay = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgay.zzani();
            }
        });
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final synchronized void destroy() {
        if (this.zzepb) {
            return;
        }
        if (this.zzgaw != null) {
            this.zzgaw.zzb(this);
            this.zzgaw = null;
        }
        this.zzdqc.clear();
        this.zzgbb.removeAllViews();
        this.zzbnw.removeAllViews();
        this.zzdqc = null;
        this.zzgbb = null;
        this.zzbnw = null;
        this.zzgbd = null;
        this.zzgax = null;
        this.zzepb = true;
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        if (this.zzgaw != null) {
            this.zzgaw.cancelUnconfirmedClick();
            this.zzgaw.zza(view, this.zzgbb, zzanc(), zzand(), false);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        if (this.zzgaw != null) {
            this.zzgaw.zzb(this.zzgbb, zzanc(), zzand(), zzcdx.zzz(this.zzgbb));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        if (this.zzgaw != null) {
            this.zzgaw.zzb(this.zzgbb, zzanc(), zzand(), zzcdx.zzz(this.zzgbb));
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzgaw != null) {
            this.zzgaw.zza(view, motionEvent, this.zzgbb);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final synchronized void zza(String str, View view, boolean z) {
        if (this.zzepb) {
            return;
        }
        if (view == null) {
            this.zzdqc.remove(str);
            return;
        }
        this.zzdqc.put(str, new WeakReference<>(view));
        if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
            if (zzbau.zzdi(this.zzeem)) {
                view.setOnTouchListener(this);
            }
            view.setClickable(true);
            view.setOnClickListener(this);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final /* synthetic */ View zzahx() {
        return this.zzgbb;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final FrameLayout zzana() {
        return this.zzbnw;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final zzqq zzanb() {
        return this.zzgax;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final synchronized Map<String, WeakReference<View>> zzanc() {
        return this.zzdqc;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final synchronized Map<String, WeakReference<View>> zzand() {
        return this.zzdqc;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final synchronized Map<String, WeakReference<View>> zzane() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final synchronized String zzanf() {
        return this.zzgaz;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final IObjectWrapper zzang() {
        return this.zzgbe;
    }

    final /* synthetic */ void zzani() {
        if (this.zzgbd == null) {
            this.zzgbd = new View(this.zzgbb.getContext());
            this.zzgbd.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzgbb != this.zzgbd.getParent()) {
            this.zzgbb.addView(this.zzgbd);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final synchronized void zzb(String str, IObjectWrapper iObjectWrapper) {
        zza(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final synchronized void zzc(IObjectWrapper iObjectWrapper, int i) {
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final synchronized IObjectWrapper zzcs(String str) {
        return ObjectWrapper.wrap(zzgf(str));
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        this.zzgaw.setClickConfirmingView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final void zzf(IObjectWrapper iObjectWrapper) {
        onTouch(this.zzgbb, (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final synchronized void zzg(IObjectWrapper iObjectWrapper) {
        if (this.zzepb) {
            return;
        }
        this.zzgbe = iObjectWrapper;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final synchronized View zzgf(String str) {
        if (this.zzepb) {
            return null;
        }
        WeakReference<View> weakReference = this.zzdqc.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final synchronized JSONObject zzsi() {
        if (this.zzgaw == null) {
            return null;
        }
        return this.zzgaw.zza(this.zzgbb, zzanc(), zzand());
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final synchronized void zza(IObjectWrapper iObjectWrapper) {
        if (this.zzepb) {
            return;
        }
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof zzcdx)) {
            zzbbq.zzfe("Not an instance of native engine. This is most likely a transient error");
            return;
        }
        if (this.zzgaw != null) {
            this.zzgaw.zzb(this);
        }
        zzanh();
        this.zzgaw = (zzcdx) objUnwrap;
        this.zzgaw.zza(this);
        this.zzgaw.zzaa(this.zzgbb);
        this.zzgaw.zzab(this.zzbnw);
        if (this.zzgbf) {
            this.zzgaw.zzalx().zza(this.zzckt);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzaei
    public final synchronized void zza(zzadz zzadzVar) {
        if (this.zzepb) {
            return;
        }
        this.zzgbf = true;
        this.zzckt = zzadzVar;
        if (this.zzgaw != null) {
            this.zzgaw.zzalx().zza(zzadzVar);
        }
    }
}
