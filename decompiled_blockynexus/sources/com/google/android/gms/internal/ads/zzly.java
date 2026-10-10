package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.media.MediaCodecInfo;
import android.text.TextUtils;
import android.util.Log;
import android.util.Pair;
import android.util.SparseIntArray;
import io.grpc.internal.GrpcUtil;
import io.rong.common.dlog.DLog;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.regex.Pattern;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
@SuppressLint({"InlinedApi"})
@TargetApi(16)
public final class zzly {
    private static final SparseIntArray zzbda;
    private static final SparseIntArray zzbdb;
    private static final Map<String, Integer> zzbdc;
    private static final zzlr zzbcx = zzlr.zzbb("OMX.google.raw.decoder");
    private static final Pattern zzbcy = Pattern.compile("^\\D?(\\d+)$");
    private static final HashMap<zza, List<zzlr>> zzbcz = new HashMap<>();
    private static int zzbdd = -1;

    /* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
    static final class zza {
        public final String mimeType;
        public final boolean zzbbf;

        public zza(String str, boolean z) {
            this.mimeType = str;
            this.zzbbf = z;
        }

        public final boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj != null && obj.getClass() == zza.class) {
                zza zzaVar = (zza) obj;
                if (TextUtils.equals(this.mimeType, zzaVar.mimeType) && this.zzbbf == zzaVar.zzbbf) {
                    return true;
                }
            }
            return false;
        }

        public final int hashCode() {
            String str = this.mimeType;
            return (((str == null ? 0 : str.hashCode()) + 31) * 31) + (this.zzbbf ? 1231 : 1237);
        }
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        zzbda = sparseIntArray;
        sparseIntArray.put(66, 1);
        zzbda.put(77, 2);
        zzbda.put(88, 4);
        zzbda.put(100, 8);
        SparseIntArray sparseIntArray2 = new SparseIntArray();
        zzbdb = sparseIntArray2;
        sparseIntArray2.put(10, 1);
        zzbdb.put(11, 4);
        zzbdb.put(12, 8);
        zzbdb.put(13, 16);
        zzbdb.put(20, 32);
        zzbdb.put(21, 64);
        zzbdb.put(22, 128);
        zzbdb.put(30, 256);
        zzbdb.put(31, 512);
        zzbdb.put(32, 1024);
        zzbdb.put(40, DLog.CRS);
        zzbdb.put(41, 4096);
        zzbdb.put(42, 8192);
        zzbdb.put(50, 16384);
        zzbdb.put(51, 32768);
        zzbdb.put(52, 65536);
        HashMap map = new HashMap();
        zzbdc = map;
        map.put("L30", 1);
        zzbdc.put("L60", 4);
        zzbdc.put("L63", 16);
        zzbdc.put("L90", 64);
        zzbdc.put("L93", 256);
        zzbdc.put("L120", 1024);
        zzbdc.put("L123", 4096);
        zzbdc.put("L150", 16384);
        zzbdc.put("L153", 65536);
        zzbdc.put("L156", 262144);
        zzbdc.put("L180", 1048576);
        zzbdc.put("L183", Integer.valueOf(GrpcUtil.DEFAULT_MAX_MESSAGE_SIZE));
        zzbdc.put("L186", 16777216);
        zzbdc.put("H30", 2);
        zzbdc.put("H60", 8);
        zzbdc.put("H63", 32);
        zzbdc.put("H90", 128);
        zzbdc.put("H93", 512);
        zzbdc.put("H120", Integer.valueOf(DLog.CRS));
        zzbdc.put("H123", 8192);
        zzbdc.put("H150", 32768);
        zzbdc.put("H153", 131072);
        zzbdc.put("H156", 524288);
        zzbdc.put("H180", 2097152);
        zzbdc.put("H183", 8388608);
        zzbdc.put("H186", 33554432);
    }

    /* JADX WARN: Removed duplicated region for block: B:127:0x01fa  */
    /*  JADX ERROR: JadxRuntimeException in pass: ProcessVariables
        jadx.core.utils.exceptions.JadxRuntimeException: Method arg registers not loaded: com.google.android.gms.internal.ads.zzlz.<init>(java.lang.Throwable, com.google.android.gms.internal.ads.zzlx):void, class status: GENERATED_AND_UNLOADED
        	at jadx.core.dex.nodes.MethodNode.getArgRegs(MethodNode.java:298)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isArgUnused(ProcessVariables.java:146)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.lambda$isVarUnused$0(ProcessVariables.java:131)
        	at jadx.core.utils.ListUtils.allMatch(ListUtils.java:197)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.isVarUnused(ProcessVariables.java:131)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables$1.processBlock(ProcessVariables.java:82)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:64)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at java.base/java.util.Collections$UnmodifiableCollection.forEach(Collections.java:1116)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.lambda$traverseInternal$0(DepthRegionTraversal.java:68)
        	at java.base/java.util.ArrayList.forEach(ArrayList.java:1596)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseInternal(DepthRegionTraversal.java:68)
        	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverse(DepthRegionTraversal.java:19)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.removeUnusedResults(ProcessVariables.java:73)
        	at jadx.core.dex.visitors.regions.variables.ProcessVariables.visit(ProcessVariables.java:48)
        */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private static java.util.List<com.google.android.gms.internal.ads.zzlr> zza(com.google.android.gms.internal.ads.zzly.zza r17, com.google.android.gms.internal.ads.zzmb r18) throws com.google.android.gms.internal.ads.zzlz {
        /*
            Method dump skipped, instruction units count: 696
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzly.zza(com.google.android.gms.internal.ads.zzly$zza, com.google.android.gms.internal.ads.zzmb):java.util.List");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /* JADX WARN: Removed duplicated region for block: B:20:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static android.util.Pair<java.lang.Integer, java.lang.Integer> zzbe(java.lang.String r9) {
        /*
            Method dump skipped, instruction units count: 268
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzly.zzbe(java.lang.String):android.util.Pair");
    }

    public static zzlr zzc(String str, boolean z) throws zzlz {
        List<zzlr> listZzd = zzd(str, z);
        if (listZzd.isEmpty()) {
            return null;
        }
        return listZzd.get(0);
    }

    private static synchronized List<zzlr> zzd(String str, boolean z) throws zzlz {
        zza zzaVar = new zza(str, z);
        List<zzlr> list = zzbcz.get(zzaVar);
        if (list != null) {
            return list;
        }
        List<zzlr> listZza = zza(zzaVar, zzpq.SDK_INT >= 21 ? new zzmd(z) : new zzma());
        if (z && listZza.isEmpty() && 21 <= zzpq.SDK_INT && zzpq.SDK_INT <= 23) {
            listZza = zza(zzaVar, new zzma());
            if (!listZza.isEmpty()) {
                String str2 = listZza.get(0).name;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 63 + String.valueOf(str2).length());
                sb.append("MediaCodecList API didn't list secure decoder for: ");
                sb.append(str);
                sb.append(". Assuming: ");
                sb.append(str2);
                Log.w("MediaCodecUtil", sb.toString());
            }
        }
        List<zzlr> listUnmodifiableList = Collections.unmodifiableList(listZza);
        zzbcz.put(zzaVar, listUnmodifiableList);
        return listUnmodifiableList;
    }

    public static zzlr zzhj() {
        return zzbcx;
    }

    public static int zzhk() throws zzlz {
        int i;
        if (zzbdd == -1) {
            int iMax = 0;
            zzlr zzlrVarZzc = zzc("video/avc", false);
            if (zzlrVarZzc != null) {
                MediaCodecInfo.CodecProfileLevel[] codecProfileLevelArrZzhc = zzlrVarZzc.zzhc();
                int length = codecProfileLevelArrZzhc.length;
                int iMax2 = 0;
                while (iMax < length) {
                    int i2 = codecProfileLevelArrZzhc[iMax].level;
                    if (i2 != 1 && i2 != 2) {
                        switch (i2) {
                            case 8:
                            case 16:
                            case 32:
                                i = 101376;
                                break;
                            case 64:
                                i = 202752;
                                break;
                            case 128:
                            case 256:
                                i = 414720;
                                break;
                            case 512:
                                i = 921600;
                                break;
                            case 1024:
                                i = 1310720;
                                break;
                            case DLog.CRS /* 2048 */:
                            case 4096:
                                i = 2097152;
                                break;
                            case 8192:
                                i = 2228224;
                                break;
                            case 16384:
                                i = 5652480;
                                break;
                            case 32768:
                            case 65536:
                                i = 9437184;
                                break;
                            default:
                                i = -1;
                                break;
                        }
                    } else {
                        i = 25344;
                    }
                    iMax2 = Math.max(i, iMax2);
                    iMax++;
                }
                iMax = Math.max(iMax2, zzpq.SDK_INT >= 21 ? 345600 : 172800);
            }
            zzbdd = iMax;
        }
        return zzbdd;
    }

    private static Pair<Integer, Integer> zza(String str, String[] strArr) {
        Integer numValueOf;
        Integer numValueOf2;
        if (strArr.length < 2) {
            String strValueOf = String.valueOf(str);
            Log.w("MediaCodecUtil", strValueOf.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(strValueOf) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
        try {
            if (strArr[1].length() == 6) {
                Integer numValueOf3 = Integer.valueOf(Integer.parseInt(strArr[1].substring(0, 2), 16));
                numValueOf2 = Integer.valueOf(Integer.parseInt(strArr[1].substring(4), 16));
                numValueOf = numValueOf3;
            } else if (strArr.length >= 3) {
                numValueOf = Integer.valueOf(Integer.parseInt(strArr[1]));
                numValueOf2 = Integer.valueOf(Integer.parseInt(strArr[2]));
            } else {
                String strValueOf2 = String.valueOf(str);
                Log.w("MediaCodecUtil", strValueOf2.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(strValueOf2) : new String("Ignoring malformed AVC codec string: "));
                return null;
            }
            Integer numValueOf4 = Integer.valueOf(zzbda.get(numValueOf.intValue()));
            if (numValueOf4 == null) {
                String strValueOf3 = String.valueOf(numValueOf);
                StringBuilder sb = new StringBuilder(String.valueOf(strValueOf3).length() + 21);
                sb.append("Unknown AVC profile: ");
                sb.append(strValueOf3);
                Log.w("MediaCodecUtil", sb.toString());
                return null;
            }
            Integer numValueOf5 = Integer.valueOf(zzbdb.get(numValueOf2.intValue()));
            if (numValueOf5 == null) {
                String strValueOf4 = String.valueOf(numValueOf2);
                StringBuilder sb2 = new StringBuilder(String.valueOf(strValueOf4).length() + 19);
                sb2.append("Unknown AVC level: ");
                sb2.append(strValueOf4);
                Log.w("MediaCodecUtil", sb2.toString());
                return null;
            }
            return new Pair<>(numValueOf4, numValueOf5);
        } catch (NumberFormatException unused) {
            String strValueOf5 = String.valueOf(str);
            Log.w("MediaCodecUtil", strValueOf5.length() != 0 ? "Ignoring malformed AVC codec string: ".concat(strValueOf5) : new String("Ignoring malformed AVC codec string: "));
            return null;
        }
    }
}
