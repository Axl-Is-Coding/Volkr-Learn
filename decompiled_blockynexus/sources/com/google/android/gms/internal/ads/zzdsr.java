package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.common.util.Clock;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzdsr {
    private final Clock zzbqa;
    private final String zzbre;
    private final String zzcja;
    private final String zzdqu;
    private final zzeg zzfna;
    private final zzdoj zzfuj;
    private final zzcwj zzfwe;
    private final Context zzvr;

    public zzdsr(zzcwj zzcwjVar, zzbbx zzbbxVar, String str, String str2, Context context, zzdoj zzdojVar, Clock clock, zzeg zzegVar) {
        this.zzfwe = zzcwjVar;
        this.zzbre = zzbbxVar.zzbre;
        this.zzdqu = str;
        this.zzcja = str2;
        this.zzvr = context;
        this.zzfuj = zzdojVar;
        this.zzbqa = clock;
        this.zzfna = zzegVar;
    }

    private static String zzc(String str, String str2, String str3) {
        if (TextUtils.isEmpty(str3)) {
            str3 = "";
        }
        return str.replaceAll(str2, str3);
    }

    private static String zzgy(String str) {
        return (TextUtils.isEmpty(str) || !zzbbk.isEnabled()) ? str : "fakeForAdDebugLog";
    }

    public final List<String> zza(zzdog zzdogVar, zzdnv zzdnvVar, List<String> list) {
        return zza(zzdogVar, zzdnvVar, false, "", "", list);
    }

    public final List<String> zza(zzdog zzdogVar, zzdnv zzdnvVar, boolean z, String str, String str2, List<String> list) {
        ArrayList arrayList = new ArrayList();
        String str3 = z ? "1" : "0";
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String strZzc = zzc(zzc(zzc(it.next(), "@gw_adlocid@", zzdogVar.zzhev.zzfsk.zzhfb), "@gw_adnetrefresh@", str3), "@gw_sdkver@", this.zzbre);
            if (zzdnvVar != null) {
                strZzc = zzaxh.zzc(zzc(zzc(zzc(strZzc, "@gw_qdata@", zzdnvVar.zzdkp), "@gw_adnetid@", zzdnvVar.zzagx), "@gw_allocid@", zzdnvVar.zzdjo), this.zzvr, zzdnvVar.zzdtp);
            }
            String strZzc2 = zzc(zzc(zzc(strZzc, "@gw_adnetstatus@", this.zzfwe.zzaqm()), "@gw_seqnum@", this.zzdqu), "@gw_sessid@", this.zzcja);
            boolean z2 = ((Boolean) zzwm.zzpx().zzd(zzabb.zzcro)).booleanValue() && !TextUtils.isEmpty(str);
            boolean zIsEmpty = true ^ TextUtils.isEmpty(str2);
            if (z2 || zIsEmpty) {
                if (this.zzfna.zzb(Uri.parse(strZzc2))) {
                    Uri.Builder builderBuildUpon = Uri.parse(strZzc2).buildUpon();
                    if (z2) {
                        builderBuildUpon = builderBuildUpon.appendQueryParameter("ms", str);
                    }
                    if (zIsEmpty) {
                        builderBuildUpon = builderBuildUpon.appendQueryParameter("attok", str2);
                    }
                    strZzc2 = builderBuildUpon.build().toString();
                }
            }
            arrayList.add(strZzc2);
        }
        return arrayList;
    }

    public final List<String> zza(zzdnv zzdnvVar, List<String> list, zzatw zzatwVar) {
        ArrayList arrayList = new ArrayList();
        long jCurrentTimeMillis = this.zzbqa.currentTimeMillis();
        try {
            String type = zzatwVar.getType();
            String string = Integer.toString(zzatwVar.getAmount());
            zzdoj zzdojVar = this.zzfuj;
            String strZzgy = zzdojVar == null ? "" : zzgy(zzdojVar.zzdvz);
            zzdoj zzdojVar2 = this.zzfuj;
            String strZzgy2 = zzdojVar2 != null ? zzgy(zzdojVar2.zzdwa) : "";
            Iterator<String> it = list.iterator();
            while (it.hasNext()) {
                arrayList.add(zzaxh.zzc(zzc(zzc(zzc(zzc(zzc(zzc(it.next(), "@gw_rwd_userid@", Uri.encode(strZzgy)), "@gw_rwd_custom_data@", Uri.encode(strZzgy2)), "@gw_tmstmp@", Long.toString(jCurrentTimeMillis)), "@gw_rwd_itm@", Uri.encode(type)), "@gw_rwd_amt@", string), "@gw_sdkver@", this.zzbre), this.zzvr, zzdnvVar.zzdtp));
            }
            return arrayList;
        } catch (RemoteException e2) {
            zzbbq.zzc("Unable to determine award type and amount.", e2);
            return arrayList;
        }
    }
}
