package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.AbstractAdViewAdapter;
import com.google.android.ads.mediationtestsuite.dataobjects.AdUnit;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public abstract class zzcwe<AdT> implements zzcta<AdT> {
    private static Bundle zzn(Bundle bundle) {
        return bundle == null ? new Bundle() : new Bundle(bundle);
    }

    protected abstract zzdzc<AdT> zza(zzdok zzdokVar, Bundle bundle);

    @Override // com.google.android.gms.internal.ads.zzcta
    public final boolean zza(zzdog zzdogVar, zzdnv zzdnvVar) {
        return !TextUtils.isEmpty(zzdnvVar.zzhdu.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, ""));
    }

    @Override // com.google.android.gms.internal.ads.zzcta
    public final zzdzc<AdT> zzb(zzdog zzdogVar, zzdnv zzdnvVar) {
        String strOptString = zzdnvVar.zzhdu.optString(AbstractAdViewAdapter.AD_UNIT_ID_PARAMETER, "");
        zzdok zzdokVar = zzdogVar.zzhev.zzfsk;
        zzdom zzdomVarZzgt = new zzdom().zzc(zzdokVar).zzgt(strOptString);
        Bundle bundleZzn = zzn(zzdokVar.zzhfa.zzchi);
        Bundle bundleZzn2 = zzn(bundleZzn.getBundle(AdUnit.GOOGLE_ADAPTER_CLASS));
        bundleZzn2.putInt("gw", 1);
        String strOptString2 = zzdnvVar.zzhdu.optString("mad_hac", null);
        if (strOptString2 != null) {
            bundleZzn2.putString("mad_hac", strOptString2);
        }
        String strOptString3 = zzdnvVar.zzhdu.optString("adJson", null);
        if (strOptString3 != null) {
            bundleZzn2.putString("_ad", strOptString3);
        }
        bundleZzn2.putBoolean("_noRefresh", true);
        Iterator<String> itKeys = zzdnvVar.zzhdx.keys();
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            String strOptString4 = zzdnvVar.zzhdx.optString(next, null);
            if (next != null) {
                bundleZzn2.putString(next, strOptString4);
            }
        }
        bundleZzn.putBundle(AdUnit.GOOGLE_ADAPTER_CLASS, bundleZzn2);
        zzvg zzvgVar = zzdokVar.zzhfa;
        zzdok zzdokVarZzatn = zzdomVarZzgt.zzh(new zzvg(zzvgVar.versionCode, zzvgVar.zzchb, bundleZzn2, zzvgVar.zzchc, zzvgVar.zzchd, zzvgVar.zzche, zzvgVar.zzadm, zzvgVar.zzbny, zzvgVar.zzchf, zzvgVar.zzchg, zzvgVar.zznb, zzvgVar.zzchh, bundleZzn, zzvgVar.zzchj, zzvgVar.zzchk, zzvgVar.zzchl, zzvgVar.zzchm, zzvgVar.zzchn, zzvgVar.zzcho, zzvgVar.zzadn, zzvgVar.zzado, zzvgVar.zzchp)).zzatn();
        Bundle bundle = new Bundle();
        zzdnw zzdnwVar = zzdogVar.zzhew.zzeou;
        Bundle bundle2 = new Bundle();
        bundle2.putStringArrayList("nofill_urls", new ArrayList<>(zzdnwVar.zzdkm));
        bundle2.putInt("refresh_interval", zzdnwVar.zzhel);
        bundle2.putString("gws_query_id", zzdnwVar.zzdtb);
        bundle.putBundle("parent_common_config", bundle2);
        String str = zzdogVar.zzhev.zzfsk.zzhfb;
        Bundle bundle3 = new Bundle();
        bundle3.putString("initial_ad_unit_id", str);
        bundle3.putString("allocation_id", zzdnvVar.zzdjo);
        bundle3.putStringArrayList("click_urls", new ArrayList<>(zzdnvVar.zzdkj));
        bundle3.putStringArrayList("imp_urls", new ArrayList<>(zzdnvVar.zzdkk));
        bundle3.putStringArrayList("manual_tracking_urls", new ArrayList<>(zzdnvVar.zzdsp));
        bundle3.putStringArrayList("fill_urls", new ArrayList<>(zzdnvVar.zzhdn));
        bundle3.putStringArrayList("video_start_urls", new ArrayList<>(zzdnvVar.zzdtd));
        bundle3.putStringArrayList("video_reward_urls", new ArrayList<>(zzdnvVar.zzdte));
        bundle3.putStringArrayList("video_complete_urls", new ArrayList<>(zzdnvVar.zzhdm));
        bundle3.putString(FirebaseAnalytics.Param.TRANSACTION_ID, zzdnvVar.zzdjz);
        bundle3.putString("valid_from_timestamp", zzdnvVar.zzdka);
        bundle3.putBoolean("is_closable_area_disabled", zzdnvVar.zzbpd);
        if (zzdnvVar.zzdtc != null) {
            Bundle bundle4 = new Bundle();
            bundle4.putInt("rb_amount", zzdnvVar.zzdtc.zzdvs);
            bundle4.putString("rb_type", zzdnvVar.zzdtc.type);
            bundle3.putParcelableArray("rewards", new Bundle[]{bundle4});
        }
        bundle.putBundle("parent_ad_config", bundle3);
        return zza(zzdokVarZzatn, bundle);
    }
}
