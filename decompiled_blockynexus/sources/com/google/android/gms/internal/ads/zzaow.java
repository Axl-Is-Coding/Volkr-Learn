package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaow extends zzant {
    private final UnifiedNativeAdMapper zzdmf;

    public zzaow(UnifiedNativeAdMapper unifiedNativeAdMapper) {
        this.zzdmf = unifiedNativeAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final String getAdvertiser() {
        return this.zzdmf.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final String getBody() {
        return this.zzdmf.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final String getCallToAction() {
        return this.zzdmf.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final Bundle getExtras() {
        return this.zzdmf.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final String getHeadline() {
        return this.zzdmf.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final List getImages() {
        List<NativeAd.Image> images = this.zzdmf.getImages();
        ArrayList arrayList = new ArrayList();
        if (images != null) {
            for (NativeAd.Image image : images) {
                arrayList.add(new zzadq(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
            }
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final float getMediaContentAspectRatio() {
        return this.zzdmf.getMediaContentAspectRatio();
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final boolean getOverrideClickHandling() {
        return this.zzdmf.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final boolean getOverrideImpressionRecording() {
        return this.zzdmf.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final String getPrice() {
        return this.zzdmf.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final double getStarRating() {
        if (this.zzdmf.getStarRating() != null) {
            return this.zzdmf.getStarRating().doubleValue();
        }
        return -1.0d;
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final String getStore() {
        return this.zzdmf.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final zzyo getVideoController() {
        if (this.zzdmf.getVideoController() != null) {
            return this.zzdmf.getVideoController().zzdv();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final float getVideoCurrentTime() {
        return this.zzdmf.getCurrentTime();
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final float getVideoDuration() {
        return this.zzdmf.getDuration();
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final void recordImpression() {
        this.zzdmf.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdmf.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final zzaee zzsl() {
        NativeAd.Image icon = this.zzdmf.getIcon();
        if (icon != null) {
            return new zzadq(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final zzadw zzsm() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final IObjectWrapper zzsn() {
        Object objZzjx = this.zzdmf.zzjx();
        if (objZzjx == null) {
            return null;
        }
        return ObjectWrapper.wrap(objZzjx);
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzdmf.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final IObjectWrapper zzue() {
        View adChoicesContent = this.zzdmf.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final IObjectWrapper zzuf() {
        View viewZzadh = this.zzdmf.zzadh();
        if (viewZzadh == null) {
            return null;
        }
        return ObjectWrapper.wrap(viewZzadh);
    }

    @Override // com.google.android.gms.internal.ads.zzanu
    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdmf.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
