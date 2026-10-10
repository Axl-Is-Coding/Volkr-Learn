package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.VideoController;
import com.google.android.gms.ads.formats.MediaView;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzafb implements NativeCustomTemplateAd {
    private final VideoController zzcjt = new VideoController();
    private final zzafa zzddy;
    private final MediaView zzddz;
    private NativeCustomTemplateAd.DisplayOpenMeasurement zzdea;

    @VisibleForTesting
    public zzafb(zzafa zzafaVar) {
        Context context;
        this.zzddy = zzafaVar;
        MediaView mediaView = null;
        try {
            context = (Context) ObjectWrapper.unwrap(zzafaVar.zzsp());
        } catch (RemoteException | NullPointerException e2) {
            zzbbq.zzc("", e2);
            context = null;
        }
        if (context != null) {
            MediaView mediaView2 = new MediaView(context);
            try {
                if (this.zzddy.zzp(ObjectWrapper.wrap(mediaView2))) {
                    mediaView = mediaView2;
                }
            } catch (RemoteException e3) {
                zzbbq.zzc("", e3);
            }
        }
        this.zzddz = mediaView;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void destroy() {
        try {
            this.zzddy.destroy();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final List<String> getAvailableAssetNames() {
        try {
            return this.zzddy.getAvailableAssetNames();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final String getCustomTemplateId() {
        try {
            return this.zzddy.getCustomTemplateId();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final NativeCustomTemplateAd.DisplayOpenMeasurement getDisplayOpenMeasurement() {
        try {
            if (this.zzdea == null && this.zzddy.zzsq()) {
                this.zzdea = new zzaea(this.zzddy);
            }
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
        return this.zzdea;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final NativeAd.Image getImage(String str) {
        try {
            zzaee zzaeeVarZzcy = this.zzddy.zzcy(str);
            if (zzaeeVarZzcy != null) {
                return new zzaef(zzaeeVarZzcy);
            }
            return null;
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final CharSequence getText(String str) {
        try {
            return this.zzddy.zzcx(str);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
            return null;
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final VideoController getVideoController() {
        try {
            zzyo videoController = this.zzddy.getVideoController();
            if (videoController != null) {
                this.zzcjt.zza(videoController);
            }
        } catch (RemoteException e2) {
            zzbbq.zzc("Exception occurred while getting video controller", e2);
        }
        return this.zzcjt;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final MediaView getVideoMediaView() {
        return this.zzddz;
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void performClick(String str) {
        try {
            this.zzddy.performClick(str);
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    @Override // com.google.android.gms.ads.formats.NativeCustomTemplateAd
    public final void recordImpression() {
        try {
            this.zzddy.recordImpression();
        } catch (RemoteException e2) {
            zzbbq.zzc("", e2);
        }
    }

    public final zzafa zzst() {
        return this.zzddy;
    }
}
