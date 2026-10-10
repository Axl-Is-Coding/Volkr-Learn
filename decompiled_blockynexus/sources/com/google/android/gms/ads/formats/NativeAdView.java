package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabb;
import com.google.android.gms.internal.ads.zzaei;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzwm;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public class NativeAdView extends FrameLayout {
    private final FrameLayout zzbnw;
    private final zzaei zzbnx;

    public NativeAdView(Context context) {
        super(context);
        this.zzbnw = zzd(context);
        this.zzbnx = zzju();
    }

    private final FrameLayout zzd(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzaei zzju() {
        Preconditions.checkNotNull(this.zzbnw, "createDelegate must be called after mOverlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzwm.zzpu().zza(this.zzbnw.getContext(), this, this.zzbnw);
    }

    @Override // android.view.ViewGroup
    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzbnw);
    }

    @Override // android.view.ViewGroup, android.view.ViewParent
    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zzbnw;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public void destroy() {
        try {
            this.zzbnx.destroy();
        } catch (RemoteException e2) {
            zzbbq.zzc("Unable to destroy native ad view", e2);
        }
    }

    @Override // android.view.ViewGroup, android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
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

    public AdChoicesView getAdChoicesView() {
        View viewZzbn = zzbn(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (viewZzbn instanceof AdChoicesView) {
            return (AdChoicesView) viewZzbn;
        }
        return null;
    }

    @Override // android.view.View
    public void onVisibilityChanged(View view, int i) {
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
    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzbnw);
    }

    @Override // android.view.ViewGroup, android.view.ViewManager
    public void removeView(View view) {
        if (this.zzbnw == view) {
            return;
        }
        super.removeView(view);
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        zza(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.zzbnx.zza((IObjectWrapper) nativeAd.zzjs());
        } catch (RemoteException e2) {
            zzbbq.zzc("Unable to call setNativeAd on delegate", e2);
        }
    }

    protected final void zza(String str, View view) {
        try {
            this.zzbnx.zzb(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e2) {
            zzbbq.zzc("Unable to call setAssetView on delegate", e2);
        }
    }

    protected final View zzbn(String str) {
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

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzbnw = zzd(context);
        this.zzbnx = zzju();
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzbnw = zzd(context);
        this.zzbnx = zzju();
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzbnw = zzd(context);
        this.zzbnx = zzju();
    }
}
