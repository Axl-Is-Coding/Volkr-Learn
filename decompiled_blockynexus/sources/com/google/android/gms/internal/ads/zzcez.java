package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
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
public final class zzcez extends zzaeo implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcgc {
    private final WeakReference<View> zzgas;
    private final Map<String, WeakReference<View>> zzgat = new HashMap();
    private final Map<String, WeakReference<View>> zzgau = new HashMap();
    private final Map<String, WeakReference<View>> zzgav = new HashMap();
    private zzcdx zzgaw;
    private zzqq zzgax;

    public zzcez(View view, HashMap<String, View> map, HashMap<String, View> map2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        com.google.android.gms.ads.internal.zzp.zzlo();
        zzbco.zza(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        com.google.android.gms.ads.internal.zzp.zzlo();
        zzbco.zza(view, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzgas = new WeakReference<>(view);
        for (Map.Entry<String, View> entry : map.entrySet()) {
            String key = entry.getKey();
            View value = entry.getValue();
            if (value != null) {
                this.zzgat.put(key, new WeakReference<>(value));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(key)) {
                    value.setOnTouchListener(this);
                    value.setClickable(true);
                    value.setOnClickListener(this);
                }
            }
        }
        this.zzgav.putAll(this.zzgat);
        for (Map.Entry<String, View> entry2 : map2.entrySet()) {
            View value2 = entry2.getValue();
            if (value2 != null) {
                this.zzgau.put(entry2.getKey(), new WeakReference<>(value2));
                value2.setOnTouchListener(this);
                value2.setClickable(false);
            }
        }
        this.zzgav.putAll(this.zzgau);
        this.zzgax = new zzqq(view.getContext(), view);
    }

    @Override // android.view.View.OnClickListener
    public final synchronized void onClick(View view) {
        if (this.zzgaw != null) {
            this.zzgaw.zza(view, zzahx(), zzanc(), zzand(), true);
        }
    }

    @Override // android.view.ViewTreeObserver.OnGlobalLayoutListener
    public final synchronized void onGlobalLayout() {
        if (this.zzgaw != null) {
            this.zzgaw.zzb(zzahx(), zzanc(), zzand(), zzcdx.zzz(zzahx()));
        }
    }

    @Override // android.view.ViewTreeObserver.OnScrollChangedListener
    public final synchronized void onScrollChanged() {
        if (this.zzgaw != null) {
            this.zzgaw.zzb(zzahx(), zzanc(), zzand(), zzcdx.zzz(zzahx()));
        }
    }

    @Override // android.view.View.OnTouchListener
    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzgaw != null) {
            this.zzgaw.zza(view, motionEvent, zzahx());
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzael
    public final synchronized void unregisterNativeAd() {
        if (this.zzgaw != null) {
            this.zzgaw.zzb(this);
            this.zzgaw = null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzael
    public final synchronized void zza(IObjectWrapper iObjectWrapper) {
        Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(objUnwrap instanceof zzcdx)) {
            zzbbq.zzfe("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        if (this.zzgaw != null) {
            this.zzgaw.zzb(this);
        }
        if (!((zzcdx) objUnwrap).zzalv()) {
            zzbbq.zzfc("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
            return;
        }
        this.zzgaw = (zzcdx) objUnwrap;
        this.zzgaw.zza(this);
        this.zzgaw.zzaa(zzahx());
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final View zzahx() {
        return this.zzgas.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final FrameLayout zzana() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final zzqq zzanb() {
        return this.zzgax;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final synchronized Map<String, WeakReference<View>> zzanc() {
        return this.zzgav;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final synchronized Map<String, WeakReference<View>> zzand() {
        return this.zzgat;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final synchronized Map<String, WeakReference<View>> zzane() {
        return this.zzgau;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final synchronized String zzanf() {
        return NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final synchronized IObjectWrapper zzang() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzael
    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        if (this.zzgaw != null) {
            Object objUnwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(objUnwrap instanceof View)) {
                zzbbq.zzfe("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.zzgaw.setClickConfirmingView((View) objUnwrap);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final synchronized View zzgf(String str) {
        WeakReference<View> weakReference = this.zzgav.get(str);
        if (weakReference == null) {
            return null;
        }
        return weakReference.get();
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final synchronized JSONObject zzsi() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzcgc
    public final synchronized void zza(String str, View view, boolean z) {
        if (view == null) {
            this.zzgav.remove(str);
            this.zzgat.remove(str);
            this.zzgau.remove(str);
            return;
        }
        this.zzgav.put(str, new WeakReference<>(view));
        if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
            this.zzgat.put(str, new WeakReference<>(view));
            view.setClickable(true);
            view.setOnClickListener(this);
            view.setOnTouchListener(this);
        }
    }
}
