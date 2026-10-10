package com.google.android.gms.ads.instream;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes.dex */
public final class InstreamAdView extends FrameLayout {
    public InstreamAdView(Context context) {
        super(context);
        Preconditions.checkNotNull(context, "Context cannot be null");
    }

    public final void setInstreamAd(InstreamAd instreamAd) {
        if (instreamAd != null) {
            instreamAd.zza(this);
        }
    }

    public InstreamAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public InstreamAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }
}
