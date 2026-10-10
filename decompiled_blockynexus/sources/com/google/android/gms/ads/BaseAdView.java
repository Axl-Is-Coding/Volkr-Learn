package com.google.android.gms.ads;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.internal.ads.zzbbq;
import com.google.android.gms.internal.ads.zzux;
import com.google.android.gms.internal.ads.zzyy;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
class BaseAdView extends ViewGroup {
    protected final zzyy zzadh;

    public BaseAdView(Context context, int i) {
        super(context);
        this.zzadh = new zzyy(this, i);
    }

    public void destroy() {
        this.zzadh.destroy();
    }

    public AdListener getAdListener() {
        return this.zzadh.getAdListener();
    }

    public AdSize getAdSize() {
        return this.zzadh.getAdSize();
    }

    public String getAdUnitId() {
        return this.zzadh.getAdUnitId();
    }

    @Deprecated
    public String getMediationAdapterClassName() {
        return this.zzadh.getMediationAdapterClassName();
    }

    public ResponseInfo getResponseInfo() {
        return this.zzadh.getResponseInfo();
    }

    public boolean isLoading() {
        return this.zzadh.isLoading();
    }

    public void loadAd(AdRequest adRequest) {
        this.zzadh.zza(adRequest.zzdr());
    }

    @Override // android.view.ViewGroup, android.view.View
    protected void onLayout(boolean z, int i, int i2, int i3, int i4) {
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
    protected void onMeasure(int i, int i2) {
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

    public void pause() {
        this.zzadh.pause();
    }

    public void resume() {
        this.zzadh.resume();
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void setAdListener(AdListener adListener) {
        this.zzadh.setAdListener(adListener);
        if (adListener == 0) {
            this.zzadh.zza((zzux) null);
            this.zzadh.setAppEventListener(null);
            return;
        }
        if (adListener instanceof zzux) {
            this.zzadh.zza((zzux) adListener);
        }
        if (adListener instanceof AppEventListener) {
            this.zzadh.setAppEventListener((AppEventListener) adListener);
        }
    }

    public void setAdSize(AdSize adSize) {
        this.zzadh.setAdSizes(adSize);
    }

    public void setAdUnitId(String str) {
        this.zzadh.setAdUnitId(str);
    }

    public void setOnPaidEventListener(OnPaidEventListener onPaidEventListener) {
        this.zzadh.setOnPaidEventListener(onPaidEventListener);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet);
        this.zzadh = new zzyy(this, attributeSet, false, i);
    }

    public BaseAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i);
        this.zzadh = new zzyy(this, attributeSet, false, i2);
    }
}
