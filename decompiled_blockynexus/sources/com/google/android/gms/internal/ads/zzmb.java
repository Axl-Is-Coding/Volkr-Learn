package com.google.android.gms.internal.ads;

import android.media.MediaCodecInfo;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
interface zzmb {
    int getCodecCount();

    MediaCodecInfo getCodecInfoAt(int i);

    boolean zza(String str, MediaCodecInfo.CodecCapabilities codecCapabilities);

    boolean zzhl();
}
