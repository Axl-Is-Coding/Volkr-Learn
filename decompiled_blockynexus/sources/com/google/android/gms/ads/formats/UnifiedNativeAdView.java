package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.google.android.gms.ads.MediaContent;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzadp;
import com.google.android.gms.internal.ads.zzadr;
import com.google.android.gms.internal.ads.zzadz;
import com.google.android.gms.internal.ads.zzaei;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzwm;
import com.google.android.gms.internal.ads.zzzm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class UnifiedNativeAdView extends FrameLayout {
    private final FrameLayout zzbnw;
    private final zzaei zzbnx;

    public UnifiedNativeAdView(Context context) {
        super(context);
        this.zzbnw = zzd(context);
        this.zzbnx = zzju();
    }

    private final void zza(String str, View view) {
        try {
            this.zzbnx.zzb(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e2) {
            zzbbq.zzc("Unable to call setAssetView on delegate", e2);
        }
    }

    private final View zzbn(String str) {
        try {
            IObjectWrapper iObjectWrapperZzcs = this.zzbnx.zzcs(str);
            if (iObjectWrapperZzcs != null) {
                return (View) ObjectWrapper.unwrap(iObjectWrapperZzcs);
            }
            return null;
        } catch (RemoteException e2) {
            zzbbq.zzc("Unable to call getAssetView on delegate", e2);
            return null;
        }
    }

    private final FrameLayout zzd(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzaei zzju() {
        Preconditions.checkNotNull(this.zzbnw, "createDelegate must be called after overlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzwm.zzpu().zza(this.zzbnw.getContext(), this, this.zzbnw);
    }

    @Override // android.view.ViewGroup
    public final void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzbnw);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public final void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zzbnw;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public final void destroy() {
        try {
            this.zzbnx.destroy();
        } catch (RemoteException e2) {
            zzbbq.zzc("Unable to destroy native ad view", e2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public final boolean dispatchTouchEvent(MotionEvent motionEvent) {
        zzaei zzaeiVar;
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcrm)).booleanValue() && (zzaeiVar = this.zzbnx) != null) {
            try {
                zzaeiVar.zzf(ObjectWrapper.wrap(motionEvent));
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to call handleTouchEvent on delegate", e2);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public final AdChoicesView getAdChoicesView() {
        View viewZzbn = zzbn(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (viewZzbn instanceof AdChoicesView) {
            return (AdChoicesView) viewZzbn;
        }
        return null;
    }

    public final View getAdvertiserView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_ADVERTISER);
    }

    public final View getBodyView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_BODY);
    }

    public final View getCallToActionView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION);
    }

    public final View getHeadlineView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_HEADLINE);
    }

    public final View getIconView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_ICON);
    }

    public final View getImageView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_IMAGE);
    }

    public final MediaView getMediaView() {
        View viewZzbn = zzbn(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO);
        if (viewZzbn instanceof MediaView) {
            return (MediaView) viewZzbn;
        }
        if (viewZzbn == null) {
            return null;
        }
        zzbbq.zzef("View is not an instance of MediaView");
        return null;
    }

    public final View getPriceView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_PRICE);
    }

    public final View getStarRatingView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_STAR_RATING);
    }

    public final View getStoreView() {
        return zzbn(UnifiedNativeAdAssetNames.ASSET_STORE);
    }

    @Override // android.view.View
    public final void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzaei zzaeiVar = this.zzbnx;
        if (zzaeiVar != null) {
            try {
                zzaeiVar.zzc(ObjectWrapper.wrap(view), i);
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to call onVisibilityChanged on delegate", e2);
            }
        }
    }

    @Override // android.view.ViewGroup
    public final void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzbnw);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public final void removeView(View view) {
        if (this.zzbnw == view) {
            return;
        }
        super.removeView(view);
    }

    public final void setAdChoicesView(AdChoicesView adChoicesView) {
        zza(UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public final void setAdvertiserView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_ADVERTISER, view);
    }

    public final void setBodyView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_BODY, view);
    }

    public final void setCallToActionView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_CALL_TO_ACTION, view);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzbnx.zze(ObjectWrapper.wrap(view));
        } catch (RemoteException e2) {
            zzbbq.zzc("Unable to call setClickConfirmingView on delegate", e2);
        }
    }

    public final void setHeadlineView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_HEADLINE, view);
    }

    public final void setIconView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_ICON, view);
    }

    public final void setImageView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_IMAGE, view);
    }

    public final void setMediaView(MediaView mediaView) {
        zza(UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO, mediaView);
        if (mediaView != null) {
            mediaView.zza(new zzadp(this) { // from class: com.google.android.gms.ads.formats.zzd
                private final UnifiedNativeAdView zzbod;

                {
                    this.zzbod = this;
                }

                @Override // com.google.android.gms.internal.ads.zzadp
                public final void setMediaContent(MediaContent mediaContent) {
                    this.zzbod.zza(mediaContent);
                }
            });
            mediaView.zza(new zzadr(this) { // from class: com.google.android.gms.ads.formats.zze
                private final UnifiedNativeAdView zzbod;

                {
                    this.zzbod = this;
                }

                @Override // com.google.android.gms.internal.ads.zzadr
                public final void setImageScaleType(ImageView.ScaleType scaleType) {
                    this.zzbod.zza(scaleType);
                }
            });
        }
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        try {
            this.zzbnx.zza((IObjectWrapper) unifiedNativeAd.zzjs());
        } catch (RemoteException e2) {
            zzbbq.zzc("Unable to call setNativeAd on delegate", e2);
        }
    }

    public final void setPriceView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_PRICE, view);
    }

    public final void setStarRatingView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_STAR_RATING, view);
    }

    public final void setStoreView(View view) {
        zza(UnifiedNativeAdAssetNames.ASSET_STORE, view);
    }

    final /* synthetic */ void zza(ImageView.ScaleType scaleType) {
        if (scaleType != null) {
            try {
                this.zzbnx.zzg(ObjectWrapper.wrap(scaleType));
            } catch (RemoteException e2) {
                zzbbq.zzc("Unable to call setMediaViewImageScaleType on delegate", e2);
            }
        }
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzbnw = zzd(context);
        this.zzbnx = zzju();
    }

    final /* synthetic */ void zza(MediaContent mediaContent) {
        try {
            if (mediaContent instanceof zzzm) {
                this.zzbnx.zza(((zzzm) mediaContent).zzqx());
            } else if (mediaContent == null) {
                this.zzbnx.zza((zzadz) null);
            } else {
                zzbbq.zzef("Use MediaContent provided by UnifiedNativeAd.getMediaContent");
            }
        } catch (RemoteException e2) {
            zzbbq.zzc("Unable to call setMediaContent on delegate", e2);
        }
    }

    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzbnw = zzd(context);
        this.zzbnx = zzju();
    }

    @TargetApi(21)
    public UnifiedNativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzbnw = zzd(context);
        this.zzbnx = zzju();
    }
}
