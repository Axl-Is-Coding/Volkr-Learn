package com.facebook.ads.redexgen.X;

import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.Nullable;
import com.facebook.ads.NativeAdLayout;
import com.facebook.ads.internal.api.AdComponentViewApi;
import com.facebook.ads.internal.api.NativeAdLayoutApi;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public class T0 extends C13654z implements NativeAdLayoutApi {

    @Nullable
    public View A02;
    public NativeAdLayout A03;
    public int A01 = 0;
    public int A00 = 0;

    public final void A03() {
        LX.A0X(this.A03);
        this.A03.removeView(this.A02);
        this.A02 = null;
    }

    public final void A04(MZ mz) {
        this.A02 = mz;
        mz.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        LX.A0X(this.A03);
        this.A03.addView(this.A02);
    }

    @Override // com.facebook.ads.internal.api.AdComponentViewApiProvider
    public final AdComponentViewApi getAdComponentViewApi() {
        return this;
    }

    @Override // com.facebook.ads.internal.api.NativeAdLayoutApi
    public final void initialize(NativeAdLayout nativeAdLayout) {
        this.A03 = nativeAdLayout;
    }

    @Override // com.facebook.ads.redexgen.X.C13654z, com.facebook.ads.internal.api.AdComponentViewParentApi
    public final void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        if (this.A00 > 0) {
            int measuredWidth = this.A03.getMeasuredWidth();
            int i3 = this.A00;
            if (measuredWidth > i3) {
                setMeasuredDimension(i3, this.A03.getMeasuredHeight());
                return;
            }
        }
        int measuredWidth2 = this.A03.getMeasuredWidth();
        int i4 = this.A01;
        if (measuredWidth2 >= i4) {
            return;
        }
        setMeasuredDimension(i4, this.A03.getMeasuredHeight());
    }

    @Override // com.facebook.ads.internal.api.NativeAdLayoutApi
    public final void setMaxWidth(int i) {
        this.A00 = i;
    }

    @Override // com.facebook.ads.internal.api.NativeAdLayoutApi
    public final void setMinWidth(int i) {
        this.A01 = i;
    }
}
