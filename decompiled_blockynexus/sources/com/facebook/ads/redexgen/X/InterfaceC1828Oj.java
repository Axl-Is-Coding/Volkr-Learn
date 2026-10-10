package com.facebook.ads.redexgen.X;

import android.graphics.Rect;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Oj, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface InterfaceC1828Oj {
    boolean A7p();

    boolean A7r();

    int getCurrentPositionInMillis();

    boolean getGlobalVisibleRect(Rect rect);

    long getInitialBufferTime();

    int getMeasuredHeight();

    int getMeasuredWidth();

    EnumC1834Op getVideoStartReason();

    @Nullable
    View getView();

    float getVolume();
}
