package com.google.android.gms.internal.ads;

import com.just.agentweb.WebIndicator;
import com.uc.crashsdk.export.LogType;
import io.rong.common.dlog.DLog;
import java.nio.ByteBuffer;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zziy {
    private static final int[] zzamf = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzamg = {-1, WebIndicator.MAX_UNIFORM_SPEED_DURATION, 16000, LogType.UNEXP_KNOWN_REASON, -1, -1, 11025, 22050, 44100, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzamh = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, LogType.UNEXP_OTHER, 896, 1024, 1152, LogType.UNEXP_ANR, 1536, 1920, DLog.CRS, LogType.UNEXP_LOW_MEMORY, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static int zzo(ByteBuffer byteBuffer) {
        int iPosition = byteBuffer.position();
        return ((((byteBuffer.get(iPosition + 5) & 252) >> 2) | ((byteBuffer.get(iPosition + 4) & 1) << 6)) + 1) << 5;
    }
}
