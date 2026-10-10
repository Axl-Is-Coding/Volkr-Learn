package com.facebook.ads.redexgen.X;

import android.net.Uri;
import android.view.View;
import androidx.annotation.Nullable;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: loaded from: assets/audience_network.dex */
public interface PZ {
    void A7L();

    boolean A7S();

    boolean A7T();

    boolean A7v();

    void ABq(boolean z, int i);

    void ADX(int i);

    void ADb(EnumC1834Op enumC1834Op, int i);

    void ADh(int i);

    void destroy();

    int getCurrentPosition();

    int getDuration();

    long getInitialBufferTime();

    EnumC1834Op getStartReason();

    EnumC1846Pb getState();

    int getVideoHeight();

    int getVideoWidth();

    View getView();

    float getVolume();

    void seekTo(int i);

    void setBackgroundPlaybackEnabled(boolean z);

    void setControlsAnchorView(View view);

    void setFullScreen(boolean z);

    void setRequestedVolume(float f2);

    void setVideoMPD(@Nullable String str);

    void setVideoStateChangeListener(InterfaceC1847Pc interfaceC1847Pc);

    void setup(Uri uri);
}
