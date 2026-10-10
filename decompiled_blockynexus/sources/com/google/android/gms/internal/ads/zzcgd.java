package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcgd implements zzceq {
    private final zzbbx zzbpe;
    private final zzdnv zzeot;
    private final zzdok zzfsk;
    private final zzbuu zzfxv;
    private final zzbuc zzfxw;
    private boolean zzfya = false;
    private boolean zzfyd = false;
    private final zzano zzgcm;
    private final zzanp zzgcn;
    private final zzanu zzgco;
    private final Context zzvr;

    public zzcgd(zzano zzanoVar, zzanp zzanpVar, zzanu zzanuVar, zzbuu zzbuuVar, zzbuc zzbucVar, Context context, zzdnv zzdnvVar, zzbbx zzbbxVar, zzdok zzdokVar) {
        this.zzgcm = zzanoVar;
        this.zzgcn = zzanpVar;
        this.zzgco = zzanuVar;
        this.zzfxv = zzbuuVar;
        this.zzfxw = zzbucVar;
        this.zzvr = context;
        this.zzeot = zzdnvVar;
        this.zzbpe = zzbbxVar;
        this.zzfsk = zzdokVar;
    }

    private final void zzad(View view) {
        try {
            if (this.zzgco != null && !this.zzgco.getOverrideClickHandling()) {
                this.zzgco.zzu(ObjectWrapper.wrap(view));
                this.zzfxw.onAdClicked();
            } else if (this.zzgcm != null && !this.zzgcm.getOverrideClickHandling()) {
                this.zzgcm.zzu(ObjectWrapper.wrap(view));
                this.zzfxw.onAdClicked();
            } else {
                if (this.zzgcn == null || this.zzgcn.getOverrideClickHandling()) {
                    return;
                }
                this.zzgcn.zzu(ObjectWrapper.wrap(view));
                this.zzfxw.onAdClicked();
            }
        } catch (RemoteException e2) {
            zzbbq.zzd("Failed to call handleClick", e2);
        }
    }

    private static HashMap<String, View> zzb(Map<String, WeakReference<View>> map) {
        HashMap<String, View> map2 = new HashMap<>();
        if (map == null) {
            return map2;
        }
        synchronized (map) {
            for (Map.Entry<String, WeakReference<View>> entry : map.entrySet()) {
                View view = entry.getValue().get();
                if (view != null) {
                    map2.put(entry.getKey(), view);
                }
            }
        }
        return map2;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void cancelUnconfirmedClick() {
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void destroy() {
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final boolean isCustomClickGestureEnabled() {
        return this.zzeot.zzdky;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void setClickConfirmingView(View view) {
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final JSONObject zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zza(View view, MotionEvent motionEvent, View view2) {
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        try {
            IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(view);
            HashMap<String, View> mapZzb = zzb(map);
            HashMap<String, View> mapZzb2 = zzb(map2);
            if (this.zzgco != null) {
                this.zzgco.zzc(iObjectWrapperWrap, ObjectWrapper.wrap(mapZzb), ObjectWrapper.wrap(mapZzb2));
                return;
            }
            if (this.zzgcm != null) {
                this.zzgcm.zzc(iObjectWrapperWrap, ObjectWrapper.wrap(mapZzb), ObjectWrapper.wrap(mapZzb2));
                this.zzgcm.zzv(iObjectWrapperWrap);
            } else if (this.zzgcn != null) {
                this.zzgcn.zzc(iObjectWrapperWrap, ObjectWrapper.wrap(mapZzb), ObjectWrapper.wrap(mapZzb2));
                this.zzgcn.zzv(iObjectWrapperWrap);
            }
        } catch (RemoteException e2) {
            zzbbq.zzd("Failed to call trackView", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zza(zzafz zzafzVar) {
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zzalp() {
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zzalq() {
        zzbbq.zzfe("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zzalr() {
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zzfz(String str) {
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zzg(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zzh(Bundle bundle) {
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final boolean zzi(Bundle bundle) {
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zzsv() {
        this.zzfyd = true;
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zzb(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        try {
            if (!this.zzfya && this.zzeot.zzhdw != null) {
                this.zzfya |= com.google.android.gms.ads.internal.zzp.zzlb().zzb(this.zzvr, this.zzbpe.zzbre, this.zzeot.zzhdw.toString(), this.zzfsk.zzhfb);
            }
            if (this.zzgco != null && !this.zzgco.getOverrideImpressionRecording()) {
                this.zzgco.recordImpression();
                this.zzfxv.onAdImpression();
            } else if (this.zzgcm != null && !this.zzgcm.getOverrideImpressionRecording()) {
                this.zzgcm.recordImpression();
                this.zzfxv.onAdImpression();
            } else {
                if (this.zzgcn == null || this.zzgcn.getOverrideImpressionRecording()) {
                    return;
                }
                this.zzgcn.recordImpression();
                this.zzfxv.onAdImpression();
            }
        } catch (RemoteException e2) {
            zzbbq.zzd("Failed to call recordImpression", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zza(View view, Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper iObjectWrapperWrap = ObjectWrapper.wrap(view);
            if (this.zzgco != null) {
                this.zzgco.zzw(iObjectWrapperWrap);
            } else if (this.zzgcm != null) {
                this.zzgcm.zzw(iObjectWrapperWrap);
            } else if (this.zzgcn != null) {
                this.zzgcn.zzw(iObjectWrapperWrap);
            }
        } catch (RemoteException e2) {
            zzbbq.zzd("Failed to call untrackView", e2);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (this.zzfyd && this.zzeot.zzdky) {
            return;
        }
        zzad(view);
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzfyd) {
            zzbbq.zzfe("Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.");
        } else if (!this.zzeot.zzdky) {
            zzbbq.zzfe("Custom click reporting for 3p ads failed. Ad unit id not whitelisted.");
        } else {
            zzad(view);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zza(zzyd zzydVar) {
        zzbbq.zzfe("Mute This Ad is not supported for 3rd party ads");
    }

    @Override // com.google.android.gms.internal.ads.zzceq
    public final void zza(zzxz zzxzVar) {
        zzbbq.zzfe("Mute This Ad is not supported for 3rd party ads");
    }
}
