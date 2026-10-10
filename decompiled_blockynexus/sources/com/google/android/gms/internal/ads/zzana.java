package com.google.android.gms.internal.ads;

import com.google.android.ads.mediationtestsuite.dataobjects.AdUnit;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzana {
    private final long zzdkh;
    public final List<zzamx> zzdki;
    private final List<String> zzdkj;
    private final List<String> zzdkk;
    private final List<String> zzdkl;
    private final List<String> zzdkm;
    private final List<String> zzdkn;
    private final boolean zzdko;
    private final String zzdkp;
    private final long zzdkq;
    private final String zzdkr;
    private final int zzdks;
    private final int zzdkt;
    private final long zzdku;
    private final boolean zzdkv;
    private final boolean zzdkw;
    private final boolean zzdkx;
    private final boolean zzdky;
    private int zzdkz;
    private int zzdla;
    private boolean zzdlb;

    public zzana(JSONObject jSONObject) throws JSONException {
        if (zzbbq.isLoggable(2)) {
            String strValueOf = String.valueOf(jSONObject.toString(2));
            zzayp.zzei(strValueOf.length() != 0 ? "Mediation Response JSON: ".concat(strValueOf) : new String("Mediation Response JSON: "));
        }
        JSONArray jSONArray = jSONObject.getJSONArray("ad_networks");
        ArrayList arrayList = new ArrayList(jSONArray.length());
        int i = -1;
        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
            try {
                zzamx zzamxVar = new zzamx(jSONArray.getJSONObject(i2));
                boolean z = true;
                if ("banner".equalsIgnoreCase(zzamxVar.zzdkg)) {
                    this.zzdlb = true;
                }
                arrayList.add(zzamxVar);
                if (i < 0) {
                    Iterator<String> it = zzamxVar.zzdjn.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            if (it.next().equals(AdUnit.GOOGLE_ADAPTER_CLASS)) {
                                break;
                            }
                        } else {
                            z = false;
                            break;
                        }
                    }
                    if (z) {
                        i = i2;
                    }
                }
            } catch (JSONException unused) {
            }
        }
        this.zzdkz = i;
        this.zzdla = jSONArray.length();
        this.zzdki = Collections.unmodifiableList(arrayList);
        this.zzdkp = jSONObject.optString("qdata");
        this.zzdkt = jSONObject.optInt("fs_model_type", -1);
        this.zzdku = jSONObject.optLong("timeout_ms", -1L);
        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("settings");
        if (jSONObjectOptJSONObject == null) {
            this.zzdkh = -1L;
            this.zzdkj = null;
            this.zzdkk = null;
            this.zzdkl = null;
            this.zzdkm = null;
            this.zzdkn = null;
            this.zzdkq = -1L;
            this.zzdkr = null;
            this.zzdks = 0;
            this.zzdkv = false;
            this.zzdko = false;
            this.zzdkw = false;
            this.zzdkx = false;
            this.zzdky = false;
            return;
        }
        this.zzdkh = jSONObjectOptJSONObject.optLong("ad_network_timeout_millis", -1L);
        com.google.android.gms.ads.internal.zzp.zzlj();
        this.zzdkj = zzamz.zza(jSONObjectOptJSONObject, "click_urls");
        com.google.android.gms.ads.internal.zzp.zzlj();
        this.zzdkk = zzamz.zza(jSONObjectOptJSONObject, "imp_urls");
        com.google.android.gms.ads.internal.zzp.zzlj();
        this.zzdkl = zzamz.zza(jSONObjectOptJSONObject, "downloaded_imp_urls");
        com.google.android.gms.ads.internal.zzp.zzlj();
        this.zzdkm = zzamz.zza(jSONObjectOptJSONObject, "nofill_urls");
        com.google.android.gms.ads.internal.zzp.zzlj();
        this.zzdkn = zzamz.zza(jSONObjectOptJSONObject, "remote_ping_urls");
        this.zzdko = jSONObjectOptJSONObject.optBoolean("render_in_browser", false);
        long jOptLong = jSONObjectOptJSONObject.optLong("refresh", -1L);
        this.zzdkq = jOptLong > 0 ? 1000 * jOptLong : -1L;
        zzauv zzauvVarZza = zzauv.zza(jSONObjectOptJSONObject.optJSONArray("rewards"));
        if (zzauvVarZza == null) {
            this.zzdkr = null;
            this.zzdks = 0;
        } else {
            this.zzdkr = zzauvVarZza.type;
            this.zzdks = zzauvVarZza.zzdvs;
        }
        this.zzdkv = jSONObjectOptJSONObject.optBoolean("use_displayed_impression", false);
        this.zzdkw = jSONObjectOptJSONObject.optBoolean("allow_pub_rendered_attribution", false);
        this.zzdkx = jSONObjectOptJSONObject.optBoolean("allow_pub_owned_ad_view", false);
        this.zzdky = jSONObjectOptJSONObject.optBoolean("allow_custom_click_gesture", false);
    }
}
