package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import cn.qqtheme.framework.widget.WheelView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.instream.InstreamAd;
import com.google.android.gms.ads.instream.InstreamAdView;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzajl extends InstreamAd {
    private final zzaje zzdgh;
    private VideoController zzcjt = zztd();
    private MediaContent zzbng = zzte();

    public zzajl(zzaje zzajeVar) {
        this.zzdgh = zzajeVar;
    }

    private final VideoController zztd() {
        VideoController videoController = new VideoController();
        try {
            videoController.zza(this.zzdgh.getVideoController());
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
        return videoController;
    }

    private final MediaContent zzte() {
        try {
            if (this.zzdgh.zzsw() != null) {
                return new zzzm(this.zzdgh.zzsw());
            }
            return null;
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.instream.InstreamAd
    public final void destroy() {
        try {
            this.zzdgh.destroy();
            this.zzcjt = null;
            this.zzbng = null;
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    @Override // com.google.android.gms.ads.instream.InstreamAd
    public final float getAspectRatio() {
        VideoController videoController = this.zzcjt;
        return videoController == null ? WheelView.DividerConfig.FILL : videoController.getAspectRatio();
    }

    @Override // com.google.android.gms.ads.instream.InstreamAd
    public final MediaContent getMediaContent() {
        return this.zzbng;
    }

    @Override // com.google.android.gms.ads.instream.InstreamAd
    public final VideoController getVideoController() {
        return this.zzcjt;
    }

    @Override // com.google.android.gms.ads.instream.InstreamAd
    public final float getVideoCurrentTime() {
        VideoController videoController = this.zzcjt;
        return videoController == null ? WheelView.DividerConfig.FILL : videoController.getVideoCurrentTime();
    }

    @Override // com.google.android.gms.ads.instream.InstreamAd
    public final float getVideoDuration() {
        VideoController videoController = this.zzcjt;
        return videoController == null ? WheelView.DividerConfig.FILL : videoController.getVideoDuration();
    }

    @Override // com.google.android.gms.ads.instream.InstreamAd
    public final void zza(InstreamAdView instreamAdView) {
        if (instreamAdView == null) {
            zzbbq.zzfc("showInView: parameter view must not be null.");
            return;
        }
        try {
            this.zzdgh.zzr(ObjectWrapper.wrap(instreamAdView));
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }
}
