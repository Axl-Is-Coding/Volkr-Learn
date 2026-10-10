package com.google.android.gms.internal.ads;

import com.google.android.ads.mediationtestsuite.dataobjects.AdUnit;
import java.util.List;
import org.json.JSONException;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzbty extends zzym {
    private final List<zzvr> zzadu;
    private final String zzful;
    private final String zzfum;

    public zzbty(zzdnv zzdnvVar, String str, zzctd zzctdVar) {
        this.zzfum = zzdnvVar == null ? null : zzdnvVar.zzfum;
        String strZzc = "com.google.android.gms.ads.mediation.customevent.CustomEventAdapter".equals(str) || AdUnit.CUSTOM_EVENT_ADAPTER_CLASS.equals(str) ? zzc(zzdnvVar) : null;
        this.zzful = strZzc == null ? str : strZzc;
        this.zzadu = zzctdVar.getAdapterResponses();
    }

    private static String zzc(zzdnv zzdnvVar) {
        try {
            return zzdnvVar.zzhdu.getString("class_name");
        } catch (JSONException unused) {
            return null;
        }
    }

    @Override // com.google.android.gms.internal.ads.zzyn
    public final List<zzvr> getAdapterResponses() {
        if (((Boolean) zzwm.zzpx().zzd(zzabb.zzcyp)).booleanValue()) {
            return this.zzadu;
        }
        return null;
    }

    @Override // com.google.android.gms.internal.ads.zzyn
    public final String getMediationAdapterClassName() {
        return this.zzful;
    }

    @Override // com.google.android.gms.internal.ads.zzyn
    public final String getResponseId() {
        return this.zzfum;
    }
}
