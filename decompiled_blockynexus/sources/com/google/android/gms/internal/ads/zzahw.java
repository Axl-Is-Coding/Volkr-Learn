package com.google.android.gms.internal.ads;

import android.text.TextUtils;
import com.umeng.umcrash.UMCustomLogInfoBuilder;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: com.google.android.gms:play-services-ads@@19.4.0 */
/* JADX INFO: loaded from: classes2.dex */
public final class zzahw implements zzahq<Object> {
    private final Object lock = new Object();
    private final Map<String, zzahy> zzdfr = new HashMap();

    public final void zza(String str, zzahy zzahyVar) {
        synchronized (this.lock) {
            this.zzdfr.put(str, zzahyVar);
        }
    }

    @Override // com.google.android.gms.internal.ads.zzahq
    public final void zza(Object obj, Map<String, String> map) {
        String strConcat;
        String str = map.get("id");
        String str2 = map.get("fail");
        String str3 = map.get("fail_reason");
        String str4 = map.get("fail_stack");
        String str5 = map.get("result");
        if (TextUtils.isEmpty(str4)) {
            str3 = "Unknown Fail Reason.";
        }
        if (TextUtils.isEmpty(str4)) {
            strConcat = "";
        } else {
            String strValueOf = String.valueOf(str4);
            strConcat = strValueOf.length() != 0 ? UMCustomLogInfoBuilder.LINE_SEP.concat(strValueOf) : new String(UMCustomLogInfoBuilder.LINE_SEP);
        }
        synchronized (this.lock) {
            zzahy zzahyVarRemove = this.zzdfr.remove(str);
            if (zzahyVarRemove == null) {
                String strValueOf2 = String.valueOf(str);
                zzbbq.zzfe(strValueOf2.length() != 0 ? "Received result for unexpected method invocation: ".concat(strValueOf2) : new String("Received result for unexpected method invocation: "));
                return;
            }
            if (!TextUtils.isEmpty(str2)) {
                String strValueOf3 = String.valueOf(str3);
                String strValueOf4 = String.valueOf(strConcat);
                zzahyVarRemove.onFailure(strValueOf4.length() != 0 ? strValueOf3.concat(strValueOf4) : new String(strValueOf3));
            } else {
                if (str5 == null) {
                    zzahyVarRemove.zzc(null);
                    return;
                }
                try {
                    JSONObject jSONObject = new JSONObject(str5);
                    if (zzayp.zzxa()) {
                        String strValueOf5 = String.valueOf(jSONObject.toString(2));
                        zzayp.zzei(strValueOf5.length() != 0 ? "Result GMSG: ".concat(strValueOf5) : new String("Result GMSG: "));
                    }
                    zzahyVarRemove.zzc(jSONObject);
                } catch (JSONException e2) {
                    zzahyVarRemove.onFailure(e2.getMessage());
                }
            }
        }
    }

    public final <EngineT extends zzaks> zzdzc<JSONObject> zza(EngineT enginet, String str, JSONObject jSONObject) {
        zzbcg zzbcgVar = new zzbcg();
        com.google.android.gms.ads.internal.zzp.zzkr();
        String strZzxs = zzayu.zzxs();
        zza(strZzxs, new zzahv(this, zzbcgVar));
        try {
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("id", strZzxs);
            jSONObject2.put("args", jSONObject);
            enginet.zzb(str, jSONObject2);
        } catch (Exception e2) {
            zzbcgVar.setException(e2);
        }
        return zzbcgVar;
    }
}
