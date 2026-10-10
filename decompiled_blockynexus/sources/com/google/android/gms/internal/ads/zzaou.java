package com.google.android.gms.internal.ads;

import com.google.ads.AdRequest$ErrorCode;
import com.google.ads.AdRequest$Gender;
import com.google.ads.mediation.a;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads-lite@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaou {
    public static int zza(AdRequest$ErrorCode adRequest$ErrorCode) {
        int i = zzaot.zzdme[adRequest$ErrorCode.ordinal()];
        if (i == 2) {
            return 1;
        }
        if (i != 3) {
            return i != 4 ? 0 : 3;
        }
        return 2;
    }

    public static a zza(zzvg zzvgVar, boolean z) {
        List<String> list = zzvgVar.zzchd;
        HashSet hashSet = list != null ? new HashSet(list) : null;
        Date date = new Date(zzvgVar.zzchb);
        int i = zzvgVar.zzchc;
        return new a(date, i != 1 ? i != 2 ? AdRequest$Gender.UNKNOWN : AdRequest$Gender.FEMALE : AdRequest$Gender.MALE, hashSet, z, zzvgVar.zznb);
    }
}
