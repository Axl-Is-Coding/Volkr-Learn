package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzma implements zzmb {
    private zzma() {
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final int getCodecCount() {
        return MediaCodecList.getCodecCount();
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final MediaCodecInfo getCodecInfoAt(int i) {
        return MediaCodecList.getCodecInfoAt(i);
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final boolean zza(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return "video/avc".equals(str);
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final boolean zzhl() {
        return false;
    }
}
