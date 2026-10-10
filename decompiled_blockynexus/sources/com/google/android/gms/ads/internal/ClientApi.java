package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzs;
import com.google.android.gms.ads.internal.overlay.zzt;
import com.google.android.gms.ads.internal.overlay.zzy;
import com.google.android.gms.ads.internal.overlay.zzz;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzaei;
import com.google.android.gms.internal.ads.zzael;
import com.google.android.gms.internal.ads.zzanb;
import com.google.android.gms.internal.ads.zzaqp;
import com.google.android.gms.internal.ads.zzaqy;
import com.google.android.gms.internal.ads.zzarn;
import com.google.android.gms.internal.ads.zzaud;
import com.google.android.gms.internal.ads.zzauy;
import com.google.android.gms.internal.ads.zzaxl;
import com.google.android.gms.internal.ads.zzbbx;
import com.google.android.gms.internal.ads.zzbix;
import com.google.android.gms.internal.ads.zzcez;
import com.google.android.gms.internal.ads.zzcfc;
import com.google.android.gms.internal.ads.zzczh;
import com.google.android.gms.internal.ads.zzczj;
import com.google.android.gms.internal.ads.zzczu;
import com.google.android.gms.internal.ads.zzdju;
import com.google.android.gms.internal.ads.zzvn;
import com.google.android.gms.internal.ads.zzwm;
import com.google.android.gms.internal.ads.zzwz;
import com.google.android.gms.internal.ads.zzxc;
import com.google.android.gms.internal.ads.zzxo;
import com.google.android.gms.internal.ads.zzxs;
import java.util.HashMap;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public class ClientApi extends zzxo {
    @KeepForSdk
    public ClientApi() {
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxc zza(IObjectWrapper iObjectWrapper, zzvn zzvnVar, String str, zzanb zzanbVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzczj(zzbix.zza(context, zzanbVar, i), context, zzvnVar, str);
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxc zzb(IObjectWrapper iObjectWrapper, zzvn zzvnVar, String str, zzanb zzanbVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzczu(zzbix.zza(context, zzanbVar, i), context, zzvnVar, str);
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxc zzc(IObjectWrapper iObjectWrapper, zzvn zzvnVar, String str, zzanb zzanbVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        zzdju zzdjuVarZzafu = zzbix.zza(context, zzanbVar, i).zzads().zzfv(str).zzby(context).zzafu();
        return i >= ((Integer) zzwm.zzpx().zzd(zzabb.zzcul)).intValue() ? zzdjuVarZzafu.zzafy() : zzdjuVarZzafu.zzafx();
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxs zzc(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzarn zzd(IObjectWrapper iObjectWrapper) {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzwz zza(IObjectWrapper iObjectWrapper, String str, zzanb zzanbVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return new zzczh(zzbix.zza(context, zzanbVar, i), context, str);
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaqy zzb(IObjectWrapper iObjectWrapper) {
        Activity activity = (Activity) ObjectWrapper.unwrap(iObjectWrapper);
        AdOverlayInfoParcel adOverlayInfoParcelZzd = AdOverlayInfoParcel.zzd(activity.getIntent());
        if (adOverlayInfoParcelZzd == null) {
            return new zzt(activity);
        }
        int i = adOverlayInfoParcelZzd.zzdpr;
        if (i == 1) {
            return new com.google.android.gms.ads.internal.overlay.zzq(activity);
        }
        if (i == 2) {
            return new zzz(activity);
        }
        if (i == 3) {
            return new zzy(activity);
        }
        if (i != 4) {
            return new zzt(activity);
        }
        return new zzs(activity, adOverlayInfoParcelZzd);
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaei zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2) {
        return new zzcfc((FrameLayout) ObjectWrapper.unwrap(iObjectWrapper), (FrameLayout) ObjectWrapper.unwrap(iObjectWrapper2), 202510000);
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaud zza(IObjectWrapper iObjectWrapper, zzanb zzanbVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbix.zza(context, zzanbVar, i).zzadw().zzbz(context).zzagi().zzagm();
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaqp zzc(IObjectWrapper iObjectWrapper, zzanb zzanbVar, int i) {
        return zzbix.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzanbVar, i).zzadz();
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzauy zzb(IObjectWrapper iObjectWrapper, String str, zzanb zzanbVar, int i) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        return zzbix.zza(context, zzanbVar, i).zzadw().zzbz(context).zzfw(str).zzagi().zzagn();
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxs zza(IObjectWrapper iObjectWrapper, int i) {
        return zzbix.zzf((Context) ObjectWrapper.unwrap(iObjectWrapper), i).zzado();
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzxc zza(IObjectWrapper iObjectWrapper, zzvn zzvnVar, String str, int i) {
        return new zzj((Context) ObjectWrapper.unwrap(iObjectWrapper), zzvnVar, str, new zzbbx(202510000, i, true, false));
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzaxl zzb(IObjectWrapper iObjectWrapper, zzanb zzanbVar, int i) {
        return zzbix.zza((Context) ObjectWrapper.unwrap(iObjectWrapper), zzanbVar, i).zzady();
    }

    @Override // com.google.android.gms.internal.ads.zzxp
    public final zzael zza(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        return new zzcez((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }
}
