package com.bytedance.sdk.adnet.c;

import android.content.Context;
import android.text.TextUtils;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONObject;

/* JADX INFO: compiled from: TNCConfigHandler.java */
/* JADX INFO: loaded from: classes.dex */
public class e {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f5445d = new Object();

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f5446a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private d f5447b = new d();

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f5448c;

    public e(Context context, boolean z) {
        this.f5448c = true;
        this.f5446a = context;
        this.f5448c = z;
    }

    /* JADX WARN: Removed duplicated region for block: B:92:0x0161 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void a(org.json.JSONObject r11) {
        /*
            Method dump skipped, instruction units count: 386
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bytedance.sdk.adnet.c.e.a(org.json.JSONObject):void");
    }

    public void b() {
        try {
            String strA = com.bytedance.sdk.adnet.d.d.a(this.f5446a, 1);
            if (TextUtils.isEmpty(strA)) {
                com.bytedance.sdk.adnet.d.c.b("TNCConfigHandler", "loadLocalConfigForOtherProcess, data empty");
                return;
            }
            d dVarB = b(new JSONObject(strA));
            StringBuilder sb = new StringBuilder();
            sb.append("loadLocalConfigForOtherProcess, config: ");
            sb.append(dVarB == null ? "null" : dVarB.toString());
            com.bytedance.sdk.adnet.d.c.b("TNCConfigHandler", sb.toString());
            if (dVarB != null) {
                this.f5447b = dVarB;
            }
        } catch (Throwable th) {
            com.bytedance.sdk.adnet.d.c.b("TNCConfigHandler", "loadLocalConfigForOtherProcess, except: " + th.getMessage());
        }
    }

    public d c() {
        return this.f5447b;
    }

    private d b(JSONObject jSONObject) {
        try {
            d dVar = new d();
            if (jSONObject.has("local_enable")) {
                dVar.f5439a = jSONObject.getInt("local_enable") != 0;
            }
            if (jSONObject.has("probe_enable")) {
                dVar.f5440b = jSONObject.getInt("probe_enable") != 0;
            }
            if (jSONObject.has("local_host_filter")) {
                JSONArray jSONArray = jSONObject.getJSONArray("local_host_filter");
                HashMap map = new HashMap();
                if (jSONArray.length() > 0) {
                    for (int i = 0; i < jSONArray.length(); i++) {
                        String string = jSONArray.getString(i);
                        if (!TextUtils.isEmpty(string)) {
                            map.put(string, 0);
                        }
                    }
                }
                dVar.f5441c = map;
            } else {
                dVar.f5441c = null;
            }
            if (jSONObject.has("host_replace_map")) {
                JSONObject jSONObject2 = jSONObject.getJSONObject("host_replace_map");
                HashMap map2 = new HashMap();
                if (jSONObject2.length() > 0) {
                    Iterator<String> itKeys = jSONObject2.keys();
                    while (itKeys.hasNext()) {
                        String next = itKeys.next();
                        String string2 = jSONObject2.getString(next);
                        if (!TextUtils.isEmpty(next) && !TextUtils.isEmpty(string2)) {
                            map2.put(next, string2);
                        }
                    }
                }
                dVar.f5442d = map2;
            } else {
                dVar.f5442d = null;
            }
            dVar.f5443e = jSONObject.optInt("req_to_cnt", dVar.f5443e);
            dVar.f5444f = jSONObject.optInt("req_to_api_cnt", dVar.f5444f);
            dVar.g = jSONObject.optInt("req_to_ip_cnt", dVar.g);
            dVar.h = jSONObject.optInt("req_err_cnt", dVar.h);
            dVar.i = jSONObject.optInt("req_err_api_cnt", dVar.i);
            dVar.j = jSONObject.optInt("req_err_ip_cnt", dVar.j);
            dVar.k = jSONObject.optInt("update_interval", dVar.k);
            dVar.l = jSONObject.optInt("update_random_range", dVar.l);
            dVar.m = jSONObject.optString("http_code_black", dVar.m);
            return dVar;
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public void a() {
        if (this.f5448c) {
            String string = this.f5446a.getSharedPreferences("ttnet_tnc_config", 0).getString("tnc_config_str", null);
            if (TextUtils.isEmpty(string)) {
                com.bytedance.sdk.adnet.d.c.b("TNCConfigHandler", "loadLocalConfig: no existed");
                return;
            }
            try {
                d dVarB = b(new JSONObject(string));
                if (dVarB != null) {
                    this.f5447b = dVarB;
                }
                StringBuilder sb = new StringBuilder();
                sb.append("loadLocalConfig: ");
                sb.append(dVarB == null ? "null" : dVarB.toString());
                com.bytedance.sdk.adnet.d.c.b("TNCConfigHandler", sb.toString());
            } catch (Throwable th) {
                th.printStackTrace();
                com.bytedance.sdk.adnet.d.c.b("TNCConfigHandler", "loadLocalConfig: except: " + th.getMessage());
            }
        }
    }
}
