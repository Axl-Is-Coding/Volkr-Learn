package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcfu {
    private final zzcil zzgbo;
    private final zzcjt zzgbx;
    private ViewTreeObserver.OnScrollChangedListener zzgcc = null;

    public zzcfu(zzcjt zzcjtVar, zzcil zzcilVar) {
        this.zzgbx = zzcjtVar;
        this.zzgbo = zzcilVar;
    }

    public final View zza(final View view, final WindowManager windowManager) throws zzbgv {
        zzbgj zzbgjVarZzc = this.zzgbx.zzc(zzvn.zzpk());
        zzbgjVarZzc.getView().setVisibility(4);
        zzbgjVarZzc.getView().setContentDescription("policy_validator");
        zzbgjVarZzc.zza("/sendMessageToSdk", new zzahq(this) { // from class: com.google.android.gms.internal.ads.zzcft
            private final zzcfu zzgcb;

            {
                this.zzgcb = this;
            }

            @Override // com.google.android.gms.internal.ads.zzahq
            public final void zza(Object obj, Map map) {
                this.zzgcb.zze((zzbgj) obj, map);
            }
        });
        zzbgjVarZzc.zza("/hideValidatorOverlay", new zzahq(this, windowManager, view) { // from class: com.google.android.gms.internal.ads.zzcfw
            private final zzcfu zzgcb;
            private final WindowManager zzgcf;
            private final View zzgcg;

            {
                this.zzgcb = this;
                this.zzgcf = windowManager;
                this.zzgcg = view;
            }

            @Override // com.google.android.gms.internal.ads.zzahq
            public final void zza(Object obj, Map map) {
                this.zzgcb.zza(this.zzgcf, this.zzgcg, (zzbgj) obj, map);
            }
        });
        zzbgjVarZzc.zza("/open", new zzahu(null, null));
        this.zzgbo.zza(new WeakReference(zzbgjVarZzc), "/loadNativeAdPolicyViolations", new zzahq(this, view, windowManager) { // from class: com.google.android.gms.internal.ads.zzcfv
            private final zzcfu zzgcb;
            private final View zzgcd;
            private final WindowManager zzgce;

            {
                this.zzgcb = this;
                this.zzgcd = view;
                this.zzgce = windowManager;
            }

            @Override // com.google.android.gms.internal.ads.zzahq
            public final void zza(Object obj, Map map) {
                this.zzgcb.zza(this.zzgcd, this.zzgce, (zzbgj) obj, map);
            }
        });
        this.zzgbo.zza(new WeakReference(zzbgjVarZzc), "/showValidatorOverlay", zzcfy.zzdfl);
        return zzbgjVarZzc.getView();
    }

    final /* synthetic */ void zzb(Map map, boolean z) {
        HashMap map2 = new HashMap();
        map2.put("messageType", "validatorHtmlLoaded");
        map2.put("id", (String) map.get("id"));
        this.zzgbo.zza("sendMessageToNativeJs", map2);
    }

    final /* synthetic */ void zze(zzbgj zzbgjVar, Map map) {
        this.zzgbo.zza("sendMessageToNativeJs", (Map<String, ?>) map);
    }

    private static int zza(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        zzwm.zzpt();
        return zzbbg.zzc(context, i);
    }

    final /* synthetic */ void zza(final View view, final WindowManager windowManager, final zzbgj zzbgjVar, final Map map) {
        int i;
        zzbgjVar.zzabw().zza(new zzbhu(this, map) { // from class: com.google.android.gms.internal.ads.zzcga
            private final Map zzeei;
            private final zzcfu zzgcb;

            {
                this.zzgcb = this;
                this.zzeei = map;
            }

            @Override // com.google.android.gms.internal.ads.zzbhu
            public final void zzai(boolean z) {
                this.zzgcb.zzb(this.zzeei, z);
            }
        });
        if (map == null) {
            return;
        }
        Context context = view.getContext();
        int iZza = zza(context, (String) map.get("validator_width"), ((Integer) zzwm.zzpx().zzd(zzabb.zzcya)).intValue());
        int iZza2 = zza(context, (String) map.get("validator_height"), ((Integer) zzwm.zzpx().zzd(zzabb.zzcyb)).intValue());
        int iZza3 = zza(context, (String) map.get("validator_x"), 0);
        int iZza4 = zza(context, (String) map.get("validator_y"), 0);
        zzbgjVar.zza(zzbhy.zzq(iZza, iZza2));
        try {
            zzbgjVar.getWebView().getSettings().setUseWideViewPort(((Boolean) zzwm.zzpx().zzd(zzabb.zzcyc)).booleanValue());
            zzbgjVar.getWebView().getSettings().setLoadWithOverviewMode(((Boolean) zzwm.zzpx().zzd(zzabb.zzcyd)).booleanValue());
        } catch (NullPointerException unused) {
        }
        final WindowManager.LayoutParams layoutParamsZzyk = zzbau.zzyk();
        layoutParamsZzyk.x = iZza3;
        layoutParamsZzyk.y = iZza4;
        windowManager.updateViewLayout(zzbgjVar.getView(), layoutParamsZzyk);
        final String str = (String) map.get(AdUnitActivity.EXTRA_ORIENTATION);
        Rect rect = new Rect();
        if (view.getGlobalVisibleRect(rect)) {
            if (!"1".equals(str) && !"2".equals(str)) {
                i = rect.top;
            } else {
                i = rect.bottom;
            }
            final int i2 = i - iZza4;
            this.zzgcc = new ViewTreeObserver.OnScrollChangedListener(view, zzbgjVar, str, layoutParamsZzyk, i2, windowManager) { // from class: com.google.android.gms.internal.ads.zzcfx
                private final String zzdjk;
                private final View zzgch;
                private final zzbgj zzgci;
                private final WindowManager.LayoutParams zzgcj;
                private final int zzgck;
                private final WindowManager zzgcl;

                {
                    this.zzgch = view;
                    this.zzgci = zzbgjVar;
                    this.zzdjk = str;
                    this.zzgcj = layoutParamsZzyk;
                    this.zzgck = i2;
                    this.zzgcl = windowManager;
                }

                @Override // android.view.ViewTreeObserver.OnScrollChangedListener
                public final void onScrollChanged() {
                    View view2 = this.zzgch;
                    zzbgj zzbgjVar2 = this.zzgci;
                    String str2 = this.zzdjk;
                    WindowManager.LayoutParams layoutParams = this.zzgcj;
                    int i3 = this.zzgck;
                    WindowManager windowManager2 = this.zzgcl;
                    Rect rect2 = new Rect();
                    if (!view2.getGlobalVisibleRect(rect2) || zzbgjVar2.getView().getWindowToken() == null) {
                        return;
                    }
                    if ("1".equals(str2) || "2".equals(str2)) {
                        layoutParams.y = rect2.bottom - i3;
                    } else {
                        layoutParams.y = rect2.top - i3;
                    }
                    windowManager2.updateViewLayout(zzbgjVar2.getView(), layoutParams);
                }
            };
            ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
            if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                viewTreeObserver.addOnScrollChangedListener(this.zzgcc);
            }
        }
        String str2 = (String) map.get("overlay_url");
        if (TextUtils.isEmpty(str2)) {
            return;
        }
        zzbgjVar.loadUrl(str2);
    }

    final /* synthetic */ void zza(WindowManager windowManager, View view, zzbgj zzbgjVar, Map map) {
        zzbbq.zzef("Hide native ad policy validator overlay.");
        zzbgjVar.getView().setVisibility(8);
        if (zzbgjVar.getView().getWindowToken() != null) {
            windowManager.removeView(zzbgjVar.getView());
        }
        zzbgjVar.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzgcc == null || viewTreeObserver == null || !viewTreeObserver.isAlive()) {
            return;
        }
        viewTreeObserver.removeOnScrollChangedListener(this.zzgcc);
    }
}
