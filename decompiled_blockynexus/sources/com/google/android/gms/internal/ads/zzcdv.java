package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcdv extends zzaec {
    private final zzcei zzfxu;
    private IObjectWrapper zzfyr;

    public zzcdv(zzcei zzceiVar) {
        this.zzfxu = zzceiVar;
    }

    private final float zzalu() {
        try {
            return this.zzfxu.getVideoController().getAspectRatio();
        } catch (RemoteException e2) {
            zzbbq.zzc("Remote exception getting video controller aspect ratio.", e2);
            return WheelView.DividerConfig.FILL;
        }
    }

    private static float zzar(IObjectWrapper iObjectWrapper) {
        Drawable drawable;
        return (iObjectWrapper == null || (drawable = (Drawable) ObjectWrapper.unwrap(iObjectWrapper)) == null || drawable.getIntrinsicWidth() == -1 || drawable.getIntrinsicHeight() == -1) ? WheelView.DividerConfig.FILL : drawable.getIntrinsicWidth() / drawable.getIntrinsicHeight();
    }

    @Override // com.google.android.gms.internal.ads.zzadz
    public final float getAspectRatio() throws RemoteException {
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcwn)).booleanValue()) {
            return WheelView.DividerConfig.FILL;
        }
        if (this.zzfxu.getMediaContentAspectRatio() != WheelView.DividerConfig.FILL) {
            return this.zzfxu.getMediaContentAspectRatio();
        }
        if (this.zzfxu.getVideoController() != null) {
            return zzalu();
        }
        IObjectWrapper iObjectWrapper = this.zzfyr;
        if (iObjectWrapper != null) {
            return zzar(iObjectWrapper);
        }
        zzaee zzaeeVarZzamc = this.zzfxu.zzamc();
        if (zzaeeVarZzamc == null) {
            return WheelView.DividerConfig.FILL;
        }
        float width = (zzaeeVarZzamc == null || zzaeeVarZzamc.getWidth() == -1 || zzaeeVarZzamc.getHeight() == -1) ? WheelView.DividerConfig.FILL : zzaeeVarZzamc.getWidth() / zzaeeVarZzamc.getHeight();
        return width != WheelView.DividerConfig.FILL ? width : zzar(zzaeeVarZzamc.zzsg());
    }

    @Override // com.google.android.gms.internal.ads.zzadz
    public final float getCurrentTime() throws RemoteException {
        return (((Boolean) zzwm.zzpx().zzd(zzabb.zzcwo)).booleanValue() && this.zzfxu.getVideoController() != null) ? this.zzfxu.getVideoController().getCurrentTime() : WheelView.DividerConfig.FILL;
    }

    @Override // com.google.android.gms.internal.ads.zzadz
    public final float getDuration() throws RemoteException {
        return (((Boolean) zzwm.zzpx().zzd(zzabb.zzcwo)).booleanValue() && this.zzfxu.getVideoController() != null) ? this.zzfxu.getVideoController().getDuration() : WheelView.DividerConfig.FILL;
    }

    @Override // com.google.android.gms.internal.ads.zzadz
    public final zzyo getVideoController() throws RemoteException {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcwo)).booleanValue()) {
            return this.zzfxu.getVideoController();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzadz
    public final boolean hasVideoContent() throws RemoteException {
        return ((Boolean) zzwm.zzpx().zzd(zzabb.zzcwo)).booleanValue() && this.zzfxu.getVideoController() != null;
    }

    @Override // com.google.android.gms.internal.ads.zzadz
    public final void zza(zzafq zzafqVar) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcwo)).booleanValue() && (this.zzfxu.getVideoController() instanceof zzbhd)) {
            ((zzbhd) this.zzfxu.getVideoController()).zza(zzafqVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadz
    public final void zzo(IObjectWrapper iObjectWrapper) {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcsc)).booleanValue()) {
            this.zzfyr = iObjectWrapper;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzadz
    public final IObjectWrapper zzsj() throws RemoteException {
        IObjectWrapper iObjectWrapper = this.zzfyr;
        if (iObjectWrapper != null) {
            return iObjectWrapper;
        }
        zzaee zzaeeVarZzamc = this.zzfxu.zzamc();
        if (zzaeeVarZzamc == null) {
            return null;
        }
        return zzaeeVarZzamc.zzsg();
    }
}
