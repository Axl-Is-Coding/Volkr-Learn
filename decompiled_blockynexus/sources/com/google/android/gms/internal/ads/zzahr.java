package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.CollectionUtils;
import com.umeng.analytics.pro.au;
import java.util.Map;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzahr implements zzahq<zzbgj> {
    private static final Map<String, Integer> zzdfp = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final com.google.android.gms.ads.internal.zza zzdfm;
    private final zzaqd zzdfn;
    private final zzaqq zzdfo;

    public zzahr(com.google.android.gms.ads.internal.zza zzaVar, zzaqd zzaqdVar, zzaqq zzaqqVar) {
        this.zzdfm = zzaVar;
        this.zzdfn = zzaqdVar;
        this.zzdfo = zzaqqVar;
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final /* synthetic */ void zza(zzbgj zzbgjVar, Map map) {
        com.google.android.gms.ads.internal.zza zzaVar;
        zzbgj zzbgjVar2 = zzbgjVar;
        int iIntValue = zzdfp.get((String) map.get(au.at)).intValue();
        if (iIntValue != 5 && iIntValue != 7 && (zzaVar = this.zzdfm) != null && !zzaVar.zzjz()) {
            this.zzdfm.zzbo(null);
            return;
        }
        if (iIntValue == 1) {
            this.zzdfn.zzg(map);
            return;
        }
        if (iIntValue == 3) {
            new zzaqi(zzbgjVar2, map).execute();
            return;
        }
        if (iIntValue == 4) {
            new zzaqc(zzbgjVar2, map).execute();
            return;
        }
        if (iIntValue == 5) {
            new zzaqf(zzbgjVar2, map).execute();
            return;
        }
        if (iIntValue == 6) {
            this.zzdfn.zzac(true);
        } else if (iIntValue != 7) {
            zzbbq.zzfd("Unknown MRAID command called.");
        } else {
            this.zzdfo.zzuq();
        }
    }
}
