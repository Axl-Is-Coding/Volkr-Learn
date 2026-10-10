package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.AdSize;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdoq {
    public static zzdnu zza(List<zzdnu> list, zzdnu zzdnuVar) {
        return list.get(0);
    }

    public static zzvn zzb(Context context, List<zzdnu> list) {
        ArrayList arrayList = new ArrayList();
        for (zzdnu zzdnuVar : list) {
            if (zzdnuVar.zzhdh) {
                arrayList.add(AdSize.FLUID);
            } else {
                arrayList.add(new AdSize(zzdnuVar.width, zzdnuVar.height));
            }
        }
        return new zzvn(context, (AdSize[]) arrayList.toArray(new AdSize[arrayList.size()]));
    }

    public static zzdnu zzf(zzvn zzvnVar) {
        return zzvnVar.zzchv ? new zzdnu(-3, 0, true) : new zzdnu(zzvnVar.width, zzvnVar.height, false);
    }
}
