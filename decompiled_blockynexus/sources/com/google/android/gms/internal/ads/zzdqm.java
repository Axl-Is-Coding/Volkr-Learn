package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import com.unity3d.services.ads.adunit.AdUnitActivity;
import io.rong.imlib.statistics.UserData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.TreeSet;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdqm implements zzdqj {
    private final Object[] zzhit;

    public zzdqm(zzvg zzvgVar, String str, int i, String str2, zzvs zzvsVar) {
        HashSet hashSet = new HashSet(Arrays.asList(str2.split(",")));
        ArrayList arrayList = new ArrayList();
        arrayList.add(str2);
        arrayList.add(str);
        if (hashSet.contains("networkType")) {
            arrayList.add(Integer.valueOf(i));
        }
        if (hashSet.contains("birthday")) {
            arrayList.add(Long.valueOf(zzvgVar.zzchb));
        }
        if (hashSet.contains("extras")) {
            arrayList.add(zzr(zzvgVar.extras));
        } else if (hashSet.contains("npa")) {
            arrayList.add(zzvgVar.extras.getString("npa"));
        }
        if (hashSet.contains(UserData.GENDER_KEY)) {
            arrayList.add(Integer.valueOf(zzvgVar.zzchc));
        }
        if (hashSet.contains("keywords")) {
            List<String> list = zzvgVar.zzchd;
            if (list != null) {
                arrayList.add(list.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("isTestDevice")) {
            arrayList.add(Boolean.valueOf(zzvgVar.zzche));
        }
        if (hashSet.contains("tagForChildDirectedTreatment")) {
            arrayList.add(Integer.valueOf(zzvgVar.zzadm));
        }
        if (hashSet.contains("manualImpressionsEnabled")) {
            arrayList.add(Boolean.valueOf(zzvgVar.zzbny));
        }
        if (hashSet.contains("publisherProvidedId")) {
            arrayList.add(zzvgVar.zzchf);
        }
        if (hashSet.contains("location")) {
            Location location = zzvgVar.zznb;
            if (location != null) {
                arrayList.add(location.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("contentUrl")) {
            arrayList.add(zzvgVar.zzchh);
        }
        if (hashSet.contains("networkExtras")) {
            arrayList.add(zzr(zzvgVar.zzchi));
        }
        if (hashSet.contains("customTargeting")) {
            arrayList.add(zzr(zzvgVar.zzchj));
        }
        if (hashSet.contains("categoryExclusions")) {
            List<String> list2 = zzvgVar.zzchk;
            if (list2 != null) {
                arrayList.add(list2.toString());
            } else {
                arrayList.add(null);
            }
        }
        if (hashSet.contains("requestAgent")) {
            arrayList.add(zzvgVar.zzchl);
        }
        if (hashSet.contains("requestPackage")) {
            arrayList.add(zzvgVar.zzchm);
        }
        if (hashSet.contains("isDesignedForFamilies")) {
            arrayList.add(Boolean.valueOf(zzvgVar.zzchn));
        }
        if (hashSet.contains("tagForUnderAgeOfConsent")) {
            arrayList.add(Integer.valueOf(zzvgVar.zzadn));
        }
        if (hashSet.contains("maxAdContentRating")) {
            arrayList.add(zzvgVar.zzado);
        }
        if (hashSet.contains(AdUnitActivity.EXTRA_ORIENTATION)) {
            if (zzvsVar != null) {
                arrayList.add(Integer.valueOf(zzvsVar.orientation));
            } else {
                arrayList.add(null);
            }
        }
        this.zzhit = arrayList.toArray();
    }

    private static String zzr(Bundle bundle) {
        if (bundle == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = new TreeSet(bundle.keySet()).iterator();
        while (it.hasNext()) {
            Object obj = bundle.get((String) it.next());
            sb.append(obj == null ? "null" : obj instanceof Bundle ? zzr((Bundle) obj) : obj.toString());
        }
        return sb.toString();
    }

    @Override // com.google.android.gms.internal.ads.zzdqj
    public final boolean equals(Object obj) {
        if (obj instanceof zzdqm) {
            return Arrays.equals(this.zzhit, ((zzdqm) obj).zzhit);
        }
        return false;
    }

    @Override // com.google.android.gms.internal.ads.zzdqj
    public final int hashCode() {
        return Arrays.hashCode(this.zzhit);
    }

    public final String toString() {
        int iHashCode = hashCode();
        String string = Arrays.toString(this.zzhit);
        StringBuilder sb = new StringBuilder(String.valueOf(string).length() + 22);
        sb.append("[PoolKey#");
        sb.append(iHashCode);
        sb.append(" ");
        sb.append(string);
        sb.append("]");
        return sb.toString();
    }
}
