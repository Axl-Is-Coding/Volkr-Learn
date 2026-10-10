package com.google.android.gms.internal.ads;

import com.facebook.share.internal.ShareConstants;
import com.umeng.analytics.pro.au;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
final class zzcrm implements zzaly<zzcrj> {
    zzcrm() {
    }

    @Override // com.google.android.gms.internal.ads.zzaly
    public final /* synthetic */ JSONObject zzj(zzcrj zzcrjVar) throws JSONException {
        zzcrj zzcrjVar2 = zzcrjVar;
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        JSONObject jSONObject3 = new JSONObject();
        jSONObject2.put("base_url", zzcrjVar2.zzgll.zzvi());
        jSONObject2.put("signals", zzcrjVar2.zzglk);
        jSONObject3.put("body", zzcrjVar2.zzglj.zzdsl);
        jSONObject3.put("headers", com.google.android.gms.ads.internal.zzp.zzkr().zzj(zzcrjVar2.zzglj.zzam));
        jSONObject3.put("response_code", zzcrjVar2.zzglj.zzglt);
        jSONObject3.put(au.aI, zzcrjVar2.zzglj.zzglu);
        jSONObject.put(ShareConstants.WEB_DIALOG_RESULT_PARAM_REQUEST_ID, jSONObject2);
        jSONObject.put("response", jSONObject3);
        jSONObject.put("flags", zzcrjVar2.zzgll.zzvl());
        return jSONObject;
    }
}
