package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.facebook.internal.AnalyticsEvents;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzaxy {
    private String zzdro;
    private final long zzdyp;
    private final List<String> zzdyq = new ArrayList();
    private final List<String> zzdyr = new ArrayList();
    private final Map<String, zzana> zzdys = new HashMap();
    private String zzdyt;
    private JSONObject zzdyu;
    private boolean zzdyv;

    public zzaxy(String str, long j) {
        JSONObject jSONObjectOptJSONObject;
        this.zzdyv = false;
        this.zzdro = str;
        this.zzdyp = j;
        if (TextUtils.isEmpty(str)) {
            return;
        }
        try {
            this.zzdyu = new JSONObject(str);
            if (this.zzdyu.optInt(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_STATUS, -1) != 1) {
                this.zzdyv = false;
                zzbbq.zzfe("App settings could not be fetched successfully.");
                return;
            }
            this.zzdyv = true;
            this.zzdyt = this.zzdyu.optString("app_id");
            JSONArray jSONArrayOptJSONArray = this.zzdyu.optJSONArray("ad_unit_id_settings");
            if (jSONArrayOptJSONArray != null) {
                for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArrayOptJSONArray.getJSONObject(i);
                    String strOptString = jSONObject.optString("format");
                    String strOptString2 = jSONObject.optString("ad_unit_id");
                    if (!TextUtils.isEmpty(strOptString) && !TextUtils.isEmpty(strOptString2)) {
                        if ("interstitial".equalsIgnoreCase(strOptString)) {
                            this.zzdyr.add(strOptString2);
                        } else if ("rewarded".equalsIgnoreCase(strOptString) && (jSONObjectOptJSONObject = jSONObject.optJSONObject("mediation_config")) != null) {
                            this.zzdys.put(strOptString2, new zzana(jSONObjectOptJSONObject));
                        }
                    }
                }
            }
            JSONArray jSONArrayOptJSONArray2 = this.zzdyu.optJSONArray("persistable_banner_ad_unit_ids");
            if (jSONArrayOptJSONArray2 != null) {
                for (int i2 = 0; i2 < jSONArrayOptJSONArray2.length(); i2++) {
                    this.zzdyq.add(jSONArrayOptJSONArray2.optString(i2));
                }
            }
        } catch (JSONException e2) {
            zzbbq.zzd("Exception occurred while processing app setting json", e2);
            com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "AppSettings.parseAppSettingsJson");
        }
    }

    public final long zzwe() {
        return this.zzdyp;
    }

    public final boolean zzwf() {
        return this.zzdyv;
    }

    public final String zzwg() {
        return this.zzdro;
    }

    public final String zzwh() {
        return this.zzdyt;
    }

    public final Map<String, zzana> zzwi() {
        return this.zzdys;
    }

    public final JSONObject zzwj() {
        return this.zzdyu;
    }
}
