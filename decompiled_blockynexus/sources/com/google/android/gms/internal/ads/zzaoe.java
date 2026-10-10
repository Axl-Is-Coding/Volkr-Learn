package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaoe extends zzann {
    private final NativeAppInstallAdMapper zzdlv;

    public zzaoe(NativeAppInstallAdMapper nativeAppInstallAdMapper) {
        this.zzdlv = nativeAppInstallAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final String getBody() {
        return this.zzdlv.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final String getCallToAction() {
        return this.zzdlv.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final Bundle getExtras() {
        return this.zzdlv.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final String getHeadline() {
        return this.zzdlv.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final List getImages() {
        List<NativeAd.Image> images = this.zzdlv.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new zzadq(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final boolean getOverrideClickHandling() {
        return this.zzdlv.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final boolean getOverrideImpressionRecording() {
        return this.zzdlv.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final String getPrice() {
        return this.zzdlv.getPrice();
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final double getStarRating() {
        return this.zzdlv.getStarRating();
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final String getStore() {
        return this.zzdlv.getStore();
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzyo getVideoController() {
        if (this.zzdlv.getVideoController() != null) {
            return this.zzdlv.getVideoController().zzdv();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void recordImpression() {
        this.zzdlv.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdlv.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzaee zzsl() {
        NativeAd.Image icon = this.zzdlv.getIcon();
        if (icon != null) {
            return new zzadq(icon.getDrawable(), icon.getUri(), icon.getScale(), icon.getWidth(), icon.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final zzadw zzsm() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final IObjectWrapper zzsn() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzdlv.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final IObjectWrapper zzue() {
        View adChoicesContent = this.zzdlv.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final IObjectWrapper zzuf() {
        View viewZzadh = this.zzdlv.zzadh();
        if (viewZzadh == null) {
            return null;
        }
        return ObjectWrapper.wrap(viewZzadh);
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdlv.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzano
    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdlv.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
