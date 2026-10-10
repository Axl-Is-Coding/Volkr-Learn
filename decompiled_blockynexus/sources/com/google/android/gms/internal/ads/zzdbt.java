package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.sandboxol.center.utils.TimeUtil;
import com.umeng.analytics.pro.b;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdbt implements zzdgu<Bundle> {
    private final zzdok zzfsk;

    public zzdbt(zzdok zzdokVar) {
        Preconditions.checkNotNull(zzdokVar, "the targeting must not be null");
        this.zzfsk = zzdokVar;
    }

    @Override // com.google.android.gms.internal.ads.zzdgu
    public final /* synthetic */ void zzs(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzdok zzdokVar = this.zzfsk;
        zzvg zzvgVar = zzdokVar.zzhfa;
        bundle2.putString("slotname", zzdokVar.zzhfb);
        int i = zzdbs.zzgfd[this.zzfsk.zzhfh.zzheo - 1];
        if (i == 1) {
            bundle2.putBoolean("is_new_rewarded", true);
        } else if (i == 2) {
            bundle2.putBoolean("is_rewarded_interstitial", true);
        }
        zzdot.zza(bundle2, "cust_age", new SimpleDateFormat(TimeUtil.DEFAULT_DAY_NO_SEPRATOR_FORMAT, Locale.US).format(new Date(zzvgVar.zzchb)), zzvgVar.zzchb != -1);
        zzdot.zza(bundle2, "extras", zzvgVar.extras);
        zzdot.zza(bundle2, "cust_gender", Integer.valueOf(zzvgVar.zzchc), zzvgVar.zzchc != -1);
        zzdot.zza(bundle2, "kw", zzvgVar.zzchd);
        zzdot.zza(bundle2, "tag_for_child_directed_treatment", Integer.valueOf(zzvgVar.zzadm), zzvgVar.zzadm != -1);
        boolean z = zzvgVar.zzche;
        if (z) {
            bundle2.putBoolean("test_request", z);
        }
        zzdot.zza(bundle2, "d_imp_hdr", (Integer) 1, zzvgVar.versionCode >= 2 && zzvgVar.zzbny);
        String str = zzvgVar.zzchf;
        zzdot.zza(bundle2, "ppid", str, zzvgVar.versionCode >= 2 && !TextUtils.isEmpty(str));
        Location location = zzvgVar.zznb;
        if (location != null) {
            Float fValueOf = Float.valueOf(location.getAccuracy() * 1000.0f);
            Long lValueOf = Long.valueOf(location.getTime() * 1000);
            Long lValueOf2 = Long.valueOf((long) (location.getLatitude() * 1.0E7d));
            Long lValueOf3 = Long.valueOf((long) (location.getLongitude() * 1.0E7d));
            Bundle bundle3 = new Bundle();
            bundle3.putFloat("radius", fValueOf.floatValue());
            bundle3.putLong(b.B, lValueOf2.longValue());
            bundle3.putLong("long", lValueOf3.longValue());
            bundle3.putLong("time", lValueOf.longValue());
            bundle2.putBundle("uule", bundle3);
        }
        zzdot.zza(bundle2, "url", zzvgVar.zzchh);
        zzdot.zza(bundle2, "neighboring_content_urls", zzvgVar.zzchp);
        zzdot.zza(bundle2, "custom_targeting", zzvgVar.zzchj);
        zzdot.zza(bundle2, "category_exclusions", zzvgVar.zzchk);
        zzdot.zza(bundle2, "request_agent", zzvgVar.zzchl);
        zzdot.zza(bundle2, "request_pkg", zzvgVar.zzchm);
        zzdot.zza(bundle2, "is_designed_for_families", Boolean.valueOf(zzvgVar.zzchn), zzvgVar.versionCode >= 7);
        if (zzvgVar.versionCode >= 8) {
            zzdot.zza(bundle2, "tag_for_under_age_of_consent", Integer.valueOf(zzvgVar.zzadn), zzvgVar.zzadn != -1);
            zzdot.zza(bundle2, "max_ad_content_rating", zzvgVar.zzado);
        }
    }
}
