package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.media.MediaCodecList;
import android.os.Build;
import android.util.Range;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbbe {
    private static List<MediaCodecInfo> zzedq;
    private static Map<String, List<Map<String, Object>>> zzedp = new HashMap();
    private static final Object zzedr = new Object();

    @TargetApi(21)
    private static Integer[] zza(Range<Integer> range) {
        return new Integer[]{(Integer) range.getLower(), (Integer) range.getUpper()};
    }

    @TargetApi(16)
    public static List<Map<String, Object>> zzew(String str) {
        synchronized (zzedr) {
            if (zzedp.containsKey(str)) {
                return zzedp.get(str);
            }
            try {
                synchronized (zzedr) {
                    if (zzedq == null) {
                        if (Build.VERSION.SDK_INT >= 21) {
                            zzedq = Arrays.asList(new MediaCodecList(0).getCodecInfos());
                        } else {
                            int codecCount = MediaCodecList.getCodecCount();
                            zzedq = new ArrayList(codecCount);
                            for (int i = 0; i < codecCount; i++) {
                                zzedq.add(MediaCodecList.getCodecInfoAt(i));
                            }
                        }
                    }
                }
                ArrayList arrayList = new ArrayList();
                for (MediaCodecInfo mediaCodecInfo : zzedq) {
                    if (!mediaCodecInfo.isEncoder() && Arrays.asList(mediaCodecInfo.getSupportedTypes()).contains(str)) {
                        HashMap map = new HashMap();
                        map.put("codecName", mediaCodecInfo.getName());
                        MediaCodecInfo.CodecCapabilities capabilitiesForType = mediaCodecInfo.getCapabilitiesForType(str);
                        ArrayList arrayList2 = new ArrayList();
                        for (MediaCodecInfo.CodecProfileLevel codecProfileLevel : capabilitiesForType.profileLevels) {
                            arrayList2.add(new Integer[]{Integer.valueOf(codecProfileLevel.profile), Integer.valueOf(codecProfileLevel.level)});
                        }
                        map.put("profileLevels", arrayList2);
                        if (Build.VERSION.SDK_INT >= 21) {
                            MediaCodecInfo.VideoCapabilities videoCapabilities = capabilitiesForType.getVideoCapabilities();
                            map.put("bitRatesBps", zza(videoCapabilities.getBitrateRange()));
                            map.put("widthAlignment", Integer.valueOf(videoCapabilities.getWidthAlignment()));
                            map.put("heightAlignment", Integer.valueOf(videoCapabilities.getHeightAlignment()));
                            map.put("frameRates", zza(videoCapabilities.getSupportedFrameRates()));
                            map.put("widths", zza(videoCapabilities.getSupportedWidths()));
                            map.put("heights", zza(videoCapabilities.getSupportedHeights()));
                        }
                        if (Build.VERSION.SDK_INT >= 23) {
                            map.put("instancesLimit", Integer.valueOf(capabilitiesForType.getMaxSupportedInstances()));
                        }
                        arrayList.add(map);
                    }
                }
                zzedp.put(str, arrayList);
                return arrayList;
            } catch (LinkageError | RuntimeException e2) {
                HashMap map2 = new HashMap();
                map2.put("error", e2.getClass().getSimpleName());
                ArrayList arrayList3 = new ArrayList();
                arrayList3.add(map2);
                zzedp.put(str, arrayList3);
                return arrayList3;
            }
        }
    }
}
