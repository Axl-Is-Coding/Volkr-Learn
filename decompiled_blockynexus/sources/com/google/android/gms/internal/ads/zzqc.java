package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.os.Handler;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(23)
final class zzqc implements MediaCodec.OnFrameRenderedListener {
    private final /* synthetic */ zzpx zzbmr;

    private zzqc(zzpx zzpxVar, MediaCodec mediaCodec) {
        this.zzbmr = zzpxVar;
        mediaCodec.setOnFrameRenderedListener(this, new Handler());
    }

    @Override // android.media.MediaCodec.OnFrameRenderedListener
    public final void onFrameRendered(MediaCodec mediaCodec, long j, long j2) {
        zzpx zzpxVar = this.zzbmr;
        if (this != zzpxVar.zzbmc) {
            return;
        }
        zzpxVar.zzjk();
    }
}
