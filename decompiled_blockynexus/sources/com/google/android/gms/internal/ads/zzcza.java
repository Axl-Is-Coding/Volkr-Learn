package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzcza {
    private final Executor executor;
    private JSONObject zzggc;
    private final Map<String, zzczd> zzgse = new ConcurrentHashMap();
    private final Map<String, Map<String, List<zzczd>>> zzgsf = new ConcurrentHashMap();

    public zzcza(Executor executor) {
        this.executor = executor;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: renamed from: zzaqo, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final synchronized void zzaqr() {
        JSONArray jSONArrayOptJSONArray;
        JSONObject jSONObjectZzwj = com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzxk().zzwj();
        if (jSONObjectZzwj != null) {
            try {
                JSONArray jSONArrayOptJSONArray2 = jSONObjectZzwj.optJSONArray("ad_unit_id_settings");
                this.zzggc = jSONObjectZzwj.optJSONObject("ad_unit_patterns");
                if (jSONArrayOptJSONArray2 != null) {
                    for (int i = 0; i < jSONArrayOptJSONArray2.length(); i++) {
                        JSONObject jSONObject = jSONArrayOptJSONArray2.getJSONObject(i);
                        String strOptString = jSONObject.optString("ad_unit_id", "");
                        String strOptString2 = jSONObject.optString("format", "");
                        ArrayList arrayList = new ArrayList();
                        JSONObject jSONObjectOptJSONObject = jSONObject.optJSONObject("mediation_config");
                        if (jSONObjectOptJSONObject != null && (jSONArrayOptJSONArray = jSONObjectOptJSONObject.optJSONArray("ad_networks")) != null) {
                            for (int i2 = 0; i2 < jSONArrayOptJSONArray.length(); i2++) {
                                JSONObject jSONObject2 = jSONArrayOptJSONArray.getJSONObject(i2);
                                ArrayList arrayList2 = new ArrayList();
                                if (jSONObject2 != null) {
                                    JSONObject jSONObjectOptJSONObject2 = jSONObject2.optJSONObject("data");
                                    Bundle bundle = new Bundle();
                                    if (jSONObjectOptJSONObject2 != null) {
                                        Iterator<String> itKeys = jSONObjectOptJSONObject2.keys();
                                        while (itKeys.hasNext()) {
                                            String next = itKeys.next();
                                            bundle.putString(next, jSONObjectOptJSONObject2.optString(next, ""));
                                        }
                                    }
                                    JSONArray jSONArrayOptJSONArray3 = jSONObject2.optJSONArray("rtb_adapters");
                                    if (jSONArrayOptJSONArray3 != null) {
                                        ArrayList arrayList3 = new ArrayList();
                                        for (int i3 = 0; i3 < jSONArrayOptJSONArray3.length(); i3++) {
                                            String strOptString3 = jSONArrayOptJSONArray3.optString(i3, "");
                                            if (!TextUtils.isEmpty(strOptString3)) {
                                                arrayList3.add(strOptString3);
                                            }
                                        }
                                        int size = arrayList3.size();
                                        int i4 = 0;
                                        while (i4 < size) {
                                            Object obj = arrayList3.get(i4);
                                            i4++;
                                            String str = (String) obj;
                                            zzgq(str);
                                            if (this.zzgse.get(str) != null) {
                                                arrayList2.add(new zzczd(str, strOptString2, bundle));
                                            }
                                        }
                                    }
                                }
                                arrayList.addAll(arrayList2);
                            }
                        }
                        if (!TextUtils.isEmpty(strOptString2) && !TextUtils.isEmpty(strOptString)) {
                            Map<String, List<zzczd>> concurrentHashMap = this.zzgsf.get(strOptString2);
                            if (concurrentHashMap == null) {
                                concurrentHashMap = new ConcurrentHashMap<>();
                            }
                            this.zzgsf.put(strOptString2, concurrentHashMap);
                            List<zzczd> arrayList4 = concurrentHashMap.get(strOptString);
                            if (arrayList4 == null) {
                                arrayList4 = new ArrayList<>();
                            }
                            arrayList4.addAll(arrayList);
                            concurrentHashMap.put(strOptString, arrayList4);
                        }
                    }
                }
            } catch (JSONException e2) {
                zzayp.zza("Malformed config loading JSON.", e2);
            }
        }
    }

    public final void zzaoh() {
        com.google.android.gms.ads.internal.zzp.zzkv().zzwt().zzb(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzcyz
            private final zzcza zzgsd;

            {
                this.zzgsd = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgsd.zzaqq();
            }
        });
        this.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzczc
            private final zzcza zzgsd;

            {
                this.zzgsd = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgsd.zzaqp();
            }
        });
    }

    final /* synthetic */ void zzaqq() {
        this.executor.execute(new Runnable(this) { // from class: com.google.android.gms.internal.ads.zzczb
            private final zzcza zzgsd;

            {
                this.zzgsd = this;
            }

            @Override // java.lang.Runnable
            public final void run() {
                this.zzgsd.zzaqr();
            }
        });
    }

    public final void zzgq(String str) {
        if (TextUtils.isEmpty(str) || this.zzgse.containsKey(str)) {
            return;
        }
        this.zzgse.put(str, new zzczd(str, "", new Bundle()));
    }

    public final Map<String, List<Bundle>> zzt(String str, String str2) {
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            return Collections.emptyMap();
        }
        Map<String, List<zzczd>> map = this.zzgsf.get(str);
        if (map == null) {
            return Collections.emptyMap();
        }
        List<zzczd> list = map.get(str2);
        if (list == null) {
            list = map.get(zzckz.zza(this.zzggc, str2, str));
        }
        if (list == null) {
            return Collections.emptyMap();
        }
        HashMap map2 = new HashMap();
        for (zzczd zzczdVar : list) {
            String str3 = zzczdVar.zzcib;
            if (!map2.containsKey(str3)) {
                map2.put(str3, new ArrayList());
            }
            ((List) map2.get(str3)).add(zzczdVar.zzerb);
        }
        return map2;
    }
}
