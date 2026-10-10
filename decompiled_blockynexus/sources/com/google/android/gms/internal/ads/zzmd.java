package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(21)
final class zzmd implements zzmb {
    private final int zzbdf;
    private MediaCodecInfo[] zzbdg;

    public zzmd(boolean z) {
        this.zzbdf = z ? 1 : 0;
    }

    private final void zzhm() {
        if (this.zzbdg == null) {
            this.zzbdg = new MediaCodecList(this.zzbdf).getCodecInfos();
        }
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final int getCodecCount() {
        zzhm();
        return this.zzbdg.length;
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final MediaCodecInfo getCodecInfoAt(int i) {
        zzhm();
        return this.zzbdg[i];
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final boolean zza(String str, MediaCodecInfo.CodecCapabilities codecCapabilities) {
        return codecCapabilities.isFeatureSupported("secure-playback");
    }

    @Override // com.google.android.gms.internal.ads.zzmb
    public final boolean zzhl() {
        return true;
    }
}
