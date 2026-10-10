package com.google.android.gms.internal.ads;

import com.facebook.internal.ServerProtocol;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.umeng.analytics.pro.au;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzamx {
    private final String zzdjl;
    private final String zzdjm;
    public final List<String> zzdjn;
    private final String zzdjo;
    private final String zzdjp;
    private final List<String> zzdjq;
    private final List<String> zzdjr;
    private final List<String> zzdjs;
    private final List<String> zzdjt;
    private final List<String> zzdju;
    public final String zzdjv;
    private final List<String> zzdjw;
    private final List<String> zzdjx;
    private final List<String> zzdjy;
    private final String zzdjz;
    private final String zzdka;
    private final String zzdkb;
    private final String zzdkc;
    private final String zzdkd;
    private final List<String> zzdke;
    private final String zzdkf;
    public final String zzdkg;
    private final long zzdkh;

    public zzamx(JSONObject jSONObject) throws JSONException {
        List<String> listZza;
        this.zzdjm = jSONObject.optString("id");
        JSONArray jSONArray = jSONObject.getJSONArray("adapters");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        for (int i = 0; i < jSONArray.length(); i++) {
            arrayList.add(jSONArray.getString(i));
        }
        this.zzdjn = Collections.unmodifiableList(arrayList);
        this.zzdjo = jSONObject.optString("allocation_id", null);
        com.google.android.gms.ads.internal.zzp.zzlj();
        this.zzdjq = zzamz.zza(jSONObject, "clickurl");
        com.google.android.gms.ads.internal.zzp.zzlj();
        this.zzdjr = zzamz.zza(jSONObject, "imp_urls");
        com.google.android.gms.ads.internal.zzp.zzlj();
        this.zzdjs = zzamz.zza(jSONObject, "downloaded_imp_urls");
        com.google.android.gms.ads.internal.zzp.zzlj();
        this.zzdju = zzamz.zza(jSONObject, "fill_urls");
        com.google.android.gms.ads.internal.zzp.zzlj();
        this.zzdjw = zzamz.zza(jSONObject, "video_start_urls");
        com.google.android.gms.ads.internal.zzp.zzlj();
        this.zzdjy = zzamz.zza(jSONObject, "video_complete_urls");
        com.google.android.gms.ads.internal.zzp.zzlj();
        this.zzdjx = zzamz.zza(jSONObject, "video_reward_urls");
        this.zzdjz = jSONObject.optString(FirebaseAnalytics.Param.TRANSACTION_ID);
        this.zzdka = jSONObject.optString("valid_from_timestamp");
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject(au.av);
        if (jSONObjectOptJSONObject != null) {
            com.google.android.gms.ads.internal.zzp.zzlj();
            listZza = zzamz.zza(jSONObjectOptJSONObject, "manual_impression_urls");
        } else {
            listZza = null;
        }
        this.zzdjt = listZza;
        this.zzdjl = jSONObjectOptJSONObject != null ? jSONObjectOptJSONObject.toString() : null;
        JSONObject jSONObjectOptJSONObject2 = jSONObject.optJSONObject("data");
        this.zzdjv = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.toString() : null;
        this.zzdjp = jSONObjectOptJSONObject2 != null ? jSONObjectOptJSONObject2.optString("class_name") : null;
        this.zzdkb = jSONObject.optString("html_template", null);
        this.zzdkc = jSONObject.optString("ad_base_url", null);
        JSONObject jSONObjectOptJSONObject3 = jSONObject.optJSONObject("assets");
        this.zzdkd = jSONObjectOptJSONObject3 != null ? jSONObjectOptJSONObject3.toString() : null;
        com.google.android.gms.ads.internal.zzp.zzlj();
        this.zzdke = zzamz.zza(jSONObject, "template_ids");
        JSONObject jSONObjectOptJSONObject4 = jSONObject.optJSONObject("ad_loader_options");
        this.zzdkf = jSONObjectOptJSONObject4 != null ? jSONObjectOptJSONObject4.toString() : null;
        this.zzdkg = jSONObject.optString(ServerProtocol.DIALOG_PARAM_RESPONSE_TYPE, null);
        this.zzdkh = jSONObject.optLong("ad_network_timeout_millis", -1L);
    }
}
