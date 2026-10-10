package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.View;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaod extends zzans {
    private final NativeContentAdMapper zzdlu;

    public zzaod(NativeContentAdMapper nativeContentAdMapper) {
        this.zzdlu = nativeContentAdMapper;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final String getAdvertiser() {
        return this.zzdlu.getAdvertiser();
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final String getBody() {
        return this.zzdlu.getBody();
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final String getCallToAction() {
        return this.zzdlu.getCallToAction();
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final Bundle getExtras() {
        return this.zzdlu.getExtras();
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final String getHeadline() {
        return this.zzdlu.getHeadline();
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final List getImages() {
        List<NativeAd.Image> images = this.zzdlu.getImages();
        if (images == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (NativeAd.Image image : images) {
            arrayList.add(new zzadq(image.getDrawable(), image.getUri(), image.getScale(), image.getWidth(), image.getHeight()));
        }
        return arrayList;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final boolean getOverrideClickHandling() {
        return this.zzdlu.getOverrideClickHandling();
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final boolean getOverrideImpressionRecording() {
        return this.zzdlu.getOverrideImpressionRecording();
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final zzyo getVideoController() {
        if (this.zzdlu.getVideoController() != null) {
            return this.zzdlu.getVideoController().zzdv();
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final void recordImpression() {
        this.zzdlu.recordImpression();
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3) {
        this.zzdlu.trackViews((View) ObjectWrapper.unwrap(iObjectWrapper), (HashMap) ObjectWrapper.unwrap(iObjectWrapper2), (HashMap) ObjectWrapper.unwrap(iObjectWrapper3));
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final zzadw zzsm() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final IObjectWrapper zzsn() {
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final zzaee zzso() {
        NativeAd.Image logo = this.zzdlu.getLogo();
        if (logo != null) {
            return new zzadq(logo.getDrawable(), logo.getUri(), logo.getScale(), logo.getWidth(), logo.getHeight());
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final void zzu(IObjectWrapper iObjectWrapper) {
        this.zzdlu.handleClick((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final IObjectWrapper zzue() {
        View adChoicesContent = this.zzdlu.getAdChoicesContent();
        if (adChoicesContent == null) {
            return null;
        }
        return ObjectWrapper.wrap(adChoicesContent);
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final IObjectWrapper zzuf() {
        View viewZzadh = this.zzdlu.zzadh();
        if (viewZzadh == null) {
            return null;
        }
        return ObjectWrapper.wrap(viewZzadh);
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final void zzv(IObjectWrapper iObjectWrapper) {
        this.zzdlu.trackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    @Override // com.google.android.gms.internal.ads.zzanp
    public final void zzw(IObjectWrapper iObjectWrapper) {
        this.zzdlu.untrackView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
