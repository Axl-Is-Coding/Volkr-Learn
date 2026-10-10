package com.facebook.ads.redexgen.X;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.os.Handler;
import androidx.annotation.NonNull;

/* JADX WARN: Classes with same name are omitted, all sources:
  assets.dex
  assets/audience_network.dex
 */
/* JADX INFO: renamed from: com.facebook.ads.redexgen.X.Ih, reason: case insensitive filesystem */
/* JADX INFO: loaded from: assets/audience_network.dex */
@TargetApi(23)
public final class C1676Ih implements MediaCodec.OnFrameRenderedListener {
    public final /* synthetic */ C12881x A00;

    public C1676Ih(C12881x c12881x, MediaCodec mediaCodec) {
        this.A00 = c12881x;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(@NonNull MediaCodec mediaCodec, long j, long j2) {
        if (this != this.A00.A00) {
            return;
        }
        this.A00.A1T();
    }
}
