package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.graphics.Point;
import android.media.MediaCodecInfo;
import android.util.Log;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@TargetApi(16)
public final class zzlr {
    private final String mimeType;
    public final String name;
    public final boolean zzalm;
    public final boolean zzbbe;
    public final boolean zzbbf;
    private final MediaCodecInfo.CodecCapabilities zzbbg;

    /* JADX WARN: Removed duplicated region for block: B:13:0x0029  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x0043  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x005c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private zzlr(java.lang.String r2, java.lang.String r3, android.media.MediaCodecInfo.CodecCapabilities r4, boolean r5, boolean r6) {
        /*
            r1 = this;
            r1.<init>()
            com.google.android.gms.internal.ads.zzoz.checkNotNull(r2)
            java.lang.String r2 = (java.lang.String) r2
            r1.name = r2
            r1.mimeType = r3
            r1.zzbbg = r4
            r2 = 1
            r3 = 0
            if (r5 != 0) goto L29
            if (r4 == 0) goto L29
            int r5 = com.google.android.gms.internal.ads.zzpq.SDK_INT
            r0 = 19
            if (r5 < r0) goto L24
            java.lang.String r5 = "adaptive-playback"
            boolean r5 = r4.isFeatureSupported(r5)
            if (r5 == 0) goto L24
            r5 = 1
            goto L25
        L24:
            r5 = 0
        L25:
            if (r5 == 0) goto L29
            r5 = 1
            goto L2a
        L29:
            r5 = 0
        L2a:
            r1.zzbbe = r5
            r5 = 21
            if (r4 == 0) goto L43
            int r0 = com.google.android.gms.internal.ads.zzpq.SDK_INT
            if (r0 < r5) goto L3e
            java.lang.String r0 = "tunneled-playback"
            boolean r0 = r4.isFeatureSupported(r0)
            if (r0 == 0) goto L3e
            r0 = 1
            goto L3f
        L3e:
            r0 = 0
        L3f:
            if (r0 == 0) goto L43
            r0 = 1
            goto L44
        L43:
            r0 = 0
        L44:
            r1.zzalm = r0
            if (r6 != 0) goto L5d
            if (r4 == 0) goto L5c
            int r6 = com.google.android.gms.internal.ads.zzpq.SDK_INT
            if (r6 < r5) goto L58
            java.lang.String r5 = "secure-playback"
            boolean r4 = r4.isFeatureSupported(r5)
            if (r4 == 0) goto L58
            r4 = 1
            goto L59
        L58:
            r4 = 0
        L59:
            if (r4 == 0) goto L5c
            goto L5d
        L5c:
            r2 = 0
        L5d:
            r1.zzbbf = r2
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlr.<init>(java.lang.String, java.lang.String, android.media.MediaCodecInfo$CodecCapabilities, boolean, boolean):void");
    }

    public static zzlr zza(String str, String str2, MediaCodecInfo.CodecCapabilities codecCapabilities, boolean z, boolean z2) {
        return new zzlr(str, str2, codecCapabilities, z, z2);
    }

    public static zzlr zzbb(String str) {
        return new zzlr(str, null, null, false, false);
    }

    private final void zzbd(String str) {
        String str2 = this.name;
        String str3 = this.mimeType;
        String str4 = zzpq.zzbkm;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 20 + String.valueOf(str2).length() + String.valueOf(str3).length() + String.valueOf(str4).length());
        sb.append("NoSupport [");
        sb.append(str);
        sb.append("] [");
        sb.append(str2);
        sb.append(", ");
        sb.append(str3);
        sb.append("] [");
        sb.append(str4);
        sb.append("]");
        Log.d("MediaCodecInfo", sb.toString());
    }

    @TargetApi(21)
    public final boolean zzay(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbbg;
        if (codecCapabilities == null) {
            zzbd("sampleRate.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzbd("sampleRate.aCaps");
            return false;
        }
        if (audioCapabilities.isSampleRateSupported(i)) {
            return true;
        }
        StringBuilder sb = new StringBuilder(31);
        sb.append("sampleRate.support, ");
        sb.append(i);
        zzbd(sb.toString());
        return false;
    }

    @TargetApi(21)
    public final boolean zzaz(int i) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbbg;
        if (codecCapabilities == null) {
            zzbd("channelCount.caps");
            return false;
        }
        MediaCodecInfo.AudioCapabilities audioCapabilities = codecCapabilities.getAudioCapabilities();
        if (audioCapabilities == null) {
            zzbd("channelCount.aCaps");
            return false;
        }
        if (audioCapabilities.getMaxInputChannelCount() >= i) {
            return true;
        }
        StringBuilder sb = new StringBuilder(33);
        sb.append("channelCount.support, ");
        sb.append(i);
        zzbd(sb.toString());
        return false;
    }

    /* JADX WARN: Removed duplicated region for block: B:59:0x00c3  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean zzbc(java.lang.String r12) {
        /*
            Method dump skipped, instruction units count: 348
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlr.zzbc(java.lang.String):boolean");
    }

    @TargetApi(21)
    public final Point zzd(int i, int i2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbbg;
        if (codecCapabilities == null) {
            zzbd("align.caps");
            return null;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzbd("align.vCaps");
            return null;
        }
        int widthAlignment = videoCapabilities.getWidthAlignment();
        int heightAlignment = videoCapabilities.getHeightAlignment();
        return new Point(zzpq.zzf(i, widthAlignment) * widthAlignment, zzpq.zzf(i2, heightAlignment) * heightAlignment);
    }

    public final MediaCodecInfo.CodecProfileLevel[] zzhc() {
        MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArr;
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbbg;
        return (codecCapabilities == null || (codecProfileLevelArr = codecCapabilities.profileLevels) == null) ? new MediaCodecInfo.CodecProfileLevel[0] : codecProfileLevelArr;
    }

    @TargetApi(21)
    public final boolean zza(int i, int i2, double d2) {
        MediaCodecInfo.CodecCapabilities codecCapabilities = this.zzbbg;
        if (codecCapabilities == null) {
            zzbd("sizeAndRate.caps");
            return false;
        }
        MediaCodecInfo.VideoCapabilities videoCapabilities = codecCapabilities.getVideoCapabilities();
        if (videoCapabilities == null) {
            zzbd("sizeAndRate.vCaps");
            return false;
        }
        if (zza(videoCapabilities, i, i2, d2)) {
            return true;
        }
        if (i >= i2 || !zza(videoCapabilities, i2, i, d2)) {
            StringBuilder sb = new StringBuilder(69);
            sb.append("sizeAndRate.support, ");
            sb.append(i);
            sb.append("x");
            sb.append(i2);
            sb.append("x");
            sb.append(d2);
            zzbd(sb.toString());
            return false;
        }
        StringBuilder sb2 = new StringBuilder(69);
        sb2.append("sizeAndRate.rotated, ");
        sb2.append(i);
        sb2.append("x");
        sb2.append(i2);
        sb2.append("x");
        sb2.append(d2);
        String string = sb2.toString();
        String str = this.name;
        String str2 = this.mimeType;
        String str3 = zzpq.zzbkm;
        StringBuilder sb3 = new StringBuilder(String.valueOf(string).length() + 25 + String.valueOf(str).length() + String.valueOf(str2).length() + String.valueOf(str3).length());
        sb3.append("AssumedSupport [");
        sb3.append(string);
        sb3.append("] [");
        sb3.append(str);
        sb3.append(", ");
        sb3.append(str2);
        sb3.append("] [");
        sb3.append(str3);
        sb3.append("]");
        Log.d("MediaCodecInfo", sb3.toString());
        return true;
    }

    @TargetApi(21)
    private static boolean zza(MediaCodecInfo.VideoCapabilities videoCapabilities, int i, int i2, double d2) {
        if (d2 != -1.0d && d2 > 0.0d) {
            return videoCapabilities.areSizeAndRateSupported(i, i2, d2);
        }
        return videoCapabilities.isSizeSupported(i, i2);
    }
}
