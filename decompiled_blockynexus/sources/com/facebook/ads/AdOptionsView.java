package com.facebook.ads;

import android.content.Context;
import androidx.annotation.Keep;
import com.facebook.ads.internal.api.AdComponentFrameLayout;
import com.facebook.ads.internal.api.AdOptionsViewApi;
import com.facebook.ads.internal.dynamicloading.DynamicLoaderFactory;

/* JADX INFO: loaded from: classes.dex */
@Keep
public class AdOptionsView extends AdComponentFrameLayout {
    private final AdOptionsViewApi mAdOptionsViewApi;

    @Keep
    public enum Orientation {
        HORIZONTAL,
        VERTICAL
    }

    public AdOptionsView(Context context, NativeAdBase nativeAdBase, NativeAdLayout nativeAdLayout) {
        super(context);
        this.mAdOptionsViewApi = DynamicLoaderFactory.makeLoader(context).createAdOptionsView(context, nativeAdBase, nativeAdLayout, this);
        attachAdComponentViewApi(this.mAdOptionsViewApi);
    }

    public void setIconColor(int i) {
        this.mAdOptionsViewApi.setIconColor(i);
    }

    public void setIconSizeDp(int i) {
        this.mAdOptionsViewApi.setIconSizeDp(i);
    }

    public void setSingleIcon(boolean z) {
        this.mAdOptionsViewApi.setSingleIcon(z);
    }

    public AdOptionsView(Context context, NativeAdBase nativeAdBase, NativeAdLayout nativeAdLayout, Orientation orientation, int i) {
        super(context);
        this.mAdOptionsViewApi = DynamicLoaderFactory.makeLoader(context).createAdOptionsView(context, nativeAdBase, nativeAdLayout, orientation, i, this);
        attachAdComponentViewApi(this.mAdOptionsViewApi);
    }
}
