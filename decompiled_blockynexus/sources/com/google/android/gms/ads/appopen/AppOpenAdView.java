package com.google.android.gms.ads.appopen;

import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzse;
import com.google.android.gms.internal.ads.zzvn;
import com.google.android.gms.internal.ads.zzxc;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
@Deprecated
public final class AppOpenAdView extends ViewGroup {
    private AppOpenAd zzady;
    private AppOpenAdPresentationCallback zzadz;

    public AppOpenAdView(Context context) {
        super(context);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    private final AdSize getAdSize() {
        zzxc zzxcVarZzdw = this.zzady.zzdw();
        if (zzxcVarZzdw == null) {
            return null;
        }
        try {
            zzvn zzvnVarZzkg = zzxcVarZzdw.zzkg();
            if (zzvnVarZzkg != null) {
                return zzvnVarZzkg.zzpo();
            }
            return null;
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
            return null;
        }
    }

    private final void zzdy() {
        AppOpenAdPresentationCallback appOpenAdPresentationCallback;
        AppOpenAd appOpenAd = this.zzady;
        if (appOpenAd == null || (appOpenAdPresentationCallback = this.zzadz) == null) {
            return;
        }
        appOpenAd.zza(new zzse(appOpenAdPresentationCallback));
    }

    @Override // android.view.ViewGroup, android.view.View
    protected final void onLayout(boolean z, int i, int i2, int i3, int i4) {
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            return;
        }
        int measuredWidth = childAt.getMeasuredWidth();
        int measuredHeight = childAt.getMeasuredHeight();
        int i5 = ((i3 - i) - measuredWidth) / 2;
        int i6 = ((i4 - i2) - measuredHeight) / 2;
        childAt.layout(i5, i6, measuredWidth + i5, measuredHeight + i6);
    }

    @Override // android.view.View
    protected final void onMeasure(int i, int i2) {
        int heightInPixels;
        int measuredWidth = 0;
        View childAt = getChildAt(0);
        if (childAt == null || childAt.getVisibility() == 8) {
            AdSize adSize = null;
            try {
                adSize = getAdSize();
            } catch (NullPointerException e2) {
                zzbbq.zzc("Unable to retrieve ad size.", e2);
            }
            if (adSize != null) {
                Context context = getContext();
                int widthInPixels = adSize.getWidthInPixels(context);
                heightInPixels = adSize.getHeightInPixels(context);
                measuredWidth = widthInPixels;
            } else {
                heightInPixels = 0;
            }
        } else {
            measureChild(childAt, i, i2);
            measuredWidth = childAt.getMeasuredWidth();
            heightInPixels = childAt.getMeasuredHeight();
        }
        setMeasuredDimension(View.resolveSize(Math.max(measuredWidth, getSuggestedMinimumWidth()), i), View.resolveSize(Math.max(heightInPixels, getSuggestedMinimumHeight()), i2));
    }

    public final void setAppOpenAd(AppOpenAd appOpenAd) {
        IObjectWrapper iObjectWrapperZzke;
        try {
            zzxc zzxcVarZzdw = appOpenAd.zzdw();
            if (zzxcVarZzdw == null || (iObjectWrapperZzke = zzxcVarZzdw.zzke()) == null) {
                return;
            }
            View view = (View) ObjectWrapper.unwrap(iObjectWrapperZzke);
            if (view.getParent() != null) {
                zzbbq.zzfc("Trying to set AppOpenAd which is already in use.");
                return;
            }
            removeAllViews();
            addView(view);
            this.zzady = appOpenAd;
            zzdy();
        } catch (RemoteException e2) {
            zzbbq.zze("#007 Could not call remote method.", e2);
        }
    }

    public final void setAppOpenAdPresentationCallback(AppOpenAdPresentationCallback appOpenAdPresentationCallback) {
        this.zzadz = appOpenAdPresentationCallback;
        zzdy();
    }

    public AppOpenAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AppOpenAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
