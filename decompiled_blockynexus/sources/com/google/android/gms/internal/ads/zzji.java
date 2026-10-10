package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(24)
final class zzji {
    private final MediaCodec.CryptoInfo zzanx;
    private final MediaCodec.CryptoInfo.Pattern zzanz;

    private zzji(MediaCodec.CryptoInfo cryptoInfo) {
        this.zzanx = cryptoInfo;
        this.zzanz = new MediaCodec.CryptoInfo.Pattern(0, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void set(int i, int i2) {
        this.zzanz.set(i, i2);
        this.zzanx.setPattern(this.zzanz);
    }
}
