package com.google.android.gms.internal.ads;

import android.graphics.drawable.Drawable;
import android.os.RemoteException;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzzm implements MediaContent {
    private final VideoController zzcjt = new VideoController();
    private final zzadz zzckt;

    public zzzm(zzadz zzadzVar) {
        this.zzckt = zzadzVar;
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getAspectRatio() {
        try {
            return this.zzckt.getAspectRatio();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return WheelView.DividerConfig.FILL;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getCurrentTime() {
        try {
            return this.zzckt.getCurrentTime();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return WheelView.DividerConfig.FILL;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final float getDuration() {
        try {
            return this.zzckt.getDuration();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return WheelView.DividerConfig.FILL;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final Drawable getMainImage() {
        try {
            IObjectWrapper iObjectWrapperZzsj = this.zzckt.zzsj();
            if (iObjectWrapperZzsj != null) {
                return (Drawable) ObjectWrapper.unwrap(iObjectWrapperZzsj);
            }
            return null;
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final VideoController getVideoController() {
        try {
            if (this.zzckt.getVideoController() != null) {
                this.zzcjt.zza(this.zzckt.getVideoController());
            }
        } catch (RemoteException e2) {
            zzbbq.zzc("Exception occurred while getting video controller", e2);
        }
        return this.zzcjt;
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final boolean hasVideoContent() {
        try {
            return this.zzckt.hasVideoContent();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return false;
        }
    }

    @Override // com.google.android.gms.ads.MediaContent
    public final void setMainImage(Drawable drawable) {
        try {
            this.zzckt.zzo(ObjectWrapper.wrap(drawable));
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    public final zzadz zzqx() {
        return this.zzckt;
    }
}
