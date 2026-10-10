package com.google.android.gms.internal.ads;

import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzckz {
    public static String zza(JSONObject jSONObject, String str, String str2) {
        JSONArray jSONArrayOptJSONArray;
        if (!((Boolean) zzwm.zzpx().zzd(zzabb.zzcqe)).booleanValue() || jSONObject == null || (jSONArrayOptJSONArray = jSONObject.optJSONArray(str2)) == null) {
            return "";
        }
        for (int i = 0; i < jSONArrayOptJSONArray.length(); i++) {
            JSONObject jSONObjectOptJSONObject = jSONArrayOptJSONArray.optJSONObject(i);
            if (jSONObjectOptJSONObject != null) {
                JSONArray jSONArrayOptJSONArray2 = jSONObjectOptJSONObject.optJSONArray("including");
                JSONArray jSONArrayOptJSONArray3 = jSONObjectOptJSONObject.optJSONArray("excluding");
                if (zza(jSONArrayOptJSONArray2, str) && !zza(jSONArrayOptJSONArray3, str)) {
                    return jSONObjectOptJSONObject.optString("effective_ad_unit_id", "");
                }
            }
        }
        return "";
    }

    private static boolean zza(JSONArray jSONArray, String str) {
        if (jSONArray != null && str != null) {
            for (int i = 0; i < jSONArray.length(); i++) {
                try {
                } catch (PatternSyntaxException e2) {
                    com.google.android.gms.ads.internal.zzp.zzkv().zza(e2, "RtbAdapterMap.hasAtleastOneRegexMatch");
                }
                if (Pattern.compile(jSONArray.optString(i)).matcher(str).lookingAt()) {
                    return true;
                }
            }
        }
        return false;
    }
}
